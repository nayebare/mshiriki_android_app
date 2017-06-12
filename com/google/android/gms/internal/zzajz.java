package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.query.internal.FilterHolder;

public class zzajz extends zza {
    public static final Creator<zzajz> CREATOR;
    final int mVersionCode;
    final String[] zzaJQ;
    final DriveId zzaJS;
    final FilterHolder zzaMZ;
    final String zzalD;

    static {
        CREATOR = new zzaka();
    }

    zzajz(int i, String str, String[] strArr, DriveId driveId, FilterHolder filterHolder) {
        this.mVersionCode = i;
        this.zzalD = str;
        this.zzaJQ = strArr;
        this.zzaJS = driveId;
        this.zzaMZ = filterHolder;
    }

    public zzajz(String str, String[] strArr, DriveId driveId, FilterHolder filterHolder) {
        this(1, str, strArr, driveId, filterHolder);
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzaka.zza(this, parcel, i);
    }
}
