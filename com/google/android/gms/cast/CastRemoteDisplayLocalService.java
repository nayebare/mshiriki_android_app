package com.google.android.gms.cast;

import android.annotation.TargetApi;
import android.app.Notification;
import android.app.PendingIntent;
import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.ServiceInfo;
import android.os.Binder;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.support.v4.app.NotificationCompat;
import android.support.v7.media.MediaRouteSelector;
import android.support.v7.media.MediaRouter;
import android.support.v7.media.MediaRouter.Callback;
import android.support.v7.media.MediaRouter.RouteInfo;
import android.text.TextUtils;
import android.view.Display;
import com.google.android.gms.C0473R;
import com.google.android.gms.cast.CastRemoteDisplay.CastRemoteDisplayOptions.Builder;
import com.google.android.gms.cast.CastRemoteDisplay.CastRemoteDisplaySessionCallbacks;
import com.google.android.gms.cast.CastRemoteDisplay.CastRemoteDisplaySessionResult;
import com.google.android.gms.cast.CastRemoteDisplay.Configuration;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.zzac;
import com.google.android.gms.drive.DriveFile;
import com.google.android.gms.internal.zzyu;
import java.util.concurrent.atomic.AtomicBoolean;

@TargetApi(19)
public abstract class CastRemoteDisplayLocalService extends Service {
    private static CastRemoteDisplayLocalService zzamL;
    private static final zzyu zzamu;
    private static final int zzamv;
    private static final Object zzamw;
    private static AtomicBoolean zzamx;
    private Handler mHandler;
    private Notification mNotification;
    private Display zzNI;
    private String zzalR;
    private Callbacks zzamA;
    private zzb zzamB;
    private NotificationSettings zzamC;
    private boolean zzamD;
    private PendingIntent zzamE;
    private CastDevice zzamF;
    private Context zzamG;
    private ServiceConnection zzamH;
    private MediaRouter zzamI;
    private boolean zzamJ;
    private final Callback zzamK;
    private final IBinder zzamM;
    private GoogleApiClient zzamy;
    private CastRemoteDisplaySessionCallbacks zzamz;

    /* renamed from: com.google.android.gms.cast.CastRemoteDisplayLocalService.1 */
    class C05781 extends Callback {
        final /* synthetic */ CastRemoteDisplayLocalService zzamN;

        C05781(CastRemoteDisplayLocalService castRemoteDisplayLocalService) {
            this.zzamN = castRemoteDisplayLocalService;
        }

        public void onRouteUnselected(MediaRouter mediaRouter, RouteInfo routeInfo) {
            this.zzamN.zzbP("onRouteUnselected");
            if (this.zzamN.zzamF == null) {
                this.zzamN.zzbP("onRouteUnselected, no device was selected");
            } else if (CastDevice.getFromBundle(routeInfo.getExtras()).getDeviceId().equals(this.zzamN.zzamF.getDeviceId())) {
                CastRemoteDisplayLocalService.stopService();
            } else {
                this.zzamN.zzbP("onRouteUnselected, device does not match");
            }
        }
    }

    /* renamed from: com.google.android.gms.cast.CastRemoteDisplayLocalService.2 */
    class C05792 implements OnConnectionFailedListener {
        final /* synthetic */ CastRemoteDisplayLocalService zzamN;

        C05792(CastRemoteDisplayLocalService castRemoteDisplayLocalService) {
            this.zzamN = castRemoteDisplayLocalService;
        }

        public void onConnectionFailed(ConnectionResult connectionResult) {
            CastRemoteDisplayLocalService castRemoteDisplayLocalService = this.zzamN;
            String valueOf = String.valueOf(connectionResult);
            castRemoteDisplayLocalService.zzbS(new StringBuilder(String.valueOf(valueOf).length() + 19).append("Connection failed: ").append(valueOf).toString());
            this.zzamN.zzrQ();
        }
    }

    /* renamed from: com.google.android.gms.cast.CastRemoteDisplayLocalService.3 */
    class C05803 implements Runnable {
        final /* synthetic */ CastRemoteDisplayLocalService zzamN;

