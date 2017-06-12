package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;

public class zzaiw extends zza {
    public static final Creator<zzaiw> CREATOR;
    final int mVersionCode;
    final zzahy zzaMG;

    static {
        CREATOR = new zzaix();
    }

    zzaiw(int i, zzahy com_google_android_gms_internal_zzahy) {
        this.mVersionCode = i;
        this.zzaMG = com_google_android_gms_internal_zzahy;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzaix.zza(this, parcel, i);
    }

    public zzahy zzAq() {
        return this.zzaMG;
    }
}
