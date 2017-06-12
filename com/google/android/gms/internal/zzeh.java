package com.google.android.gms.internal;

@zzmb
public class zzeh {
    private static final Object zztU;
    private static zzeh zzzF;
    private final zzpx zzzG;
    private final zzeg zzzH;

    static {
        zztU = new Object();
        zza(new zzeh());
    }

    protected zzeh() {
        this.zzzG = new zzpx();
        this.zzzH = new zzeg(new zzdx(), new zzdw(), new zzfd(), new zzhn(), new zznv(), new zzlf(), new zzkq());
    }

    protected static void zza(zzeh com_google_android_gms_internal_zzeh) {
        synchronized (zztU) {
            zzzF = com_google_android_gms_internal_zzeh;
        }
    }

    private static zzeh zzeN() {
        zzeh com_google_android_gms_internal_zzeh;
        synchronized (zztU) {
            com_google_android_gms_internal_zzeh = zzzF;
        }
        return com_google_android_gms_internal_zzeh;
    }

    public static zzpx zzeO() {
        return zzeN().zzzG;
    }

    public static zzeg zzeP() {
        return zzeN().zzzH;
    }
}
