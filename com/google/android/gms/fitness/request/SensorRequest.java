package com.google.android.gms.fitness.request;

import android.os.SystemClock;
import android.support.v7.mediarouter.C0308R;
import com.google.android.gms.common.internal.zzaa;
import com.google.android.gms.common.internal.zzac;
import com.google.android.gms.drive.MetadataChangeSet;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.internal.zzank;
import com.google.android.gms.location.LocationRequest;
import java.util.concurrent.TimeUnit;

public class SensorRequest {
    public static final int ACCURACY_MODE_DEFAULT = 2;
    public static final int ACCURACY_MODE_HIGH = 3;
    public static final int ACCURACY_MODE_LOW = 1;
    private final DataSource zzaRJ;
    private final DataType zzaRK;
    private final long zzaTN;
    private final int zzaTO;
    private final long zzaVQ;
    private final long zzaVR;
    private final LocationRequest zzaVV;
    private final long zzaVW;

    public static class Builder {
        private DataSource zzaRJ;
        private DataType zzaRK;
        private long zzaTN;
        private int zzaTO;
        private long zzaVQ;
        private long zzaVR;
        private long zzaVW;
        private boolean zzaVX;

        public Builder() {
            this.zzaTN = -1;
            this.zzaVR = 0;
            this.zzaVQ = 0;
            this.zzaVX = false;
            this.zzaTO = SensorRequest.ACCURACY_MODE_DEFAULT;
            this.zzaVW = Long.MAX_VALUE;
        }

        public SensorRequest build() {
            boolean z = false;
            boolean z2 = (this.zzaRJ == null && this.zzaRK == null) ? false : true;
            zzac.zza(z2, (Object) "Must call setDataSource() or setDataType()");
            if (this.zzaRK == null || this.zzaRJ == null || this.zzaRK.equals(this.zzaRJ.getDataType())) {
                z = true;
            }
            zzac.zza(z, (Object) "Specified data type is incompatible with specified data source");
            return new SensorRequest();
        }

        public Builder setAccuracyMode(int i) {
            this.zzaTO = zzank.zzgT(i);
            return this;
        }

        public Builder setDataSource(DataSource dataSource) {
            this.zzaRJ = dataSource;
            return this;
        }

        public Builder setDataType(DataType dataType) {
            this.zzaRK = dataType;
            return this;
        }

        public Builder setFastestRate(int i, TimeUnit timeUnit) {
            zzac.zzb(i >= 0, (Object) "Cannot use a negative interval");
            this.zzaVX = true;
            this.zzaVR = timeUnit.toMicros((long) i);
            return this;
        }

        public Builder setMaxDeliveryLatency(int i, TimeUnit timeUnit) {
            zzac.zzb(i >= 0, (Object) "Cannot use a negative delivery interval");
            this.zzaVQ = timeUnit.toMicros((long) i);
            return this;
        }

        public Builder setSamplingRate(long j, TimeUnit timeUnit) {
            zzac.zzb(j >= 0, (Object) "Cannot use a negative sampling interval");
            this.zzaTN = timeUnit.toMicros(j);
            if (!this.zzaVX) {
                this.zzaVR = this.zzaTN / 2;
            }
            return this;
        }

        public Builder setTimeout(long j, TimeUnit timeUnit) {
            boolean z = true;
            boolean z2 = j > 0;
            Object[] objArr = new Object[SensorRequest.ACCURACY_MODE_LOW];
            objArr[0] = Long.valueOf(j);
            zzac.zzb(z2, "Invalid time out value specified: %d", objArr);
            if (timeUnit == null) {
                z = false;
            }
            zzac.zzb(z, (Object) "Invalid time unit specified");
            this.zzaVW = timeUnit.toMicros(j);
            return this;
        }
    }

