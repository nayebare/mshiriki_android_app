package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;

@Deprecated
public final class ProxyCard extends zza {
    public static final Creator<ProxyCard> CREATOR;
    private final int mVersionCode;
    String zzbPp;
    String zzbPq;
    int zzbPr;
    int zzbPs;

    static {
        CREATOR = new zzt();
    }

    ProxyCard(int i, String str, String str2, int i2, int i3) {
        this.mVersionCode = i;
        this.zzbPp = str;
        this.zzbPq = str2;
        this.zzbPr = i2;
        this.zzbPs = i3;
    }

    public String getCvn() {
        return this.zzbPq;
    }

    public int getExpirationMonth() {
        return this.zzbPr;
    }

    public int getExpirationYear() {
        return this.zzbPs;
    }

    public String getPan() {
        return this.zzbPp;
    }

    public int getVersionCode() {
        return this.mVersionCode;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzt.zza(this, parcel, i);
    }
}
