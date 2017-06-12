package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;

public class zzagx extends zza {
    public static final Creator<zzagx> CREATOR;
    final int mVersionCode;
    final DriveId zzaJS;
    final int zzaJh;
    final MetadataBundle zzaLf;
    final Integer zzaLg;
    final String zzalD;

    static {
        CREATOR = new zzagy();
    }

    zzagx(int i, MetadataBundle metadataBundle, int i2, String str, DriveId driveId, Integer num) {
        this.mVersionCode = i;
        this.zzaLf = metadataBundle;
        this.zzaJh = i2;
        this.zzalD = str;
        this.zzaJS = driveId;
        this.zzaLg = num;
    }

    public zzagx(MetadataBundle metadataBundle, int i, String str, DriveId driveId, int i2) {
        this(1, metadataBundle, i, str, driveId, Integer.valueOf(i2));
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzagy.zza(this, parcel, i);
    }
}
