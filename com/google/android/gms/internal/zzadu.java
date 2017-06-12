package com.google.android.gms.internal;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.awareness.AwarenessOptions;
import com.google.android.gms.awareness.FenceApi;
import com.google.android.gms.awareness.SnapshotApi;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.zza;
import com.google.android.gms.common.api.Api.zzf;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.internal.zzg;

public final class zzadu {
    public static final Api<AwarenessOptions> API;
    public static final FenceApi FenceApi;
    public static final SnapshotApi SnapshotApi;
    public static final zzf<zzafa> zzahc;
    private static final zza<zzafa, AwarenessOptions> zzahd;

    /* renamed from: com.google.android.gms.internal.zzadu.1 */
    class C09131 extends zza<zzafa, AwarenessOptions> {
        C09131() {
        }

        public zzafa zza(Context context, Looper looper, zzg com_google_android_gms_common_internal_zzg, AwarenessOptions awarenessOptions, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
            return new zzafa(context, looper, com_google_android_gms_common_internal_zzg, awarenessOptions, connectionCallbacks, onConnectionFailedListener);
        }
    }

    static {
        zzahc = new zzf();
        FenceApi = new zzadz();
        SnapshotApi = new zzwh();
        zzahd = new C09131();
        API = new Api("ContextManager.API", zzahd, zzahc);
    }
}
