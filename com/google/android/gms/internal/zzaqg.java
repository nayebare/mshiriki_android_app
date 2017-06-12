package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;

public class zzaqg extends zza {
    public static final Creator<zzaqg> CREATOR;
    public final int version;
    private final String zzbhO;
    private final String zzbhP;
    private final String zzbhQ;
    private final String[] zzbhR;

    static {
        CREATOR = new zzaqh();
    }

    zzaqg(int i, String str, String str2, String str3, String[] strArr) {
        this.version = i;
        this.zzbhO = str;
        this.zzbhP = str2;
        this.zzbhQ = str3;
        this.zzbhR = strArr;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzaqh.zza(this, parcel, i);
    }

    public String zzGG() {
        return this.zzbhO;
    }

    public String zzGH() {
        return this.zzbhP;
    }

    public String zzGI() {
        return this.zzbhQ;
    }

    public String[] zzGJ() {
        return this.zzbhR;
    }
}
