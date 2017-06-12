package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.zzac;

public class zzara extends zza {
    public static final Creator<zzara> CREATOR;
    private final int port;
    public final int version;
    private final String zzbhO;
    private final zzaqx zzbiA;
    private final String zzbiu;
    private final String zzbiv;
    private final String zzbiw;
    private final String zzbix;
    private final String zzbiy;
    private final String zzbiz;

    static {
        CREATOR = new zzarb();
    }

    zzara(int i, String str, int i2, String str2, String str3, String str4, String str5, String str6, String str7) {
        this.version = i;
        this.zzbiu = zzac.zzdv(str);
        this.port = i2;
        this.zzbiv = str2;
        this.zzbiw = str3;
        this.zzbix = str4;
        this.zzbiy = str5;
        this.zzbhO = str6;
        this.zzbiz = str7;
        if (!TextUtils.isEmpty(str2)) {
            this.zzbiA = new zzaqx(str2, 0);
        } else if (!TextUtils.isEmpty(str3)) {
            this.zzbiA = new zzaqx(str3, 1);
        } else if (!TextUtils.isEmpty(str4)) {
            this.zzbiA = new zzaqx(str4, 2);
        } else if (TextUtils.isEmpty(str5)) {
            this.zzbiA = null;
        } else {
            this.zzbiA = new zzaqx(str5, 3);
        }
    }

    public String getPath() {
        return this.zzbiv;
    }

    public int getPort() {
        return this.port;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzarb.zza(this, parcel, i);
    }

    public String zzGG() {
        return this.zzbhO;
    }

    public String zzGZ() {
        return this.zzbiu;
    }

    public String zzHa() {
        return this.zzbiw;
    }

    public String zzHb() {
        return this.zzbix;
    }

    public String zzHc() {
        return this.zzbix;
    }

    public String zzHd() {
        return this.zzbiz;
    }
}
