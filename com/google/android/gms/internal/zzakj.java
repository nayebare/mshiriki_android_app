package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;

public class zzakj extends zza {
    public static final Creator<zzakj> CREATOR;
    final int mVersionCode;
    final zzahy zzaMG;

    static {
        CREATOR = new zzakk();
    }

    zzakj(int i, zzahy com_google_android_gms_internal_zzahy) {
        this.mVersionCode = i;
        this.zzaMG = com_google_android_gms_internal_zzahy;
    }

    public zzakj(zzahy com_google_android_gms_internal_zzahy) {
        this(1, com_google_android_gms_internal_zzahy);
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzakk.zza(this, parcel, i);
    }
}
