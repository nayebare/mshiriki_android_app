package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.drive.DriveId;

public class zzags extends zza {
    public static final Creator<zzags> CREATOR;
    final int mVersionCode;
    final DriveId zzaJj;
    final int zzaKZ;
    final int zzaLa;
    final zzakb zzaLb;

    static {
        CREATOR = new zzagt();
    }

    zzags(int i, int i2, int i3, DriveId driveId, zzakb com_google_android_gms_internal_zzakb) {
        this.mVersionCode = i;
        this.zzaKZ = i2;
        this.zzaLa = i3;
        this.zzaJj = driveId;
        this.zzaLb = com_google_android_gms_internal_zzakb;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzagt.zza(this, parcel, i);
    }
}
