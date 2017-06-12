package com.google.android.gms.internal;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;

public class zzadp extends zza {
    public static final Creator<zzadp> CREATOR;
    private final int mVersionCode;
    private final Bundle zzaHF;

    static {
        CREATOR = new zzadq();
    }

    zzadp(int i, Bundle bundle) {
        this.mVersionCode = i;
        this.zzaHF = bundle;
    }

    public int getVersionCode() {
        return this.mVersionCode;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzadq.zza(this, parcel, i);
    }

    public Bundle zzzd() {
        return this.zzaHF;
    }
}
