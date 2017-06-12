package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.drive.DriveId;
import java.util.List;

public class zzaiq extends zza {
    public static final Creator<zzaiq> CREATOR;
    final int mVersionCode;
    final DriveId zzaJj;
    final String zzaMA;
    final boolean zzaMw;
    final List<String> zzaMx;
    final boolean zzaMy;
    final DataHolder zzaMz;

    static {
        CREATOR = new zzair();
    }

    zzaiq(int i, DriveId driveId, boolean z, List<String> list, boolean z2, DataHolder dataHolder, String str) {
        this.mVersionCode = i;
        this.zzaJj = driveId;
        this.zzaMw = z;
        this.zzaMx = list;
        this.zzaMy = z2;
        this.zzaMz = dataHolder;
        this.zzaMA = str;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzair.zza(this, parcel, i);
    }
}
