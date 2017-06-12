package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;

public class zzamj extends zza {
    public static final Creator<zzamj> CREATOR;
    final int mVersionCode;
    final int zzaPu;

    static {
        CREATOR = new zzamk();
    }

    zzamj(int i, int i2) {
        this.mVersionCode = i;
        this.zzaPu = i2;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzamk.zza(this, parcel, i);
    }
}
