package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;

public class zzz extends zza {
    public static final Creator<zzz> CREATOR;
    final int mVersionCode;

    static {
        CREATOR = new zzaa();
    }

    public zzz() {
        this(1);
    }

    zzz(int i) {
        this.mVersionCode = i;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzaa.zza(this, parcel, i);
    }

    public <F> F zza(zzj<F> com_google_android_gms_drive_query_internal_zzj_F) {
        return com_google_android_gms_drive_query_internal_zzj_F.zzAT();
    }
}
