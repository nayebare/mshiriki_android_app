package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.annotation.NonNull;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.zzaa;
import java.util.List;

public class zzasd extends zza {
    public static final Creator<zzasd> CREATOR;
    final int mVersionCode;
    private final String zzblg;
    private final List<String> zzbmI;

    static {
        CREATOR = new zzase();
    }

    zzasd(int i, @NonNull String str, @NonNull List<String> list) {
        this.mVersionCode = i;
        this.zzblg = str;
        this.zzbmI = list;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzasd)) {
            return false;
        }
        zzasd com_google_android_gms_internal_zzasd = (zzasd) obj;
        return this.zzblg.equals(com_google_android_gms_internal_zzasd.zzblg) && this.zzbmI.equals(com_google_android_gms_internal_zzasd.zzbmI);
    }

    public String getPlaceId() {
        return this.zzblg;
    }

    public int hashCode() {
        return zzaa.hashCode(this.zzblg, this.zzbmI);
    }

    public String toString() {
        return zzaa.zzv(this).zzg("placeId", this.zzblg).zzg("placeAliases", this.zzbmI).toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzase.zza(this, parcel, i);
    }

    public List<String> zzIr() {
        return this.zzbmI;
    }
}
