package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.zzaa;
import com.google.android.gms.common.internal.zzac;
import com.google.android.gms.fitness.data.Bucket;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.fitness.data.Device;
import com.google.android.gms.internal.zzanz;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class DataReadRequest extends zza {
    public static final Creator<DataReadRequest> CREATOR;
    public static final int NO_LIMIT = 0;
    private final int mVersionCode;
    private final List<DataType> zzaQU;
    private final long zzaQV;
    private final int zzaQY;
    private final List<DataSource> zzaUV;
    private final List<DataType> zzaVa;
    private final List<DataSource> zzaVb;
    private final long zzaVc;
    private final DataSource zzaVd;
    private final int zzaVe;
    private final boolean zzaVf;
    private final boolean zzaVg;
    private final zzanz zzaVh;
    private final List<Device> zzaVi;
    private final List<Integer> zzaVj;
    private final long zzaed;

    public static class Builder {
        private List<DataType> zzaQU;
        private long zzaQV;
        private int zzaQY;
        private List<DataSource> zzaUV;
        private List<DataType> zzaVa;
        private List<DataSource> zzaVb;
        private long zzaVc;
        private DataSource zzaVd;
        private int zzaVe;
        private boolean zzaVf;
        private boolean zzaVg;
        private final List<Device> zzaVi;
        private final List<Integer> zzaVj;
        private long zzaed;

        public Builder() {
            this.zzaQU = new ArrayList();
            this.zzaUV = new ArrayList();
            this.zzaVa = new ArrayList();
            this.zzaVb = new ArrayList();
            this.zzaQY = 0;
            this.zzaVc = 0;
            this.zzaVe = 0;
            this.zzaVf = false;
            this.zzaVg = false;
            this.zzaVi = new ArrayList();
            this.zzaVj = new ArrayList();
        }

        public Builder aggregate(DataSource dataSource, DataType dataType) {
            zzac.zzb((Object) dataSource, (Object) "Attempting to add a null data source");
            zzac.zza(!this.zzaUV.contains(dataSource), (Object) "Cannot add the same data source for aggregated and detailed");
            List aggregatesForInput = DataType.getAggregatesForInput(dataSource.getDataType());
            zzac.zzb(!aggregatesForInput.isEmpty(), "Unsupported input data type specified for aggregation: %s", dataSource.getDataType());
            zzac.zzb(aggregatesForInput.contains(dataType), "Invalid output aggregate data type specified: %s -> %s", r3, dataType);
            if (!this.zzaVb.contains(dataSource)) {
                this.zzaVb.add(dataSource);
            }
            return this;
        }

        public Builder aggregate(DataType dataType, DataType dataType2) {
            zzac.zzb((Object) dataType, (Object) "Attempting to use a null data type");
            zzac.zza(!this.zzaQU.contains(dataType), (Object) "Cannot add the same data type as aggregated and detailed");
            List aggregatesForInput = DataType.getAggregatesForInput(dataType);
            zzac.zzb(!aggregatesForInput.isEmpty(), "Unsupported input data type specified for aggregation: %s", dataType);
            zzac.zzb(aggregatesForInput.contains(dataType2), "Invalid output aggregate data type specified: %s -> %s", dataType, dataType2);
            if (!this.zzaVa.contains(dataType)) {
                this.zzaVa.add(dataType);
            }
            return this;
        }

        public Builder bucketByActivitySegment(int i, TimeUnit timeUnit) {
            zzac.zzb(this.zzaQY == 0, "Bucketing strategy already set to %s", Integer.valueOf(this.zzaQY));
            zzac.zzb(i > 0, "Must specify a valid minimum duration for an activity segment: %d", Integer.valueOf(i));
            this.zzaQY = 4;
            this.zzaVc = timeUnit.toMillis((long) i);
            return this;
        }

        public Builder bucketByActivitySegment(int i, TimeUnit timeUnit, DataSource dataSource) {
            zzac.zzb(this.zzaQY == 0, "Bucketing strategy already set to %s", Integer.valueOf(this.zzaQY));
            zzac.zzb(i > 0, "Must specify a valid minimum duration for an activity segment: %d", Integer.valueOf(i));
            zzac.zzb(dataSource != null, (Object) "Invalid activity data source specified");
            zzac.zzb(dataSource.getDataType().equals(DataType.TYPE_ACTIVITY_SEGMENT), "Invalid activity data source specified: %s", dataSource);
            this.zzaVd = dataSource;
            this.zzaQY = 4;
            this.zzaVc = timeUnit.toMillis((long) i);
            return this;
        }

        public Builder bucketByActivityType(int i, TimeUnit timeUnit) {
            zzac.zzb(this.zzaQY == 0, "Bucketing strategy already set to %s", Integer.valueOf(this.zzaQY));
            zzac.zzb(i > 0, "Must specify a valid minimum duration for an activity segment: %d", Integer.valueOf(i));
            this.zzaQY = 3;
            this.zzaVc = timeUnit.toMillis((long) i);
            return this;
        }

        public Builder bucketByActivityType(int i, TimeUnit timeUnit, DataSource dataSource) {
            zzac.zzb(this.zzaQY == 0, "Bucketing strategy already set to %s", Integer.valueOf(this.zzaQY));
            zzac.zzb(i > 0, "Must specify a valid minimum duration for an activity segment: %d", Integer.valueOf(i));
            zzac.zzb(dataSource != null, (Object) "Invalid activity data source specified");
            zzac.zzb(dataSource.getDataType().equals(DataType.TYPE_ACTIVITY_SEGMENT), "Invalid activity data source specified: %s", dataSource);
            this.zzaVd = dataSource;
            this.zzaQY = 3;
            this.zzaVc = timeUnit.toMillis((long) i);
            return this;
        }

        public Builder bucketBySession(int i, TimeUnit timeUnit) {
            zzac.zzb(this.zzaQY == 0, "Bucketing strategy already set to %s", Integer.valueOf(this.zzaQY));
            zzac.zzb(i > 0, "Must specify a valid minimum duration for an activity segment: %d", Integer.valueOf(i));
            this.zzaQY = 2;
            this.zzaVc = timeUnit.toMillis((long) i);
            return this;
        }

        public Builder bucketByTime(int i, TimeUnit timeUnit) {
            zzac.zzb(this.zzaQY == 0, "Bucketing strategy already set to %s", Integer.valueOf(this.zzaQY));
            zzac.zzb(i > 0, "Must specify a valid minimum duration for an activity segment: %d", Integer.valueOf(i));
            this.zzaQY = 1;
            this.zzaVc = timeUnit.toMillis((long) i);
            return this;
        }

        public DataReadRequest build() {
            boolean z = true;
            boolean z2 = (this.zzaUV.isEmpty() && this.zzaQU.isEmpty() && this.zzaVb.isEmpty() && this.zzaVa.isEmpty()) ? false : true;
            zzac.zza(z2, (Object) "Must add at least one data source (aggregated or detailed)");
            zzac.zza(this.zzaed > 0, "Invalid start time: %s", Long.valueOf(this.zzaed));
            z2 = this.zzaQV > 0 && this.zzaQV > this.zzaed;
            zzac.zza(z2, "Invalid end time: %s", Long.valueOf(this.zzaQV));
            z2 = this.zzaVb.isEmpty() && this.zzaVa.isEmpty();
            if (!(z2 && this.zzaQY == 0) && (z2 || this.zzaQY == 0)) {
                z = false;
            }
            zzac.zza(z, (Object) "Must specify a valid bucketing strategy while requesting aggregation");
            return new DataReadRequest();
        }

        public Builder enableServerQueries() {
            this.zzaVg = true;
            return this;
        }

        public Builder read(DataSource dataSource) {
            zzac.zzb((Object) dataSource, (Object) "Attempting to add a null data source");
            zzac.zzb(!this.zzaVb.contains(dataSource), (Object) "Cannot add the same data source as aggregated and detailed");
            if (!this.zzaUV.contains(dataSource)) {
                this.zzaUV.add(dataSource);
            }
            return this;
        }

        public Builder read(DataType dataType) {
            zzac.zzb((Object) dataType, (Object) "Attempting to use a null data type");
            zzac.zza(!this.zzaVa.contains(dataType), (Object) "Cannot add the same data type as aggregated and detailed");
            if (!this.zzaQU.contains(dataType)) {
                this.zzaQU.add(dataType);
            }
            return this;
        }

        public Builder setLimit(int i) {
            zzac.zzb(i > 0, "Invalid limit %d is specified", Integer.valueOf(i));
            this.zzaVe = i;
            return this;
        }

        public Builder setTimeRange(long j, long j2, TimeUnit timeUnit) {
            this.zzaed = timeUnit.toMillis(j);
            this.zzaQV = timeUnit.toMillis(j2);
            return this;
        }
    }

    static {
        CREATOR = new zzi();
    }

    DataReadRequest(int i, List<DataType> list, List<DataSource> list2, long j, long j2, List<DataType> list3, List<DataSource> list4, int i2, long j3, DataSource dataSource, int i3, boolean z, boolean z2, IBinder iBinder, List<Device> list5, List<Integer> list6) {
        this.mVersionCode = i;
        this.zzaQU = list;
        this.zzaUV = list2;
        this.zzaed = j;
        this.zzaQV = j2;
        this.zzaVa = list3;
        this.zzaVb = list4;
        this.zzaQY = i2;
        this.zzaVc = j3;
        this.zzaVd = dataSource;
        this.zzaVe = i3;
        this.zzaVf = z;
        this.zzaVg = z2;
        this.zzaVh = iBinder == null ? null : zzanz.zza.zzcq(iBinder);
        if (list5 == null) {
            list5 = Collections.emptyList();
        }
        this.zzaVi = list5;
        if (list6 == null) {
            list6 = Collections.emptyList();
        }
        this.zzaVj = list6;
    }

    private DataReadRequest(Builder builder) {
        this(builder.zzaQU, builder.zzaUV, builder.zzaed, builder.zzaQV, builder.zzaVa, builder.zzaVb, builder.zzaQY, builder.zzaVc, builder.zzaVd, builder.zzaVe, false, builder.zzaVg, null, builder.zzaVi, builder.zzaVj);
    }

    public DataReadRequest(DataReadRequest dataReadRequest, zzanz com_google_android_gms_internal_zzanz) {
        zzanz com_google_android_gms_internal_zzanz2 = com_google_android_gms_internal_zzanz;
        this(dataReadRequest.zzaQU, dataReadRequest.zzaUV, dataReadRequest.zzaed, dataReadRequest.zzaQV, dataReadRequest.zzaVa, dataReadRequest.zzaVb, dataReadRequest.zzaQY, dataReadRequest.zzaVc, dataReadRequest.zzaVd, dataReadRequest.zzaVe, dataReadRequest.zzaVf, dataReadRequest.zzaVg, com_google_android_gms_internal_zzanz2, dataReadRequest.zzaVi, dataReadRequest.zzaVj);
    }

    public DataReadRequest(List<DataType> list, List<DataSource> list2, long j, long j2, List<DataType> list3, List<DataSource> list4, int i, long j3, DataSource dataSource, int i2, boolean z, boolean z2, zzanz com_google_android_gms_internal_zzanz, List<Device> list5, List<Integer> list6) {
        this(6, list, list2, j, j2, list3, list4, i, j3, dataSource, i2, z, z2, com_google_android_gms_internal_zzanz == null ? null : com_google_android_gms_internal_zzanz.asBinder(), list5, list6);
    }

    private boolean zzb(DataReadRequest dataReadRequest) {
        return this.zzaQU.equals(dataReadRequest.zzaQU) && this.zzaUV.equals(dataReadRequest.zzaUV) && this.zzaed == dataReadRequest.zzaed && this.zzaQV == dataReadRequest.zzaQV && this.zzaQY == dataReadRequest.zzaQY && this.zzaVb.equals(dataReadRequest.zzaVb) && this.zzaVa.equals(dataReadRequest.zzaVa) && zzaa.equal(this.zzaVd, dataReadRequest.zzaVd) && this.zzaVc == dataReadRequest.zzaVc && this.zzaVg == dataReadRequest.zzaVg && this.zzaVe == dataReadRequest.zzaVe && this.zzaVf == dataReadRequest.zzaVf && zzaa.equal(this.zzaVh, dataReadRequest.zzaVh) && zzaa.equal(this.zzaVi, dataReadRequest.zzaVi) && zzaa.equal(this.zzaVj, dataReadRequest.zzaVj);
    }

    public boolean equals(Object obj) {
        return this == obj || ((obj instanceof DataReadRequest) && zzb((DataReadRequest) obj));
    }

    public DataSource getActivityDataSource() {
        return this.zzaVd;
    }

    public List<DataSource> getAggregatedDataSources() {
        return this.zzaVb;
    }

    public List<DataType> getAggregatedDataTypes() {
        return this.zzaVa;
    }

    public long getBucketDuration(TimeUnit timeUnit) {
        return timeUnit.convert(this.zzaVc, TimeUnit.MILLISECONDS);
    }

    public int getBucketType() {
        return this.zzaQY;
    }

    public IBinder getCallbackBinder() {
        return this.zzaVh == null ? null : this.zzaVh.asBinder();
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

    public int getLimit() {
        return this.zzaVe;
    }

    public long getStartTime(TimeUnit timeUnit) {
        return timeUnit.convert(this.zzaed, TimeUnit.MILLISECONDS);
    }

    int getVersionCode() {
        return this.mVersionCode;
    }

    public int hashCode() {
        return zzaa.hashCode(Integer.valueOf(this.zzaQY), Long.valueOf(this.zzaed), Long.valueOf(this.zzaQV));
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("DataReadRequest{");
        if (!this.zzaQU.isEmpty()) {
            for (DataType zzBv : this.zzaQU) {
                stringBuilder.append(zzBv.zzBv()).append(" ");
            }
        }
        if (!this.zzaUV.isEmpty()) {
            for (DataSource toDebugString : this.zzaUV) {
                stringBuilder.append(toDebugString.toDebugString()).append(" ");
            }
        }
        if (this.zzaQY != 0) {
            stringBuilder.append("bucket by ").append(Bucket.zzgn(this.zzaQY));
            if (this.zzaVc > 0) {
                stringBuilder.append(" >").append(this.zzaVc).append("ms");
            }
            stringBuilder.append(": ");
        }
        if (!this.zzaVa.isEmpty()) {
            for (DataType zzBv2 : this.zzaVa) {
                stringBuilder.append(zzBv2.zzBv()).append(" ");
            }
        }
        if (!this.zzaVb.isEmpty()) {
            for (DataSource toDebugString2 : this.zzaVb) {
                stringBuilder.append(toDebugString2.toDebugString()).append(" ");
            }
        }
        stringBuilder.append(String.format("(%tF %tT - %tF %tT)", new Object[]{Long.valueOf(this.zzaed), Long.valueOf(this.zzaed), Long.valueOf(this.zzaQV), Long.valueOf(this.zzaQV)}));
        if (this.zzaVd != null) {
            stringBuilder.append("activities: ").append(this.zzaVd.toDebugString());
        }
        if (!this.zzaVj.isEmpty()) {
            stringBuilder.append("quality: ");
            for (Integer intValue : this.zzaVj) {
                stringBuilder.append(DataSource.zzgu(intValue.intValue())).append(" ");
            }
        }
        if (this.zzaVg) {
            stringBuilder.append(" +server");
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzi.zza(this, parcel, i);
    }

    public boolean zzCd() {
        return this.zzaVg;
    }

    public boolean zzCe() {
        return this.zzaVf;
    }

    public long zzCf() {
        return this.zzaVc;
    }

    public List<Device> zzCg() {
        return this.zzaVi;
    }

    public List<Integer> zzCh() {
        return this.zzaVj;
    }

    public long zzpN() {
        return this.zzaed;
    }

    public long zzzx() {
        return this.zzaQV;
    }
}
