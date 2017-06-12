package com.google.android.gms.internal;

import android.support.v7.mediarouter.C0308R;

public class zzbnq {
    public final long id;
    public final zzboe zzcfe;
    public final long zzcff;
    public final boolean zzcfg;
    public final boolean zzcfh;

    public zzbnq(long j, zzboe com_google_android_gms_internal_zzboe, long j2, boolean z, boolean z2) {
        this.id = j;
        if (!com_google_android_gms_internal_zzboe.zzYD() || com_google_android_gms_internal_zzboe.isDefault()) {
            this.zzcfe = com_google_android_gms_internal_zzboe;
            this.zzcff = j2;
            this.zzcfg = z;
            this.zzcfh = z2;
            return;
        }
        throw new IllegalArgumentException("Can't create TrackedQuery for a non-default query that loads all data");
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != getClass()) {
            return false;
        }
        zzbnq com_google_android_gms_internal_zzbnq = (zzbnq) obj;
        return this.id == com_google_android_gms_internal_zzbnq.id && this.zzcfe.equals(com_google_android_gms_internal_zzbnq.zzcfe) && this.zzcff == com_google_android_gms_internal_zzbnq.zzcff && this.zzcfg == com_google_android_gms_internal_zzbnq.zzcfg && this.zzcfh == com_google_android_gms_internal_zzbnq.zzcfh;
    }

    public int hashCode() {
        return (((((((Long.valueOf(this.id).hashCode() * 31) + this.zzcfe.hashCode()) * 31) + Long.valueOf(this.zzcff).hashCode()) * 31) + Boolean.valueOf(this.zzcfg).hashCode()) * 31) + Boolean.valueOf(this.zzcfh).hashCode();
    }

    public String toString() {
        long j = this.id;
        String valueOf = String.valueOf(this.zzcfe);
        long j2 = this.zzcff;
        boolean z = this.zzcfg;
        return new StringBuilder(String.valueOf(valueOf).length() + C0308R.styleable.AppCompatTheme_ratingBarStyleIndicator).append("TrackedQuery{id=").append(j).append(", querySpec=").append(valueOf).append(", lastUse=").append(j2).append(", complete=").append(z).append(", active=").append(this.zzcfh).append("}").toString();
    }

    public zzbnq zzXZ() {
        return new zzbnq(this.id, this.zzcfe, this.zzcff, true, this.zzcfh);
    }

    public zzbnq zzaO(long j) {
        return new zzbnq(this.id, this.zzcfe, j, this.zzcfg, this.zzcfh);
    }

    public zzbnq zzbb(boolean z) {
        return new zzbnq(this.id, this.zzcfe, this.zzcff, this.zzcfg, z);
    }
}
