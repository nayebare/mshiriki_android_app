package com.google.android.gms.fitness.service;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.zzaa;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.zzu;
import java.util.concurrent.TimeUnit;

public class FitnessSensorServiceRequest extends zza {
    public static final Creator<FitnessSensorServiceRequest> CREATOR;
    public static final int UNSPECIFIED = -1;
    private final int mVersionCode;
    private final DataSource zzaRJ;
    private final zzu zzaVN;
    private final long zzaWG;
    private final long zzaWH;

    static {
        CREATOR = new zza();
    }

    FitnessSensorServiceRequest(int i, DataSource dataSource, IBinder iBinder, long j, long j2) {
        this.mVersionCode = i;
        this.zzaRJ = dataSource;
        this.zzaVN = zzu.zza.zzcg(iBinder);
        this.zzaWG = j;
        this.zzaWH = j2;
    }

    private boolean zza(FitnessSensorServiceRequest fitnessSensorServiceRequest) {
        return zzaa.equal(this.zzaRJ, fitnessSensorServiceRequest.zzaRJ) && this.zzaWG == fitnessSensorServiceRequest.zzaWG && this.zzaWH == fitnessSensorServiceRequest.zzaWH;
    }

    public boolean equals(Object obj) {
        return this == obj || ((obj instanceof FitnessSensorServiceRequest) && zza((FitnessSensorServiceRequest) obj));
    }

    public long getBatchInterval(TimeUnit timeUnit) {
        return timeUnit.convert(this.zzaWH, TimeUnit.MICROSECONDS);
    }

    public DataSource getDataSource() {
        return this.zzaRJ;
    }

    public SensorEventDispatcher getDispatcher() {
        return new zzb(this.zzaVN);
    }

    public long getSamplingRate(TimeUnit timeUnit) {
        return this.zzaWG == -1 ? -1 : timeUnit.convert(this.zzaWG, TimeUnit.MICROSECONDS);
    }

    int getVersionCode() {
        return this.mVersionCode;
    }

    public int hashCode() {
        return zzaa.hashCode(this.zzaRJ, Long.valueOf(this.zzaWG), Long.valueOf(this.zzaWH));
    }

    public String toString() {
        return String.format("FitnessSensorServiceRequest{%s}", new Object[]{this.zzaRJ});
    }

    public void writeToParcel(Parcel parcel, int i) {
        zza.zza(this, parcel, i);
    }

    public long zzBK() {
        return this.zzaWG;
    }

    public long zzCO() {
        return this.zzaWH;
    }

    IBinder zzCt() {
        return this.zzaVN.asBinder();
    }
}
