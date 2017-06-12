package com.google.android.gms.internal;

import com.google.android.gms.internal.zzbns.zza;

public class zzbnp {
    private static final zzbnt<Boolean> zzceZ;
    private static final zzbnt<Boolean> zzcfa;
    private static final zzbns<Boolean> zzcfb;
    private static final zzbns<Boolean> zzcfc;
    private final zzbns<Boolean> zzceY;

    /* renamed from: com.google.android.gms.internal.zzbnp.1 */
    class C12511 implements zzbnt<Boolean> {
        C12511() {
        }

        public /* synthetic */ boolean zzaq(Object obj) {
            return zzf((Boolean) obj);
        }

        public boolean zzf(Boolean bool) {
            return !bool.booleanValue();
        }
    }

    /* renamed from: com.google.android.gms.internal.zzbnp.2 */
    class C12522 implements zzbnt<Boolean> {
        C12522() {
        }

        public /* synthetic */ boolean zzaq(Object obj) {
            return zzf((Boolean) obj);
        }

        public boolean zzf(Boolean bool) {
            return bool.booleanValue();
        }
    }

    /* renamed from: com.google.android.gms.internal.zzbnp.3 */
    class C12533 implements zza<Boolean, T> {
        final /* synthetic */ zza zzcfd;

        C12533(zzbnp com_google_android_gms_internal_zzbnp, zza com_google_android_gms_internal_zzbns_zza) {
            this.zzcfd = com_google_android_gms_internal_zzbns_zza;
        }

        public T zza(zzbmj com_google_android_gms_internal_zzbmj, Boolean bool, T t) {
            return !bool.booleanValue() ? this.zzcfd.zza(com_google_android_gms_internal_zzbmj, null, t) : t;
        }
    }

    static {
        zzceZ = new C12511();
        zzcfa = new C12522();
        zzcfb = new zzbns(Boolean.valueOf(true));
        zzcfc = new zzbns(Boolean.valueOf(false));
    }

    public zzbnp() {
        this.zzceY = zzbns.zzYd();
    }

    private zzbnp(zzbns<Boolean> com_google_android_gms_internal_zzbns_java_lang_Boolean) {
        this.zzceY = com_google_android_gms_internal_zzbns_java_lang_Boolean;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzbnp)) {
            return false;
        }
        return this.zzceY.equals(((zzbnp) obj).zzceY);
    }

    public int hashCode() {
        return this.zzceY.hashCode();
    }

    public String toString() {
        String valueOf = String.valueOf(this.zzceY.toString());
        return new StringBuilder(String.valueOf(valueOf).length() + 14).append("{PruneForest:").append(valueOf).append("}").toString();
    }

    public boolean zzXY() {
        return this.zzceY.zzb(zzcfa);
    }

    public <T> T zza(T t, zza<Void, T> com_google_android_gms_internal_zzbns_zza_java_lang_Void__T) {
        return this.zzceY.zzb((Object) t, new C12533(this, com_google_android_gms_internal_zzbns_zza_java_lang_Void__T));
    }

    public zzbnp zzd(zzbos com_google_android_gms_internal_zzbos) {
        zzbns zze = this.zzceY.zze(com_google_android_gms_internal_zzbos);
        zzbns com_google_android_gms_internal_zzbns = zze == null ? new zzbns((Boolean) this.zzceY.getValue()) : (zze.getValue() != null || this.zzceY.getValue() == null) ? zze : zze.zzb(zzbmj.zzXf(), (Boolean) this.zzceY.getValue());
        return new zzbnp(com_google_android_gms_internal_zzbns);
    }

    public boolean zzw(zzbmj com_google_android_gms_internal_zzbmj) {
        Boolean bool = (Boolean) this.zzceY.zzH(com_google_android_gms_internal_zzbmj);
        return bool != null && bool.booleanValue();
    }

    public boolean zzx(zzbmj com_google_android_gms_internal_zzbmj) {
        Boolean bool = (Boolean) this.zzceY.zzH(com_google_android_gms_internal_zzbmj);
        return (bool == null || bool.booleanValue()) ? false : true;
    }

    public zzbnp zzy(zzbmj com_google_android_gms_internal_zzbmj) {
        if (this.zzceY.zzb(com_google_android_gms_internal_zzbmj, zzceZ) == null) {
            return this.zzceY.zzb(com_google_android_gms_internal_zzbmj, zzcfa) != null ? this : new zzbnp(this.zzceY.zza(com_google_android_gms_internal_zzbmj, zzcfb));
        } else {
            throw new IllegalArgumentException("Can't prune path that was kept previously!");
        }
    }

    public zzbnp zzz(zzbmj com_google_android_gms_internal_zzbmj) {
        return this.zzceY.zzb(com_google_android_gms_internal_zzbmj, zzceZ) != null ? this : new zzbnp(this.zzceY.zza(com_google_android_gms_internal_zzbmj, zzcfc));
    }
}
