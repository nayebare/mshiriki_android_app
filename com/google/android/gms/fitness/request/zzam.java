package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.internal.zzaon;

public class zzam extends zza {
    public static final Creator<zzam> CREATOR;
    private final int mVersionCode;
    private final DataType zzaRK;
    private final zzaon zzaVC;

    static {
        CREATOR = new zzan();
    }

    zzam(int i, DataType dataType, IBinder iBinder) {
        this.mVersionCode = i;
        this.zzaRK = dataType;
        this.zzaVC = zzaon.zza.zzcE(iBinder);
    }

    public zzam(DataType dataType, zzaon com_google_android_gms_internal_zzaon) {
        this.mVersionCode = 3;
        this.zzaRK = dataType;
        this.zzaVC = com_google_android_gms_internal_zzaon;
    }

    public IBinder getCallbackBinder() {
        return this.zzaVC == null ? null : this.zzaVC.asBinder();
    }

    public DataType getDataType() {
        return this.zzaRK;
    }

    int getVersionCode() {
        return this.mVersionCode;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzan.zza(this, parcel, i);
    }
}
