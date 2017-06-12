package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import java.util.List;

public class zzagi extends zza {
    public static final Creator<zzagi> CREATOR;
    final int mVersionCode;
    final List<String> zzaKp;

    static {
        CREATOR = new zzagj();
    }

    zzagi(int i, List<String> list) {
        this.mVersionCode = i;
        this.zzaKp = list;
    }

    public zzagi(List<String> list) {
        this(1, list);
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzagj.zza(this, parcel, i);
    }
}
