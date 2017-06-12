package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.zza;
import com.google.android.gms.drive.zzr;
import java.util.List;

public class zzais extends zzr {
    public static final Creator<zzais> CREATOR;
    final int mVersionCode;
    final DataHolder zzaMB;
    final List<DriveId> zzaMC;
    final zza zzaMD;
    final boolean zzaME;

    static {
        CREATOR = new zzait();
    }

    zzais(int i, DataHolder dataHolder, List<DriveId> list, zza com_google_android_gms_drive_zza, boolean z) {
        this.mVersionCode = i;
        this.zzaMB = dataHolder;
        this.zzaMC = list;
        this.zzaMD = com_google_android_gms_drive_zza;
        this.zzaME = z;
    }

    protected void zzK(Parcel parcel, int i) {
        zzait.zza(this, parcel, i | 1);
    }
}
