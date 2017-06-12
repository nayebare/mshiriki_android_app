package com.google.android.gms.location.places.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.zzaa;
import java.util.List;

@Deprecated
public final class zzs extends zza {
    public static final Creator<zzs> CREATOR;
    public final String address;
    public final String name;
    public final int versionCode;
    public final String zzbmk;
    public final String zzbml;
    public final List<String> zzbmm;

    static {
        CREATOR = new zzt();
    }

    public zzs(int i, String str, String str2, String str3, String str4, List<String> list) {
        this.versionCode = i;
        this.name = str;
        this.address = str2;
        this.zzbmk = str3;
        this.zzbml = str4;
        this.zzbmm = list;
    }

    public static zzs zza(String str, String str2, String str3, String str4, List<String> list) {
        return new zzs(0, str, str2, str3, str4, list);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzs)) {
            return false;
        }
        zzs com_google_android_gms_location_places_internal_zzs = (zzs) obj;
        return zzaa.equal(this.name, com_google_android_gms_location_places_internal_zzs.name) && zzaa.equal(this.address, com_google_android_gms_location_places_internal_zzs.address) && zzaa.equal(this.zzbmk, com_google_android_gms_location_places_internal_zzs.zzbmk) && zzaa.equal(this.zzbml, com_google_android_gms_location_places_internal_zzs.zzbml) && zzaa.equal(this.zzbmm, com_google_android_gms_location_places_internal_zzs.zzbmm);
    }

    public int hashCode() {
        return zzaa.hashCode(this.name, this.address, this.zzbmk, this.zzbml);
    }

    public String toString() {
        return zzaa.zzv(this).zzg("name", this.name).zzg("address", this.address).zzg("internationalPhoneNumber", this.zzbmk).zzg("regularOpenHours", this.zzbml).zzg("attributions", this.zzbmm).toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzt.zza(this, parcel, i);
    }
}
