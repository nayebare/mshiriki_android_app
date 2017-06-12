package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;
import com.google.android.gms.drive.zzc;
import com.google.android.gms.drive.zzl;

public class zzago extends zza {
    public static final Creator<zzago> CREATOR;
    final int mVersionCode;
    final String zzaJF;
    final boolean zzaJG;
    final boolean zzaJK;
    final DriveId zzaKS;
    final MetadataBundle zzaKT;
    final zzc zzaKU;
    final int zzaKV;
    final int zzaKW;
    final boolean zzaKX;

    static {
        CREATOR = new zzagp();
    }

    zzago(int i, DriveId driveId, MetadataBundle metadataBundle, zzc com_google_android_gms_drive_zzc, boolean z, String str, int i2, int i3, boolean z2, boolean z3) {
        this.mVersionCode = i;
        this.zzaKS = driveId;
        this.zzaKT = metadataBundle;
        this.zzaKU = com_google_android_gms_drive_zzc;
        this.zzaJG = z;
        this.zzaJF = str;
        this.zzaKV = i2;
        this.zzaKW = i3;
        this.zzaKX = z2;
        this.zzaJK = z3;
    }

    public zzago(DriveId driveId, MetadataBundle metadataBundle, int i, boolean z, zzl com_google_android_gms_drive_zzl) {
        this(1, driveId, metadataBundle, null, com_google_android_gms_drive_zzl.zzzG(), com_google_android_gms_drive_zzl.zzzF(), com_google_android_gms_drive_zzl.zzzH(), i, z, com_google_android_gms_drive_zzl.zzzM());
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzagp.zza(this, parcel, i);
    }
}
