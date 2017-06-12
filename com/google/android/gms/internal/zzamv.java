package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;

public class zzamv extends zza {
    public static final Creator<zzamv> CREATOR;
    final int mIndex;
    final int mVersionCode;
    final int zzaPT;

    static {
        CREATOR = new zzamw();
    }

    zzamv(int i, int i2, int i3) {
        this.mVersionCode = i;
        this.mIndex = i2;
        this.zzaPT = i3;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzamw.zza(this, parcel, i);
    }
}
