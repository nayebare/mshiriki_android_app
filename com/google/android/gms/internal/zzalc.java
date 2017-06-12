package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.drive.DriveId;

public class zzalc extends zza {
    public static final Creator<zzalc> CREATOR;
    final int mVersionCode;
    final String zzaJF;
    final String zzaJT;
    final DriveId zzaJj;
    final boolean zzaKM;
    final int zzaNe;

    static {
        CREATOR = new zzald();
    }

    zzalc(int i, DriveId driveId, String str, int i2, boolean z, String str2) {
        this.mVersionCode = i;
        this.zzaJj = driveId;
        this.zzaJT = str;
        this.zzaNe = i2;
        this.zzaKM = z;
        this.zzaJF = str2;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzald.zza(this, parcel, i);
    }
}
