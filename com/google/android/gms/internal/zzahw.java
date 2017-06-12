package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.drive.DriveId;

public class zzahw extends zza {
    public static final Creator<zzahw> CREATOR;
    final int mVersionCode;
    final DriveId zzaKS;

    static {
        CREATOR = new zzahx();
    }

    zzahw(int i, DriveId driveId) {
        this.mVersionCode = i;
        this.zzaKS = driveId;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzahx.zza(this, parcel, i);
    }
}
