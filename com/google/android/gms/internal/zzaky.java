package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.drive.DriveId;

public class zzaky extends zza {
    public static final Creator<zzaky> CREATOR;
    final int mVersionCode;
    final DriveId zzaKS;

    static {
        CREATOR = new zzakz();
    }

    zzaky(int i, DriveId driveId) {
        this.mVersionCode = i;
        this.zzaKS = driveId;
    }

    public zzaky(DriveId driveId) {
        this(1, driveId);
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzakz.zza(this, parcel, i);
    }
}
