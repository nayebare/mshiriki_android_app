package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.drive.query.Filter;

public class zzv extends zza {
    public static final Creator<zzv> CREATOR;
    final int mVersionCode;
    final FilterHolder zzaPc;

    static {
        CREATOR = new zzw();
    }

    zzv(int i, FilterHolder filterHolder) {
        this.mVersionCode = i;
        this.zzaPc = filterHolder;
    }

    public zzv(Filter filter) {
        this(1, new FilterHolder(filter));
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzw.zza(this, parcel, i);
    }

    public <T> T zza(zzj<T> com_google_android_gms_drive_query_internal_zzj_T) {
        return com_google_android_gms_drive_query_internal_zzj_T.zzz(this.zzaPc.getFilter().zza(com_google_android_gms_drive_query_internal_zzj_T));
    }
}
