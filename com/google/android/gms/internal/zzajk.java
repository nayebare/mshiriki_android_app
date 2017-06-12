package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;

public class zzajk extends zza {
    public static final Creator<zzajk> CREATOR;
    final int mVersionCode;
    final boolean zztW;

    static {
        CREATOR = new zzajp();
    }

    zzajk(int i, boolean z) {
        this.mVersionCode = i;
        this.zztW = z;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzajp.zza(this, parcel, i);
    }
}
