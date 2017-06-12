package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.zzaa;

public class zzarj extends zza {
    public static final Creator<zzarj> CREATOR;
    private final int mVersionCode;
    public final String packageName;
    public final int uid;

    static {
        CREATOR = new zzark();
    }

    zzarj(int i, int i2, String str) {
        this.mVersionCode = i;
        this.uid = i2;
        this.packageName = str;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || !(obj instanceof zzarj)) {
            return false;
        }
        zzarj com_google_android_gms_internal_zzarj = (zzarj) obj;
        return com_google_android_gms_internal_zzarj.uid == this.uid && zzaa.equal(com_google_android_gms_internal_zzarj.packageName, this.packageName);
    }

    int getVersionCode() {
        return this.mVersionCode;
    }

    public int hashCode() {
        return this.uid;
    }

    public String toString() {
        return String.format("%d:%s", new Object[]{Integer.valueOf(this.uid), this.packageName});
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzark.zza(this, parcel, i);
    }
}
