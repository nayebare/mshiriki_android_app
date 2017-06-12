package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;

public class zzafq extends zza {
    public static final Creator<zzafq> CREATOR;
    public final int versionCode;

    static {
        CREATOR = new zzafp();
    }

    zzafq(int i) {
        this.versionCode = i;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzafp.zza(this, parcel, i);
    }
}
