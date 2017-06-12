package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;

public class zzaml extends zza {
    public static final Creator<zzaml> CREATOR;
    final int mVersionCode;
    final int zzaPv;
    final int zzaPw;

    static {
        CREATOR = new zzamm();
    }

    zzaml(int i, int i2, int i3) {
        this.mVersionCode = i;
        this.zzaPv = i2;
        this.zzaPw = i3;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzamm.zza(this, parcel, i);
    }
}
