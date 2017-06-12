package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.drive.zzc;

public class zzaiu extends zza {
    public static final Creator<zzaiu> CREATOR;
    final int mVersionCode;
    final zzc zzaLH;
    final boolean zzaMF;

    static {
        CREATOR = new zzaiv();
    }

    zzaiu(int i, zzc com_google_android_gms_drive_zzc, boolean z) {
        this.mVersionCode = i;
        this.zzaLH = com_google_android_gms_drive_zzc;
        this.zzaMF = z;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzaiv.zza(this, parcel, i);
    }

    public zzc zzAo() {
        return this.zzaLH;
    }

    public boolean zzAp() {
        return this.zzaMF;
    }
}
