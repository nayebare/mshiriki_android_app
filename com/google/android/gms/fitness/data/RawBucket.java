package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.annotation.KeepName;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.zzaa;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

@KeepName
public final class RawBucket extends zza {
    public static final Creator<RawBucket> CREATOR;
    final int mVersionCode;
    public final Session zzaQL;
    public final long zzaQV;
    public final List<RawDataSet> zzaQX;
    public final int zzaQY;
    public final boolean zzaQZ;
    public final int zzaTz;
    public final long zzaed;

    static {
        CREATOR = new zzx();
    }

    public RawBucket(int i, long j, long j2, Session session, int i2, List<RawDataSet> list, int i3, boolean z) {
        this.mVersionCode = i;
        this.zzaed = j;
        this.zzaQV = j2;
        this.zzaQL = session;
        this.zzaTz = i2;
        this.zzaQX = list;
        this.zzaQY = i3;
        this.zzaQZ = z;
    }

    public RawBucket(Bucket bucket, List<DataSource> list, List<DataType> list2) {
        this.mVersionCode = 2;
        this.zzaed = bucket.getStartTime(TimeUnit.MILLISECONDS);
        this.zzaQV = bucket.getEndTime(TimeUnit.MILLISECONDS);
        this.zzaQL = bucket.getSession();
        this.zzaTz = bucket.zzBg();
        this.zzaQY = bucket.getBucketType();
        this.zzaQZ = bucket.zzBh();
        List<DataSet> dataSets = bucket.getDataSets();
        this.zzaQX = new ArrayList(dataSets.size());
        for (DataSet rawDataSet : dataSets) {
            this.zzaQX.add(new RawDataSet(rawDataSet, list, list2));
        }
    }

    private boolean zza(RawBucket rawBucket) {
        return this.zzaed == rawBucket.zzaed && this.zzaQV == rawBucket.zzaQV && this.zzaTz == rawBucket.zzaTz && zzaa.equal(this.zzaQX, rawBucket.zzaQX) && this.zzaQY == rawBucket.zzaQY && this.zzaQZ == rawBucket.zzaQZ;
    }

    public boolean equals(Object obj) {
        return this == obj || ((obj instanceof RawBucket) && zza((RawBucket) obj));
    }

    public int hashCode() {
        return zzaa.hashCode(Long.valueOf(this.zzaed), Long.valueOf(this.zzaQV), Integer.valueOf(this.zzaQY));
    }

    public String toString() {
        return zzaa.zzv(this).zzg("startTime", Long.valueOf(this.zzaed)).zzg("endTime", Long.valueOf(this.zzaQV)).zzg("activity", Integer.valueOf(this.zzaTz)).zzg("dataSets", this.zzaQX).zzg("bucketType", Integer.valueOf(this.zzaQY)).zzg("serverHasMoreData", Boolean.valueOf(this.zzaQZ)).toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzx.zza(this, parcel, i);
    }
}
