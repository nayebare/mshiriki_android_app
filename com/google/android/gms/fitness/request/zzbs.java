package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.internal.zzaos;

public class zzbs extends zza {
    public static final Creator<zzbs> CREATOR;
    private final int versionCode;
    private final zzaos zzaVG;
    private final zzaj zzaWm;

    static {
        CREATOR = new zzbt();
    }

    zzbs(int i, IBinder iBinder, IBinder iBinder2) {
        zzaj com_google_android_gms_fitness_request_zzaj = null;
        this.versionCode = i;
        this.zzaVG = iBinder == null ? null : zzaos.zza.zzcJ(iBinder);
        if (iBinder2 != null) {
            com_google_android_gms_fitness_request_zzaj = zzaj.zza.zzcO(iBinder2);
        }
        this.zzaWm = com_google_android_gms_fitness_request_zzaj;
    }

    public IBinder getCallbackBinder() {
        return this.zzaVG == null ? null : this.zzaVG.asBinder();
    }

    int getVersionCode() {
        return this.versionCode;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzbt.zza(this, parcel, i);
    }

    public IBinder zzCB() {
        return this.zzaWm == null ? null : this.zzaWm.asBinder();
    }
}
