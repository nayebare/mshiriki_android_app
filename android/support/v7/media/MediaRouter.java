package android.support.v7.media;

import android.app.ActivityManager;
import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.IntentSender;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityManagerCompat;
import android.support.v4.hardware.display.DisplayManagerCompat;
import android.support.v4.media.VolumeProviderCompat;
import android.support.v4.media.session.MediaSessionCompat;
import android.support.v4.media.session.MediaSessionCompat.OnActiveChangeListener;
import android.support.v4.media.session.MediaSessionCompat.Token;
import android.support.v4.util.Pair;
import android.support.v7.media.MediaRouteProvider.ProviderMetadata;
import android.support.v7.media.MediaRouteProvider.RouteController;
import android.support.v7.media.MediaRouteSelector.Builder;
import android.support.v7.media.RemoteControlClientCompat.PlaybackInfo;
import android.support.v7.media.RemoteControlClientCompat.VolumeCallback;
import android.support.v7.media.SystemMediaRouteProvider.SyncCallback;
import android.text.TextUtils;
import android.util.Log;
import android.view.Display;
import com.google.android.gms.drive.FileUploadPreferences;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public final class MediaRouter {
    public static final int AVAILABILITY_FLAG_IGNORE_DEFAULT_ROUTE = 1;
    public static final int AVAILABILITY_FLAG_REQUIRE_MATCH = 2;
    public static final int CALLBACK_FLAG_FORCE_DISCOVERY = 8;
    public static final int CALLBACK_FLAG_PERFORM_ACTIVE_SCAN = 1;
    public static final int CALLBACK_FLAG_REQUEST_DISCOVERY = 4;
    public static final int CALLBACK_FLAG_UNFILTERED_EVENTS = 2;
    private static final boolean DEBUG;
    private static final String TAG = "MediaRouter";
    public static final int UNSELECT_REASON_DISCONNECTED = 1;
    public static final int UNSELECT_REASON_ROUTE_CHANGED = 3;
    public static final int UNSELECT_REASON_STOPPED = 2;
    public static final int UNSELECT_REASON_UNKNOWN = 0;
    static GlobalMediaRouter sGlobal;
    final ArrayList<CallbackRecord> mCallbackRecords;
    final Context mContext;

    public static abstract class Callback {
        public void onRouteSelected(MediaRouter router, RouteInfo route) {
        }

        public void onRouteUnselected(MediaRouter router, RouteInfo route) {
        }

        public void onRouteUnselected(MediaRouter router, RouteInfo route, int reason) {
            onRouteUnselected(router, route);
        }

        public void onRouteAdded(MediaRouter router, RouteInfo route) {
        }

        public void onRouteRemoved(MediaRouter router, RouteInfo route) {
        }

        public void onRouteChanged(MediaRouter router, RouteInfo route) {
        }

        public void onRouteVolumeChanged(MediaRouter router, RouteInfo route) {
        }

        public void onRoutePresentationDisplayChanged(MediaRouter router, RouteInfo route) {
        }

        public void onProviderAdded(MediaRouter router, ProviderInfo provider) {
        }

        public void onProviderRemoved(MediaRouter router, ProviderInfo provider) {
        }

        public void onProviderChanged(MediaRouter router, ProviderInfo provider) {
        }
    }

    public static abstract class ControlRequestCallback {
        public void onResult(Bundle data) {
        }

        public void onError(String error, Bundle data) {
        }
    }

    private static final class CallbackRecord {
        public final Callback mCallback;
        public int mFlags;
        public final MediaRouter mRouter;
        public MediaRouteSelector mSelector;

        public CallbackRecord(MediaRouter router, Callback callback) {
            this.mRouter = router;
            this.mCallback = callback;
            this.mSelector = MediaRouteSelector.EMPTY;
        }

        public boolean filterRouteEvent(RouteInfo route) {
            return ((this.mFlags & MediaRouter.UNSELECT_REASON_STOPPED) != 0 || route.matchesSelector(this.mSelector)) ? true : MediaRouter.DEBUG;
        }
    }

    private static final class GlobalMediaRouter implements SyncCallback, android.support.v7.media.RegisteredMediaRouteProviderWatcher.Callback {
        private final Context mApplicationContext;
        private final CallbackHandler mCallbackHandler;
        private MediaSessionCompat mCompatSession;
        private RouteInfo mDefaultRoute;
        private MediaRouteDiscoveryRequest mDiscoveryRequest;
        private final DisplayManagerCompat mDisplayManager;
        private Map<String, RouteController> mGroupMemberControllers;
        private final boolean mLowRam;
        private MediaSessionRecord mMediaSession;
        private final PlaybackInfo mPlaybackInfo;
        private final ProviderCallback mProviderCallback;
        private final ArrayList<ProviderInfo> mProviders;
        private MediaSessionCompat mRccMediaSession;
        private RegisteredMediaRouteProviderWatcher mRegisteredProviderWatcher;
        private final ArrayList<RemoteControlClientRecord> mRemoteControlClients;
        private final ArrayList<WeakReference<MediaRouter>> mRouters;
        private final ArrayList<RouteInfo> mRoutes;
        private RouteInfo mSelectedRoute;
        private RouteController mSelectedRouteController;
        private OnActiveChangeListener mSessionActiveListener;
        private final SystemMediaRouteProvider mSystemProvider;
        private final Map<Pair<String, String>, String> mUniqueIdMap;

        /* renamed from: android.support.v7.media.MediaRouter.GlobalMediaRouter.1 */
        class C02961 implements OnActiveChangeListener {
            C02961() {
            }

            public void onActiveChanged() {
                if (GlobalMediaRouter.this.mRccMediaSession == null) {
                    return;
                }
                if (GlobalMediaRouter.this.mRccMediaSession.isActive()) {
                    GlobalMediaRouter.this.addRemoteControlClient(GlobalMediaRouter.this.mRccMediaSession.getRemoteControlClient());
                } else {
                    GlobalMediaRouter.this.removeRemoteControlClient(GlobalMediaRouter.this.mRccMediaSession.getRemoteControlClient());
                }
            }
        }

        private final class CallbackHandler extends Handler {
            public static final int MSG_PROVIDER_ADDED = 513;
            public static final int MSG_PROVIDER_CHANGED = 515;
            public static final int MSG_PROVIDER_REMOVED = 514;
            public static final int MSG_ROUTE_ADDED = 257;
            public static final int MSG_ROUTE_CHANGED = 259;
            public static final int MSG_ROUTE_PRESENTATION_DISPLAY_CHANGED = 261;
            public static final int MSG_ROUTE_REMOVED = 258;
            public static final int MSG_ROUTE_SELECTED = 262;
            public static final int MSG_ROUTE_UNSELECTED = 263;
            public static final int MSG_ROUTE_VOLUME_CHANGED = 260;
            private static final int MSG_TYPE_MASK = 65280;
            private static final int MSG_TYPE_PROVIDER = 512;
            private static final int MSG_TYPE_ROUTE = 256;
            private final ArrayList<CallbackRecord> mTempCallbackRecords;

            private CallbackHandler() {
                this.mTempCallbackRecords = new ArrayList();
            }

            public void post(int msg, Object obj) {
                obtainMessage(msg, obj).sendToTarget();
            }

            public void post(int msg, Object obj, int arg) {
                Message message = obtainMessage(msg, obj);
                message.arg1 = arg;
                message.sendToTarget();
            }

            public void handleMessage(Message msg) {
                int what = msg.what;
                Object obj = msg.obj;
                int arg = msg.arg1;
                syncWithSystemProvider(what, obj);
                try {
                    int i = GlobalMediaRouter.this.mRouters.size();
                    while (true) {
                        i--;
                        if (i < 0) {
                            break;
                        }
                        MediaRouter router = (MediaRouter) ((WeakReference) GlobalMediaRouter.this.mRouters.get(i)).get();
                        if (router == null) {
                            GlobalMediaRouter.this.mRouters.remove(i);
                        } else {
                            this.mTempCallbackRecords.addAll(router.mCallbackRecords);
                        }
                    }
                    int callbackCount = this.mTempCallbackRecords.size();
                    for (i = 0; i < callbackCount; i += MediaRouter.UNSELECT_REASON_DISCONNECTED) {
                        invokeCallback((CallbackRecord) this.mTempCallbackRecords.get(i), what, obj, arg);
                    }
                } finally {
                    this.mTempCallbackRecords.clear();
                }
            }

            private void syncWithSystemProvider(int what, Object obj) {
                switch (what) {
                    case MSG_ROUTE_ADDED /*257*/:
                        GlobalMediaRouter.this.mSystemProvider.onSyncRouteAdded((RouteInfo) obj);
                    case MSG_ROUTE_REMOVED /*258*/:
                        GlobalMediaRouter.this.mSystemProvider.onSyncRouteRemoved((RouteInfo) obj);
                    case MSG_ROUTE_CHANGED /*259*/:
                        GlobalMediaRouter.this.mSystemProvider.onSyncRouteChanged((RouteInfo) obj);
                    case MSG_ROUTE_SELECTED /*262*/:
                        GlobalMediaRouter.this.mSystemProvider.onSyncRouteSelected((RouteInfo) obj);
                    default:
                }
            }

            private void invokeCallback(CallbackRecord record, int what, Object obj, int arg) {
                MediaRouter router = record.mRouter;
                Callback callback = record.mCallback;
                switch (MSG_TYPE_MASK & what) {
                    case MSG_TYPE_ROUTE /*256*/:
                        RouteInfo route = (RouteInfo) obj;
                        if (record.filterRouteEvent(route)) {
                            switch (what) {
                                case MSG_ROUTE_ADDED /*257*/:
                                    callback.onRouteAdded(router, route);
                                case MSG_ROUTE_REMOVED /*258*/:
                                    callback.onRouteRemoved(router, route);
                                case MSG_ROUTE_CHANGED /*259*/:
                                    callback.onRouteChanged(router, route);
                                case MSG_ROUTE_VOLUME_CHANGED /*260*/:
                                    callback.onRouteVolumeChanged(router, route);
                                case MSG_ROUTE_PRESENTATION_DISPLAY_CHANGED /*261*/:
                                    callback.onRoutePresentationDisplayChanged(router, route);
                                case MSG_ROUTE_SELECTED /*262*/:
                                    callback.onRouteSelected(router, route);
                                case MSG_ROUTE_UNSELECTED /*263*/:
                                    callback.onRouteUnselected(router, route, arg);
                                default:
                            }
                        }
                    case MSG_TYPE_PROVIDER /*512*/:
                        ProviderInfo provider = (ProviderInfo) obj;
                        switch (what) {
                            case MSG_PROVIDER_ADDED /*513*/:
                                callback.onProviderAdded(router, provider);
                            case MSG_PROVIDER_REMOVED /*514*/:
                                callback.onProviderRemoved(router, provider);
                            case MSG_PROVIDER_CHANGED /*515*/:
                                callback.onProviderChanged(router, provider);
                            default:
                        }
                    default:
                }
            }
        }

        private final class MediaSessionRecord {
            private int mControlType;
            private int mMaxVolume;
            private final MediaSessionCompat mMsCompat;
            private VolumeProviderCompat mVpCompat;

            /* renamed from: android.support.v7.media.MediaRouter.GlobalMediaRouter.MediaSessionRecord.1 */
            class C02991 extends VolumeProviderCompat {

                /* renamed from: android.support.v7.media.MediaRouter.GlobalMediaRouter.MediaSessionRecord.1.1 */
                class C02971 implements Runnable {
                    final /* synthetic */ int val$volume;

                    C02971(int i) {
                        this.val$volume = i;
                    }

                    public void run() {
                        if (GlobalMediaRouter.this.mSelectedRoute != null) {
                            GlobalMediaRouter.this.mSelectedRoute.requestSetVolume(this.val$volume);
                        }
                    }
                }

                /* renamed from: android.support.v7.media.MediaRouter.GlobalMediaRouter.MediaSessionRecord.1.2 */
                class C02982 implements Runnable {
                    final /* synthetic */ int val$direction;

                    C02982(int i) {
                        this.val$direction = i;
                    }

                    public void run() {
                        if (GlobalMediaRouter.this.mSelectedRoute != null) {
                            GlobalMediaRouter.this.mSelectedRoute.requestUpdateVolume(this.val$direction);
                        }
                    }
                }

                C02991(int x0, int x1, int x2) {
                    super(x0, x1, x2);
                }

                public void onSetVolumeTo(int volume) {
                    GlobalMediaRouter.this.mCallbackHandler.post(new C02971(volume));
                }

                public void onAdjustVolume(int direction) {
                    GlobalMediaRouter.this.mCallbackHandler.post(new C02982(direction));
                }
            }

            public MediaSessionRecord(Object mediaSession) {
                this.mMsCompat = MediaSessionCompat.obtain(GlobalMediaRouter.this.mApplicationContext, mediaSession);
            }

            public void configureVolume(int controlType, int max, int current) {
                if (this.mVpCompat != null && controlType == this.mControlType && max == this.mMaxVolume) {
                    this.mVpCompat.setCurrentVolume(current);
                    return;
                }
                this.mVpCompat = new C02991(controlType, max, current);
                this.mMsCompat.setPlaybackToRemote(this.mVpCompat);
            }

            public void clearVolumeHandling() {
                this.mMsCompat.setPlaybackToLocal(GlobalMediaRouter.this.mPlaybackInfo.playbackStream);
                this.mVpCompat = null;
            }

            public Token getToken() {
                return this.mMsCompat.getSessionToken();
            }
        }

        private final class ProviderCallback extends android.support.v7.media.MediaRouteProvider.Callback {
            private ProviderCallback() {
            }

            public void onDescriptorChanged(MediaRouteProvider provider, MediaRouteProviderDescriptor descriptor) {
                GlobalMediaRouter.this.updateProviderDescriptor(provider, descriptor);
            }
        }

        private final class RemoteControlClientRecord implements VolumeCallback {
            private boolean mDisconnected;
            private final RemoteControlClientCompat mRccCompat;

            public RemoteControlClientRecord(Object rcc) {
                this.mRccCompat = RemoteControlClientCompat.obtain(GlobalMediaRouter.this.mApplicationContext, rcc);
                this.mRccCompat.setVolumeCallback(this);
                updatePlaybackInfo();
            }

            public Object getRemoteControlClient() {
                return this.mRccCompat.getRemoteControlClient();
            }

            public void disconnect() {
                this.mDisconnected = true;
                this.mRccCompat.setVolumeCallback(null);
            }

            public void updatePlaybackInfo() {
                this.mRccCompat.setPlaybackInfo(GlobalMediaRouter.this.mPlaybackInfo);
            }

            public void onVolumeSetRequest(int volume) {
                if (!this.mDisconnected && GlobalMediaRouter.this.mSelectedRoute != null) {
                    GlobalMediaRouter.this.mSelectedRoute.requestSetVolume(volume);
                }
            }

            public void onVolumeUpdateRequest(int direction) {
                if (!this.mDisconnected && GlobalMediaRouter.this.mSelectedRoute != null) {
                    GlobalMediaRouter.this.mSelectedRoute.requestUpdateVolume(direction);
                }
            }
        }

        GlobalMediaRouter(Context applicationContext) {
            this.mRouters = new ArrayList();
            this.mRoutes = new ArrayList();
            this.mUniqueIdMap = new HashMap();
            this.mProviders = new ArrayList();
            this.mRemoteControlClients = new ArrayList();
            this.mPlaybackInfo = new PlaybackInfo();
            this.mProviderCallback = new ProviderCallback();
            this.mCallbackHandler = new CallbackHandler();
            this.mSessionActiveListener = new C02961();
            this.mApplicationContext = applicationContext;
            this.mDisplayManager = DisplayManagerCompat.getInstance(applicationContext);
            this.mLowRam = ActivityManagerCompat.isLowRamDevice((ActivityManager) applicationContext.getSystemService("activity"));
            this.mSystemProvider = SystemMediaRouteProvider.obtain(applicationContext, this);
            addProvider(this.mSystemProvider);
        }

        public void start() {
            this.mRegisteredProviderWatcher = new RegisteredMediaRouteProviderWatcher(this.mApplicationContext, this);
            this.mRegisteredProviderWatcher.start();
        }

        public MediaRouter getRouter(Context context) {
            int i = this.mRouters.size();
            while (true) {
                i--;
                MediaRouter router;
                if (i >= 0) {
                    router = (MediaRouter) ((WeakReference) this.mRouters.get(i)).get();
                    if (router == null) {
                        this.mRouters.remove(i);
                    } else if (router.mContext == context) {
                        return router;
                    }
                } else {
                    router = new MediaRouter(context);
                    this.mRouters.add(new WeakReference(router));
                    return router;
                }
            }
        }

        public ContentResolver getContentResolver() {
            return this.mApplicationContext.getContentResolver();
        }

        public Context getProviderContext(String packageName) {
            if (packageName.equals(SystemMediaRouteProvider.PACKAGE_NAME)) {
                return this.mApplicationContext;
            }
            try {
                return this.mApplicationContext.createPackageContext(packageName, MediaRouter.CALLBACK_FLAG_REQUEST_DISCOVERY);
            } catch (NameNotFoundException e) {
                return null;
            }
        }

        public Display getDisplay(int displayId) {
            return this.mDisplayManager.getDisplay(displayId);
        }

        public void sendControlRequest(RouteInfo route, Intent intent, ControlRequestCallback callback) {
            if ((route != this.mSelectedRoute || this.mSelectedRouteController == null || !this.mSelectedRouteController.onControlRequest(intent, callback)) && callback != null) {
                callback.onError(null, null);
            }
        }

        public void requestSetVolume(RouteInfo route, int volume) {
            if (route == this.mSelectedRoute && this.mSelectedRouteController != null) {
                this.mSelectedRouteController.onSetVolume(volume);
            } else if (this.mGroupMemberControllers != null) {
                RouteController controller = (RouteController) this.mGroupMemberControllers.get(route.mDescriptorId);
                if (controller != null) {
                    controller.onSetVolume(volume);
                }
            }
        }

        public void requestUpdateVolume(RouteInfo route, int delta) {
            if (route == this.mSelectedRoute && this.mSelectedRouteController != null) {
                this.mSelectedRouteController.onUpdateVolume(delta);
            }
        }

        public RouteInfo getRoute(String uniqueId) {
            Iterator it = this.mRoutes.iterator();
            while (it.hasNext()) {
                RouteInfo info = (RouteInfo) it.next();
                if (info.mUniqueId.equals(uniqueId)) {
                    return info;
                }
            }
            return null;
        }

        public List<RouteInfo> getRoutes() {
            return this.mRoutes;
        }

        public List<ProviderInfo> getProviders() {
            return this.mProviders;
        }

        public RouteInfo getDefaultRoute() {
            if (this.mDefaultRoute != null) {
                return this.mDefaultRoute;
            }
            throw new IllegalStateException("There is no default route.  The media router has not yet been fully initialized.");
        }

        public RouteInfo getSelectedRoute() {
            if (this.mSelectedRoute != null) {
                return this.mSelectedRoute;
            }
            throw new IllegalStateException("There is no currently selected route.  The media router has not yet been fully initialized.");
        }

        public void selectRoute(RouteInfo route) {
            selectRoute(route, MediaRouter.UNSELECT_REASON_ROUTE_CHANGED);
        }

        public void selectRoute(RouteInfo route, int unselectReason) {
            if (!this.mRoutes.contains(route)) {
                Log.w(MediaRouter.TAG, "Ignoring attempt to select removed route: " + route);
            } else if (route.mEnabled) {
                setSelectedRouteInternal(route, unselectReason);
            } else {
                Log.w(MediaRouter.TAG, "Ignoring attempt to select disabled route: " + route);
            }
        }

        public boolean isRouteAvailable(MediaRouteSelector selector, int flags) {
            if (selector.isEmpty()) {
                return MediaRouter.DEBUG;
            }
            if ((flags & MediaRouter.UNSELECT_REASON_STOPPED) == 0 && this.mLowRam) {
                return true;
            }
            int routeCount = this.mRoutes.size();
            for (int i = 0; i < routeCount; i += MediaRouter.UNSELECT_REASON_DISCONNECTED) {
                RouteInfo route = (RouteInfo) this.mRoutes.get(i);
                if (((flags & MediaRouter.UNSELECT_REASON_DISCONNECTED) == 0 || !route.isDefaultOrBluetooth()) && route.matchesSelector(selector)) {
                    return true;
                }
            }
            return MediaRouter.DEBUG;
        }

        public void updateDiscoveryRequest() {
            boolean discover = MediaRouter.DEBUG;
            boolean activeScan = MediaRouter.DEBUG;
            Builder builder = new Builder();
            int i = this.mRouters.size();
            while (true) {
                i--;
                if (i < 0) {
                    break;
                }
                MediaRouter router = (MediaRouter) ((WeakReference) this.mRouters.get(i)).get();
                if (router == null) {
                    this.mRouters.remove(i);
                } else {
                    int count = router.mCallbackRecords.size();
                    for (int j = 0; j < count; j += MediaRouter.UNSELECT_REASON_DISCONNECTED) {
                        CallbackRecord callback = (CallbackRecord) router.mCallbackRecords.get(j);
                        builder.addSelector(callback.mSelector);
                        if ((callback.mFlags & MediaRouter.UNSELECT_REASON_DISCONNECTED) != 0) {
                            activeScan = true;
                            discover = true;
                        }
                        if (!((callback.mFlags & MediaRouter.CALLBACK_FLAG_REQUEST_DISCOVERY) == 0 || this.mLowRam)) {
                            discover = true;
                        }
                        if ((callback.mFlags & MediaRouter.CALLBACK_FLAG_FORCE_DISCOVERY) != 0) {
                            discover = true;
                        }
                    }
                }
            }
            MediaRouteSelector selector = discover ? builder.build() : MediaRouteSelector.EMPTY;
            if (this.mDiscoveryRequest == null || !this.mDiscoveryRequest.getSelector().equals(selector) || this.mDiscoveryRequest.isActiveScan() != activeScan) {
                if (!selector.isEmpty() || activeScan) {
                    this.mDiscoveryRequest = new MediaRouteDiscoveryRequest(selector, activeScan);
                } else if (this.mDiscoveryRequest != null) {
                    this.mDiscoveryRequest = null;
                } else {
                    return;
                }
                if (MediaRouter.DEBUG) {
                    Log.d(MediaRouter.TAG, "Updated discovery request: " + this.mDiscoveryRequest);
                }
                if (discover && !activeScan && this.mLowRam) {
                    Log.i(MediaRouter.TAG, "Forcing passive route discovery on a low-RAM device, system performance may be affected.  Please consider using CALLBACK_FLAG_REQUEST_DISCOVERY instead of CALLBACK_FLAG_FORCE_DISCOVERY.");
                }
                int providerCount = this.mProviders.size();
                for (i = 0; i < providerCount; i += MediaRouter.UNSELECT_REASON_DISCONNECTED) {
                    ((ProviderInfo) this.mProviders.get(i)).mProviderInstance.setDiscoveryRequest(this.mDiscoveryRequest);
                }
            }
        }

        public void addProvider(MediaRouteProvider providerInstance) {
            if (findProviderInfo(providerInstance) < 0) {
                ProviderInfo provider = new ProviderInfo(providerInstance);
                this.mProviders.add(provider);
                if (MediaRouter.DEBUG) {
                    Log.d(MediaRouter.TAG, "Provider added: " + provider);
                }
                this.mCallbackHandler.post(CallbackHandler.MSG_PROVIDER_ADDED, provider);
                updateProviderContents(provider, providerInstance.getDescriptor());
                providerInstance.setCallback(this.mProviderCallback);
                providerInstance.setDiscoveryRequest(this.mDiscoveryRequest);
            }
        }

        public void removeProvider(MediaRouteProvider providerInstance) {
            int index = findProviderInfo(providerInstance);
            if (index >= 0) {
                providerInstance.setCallback(null);
                providerInstance.setDiscoveryRequest(null);
                ProviderInfo provider = (ProviderInfo) this.mProviders.get(index);
                updateProviderContents(provider, null);
                if (MediaRouter.DEBUG) {
                    Log.d(MediaRouter.TAG, "Provider removed: " + provider);
                }
                this.mCallbackHandler.post(CallbackHandler.MSG_PROVIDER_REMOVED, provider);
                this.mProviders.remove(index);
            }
        }

        private void updateProviderDescriptor(MediaRouteProvider providerInstance, MediaRouteProviderDescriptor descriptor) {
            int index = findProviderInfo(providerInstance);
            if (index >= 0) {
                updateProviderContents((ProviderInfo) this.mProviders.get(index), descriptor);
            }
        }

        private int findProviderInfo(MediaRouteProvider providerInstance) {
            int count = this.mProviders.size();
            for (int i = 0; i < count; i += MediaRouter.UNSELECT_REASON_DISCONNECTED) {
                if (((ProviderInfo) this.mProviders.get(i)).mProviderInstance == providerInstance) {
                    return i;
                }
            }
            return -1;
        }

        private void updateProviderContents(ProviderInfo provider, MediaRouteProviderDescriptor providerDescriptor) {
            if (provider.updateDescriptor(providerDescriptor)) {
                int i;
                RouteInfo route;
                int targetIndex = 0;
                boolean selectedRouteDescriptorChanged = MediaRouter.DEBUG;
                if (providerDescriptor != null) {
                    if (providerDescriptor.isValid()) {
                        RouteInfo routeInfo;
                        List<MediaRouteDescriptor> routeDescriptors = providerDescriptor.getRoutes();
                        int routeCount = routeDescriptors.size();
                        List<Pair<RouteInfo, MediaRouteDescriptor>> addedGroups = new ArrayList();
                        List<Pair<RouteInfo, MediaRouteDescriptor>> updatedGroups = new ArrayList();
                        i = 0;
                        int targetIndex2 = 0;
                        while (i < routeCount) {
                            MediaRouteDescriptor routeDescriptor = (MediaRouteDescriptor) routeDescriptors.get(i);
                            String id = routeDescriptor.getId();
                            int sourceIndex = provider.findRouteByDescriptorId(id);
                            if (sourceIndex < 0) {
                                String uniqueId = assignRouteUniqueId(provider, id);
                                boolean isGroup = routeDescriptor.getGroupMemberIds() != null ? true : MediaRouter.DEBUG;
                                route = isGroup ? new RouteGroup(provider, id, uniqueId) : new RouteInfo(provider, id, uniqueId);
                                targetIndex = targetIndex2 + MediaRouter.UNSELECT_REASON_DISCONNECTED;
                                provider.mRoutes.add(targetIndex2, route);
                                this.mRoutes.add(route);
                                if (isGroup) {
                                    addedGroups.add(new Pair(route, routeDescriptor));
                                } else {
                                    route.maybeUpdateDescriptor(routeDescriptor);
                                    if (MediaRouter.DEBUG) {
                                        Log.d(MediaRouter.TAG, "Route added: " + route);
                                    }
                                    this.mCallbackHandler.post(FileUploadPreferences.BATTERY_USAGE_CHARGING_ONLY, route);
                                }
                            } else if (sourceIndex < targetIndex2) {
                                Log.w(MediaRouter.TAG, "Ignoring route descriptor with duplicate id: " + routeDescriptor);
                                targetIndex = targetIndex2;
                            } else {
                                route = (RouteInfo) provider.mRoutes.get(sourceIndex);
                                targetIndex = targetIndex2 + MediaRouter.UNSELECT_REASON_DISCONNECTED;
                                Collections.swap(provider.mRoutes, sourceIndex, targetIndex2);
                                if (route instanceof RouteGroup) {
                                    updatedGroups.add(new Pair(route, routeDescriptor));
                                } else if (updateRouteDescriptorAndNotify(route, routeDescriptor) != 0) {
                                    routeInfo = this.mSelectedRoute;
                                    if (route == r0) {
                                        selectedRouteDescriptorChanged = true;
                                    }
                                }
                            }
                            i += MediaRouter.UNSELECT_REASON_DISCONNECTED;
                            targetIndex2 = targetIndex;
                        }
                        for (Pair<RouteInfo, MediaRouteDescriptor> pair : addedGroups) {
                            route = (RouteInfo) pair.first;
                            route.maybeUpdateDescriptor((MediaRouteDescriptor) pair.second);
                            if (MediaRouter.DEBUG) {
                                Log.d(MediaRouter.TAG, "Route added: " + route);
                            }
                            this.mCallbackHandler.post(FileUploadPreferences.BATTERY_USAGE_CHARGING_ONLY, route);
                        }
                        for (Pair<RouteInfo, MediaRouteDescriptor> pair2 : updatedGroups) {
                            route = (RouteInfo) pair2.first;
                            if (updateRouteDescriptorAndNotify(route, (MediaRouteDescriptor) pair2.second) != 0) {
                                routeInfo = this.mSelectedRoute;
                                if (route == r0) {
                                    selectedRouteDescriptorChanged = true;
                                }
                            }
                        }
                        targetIndex = targetIndex2;
                    } else {
                        Log.w(MediaRouter.TAG, "Ignoring invalid provider descriptor: " + providerDescriptor);
                    }
                }
                for (i = provider.mRoutes.size() - 1; i >= targetIndex; i--) {
                    route = (RouteInfo) provider.mRoutes.get(i);
                    route.maybeUpdateDescriptor(null);
                    this.mRoutes.remove(route);
                }
                updateSelectedRouteIfNeeded(selectedRouteDescriptorChanged);
                for (i = provider.mRoutes.size() - 1; i >= targetIndex; i--) {
                    route = (RouteInfo) provider.mRoutes.remove(i);
                    if (MediaRouter.DEBUG) {
                        Log.d(MediaRouter.TAG, "Route removed: " + route);
                    }
                    this.mCallbackHandler.post(CallbackHandler.MSG_ROUTE_REMOVED, route);
                }
                if (MediaRouter.DEBUG) {
                    Log.d(MediaRouter.TAG, "Provider changed: " + provider);
                }
                this.mCallbackHandler.post(CallbackHandler.MSG_PROVIDER_CHANGED, provider);
            }
        }

        private int updateRouteDescriptorAndNotify(RouteInfo route, MediaRouteDescriptor routeDescriptor) {
            int changes = route.maybeUpdateDescriptor(routeDescriptor);
            if (changes != 0) {
                if ((changes & MediaRouter.UNSELECT_REASON_DISCONNECTED) != 0) {
                    if (MediaRouter.DEBUG) {
                        Log.d(MediaRouter.TAG, "Route changed: " + route);
                    }
                    this.mCallbackHandler.post(CallbackHandler.MSG_ROUTE_CHANGED, route);
                }
                if ((changes & MediaRouter.UNSELECT_REASON_STOPPED) != 0) {
                    if (MediaRouter.DEBUG) {
                        Log.d(MediaRouter.TAG, "Route volume changed: " + route);
                    }
                    this.mCallbackHandler.post(CallbackHandler.MSG_ROUTE_VOLUME_CHANGED, route);
                }
                if ((changes & MediaRouter.CALLBACK_FLAG_REQUEST_DISCOVERY) != 0) {
                    if (MediaRouter.DEBUG) {
                        Log.d(MediaRouter.TAG, "Route presentation display changed: " + route);
                    }
                    this.mCallbackHandler.post(CallbackHandler.MSG_ROUTE_PRESENTATION_DISPLAY_CHANGED, route);
                }
            }
            return changes;
        }

        private String assignRouteUniqueId(ProviderInfo provider, String routeDescriptorId) {
            String componentName = provider.getComponentName().flattenToShortString();
            String uniqueId = componentName + ":" + routeDescriptorId;
            if (findRouteByUniqueId(uniqueId) < 0) {
                this.mUniqueIdMap.put(new Pair(componentName, routeDescriptorId), uniqueId);
                return uniqueId;
            }
            Log.w(MediaRouter.TAG, "Either " + routeDescriptorId + " isn't unique in " + componentName + " or we're trying to assign a unique ID for an already added route");
            int i = MediaRouter.UNSELECT_REASON_STOPPED;
            while (true) {
                Object[] objArr = new Object[MediaRouter.UNSELECT_REASON_STOPPED];
                objArr[0] = uniqueId;
                objArr[MediaRouter.UNSELECT_REASON_DISCONNECTED] = Integer.valueOf(i);
                String newUniqueId = String.format(Locale.US, "%s_%d", objArr);
                if (findRouteByUniqueId(newUniqueId) < 0) {
                    this.mUniqueIdMap.put(new Pair(componentName, routeDescriptorId), newUniqueId);
                    return newUniqueId;
                }
                i += MediaRouter.UNSELECT_REASON_DISCONNECTED;
            }
        }

        private int findRouteByUniqueId(String uniqueId) {
            int count = this.mRoutes.size();
            for (int i = 0; i < count; i += MediaRouter.UNSELECT_REASON_DISCONNECTED) {
                if (((RouteInfo) this.mRoutes.get(i)).mUniqueId.equals(uniqueId)) {
                    return i;
                }
            }
            return -1;
        }

        private String getUniqueId(ProviderInfo provider, String routeDescriptorId) {
            return (String) this.mUniqueIdMap.get(new Pair(provider.getComponentName().flattenToShortString(), routeDescriptorId));
        }

        private void updateSelectedRouteIfNeeded(boolean selectedRouteDescriptorChanged) {
            if (!(this.mDefaultRoute == null || isRouteSelectable(this.mDefaultRoute))) {
                Log.i(MediaRouter.TAG, "Clearing the default route because it is no longer selectable: " + this.mDefaultRoute);
                this.mDefaultRoute = null;
            }
            if (this.mDefaultRoute == null && !this.mRoutes.isEmpty()) {
                Iterator it = this.mRoutes.iterator();
                while (it.hasNext()) {
                    RouteInfo route = (RouteInfo) it.next();
                    if (isSystemDefaultRoute(route) && isRouteSelectable(route)) {
                        this.mDefaultRoute = route;
                        Log.i(MediaRouter.TAG, "Found default route: " + this.mDefaultRoute);
                        break;
                    }
                }
            }
            if (!(this.mSelectedRoute == null || isRouteSelectable(this.mSelectedRoute))) {
                Log.i(MediaRouter.TAG, "Unselecting the current route because it is no longer selectable: " + this.mSelectedRoute);
                setSelectedRouteInternal(null, 0);
            }
            if (this.mSelectedRoute == null) {
                setSelectedRouteInternal(chooseFallbackRoute(), 0);
            } else if (selectedRouteDescriptorChanged) {
                updatePlaybackInfoFromSelectedRoute();
            }
        }

        RouteInfo chooseFallbackRoute() {
            Iterator it = this.mRoutes.iterator();
            while (it.hasNext()) {
                RouteInfo route = (RouteInfo) it.next();
                if (route != this.mDefaultRoute && isSystemLiveAudioOnlyRoute(route) && isRouteSelectable(route)) {
                    return route;
                }
            }
            return this.mDefaultRoute;
        }

        private boolean isSystemLiveAudioOnlyRoute(RouteInfo route) {
            return (route.getProviderInstance() == this.mSystemProvider && route.supportsControlCategory(MediaControlIntent.CATEGORY_LIVE_AUDIO) && !route.supportsControlCategory(MediaControlIntent.CATEGORY_LIVE_VIDEO)) ? true : MediaRouter.DEBUG;
        }

        private boolean isRouteSelectable(RouteInfo route) {
            return (route.mDescriptor == null || !route.mEnabled) ? MediaRouter.DEBUG : true;
        }

        private boolean isSystemDefaultRoute(RouteInfo route) {
            return (route.getProviderInstance() == this.mSystemProvider && route.mDescriptorId.equals(SystemMediaRouteProvider.DEFAULT_ROUTE_ID)) ? true : MediaRouter.DEBUG;
        }

        private void setSelectedRouteInternal(RouteInfo route, int unselectReason) {
            if (this.mSelectedRoute != route) {
                RouteController controller;
                if (this.mSelectedRoute != null) {
                    if (MediaRouter.DEBUG) {
                        Log.d(MediaRouter.TAG, "Route unselected: " + this.mSelectedRoute + " reason: " + unselectReason);
                    }
                    this.mCallbackHandler.post(CallbackHandler.MSG_ROUTE_UNSELECTED, this.mSelectedRoute, unselectReason);
                    if (this.mSelectedRouteController != null) {
                        this.mSelectedRouteController.onUnselect(unselectReason);
                        this.mSelectedRouteController.onRelease();
                        this.mSelectedRouteController = null;
                    }
                    if (this.mGroupMemberControllers != null) {
                        for (RouteController controller2 : this.mGroupMemberControllers.values()) {
                            controller2.onUnselect(unselectReason);
                            controller2.onRelease();
                        }
                        this.mGroupMemberControllers = null;
                    }
                }
                this.mSelectedRoute = route;
                if (this.mSelectedRoute != null) {
                    this.mSelectedRouteController = route.getProviderInstance().onCreateRouteController(route.mDescriptorId);
                    if (this.mSelectedRouteController != null) {
                        this.mSelectedRouteController.onSelect();
                    }
                    if (MediaRouter.DEBUG) {
                        Log.d(MediaRouter.TAG, "Route selected: " + this.mSelectedRoute);
                    }
                    this.mCallbackHandler.post(CallbackHandler.MSG_ROUTE_SELECTED, this.mSelectedRoute);
                    if (this.mSelectedRoute instanceof RouteGroup) {
                        this.mGroupMemberControllers = new HashMap();
                        for (RouteInfo groupMember : this.mSelectedRoute.getRoutes()) {
                            controller2 = groupMember.getProviderInstance().onCreateRouteController(groupMember.mDescriptorId);
                            controller2.onSelect();
                            this.mGroupMemberControllers.put(groupMember.mDescriptorId, controller2);
                        }
                    }
                }
                updatePlaybackInfoFromSelectedRoute();
            }
        }

        public RouteInfo getSystemRouteByDescriptorId(String id) {
            int providerIndex = findProviderInfo(this.mSystemProvider);
            if (providerIndex >= 0) {
                ProviderInfo provider = (ProviderInfo) this.mProviders.get(providerIndex);
                int routeIndex = provider.findRouteByDescriptorId(id);
                if (routeIndex >= 0) {
                    return (RouteInfo) provider.mRoutes.get(routeIndex);
                }
            }
            return null;
        }

        public void addRemoteControlClient(Object rcc) {
            if (findRemoteControlClientRecord(rcc) < 0) {
                this.mRemoteControlClients.add(new RemoteControlClientRecord(rcc));
            }
        }

        public void removeRemoteControlClient(Object rcc) {
            int index = findRemoteControlClientRecord(rcc);
            if (index >= 0) {
                ((RemoteControlClientRecord) this.mRemoteControlClients.remove(index)).disconnect();
            }
        }

        public void setMediaSession(Object session) {
            if (this.mMediaSession != null) {
                this.mMediaSession.clearVolumeHandling();
            }
            if (session == null) {
                this.mMediaSession = null;
                return;
            }
            this.mMediaSession = new MediaSessionRecord(session);
            updatePlaybackInfoFromSelectedRoute();
        }

        public void setMediaSessionCompat(MediaSessionCompat session) {
            this.mCompatSession = session;
            if (VERSION.SDK_INT >= 21) {
                Object mediaSession;
                if (session != null) {
                    mediaSession = session.getMediaSession();
                } else {
                    mediaSession = null;
                }
                setMediaSession(mediaSession);
            } else if (VERSION.SDK_INT >= 14) {
                if (this.mRccMediaSession != null) {
                    removeRemoteControlClient(this.mRccMediaSession.getRemoteControlClient());
                    this.mRccMediaSession.removeOnActiveChangeListener(this.mSessionActiveListener);
                }
                this.mRccMediaSession = session;
                if (session != null) {
                    session.addOnActiveChangeListener(this.mSessionActiveListener);
                    if (session.isActive()) {
                        addRemoteControlClient(session.getRemoteControlClient());
                    }
                }
            }
        }

        public Token getMediaSessionToken() {
            if (this.mMediaSession != null) {
                return this.mMediaSession.getToken();
            }
            if (this.mCompatSession != null) {
                return this.mCompatSession.getSessionToken();
            }
            return null;
        }

        private int findRemoteControlClientRecord(Object rcc) {
            int count = this.mRemoteControlClients.size();
            for (int i = 0; i < count; i += MediaRouter.UNSELECT_REASON_DISCONNECTED) {
                if (((RemoteControlClientRecord) this.mRemoteControlClients.get(i)).getRemoteControlClient() == rcc) {
                    return i;
                }
            }
            return -1;
        }

        private void updatePlaybackInfoFromSelectedRoute() {
            if (this.mSelectedRoute != null) {
                this.mPlaybackInfo.volume = this.mSelectedRoute.getVolume();
                this.mPlaybackInfo.volumeMax = this.mSelectedRoute.getVolumeMax();
                this.mPlaybackInfo.volumeHandling = this.mSelectedRoute.getVolumeHandling();
                this.mPlaybackInfo.playbackStream = this.mSelectedRoute.getPlaybackStream();
                this.mPlaybackInfo.playbackType = this.mSelectedRoute.getPlaybackType();
                int count = this.mRemoteControlClients.size();
                for (int i = 0; i < count; i += MediaRouter.UNSELECT_REASON_DISCONNECTED) {
                    ((RemoteControlClientRecord) this.mRemoteControlClients.get(i)).updatePlaybackInfo();
                }
                if (this.mMediaSession == null) {
                    return;
                }
                if (this.mSelectedRoute == getDefaultRoute()) {
                    this.mMediaSession.clearVolumeHandling();
                    return;
                }
                int controlType = 0;
                if (this.mPlaybackInfo.volumeHandling == MediaRouter.UNSELECT_REASON_DISCONNECTED) {
                    controlType = MediaRouter.UNSELECT_REASON_STOPPED;
                }
                this.mMediaSession.configureVolume(controlType, this.mPlaybackInfo.volumeMax, this.mPlaybackInfo.volume);
            } else if (this.mMediaSession != null) {
                this.mMediaSession.clearVolumeHandling();
            }
        }
    }

    public static final class ProviderInfo {
        private MediaRouteProviderDescriptor mDescriptor;
        private final ProviderMetadata mMetadata;
        private final MediaRouteProvider mProviderInstance;
        private Resources mResources;
        private boolean mResourcesNotAvailable;
        private final List<RouteInfo> mRoutes;

        ProviderInfo(MediaRouteProvider provider) {
            this.mRoutes = new ArrayList();
            this.mProviderInstance = provider;
            this.mMetadata = provider.getMetadata();
        }

        public MediaRouteProvider getProviderInstance() {
            MediaRouter.checkCallingThread();
            return this.mProviderInstance;
        }

        public String getPackageName() {
            return this.mMetadata.getPackageName();
        }

        public ComponentName getComponentName() {
            return this.mMetadata.getComponentName();
        }

        public List<RouteInfo> getRoutes() {
            MediaRouter.checkCallingThread();
            return this.mRoutes;
        }

        Resources getResources() {
            if (this.mResources == null && !this.mResourcesNotAvailable) {
                String packageName = getPackageName();
                Context context = MediaRouter.sGlobal.getProviderContext(packageName);
                if (context != null) {
                    this.mResources = context.getResources();
                } else {
                    Log.w(MediaRouter.TAG, "Unable to obtain resources for route provider package: " + packageName);
                    this.mResourcesNotAvailable = true;
                }
            }
            return this.mResources;
        }

        boolean updateDescriptor(MediaRouteProviderDescriptor descriptor) {
            if (this.mDescriptor == descriptor) {
                return MediaRouter.DEBUG;
            }
            this.mDescriptor = descriptor;
            return true;
        }

        int findRouteByDescriptorId(String id) {
            int count = this.mRoutes.size();
            for (int i = 0; i < count; i += MediaRouter.UNSELECT_REASON_DISCONNECTED) {
                if (((RouteInfo) this.mRoutes.get(i)).mDescriptorId.equals(id)) {
                    return i;
                }
            }
            return -1;
        }

        public String toString() {
            return "MediaRouter.RouteProviderInfo{ packageName=" + getPackageName() + " }";
        }
    }

    public static class RouteInfo {
        static final int CHANGE_GENERAL = 1;
        static final int CHANGE_PRESENTATION_DISPLAY = 4;
        static final int CHANGE_VOLUME = 2;
        public static final int CONNECTION_STATE_CONNECTED = 2;
        public static final int CONNECTION_STATE_CONNECTING = 1;
        public static final int CONNECTION_STATE_DISCONNECTED = 0;
        public static final int DEVICE_TYPE_BLUETOOTH = 3;
        public static final int DEVICE_TYPE_SPEAKER = 2;
        public static final int DEVICE_TYPE_TV = 1;
        public static final int DEVICE_TYPE_UNKNOWN = 0;
        public static final int PLAYBACK_TYPE_LOCAL = 0;
        public static final int PLAYBACK_TYPE_REMOTE = 1;
        public static final int PLAYBACK_VOLUME_FIXED = 0;
        public static final int PLAYBACK_VOLUME_VARIABLE = 1;
        public static final int PRESENTATION_DISPLAY_ID_NONE = -1;
        static final String SYSTEM_MEDIA_ROUTE_PROVIDER_PACKAGE_NAME = "android";
        private boolean mCanDisconnect;
        private boolean mConnecting;
        private int mConnectionState;
        private final ArrayList<IntentFilter> mControlFilters;
        private String mDescription;
        MediaRouteDescriptor mDescriptor;
        private final String mDescriptorId;
        private int mDeviceType;
        private boolean mEnabled;
        private Bundle mExtras;
        private Uri mIconUri;
        private String mName;
        private int mPlaybackStream;
        private int mPlaybackType;
        private Display mPresentationDisplay;
        private int mPresentationDisplayId;
        private final ProviderInfo mProvider;
        private IntentSender mSettingsIntent;
        private final String mUniqueId;
        private int mVolume;
        private int mVolumeHandling;
        private int mVolumeMax;

        RouteInfo(ProviderInfo provider, String descriptorId, String uniqueId) {
            this.mControlFilters = new ArrayList();
            this.mPresentationDisplayId = PRESENTATION_DISPLAY_ID_NONE;
            this.mProvider = provider;
            this.mDescriptorId = descriptorId;
            this.mUniqueId = uniqueId;
        }

        public ProviderInfo getProvider() {
            return this.mProvider;
        }

        @NonNull
        public String getId() {
            return this.mUniqueId;
        }

        public String getName() {
            return this.mName;
        }

        @Nullable
        public String getDescription() {
            return this.mDescription;
        }

        public Uri getIconUri() {
            return this.mIconUri;
        }

        public boolean isEnabled() {
            return this.mEnabled;
        }

        public boolean isConnecting() {
            return this.mConnecting;
        }

        public int getConnectionState() {
            return this.mConnectionState;
        }

        public boolean isSelected() {
            MediaRouter.checkCallingThread();
            return MediaRouter.sGlobal.getSelectedRoute() == this ? true : MediaRouter.DEBUG;
        }

        public boolean isDefault() {
            MediaRouter.checkCallingThread();
            return MediaRouter.sGlobal.getDefaultRoute() == this ? true : MediaRouter.DEBUG;
        }

        public List<IntentFilter> getControlFilters() {
            return this.mControlFilters;
        }

        public boolean matchesSelector(@NonNull MediaRouteSelector selector) {
            if (selector == null) {
                throw new IllegalArgumentException("selector must not be null");
            }
            MediaRouter.checkCallingThread();
            return selector.matchesControlFilters(this.mControlFilters);
        }

        public boolean supportsControlCategory(@NonNull String category) {
            if (category == null) {
                throw new IllegalArgumentException("category must not be null");
            }
            MediaRouter.checkCallingThread();
            int count = this.mControlFilters.size();
            for (int i = PLAYBACK_VOLUME_FIXED; i < count; i += PLAYBACK_VOLUME_VARIABLE) {
                if (((IntentFilter) this.mControlFilters.get(i)).hasCategory(category)) {
                    return true;
                }
            }
            return MediaRouter.DEBUG;
        }

        public boolean supportsControlAction(@NonNull String category, @NonNull String action) {
            if (category == null) {
                throw new IllegalArgumentException("category must not be null");
            } else if (action == null) {
                throw new IllegalArgumentException("action must not be null");
            } else {
                MediaRouter.checkCallingThread();
                int count = this.mControlFilters.size();
                for (int i = PLAYBACK_VOLUME_FIXED; i < count; i += PLAYBACK_VOLUME_VARIABLE) {
                    IntentFilter filter = (IntentFilter) this.mControlFilters.get(i);
                    if (filter.hasCategory(category) && filter.hasAction(action)) {
                        return true;
                    }
                }
                return MediaRouter.DEBUG;
            }
        }

        public boolean supportsControlRequest(@NonNull Intent intent) {
            if (intent == null) {
                throw new IllegalArgumentException("intent must not be null");
            }
            MediaRouter.checkCallingThread();
            ContentResolver contentResolver = MediaRouter.sGlobal.getContentResolver();
            int count = this.mControlFilters.size();
            for (int i = PLAYBACK_VOLUME_FIXED; i < count; i += PLAYBACK_VOLUME_VARIABLE) {
                if (((IntentFilter) this.mControlFilters.get(i)).match(contentResolver, intent, true, MediaRouter.TAG) >= 0) {
                    return true;
                }
            }
            return MediaRouter.DEBUG;
        }

        public void sendControlRequest(@NonNull Intent intent, @Nullable ControlRequestCallback callback) {
            if (intent == null) {
                throw new IllegalArgumentException("intent must not be null");
            }
            MediaRouter.checkCallingThread();
            MediaRouter.sGlobal.sendControlRequest(this, intent, callback);
        }

        public int getPlaybackType() {
            return this.mPlaybackType;
        }

        public int getPlaybackStream() {
            return this.mPlaybackStream;
        }

        public int getDeviceType() {
            return this.mDeviceType;
        }

        public boolean isDefaultOrBluetooth() {
            if (isDefault() || this.mDeviceType == DEVICE_TYPE_BLUETOOTH) {
                return true;
            }
            if (isSystemMediaRouteProvider(this) && supportsControlCategory(MediaControlIntent.CATEGORY_LIVE_AUDIO) && !supportsControlCategory(MediaControlIntent.CATEGORY_LIVE_VIDEO)) {
                return true;
            }
            return MediaRouter.DEBUG;
        }

        private static boolean isSystemMediaRouteProvider(RouteInfo route) {
            return TextUtils.equals(route.getProviderInstance().getMetadata().getPackageName(), SYSTEM_MEDIA_ROUTE_PROVIDER_PACKAGE_NAME);
        }

        public int getVolumeHandling() {
            return this.mVolumeHandling;
        }

        public int getVolume() {
            return this.mVolume;
        }

        public int getVolumeMax() {
            return this.mVolumeMax;
        }

        public boolean canDisconnect() {
            return this.mCanDisconnect;
        }

        public void requestSetVolume(int volume) {
            MediaRouter.checkCallingThread();
            MediaRouter.sGlobal.requestSetVolume(this, Math.min(this.mVolumeMax, Math.max(PLAYBACK_VOLUME_FIXED, volume)));
        }

        public void requestUpdateVolume(int delta) {
            MediaRouter.checkCallingThread();
            if (delta != 0) {
                MediaRouter.sGlobal.requestUpdateVolume(this, delta);
            }
        }

        @Nullable
        public Display getPresentationDisplay() {
            MediaRouter.checkCallingThread();
            if (this.mPresentationDisplayId >= 0 && this.mPresentationDisplay == null) {
                this.mPresentationDisplay = MediaRouter.sGlobal.getDisplay(this.mPresentationDisplayId);
            }
            return this.mPresentationDisplay;
        }

        public int getPresentationDisplayId() {
            return this.mPresentationDisplayId;
        }

        @Nullable
        public Bundle getExtras() {
            return this.mExtras;
        }

        @Nullable
        public IntentSender getSettingsIntent() {
            return this.mSettingsIntent;
        }

        public void select() {
            MediaRouter.checkCallingThread();
            MediaRouter.sGlobal.selectRoute(this);
        }

        public String toString() {
            return "MediaRouter.RouteInfo{ uniqueId=" + this.mUniqueId + ", name=" + this.mName + ", description=" + this.mDescription + ", iconUri=" + this.mIconUri + ", enabled=" + this.mEnabled + ", connecting=" + this.mConnecting + ", connectionState=" + this.mConnectionState + ", canDisconnect=" + this.mCanDisconnect + ", playbackType=" + this.mPlaybackType + ", playbackStream=" + this.mPlaybackStream + ", deviceType=" + this.mDeviceType + ", volumeHandling=" + this.mVolumeHandling + ", volume=" + this.mVolume + ", volumeMax=" + this.mVolumeMax + ", presentationDisplayId=" + this.mPresentationDisplayId + ", extras=" + this.mExtras + ", settingsIntent=" + this.mSettingsIntent + ", providerPackageName=" + this.mProvider.getPackageName() + " }";
        }

        int maybeUpdateDescriptor(MediaRouteDescriptor descriptor) {
            if (this.mDescriptor != descriptor) {
                return updateDescriptor(descriptor);
            }
            return PLAYBACK_VOLUME_FIXED;
        }

        int updateDescriptor(MediaRouteDescriptor descriptor) {
            int changes = PLAYBACK_VOLUME_FIXED;
            this.mDescriptor = descriptor;
            if (descriptor == null) {
                return PLAYBACK_VOLUME_FIXED;
            }
            if (!MediaRouter.equal(this.mName, descriptor.getName())) {
                this.mName = descriptor.getName();
                changes = PLAYBACK_VOLUME_FIXED | PLAYBACK_VOLUME_VARIABLE;
            }
            if (!MediaRouter.equal(this.mDescription, descriptor.getDescription())) {
                this.mDescription = descriptor.getDescription();
                changes |= PLAYBACK_VOLUME_VARIABLE;
            }
            if (!MediaRouter.equal(this.mIconUri, descriptor.getIconUri())) {
                this.mIconUri = descriptor.getIconUri();
                changes |= PLAYBACK_VOLUME_VARIABLE;
            }
            if (this.mEnabled != descriptor.isEnabled()) {
                this.mEnabled = descriptor.isEnabled();
                changes |= PLAYBACK_VOLUME_VARIABLE;
            }
            if (this.mConnecting != descriptor.isConnecting()) {
                this.mConnecting = descriptor.isConnecting();
                changes |= PLAYBACK_VOLUME_VARIABLE;
            }
            if (this.mConnectionState != descriptor.getConnectionState()) {
                this.mConnectionState = descriptor.getConnectionState();
                changes |= PLAYBACK_VOLUME_VARIABLE;
            }
            if (!this.mControlFilters.equals(descriptor.getControlFilters())) {
                this.mControlFilters.clear();
                this.mControlFilters.addAll(descriptor.getControlFilters());
                changes |= PLAYBACK_VOLUME_VARIABLE;
            }
            if (this.mPlaybackType != descriptor.getPlaybackType()) {
                this.mPlaybackType = descriptor.getPlaybackType();
                changes |= PLAYBACK_VOLUME_VARIABLE;
            }
            if (this.mPlaybackStream != descriptor.getPlaybackStream()) {
                this.mPlaybackStream = descriptor.getPlaybackStream();
                changes |= PLAYBACK_VOLUME_VARIABLE;
            }
            if (this.mDeviceType != descriptor.getDeviceType()) {
                this.mDeviceType = descriptor.getDeviceType();
                changes |= PLAYBACK_VOLUME_VARIABLE;
            }
            if (this.mVolumeHandling != descriptor.getVolumeHandling()) {
                this.mVolumeHandling = descriptor.getVolumeHandling();
                changes |= DEVICE_TYPE_BLUETOOTH;
            }
            if (this.mVolume != descriptor.getVolume()) {
                this.mVolume = descriptor.getVolume();
                changes |= DEVICE_TYPE_BLUETOOTH;
            }
            if (this.mVolumeMax != descriptor.getVolumeMax()) {
                this.mVolumeMax = descriptor.getVolumeMax();
                changes |= DEVICE_TYPE_BLUETOOTH;
            }
            if (this.mPresentationDisplayId != descriptor.getPresentationDisplayId()) {
                this.mPresentationDisplayId = descriptor.getPresentationDisplayId();
                this.mPresentationDisplay = null;
                changes |= 5;
            }
            if (!MediaRouter.equal(this.mExtras, descriptor.getExtras())) {
                this.mExtras = descriptor.getExtras();
                changes |= PLAYBACK_VOLUME_VARIABLE;
            }
            if (!MediaRouter.equal(this.mSettingsIntent, descriptor.getSettingsActivity())) {
                this.mSettingsIntent = descriptor.getSettingsActivity();
                changes |= PLAYBACK_VOLUME_VARIABLE;
            }
            if (this.mCanDisconnect == descriptor.canDisconnectAndKeepPlaying()) {
                return changes;
            }
            this.mCanDisconnect = descriptor.canDisconnectAndKeepPlaying();
            return changes | 5;
        }

        String getDescriptorId() {
            return this.mDescriptorId;
        }

        public MediaRouteProvider getProviderInstance() {
            return this.mProvider.getProviderInstance();
        }
    }

    public static class RouteGroup extends RouteInfo {
        private List<RouteInfo> mRoutes;

        RouteGroup(ProviderInfo provider, String descriptorId, String uniqueId) {
            super(provider, descriptorId, uniqueId);
            this.mRoutes = new ArrayList();
        }

        public int getRouteCount() {
            return this.mRoutes.size();
        }

        public RouteInfo getRouteAt(int index) {
            return (RouteInfo) this.mRoutes.get(index);
        }

        public List<RouteInfo> getRoutes() {
            return this.mRoutes;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder(super.toString());
            sb.append('[');
            int count = this.mRoutes.size();
            for (int i = 0; i < count; i += MediaRouter.UNSELECT_REASON_DISCONNECTED) {
                if (i > 0) {
                    sb.append(", ");
                }
                sb.append(this.mRoutes.get(i));
            }
            sb.append(']');
            return sb.toString();
        }

        int maybeUpdateDescriptor(MediaRouteDescriptor descriptor) {
            int i = MediaRouter.UNSELECT_REASON_DISCONNECTED;
            boolean changed = MediaRouter.DEBUG;
            if (this.mDescriptor != descriptor) {
                this.mDescriptor = descriptor;
                if (descriptor != null) {
                    List<String> groupMemberIds = descriptor.getGroupMemberIds();
                    List<RouteInfo> routes = new ArrayList();
                    if (groupMemberIds.size() != this.mRoutes.size()) {
                        changed = true;
                    } else {
                        changed = MediaRouter.DEBUG;
                    }
                    for (String groupMemberId : groupMemberIds) {
                        RouteInfo groupMember = MediaRouter.sGlobal.getRoute(MediaRouter.sGlobal.getUniqueId(getProvider(), groupMemberId));
                        if (groupMember != null) {
                            routes.add(groupMember);
                            if (!(changed || this.mRoutes.contains(groupMember))) {
                                changed = true;
                            }
                        }
                    }
                    if (changed) {
                        this.mRoutes = routes;
                    }
                }
            }
            if (!changed) {
                i = 0;
            }
            return i | super.updateDescriptor(descriptor);
        }
    }

    static {
        DEBUG = Log.isLoggable(TAG, UNSELECT_REASON_ROUTE_CHANGED);
    }

    MediaRouter(Context context) {
        this.mCallbackRecords = new ArrayList();
        this.mContext = context;
    }

    public static MediaRouter getInstance(@NonNull Context context) {
        if (context == null) {
            throw new IllegalArgumentException("context must not be null");
        }
        checkCallingThread();
        if (sGlobal == null) {
            sGlobal = new GlobalMediaRouter(context.getApplicationContext());
            sGlobal.start();
        }
        return sGlobal.getRouter(context);
    }

    public List<RouteInfo> getRoutes() {
        checkCallingThread();
        return sGlobal.getRoutes();
    }

    public List<ProviderInfo> getProviders() {
        checkCallingThread();
        return sGlobal.getProviders();
    }

    @NonNull
    public RouteInfo getDefaultRoute() {
        checkCallingThread();
        return sGlobal.getDefaultRoute();
    }

    @NonNull
    public RouteInfo getSelectedRoute() {
        checkCallingThread();
        return sGlobal.getSelectedRoute();
    }

    @NonNull
    public RouteInfo updateSelectedRoute(@NonNull MediaRouteSelector selector) {
        if (selector == null) {
            throw new IllegalArgumentException("selector must not be null");
        }
        checkCallingThread();
        if (DEBUG) {
            Log.d(TAG, "updateSelectedRoute: " + selector);
        }
        RouteInfo route = sGlobal.getSelectedRoute();
        if (route.isDefaultOrBluetooth() || route.matchesSelector(selector)) {
            return route;
        }
        route = sGlobal.chooseFallbackRoute();
        sGlobal.selectRoute(route);
        return route;
    }

    public void selectRoute(@NonNull RouteInfo route) {
        if (route == null) {
            throw new IllegalArgumentException("route must not be null");
        }
        checkCallingThread();
        if (DEBUG) {
            Log.d(TAG, "selectRoute: " + route);
        }
        sGlobal.selectRoute(route);
    }

    public void unselect(int reason) {
        if (reason < 0 || reason > UNSELECT_REASON_ROUTE_CHANGED) {
            throw new IllegalArgumentException("Unsupported reason to unselect route");
        }
        checkCallingThread();
        RouteInfo fallbackRoute = sGlobal.chooseFallbackRoute();
        if (sGlobal.getSelectedRoute() != fallbackRoute) {
            sGlobal.selectRoute(fallbackRoute, reason);
        } else {
            sGlobal.selectRoute(sGlobal.getDefaultRoute(), reason);
        }
    }

    public boolean isRouteAvailable(@NonNull MediaRouteSelector selector, int flags) {
        if (selector == null) {
            throw new IllegalArgumentException("selector must not be null");
        }
        checkCallingThread();
        return sGlobal.isRouteAvailable(selector, flags);
    }

    public void addCallback(MediaRouteSelector selector, Callback callback) {
        addCallback(selector, callback, 0);
    }

    public void addCallback(@NonNull MediaRouteSelector selector, @NonNull Callback callback, int flags) {
        if (selector == null) {
            throw new IllegalArgumentException("selector must not be null");
        } else if (callback == null) {
            throw new IllegalArgumentException("callback must not be null");
        } else {
            CallbackRecord record;
            checkCallingThread();
            if (DEBUG) {
                Log.d(TAG, "addCallback: selector=" + selector + ", callback=" + callback + ", flags=" + Integer.toHexString(flags));
            }
            int index = findCallbackRecord(callback);
            if (index < 0) {
                record = new CallbackRecord(this, callback);
                this.mCallbackRecords.add(record);
            } else {
                record = (CallbackRecord) this.mCallbackRecords.get(index);
            }
            boolean updateNeeded = DEBUG;
            if (((record.mFlags ^ -1) & flags) != 0) {
                record.mFlags |= flags;
                updateNeeded = true;
            }
            if (!record.mSelector.contains(selector)) {
                record.mSelector = new Builder(record.mSelector).addSelector(selector).build();
                updateNeeded = true;
            }
            if (updateNeeded) {
                sGlobal.updateDiscoveryRequest();
            }
        }
    }

    public void removeCallback(@NonNull Callback callback) {
        if (callback == null) {
            throw new IllegalArgumentException("callback must not be null");
        }
        checkCallingThread();
        if (DEBUG) {
            Log.d(TAG, "removeCallback: callback=" + callback);
        }
        int index = findCallbackRecord(callback);
        if (index >= 0) {
            this.mCallbackRecords.remove(index);
            sGlobal.updateDiscoveryRequest();
        }
    }

    private int findCallbackRecord(Callback callback) {
        int count = this.mCallbackRecords.size();
        for (int i = 0; i < count; i += UNSELECT_REASON_DISCONNECTED) {
            if (((CallbackRecord) this.mCallbackRecords.get(i)).mCallback == callback) {
                return i;
            }
        }
        return -1;
    }

    public void addProvider(@NonNull MediaRouteProvider providerInstance) {
        if (providerInstance == null) {
            throw new IllegalArgumentException("providerInstance must not be null");
        }
        checkCallingThread();
        if (DEBUG) {
            Log.d(TAG, "addProvider: " + providerInstance);
        }
        sGlobal.addProvider(providerInstance);
    }

    public void removeProvider(@NonNull MediaRouteProvider providerInstance) {
        if (providerInstance == null) {
            throw new IllegalArgumentException("providerInstance must not be null");
        }
        checkCallingThread();
        if (DEBUG) {
            Log.d(TAG, "removeProvider: " + providerInstance);
        }
        sGlobal.removeProvider(providerInstance);
    }

    public void addRemoteControlClient(@NonNull Object remoteControlClient) {
        if (remoteControlClient == null) {
            throw new IllegalArgumentException("remoteControlClient must not be null");
        }
        checkCallingThread();
        if (DEBUG) {
            Log.d(TAG, "addRemoteControlClient: " + remoteControlClient);
        }
        sGlobal.addRemoteControlClient(remoteControlClient);
    }

    public void removeRemoteControlClient(@NonNull Object remoteControlClient) {
        if (remoteControlClient == null) {
            throw new IllegalArgumentException("remoteControlClient must not be null");
        }
        if (DEBUG) {
            Log.d(TAG, "removeRemoteControlClient: " + remoteControlClient);
        }
        sGlobal.removeRemoteControlClient(remoteControlClient);
    }

    public void setMediaSession(Object mediaSession) {
        if (DEBUG) {
            Log.d(TAG, "addMediaSession: " + mediaSession);
        }
        sGlobal.setMediaSession(mediaSession);
    }

    public void setMediaSessionCompat(MediaSessionCompat mediaSession) {
        if (DEBUG) {
            Log.d(TAG, "addMediaSessionCompat: " + mediaSession);
        }
        sGlobal.setMediaSessionCompat(mediaSession);
    }

    public Token getMediaSessionToken() {
        return sGlobal.getMediaSessionToken();
    }

    static void checkCallingThread() {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            throw new IllegalStateException("The media router service must only be accessed on the application's main thread.");
        }
    }

    static <T> boolean equal(T a, T b) {
        return (a == b || !(a == null || b == null || !a.equals(b))) ? true : DEBUG;
    }
}
