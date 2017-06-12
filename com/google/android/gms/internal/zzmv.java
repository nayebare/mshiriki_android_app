package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;

@zzmb
public class zzmv extends zza {
    public static final Creator<zzmv> CREATOR;
    final int mVersionCode;
    String zzFy;

    static {
        CREATOR = new zzmw();
    }

    zzmv(int i, String str) {
        this.mVersionCode = i;
        this.zzFy = str;
    }

    public zzmv(String str) {
        this.mVersionCode = 1;
        this.zzFy = str;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzmw.zza(this, parcel, i);
    }

    public String zzje() {
        return this.zzFy;
    }
}
