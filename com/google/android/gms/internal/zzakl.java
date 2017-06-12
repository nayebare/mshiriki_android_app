package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;

public class zzakl extends zza {
    public static final Creator<zzakl> CREATOR;
    final int mVersionCode;
    final zzakb zzaMU;

    static {
        CREATOR = new zzakm();
    }

    zzakl(int i, zzakb com_google_android_gms_internal_zzakb) {
        this.mVersionCode = i;
        this.zzaMU = com_google_android_gms_internal_zzakb;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzakm.zza(this, parcel, i);
    }
}
