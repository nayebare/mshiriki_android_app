package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.zzaa;
import com.google.android.gms.common.internal.zzac;
import com.google.android.gms.common.util.zzb;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.internal.zzaos;
import java.util.Collections;
import java.util.List;

public class StartBleScanRequest extends zza {
    public static final Creator<StartBleScanRequest> CREATOR;
    private final int mVersionCode;
    private final List<DataType> zzaQU;
    private final zzaos zzaUS;
    private final zzai zzaWi;
    private final int zzaWj;

    public static class Builder {
        private DataType[] zzaVp;
        private zzai zzaWi;
        private int zzaWj;

        public Builder() {
            this.zzaVp = new DataType[0];
            this.zzaWj = 10;
        }

        public StartBleScanRequest build() {
            zzac.zza(this.zzaWi != null, (Object) "Must set BleScanCallback");
            return new StartBleScanRequest();
        }

        public Builder setBleScanCallback(BleScanCallback bleScanCallback) {
            zza(zza.zza.zzBW().zza(bleScanCallback));
            return this;
        }

        public Builder setDataTypes(DataType... dataTypeArr) {
            this.zzaVp = dataTypeArr;
            return this;
        }

        public Builder setTimeoutSecs(int i) {
            boolean z = true;
            zzac.zzb(i > 0, (Object) "Stop time must be greater than zero");
            if (i > 60) {
                z = false;
            }
            zzac.zzb(z, (Object) "Stop time must be less than 1 minute");
            this.zzaWj = i;
            return this;
        }

        public Builder zza(zzai com_google_android_gms_fitness_request_zzai) {
            this.zzaWi = com_google_android_gms_fitness_request_zzai;
            return this;
        }
    }

    static {
        CREATOR = new zzbj();
    }

    StartBleScanRequest(int i, List<DataType> list, IBinder iBinder, int i2, IBinder iBinder2) {
        this.mVersionCode = i;
        this.zzaQU = list;
        this.zzaWi = zzai.zza.zzcN(iBinder);
        this.zzaWj = i2;
        this.zzaUS = zzaos.zza.zzcJ(iBinder2);
    }

    private StartBleScanRequest(Builder builder) {
        this(zzb.zzb(builder.zzaVp), builder.zzaWi, builder.zzaWj, null);
    }

    public StartBleScanRequest(StartBleScanRequest startBleScanRequest, zzaos com_google_android_gms_internal_zzaos) {
        this(startBleScanRequest.zzaQU, startBleScanRequest.zzaWi, startBleScanRequest.zzaWj, com_google_android_gms_internal_zzaos);
    }

    public StartBleScanRequest(List<DataType> list, zzai com_google_android_gms_fitness_request_zzai, int i, zzaos com_google_android_gms_internal_zzaos) {
        this.mVersionCode = 4;
        this.zzaQU = list;
        this.zzaWi = com_google_android_gms_fitness_request_zzai;
        this.zzaWj = i;
        this.zzaUS = com_google_android_gms_internal_zzaos;
    }

    public IBinder getCallbackBinder() {
        return this.zzaUS == null ? null : this.zzaUS.asBinder();
    }

    public List<DataType> getDataTypes() {
        return Collections.unmodifiableList(this.zzaQU);
    }

    public int getTimeoutSecs() {
        return this.zzaWj;
    }

    int getVersionCode() {
        return this.mVersionCode;
    }

    public String toString() {
        return zzaa.zzv(this).zzg("dataTypes", this.zzaQU).zzg("timeoutSecs", Integer.valueOf(this.zzaWj)).toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzbj.zza(this, parcel, i);
    }

    public IBinder zzCy() {
        return this.zzaWi.asBinder();
    }
}
