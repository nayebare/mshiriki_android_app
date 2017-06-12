package com.google.android.gms.cast;

import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import android.os.RemoteException;
import android.text.TextUtils;
import com.github.mikephil.charting.BuildConfig;
import com.google.android.gms.cast.LaunchOptions.Builder;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.ApiOptions.HasOptions;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.zzac;
import com.google.android.gms.common.internal.zzg;
import com.google.android.gms.games.GamesStatusCodes;
import com.google.android.gms.internal.zzyi;
import com.google.android.gms.internal.zzyl;
import com.google.android.gms.internal.zzyq;
import com.google.android.gms.internal.zzyt;
import java.io.IOException;

public final class Cast {
    public static final int ACTIVE_INPUT_STATE_NO = 0;
    public static final int ACTIVE_INPUT_STATE_UNKNOWN = -1;
    public static final int ACTIVE_INPUT_STATE_YES = 1;
    public static final Api<CastOptions> API;
    public static final CastApi CastApi;
    public static final String EXTRA_APP_NO_LONGER_RUNNING = "com.google.android.gms.cast.EXTRA_APP_NO_LONGER_RUNNING";
    public static final int MAX_MESSAGE_LENGTH = 65536;
    public static final int MAX_NAMESPACE_LENGTH = 128;
    public static final int STANDBY_STATE_NO = 0;
    public static final int STANDBY_STATE_UNKNOWN = -1;
    public static final int STANDBY_STATE_YES = 1;
    static final com.google.android.gms.common.api.Api.zza<zzyl, CastOptions> zzahd;

    /* renamed from: com.google.android.gms.cast.Cast.1 */
    class C05681 extends com.google.android.gms.common.api.Api.zza<zzyl, CastOptions> {
        C05681() {
        }

        public zzyl zza(Context context, Looper looper, zzg com_google_android_gms_common_internal_zzg, CastOptions castOptions, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
            zzac.zzb((Object) castOptions, (Object) "Setting the API options is required.");
            return new zzyl(context, looper, com_google_android_gms_common_internal_zzg, castOptions.zzalZ, (long) castOptions.zzamb, castOptions.zzama, castOptions.extras, connectionCallbacks, onConnectionFailedListener);
        }
    }

    public interface ApplicationConnectionResult extends Result {
        ApplicationMetadata getApplicationMetadata();

        String getApplicationStatus();

        String getSessionId();

        boolean getWasLaunched();
    }

    static abstract class zza extends zzyi<ApplicationConnectionResult> {

        /* renamed from: com.google.android.gms.cast.Cast.zza.1 */
        class C05761 implements ApplicationConnectionResult {
            final /* synthetic */ Status zzamf;

            C05761(zza com_google_android_gms_cast_Cast_zza, Status status) {
                this.zzamf = status;
            }

            public ApplicationMetadata getApplicationMetadata() {
                return null;
            }

            public String getApplicationStatus() {
                return null;
            }

            public String getSessionId() {
                return null;
            }

            public Status getStatus() {
                return this.zzamf;
            }

            public boolean getWasLaunched() {
                return false;
            }
        }

        public zza(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        public void zza(zzyl com_google_android_gms_internal_zzyl) throws RemoteException {
        }

        public /* synthetic */ Result zzc(Status status) {
            return zzo(status);
        }

        public ApplicationConnectionResult zzo(Status status) {
            return new C05761(this, status);
        }
    }

    public interface CastApi {

        public static final class zza implements CastApi {

            /* renamed from: com.google.android.gms.cast.Cast.CastApi.zza.1 */
            class C05691 extends zzyq {
                final /* synthetic */ String zzIg;
                final /* synthetic */ String zzalV;

                C05691(zza com_google_android_gms_cast_Cast_CastApi_zza, GoogleApiClient googleApiClient, String str, String str2) {
                    this.zzalV = str;
                    this.zzIg = str2;
                    super(googleApiClient);
                }

