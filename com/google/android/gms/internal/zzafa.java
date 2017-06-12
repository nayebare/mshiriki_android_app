package com.google.android.gms.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.RemoteException;
import com.google.android.gms.awareness.AwarenessOptions;
import com.google.android.gms.awareness.fence.FenceQueryResult;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.zzg;
import com.google.android.gms.common.internal.zzl;
import com.google.android.gms.internal.zzcb.zza;
import com.google.android.gms.internal.zzzv.zzb;

public class zzafa extends zzl<zzafg> {
    private static zza zzaIs;
    private final zzafb zzaIt;
    private zzcg<com.google.android.gms.awareness.fence.zza, zzaeb> zzaIu;
    private final Looper zzrx;

    static {
        zzaIs = zza.zzrs;
    }

    public zzafa(Context context, Looper looper, zzg com_google_android_gms_common_internal_zzg, AwarenessOptions awarenessOptions, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
        super(context, looper, 47, com_google_android_gms_common_internal_zzg, connectionCallbacks, onConnectionFailedListener);
        this.zzrx = looper;
        String str = com_google_android_gms_common_internal_zzg.getAccount() == null ? "@@ContextManagerNullAccount@@" : com_google_android_gms_common_internal_zzg.getAccount().name;
        this.zzaIt = awarenessOptions == null ? zzafb.zzz(context, str) : zzafb.zza(context, str, awarenessOptions);
    }

    public static Handler zza(Looper looper) {
        return zzaIs == null ? zza.zzrs.zza(looper) : zzaIs.zza(looper);
    }

    private zzcg<com.google.android.gms.awareness.fence.zza, zzaeb> zzzt() {
        if (this.zzaIu == null) {
            this.zzaIu = new zzcg(this.zzrx, zzaeb.zzaHO);
        }
        return this.zzaIu;
    }

    public void zza(zzb<FenceQueryResult> com_google_android_gms_internal_zzzv_zzb_com_google_android_gms_awareness_fence_FenceQueryResult, zzaeg com_google_android_gms_internal_zzaeg) throws RemoteException {
        zzwV();
        ((zzafg) zzwW()).zza(zzafd.zze(com_google_android_gms_internal_zzzv_zzb_com_google_android_gms_awareness_fence_FenceQueryResult), this.zzaIt.packageName, this.zzaIt.zzaIv, this.zzaIt.moduleId, com_google_android_gms_internal_zzaeg);
    }

    public void zza(zzb<Status> com_google_android_gms_internal_zzzv_zzb_com_google_android_gms_common_api_Status, zzaeo com_google_android_gms_internal_zzaeo) throws RemoteException {
        zzwV();
        com_google_android_gms_internal_zzaeo.zza(zzzt());
        ((zzafg) zzwW()).zza(zzafd.zza((zzb) com_google_android_gms_internal_zzzv_zzb_com_google_android_gms_common_api_Status, null), this.zzaIt.packageName, this.zzaIt.zzaIv, this.zzaIt.moduleId, com_google_android_gms_internal_zzaeo);
    }

    public void zza(zzb<zzwl> com_google_android_gms_internal_zzzv_zzb_com_google_android_gms_internal_zzwl, zzwj com_google_android_gms_internal_zzwj) throws RemoteException {
        zzwV();
        ((zzafg) zzwW()).zza(zzafd.zzd(com_google_android_gms_internal_zzzv_zzb_com_google_android_gms_internal_zzwl), this.zzaIt.packageName, this.zzaIt.zzaIv, this.zzaIt.moduleId, com_google_android_gms_internal_zzwj);
    }

    protected zzafg zzbG(IBinder iBinder) {
        return zzafg.zza.zzbJ(iBinder);
    }

    protected String zzeu() {
        return "com.google.android.contextmanager.service.ContextManagerService.START";
    }

    protected String zzev() {
        return "com.google.android.gms.contextmanager.internal.IContextManagerService";
    }

    protected /* synthetic */ IInterface zzh(IBinder iBinder) {
        return zzbG(iBinder);
    }

    protected Bundle zzql() {
        Bundle bundle = new Bundle();
        bundle.putByteArray("com.google.android.contextmanager.service.args", this.zzaIt.toByteArray());
        return bundle;
    }

    public boolean zzwX() {
        return false;
    }
}
