package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.annotation.KeepName;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.zzaa;
import com.google.android.gms.internal.zzanh;
import java.util.List;

@KeepName
public final class RawDataSet extends zza {
    public static final Creator<RawDataSet> CREATOR;
    final int mVersionCode;
    public final boolean zzaQZ;
    public final int zzaTD;
    public final int zzaTH;
    public final List<RawDataPoint> zzaTI;

    static {
        CREATOR = new zzz();
    }

    public RawDataSet(int i, int i2, int i3, List<RawDataPoint> list, boolean z) {
        this.mVersionCode = i;
        this.zzaTD = i2;
        this.zzaTH = i3;
        this.zzaTI = list;
        this.zzaQZ = z;
    }

    public RawDataSet(DataSet dataSet, List<DataSource> list, List<DataType> list2) {
        this.mVersionCode = 3;
        this.zzaTI = dataSet.zzA(list);
        this.zzaQZ = dataSet.zzBh();
        this.zzaTD = zzanh.zza(dataSet.getDataSource(), list);
        this.zzaTH = zzanh.zza(dataSet.getDataType(), list2);
    }

    private boolean zza(RawDataSet rawDataSet) {
        return this.zzaTD == rawDataSet.zzaTD && this.zzaQZ == rawDataSet.zzaQZ && zzaa.equal(this.zzaTI, rawDataSet.zzaTI);
    }

    public boolean equals(Object obj) {
        return this == obj || ((obj instanceof RawDataSet) && zza((RawDataSet) obj));
    }

    public int hashCode() {
        return zzaa.hashCode(Integer.valueOf(this.zzaTD));
    }

    public String toString() {
        return String.format("RawDataSet{%s@[%s]}", new Object[]{Integer.valueOf(this.zzaTD), this.zzaTI});
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzz.zza(this, parcel, i);
    }
}
