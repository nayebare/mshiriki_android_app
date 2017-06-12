package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.zzac;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;
import com.google.android.gms.drive.zzc;
import com.google.android.gms.drive.zzk;

public class zzagz extends zza {
    public static final Creator<zzagz> CREATOR;
    final int mVersionCode;
    final String zzaJF;
    final String zzaJI;
    final boolean zzaKM;
    final zzc zzaKU;
    final MetadataBundle zzaLf;
    final Integer zzaLg;
    final DriveId zzaLh;
    final int zzaLi;
    final int zzaLj;

    static {
        CREATOR = new zzaha();
    }

    zzagz(int i, DriveId driveId, MetadataBundle metadataBundle, zzc com_google_android_gms_drive_zzc, Integer num, boolean z, String str, int i2, int i3, String str2) {
        if (!(com_google_android_gms_drive_zzc == null || i3 == 0)) {
            zzac.zzb(com_google_android_gms_drive_zzc.getRequestId() == i3, (Object) "inconsistent contents reference");
        }
        if ((num == null || num.intValue() == 0) && com_google_android_gms_drive_zzc == null && i3 == 0) {
            throw new IllegalArgumentException("Need a valid contents");
        }
        this.mVersionCode = i;
        this.zzaLh = (DriveId) zzac.zzw(driveId);
        this.zzaLf = (MetadataBundle) zzac.zzw(metadataBundle);
        this.zzaKU = com_google_android_gms_drive_zzc;
        this.zzaLg = num;
        this.zzaJF = str;
        this.zzaLi = i2;
        this.zzaKM = z;
        this.zzaLj = i3;
        this.zzaJI = str2;
    }

    public zzagz(DriveId driveId, MetadataBundle metadataBundle, int i, int i2, zzk com_google_android_gms_drive_zzk) {
        this(2, driveId, metadataBundle, null, Integer.valueOf(i2), com_google_android_gms_drive_zzk.zzzG(), com_google_android_gms_drive_zzk.zzzF(), com_google_android_gms_drive_zzk.zzzH(), i, com_google_android_gms_drive_zzk.zzzJ());
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzaha.zza(this, parcel, i);
    }
}
