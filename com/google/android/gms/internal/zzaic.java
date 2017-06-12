package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;

public class zzaic extends zza {
    public static final Creator<zzaic> CREATOR;
    final int mVersionCode;
    final String zzaJJ;
    final boolean zzaMs;

    static {
        CREATOR = new zzaid();
    }

    zzaic(int i, String str, boolean z) {
        this.mVersionCode = i;
        this.zzaJJ = str;
        this.zzaMs = z;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzaid.zza(this, parcel, i);
    }
}
