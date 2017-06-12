package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.drive.DriveId;

public class zzaig extends zza {
    public static final Creator<zzaig> CREATOR;
    final int mVersionCode;
    final DriveId zzaJj;

    static {
        CREATOR = new zzaih();
    }

    zzaig(int i, DriveId driveId) {
        this.mVersionCode = i;
        this.zzaJj = driveId;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzaih.zza(this, parcel, i);
    }
}
