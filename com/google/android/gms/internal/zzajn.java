package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;

public class zzajn extends zza {
    public static final Creator<zzajn> CREATOR;
    final int mVersionCode;
    final zzakb zzaMU;

    static {
        CREATOR = new zzajo();
    }

    zzajn(int i, zzakb com_google_android_gms_internal_zzakb) {
        this.mVersionCode = i;
        this.zzaMU = com_google_android_gms_internal_zzakb;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzajo.zza(this, parcel, i);
    }
}
