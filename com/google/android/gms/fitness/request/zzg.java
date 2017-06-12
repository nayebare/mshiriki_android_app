package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.zzaa;
import com.google.android.gms.fitness.data.DataSet;
import com.google.android.gms.internal.zzaos;

public class zzg extends zza {
    public static final Creator<zzg> CREATOR;
    private final int mVersionCode;
    private final DataSet zzaTM;
    private final zzaos zzaUS;
    private final boolean zzaUZ;

    static {
        CREATOR = new zzh();
    }

    zzg(int i, DataSet dataSet, IBinder iBinder, boolean z) {
        this.mVersionCode = i;
        this.zzaTM = dataSet;
        this.zzaUS = zzaos.zza.zzcJ(iBinder);
        this.zzaUZ = z;
    }

    public zzg(DataSet dataSet, zzaos com_google_android_gms_internal_zzaos, boolean z) {
        this.mVersionCode = 4;
        this.zzaTM = dataSet;
        this.zzaUS = com_google_android_gms_internal_zzaos;
        this.zzaUZ = z;
    }

    private boolean zzc(zzg com_google_android_gms_fitness_request_zzg) {
        return zzaa.equal(this.zzaTM, com_google_android_gms_fitness_request_zzg.zzaTM);
    }

    public boolean equals(Object obj) {
        return obj == this || ((obj instanceof zzg) && zzc((zzg) obj));
    }

    public IBinder getCallbackBinder() {
        return this.zzaUS == null ? null : this.zzaUS.asBinder();
    }

    public DataSet getDataSet() {
        return this.zzaTM;
    }

    int getVersionCode() {
        return this.mVersionCode;
    }

    public int hashCode() {
        return zzaa.hashCode(this.zzaTM);
    }

    public String toString() {
        return zzaa.zzv(this).zzg("dataSet", this.zzaTM).toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzh.zza(this, parcel, i);
    }

    public boolean zzCc() {
        return this.zzaUZ;
    }
}
