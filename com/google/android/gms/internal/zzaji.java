package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.drive.zzr;

public class zzaji extends zzr {
    public static final Creator<zzaji> CREATOR;
    final int mVersionCode;
    final DataHolder zzaMT;

    static {
        CREATOR = new zzajj();
    }

    zzaji(int i, DataHolder dataHolder) {
        this.mVersionCode = i;
        this.zzaMT = dataHolder;
    }

    public DataHolder zzAw() {
        return this.zzaMT;
    }

    protected void zzK(Parcel parcel, int i) {
        zzajj.zza(this, parcel, i);
    }
}
