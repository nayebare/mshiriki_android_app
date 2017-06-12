package com.google.android.gms.internal;

import com.google.android.gms.internal.zzbol.zza;
import java.util.Iterator;

public class zzbok implements zzbol {
    static final /* synthetic */ boolean $assertionsDisabled;
    private final int limit;
    private final zzboy zzcfT;
    private final zzbom zzcgx;
    private final boolean zzcgy;

    static {
        $assertionsDisabled = !zzbok.class.desiredAssertionStatus();
    }

    public zzbok(zzbod com_google_android_gms_internal_zzbod) {
        this.zzcgx = new zzbom(com_google_android_gms_internal_zzbod);
        this.zzcfT = com_google_android_gms_internal_zzbod.zzYz();
        this.limit = com_google_android_gms_internal_zzbod.getLimit();
        this.zzcgy = !com_google_android_gms_internal_zzbod.zzYB();
    }

    private zzboz zza(zzboz com_google_android_gms_internal_zzboz, zzbos com_google_android_gms_internal_zzbos, zzbpe com_google_android_gms_internal_zzbpe, zza com_google_android_gms_internal_zzbol_zza, zzboi com_google_android_gms_internal_zzboi) {
        if ($assertionsDisabled || com_google_android_gms_internal_zzboz.zzUY().getChildCount() == this.limit) {
            zzbpd com_google_android_gms_internal_zzbpd = new zzbpd(com_google_android_gms_internal_zzbos, com_google_android_gms_internal_zzbpe);
            zzbpd zzZu = this.zzcgy ? com_google_android_gms_internal_zzboz.zzZu() : com_google_android_gms_internal_zzboz.zzZv();
            boolean zza = this.zzcgx.zza(com_google_android_gms_internal_zzbpd);
            if (com_google_android_gms_internal_zzboz.zzUY().zzk(com_google_android_gms_internal_zzbos)) {
                zzbpe zzm = com_google_android_gms_internal_zzboz.zzUY().zzm(com_google_android_gms_internal_zzbos);
                zzbpd zza2 = com_google_android_gms_internal_zzbol_zza.zza(this.zzcfT, zzZu, this.zzcgy);
                while (zza2 != null && (zza2.zzZz().equals(com_google_android_gms_internal_zzbos) || com_google_android_gms_internal_zzboz.zzUY().zzk(zza2.zzZz()))) {
                    zza2 = com_google_android_gms_internal_zzbol_zza.zza(this.zzcfT, zza2, this.zzcgy);
                }
                Object obj = (!zza || com_google_android_gms_internal_zzbpe.isEmpty() || (zza2 == null ? 1 : this.zzcfT.zza(zza2, com_google_android_gms_internal_zzbpd, this.zzcgy)) < 0) ? null : 1;
                if (obj != null) {
                    if (com_google_android_gms_internal_zzboi != null) {
                        com_google_android_gms_internal_zzboi.zza(zzbny.zza(com_google_android_gms_internal_zzbos, com_google_android_gms_internal_zzbpe, zzm));
                    }
                    return com_google_android_gms_internal_zzboz.zzh(com_google_android_gms_internal_zzbos, com_google_android_gms_internal_zzbpe);
                }
                if (com_google_android_gms_internal_zzboi != null) {
                    com_google_android_gms_internal_zzboi.zza(zzbny.zzd(com_google_android_gms_internal_zzbos, zzm));
                }
                com_google_android_gms_internal_zzboz = com_google_android_gms_internal_zzboz.zzh(com_google_android_gms_internal_zzbos, zzbox.zzZp());
                obj = (zza2 == null || !this.zzcgx.zza(zza2)) ? null : 1;
                if (obj == null) {
                    return com_google_android_gms_internal_zzboz;
                }
                if (com_google_android_gms_internal_zzboi != null) {
                    com_google_android_gms_internal_zzboi.zza(zzbny.zzc(zza2.zzZz(), zza2.zzUY()));
                }
                return com_google_android_gms_internal_zzboz.zzh(zza2.zzZz(), zza2.zzUY());
            } else if (com_google_android_gms_internal_zzbpe.isEmpty() || !zza || this.zzcfT.zza(zzZu, com_google_android_gms_internal_zzbpd, this.zzcgy) < 0) {
                return com_google_android_gms_internal_zzboz;
            } else {
                if (com_google_android_gms_internal_zzboi != null) {
                    com_google_android_gms_internal_zzboi.zza(zzbny.zzd(zzZu.zzZz(), zzZu.zzUY()));
                    com_google_android_gms_internal_zzboi.zza(zzbny.zzc(com_google_android_gms_internal_zzbos, com_google_android_gms_internal_zzbpe));
                }
                return com_google_android_gms_internal_zzboz.zzh(com_google_android_gms_internal_zzbos, com_google_android_gms_internal_zzbpe).zzh(zzZu.zzZz(), zzbox.zzZp());
            }
        }
        throw new AssertionError();
    }

