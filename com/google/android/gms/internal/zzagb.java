package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.zzac;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.events.zze;
import com.google.android.gms.drive.events.zzp;
import com.google.android.gms.drive.events.zzu;

public class zzagb extends zza {
    public static final Creator<zzagb> CREATOR;
    final int mVersionCode;
    final int zzaGv;
    final DriveId zzaJj;
    final zzu zzaKH;
    final zzp zzaKI;
    final zze zzaKh;

    static {
        CREATOR = new zzagc();
    }

    public zzagb(int i, DriveId driveId) {
        this(1, (DriveId) zzac.zzw(driveId), i, null, null, null);
    }

    zzagb(int i, DriveId driveId, int i2, zze com_google_android_gms_drive_events_zze, zzu com_google_android_gms_drive_events_zzu, zzp com_google_android_gms_drive_events_zzp) {
        this.mVersionCode = i;
        this.zzaJj = driveId;
        this.zzaGv = i2;
        this.zzaKh = com_google_android_gms_drive_events_zze;
        this.zzaKH = com_google_android_gms_drive_events_zzu;
        this.zzaKI = com_google_android_gms_drive_events_zzp;
    }

    public DriveId getDriveId() {
        return this.zzaJj;
    }

    public int getEventType() {
        return this.zzaGv;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzagc.zza(this, parcel, i);
    }
}