        C05803(CastRemoteDisplayLocalService castRemoteDisplayLocalService) {
            this.zzamN = castRemoteDisplayLocalService;
        }

        public void run() {
            this.zzamN.zzbP("onCreate after delay. The local service been started: " + this.zzamN.zzamJ);
            if (!this.zzamN.zzamJ) {
                this.zzamN.zzbS("The local service has not been been started, stopping it");
                this.zzamN.stopSelf();
            }
        }
    }

    /* renamed from: com.google.android.gms.cast.CastRemoteDisplayLocalService.4 */
    class C05814 implements ServiceConnection {
        final /* synthetic */ String zzalW;
        final /* synthetic */ CastDevice zzamO;
        final /* synthetic */ Options zzamP;
        final /* synthetic */ NotificationSettings zzamQ;
        final /* synthetic */ Context zzamR;
        final /* synthetic */ Callbacks zzamS;

        C05814(String str, CastDevice castDevice, Options options, NotificationSettings notificationSettings, Context context, Callbacks callbacks) {
            this.zzalW = str;
            this.zzamO = castDevice;
            this.zzamP = options;
            this.zzamQ = notificationSettings;
            this.zzamR = context;
            this.zzamS = callbacks;
        }

        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            CastRemoteDisplayLocalService zzrY = ((zza) iBinder).zzrY();
            if (zzrY == null || !zzrY.zza(this.zzalW, this.zzamO, this.zzamP, this.zzamQ, this.zzamR, this, this.zzamS)) {
                CastRemoteDisplayLocalService.zzamu.zzc("Connected but unable to get the service instance", new Object[0]);
                this.zzamS.onRemoteDisplaySessionError(new Status(CastStatusCodes.ERROR_SERVICE_CREATION_FAILED));
                CastRemoteDisplayLocalService.zzamx.set(false);
                try {
                    this.zzamR.unbindService(this);
                } catch (IllegalArgumentException e) {
                    CastRemoteDisplayLocalService.zzamu.zzb("No need to unbind service, already unbound", new Object[0]);
                }
            }
        }

