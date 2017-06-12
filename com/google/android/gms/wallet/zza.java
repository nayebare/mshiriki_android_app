package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;

@Deprecated
public final class zza extends com.google.android.gms.common.internal.safeparcel.zza {
    public static final Creator<zza> CREATOR;
    private final int mVersionCode;
    String name;
    String phoneNumber;
    String zzUe;
    String zzbNO;
    String zzbNP;
    String zzbgO;
    String zzbgP;
    String zzbgQ;
    String zzbgV;
    boolean zzbgX;
    String zzbgY;

    static {
        CREATOR = new zzb();
    }

    zza() {
        this.mVersionCode = 1;
    }

    zza(int i, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, boolean z, String str10) {
        this.mVersionCode = i;
        this.name = str;
        this.zzbgO = str2;
        this.zzbgP = str3;
        this.zzbgQ = str4;
        this.zzUe = str5;
        this.zzbNO = str6;
        this.zzbNP = str7;
        this.zzbgV = str8;
        this.phoneNumber = str9;
        this.zzbgX = z;
        this.zzbgY = str10;
    }

    public int getVersionCode() {
        return this.mVersionCode;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzb.zza(this, parcel, i);
    }
}
