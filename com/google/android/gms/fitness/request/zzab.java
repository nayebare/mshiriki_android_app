package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.internal.zzaoa;

public class zzab extends zza {
    public static final Creator<zzab> CREATOR;
    private final int versionCode;
    private final zzaoa zzaVv;

    static {
        CREATOR = new zzac();
    }

    zzab(int i, IBinder iBinder) {
        this.versionCode = i;
        this.zzaVv = zzaoa.zza.zzcr(iBinder);
    }

    public IBinder getCallbackBinder() {
        return this.zzaVv.asBinder();
    }

    int getVersionCode() {
        return this.versionCode;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzac.zza(this, parcel, i);
    }
}
