package com.google.android.gms.internal;

public class zzbmx {
    private final zzbmj zzbXY;
    private final long zzceh;
    private final zzbpe zzcei;
    private final zzbma zzcej;
    private final boolean zzcek;

    public zzbmx(long j, zzbmj com_google_android_gms_internal_zzbmj, zzbma com_google_android_gms_internal_zzbma) {
        this.zzceh = j;
        this.zzbXY = com_google_android_gms_internal_zzbmj;
        this.zzcei = null;
        this.zzcej = com_google_android_gms_internal_zzbma;
        this.zzcek = true;
    }

    public zzbmx(long j, zzbmj com_google_android_gms_internal_zzbmj, zzbpe com_google_android_gms_internal_zzbpe, boolean z) {
        this.zzceh = j;
        this.zzbXY = com_google_android_gms_internal_zzbmj;
        this.zzcei = com_google_android_gms_internal_zzbpe;
        this.zzcej = null;
        this.zzcek = z;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        zzbmx com_google_android_gms_internal_zzbmx = (zzbmx) obj;
        if (this.zzceh != com_google_android_gms_internal_zzbmx.zzceh) {
            return false;
        }
        if (!this.zzbXY.equals(com_google_android_gms_internal_zzbmx.zzbXY)) {
            return false;
        }
        if (this.zzcek != com_google_android_gms_internal_zzbmx.zzcek) {
            return false;
        }
        if (!this.zzcei == null ? this.zzcei.equals(com_google_android_gms_internal_zzbmx.zzcei) : com_google_android_gms_internal_zzbmx.zzcei == null) {
            return false;
        }
        if (this.zzcej != null) {
            if (this.zzcej.equals(com_google_android_gms_internal_zzbmx.zzcej)) {
                return true;
            }
        } else if (com_google_android_gms_internal_zzbmx.zzcej == null) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((this.zzcei != null ? this.zzcei.hashCode() : 0) + (((((Long.valueOf(this.zzceh).hashCode() * 31) + Boolean.valueOf(this.zzcek).hashCode()) * 31) + this.zzbXY.hashCode()) * 31)) * 31;
        if (this.zzcej != null) {
            i = this.zzcej.hashCode();
        }
        return hashCode + i;
    }

    public boolean isVisible() {
        return this.zzcek;
    }

    public String toString() {
        long j = this.zzceh;
        String valueOf = String.valueOf(this.zzbXY);
        boolean z = this.zzcek;
        String valueOf2 = String.valueOf(this.zzcei);
        String valueOf3 = String.valueOf(this.zzcej);
        return new StringBuilder(((String.valueOf(valueOf).length() + 78) + String.valueOf(valueOf2).length()) + String.valueOf(valueOf3).length()).append("UserWriteRecord{id=").append(j).append(" path=").append(valueOf).append(" visible=").append(z).append(" overwrite=").append(valueOf2).append(" merge=").append(valueOf3).append("}").toString();
    }

    public zzbmj zzVc() {
        return this.zzbXY;
    }

    public long zzXC() {
        return this.zzceh;
    }

    public zzbpe zzXD() {
        if (this.zzcei != null) {
            return this.zzcei;
        }
        throw new IllegalArgumentException("Can't access overwrite when write is a merge!");
    }

    public zzbma zzXE() {
        if (this.zzcej != null) {
            return this.zzcej;
        }
        throw new IllegalArgumentException("Can't access merge when write is an overwrite!");
    }

    public boolean zzXF() {
        return this.zzcei != null;
    }
}
