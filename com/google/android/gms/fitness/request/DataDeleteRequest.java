package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.zzaa;
import com.google.android.gms.common.internal.zzac;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.fitness.data.Session;
import com.google.android.gms.internal.zzaos;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class DataDeleteRequest extends zza {
    public static final Creator<DataDeleteRequest> CREATOR;
    private final int mVersionCode;
    private final List<DataType> zzaQU;
    private final long zzaQV;
    private final zzaos zzaUS;
    private final List<DataSource> zzaUV;
    private final List<Session> zzaUW;
    private final boolean zzaUX;
    private final boolean zzaUY;
    private final long zzaed;

    public static class Builder {
        private List<DataType> zzaQU;
        private long zzaQV;
        private List<DataSource> zzaUV;
        private List<Session> zzaUW;
        private boolean zzaUX;
        private boolean zzaUY;
        private long zzaed;

        public Builder() {
            this.zzaUV = new ArrayList();
            this.zzaQU = new ArrayList();
            this.zzaUW = new ArrayList();
            this.zzaUX = false;
            this.zzaUY = false;
        }

        private void zzCb() {
            if (!this.zzaUW.isEmpty()) {
                for (Session session : this.zzaUW) {
                    boolean z = session.getStartTime(TimeUnit.MILLISECONDS) >= this.zzaed && session.getEndTime(TimeUnit.MILLISECONDS) <= this.zzaQV;
                    zzac.zza(z, "Session %s is outside the time interval [%d, %d]", session, Long.valueOf(this.zzaed), Long.valueOf(this.zzaQV));
                }
            }
        }

        public Builder addDataSource(DataSource dataSource) {
            boolean z = true;
            zzac.zzb(!this.zzaUX, (Object) "All data is already marked for deletion.  addDataSource() cannot be combined with deleteAllData()");
            if (dataSource == null) {
                z = false;
            }
            zzac.zzb(z, (Object) "Must specify a valid data source");
            if (!this.zzaUV.contains(dataSource)) {
                this.zzaUV.add(dataSource);
            }
            return this;
        }

        public Builder addDataType(DataType dataType) {
            boolean z = true;
            zzac.zzb(!this.zzaUX, (Object) "All data is already marked for deletion.  addDataType() cannot be combined with deleteAllData()");
            if (dataType == null) {
                z = false;
            }
            zzac.zzb(z, (Object) "Must specify a valid data type");
            if (!this.zzaQU.contains(dataType)) {
                this.zzaQU.add(dataType);
            }
            return this;
        }

        public Builder addSession(Session session) {
            boolean z = true;
            zzac.zzb(!this.zzaUY, (Object) "All sessions already marked for deletion.  addSession() cannot be combined with deleteAllSessions()");
            zzac.zzb(session != null, (Object) "Must specify a valid session");
            if (session.getEndTime(TimeUnit.MILLISECONDS) <= 0) {
                z = false;
            }
            zzac.zzb(z, (Object) "Cannot delete an ongoing session. Please stop the session prior to deleting it");
            this.zzaUW.add(session);
            return this;
        }

        public DataDeleteRequest build() {
            boolean z = false;
            boolean z2 = this.zzaed > 0 && this.zzaQV > this.zzaed;
            zzac.zza(z2, (Object) "Must specify a valid time interval");
            z2 = (!this.zzaUX && this.zzaUV.isEmpty() && this.zzaQU.isEmpty()) ? false : true;
            boolean z3 = this.zzaUY || !this.zzaUW.isEmpty();
            if (z2 || z3) {
                z = true;
            }
            zzac.zza(z, (Object) "No data or session marked for deletion");
            zzCb();
            return new DataDeleteRequest();
        }

        public Builder deleteAllData() {
            zzac.zzb(this.zzaQU.isEmpty(), (Object) "Specific data type already added for deletion. deleteAllData() will delete all data types and cannot be combined with addDataType()");
            zzac.zzb(this.zzaUV.isEmpty(), (Object) "Specific data source already added for deletion. deleteAllData() will delete all data sources and cannot be combined with addDataSource()");
            this.zzaUX = true;
            return this;
        }

        public Builder deleteAllSessions() {
            zzac.zzb(this.zzaUW.isEmpty(), (Object) "Specific session already added for deletion. deleteAllData() will delete all sessions and cannot be combined with addSession()");
            this.zzaUY = true;
            return this;
        }

        public Builder setTimeInterval(long j, long j2, TimeUnit timeUnit) {
            zzac.zzb(j > 0, "Invalid start time :%d", Long.valueOf(j));
            zzac.zzb(j2 > j, "Invalid end time :%d", Long.valueOf(j2));
            this.zzaed = timeUnit.toMillis(j);
            this.zzaQV = timeUnit.toMillis(j2);
            return this;
        }
    }

    static {
        CREATOR = new zzf();
    }

    DataDeleteRequest(int i, long j, long j2, List<DataSource> list, List<DataType> list2, List<Session> list3, boolean z, boolean z2, IBinder iBinder) {
        this.mVersionCode = i;
        this.zzaed = j;
        this.zzaQV = j2;
        this.zzaUV = Collections.unmodifiableList(list);
        this.zzaQU = Collections.unmodifiableList(list2);
        this.zzaUW = list3;
        this.zzaUX = z;
        this.zzaUY = z2;
        this.zzaUS = zzaos.zza.zzcJ(iBinder);
    }

    public DataDeleteRequest(long j, long j2, List<DataSource> list, List<DataType> list2, List<Session> list3, boolean z, boolean z2, zzaos com_google_android_gms_internal_zzaos) {
        this.mVersionCode = 3;
        this.zzaed = j;
        this.zzaQV = j2;
        this.zzaUV = Collections.unmodifiableList(list);
        this.zzaQU = Collections.unmodifiableList(list2);
        this.zzaUW = list3;
        this.zzaUX = z;
        this.zzaUY = z2;
        this.zzaUS = com_google_android_gms_internal_zzaos;
    }

    private DataDeleteRequest(Builder builder) {
        this(builder.zzaed, builder.zzaQV, builder.zzaUV, builder.zzaQU, builder.zzaUW, builder.zzaUX, builder.zzaUY, null);
    }

    public DataDeleteRequest(DataDeleteRequest dataDeleteRequest, zzaos com_google_android_gms_internal_zzaos) {
        this(dataDeleteRequest.zzaed, dataDeleteRequest.zzaQV, dataDeleteRequest.zzaUV, dataDeleteRequest.zzaQU, dataDeleteRequest.zzaUW, dataDeleteRequest.zzaUX, dataDeleteRequest.zzaUY, com_google_android_gms_internal_zzaos);
    }

    private boolean zzb(DataDeleteRequest dataDeleteRequest) {
        return this.zzaed == dataDeleteRequest.zzaed && this.zzaQV == dataDeleteRequest.zzaQV && zzaa.equal(this.zzaUV, dataDeleteRequest.zzaUV) && zzaa.equal(this.zzaQU, dataDeleteRequest.zzaQU) && zzaa.equal(this.zzaUW, dataDeleteRequest.zzaUW) && this.zzaUX == dataDeleteRequest.zzaUX && this.zzaUY == dataDeleteRequest.zzaUY;
    }

    public boolean deleteAllData() {
        return this.zzaUX;
    }

    public boolean deleteAllSessions() {
        return this.zzaUY;
    }

    public boolean equals(Object obj) {
        return obj == this || ((obj instanceof DataDeleteRequest) && zzb((DataDeleteRequest) obj));
    }

    public IBinder getCallbackBinder() {
        return this.zzaUS == null ? null : this.zzaUS.asBinder();
    }

    public List<DataSource> getDataSources() {
        return this.zzaUV;
    }

    public List<DataType> getDataTypes() {
        return this.zzaQU;
    }

    public long getEndTime(TimeUnit timeUnit) {
        return timeUnit.convert(this.zzaQV, TimeUnit.MILLISECONDS);
    }

    public List<Session> getSessions() {
        return this.zzaUW;
    }

    public long getStartTime(TimeUnit timeUnit) {
        return timeUnit.convert(this.zzaed, TimeUnit.MILLISECONDS);
    }

    int getVersionCode() {
        return this.mVersionCode;
    }

    public int hashCode() {
        return zzaa.hashCode(Long.valueOf(this.zzaed), Long.valueOf(this.zzaQV));
    }

    public String toString() {
        return zzaa.zzv(this).zzg("startTimeMillis", Long.valueOf(this.zzaed)).zzg("endTimeMillis", Long.valueOf(this.zzaQV)).zzg("dataSources", this.zzaUV).zzg("dateTypes", this.zzaQU).zzg("sessions", this.zzaUW).zzg("deleteAllData", Boolean.valueOf(this.zzaUX)).zzg("deleteAllSessions", Boolean.valueOf(this.zzaUY)).toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzf.zza(this, parcel, i);
    }

    public boolean zzBZ() {
        return this.zzaUX;
    }

    public boolean zzCa() {
        return this.zzaUY;
    }

    public long zzpN() {
        return this.zzaed;
    }

    public long zzzx() {
        return this.zzaQV;
    }
}
