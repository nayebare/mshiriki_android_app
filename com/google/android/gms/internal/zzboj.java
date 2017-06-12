package com.google.android.gms.internal;

import com.google.android.gms.internal.zzbol.zza;

public class zzboj implements zzbol {
    static final /* synthetic */ boolean $assertionsDisabled;
    private final zzboy zzcfT;

    static {
        $assertionsDisabled = !zzboj.class.desiredAssertionStatus();
    }

    public zzboj(zzboy com_google_android_gms_internal_zzboy) {
        this.zzcfT = com_google_android_gms_internal_zzboy;
    }

    public zzbol zzYP() {
        return this;
    }

    public boolean zzYQ() {
        return false;
    }

    public zzboy zzYz() {
        return this.zzcfT;
    }

    public zzboz zza(zzboz com_google_android_gms_internal_zzboz, zzbos com_google_android_gms_internal_zzbos, zzbpe com_google_android_gms_internal_zzbpe, zzbmj com_google_android_gms_internal_zzbmj, zza com_google_android_gms_internal_zzbol_zza, zzboi com_google_android_gms_internal_zzboi) {
        if ($assertionsDisabled || com_google_android_gms_internal_zzboz.zzb(this.zzcfT)) {
            zzbpe zzUY = com_google_android_gms_internal_zzboz.zzUY();
            zzbpe zzm = zzUY.zzm(com_google_android_gms_internal_zzbos);
            if (zzm.zzO(com_google_android_gms_internal_zzbmj).equals(com_google_android_gms_internal_zzbpe.zzO(com_google_android_gms_internal_zzbmj)) && zzm.isEmpty() == com_google_android_gms_internal_zzbpe.isEmpty()) {
                return com_google_android_gms_internal_zzboz;
            }
            if (com_google_android_gms_internal_zzboi != null) {
                if (com_google_android_gms_internal_zzbpe.isEmpty()) {
                    if (zzUY.zzk(com_google_android_gms_internal_zzbos)) {
                        com_google_android_gms_internal_zzboi.zza(zzbny.zzd(com_google_android_gms_internal_zzbos, zzm));
                    } else if (!($assertionsDisabled || zzUY.zzZd())) {
                        throw new AssertionError("A child remove without an old child only makes sense on a leaf node");
                    }
                } else if (zzm.isEmpty()) {
                    com_google_android_gms_internal_zzboi.zza(zzbny.zzc(com_google_android_gms_internal_zzbos, com_google_android_gms_internal_zzbpe));
                } else {
                    com_google_android_gms_internal_zzboi.zza(zzbny.zza(com_google_android_gms_internal_zzbos, com_google_android_gms_internal_zzbpe, zzm));
                }
            }
            return (zzUY.zzZd() && com_google_android_gms_internal_zzbpe.isEmpty()) ? com_google_android_gms_internal_zzboz : com_google_android_gms_internal_zzboz.zzh(com_google_android_gms_internal_zzbos, com_google_android_gms_internal_zzbpe);
        } else {
            throw new AssertionError("The index must match the filter");
        }
    }

    public zzboz zza(zzboz com_google_android_gms_internal_zzboz, zzboz com_google_android_gms_internal_zzboz2, zzboi com_google_android_gms_internal_zzboi) {
        if ($assertionsDisabled || com_google_android_gms_internal_zzboz2.zzb(this.zzcfT)) {
            if (com_google_android_gms_internal_zzboi != null) {
                for (zzbpd com_google_android_gms_internal_zzbpd : com_google_android_gms_internal_zzboz.zzUY()) {
                    if (!com_google_android_gms_internal_zzboz2.zzUY().zzk(com_google_android_gms_internal_zzbpd.zzZz())) {
                        com_google_android_gms_internal_zzboi.zza(zzbny.zzd(com_google_android_gms_internal_zzbpd.zzZz(), com_google_android_gms_internal_zzbpd.zzUY()));
                    }
                }
                if (!com_google_android_gms_internal_zzboz2.zzUY().zzZd()) {
                    for (zzbpd com_google_android_gms_internal_zzbpd2 : com_google_android_gms_internal_zzboz2.zzUY()) {
                        if (com_google_android_gms_internal_zzboz.zzUY().zzk(com_google_android_gms_internal_zzbpd2.zzZz())) {
                            zzbpe zzm = com_google_android_gms_internal_zzboz.zzUY().zzm(com_google_android_gms_internal_zzbpd2.zzZz());
                            if (!zzm.equals(com_google_android_gms_internal_zzbpd2.zzUY())) {
                                com_google_android_gms_internal_zzboi.zza(zzbny.zza(com_google_android_gms_internal_zzbpd2.zzZz(), com_google_android_gms_internal_zzbpd2.zzUY(), zzm));
                            }
                        } else {
                            com_google_android_gms_internal_zzboi.zza(zzbny.zzc(com_google_android_gms_internal_zzbpd2.zzZz(), com_google_android_gms_internal_zzbpd2.zzUY()));
                        }
                    }
                }
            }
            return com_google_android_gms_internal_zzboz2;
        }
        throw new AssertionError("Can't use IndexedNode that doesn't have filter's index");
    }

    public zzboz zza(zzboz com_google_android_gms_internal_zzboz, zzbpe com_google_android_gms_internal_zzbpe) {
        return com_google_android_gms_internal_zzboz.zzUY().isEmpty() ? com_google_android_gms_internal_zzboz : com_google_android_gms_internal_zzboz.zzo(com_google_android_gms_internal_zzbpe);
    }
}
