package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;

public class zzalo extends zza {
    public static final Creator<zzalo> CREATOR;
    final int mVersionCode;

    static {
        CREATOR = new zzalp();
    }

    public zzalo() {
        this(1);
    }

    zzalo(int i) {
        this.mVersionCode = i;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzalp.zza(this, parcel, i);
    }
}
