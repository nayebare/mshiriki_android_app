package com.google.android.gms.drive.metadata.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.drive.DriveId;

public class zzo extends zza {
    public static final Creator<zzo> CREATOR;
    final int mVersionCode;
    final String zzaJv;
    final long zzaJw;
    final int zzaJx;

    static {
        CREATOR = new zzp();
    }

    zzo(int i, String str, long j, int i2) {
        this.mVersionCode = i;
        this.zzaJv = str;
        this.zzaJw = j;
        this.zzaJx = i2;
    }

    public zzo(String str, long j, int i) {
        this(1, str, j, i);
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzp.zza(this, parcel, i);
    }

    public DriveId zzL(long j) {
        return new DriveId(this.zzaJv, this.zzaJw, j, this.zzaJx);
    }
}
