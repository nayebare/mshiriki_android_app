package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.zzm;

public class zzagd extends zza {
    public static final Creator<zzagd> CREATOR;
    final int mVersionCode;
    final String zzaJF;
    final DriveId zzaJj;
    final zzm zzaKJ;
    final boolean zzaKK;
    final String zzaKL;
    final boolean zzaKM;

    static {
        CREATOR = new zzage();
    }

    zzagd(int i, DriveId driveId, zzm com_google_android_gms_drive_zzm, boolean z, String str, boolean z2, String str2) {
        this.mVersionCode = i;
        this.zzaJj = driveId;
        this.zzaKJ = com_google_android_gms_drive_zzm;
        this.zzaKK = z;
        this.zzaKL = str;
        this.zzaKM = z2;
        this.zzaJF = str2;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzage.zza(this, parcel, i);
    }
}
