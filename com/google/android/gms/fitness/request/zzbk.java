package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.internal.zzaos;

public class zzbk extends zza {
    public static final Creator<zzbk> CREATOR;
    private final int mVersionCode;
    private final zzaos zzaUS;
    private final zzai zzaWi;

    static {
        CREATOR = new zzbl();
    }

    zzbk(int i, IBinder iBinder, IBinder iBinder2) {
        this.mVersionCode = i;
        this.zzaWi = zzai.zza.zzcN(iBinder);
        this.zzaUS = zzaos.zza.zzcJ(iBinder2);
    }

    public zzbk(BleScanCallback bleScanCallback, zzaos com_google_android_gms_internal_zzaos) {
        this(zza.zza.zzBW().zzb(bleScanCallback), com_google_android_gms_internal_zzaos);
    }

    public zzbk(zzai com_google_android_gms_fitness_request_zzai, zzaos com_google_android_gms_internal_zzaos) {
        this.mVersionCode = 3;
        this.zzaWi = com_google_android_gms_fitness_request_zzai;
        this.zzaUS = com_google_android_gms_internal_zzaos;
    }

    public IBinder getCallbackBinder() {
        return this.zzaUS == null ? null : this.zzaUS.asBinder();
    }

    int getVersionCode() {
        return this.mVersionCode;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzbl.zza(this, parcel, i);
    }

    public IBinder zzCy() {
        return this.zzaWi.asBinder();
    }
}
