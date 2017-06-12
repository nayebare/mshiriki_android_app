package com.google.android.gms.internal;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;

public class zzbna {
    static final /* synthetic */ boolean $assertionsDisabled;
    private static final zzbnt<zzbmx> zzcer;
    private zzbma zzceo;
    private List<zzbmx> zzcep;
    private Long zzceq;

    /* renamed from: com.google.android.gms.internal.zzbna.1 */
    class C12481 implements zzbnt<zzbmx> {
        final /* synthetic */ boolean zzces;
        final /* synthetic */ List zzcet;
        final /* synthetic */ zzbmj zzceu;

        C12481(zzbna com_google_android_gms_internal_zzbna, boolean z, List list, zzbmj com_google_android_gms_internal_zzbmj) {
            this.zzces = z;
            this.zzcet = list;
            this.zzceu = com_google_android_gms_internal_zzbmj;
        }

        public boolean zza(zzbmx com_google_android_gms_internal_zzbmx) {
            return (com_google_android_gms_internal_zzbmx.isVisible() || this.zzces) && !this.zzcet.contains(Long.valueOf(com_google_android_gms_internal_zzbmx.zzXC())) && (com_google_android_gms_internal_zzbmx.zzVc().zzi(this.zzceu) || this.zzceu.zzi(com_google_android_gms_internal_zzbmx.zzVc()));
        }

        public /* synthetic */ boolean zzaq(Object obj) {
            return zza((zzbmx) obj);
        }
    }

    /* renamed from: com.google.android.gms.internal.zzbna.2 */
    class C12492 implements zzbnt<zzbmx> {
        C12492() {
        }

        public boolean zza(zzbmx com_google_android_gms_internal_zzbmx) {
            return com_google_android_gms_internal_zzbmx.isVisible();
        }

        public /* synthetic */ boolean zzaq(Object obj) {
            return zza((zzbmx) obj);
        }
    }

    static {
        $assertionsDisabled = !zzbna.class.desiredAssertionStatus();
        zzcer = new C12492();
    }

    public zzbna() {
        this.zzceo = zzbma.zzWE();
        this.zzcep = new ArrayList();
        this.zzceq = Long.valueOf(-1);
    }

    private void zzXJ() {
        this.zzceo = zza(this.zzcep, zzcer, zzbmj.zzXf());
        if (this.zzcep.size() > 0) {
            this.zzceq = Long.valueOf(((zzbmx) this.zzcep.get(this.zzcep.size() - 1)).zzXC());
        } else {
            this.zzceq = Long.valueOf(-1);
        }
    }

    private static zzbma zza(List<zzbmx> list, zzbnt<zzbmx> com_google_android_gms_internal_zzbnt_com_google_android_gms_internal_zzbmx, zzbmj com_google_android_gms_internal_zzbmj) {
        zzbma zzWE = zzbma.zzWE();
        zzbma com_google_android_gms_internal_zzbma = zzWE;
        for (zzbmx com_google_android_gms_internal_zzbmx : list) {
            if (com_google_android_gms_internal_zzbnt_com_google_android_gms_internal_zzbmx.zzaq(com_google_android_gms_internal_zzbmx)) {
                zzbmj zzVc = com_google_android_gms_internal_zzbmx.zzVc();
                if (com_google_android_gms_internal_zzbmx.zzXF()) {
                    if (com_google_android_gms_internal_zzbmj.zzi(zzVc)) {
                        zzWE = com_google_android_gms_internal_zzbma.zze(zzbmj.zza(com_google_android_gms_internal_zzbmj, zzVc), com_google_android_gms_internal_zzbmx.zzXD());
                    } else if (zzVc.zzi(com_google_android_gms_internal_zzbmj)) {
                        zzWE = com_google_android_gms_internal_zzbma.zze(zzbmj.zzXf(), com_google_android_gms_internal_zzbmx.zzXD().zzO(zzbmj.zza(zzVc, com_google_android_gms_internal_zzbmj)));
                    }
                    com_google_android_gms_internal_zzbma = zzWE;
                } else {
                    if (com_google_android_gms_internal_zzbmj.zzi(zzVc)) {
                        zzWE = com_google_android_gms_internal_zzbma.zzb(zzbmj.zza(com_google_android_gms_internal_zzbmj, zzVc), com_google_android_gms_internal_zzbmx.zzXE());
                    } else if (zzVc.zzi(com_google_android_gms_internal_zzbmj)) {
                        zzVc = zzbmj.zza(zzVc, com_google_android_gms_internal_zzbmj);
                        if (zzVc.isEmpty()) {
                            zzWE = com_google_android_gms_internal_zzbma.zzb(zzbmj.zzXf(), com_google_android_gms_internal_zzbmx.zzXE());
                        } else {
                            zzbpe zzf = com_google_android_gms_internal_zzbmx.zzXE().zzf(zzVc);
                            if (zzf != null) {
                                zzWE = com_google_android_gms_internal_zzbma.zze(zzbmj.zzXf(), zzf);
                            }
                        }
                    }
                    com_google_android_gms_internal_zzbma = zzWE;
                }
            }
            zzWE = com_google_android_gms_internal_zzbma;
            com_google_android_gms_internal_zzbma = zzWE;
        }
        return com_google_android_gms_internal_zzbma;
    }

