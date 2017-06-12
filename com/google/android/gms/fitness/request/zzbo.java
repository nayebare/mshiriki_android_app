package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.internal.zzaos;

public class zzbo extends zza {
    public static final Creator<zzbo> CREATOR;
    private final int mVersionCode;
    private final String zzaUQ;
    private final zzaos zzaUS;

    static {
        CREATOR = new zzbp();
    }

    zzbo(int i, String str, IBinder iBinder) {
        this.mVersionCode = i;
        this.zzaUQ = str;
        this.zzaUS = zzaos.zza.zzcJ(iBinder);
    }

    public zzbo(String str, zzaos com_google_android_gms_internal_zzaos) {
        this.mVersionCode = 5;
        this.zzaUQ = str;
        this.zzaUS = com_google_android_gms_internal_zzaos;
    }

    public IBinder getCallbackBinder() {
        return this.zzaUS == null ? null : this.zzaUS.asBinder();
    }

    public String getDeviceAddress() {
        return this.zzaUQ;
    }

    int getVersionCode() {
        return this.mVersionCode;
    }

    public String toString() {
        return String.format("UnclaimBleDeviceRequest{%s}", new Object[]{this.zzaUQ});
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzbp.zza(this, parcel, i);
    }
}
