package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.drive.DriveId;
import java.util.List;

public class zzagk extends zza {
    public static final Creator<zzagk> CREATOR;
    final int mVersionCode;
    final DriveId zzaKO;
    final List<DriveId> zzaKP;
    final List<DriveId> zzaKQ;

    static {
        CREATOR = new zzagl();
    }

    zzagk(int i, DriveId driveId, List<DriveId> list, List<DriveId> list2) {
        this.mVersionCode = i;
        this.zzaKO = driveId;
        this.zzaKP = list;
        this.zzaKQ = list2;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzagl.zza(this, parcel, i);
    }
}
