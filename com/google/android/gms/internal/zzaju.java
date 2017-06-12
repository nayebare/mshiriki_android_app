package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;

public class zzaju extends zza {
    public static final Creator<zzaju> CREATOR;
    final int mVersionCode;
    final boolean zzaLq;

    static {
        CREATOR = new zzajv();
    }

    zzaju(int i, boolean z) {
        this.mVersionCode = i;
        this.zzaLq = z;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzajv.zza(this, parcel, i);
    }
}
