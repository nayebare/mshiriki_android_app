package com.google.android.gms.drive;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;

public class zze extends zza {
    public static final Creator<zze> CREATOR;
    final int mVersionCode;
    final long zzaJt;
    final long zzaJu;

    static {
        CREATOR = new zzf();
    }

    zze(int i, long j, long j2) {
        this.mVersionCode = i;
        this.zzaJt = j;
        this.zzaJu = j2;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzf.zza(this, parcel, i);
    }
}
