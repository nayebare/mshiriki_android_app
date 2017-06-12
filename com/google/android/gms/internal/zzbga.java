package com.google.android.gms.internal;

import com.google.android.gms.common.internal.zzac;

public final class zzbga extends zzbfw<zzbfw<?>> {
    public static final zzbga zzbKS;
    public static final zzbga zzbKT;
    public static final zzbga zzbKU;
    public static final zzbga zzbKV;
    private final String mName;
    private final boolean zzbKW;
    private final zzbfw<?> zzbKX;

    static {
        zzbKS = new zzbga("BREAK");
        zzbKT = new zzbga("CONTINUE");
        zzbKU = new zzbga("NULL");
        zzbKV = new zzbga("UNDEFINED");
    }

    public zzbga(zzbfw<?> com_google_android_gms_internal_zzbfw_) {
        zzac.zzw(com_google_android_gms_internal_zzbfw_);
        this.mName = "RETURN";
        this.zzbKW = true;
        this.zzbKX = com_google_android_gms_internal_zzbfw_;
    }

    private zzbga(String str) {
        this.mName = str;
        this.zzbKW = false;
        this.zzbKX = null;
    }

    public String toString() {
        return this.mName;
    }

    public /* synthetic */ Object zzRF() {
        return zzRL();
    }

    public zzbfw zzRL() {
        return this.zzbKX;
    }

    public boolean zzRM() {
        return this.zzbKW;
    }
}
