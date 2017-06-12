package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.zzac;

public class zzauj extends zza {
    public static final Creator<zzauj> CREATOR;
    private final String description;
    private final String name;
    final int versionCode;
    private final String zzbwJ;
    private final byte zzbwK;

    static {
        CREATOR = new zzauk();
    }

    zzauj(int i, String str, String str2, String str3, byte b) {
        this.versionCode = i;
        this.name = zzac.zzdv(str);
        this.description = (String) zzac.zzw(str2);
        this.zzbwJ = (String) zzac.zzw(str3);
        zzac.zzb(b <= 4, (Object) "Unknown device type");
        this.zzbwK = b;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof zzauj)) {
            return false;
        }
        zzauj com_google_android_gms_internal_zzauj = (zzauj) obj;
        return this.name.equals(com_google_android_gms_internal_zzauj.name) && this.description.equals(com_google_android_gms_internal_zzauj.description) && this.zzbwK == com_google_android_gms_internal_zzauj.zzbwK && this.zzbwJ.equals(com_google_android_gms_internal_zzauj.zzbwJ);
    }

    public String getDescription() {
        return this.description;
    }

    public String getDeviceId() {
        return this.zzbwJ;
    }

    public String getName() {
        return this.name;
    }

    public int hashCode() {
        return (((((this.zzbwK * 31) * 31) * 31) + ((this.zzbwJ.hashCode() * 31) * 31)) + (this.name.hashCode() * 31)) + this.description.hashCode();
    }

    public String toString() {
        String str = this.name;
        String str2 = this.description;
        return new StringBuilder((String.valueOf(str).length() + 8) + String.valueOf(str2).length()).append(str).append(": ").append(str2).append("[").append(this.zzbwK).append("]").toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzauk.zza(this, parcel, i);
    }

    public byte zzMK() {
        return this.zzbwK;
    }
}
