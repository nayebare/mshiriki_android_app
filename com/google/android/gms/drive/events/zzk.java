package com.google.android.gms.drive.events;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.drive.zzr;

public class zzk extends zzr implements DriveEvent {
    public static final Creator<zzk> CREATOR;
    final int mVersionCode;
    final int zzaKA;
    final boolean zzaKz;
    final DataHolder zzazI;

    static {
        CREATOR = new zzl();
    }

    zzk(int i, DataHolder dataHolder, boolean z, int i2) {
        this.mVersionCode = i;
        this.zzazI = dataHolder;
        this.zzaKz = z;
        this.zzaKA = i2;
    }

    public int getType() {
        return 3;
    }

    public DataHolder zzAb() {
        return this.zzazI;
    }

    public boolean zzAc() {
        return this.zzaKz;
    }

    public int zzAd() {
        return this.zzaKA;
    }

    public void zzK(Parcel parcel, int i) {
        zzl.zza(this, parcel, i);
    }
}