                /* JADX WARNING: inconsistent code. */
                /* Code decompiled incorrectly, please refer to instructions dump. */
                public void zza(com.google.android.gms.internal.zzyl r3) throws android.os.RemoteException {
                    /*
                    r2 = this;
                    r0 = r2.zzalV;	 Catch:{ IllegalArgumentException -> 0x000f, IllegalStateException -> 0x0008 }
                    r1 = r2.zzIg;	 Catch:{ IllegalArgumentException -> 0x000f, IllegalStateException -> 0x0008 }
                    r3.zza(r0, r1, r2);	 Catch:{ IllegalArgumentException -> 0x000f, IllegalStateException -> 0x0008 }
                L_0x0007:
                    return;
                L_0x0008:
                    r0 = move-exception;
                L_0x0009:
                    r0 = 2001; // 0x7d1 float:2.804E-42 double:9.886E-321;
                    r2.zzch(r0);
                    goto L_0x0007;
                L_0x000f:
                    r0 = move-exception;
                    goto L_0x0009;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.cast.Cast.CastApi.zza.1.zza(com.google.android.gms.internal.zzyl):void");
                }
            }

            /* renamed from: com.google.android.gms.cast.Cast.CastApi.zza.2 */
            class C05702 extends zza {
                final /* synthetic */ String zzalW;

                C05702(zza com_google_android_gms_cast_Cast_CastApi_zza, GoogleApiClient googleApiClient, String str) {
                    this.zzalW = str;
                    super(googleApiClient);
                }

                public void zza(zzyl com_google_android_gms_internal_zzyl) throws RemoteException {
                    try {
                        com_google_android_gms_internal_zzyl.zza(this.zzalW, false, this);
                    } catch (IllegalStateException e) {
                        zzch(GamesStatusCodes.STATUS_REQUEST_UPDATE_TOTAL_FAILURE);
                    }
                }
            }

            /* renamed from: com.google.android.gms.cast.Cast.CastApi.zza.3 */
            class C05713 extends zza {
                final /* synthetic */ String zzalW;
                final /* synthetic */ LaunchOptions zzalX;

                C05713(zza com_google_android_gms_cast_Cast_CastApi_zza, GoogleApiClient googleApiClient, String str, LaunchOptions launchOptions) {
                    this.zzalW = str;
                    this.zzalX = launchOptions;
                    super(googleApiClient);
                }

                public void zza(zzyl com_google_android_gms_internal_zzyl) throws RemoteException {
                    try {
                        com_google_android_gms_internal_zzyl.zza(this.zzalW, this.zzalX, this);
                    } catch (IllegalStateException e) {
                        zzch(GamesStatusCodes.STATUS_REQUEST_UPDATE_TOTAL_FAILURE);
                    }
                }
            }

            /* renamed from: com.google.android.gms.cast.Cast.CastApi.zza.4 */
            class C05724 extends zza {
                final /* synthetic */ String val$sessionId;
                final /* synthetic */ String zzalW;
                final /* synthetic */ zzf zzalY;

                C05724(zza com_google_android_gms_cast_Cast_CastApi_zza, GoogleApiClient googleApiClient, String str, String str2, zzf com_google_android_gms_cast_zzf) {
                    this.zzalW = str;
                    this.val$sessionId = str2;
                    this.zzalY = com_google_android_gms_cast_zzf;
                    super(googleApiClient);
                }

                public void zza(zzyl com_google_android_gms_internal_zzyl) throws RemoteException {
                    try {
                        com_google_android_gms_internal_zzyl.zza(this.zzalW, this.val$sessionId, this.zzalY, this);
                    } catch (IllegalStateException e) {
                        zzch(GamesStatusCodes.STATUS_REQUEST_UPDATE_TOTAL_FAILURE);
                    }
                }
            }

            /* renamed from: com.google.android.gms.cast.Cast.CastApi.zza.5 */
            class C05735 extends zzyq {
                C05735(zza com_google_android_gms_cast_Cast_CastApi_zza, GoogleApiClient googleApiClient) {
                    super(googleApiClient);
                }

                public void zza(zzyl com_google_android_gms_internal_zzyl) throws RemoteException {
                    try {
                        com_google_android_gms_internal_zzyl.zzb(this);
                    } catch (IllegalStateException e) {
                        zzch(GamesStatusCodes.STATUS_REQUEST_UPDATE_TOTAL_FAILURE);
                    }
                }
            }

            /* renamed from: com.google.android.gms.cast.Cast.CastApi.zza.6 */
            class C05746 extends zzyq {
                C05746(zza com_google_android_gms_cast_Cast_CastApi_zza, GoogleApiClient googleApiClient) {
                    super(googleApiClient);
                }

                public void zza(zzyl com_google_android_gms_internal_zzyl) throws RemoteException {
                    try {
                        com_google_android_gms_internal_zzyl.zza(BuildConfig.FLAVOR, this);
                    } catch (IllegalStateException e) {
                        zzch(GamesStatusCodes.STATUS_REQUEST_UPDATE_TOTAL_FAILURE);
                    }
                }
            }

            /* renamed from: com.google.android.gms.cast.Cast.CastApi.zza.7 */
            class C05757 extends zzyq {
                final /* synthetic */ String val$sessionId;

                C05757(zza com_google_android_gms_cast_Cast_CastApi_zza, GoogleApiClient googleApiClient, String str) {
                    this.val$sessionId = str;
                    super(googleApiClient);
                }

                public void zza(zzyl com_google_android_gms_internal_zzyl) throws RemoteException {
                    if (TextUtils.isEmpty(this.val$sessionId)) {
                        zze(GamesStatusCodes.STATUS_REQUEST_UPDATE_TOTAL_FAILURE, "IllegalArgument: sessionId cannot be null or empty");
                        return;
                    }
                    try {
                        com_google_android_gms_internal_zzyl.zza(this.val$sessionId, this);
                    } catch (IllegalStateException e) {
                        zzch(GamesStatusCodes.STATUS_REQUEST_UPDATE_TOTAL_FAILURE);
                    }
                }
            }

            public int getActiveInputState(GoogleApiClient googleApiClient) throws IllegalStateException {
                return ((zzyl) googleApiClient.zza(zzyt.zzavu)).getActiveInputState();
            }

            public ApplicationMetadata getApplicationMetadata(GoogleApiClient googleApiClient) throws IllegalStateException {
                return ((zzyl) googleApiClient.zza(zzyt.zzavu)).getApplicationMetadata();
            }

            public String getApplicationStatus(GoogleApiClient googleApiClient) throws IllegalStateException {
                return ((zzyl) googleApiClient.zza(zzyt.zzavu)).getApplicationStatus();
            }

            public int getStandbyState(GoogleApiClient googleApiClient) throws IllegalStateException {
                return ((zzyl) googleApiClient.zza(zzyt.zzavu)).getStandbyState();
            }

            public double getVolume(GoogleApiClient googleApiClient) throws IllegalStateException {
                return ((zzyl) googleApiClient.zza(zzyt.zzavu)).getVolume();
            }

            public boolean isMute(GoogleApiClient googleApiClient) throws IllegalStateException {
                return ((zzyl) googleApiClient.zza(zzyt.zzavu)).isMute();
            }

            public PendingResult<ApplicationConnectionResult> joinApplication(GoogleApiClient googleApiClient) {
                return zza(googleApiClient, null, null, null);
            }

            public PendingResult<ApplicationConnectionResult> joinApplication(GoogleApiClient googleApiClient, String str) {
                return zza(googleApiClient, str, null, null);
            }

            public PendingResult<ApplicationConnectionResult> joinApplication(GoogleApiClient googleApiClient, String str, String str2) {
                return zza(googleApiClient, str, str2, null);
            }

            public PendingResult<ApplicationConnectionResult> launchApplication(GoogleApiClient googleApiClient, String str) {
                return googleApiClient.zzb(new C05702(this, googleApiClient, str));
            }

            public PendingResult<ApplicationConnectionResult> launchApplication(GoogleApiClient googleApiClient, String str, LaunchOptions launchOptions) {
                return googleApiClient.zzb(new C05713(this, googleApiClient, str, launchOptions));
            }

            @Deprecated
            public PendingResult<ApplicationConnectionResult> launchApplication(GoogleApiClient googleApiClient, String str, boolean z) {
                return launchApplication(googleApiClient, str, new Builder().setRelaunchIfRunning(z).build());
            }

            public PendingResult<Status> leaveApplication(GoogleApiClient googleApiClient) {
                return googleApiClient.zzb(new C05735(this, googleApiClient));
            }

            public void removeMessageReceivedCallbacks(GoogleApiClient googleApiClient, String str) throws IOException, IllegalArgumentException {
                try {
                    ((zzyl) googleApiClient.zza(zzyt.zzavu)).removeMessageReceivedCallbacks(str);
                } catch (RemoteException e) {
                    throw new IOException("service error");
                }
            }

            public void requestStatus(GoogleApiClient googleApiClient) throws IOException, IllegalStateException {
                try {
                    ((zzyl) googleApiClient.zza(zzyt.zzavu)).requestStatus();
                } catch (RemoteException e) {
                    throw new IOException("service error");
                }
            }

            public PendingResult<Status> sendMessage(GoogleApiClient googleApiClient, String str, String str2) {
                return googleApiClient.zzb(new C05691(this, googleApiClient, str, str2));
            }

            public void setMessageReceivedCallbacks(GoogleApiClient googleApiClient, String str, MessageReceivedCallback messageReceivedCallback) throws IOException, IllegalStateException {
                try {
                    ((zzyl) googleApiClient.zza(zzyt.zzavu)).setMessageReceivedCallbacks(str, messageReceivedCallback);
                } catch (RemoteException e) {
                    throw new IOException("service error");
                }
            }

            public void setMute(GoogleApiClient googleApiClient, boolean z) throws IOException, IllegalStateException {
                try {
                    ((zzyl) googleApiClient.zza(zzyt.zzavu)).setMute(z);
                } catch (RemoteException e) {
                    throw new IOException("service error");
                }
            }

            public void setVolume(GoogleApiClient googleApiClient, double d) throws IOException, IllegalArgumentException, IllegalStateException {
                try {
                    ((zzyl) googleApiClient.zza(zzyt.zzavu)).setVolume(d);
                } catch (RemoteException e) {
                    throw new IOException("service error");
                }
            }

            public PendingResult<Status> stopApplication(GoogleApiClient googleApiClient) {
                return googleApiClient.zzb(new C05746(this, googleApiClient));
            }

            public PendingResult<Status> stopApplication(GoogleApiClient googleApiClient, String str) {
                return googleApiClient.zzb(new C05757(this, googleApiClient, str));
            }

            public PendingResult<ApplicationConnectionResult> zza(GoogleApiClient googleApiClient, String str, String str2, zzf com_google_android_gms_cast_zzf) {
                return googleApiClient.zzb(new C05724(this, googleApiClient, str, str2, com_google_android_gms_cast_zzf));
            }
        }

