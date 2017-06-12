package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;

public class zzahg extends zza {
    public static final Creator<zzahg> CREATOR;
    final int mVersionCode;

    static {
        CREATOR = new zzahh();
    }

    public zzahg() {
        this(1);
    }

    zzahg(int i) {
        this.mVersionCode = i;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzahh.zza(this, parcel, i);
    }
}
