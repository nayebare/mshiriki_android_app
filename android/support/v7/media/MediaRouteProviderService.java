package android.support.v7.media;

import android.app.Service;
import android.content.Intent;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.IBinder;
import android.os.IBinder.DeathRecipient;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.support.v7.media.MediaRouteProvider.Callback;
import android.support.v7.media.MediaRouteProvider.RouteController;
import android.support.v7.media.MediaRouteSelector.Builder;
import android.support.v7.media.MediaRouter.ControlRequestCallback;
import android.util.Log;
import android.util.SparseArray;
import com.google.android.gms.games.request.Requests;
import com.google.android.gms.wallet.fragment.WalletFragmentStyle.BuyButtonText;
import com.google.android.gms.wallet.fragment.WalletFragmentStyle.Dimension;
import com.google.android.gms.wearable.ChannelApi.ChannelListener;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import org.apache.http.protocol.HTTP;

public abstract class MediaRouteProviderService extends Service {
    private static final boolean DEBUG;
    private static final int PRIVATE_MSG_CLIENT_DIED = 1;
    public static final String SERVICE_INTERFACE = "android.media.MediaRouteProviderService";
    private static final String TAG = "MediaRouteProviderSrv";
    private final ArrayList<ClientRecord> mClients;
    private MediaRouteDiscoveryRequest mCompositeDiscoveryRequest;
    private final PrivateHandler mPrivateHandler;
    private MediaRouteProvider mProvider;
    private final ProviderCallback mProviderCallback;
    private final ReceiveHandler mReceiveHandler;
    private final Messenger mReceiveMessenger;

    /* renamed from: android.support.v7.media.MediaRouteProviderService.1 */
    class C02931 extends ControlRequestCallback {
        final /* synthetic */ ClientRecord val$client;
        final /* synthetic */ int val$controllerId;
        final /* synthetic */ Intent val$intent;
        final /* synthetic */ Messenger val$messenger;
        final /* synthetic */ int val$requestId;

        C02931(ClientRecord clientRecord, int i, Intent intent, Messenger messenger, int i2) {
            this.val$client = clientRecord;
            this.val$controllerId = i;
            this.val$intent = intent;
            this.val$messenger = messenger;
            this.val$requestId = i2;
        }

        public void onResult(Bundle data) {
            if (MediaRouteProviderService.DEBUG) {
                Log.d(MediaRouteProviderService.TAG, this.val$client + ": Route control request succeeded" + ", controllerId=" + this.val$controllerId + ", intent=" + this.val$intent + ", data=" + data);
            }
            if (MediaRouteProviderService.this.findClient(this.val$messenger) >= 0) {
                MediaRouteProviderService.sendReply(this.val$messenger, 3, this.val$requestId, 0, data, null);
            }
        }

        public void onError(String error, Bundle data) {
            if (MediaRouteProviderService.DEBUG) {
                Log.d(MediaRouteProviderService.TAG, this.val$client + ": Route control request failed" + ", controllerId=" + this.val$controllerId + ", intent=" + this.val$intent + ", error=" + error + ", data=" + data);
            }
            if (MediaRouteProviderService.this.findClient(this.val$messenger) < 0) {
                return;
            }
            if (error != null) {
                Bundle bundle = new Bundle();
                bundle.putString(MediaRouteProviderProtocol.SERVICE_DATA_ERROR, error);
                MediaRouteProviderService.sendReply(this.val$messenger, 4, this.val$requestId, 0, data, bundle);
                return;
            }
            MediaRouteProviderService.sendReply(this.val$messenger, 4, this.val$requestId, 0, data, null);
        }
    }

    private final class ClientRecord implements DeathRecipient {
        private final SparseArray<RouteController> mControllers;
        public MediaRouteDiscoveryRequest mDiscoveryRequest;
        public final Messenger mMessenger;
        public final int mVersion;

        public ClientRecord(Messenger messenger, int version) {
            this.mControllers = new SparseArray();
            this.mMessenger = messenger;
            this.mVersion = version;
        }

        public boolean register() {
            try {
                this.mMessenger.getBinder().linkToDeath(this, 0);
                return true;
            } catch (RemoteException e) {
                binderDied();
                return MediaRouteProviderService.DEBUG;
            }
        }

        public void dispose() {
            int count = this.mControllers.size();
            for (int i = 0; i < count; i += MediaRouteProviderService.PRIVATE_MSG_CLIENT_DIED) {
                ((RouteController) this.mControllers.valueAt(i)).onRelease();
            }
            this.mControllers.clear();
            this.mMessenger.getBinder().unlinkToDeath(this, 0);
            setDiscoveryRequest(null);
        }

