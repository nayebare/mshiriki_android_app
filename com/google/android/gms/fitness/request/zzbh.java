package com.google.android.gms.fitness.request;

import android.app.PendingIntent;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.zzaa;
import com.google.android.gms.internal.zzaos;

public class zzbh extends zza {
    public static final Creator<zzbh> CREATOR;
    private final PendingIntent mPendingIntent;
    private final int mVersionCode;
    private final zzaos zzaUS;

    static {
        CREATOR = new zzbi();
    }

    zzbh(int i, PendingIntent pendingIntent, IBinder iBinder) {
        this.mVersionCode = i;
        this.mPendingIntent = pendingIntent;
        this.zzaUS = zzaos.zza.zzcJ(iBinder);
    }

    public zzbh(PendingIntent pendingIntent, zzaos com_google_android_gms_internal_zzaos) {
        this.mVersionCode = 5;
        this.mPendingIntent = pendingIntent;
        this.zzaUS = com_google_android_gms_internal_zzaos;
    }

    private boolean zzb(zzbh com_google_android_gms_fitness_request_zzbh) {
        return zzaa.equal(this.mPendingIntent, com_google_android_gms_fitness_request_zzbh.mPendingIntent);
    }

    public boolean equals(Object obj) {
        return this == obj || ((obj instanceof zzbh) && zzb((zzbh) obj));
    }

    public IBinder getCallbackBinder() {
        return this.zzaUS == null ? null : this.zzaUS.asBinder();
    }

    public PendingIntent getIntent() {
        return this.mPendingIntent;
    }

    int getVersionCode() {
        return this.mVersionCode;
    }

    public int hashCode() {
        return zzaa.hashCode(this.mPendingIntent);
    }

    public String toString() {
        return zzaa.zzv(this).zzg("pendingIntent", this.mPendingIntent).toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzbi.zza(this, parcel, i);
    }
}
