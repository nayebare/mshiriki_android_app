package com.google.android.gms.drive;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.zzac;
import java.util.List;

public class zzo extends zza {
    public static final Creator<zzo> CREATOR;
    final int mVersionCode;
    final List<String> zzaJZ;
    final List<String> zzaKa;

    static {
        CREATOR = new zzp();
    }

    zzo(int i, List<String> list, List<String> list2) {
        this.mVersionCode = i;
        this.zzaJZ = (List) zzac.zzw(list);
        this.zzaKa = (List) zzac.zzw(list2);
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzp.zza(this, parcel, i);
    }
}
