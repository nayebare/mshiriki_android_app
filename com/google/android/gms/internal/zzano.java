package com.google.android.gms.internal;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.zzg;
import com.google.android.gms.common.internal.zzl;
import com.google.android.gms.fitness.zza;
import java.util.Set;

public abstract class zzano<T extends IInterface> extends zzl<T> {
    protected zzano(Context context, Looper looper, int i, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener, zzg com_google_android_gms_common_internal_zzg) {
        super(context, looper, i, com_google_android_gms_common_internal_zzg, connectionCallbacks, onConnectionFailedListener);
    }

    protected Set<Scope> zzc(Set<Scope> set) {
        return zza.zzj(set);
    }

    public abstract String zzeu();

    public abstract String zzev();

    public abstract T zzh(IBinder iBinder);

    public boolean zzqD() {
        return !zzanl.zzaW(getContext());
    }

    public boolean zzwX() {
        return true;
    }
}
