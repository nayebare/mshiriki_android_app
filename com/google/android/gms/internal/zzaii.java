package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.drive.zzm;
import java.util.List;

public class zzaii extends zza {
    public static final Creator<zzaii> CREATOR;
    final int mVersionCode;
    final int zzHJ;
    final List<zzm> zzaMu;

    static {
        CREATOR = new zzaij();
    }

    zzaii(int i, List<zzm> list, int i2) {
        this.mVersionCode = i;
        this.zzaMu = list;
        this.zzHJ = i2;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzaij.zza(this, parcel, i);
    }
}
