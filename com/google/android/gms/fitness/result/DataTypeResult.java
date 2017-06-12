package com.google.android.gms.fitness.result;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.zzaa;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.games.Games;

public class DataTypeResult extends zza implements Result {
    public static final Creator<DataTypeResult> CREATOR;
    private final int mVersionCode;
    private final DataType zzaRK;
    private final Status zzahq;

    static {
        CREATOR = new zzi();
    }

    DataTypeResult(int i, Status status, DataType dataType) {
        this.mVersionCode = i;
        this.zzahq = status;
        this.zzaRK = dataType;
    }

    public DataTypeResult(Status status, DataType dataType) {
        this.mVersionCode = 2;
        this.zzahq = status;
        this.zzaRK = dataType;
    }

    public static DataTypeResult zzae(Status status) {
        return new DataTypeResult(status, null);
    }

    private boolean zzb(DataTypeResult dataTypeResult) {
        return this.zzahq.equals(dataTypeResult.zzahq) && zzaa.equal(this.zzaRK, dataTypeResult.zzaRK);
    }

    public boolean equals(Object obj) {
        return this == obj || ((obj instanceof DataTypeResult) && zzb((DataTypeResult) obj));
    }

    public DataType getDataType() {
        return this.zzaRK;
    }

    public Status getStatus() {
        return this.zzahq;
    }

    int getVersionCode() {
        return this.mVersionCode;
    }

    public int hashCode() {
        return zzaa.hashCode(this.zzahq, this.zzaRK);
    }

    public String toString() {
        return zzaa.zzv(this).zzg(Games.EXTRA_STATUS, this.zzahq).zzg("dataType", this.zzaRK).toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzi.zza(this, parcel, i);
    }
}