        public boolean hasMessenger(Messenger other) {
            return this.mMessenger.getBinder() == other.getBinder() ? true : MediaRouteProviderService.DEBUG;
        }

        public boolean createRouteController(String routeId, int controllerId) {
            if (this.mControllers.indexOfKey(controllerId) < 0) {
                RouteController controller = MediaRouteProviderService.this.mProvider.onCreateRouteController(routeId);
                if (controller != null) {
                    this.mControllers.put(controllerId, controller);
                    return true;
                }
            }
            return MediaRouteProviderService.DEBUG;
        }

        public boolean releaseRouteController(int controllerId) {
            RouteController controller = (RouteController) this.mControllers.get(controllerId);
            if (controller == null) {
                return MediaRouteProviderService.DEBUG;
            }
            this.mControllers.remove(controllerId);
            controller.onRelease();
            return true;
        }

        public RouteController getRouteController(int controllerId) {
            return (RouteController) this.mControllers.get(controllerId);
        }

        public boolean setDiscoveryRequest(MediaRouteDiscoveryRequest request) {
            if (this.mDiscoveryRequest == request || (this.mDiscoveryRequest != null && this.mDiscoveryRequest.equals(request))) {
                return MediaRouteProviderService.DEBUG;
            }
            this.mDiscoveryRequest = request;
            return MediaRouteProviderService.this.updateCompositeDiscoveryRequest();
        }

        public void binderDied() {
            MediaRouteProviderService.this.mPrivateHandler.obtainMessage(MediaRouteProviderService.PRIVATE_MSG_CLIENT_DIED, this.mMessenger).sendToTarget();
        }

        public String toString() {
            return MediaRouteProviderService.getClientId(this.mMessenger);
        }
    }

    private final class PrivateHandler extends Handler {
        private PrivateHandler() {
        }

        public void handleMessage(Message msg) {
            switch (msg.what) {
                case MediaRouteProviderService.PRIVATE_MSG_CLIENT_DIED /*1*/:
                    MediaRouteProviderService.this.onBinderDied((Messenger) msg.obj);
                default:
            }
        }
    }

    private final class ProviderCallback extends Callback {
        private ProviderCallback() {
        }

        public void onDescriptorChanged(MediaRouteProvider provider, MediaRouteProviderDescriptor descriptor) {
            MediaRouteProviderService.this.sendDescriptorChanged(descriptor);
        }
    }

    private static final class ReceiveHandler extends Handler {
        private final WeakReference<MediaRouteProviderService> mServiceRef;

        public ReceiveHandler(MediaRouteProviderService service) {
            this.mServiceRef = new WeakReference(service);
        }

        public void handleMessage(Message msg) {
            Messenger messenger = msg.replyTo;
            if (MediaRouteProviderProtocol.isValidRemoteMessenger(messenger)) {
                int what = msg.what;
                int requestId = msg.arg1;
                int arg = msg.arg2;
                Object obj = msg.obj;
                Bundle data = msg.peekData();
                if (!processMessage(what, messenger, requestId, arg, obj, data)) {
                    if (MediaRouteProviderService.DEBUG) {
                        Log.d(MediaRouteProviderService.TAG, MediaRouteProviderService.getClientId(messenger) + ": Message failed, what=" + what + ", requestId=" + requestId + ", arg=" + arg + ", obj=" + obj + ", data=" + data);
                    }
                    MediaRouteProviderService.sendGenericFailure(messenger, requestId);
                }
            } else if (MediaRouteProviderService.DEBUG) {
                Log.d(MediaRouteProviderService.TAG, "Ignoring message without valid reply messenger.");
            }
        }

