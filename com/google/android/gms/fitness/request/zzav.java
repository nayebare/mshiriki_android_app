package com.google.android.gms.fitness.request;

import android.app.PendingIntent;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.zzaa;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.fitness.data.zzu;
import com.google.android.gms.internal.zzaos;
import com.google.android.gms.internal.zzarj;
import com.google.android.gms.location.LocationRequest;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class zzav extends zza {
    public static final Creator<zzav> CREATOR;
    private final PendingIntent mPendingIntent;
    private final int mVersionCode;
    private DataSource zzaRJ;
    private DataType zzaRK;
    private final long zzaTN;
    private final int zzaTO;
    private final zzaos zzaUS;
    private zzu zzaVN;
    int zzaVO;
    int zzaVP;
    private final long zzaVQ;
    private final long zzaVR;
    private final List<LocationRequest> zzaVS;
    private final long zzaVT;
    private final List<zzarj> zzaVU;

    static {
        CREATOR = new zzaw();
    }

    zzav(int i, DataSource dataSource, DataType dataType, IBinder iBinder, int i2, int i3, long j, long j2, PendingIntent pendingIntent, long j3, int i4, List<LocationRequest> list, long j4, IBinder iBinder2) {
        this.mVersionCode = i;
        this.zzaRJ = dataSource;
        this.zzaRK = dataType;
        this.zzaVN = iBinder == null ? null : zzu.zza.zzcg(iBinder);
        if (j == 0) {
            j = (long) i2;
        }
        this.zzaTN = j;
        this.zzaVR = j3;
        if (j2 == 0) {
            j2 = (long) i3;
        }
        this.zzaVQ = j2;
        this.zzaVS = list;
        this.mPendingIntent = pendingIntent;
        this.zzaTO = i4;
        this.zzaVU = Collections.emptyList();
        this.zzaVT = j4;
        this.zzaUS = zzaos.zza.zzcJ(iBinder2);
    }

    public zzav(DataSource dataSource, DataType dataType, zzu com_google_android_gms_fitness_data_zzu, PendingIntent pendingIntent, long j, long j2, long j3, int i, List<LocationRequest> list, List<zzarj> list2, long j4, zzaos com_google_android_gms_internal_zzaos) {
        this.mVersionCode = 6;
        this.zzaRJ = dataSource;
        this.zzaRK = dataType;
        this.zzaVN = com_google_android_gms_fitness_data_zzu;
        this.mPendingIntent = pendingIntent;
        this.zzaTN = j;
        this.zzaVR = j2;
        this.zzaVQ = j3;
        this.zzaTO = i;
        this.zzaVS = list;
        this.zzaVU = list2;
        this.zzaVT = j4;
        this.zzaUS = com_google_android_gms_internal_zzaos;
    }

    public zzav(SensorRequest sensorRequest, zzu com_google_android_gms_fitness_data_zzu, PendingIntent pendingIntent, zzaos com_google_android_gms_internal_zzaos) {
        zzu com_google_android_gms_fitness_data_zzu2 = com_google_android_gms_fitness_data_zzu;
        PendingIntent pendingIntent2 = pendingIntent;
        this(sensorRequest.getDataSource(), sensorRequest.getDataType(), com_google_android_gms_fitness_data_zzu2, pendingIntent2, sensorRequest.getSamplingRate(TimeUnit.MICROSECONDS), sensorRequest.getFastestRate(TimeUnit.MICROSECONDS), sensorRequest.getMaxDeliveryLatency(TimeUnit.MICROSECONDS), sensorRequest.getAccuracyMode(), null, Collections.emptyList(), sensorRequest.zzCu(), com_google_android_gms_internal_zzaos);
    }

    private boolean zzb(zzav com_google_android_gms_fitness_request_zzav) {
        return zzaa.equal(this.zzaRJ, com_google_android_gms_fitness_request_zzav.zzaRJ) && zzaa.equal(this.zzaRK, com_google_android_gms_fitness_request_zzav.zzaRK) && this.zzaTN == com_google_android_gms_fitness_request_zzav.zzaTN && this.zzaVR == com_google_android_gms_fitness_request_zzav.zzaVR && this.zzaVQ == com_google_android_gms_fitness_request_zzav.zzaVQ && this.zzaTO == com_google_android_gms_fitness_request_zzav.zzaTO && zzaa.equal(this.zzaVS, com_google_android_gms_fitness_request_zzav.zzaVS);
    }

    public boolean equals(Object obj) {
        return this == obj || ((obj instanceof zzav) && zzb((zzav) obj));
    }

    public int getAccuracyMode() {
        return this.zzaTO;
    }

    public IBinder getCallbackBinder() {
        return this.zzaUS == null ? null : this.zzaUS.asBinder();
    }

    public DataSource getDataSource() {
        return this.zzaRJ;
    }

    public DataType getDataType() {
        return this.zzaRK;
    }

    public PendingIntent getIntent() {
        return this.mPendingIntent;
    }

    int getVersionCode() {
        return this.mVersionCode;
    }

    public int hashCode() {
        return zzaa.hashCode(this.zzaRJ, this.zzaRK, this.zzaVN, Long.valueOf(this.zzaTN), Long.valueOf(this.zzaVR), Long.valueOf(this.zzaVQ), Integer.valueOf(this.zzaTO), this.zzaVS);
    }

    public String toString() {
        return String.format("SensorRegistrationRequest{type %s source %s interval %s fastest %s latency %s}", new Object[]{this.zzaRK, this.zzaRJ, Long.valueOf(this.zzaTN), Long.valueOf(this.zzaVR), Long.valueOf(this.zzaVQ)});
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzaw.zza(this, parcel, i);
    }

    public long zzBK() {
        return this.zzaTN;
    }

    public long zzCp() {
        return this.zzaVR;
    }

    public long zzCq() {
        return this.zzaVQ;
    }

    public List<LocationRequest> zzCr() {
        return this.zzaVS;
    }

    public long zzCs() {
        return this.zzaVT;
    }

    IBinder zzCt() {
        return this.zzaVN == null ? null : this.zzaVN.asBinder();
    }
}
