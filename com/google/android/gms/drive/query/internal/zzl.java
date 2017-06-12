package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;

public class zzl extends zza {
    public static final Creator<zzl> CREATOR;
    final String mValue;
    final int mVersionCode;

    static {
        CREATOR = new zzm();
    }

    zzl(int i, String str) {
        this.mVersionCode = i;
        this.mValue = str;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzm.zza(this, parcel, i);
    }

    public <F> F zza(zzj<F> com_google_android_gms_drive_query_internal_zzj_F) {
        return com_google_android_gms_drive_query_internal_zzj_F.zzdU(this.mValue);
    }
}
