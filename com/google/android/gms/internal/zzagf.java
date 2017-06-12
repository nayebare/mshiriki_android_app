package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.drive.DriveId;

public class zzagf extends zza {
    public static final Creator<zzagf> CREATOR;
    final int mVersionCode;
    final DriveId zzaJj;
    final long zzaKN;

    static {
        CREATOR = new zzagg();
    }

    zzagf(int i, long j, DriveId driveId) {
        this.mVersionCode = i;
        this.zzaKN = j;
        this.zzaJj = driveId;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzagg.zza(this, parcel, i);
    }
}
