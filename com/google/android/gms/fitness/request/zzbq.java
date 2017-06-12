package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.zzaa;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.internal.zzaos;

public class zzbq extends zza {
    public static final Creator<zzbq> CREATOR;
    private final int mVersionCode;
    private final DataSource zzaRJ;
    private final DataType zzaRK;
    private final zzaos zzaUS;

    static {
        CREATOR = new zzbr();
    }

    zzbq(int i, DataType dataType, DataSource dataSource, IBinder iBinder) {
        this.mVersionCode = i;
        this.zzaRK = dataType;
        this.zzaRJ = dataSource;
        this.zzaUS = zzaos.zza.zzcJ(iBinder);
    }

    public zzbq(DataType dataType, DataSource dataSource, zzaos com_google_android_gms_internal_zzaos) {
        this.mVersionCode = 3;
        this.zzaRK = dataType;
        this.zzaRJ = dataSource;
        this.zzaUS = com_google_android_gms_internal_zzaos;
    }

    private boolean zzb(zzbq com_google_android_gms_fitness_request_zzbq) {
        return zzaa.equal(this.zzaRJ, com_google_android_gms_fitness_request_zzbq.zzaRJ) && zzaa.equal(this.zzaRK, com_google_android_gms_fitness_request_zzbq.zzaRK);
    }

    public boolean equals(Object obj) {
        return this == obj || ((obj instanceof zzbq) && zzb((zzbq) obj));
    }

    public IBinder getCallbackBinder() {
        return this.zzaUS == null ? null : this.zzaUS.asBinder();
    }

    public DataSource getDataSource() {
        return this.zzaRJ;
    }

    public DataType getDataType() {
        return this.zzaRK;
    }

    int getVersionCode() {
        return this.mVersionCode;
    }

    public int hashCode() {
        return zzaa.hashCode(this.zzaRJ, this.zzaRK);
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzbr.zza(this, parcel, i);
    }
}
