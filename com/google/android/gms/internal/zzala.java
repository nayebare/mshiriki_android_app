package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;

public class zzala extends zza {
    public static final Creator<zzala> CREATOR;
    final int mVersionCode;
    final DriveId zzaKS;
    final MetadataBundle zzaKT;

    static {
        CREATOR = new zzalb();
    }

    zzala(int i, DriveId driveId, MetadataBundle metadataBundle) {
        this.mVersionCode = i;
        this.zzaKS = driveId;
        this.zzaKT = metadataBundle;
    }

    public zzala(DriveId driveId, MetadataBundle metadataBundle) {
        this(1, driveId, metadataBundle);
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzalb.zza(this, parcel, i);
    }
}
