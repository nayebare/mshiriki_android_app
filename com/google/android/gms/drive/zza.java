package com.google.android.gms.drive;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.util.Base64;
import com.google.android.gms.common.internal.zzac;
import com.google.android.gms.internal.zzale;
import com.google.android.gms.internal.zzbut;

public class zza extends com.google.android.gms.common.internal.safeparcel.zza {
    public static final Creator<zza> CREATOR;
    final int mVersionCode;
    final long zzaJd;
    final long zzaJe;
    final long zzaJf;
    private volatile String zzaJg;

    static {
        CREATOR = new zzb();
    }

    zza(int i, long j, long j2, long j3) {
        boolean z = true;
        this.zzaJg = null;
        zzac.zzas(j != -1);
        zzac.zzas(j2 != -1);
        if (j3 == -1) {
            z = false;
        }
        zzac.zzas(z);
        this.mVersionCode = i;
        this.zzaJd = j;
        this.zzaJe = j2;
        this.zzaJf = j3;
    }

    public final String encodeToString() {
        if (this.zzaJg == null) {
            String encodeToString = Base64.encodeToString(zzzy(), 10);
            String valueOf = String.valueOf("ChangeSequenceNumber:");
            encodeToString = String.valueOf(encodeToString);
            this.zzaJg = encodeToString.length() != 0 ? valueOf.concat(encodeToString) : new String(valueOf);
        }
        return this.zzaJg;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof zza)) {
            return false;
        }
        zza com_google_android_gms_drive_zza = (zza) obj;
        return com_google_android_gms_drive_zza.zzaJe == this.zzaJe && com_google_android_gms_drive_zza.zzaJf == this.zzaJf && com_google_android_gms_drive_zza.zzaJd == this.zzaJd;
    }

    public int hashCode() {
        String valueOf = String.valueOf(String.valueOf(this.zzaJd));
        String valueOf2 = String.valueOf(String.valueOf(this.zzaJe));
        String valueOf3 = String.valueOf(String.valueOf(this.zzaJf));
        return new StringBuilder(((String.valueOf(valueOf).length() + 0) + String.valueOf(valueOf2).length()) + String.valueOf(valueOf3).length()).append(valueOf).append(valueOf2).append(valueOf3).toString().hashCode();
    }

    public String toString() {
        return encodeToString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzb.zza(this, parcel, i);
    }

    final byte[] zzzy() {
        zzale com_google_android_gms_internal_zzale = new zzale();
        com_google_android_gms_internal_zzale.versionCode = this.mVersionCode;
        com_google_android_gms_internal_zzale.zzaNf = this.zzaJd;
        com_google_android_gms_internal_zzale.zzaNg = this.zzaJe;
        com_google_android_gms_internal_zzale.zzaNh = this.zzaJf;
        return zzbut.zzf(com_google_android_gms_internal_zzale);
    }
}
