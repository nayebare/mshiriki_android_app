package com.google.android.gms.internal;

public class zzbpd {
    private static final zzbpd zzchs;
    private static final zzbpd zzcht;
    private final zzbos zzcfw;
    private final zzbpe zzchj;

    static {
        zzchs = new zzbpd(zzbos.zzYW(), zzbox.zzZp());
        zzcht = new zzbpd(zzbos.zzYX(), zzbpe.zzchu);
    }

    public zzbpd(zzbos com_google_android_gms_internal_zzbos, zzbpe com_google_android_gms_internal_zzbpe) {
        this.zzcfw = com_google_android_gms_internal_zzbos;
        this.zzchj = com_google_android_gms_internal_zzbpe;
    }

    public static zzbpd zzZx() {
        return zzchs;
    }

    public static zzbpd zzZy() {
        return zzcht;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        zzbpd com_google_android_gms_internal_zzbpd = (zzbpd) obj;
        return !this.zzcfw.equals(com_google_android_gms_internal_zzbpd.zzcfw) ? false : this.zzchj.equals(com_google_android_gms_internal_zzbpd.zzchj);
    }

    public int hashCode() {
        return (this.zzcfw.hashCode() * 31) + this.zzchj.hashCode();
    }

    public String toString() {
        String valueOf = String.valueOf(this.zzcfw);
        String valueOf2 = String.valueOf(this.zzchj);
        return new StringBuilder((String.valueOf(valueOf).length() + 23) + String.valueOf(valueOf2).length()).append("NamedNode{name=").append(valueOf).append(", node=").append(valueOf2).append("}").toString();
    }

    public zzbpe zzUY() {
        return this.zzchj;
    }

    public zzbos zzZz() {
        return this.zzcfw;
    }
}
