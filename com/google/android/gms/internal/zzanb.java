package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;

public class zzanb extends zza {
    public static final Creator<zzanb> CREATOR;
    final int mIndex;
    final int mVersionCode;
    final String zzaPW;
    final int zzaPX;
    final int zzaPv;
    final int zzaPw;

    static {
        CREATOR = new zzanc();
    }

    zzanb(int i, int i2, int i3, int i4, String str, int i5) {
        this.mVersionCode = i;
        this.mIndex = i2;
        this.zzaPv = i3;
        this.zzaPw = i4;
        this.zzaPW = str;
        this.zzaPX = i5;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzanc.zza(this, parcel, i);
    }
}
