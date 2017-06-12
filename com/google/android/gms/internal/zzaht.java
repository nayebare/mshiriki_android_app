package com.google.android.gms.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.zzs;

public class zzaht extends zza {
    public static final Creator<zzaht> CREATOR;
    final int mVersionCode;
    final IBinder zzaMh;

    static {
        CREATOR = new zzahu();
    }

    zzaht(int i, IBinder iBinder) {
        this.mVersionCode = i;
        this.zzaMh = iBinder;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzahu.zza(this, parcel, i);
    }

    public zzs zzAn() {
        return zzs.zza.zzbs(this.zzaMh);
    }
}