        public void onServiceDisconnected(ComponentName componentName) {
            CastRemoteDisplayLocalService.zzamu.zzb("onServiceDisconnected", new Object[0]);
            this.zzamS.onRemoteDisplaySessionError(new Status(CastStatusCodes.ERROR_SERVICE_DISCONNECTED, "Service Disconnected"));
            CastRemoteDisplayLocalService.zzamx.set(false);
            try {
                this.zzamR.unbindService(this);
            } catch (IllegalArgumentException e) {
                CastRemoteDisplayLocalService.zzamu.zzb("No need to unbind service, already unbound", new Object[0]);
            }
        }
    }

    /* renamed from: com.google.android.gms.cast.CastRemoteDisplayLocalService.5 */
    class C05825 implements Runnable {
        final /* synthetic */ CastRemoteDisplayLocalService zzamN;
        final /* synthetic */ boolean zzamT;

        C05825(CastRemoteDisplayLocalService castRemoteDisplayLocalService, boolean z) {
            this.zzamN = castRemoteDisplayLocalService;
            this.zzamT = z;
        }

        public void run() {
            this.zzamN.zzaf(this.zzamT);
        }
    }

    /* renamed from: com.google.android.gms.cast.CastRemoteDisplayLocalService.6 */
    class C05836 implements Runnable {
        final /* synthetic */ CastRemoteDisplayLocalService zzamN;
        final /* synthetic */ NotificationSettings zzamQ;

        C05836(CastRemoteDisplayLocalService castRemoteDisplayLocalService, NotificationSettings notificationSettings) {
            this.zzamN = castRemoteDisplayLocalService;
            this.zzamQ = notificationSettings;
        }

        public void run() {
            this.zzamN.zza(this.zzamQ);
        }
    }

    /* renamed from: com.google.android.gms.cast.CastRemoteDisplayLocalService.7 */
    class C05847 implements CastRemoteDisplaySessionCallbacks {
        C05847(CastRemoteDisplayLocalService castRemoteDisplayLocalService) {
        }

        public void onRemoteDisplayEnded(Status status) {
            CastRemoteDisplayLocalService.zzamu.zzb(String.format("Cast screen has ended: %d", new Object[]{Integer.valueOf(status.getStatusCode())}), new Object[0]);
            CastRemoteDisplayLocalService.zzag(false);
        }
    }

    /* renamed from: com.google.android.gms.cast.CastRemoteDisplayLocalService.8 */
    class C05858 implements ResultCallback<CastRemoteDisplaySessionResult> {
        final /* synthetic */ CastRemoteDisplayLocalService zzamN;

        C05858(CastRemoteDisplayLocalService castRemoteDisplayLocalService) {
            this.zzamN = castRemoteDisplayLocalService;
        }

        public /* synthetic */ void onResult(Result result) {
            zza((CastRemoteDisplaySessionResult) result);
        }

        public void zza(CastRemoteDisplaySessionResult castRemoteDisplaySessionResult) {
            if (castRemoteDisplaySessionResult.getStatus().isSuccess()) {
                CastRemoteDisplayLocalService.zzamu.zzb("startRemoteDisplay successful", new Object[0]);
                synchronized (CastRemoteDisplayLocalService.zzamw) {
                    if (CastRemoteDisplayLocalService.zzamL == null) {
                        CastRemoteDisplayLocalService.zzamu.zzb("Remote Display started but session already cancelled", new Object[0]);
                        this.zzamN.zzrQ();
                        return;
                    }
                    Display presentationDisplay = castRemoteDisplaySessionResult.getPresentationDisplay();
                    if (presentationDisplay != null) {
                        this.zzamN.zza(presentationDisplay);
                    } else {
                        CastRemoteDisplayLocalService.zzamu.zzc("Cast Remote Display session created without display", new Object[0]);
                    }
                    CastRemoteDisplayLocalService.zzamx.set(false);
                    if (this.zzamN.zzamG != null && this.zzamN.zzamH != null) {
                        try {
                            this.zzamN.zzamG.unbindService(this.zzamN.zzamH);
                        } catch (IllegalArgumentException e) {
                            CastRemoteDisplayLocalService.zzamu.zzb("No need to unbind service, already unbound", new Object[0]);
                        }
                        this.zzamN.zzamH = null;
                        this.zzamN.zzamG = null;
                        return;
                    }
                    return;
                }
            }
            CastRemoteDisplayLocalService.zzamu.zzc("Connection was not successful", new Object[0]);
            this.zzamN.zzrQ();
        }
    }

    /* renamed from: com.google.android.gms.cast.CastRemoteDisplayLocalService.9 */
    class C05869 implements ResultCallback<CastRemoteDisplaySessionResult> {
        final /* synthetic */ CastRemoteDisplayLocalService zzamN;

        C05869(CastRemoteDisplayLocalService castRemoteDisplayLocalService) {
            this.zzamN = castRemoteDisplayLocalService;
        }

        public /* synthetic */ void onResult(Result result) {
            zza((CastRemoteDisplaySessionResult) result);
        }

        public void zza(CastRemoteDisplaySessionResult castRemoteDisplaySessionResult) {
            if (castRemoteDisplaySessionResult.getStatus().isSuccess()) {
                this.zzamN.zzbP("remote display stopped");
            } else {
                this.zzamN.zzbP("Unable to stop the remote display, result unsuccessful");
            }
            this.zzamN.zzNI = null;
        }
    }

    public interface Callbacks {
        void onRemoteDisplaySessionError(Status status);

        void onRemoteDisplaySessionStarted(CastRemoteDisplayLocalService castRemoteDisplayLocalService);

        void onServiceCreated(CastRemoteDisplayLocalService castRemoteDisplayLocalService);
    }

    public static final class NotificationSettings {
        private Notification mNotification;
        private PendingIntent zzamU;
        private String zzamV;
        private String zzamW;

        public static final class Builder {
            private NotificationSettings zzamX;

            public Builder() {
                this.zzamX = new NotificationSettings();
            }

            public NotificationSettings build() {
                if (this.zzamX.mNotification != null) {
                    if (!TextUtils.isEmpty(this.zzamX.zzamV)) {
                        throw new IllegalArgumentException("notificationTitle requires using the default notification");
                    } else if (!TextUtils.isEmpty(this.zzamX.zzamW)) {
                        throw new IllegalArgumentException("notificationText requires using the default notification");
                    } else if (this.zzamX.zzamU != null) {
                        throw new IllegalArgumentException("notificationPendingIntent requires using the default notification");
                    }
                } else if (TextUtils.isEmpty(this.zzamX.zzamV) && TextUtils.isEmpty(this.zzamX.zzamW) && this.zzamX.zzamU == null) {
                    throw new IllegalArgumentException("At least an argument must be provided");
                }
                return this.zzamX;
            }

            public Builder setNotification(Notification notification) {
                this.zzamX.mNotification = notification;
                return this;
            }

            public Builder setNotificationPendingIntent(PendingIntent pendingIntent) {
                this.zzamX.zzamU = pendingIntent;
                return this;
            }

            public Builder setNotificationText(String str) {
                this.zzamX.zzamW = str;
                return this;
            }

            public Builder setNotificationTitle(String str) {
                this.zzamX.zzamV = str;
                return this;
            }
        }

        private NotificationSettings() {
        }

        private NotificationSettings(NotificationSettings notificationSettings) {
            this.mNotification = notificationSettings.mNotification;
            this.zzamU = notificationSettings.zzamU;
            this.zzamV = notificationSettings.zzamV;
            this.zzamW = notificationSettings.zzamW;
        }
    }

    public static class Options {
        @Configuration
        int zzamr;

        public Options() {
            this.zzamr = 2;
        }

        public int getConfigPreset() {
            return this.zzamr;
        }

        public void setConfigPreset(@Configuration int i) {
            this.zzamr = i;
        }
    }

    private class zza extends Binder {
        final /* synthetic */ CastRemoteDisplayLocalService zzamN;

        private zza(CastRemoteDisplayLocalService castRemoteDisplayLocalService) {
            this.zzamN = castRemoteDisplayLocalService;
        }

        CastRemoteDisplayLocalService zzrY() {
            return this.zzamN;
        }
    }

    private static final class zzb extends BroadcastReceiver {
        private zzb() {
        }

        public void onReceive(Context context, Intent intent) {
            if (intent.getAction().equals("com.google.android.gms.cast.remote_display.ACTION_NOTIFICATION_DISCONNECT")) {
                CastRemoteDisplayLocalService.zzamu.zzb("disconnecting", new Object[0]);
                CastRemoteDisplayLocalService.stopService();
            }
        }
    }

    static {
        zzamu = new zzyu("CastRemoteDisplayLocalService");
        zzamv = zzrM();
        zzamw = new Object();
        zzamx = new AtomicBoolean(false);
    }

    public CastRemoteDisplayLocalService() {
        this.zzamJ = false;
        this.zzamK = new C05781(this);
        this.zzamM = new zza();
    }

    public static CastRemoteDisplayLocalService getInstance() {
        CastRemoteDisplayLocalService castRemoteDisplayLocalService;
        synchronized (zzamw) {
            castRemoteDisplayLocalService = zzamL;
        }
        return castRemoteDisplayLocalService;
    }

    protected static void setDebugEnabled() {
        zzamu.zzap(true);
    }

    public static void startService(Context context, Class<? extends CastRemoteDisplayLocalService> cls, String str, CastDevice castDevice, NotificationSettings notificationSettings, Callbacks callbacks) {
        startServiceWithOptions(context, cls, str, castDevice, new Options(), notificationSettings, callbacks);
    }

    public static void startServiceWithOptions(@NonNull Context context, @NonNull Class<? extends CastRemoteDisplayLocalService> cls, @NonNull String str, @NonNull CastDevice castDevice, @NonNull Options options, @NonNull NotificationSettings notificationSettings, @NonNull Callbacks callbacks) {
        zzamu.zzb("Starting Service", new Object[0]);
        synchronized (zzamw) {
            if (zzamL != null) {
                zzamu.zzf("An existing service had not been stopped before starting one", new Object[0]);
                zzag(true);
            }
        }
        zza(context, (Class) cls);
        zzac.zzb((Object) context, (Object) "activityContext is required.");
        zzac.zzb((Object) cls, (Object) "serviceClass is required.");
        zzac.zzb((Object) str, (Object) "applicationId is required.");
        zzac.zzb((Object) castDevice, (Object) "device is required.");
        zzac.zzb((Object) options, (Object) "options is required.");
        zzac.zzb((Object) notificationSettings, (Object) "notificationSettings is required.");
        zzac.zzb((Object) callbacks, (Object) "callbacks is required.");
        if (notificationSettings.mNotification == null && notificationSettings.zzamU == null) {
            throw new IllegalArgumentException("notificationSettings: Either the notification or the notificationPendingIntent must be provided");
        } else if (zzamx.getAndSet(true)) {
            zzamu.zzc("Service is already being started, startService has been called twice", new Object[0]);
        } else {
            Intent intent = new Intent(context, cls);
            context.startService(intent);
            context.bindService(intent, new C05814(str, castDevice, options, notificationSettings, context, callbacks), 64);
        }
    }

    public static void stopService() {
        zzag(false);
    }

    private GoogleApiClient zza(CastDevice castDevice, Options options) {
        Builder builder = new Builder(castDevice, this.zzamz);
        if (options != null) {
            builder.setConfigPreset(options.zzamr);
        }
        return new GoogleApiClient.Builder(this, new ConnectionCallbacks() {
            final /* synthetic */ CastRemoteDisplayLocalService zzamN;

            {
                this.zzamN = r1;
            }

            public void onConnected(Bundle bundle) {
                this.zzamN.zzbP("onConnected");
                this.zzamN.zzrO();
            }

            public void onConnectionSuspended(int i) {
                CastRemoteDisplayLocalService.zzamu.zzf(String.format("[Instance: %s] ConnectionSuspended %d", new Object[]{this, Integer.valueOf(i)}), new Object[0]);
            }
        }, new C05792(this)).addApi(CastRemoteDisplay.API, builder.build()).build();
    }

    private static void zza(Context context, Class<? extends CastRemoteDisplayLocalService> cls) {
        try {
            ServiceInfo serviceInfo = context.getPackageManager().getServiceInfo(new ComponentName(context, cls), Cast.MAX_NAMESPACE_LENGTH);
            if (serviceInfo != null && serviceInfo.exported) {
                throw new IllegalStateException("The service must not be exported, verify the manifest configuration");
            }
        } catch (NameNotFoundException e) {
            throw new IllegalStateException("Service not found, did you forget to configure it in the manifest?");
        }
    }

    private void zza(Display display) {
        this.zzNI = display;
        if (this.zzamD) {
            this.mNotification = zzah(true);
            startForeground(zzamv, this.mNotification);
        }
        if (this.zzamA != null) {
            this.zzamA.onRemoteDisplaySessionStarted(this);
            this.zzamA = null;
        }
        onCreatePresentation(this.zzNI);
    }

    private void zza(NotificationSettings notificationSettings) {
        zzac.zzdn("updateNotificationSettingsInternal must be called on the main thread");
        if (this.zzamC == null) {
            throw new IllegalStateException("No current notification settings to update");
        }
        if (!this.zzamD) {
            zzac.zzb(notificationSettings.mNotification, (Object) "notification is required.");
            this.mNotification = notificationSettings.mNotification;
            this.zzamC.mNotification = this.mNotification;
        } else if (notificationSettings.mNotification != null) {
            throw new IllegalStateException("Current mode is default notification, notification attribute must not be provided");
        } else {
            if (notificationSettings.zzamU != null) {
                this.zzamC.zzamU = notificationSettings.zzamU;
            }
            if (!TextUtils.isEmpty(notificationSettings.zzamV)) {
                this.zzamC.zzamV = notificationSettings.zzamV;
            }
            if (!TextUtils.isEmpty(notificationSettings.zzamW)) {
                this.zzamC.zzamW = notificationSettings.zzamW;
            }
            this.mNotification = zzah(true);
        }
        startForeground(zzamv, this.mNotification);
    }

    private boolean zza(String str, CastDevice castDevice, Options options, NotificationSettings notificationSettings, Context context, ServiceConnection serviceConnection, Callbacks callbacks) {
        zzbP("startRemoteDisplaySession");
        zzac.zzdn("Starting the Cast Remote Display must be done on the main thread");
        synchronized (zzamw) {
            if (zzamL != null) {
                zzamu.zzf("An existing service had not been stopped before starting one", new Object[0]);
                return false;
            }
            zzamL = this;
            this.zzamA = callbacks;
            this.zzalR = str;
            this.zzamF = castDevice;
            this.zzamG = context;
            this.zzamH = serviceConnection;
            this.zzamI = MediaRouter.getInstance(getApplicationContext());
            MediaRouteSelector build = new MediaRouteSelector.Builder().addControlCategory(CastMediaControlIntent.categoryForCast(this.zzalR)).build();
            zzbP("addMediaRouterCallback");
            this.zzamI.addCallback(build, this.zzamK, 4);
            this.zzamz = new C05847(this);
            this.mNotification = notificationSettings.mNotification;
            this.zzamB = new zzb();
            registerReceiver(this.zzamB, new IntentFilter("com.google.android.gms.cast.remote_display.ACTION_NOTIFICATION_DISCONNECT"));
            this.zzamC = new NotificationSettings(null);
            if (this.zzamC.mNotification == null) {
                this.zzamD = true;
                this.mNotification = zzah(false);
            } else {
                this.zzamD = false;
                this.mNotification = this.zzamC.mNotification;
            }
            startForeground(zzamv, this.mNotification);
            this.zzamy = zza(castDevice, options);
            this.zzamy.connect();
            if (this.zzamA != null) {
                this.zzamA.onServiceCreated(this);
            }
            return true;
        }
    }

    private void zzae(boolean z) {
        if (this.mHandler == null) {
            return;
        }
        if (Looper.myLooper() != Looper.getMainLooper()) {
            this.mHandler.post(new C05825(this, z));
        } else {
            zzaf(z);
        }
    }

    private void zzaf(boolean z) {
        zzbP("Stopping Service");
        zzac.zzdn("stopServiceInstanceInternal must be called on the main thread");
        if (!(z || this.zzamI == null)) {
            zzbP("Setting default route");
            this.zzamI.selectRoute(this.zzamI.getDefaultRoute());
        }
        if (this.zzamB != null) {
            zzbP("Unregistering notification receiver");
            unregisterReceiver(this.zzamB);
        }
        zzrR();
        zzrS();
        zzrN();
        if (this.zzamy != null) {
            this.zzamy.disconnect();
            this.zzamy = null;
        }
        if (!(this.zzamG == null || this.zzamH == null)) {
            try {
                this.zzamG.unbindService(this.zzamH);
            } catch (IllegalArgumentException e) {
                zzbP("No need to unbind service, already unbound");
            }
            this.zzamH = null;
            this.zzamG = null;
        }
        this.zzalR = null;
        this.zzamy = null;
        this.mNotification = null;
        this.zzNI = null;
    }

    private static void zzag(boolean z) {
        zzamu.zzb("Stopping Service", new Object[0]);
        zzamx.set(false);
        synchronized (zzamw) {
            if (zzamL == null) {
                zzamu.zzc("Service is already being stopped", new Object[0]);
                return;
            }
            CastRemoteDisplayLocalService castRemoteDisplayLocalService = zzamL;
            zzamL = null;
            castRemoteDisplayLocalService.zzae(z);
        }
    }

    private Notification zzah(boolean z) {
        int i;
        int i2;
        CharSequence string;
        zzbP("createDefaultNotification");
        int i3 = getApplicationInfo().labelRes;
        CharSequence zzc = this.zzamC.zzamV;
        CharSequence zzd = this.zzamC.zzamW;
        if (z) {
            i = C0473R.string.cast_notification_connected_message;
            i2 = C0473R.drawable.cast_ic_notification_on;
        } else {
            i = C0473R.string.cast_notification_connecting_message;
            i2 = C0473R.drawable.cast_ic_notification_connecting;
        }
        if (TextUtils.isEmpty(zzc)) {
            zzc = getString(i3);
        }
        if (TextUtils.isEmpty(zzd)) {
            string = getString(i, new Object[]{this.zzamF.getFriendlyName()});
        } else {
            string = zzd;
        }
        return new NotificationCompat.Builder(this).setContentTitle(zzc).setContentText(string).setContentIntent(this.zzamC.zzamU).setSmallIcon(i2).setOngoing(true).addAction(17301560, getString(C0473R.string.cast_notification_disconnect), zzrT()).build();
    }

    private void zzbP(String str) {
        zzamu.zzb("[Instance: %s] %s", this, str);
    }

    private void zzbS(String str) {
        zzamu.zzc("[Instance: %s] %s", this, str);
    }

    private static int zzrM() {
        return C0473R.id.cast_notification_id;
    }

    private void zzrN() {
        if (this.zzamI != null) {
            zzac.zzdn("CastRemoteDisplayLocalService calls must be done on the main thread");
            zzbP("removeMediaRouterCallback");
            this.zzamI.removeCallback(this.zzamK);
        }
    }

    private void zzrO() {
        zzbP("startRemoteDisplay");
        if (this.zzamy == null || !this.zzamy.isConnected()) {
            zzamu.zzc("Unable to start the remote display as the API client is not ready", new Object[0]);
        } else {
            CastRemoteDisplay.CastRemoteDisplayApi.startRemoteDisplay(this.zzamy, this.zzalR).setResultCallback(new C05858(this));
        }
    }

    private void zzrP() {
        zzbP("stopRemoteDisplay");
        if (this.zzamy == null || !this.zzamy.isConnected()) {
            zzamu.zzc("Unable to stop the remote display as the API client is not ready", new Object[0]);
        } else {
            CastRemoteDisplay.CastRemoteDisplayApi.stopRemoteDisplay(this.zzamy).setResultCallback(new C05869(this));
        }
    }

    private void zzrQ() {
        if (this.zzamA != null) {
            this.zzamA.onRemoteDisplaySessionError(new Status(CastStatusCodes.ERROR_SERVICE_CREATION_FAILED));
            this.zzamA = null;
        }
        stopService();
    }

    private void zzrR() {
        zzbP("stopRemoteDisplaySession");
        zzrP();
        onDismissPresentation();
    }

    private void zzrS() {
        zzbP("Stopping the remote display Service");
        stopForeground(true);
        stopSelf();
    }

    private PendingIntent zzrT() {
        if (this.zzamE == null) {
            Intent intent = new Intent("com.google.android.gms.cast.remote_display.ACTION_NOTIFICATION_DISCONNECT");
            intent.setPackage(this.zzamG.getPackageName());
            this.zzamE = PendingIntent.getBroadcast(this, 0, intent, DriveFile.MODE_READ_ONLY);
        }
        return this.zzamE;
    }

    protected Display getDisplay() {
        return this.zzNI;
    }

    public IBinder onBind(Intent intent) {
        zzbP("onBind");
        return this.zzamM;
    }

    public void onCreate() {
        zzbP("onCreate");
        super.onCreate();
        this.mHandler = new Handler(getMainLooper());
        this.mHandler.postDelayed(new C05803(this), 100);
    }

    public abstract void onCreatePresentation(Display display);

    public abstract void onDismissPresentation();

    public int onStartCommand(Intent intent, int i, int i2) {
        zzbP("onStartCommand");
        this.zzamJ = true;
        return 2;
    }

    public void updateNotificationSettings(NotificationSettings notificationSettings) {
        zzac.zzb((Object) notificationSettings, (Object) "notificationSettings is required.");
        zzac.zzb(this.mHandler, (Object) "Service is not ready yet.");
        this.mHandler.post(new C05836(this, notificationSettings));
    }
}
