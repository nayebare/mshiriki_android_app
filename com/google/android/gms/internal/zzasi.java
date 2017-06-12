package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.zzaa;

@Deprecated
public class zzasi extends zza {
    public static final Creator<zzasi> CREATOR;
    public static final zzasi zzbmK;
    public static final zzasi zzbmL;
    final int mVersionCode;
    private final String zzbmM;

    static {
        CREATOR = new zzasj();
        zzbmK = new zzasi(0, "Home");
        zzbmL = new zzasi(0, "Work");
    }

    zzasi(int i, String str) {
        this.mVersionCode = i;
        this.zzbmM = str;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzasi)) {
            return false;
        }
        return zzaa.equal(this.zzbmM, ((zzasi) obj).zzbmM);
    }

    public int hashCode() {
        return zzaa.hashCode(this.zzbmM);
    }

    public String toString() {
        return zzaa.zzv(this).zzg("alias", this.zzbmM).toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzasj.zza(this, parcel, i);
    }

    public String zzIt() {
        return this.zzbmM;
    }
}
