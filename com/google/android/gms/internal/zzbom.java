package com.google.android.gms.internal;

import com.google.android.gms.internal.zzbol.zza;
import java.util.Iterator;

public class zzbom implements zzbol {
    private final zzboy zzcfT;
    private final zzbpd zzcgA;
    private final zzbpd zzcgB;
    private final zzboj zzcgz;

    public zzbom(zzbod com_google_android_gms_internal_zzbod) {
        this.zzcgz = new zzboj(com_google_android_gms_internal_zzbod.zzYz());
        this.zzcfT = com_google_android_gms_internal_zzbod.zzYz();
        this.zzcgA = zzd(com_google_android_gms_internal_zzbod);
        this.zzcgB = zze(com_google_android_gms_internal_zzbod);
    }

    private static zzbpd zzd(zzbod com_google_android_gms_internal_zzbod) {
        if (!com_google_android_gms_internal_zzbod.zzYr()) {
            return com_google_android_gms_internal_zzbod.zzYz().zzZq();
        }
        return com_google_android_gms_internal_zzbod.zzYz().zzg(com_google_android_gms_internal_zzbod.zzYt(), com_google_android_gms_internal_zzbod.zzYs());
    }

    private static zzbpd zze(zzbod com_google_android_gms_internal_zzbod) {
        if (!com_google_android_gms_internal_zzbod.zzYu()) {
            return com_google_android_gms_internal_zzbod.zzYz().zzZr();
        }
        return com_google_android_gms_internal_zzbod.zzYz().zzg(com_google_android_gms_internal_zzbod.zzYw(), com_google_android_gms_internal_zzbod.zzYv());
    }

    public zzbol zzYP() {
        return this.zzcgz;
    }

    public boolean zzYQ() {
        return true;
    }

    public zzbpd zzYR() {
        return this.zzcgA;
    }

    public zzbpd zzYS() {
        return this.zzcgB;
    }

    public zzboy zzYz() {
        return this.zzcfT;
    }

    public zzboz zza(zzboz com_google_android_gms_internal_zzboz, zzbos com_google_android_gms_internal_zzbos, zzbpe com_google_android_gms_internal_zzbpe, zzbmj com_google_android_gms_internal_zzbmj, zza com_google_android_gms_internal_zzbol_zza, zzboi com_google_android_gms_internal_zzboi) {
        return this.zzcgz.zza(com_google_android_gms_internal_zzboz, com_google_android_gms_internal_zzbos, !zza(new zzbpd(com_google_android_gms_internal_zzbos, com_google_android_gms_internal_zzbpe)) ? zzbox.zzZp() : com_google_android_gms_internal_zzbpe, com_google_android_gms_internal_zzbmj, com_google_android_gms_internal_zzbol_zza, com_google_android_gms_internal_zzboi);
    }

    public zzboz zza(zzboz com_google_android_gms_internal_zzboz, zzboz com_google_android_gms_internal_zzboz2, zzboi com_google_android_gms_internal_zzboi) {
        zzboz zza;
        if (com_google_android_gms_internal_zzboz2.zzUY().zzZd()) {
            zza = zzboz.zza(zzbox.zzZp(), this.zzcfT);
        } else {
            zzboz zzo = com_google_android_gms_internal_zzboz2.zzo(zzbpi.zzZB());
            Iterator it = com_google_android_gms_internal_zzboz2.iterator();
            zza = zzo;
            while (it.hasNext()) {
                zzbpd com_google_android_gms_internal_zzbpd = (zzbpd) it.next();
                zza = !zza(com_google_android_gms_internal_zzbpd) ? zza.zzh(com_google_android_gms_internal_zzbpd.zzZz(), zzbox.zzZp()) : zza;
            }
        }
        return this.zzcgz.zza(com_google_android_gms_internal_zzboz, zza, com_google_android_gms_internal_zzboi);
    }

    public zzboz zza(zzboz com_google_android_gms_internal_zzboz, zzbpe com_google_android_gms_internal_zzbpe) {
        return com_google_android_gms_internal_zzboz;
    }

    public boolean zza(zzbpd com_google_android_gms_internal_zzbpd) {
        return this.zzcfT.compare(zzYR(), com_google_android_gms_internal_zzbpd) <= 0 && this.zzcfT.compare(com_google_android_gms_internal_zzbpd, zzYS()) <= 0;
    }
}
