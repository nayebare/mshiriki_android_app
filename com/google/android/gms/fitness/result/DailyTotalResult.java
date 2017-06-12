package com.google.android.gms.fitness.result;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.annotation.Nullable;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.zzaa;
import com.google.android.gms.fitness.data.DataSet;
import com.google.android.gms.fitness.data.DataSource.Builder;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.games.Games;

public class DailyTotalResult extends zza implements Result {
    public static final Creator<DailyTotalResult> CREATOR;
    private final int mVersionCode;
    private final DataSet zzaTM;
    private final Status zzahq;

    static {
        CREATOR = new zzb();
    }

    DailyTotalResult(int i, Status status, DataSet dataSet) {
        this.mVersionCode = i;
        this.zzahq = status;
        this.zzaTM = dataSet;
    }

    public DailyTotalResult(DataSet dataSet, Status status) {
        this.mVersionCode = 1;
        this.zzahq = status;
        this.zzaTM = dataSet;
    }

    public static DailyTotalResult zza(Status status, DataType dataType) {
        return new DailyTotalResult(DataSet.create(new Builder().setDataType(dataType).setType(1).build()), status);
    }

    private boolean zzb(DailyTotalResult dailyTotalResult) {
        return this.zzahq.equals(dailyTotalResult.zzahq) && zzaa.equal(this.zzaTM, dailyTotalResult.zzaTM);
    }

    public boolean equals(Object obj) {
        return this == obj || ((obj instanceof DailyTotalResult) && zzb((DailyTotalResult) obj));
    }

    public Status getStatus() {
        return this.zzahq;
    }

    @Nullable
    public DataSet getTotal() {
        return this.zzaTM;
    }

    int getVersionCode() {
        return this.mVersionCode;
    }

    public int hashCode() {
        return zzaa.hashCode(this.zzahq, this.zzaTM);
    }

    public String toString() {
        return zzaa.zzv(this).zzg(Games.EXTRA_STATUS, this.zzahq).zzg("dataPoint", this.zzaTM).toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzb.zza(this, parcel, i);
    }
}
