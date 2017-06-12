package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;

public class zzt extends zza {
    public static final Creator<zzt> CREATOR;
    final int mVersionCode;

    static {
        CREATOR = new zzu();
    }

    public zzt() {
        this(1);
    }

    zzt(int i) {
        this.mVersionCode = i;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzu.zza(this, parcel, i);
    }

    public <F> F zza(zzj<F> com_google_android_gms_drive_query_internal_zzj_F) {
        return com_google_android_gms_drive_query_internal_zzj_F.zzAU();
    }
}
