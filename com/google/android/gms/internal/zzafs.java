package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.zzaa;
import java.util.ArrayList;

public class zzafs extends com.google.android.gms.common.internal.safeparcel.zza {
    public static final Creator<zzafs> CREATOR;
    public final int versionCode;
    public final ArrayList<zza> zzaIX;
    public final int[] zzaIY;

    public static class zza extends com.google.android.gms.common.internal.safeparcel.zza {
        public static final Creator<zza> CREATOR;
        public final int versionCode;
        public final long zzaIZ;
        public final long zzaJa;

        static {
            CREATOR = new zzaft();
        }

        zza(int i, long j, long j2) {
            this.versionCode = i;
            this.zzaIZ = j;
            this.zzaJa = j2;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof zza)) {
                return false;
            }
            zza com_google_android_gms_internal_zzafs_zza = (zza) obj;
            return this.zzaIZ == com_google_android_gms_internal_zzafs_zza.zzpN() && this.zzaJa == com_google_android_gms_internal_zzafs_zza.zzzx();
        }

        public int hashCode() {
            return zzaa.hashCode(Long.valueOf(this.zzaIZ), Long.valueOf(this.zzaJa));
        }

        public void writeToParcel(Parcel parcel, int i) {
            zzaft.zza(this, parcel, i);
        }

        public long zzpN() {
            return this.zzaIZ;
        }

        public long zzzx() {
            return this.zzaJa;
        }
    }

    static {
        CREATOR = new zzafr();
    }

    zzafs(int i, ArrayList<zza> arrayList, int[] iArr) {
        this.versionCode = i;
        this.zzaIX = arrayList;
        this.zzaIY = iArr;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzafs)) {
            return false;
        }
        zzafs com_google_android_gms_internal_zzafs = (zzafs) obj;
        return zzaa.equal(this.zzaIX, com_google_android_gms_internal_zzafs.zzaIX) && zzaa.equal(this.zzaIY, com_google_android_gms_internal_zzafs.zzaIY);
    }

    public int hashCode() {
        return zzaa.hashCode(this.zzaIX, this.zzaIY);
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzafr.zza(this, parcel, i);
    }
}
