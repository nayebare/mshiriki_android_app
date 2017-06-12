package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.drive.DriveId;

public class zzakh extends zza {
    public static final Creator<zzakh> CREATOR;
    final int mVersionCode;
    final String zzaJF;
    final String zzaJT;
    final DriveId zzaJj;
    final boolean zzaKM;

    static {
        CREATOR = new zzaki();
    }

    zzakh(int i, DriveId driveId, String str, boolean z, String str2) {
        this.mVersionCode = i;
        this.zzaJj = driveId;
        this.zzaJT = str;
        this.zzaKM = z;
        this.zzaJF = str2;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzaki.zza(this, parcel, i);
    }
}