        private boolean processMessage(int what, Messenger messenger, int requestId, int arg, Object obj, Bundle data) {
            int reason = 0;
            MediaRouteProviderService service = (MediaRouteProviderService) this.mServiceRef.get();
            if (service == null) {
                return MediaRouteProviderService.DEBUG;
            }
            switch (what) {
                case MediaRouteProviderService.PRIVATE_MSG_CLIENT_DIED /*1*/:
                    return service.onRegisterClient(messenger, requestId, arg);
                case ChannelListener.CLOSE_REASON_REMOTE_CLOSE /*2*/:
                    return service.onUnregisterClient(messenger, requestId);
                case ChannelListener.CLOSE_REASON_LOCAL_CLOSE /*3*/:
                    String routeId = data.getString(MediaRouteProviderProtocol.CLIENT_DATA_ROUTE_ID);
                    if (routeId != null) {
                        return service.onCreateRouteController(messenger, requestId, arg, routeId);
                    }
                    return MediaRouteProviderService.DEBUG;
                case Dimension.UNIT_IN /*4*/:
                    return service.onReleaseRouteController(messenger, requestId, arg);
                case Dimension.UNIT_MM /*5*/:
                    return service.onSelectRoute(messenger, requestId, arg);
                case BuyButtonText.LOGO_ONLY /*6*/:
                    if (data != null) {
                        reason = data.getInt(MediaRouteProviderProtocol.CLIENT_DATA_UNSELECT_REASON, 0);
                    }
                    return service.onUnselectRoute(messenger, requestId, arg, reason);
                case BuyButtonText.DONATE_WITH /*7*/:
                    int volume = data.getInt(MediaRouteProviderProtocol.CLIENT_DATA_VOLUME, -1);
                    if (volume >= 0) {
                        return service.onSetRouteVolume(messenger, requestId, arg, volume);
                    }
                    return MediaRouteProviderService.DEBUG;
                case Requests.MAX_REQUEST_RECIPIENTS /*8*/:
                    int delta = data.getInt(MediaRouteProviderProtocol.CLIENT_DATA_VOLUME, 0);
                    if (delta != 0) {
                        return service.onUpdateRouteVolume(messenger, requestId, arg, delta);
                    }
                    return MediaRouteProviderService.DEBUG;
                case HTTP.HT /*9*/:
                    if (obj instanceof Intent) {
                        return service.onRouteControlRequest(messenger, requestId, arg, (Intent) obj);
                    }
                    return MediaRouteProviderService.DEBUG;
                case HTTP.LF /*10*/:
                    if (obj != null && !(obj instanceof Bundle)) {
                        return MediaRouteProviderService.DEBUG;
                    }
                    MediaRouteDiscoveryRequest request = MediaRouteDiscoveryRequest.fromBundle((Bundle) obj);
                    if (request == null || !request.isValid()) {
                        request = null;
                    }
                    return service.onSetDiscoveryRequest(messenger, requestId, request);
                default:
                    return MediaRouteProviderService.DEBUG;
            }
        }
    }

    public abstract MediaRouteProvider onCreateMediaRouteProvider();

    static {
        DEBUG = Log.isLoggable(TAG, 3);
    }

    public MediaRouteProviderService() {
        this.mClients = new ArrayList();
        this.mReceiveHandler = new ReceiveHandler(this);
        this.mReceiveMessenger = new Messenger(this.mReceiveHandler);
        this.mPrivateHandler = new PrivateHandler();
        this.mProviderCallback = new ProviderCallback();
    }

    public MediaRouteProvider getMediaRouteProvider() {
        return this.mProvider;
    }

    public IBinder onBind(Intent intent) {
        if (intent.getAction().equals(SERVICE_INTERFACE)) {
            if (this.mProvider == null) {
                MediaRouteProvider provider = onCreateMediaRouteProvider();
                if (provider != null) {
                    String providerPackage = provider.getMetadata().getPackageName();
                    if (providerPackage.equals(getPackageName())) {
                        this.mProvider = provider;
                        this.mProvider.setCallback(this.mProviderCallback);
                    } else {
                        throw new IllegalStateException("onCreateMediaRouteProvider() returned a provider whose package name does not match the package name of the service.  A media route provider service can only export its own media route providers.  Provider package name: " + providerPackage + ".  Service package name: " + getPackageName() + ".");
                    }
                }
            }
            if (this.mProvider != null) {
                return this.mReceiveMessenger.getBinder();
            }
        }
        return null;
    }

    public boolean onUnbind(Intent intent) {
        if (this.mProvider != null) {
            this.mProvider.setCallback(null);
        }
        return super.onUnbind(intent);
    }

    private boolean onRegisterClient(Messenger messenger, int requestId, int version) {
        if (version >= PRIVATE_MSG_CLIENT_DIED && findClient(messenger) < 0) {
            ClientRecord client = new ClientRecord(messenger, version);
            if (client.register()) {
                this.mClients.add(client);
                if (DEBUG) {
                    Log.d(TAG, client + ": Registered, version=" + version);
                }
                if (requestId == 0) {
                    return true;
                }
                Object asBundle;
                MediaRouteProviderDescriptor descriptor = this.mProvider.getDescriptor();
                if (descriptor != null) {
                    asBundle = descriptor.asBundle();
                } else {
                    asBundle = null;
                }
                sendReply(messenger, 2, requestId, PRIVATE_MSG_CLIENT_DIED, asBundle, null);
                return true;
            }
        }
        return DEBUG;
    }

