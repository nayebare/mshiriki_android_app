package com.google.android.gms.auth.account;

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
import com.google.android.gms.internal.zzul;
import com.google.android.gms.internal.zzum;

public class WorkAccount {
    public static final Api<NoOptions> API;
    public static final WorkAccountApi WorkAccountApi;
    private static final zzf<zzum> zzahc;
    private static final zza<zzum, NoOptions> zzahd;

    /* renamed from: com.google.android.gms.auth.account.WorkAccount.1 */
    class C05451 extends zza<zzum, NoOptions> {
        C05451() {
        }

        public /* synthetic */ zze zza(Context context, Looper looper, zzg com_google_android_gms_common_internal_zzg, Object obj, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
            return zzc(context, looper, com_google_android_gms_common_internal_zzg, (NoOptions) obj, connectionCallbacks, onConnectionFailedListener);
        }

        public zzum zzc(Context context, Looper looper, zzg com_google_android_gms_common_internal_zzg, NoOptions noOptions, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
            return new zzum(context, looper, com_google_android_gms_common_internal_zzg, connectionCallbacks, onConnectionFailedListener);
        }
    }

    static {
        zzahc = new zzf();
        zzahd = new C05451();
        API = new Api("WorkAccount.API", zzahd, zzahc);
        WorkAccountApi = new zzul();
    }

    private WorkAccount() {
    }
}
