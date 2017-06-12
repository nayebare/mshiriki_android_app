package com.google.android.gms.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.internal.zzg;
import com.google.android.gms.common.internal.zzl;
import com.google.android.gms.internal.zzarr.zza;

public class zzari extends zzl<zzarr> {
    private final String zzbjU;
    protected final zzasb<zzarr> zzbjV;

    /* renamed from: com.google.android.gms.internal.zzari.1 */
    class C10021 implements zzasb<zzarr> {
        final /* synthetic */ zzari zzbjW;

        C10021(zzari com_google_android_gms_internal_zzari) {
            this.zzbjW = com_google_android_gms_internal_zzari;
        }

        public zzarr zzHz() throws DeadObjectException {
            return (zzarr) this.zzbjW.zzwW();
        }

        public void zzwV() {
            this.zzbjW.zzwV();
        }

        public /* synthetic */ IInterface zzwW() throws DeadObjectException {
            return zzHz();
        }
    }

    public zzari(Context context, Looper looper, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener, String str, zzg com_google_android_gms_common_internal_zzg) {
        super(context, looper, 23, com_google_android_gms_common_internal_zzg, connectionCallbacks, onConnectionFailedListener);
        this.zzbjV = new C10021(this);
        this.zzbjU = str;
    }

    protected zzarr zzdf(IBinder iBinder) {
        return zza.zzdi(iBinder);
    }

    protected String zzeu() {
        return "com.google.android.location.internal.GoogleLocationManagerService.START";
    }

    protected String zzev() {
        return "com.google.android.gms.location.internal.IGoogleLocationManagerService";
    }

    protected /* synthetic */ IInterface zzh(IBinder iBinder) {
        return zzdf(iBinder);
    }

    protected Bundle zzql() {
        Bundle bundle = new Bundle();
        bundle.putString("client_name", this.zzbjU);
        return bundle;
    }
}
