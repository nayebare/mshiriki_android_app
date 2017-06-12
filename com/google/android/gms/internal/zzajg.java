package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.drive.zzr;

public class zzajg extends zzr {
    public static final Creator<zzajg> CREATOR;
    final int mVersionCode;
    final boolean zzaLq;
    final DataHolder zzaMS;

    static {
        CREATOR = new zzajh();
    }

    zzajg(int i, DataHolder dataHolder, boolean z) {
        this.mVersionCode = i;
        this.zzaMS = dataHolder;
        this.zzaLq = z;
    }

    public DataHolder zzAu() {
        return this.zzaMS;
    }

    public boolean zzAv() {
        return this.zzaLq;
    }

    protected void zzK(Parcel parcel, int i) {
        zzajh.zza(this, parcel, i);
    }
}
