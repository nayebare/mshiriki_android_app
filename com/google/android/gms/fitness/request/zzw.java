package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.internal.zzaos;

public class zzw extends zza {
    public static final Creator<zzw> CREATOR;
    private final int mVersionCode;
    private final zzaos zzaUS;

    static {
        CREATOR = new zzx();
    }

    zzw(int i, IBinder iBinder) {
        this.mVersionCode = i;
        this.zzaUS = zzaos.zza.zzcJ(iBinder);
    }

    public zzw(zzaos com_google_android_gms_internal_zzaos) {
        this.mVersionCode = 2;
        this.zzaUS = com_google_android_gms_internal_zzaos;
    }

    public IBinder getCallbackBinder() {
        return this.zzaUS.asBinder();
    }

    int getVersionCode() {
        return this.mVersionCode;
    }

    public String toString() {
        return String.format("DisableFitRequest", new Object[0]);
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzx.zza(this, parcel, i);
    }
}
