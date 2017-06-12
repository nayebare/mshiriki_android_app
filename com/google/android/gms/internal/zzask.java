package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.zzaa;
import java.util.List;

@Deprecated
public class zzask extends zza {
    public static final Creator<zzask> CREATOR;
    final int mVersionCode;
    private final String zzaht;
    private final String zzblg;
    private final List<zzasi> zzbmI;

    static {
        CREATOR = new zzasm();
    }

    zzask(int i, String str, String str2, List<zzasi> list) {
        this.mVersionCode = i;
        this.zzaht = str;
        this.zzblg = str2;
        this.zzbmI = list;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzask)) {
            return false;
        }
        zzask com_google_android_gms_internal_zzask = (zzask) obj;
        return this.zzaht.equals(com_google_android_gms_internal_zzask.zzaht) && this.zzblg.equals(com_google_android_gms_internal_zzask.zzblg) && this.zzbmI.equals(com_google_android_gms_internal_zzask.zzbmI);
    }

    public String getPlaceId() {
        return this.zzblg;
    }

    public int hashCode() {
        return zzaa.hashCode(this.zzaht, this.zzblg, this.zzbmI);
    }

    public String toString() {
        return zzaa.zzv(this).zzg("accountName", this.zzaht).zzg("placeId", this.zzblg).zzg("placeAliases", this.zzbmI).toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzasm.zza(this, parcel, i);
    }

    public List<zzasi> zzIr() {
        return this.zzbmI;
    }

    public String zzIu() {
        return this.zzaht;
    }
}
