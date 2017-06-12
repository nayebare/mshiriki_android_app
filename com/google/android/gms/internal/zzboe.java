package com.google.android.gms.internal;

import java.util.Map;

public class zzboe {
    private final zzbmj zzbXY;
    private final zzbod zzbYc;

    public zzboe(zzbmj com_google_android_gms_internal_zzbmj, zzbod com_google_android_gms_internal_zzbod) {
        this.zzbXY = com_google_android_gms_internal_zzbmj;
        this.zzbYc = com_google_android_gms_internal_zzbod;
    }

    public static zzboe zzN(zzbmj com_google_android_gms_internal_zzbmj) {
        return new zzboe(com_google_android_gms_internal_zzbmj, zzbod.zzcfX);
    }

    public static zzboe zzb(zzbmj com_google_android_gms_internal_zzbmj, Map<String, Object> map) {
        return new zzboe(com_google_android_gms_internal_zzbmj, zzbod.zzaD(map));
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        zzboe com_google_android_gms_internal_zzboe = (zzboe) obj;
        return !this.zzbXY.equals(com_google_android_gms_internal_zzboe.zzbXY) ? false : this.zzbYc.equals(com_google_android_gms_internal_zzboe.zzbYc);
    }

    public int hashCode() {
        return (this.zzbXY.hashCode() * 31) + this.zzbYc.hashCode();
    }

    public boolean isDefault() {
        return this.zzbYc.isDefault();
    }

    public String toString() {
        String valueOf = String.valueOf(this.zzbXY);
        String valueOf2 = String.valueOf(this.zzbYc);
        return new StringBuilder((String.valueOf(valueOf).length() + 1) + String.valueOf(valueOf2).length()).append(valueOf).append(":").append(valueOf2).toString();
    }

    public zzbmj zzVc() {
        return this.zzbXY;
    }

    public boolean zzYD() {
        return this.zzbYc.zzYD();
    }

    public zzbod zzYG() {
        return this.zzbYc;
    }

    public zzboy zzYz() {
        return this.zzbYc.zzYz();
    }
}
