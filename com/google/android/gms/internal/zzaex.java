package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.zzaa;
import java.util.ArrayList;
import java.util.Iterator;

public class zzaex extends com.google.android.gms.common.internal.safeparcel.zza {
    public static final Creator<zzaex> CREATOR;
    public final int versionCode;
    public final ArrayList<zza> zzaIm;
    public final ArrayList<String> zzaIn;
    public final zzafn zzaIo;

    public static class zza extends com.google.android.gms.common.internal.safeparcel.zza {
        public static final Creator<zza> CREATOR;
        public final int name;
        public final int versionCode;
        public final int zzaIp;
        public final zzafs zzaIq;
        public final zzafk zzaIr;

        static {
            CREATOR = new zzaey();
        }

        zza(int i, int i2, int i3, zzafs com_google_android_gms_internal_zzafs, zzafk com_google_android_gms_internal_zzafk) {
            this.versionCode = i;
            this.zzaIp = i2;
            this.name = i3;
            this.zzaIq = com_google_android_gms_internal_zzafs;
            this.zzaIr = com_google_android_gms_internal_zzafk;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof zza)) {
                return false;
            }
            zza com_google_android_gms_internal_zzaex_zza = (zza) obj;
            return this.zzaIp == com_google_android_gms_internal_zzaex_zza.zzaIp && this.name == com_google_android_gms_internal_zzaex_zza.name && this.zzaIq.equals(com_google_android_gms_internal_zzaex_zza.zzaIq) && zzaa.equal(this.zzaIr, com_google_android_gms_internal_zzaex_zza.zzaIr);
        }

        public int hashCode() {
            return zzaa.hashCode(Integer.valueOf(this.zzaIp), Integer.valueOf(this.name), this.zzaIq, this.zzaIr);
        }

        public void writeToParcel(Parcel parcel, int i) {
            zzaey.zza(this, parcel, i);
        }
    }

    static {
        CREATOR = new zzaew();
    }

    public zzaex(int i, ArrayList<zza> arrayList, ArrayList<String> arrayList2, zzafn com_google_android_gms_internal_zzafn) {
        this.versionCode = i;
        this.zzaIm = arrayList;
        this.zzaIn = arrayList2;
        this.zzaIo = com_google_android_gms_internal_zzafn;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzaex)) {
            return false;
        }
        zzaex com_google_android_gms_internal_zzaex = (zzaex) obj;
        return zzaa.equal(this.zzaIm, com_google_android_gms_internal_zzaex.zzaIm) && zzaa.equal(this.zzaIn, com_google_android_gms_internal_zzaex.zzaIn);
    }

    public int hashCode() {
        return zzaa.hashCode(this.zzaIm, this.zzaIn);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("contexts=[");
        if (this.zzaIm != null && this.zzaIm.size() > 0) {
            Iterator it = this.zzaIm.iterator();
            while (it.hasNext()) {
                stringBuilder.append(((zza) it.next()).name).append(",");
            }
        }
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzaew.zza(this, parcel, i);
    }
}
