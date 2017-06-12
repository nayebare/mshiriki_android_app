package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.zzaa;
import com.google.android.gms.fitness.FitnessActivities;
import com.google.android.gms.wearable.MessageApi;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Bucket extends zza implements ReflectedParcelable {
    public static final Creator<Bucket> CREATOR;
    public static final int TYPE_ACTIVITY_SEGMENT = 4;
    public static final int TYPE_ACTIVITY_TYPE = 3;
    public static final int TYPE_SESSION = 2;
    public static final int TYPE_TIME = 1;
    private final int mVersionCode;
    private final Session zzaQL;
    private final long zzaQV;
    private final int zzaQW;
    private final List<DataSet> zzaQX;
    private final int zzaQY;
    private boolean zzaQZ;
    private final long zzaed;

    static {
        CREATOR = new zze();
    }

    Bucket(int i, long j, long j2, Session session, int i2, List<DataSet> list, int i3, boolean z) {
        this.zzaQZ = false;
        this.mVersionCode = i;
        this.zzaed = j;
        this.zzaQV = j2;
        this.zzaQL = session;
        this.zzaQW = i2;
        this.zzaQX = list;
        this.zzaQY = i3;
        this.zzaQZ = z;
    }

    public Bucket(RawBucket rawBucket, List<DataSource> list) {
        this(TYPE_SESSION, rawBucket.zzaed, rawBucket.zzaQV, rawBucket.zzaQL, rawBucket.zzaTz, zza(rawBucket.zzaQX, list), rawBucket.zzaQY, rawBucket.zzaQZ);
    }

    private static List<DataSet> zza(Collection<RawDataSet> collection, List<DataSource> list) {
        List<DataSet> arrayList = new ArrayList(collection.size());
        for (RawDataSet dataSet : collection) {
            arrayList.add(new DataSet(dataSet, list));
        }
        return arrayList;
    }

    private boolean zza(Bucket bucket) {
        return this.zzaed == bucket.zzaed && this.zzaQV == bucket.zzaQV && this.zzaQW == bucket.zzaQW && zzaa.equal(this.zzaQX, bucket.zzaQX) && this.zzaQY == bucket.zzaQY && this.zzaQZ == bucket.zzaQZ;
    }

    public static String zzgn(int i) {
        switch (i) {
            case MessageApi.FILTER_LITERAL /*0*/:
                return FitnessActivities.UNKNOWN;
            case TYPE_TIME /*1*/:
                return "time";
            case TYPE_SESSION /*2*/:
                return "session";
            case TYPE_ACTIVITY_TYPE /*3*/:
                return "type";
            case TYPE_ACTIVITY_SEGMENT /*4*/:
                return "segment";
            default:
                return "bug";
        }
    }

    public boolean equals(Object obj) {
        return obj == this || ((obj instanceof Bucket) && zza((Bucket) obj));
    }

    public String getActivity() {
        return FitnessActivities.getName(this.zzaQW);
    }

    public int getBucketType() {
        return this.zzaQY;
    }

    public DataSet getDataSet(DataType dataType) {
        for (DataSet dataSet : this.zzaQX) {
            if (dataSet.getDataType().equals(dataType)) {
                return dataSet;
            }
        }
        return null;
    }

    public List<DataSet> getDataSets() {
        return this.zzaQX;
    }

    public long getEndTime(TimeUnit timeUnit) {
        return timeUnit.convert(this.zzaQV, TimeUnit.MILLISECONDS);
    }

    public Session getSession() {
        return this.zzaQL;
    }

    public long getStartTime(TimeUnit timeUnit) {
        return timeUnit.convert(this.zzaed, TimeUnit.MILLISECONDS);
    }

    int getVersionCode() {
        return this.mVersionCode;
    }

    public int hashCode() {
        Object[] objArr = new Object[TYPE_ACTIVITY_SEGMENT];
        objArr[0] = Long.valueOf(this.zzaed);
        objArr[TYPE_TIME] = Long.valueOf(this.zzaQV);
        objArr[TYPE_SESSION] = Integer.valueOf(this.zzaQW);
        objArr[TYPE_ACTIVITY_TYPE] = Integer.valueOf(this.zzaQY);
        return zzaa.hashCode(objArr);
    }

    public String toString() {
        return zzaa.zzv(this).zzg("startTime", Long.valueOf(this.zzaed)).zzg("endTime", Long.valueOf(this.zzaQV)).zzg("activity", Integer.valueOf(this.zzaQW)).zzg("dataSets", this.zzaQX).zzg("bucketType", zzgn(this.zzaQY)).zzg("serverHasMoreData", Boolean.valueOf(this.zzaQZ)).toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        zze.zza(this, parcel, i);
    }

    public int zzBg() {
        return this.zzaQW;
    }

    public boolean zzBh() {
        if (this.zzaQZ) {
            return true;
        }
        for (DataSet zzBh : this.zzaQX) {
            if (zzBh.zzBh()) {
                return true;
            }
        }
        return false;
    }

    public boolean zzb(Bucket bucket) {
        return this.zzaed == bucket.zzaed && this.zzaQV == bucket.zzaQV && this.zzaQW == bucket.zzaQW && this.zzaQY == bucket.zzaQY;
    }

    public long zzpN() {
        return this.zzaed;
    }

    public long zzzx() {
        return this.zzaQV;
    }
}