    private boolean zza(zzbmx com_google_android_gms_internal_zzbmx, zzbmj com_google_android_gms_internal_zzbmj) {
        if (com_google_android_gms_internal_zzbmx.zzXF()) {
            return com_google_android_gms_internal_zzbmx.zzVc().zzi(com_google_android_gms_internal_zzbmj);
        }
        Iterator it = com_google_android_gms_internal_zzbmx.zzXE().iterator();
        while (it.hasNext()) {
            if (com_google_android_gms_internal_zzbmx.zzVc().zzh((zzbmj) ((Entry) it.next()).getKey()).zzi(com_google_android_gms_internal_zzbmj)) {
                return true;
            }
        }
        return false;
    }

    public List<zzbmx> zzXI() {
        List arrayList = new ArrayList(this.zzcep);
        this.zzceo = zzbma.zzWE();
        this.zzcep = new ArrayList();
        return arrayList;
    }

    public zzbpd zza(zzbmj com_google_android_gms_internal_zzbmj, zzbpe com_google_android_gms_internal_zzbpe, zzbpd com_google_android_gms_internal_zzbpd, boolean z, zzboy com_google_android_gms_internal_zzboy) {
        zzbpd com_google_android_gms_internal_zzbpd2 = null;
        zzbma zzg = this.zzceo.zzg(com_google_android_gms_internal_zzbmj);
        zzbpe zzf = zzg.zzf(zzbmj.zzXf());
        if (zzf == null) {
            if (com_google_android_gms_internal_zzbpe != null) {
                zzf = zzg.zzb(com_google_android_gms_internal_zzbpe);
            }
            return com_google_android_gms_internal_zzbpd2;
        }
        for (zzbpd com_google_android_gms_internal_zzbpd3 : r0) {
            zzbpd com_google_android_gms_internal_zzbpd32;
            if (com_google_android_gms_internal_zzboy.zza(com_google_android_gms_internal_zzbpd32, com_google_android_gms_internal_zzbpd, z) <= 0 || (com_google_android_gms_internal_zzbpd2 != null && com_google_android_gms_internal_zzboy.zza(com_google_android_gms_internal_zzbpd32, com_google_android_gms_internal_zzbpd2, z) >= 0)) {
                com_google_android_gms_internal_zzbpd32 = com_google_android_gms_internal_zzbpd2;
            }
            com_google_android_gms_internal_zzbpd2 = com_google_android_gms_internal_zzbpd32;
        }
        return com_google_android_gms_internal_zzbpd2;
    }

    public zzbpe zza(zzbmj com_google_android_gms_internal_zzbmj, zzbmj com_google_android_gms_internal_zzbmj2, zzbpe com_google_android_gms_internal_zzbpe, zzbpe com_google_android_gms_internal_zzbpe2) {
        if (!$assertionsDisabled && com_google_android_gms_internal_zzbpe == null && com_google_android_gms_internal_zzbpe2 == null) {
            throw new AssertionError("Either existingEventSnap or existingServerSnap must exist");
        }
        zzbmj zzh = com_google_android_gms_internal_zzbmj.zzh(com_google_android_gms_internal_zzbmj2);
        if (this.zzceo.zze(zzh)) {
            return null;
        }
        zzbma zzg = this.zzceo.zzg(zzh);
        return zzg.isEmpty() ? com_google_android_gms_internal_zzbpe2.zzO(com_google_android_gms_internal_zzbmj2) : zzg.zzb(com_google_android_gms_internal_zzbpe2.zzO(com_google_android_gms_internal_zzbmj2));
    }

