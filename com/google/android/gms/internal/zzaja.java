package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.drive.DriveId;

public class zzaja extends zza {
    public static final Creator<zzaja> CREATOR;
    final int mVersionCode;
    DriveId zzaKS;

    static {
        CREATOR = new zzajb();
    }

    zzaja(int i, DriveId driveId) {
        this.mVersionCode = i;
        this.zzaKS = driveId;
    }

    public DriveId getDriveId() {
        return this.zzaKS;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzajb.zza(this, parcel, i);
    }
}
