package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;

public class zzamx extends zza {
    public static final Creator<zzamx> CREATOR;
    final int mVersionCode;
    final int zzaPu;

    static {
        CREATOR = new zzamy();
    }

    zzamx(int i, int i2) {
        this.mVersionCode = i;
        this.zzaPu = i2;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzamy.zza(this, parcel, i);
    }
}
