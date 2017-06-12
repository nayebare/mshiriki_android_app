package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;

public class zzalm extends zza {
    public static final Creator<zzalm> CREATOR;
    final String mName;
    final int mVersionCode;
    final boolean zzaPm;
    final boolean zzaPn;

    static {
        CREATOR = new zzaln();
    }

    zzalm(int i, boolean z, String str, boolean z2) {
        this.mVersionCode = i;
        this.zzaPm = z;
        this.mName = str;
        this.zzaPn = z2;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzaln.zza(this, parcel, i);
    }
}
