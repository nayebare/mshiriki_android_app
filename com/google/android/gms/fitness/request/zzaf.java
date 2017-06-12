package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.internal.zzaou;

public class zzaf extends zza {
    public static final Creator<zzaf> CREATOR;
    private final int mVersionCode;
    private final zzaou zzaVx;

    static {
        CREATOR = new zzag();
    }

    zzaf(int i, IBinder iBinder) {
        this.mVersionCode = i;
        this.zzaVx = zzaou.zza.zzcL(iBinder);
    }

    public IBinder getCallbackBinder() {
        return this.zzaVx.asBinder();
    }

    int getVersionCode() {
        return this.mVersionCode;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzag.zza(this, parcel, i);
    }
}
