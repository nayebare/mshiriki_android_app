package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.drive.zzc;

public class zzagq extends zza {
    public static final Creator<zzagq> CREATOR;
    final int mVersionCode;
    final zzc zzaKU;
    final int zzaKW;
    final Boolean zzaKY;

    static {
        CREATOR = new zzagr();
    }

    zzagq(int i, zzc com_google_android_gms_drive_zzc, Boolean bool, int i2) {
        this.mVersionCode = i;
        this.zzaKU = com_google_android_gms_drive_zzc;
        this.zzaKY = bool;
        this.zzaKW = i2;
    }

    public zzagq(int i, boolean z) {
        this(1, null, Boolean.valueOf(z), i);
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzagr.zza(this, parcel, i);
    }
}
