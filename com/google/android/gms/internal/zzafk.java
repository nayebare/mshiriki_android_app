package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.zzaa;
import java.util.ArrayList;
import java.util.Arrays;

public class zzafk extends com.google.android.gms.common.internal.safeparcel.zza {
    public static final Creator<zzafk> CREATOR;
    public final int versionCode;
    public final ArrayList<zza> zzaIm;

    public static class zza extends com.google.android.gms.common.internal.safeparcel.zza {
        public static final Creator<zza> CREATOR;
        public final int versionCode;
        public final String[] zzaIS;
        public final String[] zzaIT;
        public final String[] zzaIU;

        static {
            CREATOR = new zzafm();
        }

        zza(int i, String[] strArr, String[] strArr2, String[] strArr3) {
            this.versionCode = i;
            this.zzaIS = strArr;
            this.zzaIT = strArr2;
            this.zzaIU = strArr3;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof zza)) {
                return false;
            }
            zza com_google_android_gms_internal_zzafk_zza = (zza) obj;
            return Arrays.equals(this.zzaIS, com_google_android_gms_internal_zzafk_zza.zzaIS) && Arrays.equals(this.zzaIT, com_google_android_gms_internal_zzafk_zza.zzaIT) && Arrays.equals(this.zzaIU, com_google_android_gms_internal_zzafk_zza.zzaIU);
        }

        public int hashCode() {
            return (Arrays.hashCode(this.zzaIS) + Arrays.hashCode(this.zzaIT)) + Arrays.hashCode(this.zzaIU);
        }

        public void writeToParcel(Parcel parcel, int i) {
            zzafm.zza(this, parcel, i);
        }
    }

    static {
        CREATOR = new zzafl();
    }

    zzafk(int i, ArrayList<zza> arrayList) {
        this.versionCode = i;
        this.zzaIm = arrayList;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzafk)) {
            return false;
        }
        return this.zzaIm.equals(((zzafk) obj).zzaIm);
    }

    public int hashCode() {
        return zzaa.hashCode(this.zzaIm);
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzafl.zza(this, parcel, i);
    }
}