        int getActiveInputState(GoogleApiClient googleApiClient) throws IllegalStateException;

        ApplicationMetadata getApplicationMetadata(GoogleApiClient googleApiClient) throws IllegalStateException;

        String getApplicationStatus(GoogleApiClient googleApiClient) throws IllegalStateException;

        int getStandbyState(GoogleApiClient googleApiClient) throws IllegalStateException;

        double getVolume(GoogleApiClient googleApiClient) throws IllegalStateException;

        boolean isMute(GoogleApiClient googleApiClient) throws IllegalStateException;

        PendingResult<ApplicationConnectionResult> joinApplication(GoogleApiClient googleApiClient);

        PendingResult<ApplicationConnectionResult> joinApplication(GoogleApiClient googleApiClient, String str);

        PendingResult<ApplicationConnectionResult> joinApplication(GoogleApiClient googleApiClient, String str, String str2);

        PendingResult<ApplicationConnectionResult> launchApplication(GoogleApiClient googleApiClient, String str);

        PendingResult<ApplicationConnectionResult> launchApplication(GoogleApiClient googleApiClient, String str, LaunchOptions launchOptions);

        @Deprecated
        PendingResult<ApplicationConnectionResult> launchApplication(GoogleApiClient googleApiClient, String str, boolean z);

