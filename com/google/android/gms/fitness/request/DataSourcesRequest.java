package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.zzaa;
import com.google.android.gms.common.internal.zzac;
import com.google.android.gms.common.util.zzb;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.internal.zzaoa;
import java.util.Arrays;
import java.util.List;

public class DataSourcesRequest extends zza {
    public static final Creator<DataSourcesRequest> CREATOR;
    private final int mVersionCode;
    private final List<DataType> zzaQU;
    private final List<Integer> zzaVm;
    private final boolean zzaVn;
    private final zzaoa zzaVo;

    public static class Builder {
        private boolean zzaVn;
        private DataType[] zzaVp;
        private int[] zzaVq;

        public Builder() {
            this.zzaVp = new DataType[0];
            this.zzaVq = new int[]{0, 1};
            this.zzaVn = false;
        }

        public DataSourcesRequest build() {
            boolean z = true;
            zzac.zza(this.zzaVp.length > 0, (Object) "Must add at least one data type");
            if (this.zzaVq.length <= 0) {
                z = false;
            }
            zzac.zza(z, (Object) "Must add at least one data source type");
            return new DataSourcesRequest();
        }

        public Builder setDataSourceTypes(int... iArr) {
            this.zzaVq = iArr;
            return this;
        }

        public Builder setDataTypes(DataType... dataTypeArr) {
            this.zzaVp = dataTypeArr;
            return this;
        }
    }

    static {
        CREATOR = new zzl();
    }

    DataSourcesRequest(int i, List<DataType> list, List<Integer> list2, boolean z, IBinder iBinder) {
        this.mVersionCode = i;
        this.zzaQU = list;
        this.zzaVm = list2;
        this.zzaVn = z;
        this.zzaVo = zzaoa.zza.zzcr(iBinder);
    }

    private DataSourcesRequest(Builder builder) {
        this(zzb.zzb(builder.zzaVp), Arrays.asList(zzb.zza(builder.zzaVq)), false, null);
    }

    public DataSourcesRequest(DataSourcesRequest dataSourcesRequest, zzaoa com_google_android_gms_internal_zzaoa) {
        this(dataSourcesRequest.zzaQU, dataSourcesRequest.zzaVm, dataSourcesRequest.zzaVn, com_google_android_gms_internal_zzaoa);
    }

    public DataSourcesRequest(List<DataType> list, List<Integer> list2, boolean z, zzaoa com_google_android_gms_internal_zzaoa) {
        this.mVersionCode = 4;
        this.zzaQU = list;
        this.zzaVm = list2;
        this.zzaVn = z;
        this.zzaVo = com_google_android_gms_internal_zzaoa;
    }

    public IBinder getCallbackBinder() {
        return this.zzaVo == null ? null : this.zzaVo.asBinder();
    }

    public List<DataType> getDataTypes() {
        return this.zzaQU;
    }

    int getVersionCode() {
        return this.mVersionCode;
    }

    public String toString() {
        zzaa.zza zzg = zzaa.zzv(this).zzg("dataTypes", this.zzaQU).zzg("sourceTypes", this.zzaVm);
        if (this.zzaVn) {
            zzg.zzg("includeDbOnlySources", "true");
        }
        return zzg.toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzl.zza(this, parcel, i);
    }

    public List<Integer> zzCi() {
        return this.zzaVm;
    }

    public boolean zzCj() {
        return this.zzaVn;
    }
}
