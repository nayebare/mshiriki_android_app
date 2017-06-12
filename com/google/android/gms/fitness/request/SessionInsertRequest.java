package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.util.Log;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.zzaa;
import com.google.android.gms.common.internal.zzac;
import com.google.android.gms.fitness.data.DataPoint;
import com.google.android.gms.fitness.data.DataSet;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.Session;
import com.google.android.gms.internal.zzang;
import com.google.android.gms.internal.zzaos;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class SessionInsertRequest extends zza {
    public static final Creator<SessionInsertRequest> CREATOR;
    private final int versionCode;
    private final zzaos zzaVG;
    private final Session zzaVY;
    private final List<DataSet> zzaVZ;
    private final List<DataPoint> zzaWa;

    public static class Builder {
        private Session zzaVY;
        private List<DataSet> zzaVZ;
        private List<DataPoint> zzaWa;
        private List<DataSource> zzaWb;

        public Builder() {
            this.zzaVZ = new ArrayList();
            this.zzaWa = new ArrayList();
            this.zzaWb = new ArrayList();
        }

        private void zzCv() {
            for (DataSet dataPoints : this.zzaVZ) {
                for (DataPoint zzg : dataPoints.getDataPoints()) {
                    zzg(zzg);
                }
            }
            for (DataPoint zzg2 : this.zzaWa) {
                zzg(zzg2);
            }
        }

        private void zzg(DataPoint dataPoint) {
            zzi(dataPoint);
            zzh(dataPoint);
        }

        private void zzh(DataPoint dataPoint) {
            long startTime = this.zzaVY.getStartTime(TimeUnit.NANOSECONDS);
            long endTime = this.zzaVY.getEndTime(TimeUnit.NANOSECONDS);
            long startTime2 = dataPoint.getStartTime(TimeUnit.NANOSECONDS);
            long endTime2 = dataPoint.getEndTime(TimeUnit.NANOSECONDS);
            if (startTime2 != 0 && endTime2 != 0) {
                TimeUnit timeUnit = TimeUnit.MILLISECONDS;
                if (endTime2 > endTime) {
                    endTime2 = zzang.zza(endTime2, TimeUnit.NANOSECONDS, timeUnit);
                }
                boolean z = startTime2 >= startTime && endTime2 <= endTime;
                zzac.zza(z, "Data point %s has start and end times outside session interval [%d, %d]", dataPoint, Long.valueOf(startTime), Long.valueOf(endTime));
                if (endTime2 != dataPoint.getEndTime(TimeUnit.NANOSECONDS)) {
                    Log.w("Fitness", String.format("Data point end time [%d] is truncated to [%d] to match the precision [%s] of the session start and end time", new Object[]{Long.valueOf(dataPoint.getEndTime(TimeUnit.NANOSECONDS)), Long.valueOf(endTime2), timeUnit}));
                    dataPoint.setTimeInterval(startTime2, endTime2, TimeUnit.NANOSECONDS);
                }
            }
        }

        private void zzi(DataPoint dataPoint) {
            long startTime = this.zzaVY.getStartTime(TimeUnit.NANOSECONDS);
            long endTime = this.zzaVY.getEndTime(TimeUnit.NANOSECONDS);
            long timestamp = dataPoint.getTimestamp(TimeUnit.NANOSECONDS);
            if (timestamp != 0) {
                TimeUnit timeUnit = TimeUnit.MILLISECONDS;
                if (timestamp < startTime || timestamp > endTime) {
                    timestamp = zzang.zza(timestamp, TimeUnit.NANOSECONDS, timeUnit);
                }
                boolean z = timestamp >= startTime && timestamp <= endTime;
                zzac.zza(z, "Data point %s has time stamp outside session interval [%d, %d]", dataPoint, Long.valueOf(startTime), Long.valueOf(endTime));
                if (dataPoint.getTimestamp(TimeUnit.NANOSECONDS) != timestamp) {
                    Log.w("Fitness", String.format("Data point timestamp [%d] is truncated to [%d] to match the precision [%s] of the session start and end time", new Object[]{Long.valueOf(dataPoint.getTimestamp(TimeUnit.NANOSECONDS)), Long.valueOf(timestamp), timeUnit}));
                    dataPoint.setTimestamp(timestamp, TimeUnit.NANOSECONDS);
                }
            }
        }

        public Builder addAggregateDataPoint(DataPoint dataPoint) {
            zzac.zzb(dataPoint != null, (Object) "Must specify a valid aggregate data point.");
            DataSource dataSource = dataPoint.getDataSource();
            zzac.zza(!this.zzaWb.contains(dataSource), "Data set/Aggregate data point for this data source %s is already added.", dataSource);
            DataSet.zze(dataPoint);
            this.zzaWb.add(dataSource);
            this.zzaWa.add(dataPoint);
            return this;
        }

        public Builder addDataSet(DataSet dataSet) {
            boolean z = true;
            zzac.zzb(dataSet != null, (Object) "Must specify a valid data set.");
            DataSource dataSource = dataSet.getDataSource();
            zzac.zza(!this.zzaWb.contains(dataSource), "Data set for this data source %s is already added.", dataSource);
            if (dataSet.getDataPoints().isEmpty()) {
                z = false;
            }
            zzac.zzb(z, (Object) "No data points specified in the input data set.");
            this.zzaWb.add(dataSource);
            this.zzaVZ.add(dataSet);
            return this;
        }

        public SessionInsertRequest build() {
            boolean z = true;
            zzac.zza(this.zzaVY != null, (Object) "Must specify a valid session.");
            if (this.zzaVY.getEndTime(TimeUnit.MILLISECONDS) == 0) {
                z = false;
            }
            zzac.zza(z, (Object) "Must specify a valid end time, cannot insert a continuing session.");
            zzCv();
            return new SessionInsertRequest();
        }

        public Builder setSession(Session session) {
            this.zzaVY = session;
            return this;
        }
    }

    static {
        CREATOR = new zzaz();
    }

    SessionInsertRequest(int i, Session session, List<DataSet> list, List<DataPoint> list2, IBinder iBinder) {
        this.versionCode = i;
        this.zzaVY = session;
        this.zzaVZ = Collections.unmodifiableList(list);
        this.zzaWa = Collections.unmodifiableList(list2);
        this.zzaVG = zzaos.zza.zzcJ(iBinder);
    }

    public SessionInsertRequest(Session session, List<DataSet> list, List<DataPoint> list2, zzaos com_google_android_gms_internal_zzaos) {
        this.versionCode = 3;
        this.zzaVY = session;
        this.zzaVZ = Collections.unmodifiableList(list);
        this.zzaWa = Collections.unmodifiableList(list2);
        this.zzaVG = com_google_android_gms_internal_zzaos;
    }

    private SessionInsertRequest(Builder builder) {
        this(builder.zzaVY, builder.zzaVZ, builder.zzaWa, null);
    }

    public SessionInsertRequest(SessionInsertRequest sessionInsertRequest, zzaos com_google_android_gms_internal_zzaos) {
        this(sessionInsertRequest.zzaVY, sessionInsertRequest.zzaVZ, sessionInsertRequest.zzaWa, com_google_android_gms_internal_zzaos);
    }

    private boolean zzb(SessionInsertRequest sessionInsertRequest) {
        return zzaa.equal(this.zzaVY, sessionInsertRequest.zzaVY) && zzaa.equal(this.zzaVZ, sessionInsertRequest.zzaVZ) && zzaa.equal(this.zzaWa, sessionInsertRequest.zzaWa);
    }

    public boolean equals(Object obj) {
        return obj == this || ((obj instanceof SessionInsertRequest) && zzb((SessionInsertRequest) obj));
    }

    public List<DataPoint> getAggregateDataPoints() {
        return this.zzaWa;
    }

    public IBinder getCallbackBinder() {
        return this.zzaVG == null ? null : this.zzaVG.asBinder();
    }

    public List<DataSet> getDataSets() {
        return this.zzaVZ;
    }

    public Session getSession() {
        return this.zzaVY;
    }

    int getVersionCode() {
        return this.versionCode;
    }

    public int hashCode() {
        return zzaa.hashCode(this.zzaVY, this.zzaVZ, this.zzaWa);
    }

    public String toString() {
        return zzaa.zzv(this).zzg("session", this.zzaVY).zzg("dataSets", this.zzaVZ).zzg("aggregateDataPoints", this.zzaWa).toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzaz.zza(this, parcel, i);
    }
}
