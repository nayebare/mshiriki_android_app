package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.internal.zzaoc;

public class zzt extends zza {
    public static final Creator<zzt> CREATOR;
    private final int versionCode;
    private final zzaoc zzaVt;

    static {
        CREATOR = new zzy();
    }

    zzt(int i, IBinder iBinder) {
        this.versionCode = i;
        this.zzaVt = zzaoc.zza.zzct(iBinder);
    }

    public IBinder getCallbackBinder() {
        return this.zzaVt.asBinder();
    }

    int getVersionCode() {
        return this.versionCode;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzy.zza(this, parcel, i);
    }
}
