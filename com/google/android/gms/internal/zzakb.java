package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;

public class zzakb extends zza {
    public static final Creator<zzakb> CREATOR;
    final int mVersionCode;
    final int zzaMm;
    final int zzaMn;
    final boolean zzaNa;

    static {
        CREATOR = new zzakc();
    }

    zzakb(int i, int i2, int i3, boolean z) {
        this.mVersionCode = i;
        this.zzaMm = i2;
        this.zzaMn = i3;
        this.zzaNa = z;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzakc.zza(this, parcel, i);
    }
}
