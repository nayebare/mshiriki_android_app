package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;

@Deprecated
public class zzaem extends zza {
    public static final Creator<zzaem> CREATOR;
    public final int versionCode;
    public final String zzaA;
    public final boolean zzaIc;

    static {
        CREATOR = new zzaen();
    }

    zzaem(int i, boolean z, String str) {
        this.versionCode = i;
        this.zzaIc = z;
        this.zzaA = str;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzaen.zza(this, parcel, i);
    }
}
