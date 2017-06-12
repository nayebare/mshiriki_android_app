package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.zzac;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;

public class zzahb extends zza {
    public static final Creator<zzahb> CREATOR;
    final int mVersionCode;
    final MetadataBundle zzaLf;
    final DriveId zzaLh;

    static {
        CREATOR = new zzahc();
    }

    zzahb(int i, DriveId driveId, MetadataBundle metadataBundle) {
        this.mVersionCode = i;
        this.zzaLh = (DriveId) zzac.zzw(driveId);
        this.zzaLf = (MetadataBundle) zzac.zzw(metadataBundle);
    }

    public zzahb(DriveId driveId, MetadataBundle metadataBundle) {
        this(1, driveId, metadataBundle);
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzahc.zza(this, parcel, i);
    }
}