        PendingResult<Status> leaveApplication(GoogleApiClient googleApiClient);

        void removeMessageReceivedCallbacks(GoogleApiClient googleApiClient, String str) throws IOException, IllegalArgumentException;

        void requestStatus(GoogleApiClient googleApiClient) throws IOException, IllegalStateException;

        PendingResult<Status> sendMessage(GoogleApiClient googleApiClient, String str, String str2);

        void setMessageReceivedCallbacks(GoogleApiClient googleApiClient, String str, MessageReceivedCallback messageReceivedCallback) throws IOException, IllegalStateException;

        void setMute(GoogleApiClient googleApiClient, boolean z) throws IOException, IllegalStateException;

        void setVolume(GoogleApiClient googleApiClient, double d) throws IOException, IllegalArgumentException, IllegalStateException;

        PendingResult<Status> stopApplication(GoogleApiClient googleApiClient);

        PendingResult<Status> stopApplication(GoogleApiClient googleApiClient, String str);
    }

    public static final class CastOptions implements HasOptions {
        final Bundle extras;
        final CastDevice zzalZ;
        final Listener zzama;
        private final int zzamb;

        public static final class Builder {
            private Bundle mExtras;
            CastDevice zzamc;
            Listener zzamd;
            private int zzame;

            public Builder(CastDevice castDevice, Listener listener) {
                zzac.zzb((Object) castDevice, (Object) "CastDevice parameter cannot be null");
                zzac.zzb((Object) listener, (Object) "CastListener parameter cannot be null");
                this.zzamc = castDevice;
                this.zzamd = listener;
                this.zzame = Cast.STANDBY_STATE_NO;
            }

