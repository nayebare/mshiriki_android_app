package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.annotation.KeepName;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.zzaa;
import com.google.android.gms.internal.zzanh;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

@KeepName
public final class RawDataPoint extends zza {
    public static final Creator<RawDataPoint> CREATOR;
    final int versionCode;
    public final long zzaTA;
    public final long zzaTB;
    public final Value[] zzaTC;
    public final int zzaTD;
    public final int zzaTE;
    public final long zzaTF;
    public final long zzaTG;

    static {
        CREATOR = new zzy();
    }

    public RawDataPoint(int i, long j, long j2, Value[] valueArr, int i2, int i3, long j3, long j4) {
        this.versionCode = i;
        this.zzaTA = j;
        this.zzaTB = j2;
        this.zzaTD = i2;
        this.zzaTE = i3;
        this.zzaTF = j3;
        this.zzaTG = j4;
        this.zzaTC = valueArr;
    }

    RawDataPoint(DataPoint dataPoint, List<DataSource> list) {
        this.versionCode = 4;
        this.zzaTA = dataPoint.getTimestamp(TimeUnit.NANOSECONDS);
        this.zzaTB = dataPoint.getStartTime(TimeUnit.NANOSECONDS);
        this.zzaTC = dataPoint.zzBk();
        this.zzaTD = zzanh.zza(dataPoint.getDataSource(), list);
        this.zzaTE = zzanh.zza(dataPoint.zzBl(), list);
        this.zzaTF = dataPoint.zzBm();
        this.zzaTG = dataPoint.zzBn();
    }

    private boolean zza(RawDataPoint rawDataPoint) {
        return this.zzaTA == rawDataPoint.zzaTA && this.zzaTB == rawDataPoint.zzaTB && Arrays.equals(this.zzaTC, rawDataPoint.zzaTC) && this.zzaTD == rawDataPoint.zzaTD && this.zzaTE == rawDataPoint.zzaTE && this.zzaTF == rawDataPoint.zzaTF;
    }

    public boolean equals(Object obj) {
        return this == obj || ((obj instanceof RawDataPoint) && zza((RawDataPoint) obj));
    }

    public int hashCode() {
        return zzaa.hashCode(Long.valueOf(this.zzaTA), Long.valueOf(this.zzaTB));
    }

    public String toString() {
        return String.format("RawDataPoint{%s@[%s, %s](%d,%d)}", new Object[]{Arrays.toString(this.zzaTC), Long.valueOf(this.zzaTB), Long.valueOf(this.zzaTA), Integer.valueOf(this.zzaTD), Integer.valueOf(this.zzaTE)});
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzy.zza(this, parcel, i);
    }
}