    public zzbpe zza(zzbmj com_google_android_gms_internal_zzbmj, zzbos com_google_android_gms_internal_zzbos, zzbnw com_google_android_gms_internal_zzbnw) {
        zzbmj zza = com_google_android_gms_internal_zzbmj.zza(com_google_android_gms_internal_zzbos);
        zzbpe zzf = this.zzceo.zzf(zza);
        return zzf != null ? zzf : com_google_android_gms_internal_zzbnw.zzf(com_google_android_gms_internal_zzbos) ? this.zzceo.zzg(zza).zzb(com_google_android_gms_internal_zzbnw.zzUY().zzm(com_google_android_gms_internal_zzbos)) : null;
    }

    public zzbpe zza(zzbmj com_google_android_gms_internal_zzbmj, zzbpe com_google_android_gms_internal_zzbpe, List<Long> list, boolean z) {
        zzbma zzg;
        if (!list.isEmpty() || z) {
            zzg = this.zzceo.zzg(com_google_android_gms_internal_zzbmj);
            if (!z && zzg.isEmpty()) {
                return com_google_android_gms_internal_zzbpe;
            }
            if (!z && com_google_android_gms_internal_zzbpe == null && !zzg.zze(zzbmj.zzXf())) {
                return null;
            }
            zzg = zza(this.zzcep, new C12481(this, z, list, com_google_android_gms_internal_zzbmj), com_google_android_gms_internal_zzbmj);
            if (com_google_android_gms_internal_zzbpe == null) {
                com_google_android_gms_internal_zzbpe = zzbox.zzZp();
            }
            return zzg.zzb(com_google_android_gms_internal_zzbpe);
        }
        zzbpe zzf = this.zzceo.zzf(com_google_android_gms_internal_zzbmj);
        if (zzf != null) {
            return zzf;
        }
        zzg = this.zzceo.zzg(com_google_android_gms_internal_zzbmj);
        if (zzg.isEmpty()) {
            return com_google_android_gms_internal_zzbpe;
        }
        if (com_google_android_gms_internal_zzbpe == null && !zzg.zze(zzbmj.zzXf())) {
            return null;
        }
        if (com_google_android_gms_internal_zzbpe == null) {
            com_google_android_gms_internal_zzbpe = zzbox.zzZp();
        }
        return zzg.zzb(com_google_android_gms_internal_zzbpe);
    }

    public void zza(zzbmj com_google_android_gms_internal_zzbmj, zzbma com_google_android_gms_internal_zzbma, Long l) {
        if ($assertionsDisabled || l.longValue() > this.zzceq.longValue()) {
            this.zzcep.add(new zzbmx(l.longValue(), com_google_android_gms_internal_zzbmj, com_google_android_gms_internal_zzbma));
            this.zzceo = this.zzceo.zzb(com_google_android_gms_internal_zzbmj, com_google_android_gms_internal_zzbma);
            this.zzceq = l;
            return;
        }
        throw new AssertionError();
    }

    public void zza(zzbmj com_google_android_gms_internal_zzbmj, zzbpe com_google_android_gms_internal_zzbpe, Long l, boolean z) {
        if ($assertionsDisabled || l.longValue() > this.zzceq.longValue()) {
            this.zzcep.add(new zzbmx(l.longValue(), com_google_android_gms_internal_zzbmj, com_google_android_gms_internal_zzbpe, z));
            if (z) {
                this.zzceo = this.zzceo.zze(com_google_android_gms_internal_zzbmj, com_google_android_gms_internal_zzbpe);
            }
            this.zzceq = l;
            return;
        }
        throw new AssertionError();
    }

    public zzbmx zzaL(long j) {
        for (zzbmx com_google_android_gms_internal_zzbmx : this.zzcep) {
            if (com_google_android_gms_internal_zzbmx.zzXC() == j) {
                return com_google_android_gms_internal_zzbmx;
            }
        }
        return null;
    }

