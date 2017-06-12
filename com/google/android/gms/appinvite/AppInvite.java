package com.google.android.gms.appinvite;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.ApiOptions.NoOptions;
import com.google.android.gms.common.api.Api.zza;
import com.google.android.gms.common.api.Api.zze;
import com.google.android.gms.common.api.Api.zzf;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.internal.zzg;
import com.google.android.gms.internal.zzug;
import com.google.android.gms.internal.zzuh;

public final class AppInvite {
    public static final Api<NoOptions> API;
    public static final AppInviteApi AppInviteApi;
    public static final zzf<zzuh> zzahc;
    private static final zza<zzuh, NoOptions> zzahd;

    /* renamed from: com.google.android.gms.appinvite.AppInvite.1 */
    class C05411 extends zza<zzuh, NoOptions> {
        C05411() {
        }

        public /* synthetic */ zze zza(Context context, Looper looper, zzg com_google_android_gms_common_internal_zzg, Object obj, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
            return zzb(context, looper, com_google_android_gms_common_internal_zzg, (NoOptions) obj, connectionCallbacks, onConnectionFailedListener);
        }

        public zzuh zzb(Context context, Looper looper, zzg com_google_android_gms_common_internal_zzg, NoOptions noOptions, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
            return new zzuh(context, looper, connectionCallbacks, onConnectionFailedListener, com_google_android_gms_common_internal_zzg);
        }
    }

    static {
        zzahc = new zzf();
        zzahd = new C05411();
        API = new Api("AppInvite.API", zzahd, zzahc);
        AppInviteApi = new zzug();
    }

    private AppInvite() {
    }
}
