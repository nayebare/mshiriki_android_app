package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.zzaa;
import com.google.android.gms.common.internal.zzac;
import com.google.android.gms.fitness.data.DataPoint;
import com.google.android.gms.fitness.data.DataSet;
import com.google.android.gms.internal.zzaos;
import java.util.concurrent.TimeUnit;

public class DataUpdateRequest extends zza {
    public static final Creator<DataUpdateRequest> CREATOR;
    private final int mVersionCode;
    private final long zzaQV;
    private final DataSet zzaTM;
    private final zzaos zzaUS;
    private final long zzaed;

    public static class Builder {
        private long zzaQV;
        private DataSet zzaTM;
        private long zzaed;

        private void zzCk() {
            zzac.zza(this.zzaed, (Object) "Must set a non-zero value for startTimeMillis/startTime");
            zzac.zza(this.zzaQV, (Object) "Must set a non-zero value for endTimeMillis/endTime");
            zzac.zzb(this.zzaTM, (Object) "Must set the data set");
            for (DataPoint dataPoint : this.zzaTM.getDataPoints()) {
                long startTime = dataPoint.getStartTime(TimeUnit.MILLISECONDS);
                long endTime = dataPoint.getEndTime(TimeUnit.MILLISECONDS);
                int i = (startTime > endTime || ((startTime != 0 && startTime < this.zzaed) || ((startTime != 0 && startTime > this.zzaQV) || endTime > this.zzaQV || endTime < this.zzaed))) ? 1 : 0;
                zzac.zza(i == 0, "Data Point's startTimeMillis %d, endTimeMillis %d should lie between timeRange provided in the request. StartTimeMillis %d, EndTimeMillis: %d", Long.valueOf(startTime), Long.valueOf(endTime), Long.valueOf(this.zzaed), Long.valueOf(this.zzaQV));
            }
        }

        public DataUpdateRequest build() {
            zzCk();
            return new DataUpdateRequest();
        }

        public Builder setDataSet(DataSet dataSet) {
            zzac.zzb((Object) dataSet, (Object) "Must set the data set");
            this.zzaTM = dataSet;
            return this;
        }

        public Builder setTimeInterval(long j, long j2, TimeUnit timeUnit) {
            zzac.zzb(j > 0, "Invalid start time :%d", Long.valueOf(j));
            zzac.zzb(j2 >= j, "Invalid end time :%d", Long.valueOf(j2));
            this.zzaed = timeUnit.toMillis(j);
            this.zzaQV = timeUnit.toMillis(j2);
            return this;
        }
    }

    static {
        CREATOR = new zzs();
    }

    DataUpdateRequest(int i, long j, long j2, DataSet dataSet, IBinder iBinder) {
        this.mVersionCode = i;
        this.zzaed = j;
        this.zzaQV = j2;
        this.zzaTM = dataSet;
        this.zzaUS = zzaos.zza.zzcJ(iBinder);
    }

    public DataUpdateRequest(long j, long j2, DataSet dataSet, IBinder iBinder) {
        this.mVersionCode = 1;
        this.zzaed = j;
        this.zzaQV = j2;
        this.zzaTM = dataSet;
        this.zzaUS = zzaos.zza.zzcJ(iBinder);
    }

    private DataUpdateRequest(Builder builder) {
        this(builder.zzaed, builder.zzaQV, builder.zzaTM, null);
    }

    public DataUpdateRequest(DataUpdateRequest dataUpdateRequest, IBinder iBinder) {
        this(dataUpdateRequest.zzpN(), dataUpdateRequest.zzzx(), dataUpdateRequest.getDataSet(), iBinder);
    }

    private boolean zzb(DataUpdateRequest dataUpdateRequest) {
        return this.zzaed == dataUpdateRequest.zzaed && this.zzaQV == dataUpdateRequest.zzaQV && zzaa.equal(this.zzaTM, dataUpdateRequest.zzaTM);
    }

    public boolean equals(Object obj) {
        return obj == this || ((obj instanceof DataUpdateRequest) && zzb((DataUpdateRequest) obj));
    }

    public IBinder getCallbackBinder() {
        return this.zzaUS == null ? null : this.zzaUS.asBinder();
    }

    public DataSet getDataSet() {
        return this.zzaTM;
    }

    public long getEndTime(TimeUnit timeUnit) {
        return timeUnit.convert(this.zzaQV, TimeUnit.MILLISECONDS);
    }

    public long getStartTime(TimeUnit timeUnit) {
        return timeUnit.convert(this.zzaed, TimeUnit.MILLISECONDS);
    }

    int getVersionCode() {
        return this.mVersionCode;
    }

    public int hashCode() {
        return zzaa.hashCode(Long.valueOf(this.zzaed), Long.valueOf(this.zzaQV), this.zzaTM);
    }

    public String toString() {
        return zzaa.zzv(this).zzg("startTimeMillis", Long.valueOf(this.zzaed)).zzg("endTimeMillis", Long.valueOf(this.zzaQV)).zzg("dataSet", this.zzaTM).toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzs.zza(this, parcel, i);
    }

    public long zzpN() {
        return this.zzaed;
    }

    public long zzzx() {
        return this.zzaQV;
    }
}
