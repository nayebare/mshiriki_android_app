package com.google.android.gms.fitness.data;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzd;
import com.google.android.gms.common.internal.zzaa;
import java.util.concurrent.TimeUnit;

public class DataUpdateNotification extends zza {
    public static final String ACTION = "com.google.android.gms.fitness.DATA_UPDATE_NOTIFICATION";
    public static final Creator<DataUpdateNotification> CREATOR;
    public static final String EXTRA_DATA_UPDATE_NOTIFICATION = "vnd.google.fitness.data_udpate_notification";
    public static final int OPERATION_DELETE = 2;
    public static final int OPERATION_INSERT = 1;
    public static final int OPERATION_UPDATE = 3;
    final int mVersionCode;
    private final long zzaRG;
    private final long zzaRH;
    private final int zzaRI;
    private final DataSource zzaRJ;
    private final DataType zzaRK;

    static {
        CREATOR = new zzm();
    }

    DataUpdateNotification(int i, long j, long j2, int i2, DataSource dataSource, DataType dataType) {
        this.mVersionCode = i;
        this.zzaRG = j;
        this.zzaRH = j2;
        this.zzaRI = i2;
        this.zzaRJ = dataSource;
        this.zzaRK = dataType;
    }

    public static DataUpdateNotification getDataUpdateNotification(Intent intent) {
        return (DataUpdateNotification) zzd.zza(intent, EXTRA_DATA_UPDATE_NOTIFICATION, CREATOR);
    }

    private boolean zza(DataUpdateNotification dataUpdateNotification) {
        return this.zzaRG == dataUpdateNotification.zzaRG && this.zzaRH == dataUpdateNotification.zzaRH && this.zzaRI == dataUpdateNotification.zzaRI && zzaa.equal(this.zzaRJ, dataUpdateNotification.zzaRJ) && zzaa.equal(this.zzaRK, dataUpdateNotification.zzaRK);
    }

    public boolean equals(Object obj) {
        return obj == this || ((obj instanceof DataUpdateNotification) && zza((DataUpdateNotification) obj));
    }

    public DataSource getDataSource() {
        return this.zzaRJ;
    }

    public DataType getDataType() {
        return this.zzaRK;
    }

    public int getOperationType() {
        return this.zzaRI;
    }

    public long getUpdateEndTime(TimeUnit timeUnit) {
        return timeUnit.convert(this.zzaRH, TimeUnit.NANOSECONDS);
    }

    public long getUpdateStartTime(TimeUnit timeUnit) {
        return timeUnit.convert(this.zzaRG, TimeUnit.NANOSECONDS);
    }

    public int hashCode() {
        return zzaa.hashCode(Long.valueOf(this.zzaRG), Long.valueOf(this.zzaRH), Integer.valueOf(this.zzaRI), this.zzaRJ, this.zzaRK);
    }

    public String toString() {
        return zzaa.zzv(this).zzg("updateStartTimeNanos", Long.valueOf(this.zzaRG)).zzg("updateEndTimeNanos", Long.valueOf(this.zzaRH)).zzg("operationType", Integer.valueOf(this.zzaRI)).zzg("dataSource", this.zzaRJ).zzg("dataType", this.zzaRK).toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzm.zza(this, parcel, i);
    }

    public long zzBw() {
        return this.zzaRG;
    }

    public long zzBx() {
        return this.zzaRH;
    }
}
