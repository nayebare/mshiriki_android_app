package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.zzaa;

public class zzafn extends zza {
    public static final Creator<zzafn> CREATOR;
    public final int limit;
    public final int versionCode;
    public final int zzaIV;
    public final int[] zzaIW;

    static {
        CREATOR = new zzafo();
    }

    zzafn(int i, int i2, int i3, int[] iArr) {
        this.versionCode = i;
        this.zzaIV = i2;
        this.limit = i3;
        this.zzaIW = iArr;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzafn)) {
            return false;
        }
        zzafn com_google_android_gms_internal_zzafn = (zzafn) obj;
        if (com_google_android_gms_internal_zzafn.limit != this.limit) {
            return false;
        }
        if (com_google_android_gms_internal_zzafn.zzaIV != this.zzaIV) {
            return false;
        }
        if (com_google_android_gms_internal_zzafn.versionCode != this.versionCode) {
            return false;
        }
        if (zzzw() != com_google_android_gms_internal_zzafn.zzzw()) {
            return false;
        }
        if (!zzzw()) {
            return true;
        }
        if (this.zzaIW.length != com_google_android_gms_internal_zzafn.zzaIW.length) {
            return false;
        }
        for (int i : com_google_android_gms_internal_zzafn.zzaIW) {
            boolean z;
            for (int i2 : this.zzaIW) {
                if (i2 == i) {
                    z = true;
                    break;
                }
            }
            z = false;
            if (!z) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        int i;
        if (this.zzaIW != null) {
            int[] iArr = this.zzaIW;
            int i2 = 0;
            i = 0;
            while (i2 < iArr.length) {
                int i3 = (iArr[i2] * 13) + i;
                i2++;
                i = i3;
            }
        } else {
            i = 0;
        }
        return zzaa.hashCode(Integer.valueOf(i), Integer.valueOf(this.zzaIV), Integer.valueOf(this.limit), Integer.valueOf(this.versionCode));
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzafo.zza(this, parcel, i);
    }

    public boolean zzzw() {
        return this.zzaIW != null;
    }
}