    private boolean onUnregisterClient(Messenger messenger, int requestId) {
        int index = findClient(messenger);
        if (index < 0) {
            return DEBUG;
        }
        ClientRecord client = (ClientRecord) this.mClients.remove(index);
        if (DEBUG) {
            Log.d(TAG, client + ": Unregistered");
        }
        client.dispose();
        sendGenericSuccess(messenger, requestId);
        return true;
    }

    private void onBinderDied(Messenger messenger) {
        int index = findClient(messenger);
        if (index >= 0) {
            ClientRecord client = (ClientRecord) this.mClients.remove(index);
            if (DEBUG) {
                Log.d(TAG, client + ": Binder died");
            }
            client.dispose();
        }
    }

    private boolean onCreateRouteController(Messenger messenger, int requestId, int controllerId, String routeId) {
        ClientRecord client = getClient(messenger);
        if (client == null || !client.createRouteController(routeId, controllerId)) {
            return DEBUG;
        }
        if (DEBUG) {
            Log.d(TAG, client + ": Route controller created" + ", controllerId=" + controllerId + ", routeId=" + routeId);
        }
        sendGenericSuccess(messenger, requestId);
        return true;
    }

    private boolean onReleaseRouteController(Messenger messenger, int requestId, int controllerId) {
        ClientRecord client = getClient(messenger);
        if (client == null || !client.releaseRouteController(controllerId)) {
            return DEBUG;
        }
        if (DEBUG) {
            Log.d(TAG, client + ": Route controller released" + ", controllerId=" + controllerId);
        }
        sendGenericSuccess(messenger, requestId);
        return true;
    }

    private boolean onSelectRoute(Messenger messenger, int requestId, int controllerId) {
        ClientRecord client = getClient(messenger);
        if (client != null) {
            RouteController controller = client.getRouteController(controllerId);
            if (controller != null) {
                controller.onSelect();
                if (DEBUG) {
                    Log.d(TAG, client + ": Route selected" + ", controllerId=" + controllerId);
                }
                sendGenericSuccess(messenger, requestId);
                return true;
            }
        }
        return DEBUG;
    }

    private boolean onUnselectRoute(Messenger messenger, int requestId, int controllerId, int reason) {
        ClientRecord client = getClient(messenger);
        if (client != null) {
            RouteController controller = client.getRouteController(controllerId);
            if (controller != null) {
                controller.onUnselect(reason);
                if (DEBUG) {
                    Log.d(TAG, client + ": Route unselected" + ", controllerId=" + controllerId);
                }
                sendGenericSuccess(messenger, requestId);
                return true;
            }
        }
        return DEBUG;
    }

    private boolean onSetRouteVolume(Messenger messenger, int requestId, int controllerId, int volume) {
        ClientRecord client = getClient(messenger);
        if (client != null) {
            RouteController controller = client.getRouteController(controllerId);
            if (controller != null) {
                controller.onSetVolume(volume);
                if (DEBUG) {
                    Log.d(TAG, client + ": Route volume changed" + ", controllerId=" + controllerId + ", volume=" + volume);
                }
                sendGenericSuccess(messenger, requestId);
                return true;
            }
        }
        return DEBUG;
    }

    private boolean onUpdateRouteVolume(Messenger messenger, int requestId, int controllerId, int delta) {
        ClientRecord client = getClient(messenger);
        if (client != null) {
            RouteController controller = client.getRouteController(controllerId);
            if (controller != null) {
                controller.onUpdateVolume(delta);
                if (DEBUG) {
                    Log.d(TAG, client + ": Route volume updated" + ", controllerId=" + controllerId + ", delta=" + delta);
                }
                sendGenericSuccess(messenger, requestId);
                return true;
            }
        }
        return DEBUG;
    }

