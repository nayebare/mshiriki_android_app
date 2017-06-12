package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;

public class zzamh extends zza {
    public static final Creator<zzamh> CREATOR;
    final int mIndex;
    final int mVersionCode;
    final String zzaPr;
    final boolean zzaPs;
    final int zzaPt;

    static {
        CREATOR = new zzami();
    }

    zzamh(int i, String str, int i2, boolean z, int i3) {
        this.mVersionCode = i;
        this.zzaPr = str;
        this.mIndex = i2;
        this.zzaPs = z;
        this.zzaPt = i3;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzami.zza(this, parcel, i);
    }
}
