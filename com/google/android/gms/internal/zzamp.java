package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.safeparcel.zza;
import java.util.List;

public class zzamp extends zza {
    public static final Creator<zzamp> CREATOR;
    final int mVersionCode;
    final DataHolder zzaPL;
    final boolean zzaPM;
    final List<String> zzaPN;
    final zzamd zzaPO;
    final List<zzamn> zztf;

    static {
        CREATOR = new zzamq();
    }

    zzamp(int i, List<zzamn> list, DataHolder dataHolder, boolean z, List<String> list2, zzamd com_google_android_gms_internal_zzamd) {
        this.mVersionCode = i;
        this.zztf = list;
        this.zzaPL = dataHolder;
        this.zzaPM = z;
        this.zzaPN = list2;
        this.zzaPO = com_google_android_gms_internal_zzamd;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzamq.zza(this, parcel, i);
    }
}