    private boolean onRouteControlRequest(Messenger messenger, int requestId, int controllerId, Intent intent) {
        ClientRecord client = getClient(messenger);
        if (client != null) {
            RouteController controller = client.getRouteController(controllerId);
            if (controller != null) {
                ControlRequestCallback callback = null;
                if (requestId != 0) {
                    callback = new C02931(client, controllerId, intent, messenger, requestId);
                }
                if (controller.onControlRequest(intent, callback)) {
                    if (DEBUG) {
                        Log.d(TAG, client + ": Route control request delivered" + ", controllerId=" + controllerId + ", intent=" + intent);
                    }
                    return true;
                }
            }
        }
        return DEBUG;
    }

    private boolean onSetDiscoveryRequest(Messenger messenger, int requestId, MediaRouteDiscoveryRequest request) {
        ClientRecord client = getClient(messenger);
        if (client == null) {
            return DEBUG;
        }
        boolean actuallyChanged = client.setDiscoveryRequest(request);
        if (DEBUG) {
            Log.d(TAG, client + ": Set discovery request, request=" + request + ", actuallyChanged=" + actuallyChanged + ", compositeDiscoveryRequest=" + this.mCompositeDiscoveryRequest);
        }
        sendGenericSuccess(messenger, requestId);
        return true;
    }

    private void sendDescriptorChanged(MediaRouteProviderDescriptor descriptor) {
        Bundle descriptorBundle;
        if (descriptor != null) {
            descriptorBundle = descriptor.asBundle();
        } else {
            descriptorBundle = null;
        }
        int count = this.mClients.size();
        for (int i = 0; i < count; i += PRIVATE_MSG_CLIENT_DIED) {
            ClientRecord client = (ClientRecord) this.mClients.get(i);
            sendReply(client.mMessenger, 5, 0, 0, descriptorBundle, null);
            if (DEBUG) {
                Log.d(TAG, client + ": Sent descriptor change event, descriptor=" + descriptor);
            }
        }
    }

    private boolean updateCompositeDiscoveryRequest() {
        MediaRouteDiscoveryRequest composite = null;
        Builder selectorBuilder = null;
        boolean activeScan = DEBUG;
        int count = this.mClients.size();
        for (int i = 0; i < count; i += PRIVATE_MSG_CLIENT_DIED) {
            MediaRouteDiscoveryRequest request = ((ClientRecord) this.mClients.get(i)).mDiscoveryRequest;
            if (request != null && (!request.getSelector().isEmpty() || request.isActiveScan())) {
                activeScan |= request.isActiveScan();
                if (composite == null) {
                    composite = request;
                } else {
                    if (selectorBuilder == null) {
                        selectorBuilder = new Builder(composite.getSelector());
                    }
                    selectorBuilder.addSelector(request.getSelector());
                }
            }
        }
        if (selectorBuilder != null) {
            composite = new MediaRouteDiscoveryRequest(selectorBuilder.build(), activeScan);
        }
        if (this.mCompositeDiscoveryRequest == composite || (this.mCompositeDiscoveryRequest != null && this.mCompositeDiscoveryRequest.equals(composite))) {
            return DEBUG;
        }
        this.mCompositeDiscoveryRequest = composite;
        this.mProvider.setDiscoveryRequest(composite);
        return true;
    }

    private ClientRecord getClient(Messenger messenger) {
        int index = findClient(messenger);
        return index >= 0 ? (ClientRecord) this.mClients.get(index) : null;
    }

    private int findClient(Messenger messenger) {
        int count = this.mClients.size();
        for (int i = 0; i < count; i += PRIVATE_MSG_CLIENT_DIED) {
            if (((ClientRecord) this.mClients.get(i)).hasMessenger(messenger)) {
                return i;
            }
        }
        return -1;
    }

    private static void sendGenericFailure(Messenger messenger, int requestId) {
        if (requestId != 0) {
            sendReply(messenger, 0, requestId, 0, null, null);
        }
    }

    private static void sendGenericSuccess(Messenger messenger, int requestId) {
        if (requestId != 0) {
            sendReply(messenger, PRIVATE_MSG_CLIENT_DIED, requestId, 0, null, null);
        }
    }

    private static void sendReply(Messenger messenger, int what, int requestId, int arg, Object obj, Bundle data) {
        Message msg = Message.obtain();
        msg.what = what;
        msg.arg1 = requestId;
        msg.arg2 = arg;
        msg.obj = obj;
        msg.setData(data);
        try {
            messenger.send(msg);
        } catch (DeadObjectException e) {
        } catch (RemoteException ex) {
            Log.e(TAG, "Could not send message to " + getClientId(messenger), ex);
        }
    }

    private static String getClientId(Messenger messenger) {
        return "Client connection " + messenger.getBinder().toString();
    }
}
