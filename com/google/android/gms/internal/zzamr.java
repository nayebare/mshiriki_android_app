package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;

public class zzamr extends zza {
    public static final Creator<zzamr> CREATOR;
    final int mVersionCode;
    final String zzaPP;
    final String zzaPQ;
    final int zzaPR;
    final int zzaPS;

    static {
        CREATOR = new zzams();
    }

    zzamr(int i, String str, String str2, int i2, int i3) {
        this.mVersionCode = i;
        this.zzaPP = str;
        this.zzaPQ = str2;
        this.zzaPR = i2;
        this.zzaPS = i3;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzams.zza(this, parcel, i);
    }
}
