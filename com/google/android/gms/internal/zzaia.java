package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.drive.DriveSpace;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class zzaia extends zza {
    public static final Creator<zzaia> CREATOR;
    final int mVersionCode;
    final List<DriveSpace> zzaKk;
    private final Set<DriveSpace> zzaKl;
    final com.google.android.gms.drive.zza zzaMp;
    final int zzaMq;
    final boolean zzaMr;

    static {
        CREATOR = new zzaib();
    }

    private zzaia(int i, com.google.android.gms.drive.zza com_google_android_gms_drive_zza, int i2, List<DriveSpace> list, Set<DriveSpace> set, boolean z) {
        this.mVersionCode = i;
        this.zzaMp = com_google_android_gms_drive_zza;
        this.zzaMq = i2;
        this.zzaKk = list;
        this.zzaKl = set;
        this.zzaMr = z;
    }

    zzaia(int i, com.google.android.gms.drive.zza com_google_android_gms_drive_zza, int i2, List<DriveSpace> list, boolean z) {
        this(i, com_google_android_gms_drive_zza, i2, list, list == null ? null : new HashSet(list), z);
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzaib.zza(this, parcel, i);
    }
}
