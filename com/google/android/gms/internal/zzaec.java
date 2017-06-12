package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.zzaa;
import com.google.android.gms.common.internal.zzac;

public class zzaec extends zza {
    public static final Creator<zzaec> CREATOR;
    public final int versionCode;
    public final String zzaHR;
    public zzaee zzaHS;

    static {
        CREATOR = new zzaed();
    }

    zzaec(int i, String str, zzaee com_google_android_gms_internal_zzaee) {
        this.versionCode = i;
        this.zzaHR = str;
        this.zzaHS = com_google_android_gms_internal_zzaee;
    }

    public zzaec(String str, zzaee com_google_android_gms_internal_zzaee) {
        this(1, zzac.zzdv(str), (zzaee) zzac.zzw(com_google_android_gms_internal_zzaee));
    }

    public static zzaec zza(String str, zzaee com_google_android_gms_internal_zzaee) {
        return new zzaec(str, com_google_android_gms_internal_zzaee);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzaec)) {
            return false;
        }
        return TextUtils.equals(this.zzaHR, ((zzaec) obj).zzaHR);
    }

    public int hashCode() {
        return zzaa.hashCode(this.zzaHR);
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzaed.zza(this, parcel, i);
    }
}
