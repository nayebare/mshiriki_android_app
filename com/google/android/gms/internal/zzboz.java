package com.google.android.gms.internal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class zzboz implements Iterable<zzbpd> {
    private static final zzblc<zzbpd> zzchi;
    private final zzboy zzcfT;
    private final zzbpe zzchj;
    private zzblc<zzbpd> zzchk;

    static {
        zzchi = new zzblc(Collections.emptyList(), null);
    }

    private zzboz(zzbpe com_google_android_gms_internal_zzbpe, zzboy com_google_android_gms_internal_zzboy) {
        this.zzcfT = com_google_android_gms_internal_zzboy;
        this.zzchj = com_google_android_gms_internal_zzbpe;
        this.zzchk = null;
    }

    private zzboz(zzbpe com_google_android_gms_internal_zzbpe, zzboy com_google_android_gms_internal_zzboy, zzblc<zzbpd> com_google_android_gms_internal_zzblc_com_google_android_gms_internal_zzbpd) {
        this.zzcfT = com_google_android_gms_internal_zzboy;
        this.zzchj = com_google_android_gms_internal_zzbpe;
        this.zzchk = com_google_android_gms_internal_zzblc_com_google_android_gms_internal_zzbpd;
    }

    private void zzZt() {
        if (this.zzchk != null) {
            return;
        }
        if (this.zzcfT.equals(zzbpa.zzZw())) {
            this.zzchk = zzchi;
            return;
        }
        List arrayList = new ArrayList();
        Object obj = null;
        for (zzbpd com_google_android_gms_internal_zzbpd : this.zzchj) {
            obj = (obj != null || this.zzcfT.zzm(com_google_android_gms_internal_zzbpd.zzUY())) ? 1 : null;
            arrayList.add(new zzbpd(com_google_android_gms_internal_zzbpd.zzZz(), com_google_android_gms_internal_zzbpd.zzUY()));
        }
        if (obj != null) {
            this.zzchk = new zzblc(arrayList, this.zzcfT);
        } else {
            this.zzchk = zzchi;
        }
    }

    public static zzboz zza(zzbpe com_google_android_gms_internal_zzbpe, zzboy com_google_android_gms_internal_zzboy) {
        return new zzboz(com_google_android_gms_internal_zzbpe, com_google_android_gms_internal_zzboy);
    }

    public static zzboz zzn(zzbpe com_google_android_gms_internal_zzbpe) {
        return new zzboz(com_google_android_gms_internal_zzbpe, zzbph.zzZA());
    }

    public Iterator<zzbpd> iterator() {
        zzZt();
        return this.zzchk == zzchi ? this.zzchj.iterator() : this.zzchk.iterator();
    }

    public zzbpe zzUY() {
        return this.zzchj;
    }

    public Iterator<zzbpd> zzVl() {
        zzZt();
        return this.zzchk == zzchi ? this.zzchj.zzVl() : this.zzchk.zzVl();
    }

    public zzbpd zzZu() {
        if (!(this.zzchj instanceof zzbot)) {
            return null;
        }
        zzZt();
        if (this.zzchk != zzchi) {
            return (zzbpd) this.zzchk.zzVn();
        }
        zzbos zzZf = ((zzbot) this.zzchj).zzZf();
        return new zzbpd(zzZf, this.zzchj.zzm(zzZf));
    }

    public zzbpd zzZv() {
        if (!(this.zzchj instanceof zzbot)) {
            return null;
        }
        zzZt();
        if (this.zzchk != zzchi) {
            return (zzbpd) this.zzchk.zzVo();
        }
        zzbos zzZg = ((zzbot) this.zzchj).zzZg();
        return new zzbpd(zzZg, this.zzchj.zzm(zzZg));
    }

    public zzbos zza(zzbos com_google_android_gms_internal_zzbos, zzbpe com_google_android_gms_internal_zzbpe, zzboy com_google_android_gms_internal_zzboy) {
        if (this.zzcfT.equals(zzbpa.zzZw()) || this.zzcfT.equals(com_google_android_gms_internal_zzboy)) {
            zzZt();
            if (this.zzchk == zzchi) {
                return this.zzchj.zzl(com_google_android_gms_internal_zzbos);
            }
            zzbpd com_google_android_gms_internal_zzbpd = (zzbpd) this.zzchk.zzal(new zzbpd(com_google_android_gms_internal_zzbos, com_google_android_gms_internal_zzbpe));
            return com_google_android_gms_internal_zzbpd != null ? com_google_android_gms_internal_zzbpd.zzZz() : null;
        } else {
            throw new IllegalArgumentException("Index not available in IndexedNode!");
        }
    }

    public boolean zzb(zzboy com_google_android_gms_internal_zzboy) {
        return this.zzcfT.equals(com_google_android_gms_internal_zzboy);
    }

    public zzboz zzh(zzbos com_google_android_gms_internal_zzbos, zzbpe com_google_android_gms_internal_zzbpe) {
        zzbpe zze = this.zzchj.zze(com_google_android_gms_internal_zzbos, com_google_android_gms_internal_zzbpe);
        if (this.zzchk == zzchi && !this.zzcfT.zzm(com_google_android_gms_internal_zzbpe)) {
            return new zzboz(zze, this.zzcfT, zzchi);
        }
        if (this.zzchk == null || this.zzchk == zzchi) {
            return new zzboz(zze, this.zzcfT, null);
        }
        zzblc zzaj = this.zzchk.zzaj(new zzbpd(com_google_android_gms_internal_zzbos, this.zzchj.zzm(com_google_android_gms_internal_zzbos)));
        if (!com_google_android_gms_internal_zzbpe.isEmpty()) {
            zzaj = zzaj.zzak(new zzbpd(com_google_android_gms_internal_zzbos, com_google_android_gms_internal_zzbpe));
        }
        return new zzboz(zze, this.zzcfT, zzaj);
    }

    public zzboz zzo(zzbpe com_google_android_gms_internal_zzbpe) {
        return new zzboz(this.zzchj.zzg(com_google_android_gms_internal_zzbpe), this.zzcfT, this.zzchk);
    }
}
