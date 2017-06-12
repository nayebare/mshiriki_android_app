package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.drive.DriveId;
import java.util.List;

public class zzakn extends zza {
    public static final Creator<zzakn> CREATOR;
    final int mVersionCode;
    final DriveId zzaKO;
    final List<DriveId> zzaNc;

    static {
        CREATOR = new zzako();
    }

    zzakn(int i, DriveId driveId, List<DriveId> list) {
        this.mVersionCode = i;
        this.zzaKO = driveId;
        this.zzaNc = list;
    }

    public zzakn(DriveId driveId, List<DriveId> list) {
        this(1, driveId, list);
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzako.zza(this, parcel, i);
    }
}