    private SensorRequest(DataSource dataSource, LocationRequest locationRequest) {
        this.zzaVV = locationRequest;
        this.zzaTN = TimeUnit.MILLISECONDS.toMicros(locationRequest.getInterval());
        this.zzaVR = TimeUnit.MILLISECONDS.toMicros(locationRequest.getFastestInterval());
        this.zzaVQ = this.zzaTN;
        this.zzaRK = dataSource.getDataType();
        this.zzaTO = zza(locationRequest);
        this.zzaRJ = dataSource;
        long expirationTime = locationRequest.getExpirationTime();
        if (expirationTime == Long.MAX_VALUE) {
            this.zzaVW = Long.MAX_VALUE;
        } else {
            this.zzaVW = TimeUnit.MILLISECONDS.toMicros(expirationTime - SystemClock.elapsedRealtime());
        }
    }

    private SensorRequest(Builder builder) {
        this.zzaRJ = builder.zzaRJ;
        this.zzaRK = builder.zzaRK;
        this.zzaTN = builder.zzaTN;
        this.zzaVR = builder.zzaVR;
        this.zzaVQ = builder.zzaVQ;
        this.zzaTO = builder.zzaTO;
        this.zzaVV = null;
        this.zzaVW = builder.zzaVW;
    }

    public static SensorRequest fromLocationRequest(DataSource dataSource, LocationRequest locationRequest) {
        return new SensorRequest(dataSource, locationRequest);
    }

    private static int zza(LocationRequest locationRequest) {
        switch (locationRequest.getPriority()) {
            case MetadataChangeSet.MAX_TOTAL_PROPERTIES_PER_RESOURCE /*100*/:
                return ACCURACY_MODE_HIGH;
            case C0308R.styleable.AppCompatTheme_checkboxStyle /*104*/:
                return ACCURACY_MODE_LOW;
            default:
                return ACCURACY_MODE_DEFAULT;
        }
    }

    private boolean zza(SensorRequest sensorRequest) {
        return zzaa.equal(this.zzaRJ, sensorRequest.zzaRJ) && zzaa.equal(this.zzaRK, sensorRequest.zzaRK) && this.zzaTN == sensorRequest.zzaTN && this.zzaVR == sensorRequest.zzaVR && this.zzaVQ == sensorRequest.zzaVQ && this.zzaTO == sensorRequest.zzaTO && zzaa.equal(this.zzaVV, sensorRequest.zzaVV) && this.zzaVW == sensorRequest.zzaVW;
    }

    public boolean equals(Object obj) {
        return this == obj || ((obj instanceof SensorRequest) && zza((SensorRequest) obj));
    }

    public int getAccuracyMode() {
        return this.zzaTO;
    }

    public DataSource getDataSource() {
        return this.zzaRJ;
    }

    public DataType getDataType() {
        return this.zzaRK;
    }

    public long getFastestRate(TimeUnit timeUnit) {
        return timeUnit.convert(this.zzaVR, TimeUnit.MICROSECONDS);
    }

    public long getMaxDeliveryLatency(TimeUnit timeUnit) {
        return timeUnit.convert(this.zzaVQ, TimeUnit.MICROSECONDS);
    }

    public long getSamplingRate(TimeUnit timeUnit) {
        return timeUnit.convert(this.zzaTN, TimeUnit.MICROSECONDS);
    }

    public int hashCode() {
        return zzaa.hashCode(this.zzaRJ, this.zzaRK, Long.valueOf(this.zzaTN), Long.valueOf(this.zzaVR), Long.valueOf(this.zzaVQ), Integer.valueOf(this.zzaTO), this.zzaVV, Long.valueOf(this.zzaVW));
    }

    public String toString() {
        return zzaa.zzv(this).zzg("dataSource", this.zzaRJ).zzg("dataType", this.zzaRK).zzg("samplingRateMicros", Long.valueOf(this.zzaTN)).zzg("deliveryLatencyMicros", Long.valueOf(this.zzaVQ)).zzg("timeOutMicros", Long.valueOf(this.zzaVW)).toString();
    }

    public long zzCu() {
        return this.zzaVW;
    }
}
