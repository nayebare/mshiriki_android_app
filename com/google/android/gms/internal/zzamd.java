package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import java.util.List;

public class zzamd extends zza {
    public static final Creator<zzamd> CREATOR;
    final int mVersionCode;
    final long zzavX;
    final List<zzamn> zztf;

    static {
        CREATOR = new zzame();
    }

    zzamd(int i, long j, List<zzamn> list) {
        this.mVersionCode = i;
        this.zzavX = j;
        this.zztf = list;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzame.zza(this, parcel, i);
    }
}
