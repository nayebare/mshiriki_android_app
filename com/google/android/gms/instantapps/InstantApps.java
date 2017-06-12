package com.google.android.gms.instantapps;

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
import com.google.android.gms.internal.zzaqp;
import com.google.android.gms.internal.zzaqq;
import com.google.android.gms.internal.zzaqw;

public final class InstantApps {
    public static final Api<NoOptions> API;
    public static final InstantAppsApi InstantAppsApi;
    private static final zzf<zzaqq> zzahc;
    private static final zza<zzaqq, NoOptions> zzahd;

    /* renamed from: com.google.android.gms.instantapps.InstantApps.1 */
    class C08761 extends zza<zzaqq, NoOptions> {
        C08761() {
        }

        public /* synthetic */ zze zza(Context context, Looper looper, zzg com_google_android_gms_common_internal_zzg, Object obj, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
            return zzp(context, looper, com_google_android_gms_common_internal_zzg, (NoOptions) obj, connectionCallbacks, onConnectionFailedListener);
        }

        public zzaqq zzp(Context context, Looper looper, zzg com_google_android_gms_common_internal_zzg, NoOptions noOptions, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
            return new zzaqq(context, looper, connectionCallbacks, onConnectionFailedListener);
        }
    }

    static {
        zzahc = new zzf();
        zzahd = new C08761();
        API = new Api("InstantApps.API", zzahd, zzahc);
        InstantAppsApi = new zzaqp();
    }

    private InstantApps() {
    }

    public static PackageManagerWrapper getPackageManager(Context context, boolean z) {
        return zzaqw.zzh(context, z);
    }
}