    public zzbol zzYP() {
        return this.zzcgx.zzYP();
    }

    public boolean zzYQ() {
        return true;
    }

    public zzboy zzYz() {
        return this.zzcfT;
    }

    public zzboz zza(zzboz com_google_android_gms_internal_zzboz, zzbos com_google_android_gms_internal_zzbos, zzbpe com_google_android_gms_internal_zzbpe, zzbmj com_google_android_gms_internal_zzbmj, zza com_google_android_gms_internal_zzbol_zza, zzboi com_google_android_gms_internal_zzboi) {
        zzbpe zzZp = !this.zzcgx.zza(new zzbpd(com_google_android_gms_internal_zzbos, com_google_android_gms_internal_zzbpe)) ? zzbox.zzZp() : com_google_android_gms_internal_zzbpe;
        return com_google_android_gms_internal_zzboz.zzUY().zzm(com_google_android_gms_internal_zzbos).equals(zzZp) ? com_google_android_gms_internal_zzboz : com_google_android_gms_internal_zzboz.zzUY().getChildCount() < this.limit ? this.zzcgx.zzYP().zza(com_google_android_gms_internal_zzboz, com_google_android_gms_internal_zzbos, zzZp, com_google_android_gms_internal_zzbmj, com_google_android_gms_internal_zzbol_zza, com_google_android_gms_internal_zzboi) : zza(com_google_android_gms_internal_zzboz, com_google_android_gms_internal_zzbos, zzZp, com_google_android_gms_internal_zzbol_zza, com_google_android_gms_internal_zzboi);
    }

    public zzboz zza(zzboz com_google_android_gms_internal_zzboz, zzboz com_google_android_gms_internal_zzboz2, zzboi com_google_android_gms_internal_zzboi) {
        zzboz zza;
        if (com_google_android_gms_internal_zzboz2.zzUY().zzZd() || com_google_android_gms_internal_zzboz2.zzUY().isEmpty()) {
            zza = zzboz.zza(zzbox.zzZp(), this.zzcfT);
        } else {
            Object zzYR;
            Iterator it;
            int i;
            zzboz zzo = com_google_android_gms_internal_zzboz2.zzo(zzbpi.zzZB());
            if (this.zzcgy) {
                Iterator zzVl = com_google_android_gms_internal_zzboz2.zzVl();
                Object zzYS = this.zzcgx.zzYS();
                zzYR = this.zzcgx.zzYR();
                it = zzVl;
                i = -1;
            } else {
                Iterator it2 = com_google_android_gms_internal_zzboz2.iterator();
                zzbpd zzYR2 = this.zzcgx.zzYR();
                zzbpd zzYS2 = this.zzcgx.zzYS();
                zzbpd com_google_android_gms_internal_zzbpd = zzYR2;
                i = 1;
                it = it2;
            }
            int i2 = 0;
            zza = zzo;
            Object obj = null;
            while (it.hasNext()) {
                int i3;
                zzboz com_google_android_gms_internal_zzboz3;
                zzbpd com_google_android_gms_internal_zzbpd2 = (zzbpd) it.next();
                if (obj == null && this.zzcfT.compare(r5, com_google_android_gms_internal_zzbpd2) * i <= 0) {
                    obj = 1;
                }
                Object obj2 = (obj == null || i2 >= this.limit || this.zzcfT.compare(com_google_android_gms_internal_zzbpd2, zzYR) * i > 0) ? null : 1;
                if (obj2 != null) {
                    i3 = i2 + 1;
                    com_google_android_gms_internal_zzboz3 = zza;
                } else {
                    zza = zza.zzh(com_google_android_gms_internal_zzbpd2.zzZz(), zzbox.zzZp());
                    i3 = i2;
                    com_google_android_gms_internal_zzboz3 = zza;
                }
                zza = com_google_android_gms_internal_zzboz3;
                i2 = i3;
            }
        }
        return this.zzcgx.zzYP().zza(com_google_android_gms_internal_zzboz, zza, com_google_android_gms_internal_zzboi);
    }

    public zzboz zza(zzboz com_google_android_gms_internal_zzboz, zzbpe com_google_android_gms_internal_zzbpe) {
        return com_google_android_gms_internal_zzboz;
    }
}
