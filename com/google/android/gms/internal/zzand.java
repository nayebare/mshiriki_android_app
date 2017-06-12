package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;

public class zzand extends zza {
    public static final Creator<zzand> CREATOR;
    final int mIndex;
    final int mVersionCode;
    final int zzaPv;
    final int zzaPw;

    static {
        CREATOR = new zzane();
    }

    zzand(int i, int i2, int i3, int i4) {
        this.mVersionCode = i;
        this.mIndex = i2;
        this.zzaPv = i3;
        this.zzaPw = i4;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzane.zza(this, parcel, i);
    }
}
