package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.zzaa;
import com.google.android.gms.common.internal.zzac;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.internal.zzaoq;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class SessionReadRequest extends zza {
    public static final Creator<SessionReadRequest> CREATOR;
    private final int mVersionCode;
    private final String zzVW;
    private final List<DataType> zzaQU;
    private final long zzaQV;
    private final List<DataSource> zzaUV;
    private final boolean zzaVg;
    private final String zzaWc;
    private boolean zzaWd;
    private final List<String> zzaWe;
    private final zzaoq zzaWf;
    private final long zzaed;

    public static class Builder {
        private String zzVW;
        private List<DataType> zzaQU;
        private long zzaQV;
        private List<DataSource> zzaUV;
        private boolean zzaVg;
        private String zzaWc;
        private boolean zzaWd;
        private List<String> zzaWe;
        private long zzaed;

        public Builder() {
            this.zzaed = 0;
            this.zzaQV = 0;
            this.zzaQU = new ArrayList();
            this.zzaUV = new ArrayList();
            this.zzaWd = false;
            this.zzaVg = false;
            this.zzaWe = new ArrayList();
        }

        public SessionReadRequest build() {
            zzac.zzb(this.zzaed > 0, "Invalid start time: %s", Long.valueOf(this.zzaed));
            boolean z = this.zzaQV > 0 && this.zzaQV > this.zzaed;
            zzac.zzb(z, "Invalid end time: %s", Long.valueOf(this.zzaQV));
            return new SessionReadRequest();
        }

        public Builder enableServerQueries() {
            this.zzaVg = true;
            return this;
        }

        public Builder excludePackage(String str) {
            zzac.zzb((Object) str, (Object) "Attempting to use a null package name");
            if (!this.zzaWe.contains(str)) {
                this.zzaWe.add(str);
            }
            return this;
        }

        public Builder read(DataSource dataSource) {
            zzac.zzb((Object) dataSource, (Object) "Attempting to add a null data source");
            if (!this.zzaUV.contains(dataSource)) {
                this.zzaUV.add(dataSource);
            }
            return this;
        }

        public Builder read(DataType dataType) {
            zzac.zzb((Object) dataType, (Object) "Attempting to use a null data type");
            if (!this.zzaQU.contains(dataType)) {
                this.zzaQU.add(dataType);
            }
            return this;
        }

        public Builder readSessionsFromAllApps() {
            this.zzaWd = true;
            return this;
        }

        public Builder setSessionId(String str) {
            this.zzVW = str;
            return this;
        }

        public Builder setSessionName(String str) {
            this.zzaWc = str;
            return this;
        }

        public Builder setTimeInterval(long j, long j2, TimeUnit timeUnit) {
            this.zzaed = timeUnit.toMillis(j);
            this.zzaQV = timeUnit.toMillis(j2);
            return this;
        }
    }

    static {
        CREATOR = new zzba();
    }

    SessionReadRequest(int i, String str, String str2, long j, long j2, List<DataType> list, List<DataSource> list2, boolean z, boolean z2, List<String> list3, IBinder iBinder) {
        this.mVersionCode = i;
        this.zzaWc = str;
        this.zzVW = str2;
        this.zzaed = j;
        this.zzaQV = j2;
        this.zzaQU = list;
        this.zzaUV = list2;
        this.zzaWd = z;
        this.zzaVg = z2;
        this.zzaWe = list3;
        this.zzaWf = zzaoq.zza.zzcH(iBinder);
    }

    private SessionReadRequest(Builder builder) {
        this(builder.zzaWc, builder.zzVW, builder.zzaed, builder.zzaQV, builder.zzaQU, builder.zzaUV, builder.zzaWd, builder.zzaVg, builder.zzaWe, null);
    }

    public SessionReadRequest(SessionReadRequest sessionReadRequest, zzaoq com_google_android_gms_internal_zzaoq) {
        this(sessionReadRequest.zzaWc, sessionReadRequest.zzVW, sessionReadRequest.zzaed, sessionReadRequest.zzaQV, sessionReadRequest.zzaQU, sessionReadRequest.zzaUV, sessionReadRequest.zzaWd, sessionReadRequest.zzaVg, sessionReadRequest.zzaWe, com_google_android_gms_internal_zzaoq);
    }

    public SessionReadRequest(String str, String str2, long j, long j2, List<DataType> list, List<DataSource> list2, boolean z, boolean z2, List<String> list3, zzaoq com_google_android_gms_internal_zzaoq) {
        this(5, str, str2, j, j2, list, list2, z, z2, list3, com_google_android_gms_internal_zzaoq == null ? null : com_google_android_gms_internal_zzaoq.asBinder());
    }

    private boolean zzb(SessionReadRequest sessionReadRequest) {
        return zzaa.equal(this.zzaWc, sessionReadRequest.zzaWc) && this.zzVW.equals(sessionReadRequest.zzVW) && this.zzaed == sessionReadRequest.zzaed && this.zzaQV == sessionReadRequest.zzaQV && zzaa.equal(this.zzaQU, sessionReadRequest.zzaQU) && zzaa.equal(this.zzaUV, sessionReadRequest.zzaUV) && this.zzaWd == sessionReadRequest.zzaWd && this.zzaWe.equals(sessionReadRequest.zzaWe) && this.zzaVg == sessionReadRequest.zzaVg;
    }

    public boolean equals(Object obj) {
        return this == obj || ((obj instanceof SessionReadRequest) && zzb((SessionReadRequest) obj));
    }

    public IBinder getCallbackBinder() {
        return this.zzaWf == null ? null : this.zzaWf.asBinder();
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

    public List<String> getExcludedPackages() {
        return this.zzaWe;
    }

    public String getSessionId() {
        return this.zzVW;
    }

    public String getSessionName() {
        return this.zzaWc;
    }

    public long getStartTime(TimeUnit timeUnit) {
        return timeUnit.convert(this.zzaed, TimeUnit.MILLISECONDS);
    }

    int getVersionCode() {
        return this.mVersionCode;
    }

    public int hashCode() {
        return zzaa.hashCode(this.zzaWc, this.zzVW, Long.valueOf(this.zzaed), Long.valueOf(this.zzaQV));
    }

    public boolean includeSessionsFromAllApps() {
        return this.zzaWd;
    }

    public String toString() {
        return zzaa.zzv(this).zzg("sessionName", this.zzaWc).zzg("sessionId", this.zzVW).zzg("startTimeMillis", Long.valueOf(this.zzaed)).zzg("endTimeMillis", Long.valueOf(this.zzaQV)).zzg("dataTypes", this.zzaQU).zzg("dataSources", this.zzaUV).zzg("sessionsFromAllApps", Boolean.valueOf(this.zzaWd)).zzg("excludedPackages", this.zzaWe).zzg("useServer", Boolean.valueOf(this.zzaVg)).toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzba.zza(this, parcel, i);
    }

    public boolean zzCd() {
        return this.zzaVg;
    }

    public boolean zzCw() {
        return this.zzaWd;
    }

    public long zzpN() {
        return this.zzaed;
    }

    public long zzzx() {
        return this.zzaQV;
    }
}
