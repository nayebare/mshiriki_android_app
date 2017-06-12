package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.events.zzp;

public class zzakf extends zza {
    public static final Creator<zzakf> CREATOR;
    final int mVersionCode;
    final int zzaGv;
    final DriveId zzaJj;
    final zzp zzaKI;

    static {
        CREATOR = new zzakg();
    }

    zzakf(int i, DriveId driveId, int i2, zzp com_google_android_gms_drive_events_zzp) {
        this.mVersionCode = i;
        this.zzaJj = driveId;
        this.zzaGv = i2;
        this.zzaKI = com_google_android_gms_drive_events_zzp;
    }

    public zzakf(DriveId driveId, int i) {
        this(driveId, i, null);
    }

    zzakf(DriveId driveId, int i, zzp com_google_android_gms_drive_events_zzp) {
        this(1, driveId, i, com_google_android_gms_drive_events_zzp);
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzakg.zza(this, parcel, i);
    }
}
