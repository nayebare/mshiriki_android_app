package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.drive.DriveId;

public class zzaie extends zza {
    public static final Creator<zzaie> CREATOR;
    final int mVersionCode;
    final DriveId zzaKS;
    final boolean zzaMt;

    static {
        CREATOR = new zzaif();
    }

    zzaie(int i, DriveId driveId, boolean z) {
        this.mVersionCode = i;
        this.zzaKS = driveId;
        this.zzaMt = z;
    }

    public zzaie(DriveId driveId, boolean z) {
        this(1, driveId, z);
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzaif.zza(this, parcel, i);
    }
}
