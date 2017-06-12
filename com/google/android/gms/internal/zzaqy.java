package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;

public final class zzaqy extends zza {
    public static final Creator<zzaqy> CREATOR;
    final int versionCode;
    private final String[] zzbiq;
    private final String[] zzbir;
    private final String[] zzbis;
    private final String[] zzbit;

    static {
        CREATOR = new zzaqz();
    }

    zzaqy(int i, String[] strArr, String[] strArr2, String[] strArr3, String[] strArr4) {
        this.versionCode = i;
        this.zzbiq = strArr;
        this.zzbir = strArr2;
        this.zzbit = strArr3;
        this.zzbis = strArr4;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzaqz.zza(this, parcel, i);
    }

    public String[] zzGV() {
        return this.zzbiq;
    }

    public String[] zzGW() {
        return this.zzbir;
    }

    public String[] zzGX() {
        return this.zzbit;
    }

    public String[] zzGY() {
        return this.zzbis;
    }
}
