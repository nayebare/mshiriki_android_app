package com.google.android.gms.nearby.messages.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;

public final class zzj extends zza {
    public static final Creator<zzj> CREATOR;
    public final int versionCode;
    @Deprecated
    public final ClientAppContext zzbyA;
    public final int zzbyB;

    static {
        CREATOR = new zzk();
    }

    public zzj(int i) {
        this(1, null, i);
    }

    zzj(int i, ClientAppContext clientAppContext, int i2) {
        this.versionCode = i;
        this.zzbyA = clientAppContext;
        this.zzbyB = i2;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzk.zza(this, parcel, i);
    }
}