    public boolean zzaM(long j) {
        zzbmx com_google_android_gms_internal_zzbmx;
        zzbmx com_google_android_gms_internal_zzbmx2 = null;
        int i = 0;
        for (zzbmx com_google_android_gms_internal_zzbmx3 : this.zzcep) {
            if (com_google_android_gms_internal_zzbmx3.zzXC() == j) {
                com_google_android_gms_internal_zzbmx2 = com_google_android_gms_internal_zzbmx3;
                break;
            }
            i++;
        }
        if ($assertionsDisabled || com_google_android_gms_internal_zzbmx2 != null) {
            this.zzcep.remove(com_google_android_gms_internal_zzbmx2);
            boolean isVisible = com_google_android_gms_internal_zzbmx2.isVisible();
            int size = this.zzcep.size() - 1;
            boolean z = false;
            while (isVisible && size >= 0) {
                boolean z2;
                com_google_android_gms_internal_zzbmx3 = (zzbmx) this.zzcep.get(size);
                if (com_google_android_gms_internal_zzbmx3.isVisible()) {
                    if (size >= i && zza(com_google_android_gms_internal_zzbmx3, com_google_android_gms_internal_zzbmx2.zzVc())) {
                        z2 = z;
                        z = false;
                        size--;
                        isVisible = z;
                        z = z2;
                    } else if (com_google_android_gms_internal_zzbmx2.zzVc().zzi(com_google_android_gms_internal_zzbmx3.zzVc())) {
                        z2 = true;
                        z = isVisible;
                        size--;
                        isVisible = z;
                        z = z2;
                    }
                }
                z2 = z;
                z = isVisible;
                size--;
                isVisible = z;
                z = z2;
            }
            if (!isVisible) {
                return false;
            }
            if (z) {
                zzXJ();
                return true;
            } else if (com_google_android_gms_internal_zzbmx2.zzXF()) {
                this.zzceo = this.zzceo.zzd(com_google_android_gms_internal_zzbmx2.zzVc());
                return true;
            } else {
                Iterator it = com_google_android_gms_internal_zzbmx2.zzXE().iterator();
                while (it.hasNext()) {
                    this.zzceo = this.zzceo.zzd(com_google_android_gms_internal_zzbmx2.zzVc().zzh((zzbmj) ((Entry) it.next()).getKey()));
                }
                return true;
            }
        }
        throw new AssertionError("removeWrite called with nonexistent writeId");
    }

    public zzbpe zzj(zzbmj com_google_android_gms_internal_zzbmj, zzbpe com_google_android_gms_internal_zzbpe) {
        zzbox zzZp = zzbox.zzZp();
        zzbpe<zzbpd> zzf = this.zzceo.zzf(com_google_android_gms_internal_zzbmj);
        zzbpe com_google_android_gms_internal_zzbpe2;
        if (zzf == null) {
            zzbma zzg = this.zzceo.zzg(com_google_android_gms_internal_zzbmj);
            com_google_android_gms_internal_zzbpe2 = zzZp;
            for (zzbpd com_google_android_gms_internal_zzbpd : com_google_android_gms_internal_zzbpe) {
                com_google_android_gms_internal_zzbpe2 = com_google_android_gms_internal_zzbpe2.zze(com_google_android_gms_internal_zzbpd.zzZz(), zzg.zzg(new zzbmj(com_google_android_gms_internal_zzbpd.zzZz())).zzb(com_google_android_gms_internal_zzbpd.zzUY()));
            }
            for (zzbpd com_google_android_gms_internal_zzbpd2 : zzg.zzWG()) {
                com_google_android_gms_internal_zzbpe2 = com_google_android_gms_internal_zzbpe2.zze(com_google_android_gms_internal_zzbpd2.zzZz(), com_google_android_gms_internal_zzbpd2.zzUY());
            }
            return com_google_android_gms_internal_zzbpe2;
        } else if (zzf.zzZd()) {
            return zzZp;
        } else {
            com_google_android_gms_internal_zzbpe2 = zzZp;
            for (zzbpd com_google_android_gms_internal_zzbpd22 : zzf) {
                com_google_android_gms_internal_zzbpe2 = com_google_android_gms_internal_zzbpe2.zze(com_google_android_gms_internal_zzbpd22.zzZz(), com_google_android_gms_internal_zzbpd22.zzUY());
            }
            return com_google_android_gms_internal_zzbpe2;
        }
    }

    public zzbnb zzu(zzbmj com_google_android_gms_internal_zzbmj) {
        return new zzbnb(com_google_android_gms_internal_zzbmj, this);
    }

    public zzbpe zzv(zzbmj com_google_android_gms_internal_zzbmj) {
        return this.zzceo.zzf(com_google_android_gms_internal_zzbmj);
    }
}
