package com.google.android.gms.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.zzac;

public class zzauy extends zza {
    public static final Creator<zzauy> CREATOR;
    final int versionCode;
    private final zzauj zzbwL;
    private final zzaup zzbwO;

    static {
        CREATOR = new zzauz();
    }

    zzauy(int i, zzauj com_google_android_gms_internal_zzauj, IBinder iBinder) {
        this.versionCode = i;
        this.zzbwL = (zzauj) zzac.zzw(com_google_android_gms_internal_zzauj);
        zzac.zzw(iBinder);
        this.zzbwO = zzaup.zza.zzew(iBinder);
    }

    public IBinder getCallbackBinder() {
        return this.zzbwO.asBinder();
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzauz.zza(this, parcel, i);
    }

    public zzauj zzMM() {
        return this.zzbwL;
    }
}