            public CastOptions build() {
                return new CastOptions();
            }

            public Builder setVerboseLoggingEnabled(boolean z) {
                if (z) {
                    this.zzame |= Cast.STANDBY_STATE_YES;
                } else {
                    this.zzame &= -2;
                }
                return this;
            }

            public Builder zzk(Bundle bundle) {
                this.mExtras = bundle;
                return this;
            }
        }

        private CastOptions(Builder builder) {
            this.zzalZ = builder.zzamc;
            this.zzama = builder.zzamd;
            this.zzamb = builder.zzame;
            this.extras = builder.mExtras;
        }

        @Deprecated
        public static Builder builder(CastDevice castDevice, Listener listener) {
            return new Builder(castDevice, listener);
        }
    }

    public static class Listener {
        public void onActiveInputStateChanged(int i) {
        }

        public void onApplicationDisconnected(int i) {
        }

        public void onApplicationMetadataChanged(ApplicationMetadata applicationMetadata) {
        }

        public void onApplicationStatusChanged() {
        }

        public void onStandbyStateChanged(int i) {
        }

        public void onVolumeChanged() {
        }
    }

    public interface MessageReceivedCallback {
        void onMessageReceived(CastDevice castDevice, String str, String str2);
    }

    static {
        zzahd = new C05681();
        API = new Api("Cast.API", zzahd, zzyt.zzavu);
        CastApi = new zza();
    }

    private Cast() {
    }
}
