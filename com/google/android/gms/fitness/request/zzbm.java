package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.zzaa;
import com.google.android.gms.fitness.data.Subscription;
import com.google.android.gms.internal.zzaos;

public class zzbm extends zza {
    public static final Creator<zzbm> CREATOR;
    private final int mVersionCode;
    private final zzaos zzaUS;
    private Subscription zzaWk;
    private final boolean zzaWl;

    static {
        CREATOR = new zzbn();
    }

    zzbm(int i, Subscription subscription, boolean z, IBinder iBinder) {
        this.mVersionCode = i;
        this.zzaWk = subscription;
        this.zzaWl = z;
        this.zzaUS = zzaos.zza.zzcJ(iBinder);
    }

    public zzbm(Subscription subscription, boolean z, zzaos com_google_android_gms_internal_zzaos) {
        this.mVersionCode = 3;
        this.zzaWk = subscription;
        this.zzaWl = z;
        this.zzaUS = com_google_android_gms_internal_zzaos;
    }

    public IBinder getCallbackBinder() {
        return this.zzaUS == null ? null : this.zzaUS.asBinder();
    }

    int getVersionCode() {
        return this.mVersionCode;
    }

    public String toString() {
        return zzaa.zzv(this).zzg("subscription", this.zzaWk).toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzbn.zza(this, parcel, i);
    }

    public boolean zzCA() {
        return this.zzaWl;
    }

    public Subscription zzCz() {
        return this.zzaWk;
    }
}
