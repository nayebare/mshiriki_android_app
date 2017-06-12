package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.drive.DriveId;

public class zzajw extends zza {
    public static final Creator<zzajw> CREATOR;
    final int mVersionCode;
    final int zzaJi;
    final DriveId zzaKS;
    final int zzaMX;

    static {
        CREATOR = new zzajx();
    }

    zzajw(int i, DriveId driveId, int i2, int i3) {
        this.mVersionCode = i;
        this.zzaKS = driveId;
        this.zzaJi = i2;
        this.zzaMX = i3;
    }

    public zzajw(DriveId driveId, int i, int i2) {
        this(1, driveId, i, i2);
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzajx.zza(this, parcel, i);
    }
}
