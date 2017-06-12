package com.google.android.gms.internal;

import com.google.android.gms.wallet.fragment.WalletFragmentStyle.Dimension;
import com.google.android.gms.wearable.ChannelApi.ChannelListener;
import com.google.android.gms.wearable.MessageApi;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class zzboh {
    static final /* synthetic */ boolean $assertionsDisabled;
    private static com.google.android.gms.internal.zzbol.zza zzcgs;
    private final zzbol zzcgr;

    /* renamed from: com.google.android.gms.internal.zzboh.1 */
    class C12671 implements com.google.android.gms.internal.zzbol.zza {
        C12671() {
        }

        public zzbpd zza(zzboy com_google_android_gms_internal_zzboy, zzbpd com_google_android_gms_internal_zzbpd, boolean z) {
            return null;
        }

        public zzbpe zzh(zzbos com_google_android_gms_internal_zzbos) {
            return null;
        }
    }

    /* renamed from: com.google.android.gms.internal.zzboh.2 */
    static /* synthetic */ class C12682 {
        static final /* synthetic */ int[] zzcgt;

        static {
            zzcgt = new int[com.google.android.gms.internal.zzbng.zza.values().length];
            try {
                zzcgt[com.google.android.gms.internal.zzbng.zza.Overwrite.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                zzcgt[com.google.android.gms.internal.zzbng.zza.Merge.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                zzcgt[com.google.android.gms.internal.zzbng.zza.AckUserWrite.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                zzcgt[com.google.android.gms.internal.zzbng.zza.ListenComplete.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
        }
    }

    public static class zza {
        public final zzbog zzcgk;
        public final List<zzbny> zzcgo;

        public zza(zzbog com_google_android_gms_internal_zzbog, List<zzbny> list) {
            this.zzcgk = com_google_android_gms_internal_zzbog;
            this.zzcgo = list;
        }
    }

    private static class zzb implements com.google.android.gms.internal.zzbol.zza {
        private final zzbog zzcgk;
        private final zzbnb zzcgu;
        private final zzbpe zzcgv;

        public zzb(zzbnb com_google_android_gms_internal_zzbnb, zzbog com_google_android_gms_internal_zzbog, zzbpe com_google_android_gms_internal_zzbpe) {
            this.zzcgu = com_google_android_gms_internal_zzbnb;
            this.zzcgk = com_google_android_gms_internal_zzbog;
            this.zzcgv = com_google_android_gms_internal_zzbpe;
        }

        public zzbpd zza(zzboy com_google_android_gms_internal_zzboy, zzbpd com_google_android_gms_internal_zzbpd, boolean z) {
            return this.zzcgu.zza(this.zzcgv != null ? this.zzcgv : this.zzcgk.zzYN(), com_google_android_gms_internal_zzbpd, z, com_google_android_gms_internal_zzboy);
        }

        public zzbpe zzh(zzbos com_google_android_gms_internal_zzbos) {
            zzbnw zzYK = this.zzcgk.zzYK();
            if (zzYK.zzf(com_google_android_gms_internal_zzbos)) {
                return zzYK.zzUY().zzm(com_google_android_gms_internal_zzbos);
            }
            return this.zzcgu.zza(com_google_android_gms_internal_zzbos, this.zzcgv != null ? new zzbnw(zzboz.zza(this.zzcgv, zzbpa.zzZw()), true, false) : this.zzcgk.zzYM());
        }
    }

    static {
        $assertionsDisabled = !zzboh.class.desiredAssertionStatus();
        zzcgs = new C12671();
    }

    public zzboh(zzbol com_google_android_gms_internal_zzbol) {
        this.zzcgr = com_google_android_gms_internal_zzbol;
    }

    private zzbog zza(zzbog com_google_android_gms_internal_zzbog, zzbmj com_google_android_gms_internal_zzbmj, zzbma com_google_android_gms_internal_zzbma, zzbnb com_google_android_gms_internal_zzbnb, zzbpe com_google_android_gms_internal_zzbpe, zzboi com_google_android_gms_internal_zzboi) {
        if ($assertionsDisabled || com_google_android_gms_internal_zzbma.zzWF() == null) {
            Entry entry;
            zzbmj zzh;
            Iterator it = com_google_android_gms_internal_zzbma.iterator();
            zzbog com_google_android_gms_internal_zzbog2 = com_google_android_gms_internal_zzbog;
            while (it.hasNext()) {
                entry = (Entry) it.next();
                zzh = com_google_android_gms_internal_zzbmj.zzh((zzbmj) entry.getKey());
                if (zza(com_google_android_gms_internal_zzbog, zzh.zzXi())) {
                    com_google_android_gms_internal_zzbog2 = zza(com_google_android_gms_internal_zzbog2, zzh, (zzbpe) entry.getValue(), com_google_android_gms_internal_zzbnb, com_google_android_gms_internal_zzbpe, com_google_android_gms_internal_zzboi);
                }
            }
            it = com_google_android_gms_internal_zzbma.iterator();
            while (it.hasNext()) {
                entry = (Entry) it.next();
                zzh = com_google_android_gms_internal_zzbmj.zzh((zzbmj) entry.getKey());
                if (!zza(com_google_android_gms_internal_zzbog, zzh.zzXi())) {
                    com_google_android_gms_internal_zzbog2 = zza(com_google_android_gms_internal_zzbog2, zzh, (zzbpe) entry.getValue(), com_google_android_gms_internal_zzbnb, com_google_android_gms_internal_zzbpe, com_google_android_gms_internal_zzboi);
                }
            }
            return com_google_android_gms_internal_zzbog2;
        }
        throw new AssertionError("Can't have a merge that is an overwrite");
    }

    private zzbog zza(zzbog com_google_android_gms_internal_zzbog, zzbmj com_google_android_gms_internal_zzbmj, zzbma com_google_android_gms_internal_zzbma, zzbnb com_google_android_gms_internal_zzbnb, zzbpe com_google_android_gms_internal_zzbpe, boolean z, zzboi com_google_android_gms_internal_zzboi) {
        if (com_google_android_gms_internal_zzbog.zzYM().zzUY().isEmpty() && !com_google_android_gms_internal_zzbog.zzYM().zzYg()) {
            return com_google_android_gms_internal_zzbog;
        }
        if ($assertionsDisabled || com_google_android_gms_internal_zzbma.zzWF() == null) {
            zzbos com_google_android_gms_internal_zzbos;
            if (!com_google_android_gms_internal_zzbmj.isEmpty()) {
                com_google_android_gms_internal_zzbma = zzbma.zzWE().zzb(com_google_android_gms_internal_zzbmj, com_google_android_gms_internal_zzbma);
            }
            zzbpe zzUY = com_google_android_gms_internal_zzbog.zzYM().zzUY();
            Map zzWH = com_google_android_gms_internal_zzbma.zzWH();
            zzbog com_google_android_gms_internal_zzbog2 = com_google_android_gms_internal_zzbog;
            for (Entry entry : zzWH.entrySet()) {
                com_google_android_gms_internal_zzbos = (zzbos) entry.getKey();
                if (zzUY.zzk(com_google_android_gms_internal_zzbos)) {
                    com_google_android_gms_internal_zzbog2 = zza(com_google_android_gms_internal_zzbog2, new zzbmj(com_google_android_gms_internal_zzbos), ((zzbma) entry.getValue()).zzb(zzUY.zzm(com_google_android_gms_internal_zzbos)), com_google_android_gms_internal_zzbnb, com_google_android_gms_internal_zzbpe, z, com_google_android_gms_internal_zzboi);
                }
            }
            for (Entry entry2 : zzWH.entrySet()) {
                com_google_android_gms_internal_zzbos = (zzbos) entry2.getKey();
                Object obj = (com_google_android_gms_internal_zzbog.zzYM().zzf(com_google_android_gms_internal_zzbos) || ((zzbma) entry2.getValue()).zzWF() != null) ? null : 1;
                if (!zzUY.zzk(com_google_android_gms_internal_zzbos) && obj == null) {
                    com_google_android_gms_internal_zzbog2 = zza(com_google_android_gms_internal_zzbog2, new zzbmj(com_google_android_gms_internal_zzbos), ((zzbma) entry2.getValue()).zzb(zzUY.zzm(com_google_android_gms_internal_zzbos)), com_google_android_gms_internal_zzbnb, com_google_android_gms_internal_zzbpe, z, com_google_android_gms_internal_zzboi);
                }
            }
            return com_google_android_gms_internal_zzbog2;
        }
        throw new AssertionError("Can't have a merge that is an overwrite");
    }

    private zzbog zza(zzbog com_google_android_gms_internal_zzbog, zzbmj com_google_android_gms_internal_zzbmj, zzbnb com_google_android_gms_internal_zzbnb, com.google.android.gms.internal.zzbol.zza com_google_android_gms_internal_zzbol_zza, zzboi com_google_android_gms_internal_zzboi) {
        zzbnw zzYK = com_google_android_gms_internal_zzbog.zzYK();
        if (com_google_android_gms_internal_zzbnb.zzv(com_google_android_gms_internal_zzbmj) != null) {
            return com_google_android_gms_internal_zzbog;
        }
        zzboz zza;
        zzbpe zza2;
        if (!com_google_android_gms_internal_zzbmj.isEmpty()) {
            zzbos zzXi = com_google_android_gms_internal_zzbmj.zzXi();
            if (!zzXi.zzZa()) {
                zzbpe zzl;
                zzbmj zzXj = com_google_android_gms_internal_zzbmj.zzXj();
                if (zzYK.zzf(zzXi)) {
                    zza2 = com_google_android_gms_internal_zzbnb.zza(com_google_android_gms_internal_zzbmj, zzYK.zzUY(), com_google_android_gms_internal_zzbog.zzYM().zzUY());
                    zzl = zza2 != null ? zzYK.zzUY().zzm(zzXi).zzl(zzXj, zza2) : zzYK.zzUY().zzm(zzXi);
                } else {
                    zzl = com_google_android_gms_internal_zzbnb.zza(zzXi, com_google_android_gms_internal_zzbog.zzYM());
                }
                zza = zzl != null ? this.zzcgr.zza(zzYK.zzYi(), zzXi, zzl, zzXj, com_google_android_gms_internal_zzbol_zza, com_google_android_gms_internal_zzboi) : zzYK.zzYi();
            } else if ($assertionsDisabled || com_google_android_gms_internal_zzbmj.size() == 1) {
                zza2 = com_google_android_gms_internal_zzbnb.zza(com_google_android_gms_internal_zzbmj, zzYK.zzUY(), com_google_android_gms_internal_zzbog.zzYM().zzUY());
                zza = zza2 != null ? this.zzcgr.zza(zzYK.zzYi(), zza2) : zzYK.zzYi();
            } else {
                throw new AssertionError("Can't have a priority with additional path components");
            }
        } else if ($assertionsDisabled || com_google_android_gms_internal_zzbog.zzYM().zzYg()) {
            if (com_google_android_gms_internal_zzbog.zzYM().zzYh()) {
                zza2 = com_google_android_gms_internal_zzbog.zzYN();
                if (!(zza2 instanceof zzbot)) {
                    zza2 = zzbox.zzZp();
                }
                zza2 = com_google_android_gms_internal_zzbnb.zzd(zza2);
            } else {
                zza2 = com_google_android_gms_internal_zzbnb.zzc(com_google_android_gms_internal_zzbog.zzYN());
            }
            zza = this.zzcgr.zza(com_google_android_gms_internal_zzbog.zzYK().zzYi(), zzboz.zza(zza2, this.zzcgr.zzYz()), com_google_android_gms_internal_zzboi);
        } else {
            throw new AssertionError("If change path is empty, we must have complete server data");
        }
        boolean z = zzYK.zzYg() || com_google_android_gms_internal_zzbmj.isEmpty();
        return com_google_android_gms_internal_zzbog.zza(zza, z, this.zzcgr.zzYQ());
    }

    private zzbog zza(zzbog com_google_android_gms_internal_zzbog, zzbmj com_google_android_gms_internal_zzbmj, zzbns<Boolean> com_google_android_gms_internal_zzbns_java_lang_Boolean, zzbnb com_google_android_gms_internal_zzbnb, zzbpe com_google_android_gms_internal_zzbpe, zzboi com_google_android_gms_internal_zzboi) {
        if (com_google_android_gms_internal_zzbnb.zzv(com_google_android_gms_internal_zzbmj) != null) {
            return com_google_android_gms_internal_zzbog;
        }
        boolean zzYh = com_google_android_gms_internal_zzbog.zzYM().zzYh();
        zzbnw zzYM = com_google_android_gms_internal_zzbog.zzYM();
        zzbma zzWE;
        if (com_google_android_gms_internal_zzbns_java_lang_Boolean.getValue() == null) {
            zzWE = zzbma.zzWE();
            Iterator it = com_google_android_gms_internal_zzbns_java_lang_Boolean.iterator();
            while (it.hasNext()) {
                zzbmj com_google_android_gms_internal_zzbmj2 = (zzbmj) ((Entry) it.next()).getKey();
                zzbmj zzh = com_google_android_gms_internal_zzbmj.zzh(com_google_android_gms_internal_zzbmj2);
                if (zzYM.zzM(zzh)) {
                    zzWE = zzWE.zze(com_google_android_gms_internal_zzbmj2, zzYM.zzUY().zzO(zzh));
                }
            }
            return zza(com_google_android_gms_internal_zzbog, com_google_android_gms_internal_zzbmj, zzWE, com_google_android_gms_internal_zzbnb, com_google_android_gms_internal_zzbpe, zzYh, com_google_android_gms_internal_zzboi);
        } else if ((com_google_android_gms_internal_zzbmj.isEmpty() && zzYM.zzYg()) || zzYM.zzM(com_google_android_gms_internal_zzbmj)) {
            return zza(com_google_android_gms_internal_zzbog, com_google_android_gms_internal_zzbmj, zzYM.zzUY().zzO(com_google_android_gms_internal_zzbmj), com_google_android_gms_internal_zzbnb, com_google_android_gms_internal_zzbpe, zzYh, com_google_android_gms_internal_zzboi);
        } else if (!com_google_android_gms_internal_zzbmj.isEmpty()) {
            return com_google_android_gms_internal_zzbog;
        } else {
            zzWE = zzbma.zzWE();
            for (zzbpd com_google_android_gms_internal_zzbpd : zzYM.zzUY()) {
                zzWE = zzWE.zza(com_google_android_gms_internal_zzbpd.zzZz(), com_google_android_gms_internal_zzbpd.zzUY());
            }
            return zza(com_google_android_gms_internal_zzbog, com_google_android_gms_internal_zzbmj, zzWE, com_google_android_gms_internal_zzbnb, com_google_android_gms_internal_zzbpe, zzYh, com_google_android_gms_internal_zzboi);
        }
    }

    private zzbog zza(zzbog com_google_android_gms_internal_zzbog, zzbmj com_google_android_gms_internal_zzbmj, zzbpe com_google_android_gms_internal_zzbpe, zzbnb com_google_android_gms_internal_zzbnb, zzbpe com_google_android_gms_internal_zzbpe2, zzboi com_google_android_gms_internal_zzboi) {
        zzbnw zzYK = com_google_android_gms_internal_zzbog.zzYK();
        com.google.android.gms.internal.zzbol.zza com_google_android_gms_internal_zzboh_zzb = new zzb(com_google_android_gms_internal_zzbnb, com_google_android_gms_internal_zzbog, com_google_android_gms_internal_zzbpe2);
        if (com_google_android_gms_internal_zzbmj.isEmpty()) {
            return com_google_android_gms_internal_zzbog.zza(this.zzcgr.zza(com_google_android_gms_internal_zzbog.zzYK().zzYi(), zzboz.zza(com_google_android_gms_internal_zzbpe, this.zzcgr.zzYz()), com_google_android_gms_internal_zzboi), true, this.zzcgr.zzYQ());
        }
        zzbos zzXi = com_google_android_gms_internal_zzbmj.zzXi();
        if (zzXi.zzZa()) {
            return com_google_android_gms_internal_zzbog.zza(this.zzcgr.zza(com_google_android_gms_internal_zzbog.zzYK().zzYi(), com_google_android_gms_internal_zzbpe), zzYK.zzYg(), zzYK.zzYh());
        }
        zzbpe com_google_android_gms_internal_zzbpe3;
        zzbmj zzXj = com_google_android_gms_internal_zzbmj.zzXj();
        zzbpe zzm = zzYK.zzUY().zzm(zzXi);
        if (zzXj.isEmpty()) {
            com_google_android_gms_internal_zzbpe3 = com_google_android_gms_internal_zzbpe;
        } else {
            com_google_android_gms_internal_zzbpe3 = com_google_android_gms_internal_zzboh_zzb.zzh(zzXi);
            if (com_google_android_gms_internal_zzbpe3 == null) {
                com_google_android_gms_internal_zzbpe3 = zzbox.zzZp();
            } else if (!(zzXj.zzXl().zzZa() && com_google_android_gms_internal_zzbpe3.zzO(zzXj.zzXk()).isEmpty())) {
                com_google_android_gms_internal_zzbpe3 = com_google_android_gms_internal_zzbpe3.zzl(zzXj, com_google_android_gms_internal_zzbpe);
            }
        }
        return !zzm.equals(com_google_android_gms_internal_zzbpe3) ? com_google_android_gms_internal_zzbog.zza(this.zzcgr.zza(zzYK.zzYi(), zzXi, com_google_android_gms_internal_zzbpe3, zzXj, com_google_android_gms_internal_zzboh_zzb, com_google_android_gms_internal_zzboi), zzYK.zzYg(), this.zzcgr.zzYQ()) : com_google_android_gms_internal_zzbog;
    }

    private zzbog zza(zzbog com_google_android_gms_internal_zzbog, zzbmj com_google_android_gms_internal_zzbmj, zzbpe com_google_android_gms_internal_zzbpe, zzbnb com_google_android_gms_internal_zzbnb, zzbpe com_google_android_gms_internal_zzbpe2, boolean z, zzboi com_google_android_gms_internal_zzboi) {
        zzboz zza;
        zzbnw zzYM = com_google_android_gms_internal_zzbog.zzYM();
        zzbol zzYP = z ? this.zzcgr : this.zzcgr.zzYP();
        if (com_google_android_gms_internal_zzbmj.isEmpty()) {
            zza = zzYP.zza(zzYM.zzYi(), zzboz.zza(com_google_android_gms_internal_zzbpe, zzYP.zzYz()), null);
        } else if (!zzYP.zzYQ() || zzYM.zzYh()) {
            zzbos zzXi = com_google_android_gms_internal_zzbmj.zzXi();
            if (!zzYM.zzM(com_google_android_gms_internal_zzbmj) && com_google_android_gms_internal_zzbmj.size() > 1) {
                return com_google_android_gms_internal_zzbog;
            }
            zzbmj zzXj = com_google_android_gms_internal_zzbmj.zzXj();
            zzbpe zzl = zzYM.zzUY().zzm(zzXi).zzl(zzXj, com_google_android_gms_internal_zzbpe);
            zza = zzXi.zzZa() ? zzYP.zza(zzYM.zzYi(), zzl) : zzYP.zza(zzYM.zzYi(), zzXi, zzl, zzXj, zzcgs, null);
        } else if ($assertionsDisabled || !com_google_android_gms_internal_zzbmj.isEmpty()) {
            zzbos zzXi2 = com_google_android_gms_internal_zzbmj.zzXi();
            zza = zzYP.zza(zzYM.zzYi(), zzYM.zzYi().zzh(zzXi2, zzYM.zzUY().zzm(zzXi2).zzl(com_google_android_gms_internal_zzbmj.zzXj(), com_google_android_gms_internal_zzbpe)), null);
        } else {
            throw new AssertionError("An empty path should have been caught in the other branch");
        }
        boolean z2 = zzYM.zzYg() || com_google_android_gms_internal_zzbmj.isEmpty();
        zzbog zzb = com_google_android_gms_internal_zzbog.zzb(zza, z2, zzYP.zzYQ());
        return zza(zzb, com_google_android_gms_internal_zzbmj, com_google_android_gms_internal_zzbnb, new zzb(com_google_android_gms_internal_zzbnb, zzb, com_google_android_gms_internal_zzbpe2), com_google_android_gms_internal_zzboi);
    }

    private void zza(zzbog com_google_android_gms_internal_zzbog, zzbog com_google_android_gms_internal_zzbog2, List<zzbny> list) {
        zzbnw zzYK = com_google_android_gms_internal_zzbog2.zzYK();
        if (zzYK.zzYg()) {
            Object obj = (zzYK.zzUY().zzZd() || zzYK.zzUY().isEmpty()) ? 1 : null;
            if (!list.isEmpty() || !com_google_android_gms_internal_zzbog.zzYK().zzYg() || ((obj != null && !zzYK.zzUY().equals(com_google_android_gms_internal_zzbog.zzYL())) || !zzYK.zzUY().zzZe().equals(com_google_android_gms_internal_zzbog.zzYL().zzZe()))) {
                list.add(zzbny.zza(zzYK.zzYi()));
            }
        }
    }

    private static boolean zza(zzbog com_google_android_gms_internal_zzbog, zzbos com_google_android_gms_internal_zzbos) {
        return com_google_android_gms_internal_zzbog.zzYK().zzf(com_google_android_gms_internal_zzbos);
    }

    private zzbog zzb(zzbog com_google_android_gms_internal_zzbog, zzbmj com_google_android_gms_internal_zzbmj, zzbnb com_google_android_gms_internal_zzbnb, zzbpe com_google_android_gms_internal_zzbpe, zzboi com_google_android_gms_internal_zzboi) {
        zzbnw zzYM = com_google_android_gms_internal_zzbog.zzYM();
        zzboz zzYi = zzYM.zzYi();
        boolean z = zzYM.zzYg() || com_google_android_gms_internal_zzbmj.isEmpty();
        return zza(com_google_android_gms_internal_zzbog.zzb(zzYi, z, zzYM.zzYh()), com_google_android_gms_internal_zzbmj, com_google_android_gms_internal_zzbnb, zzcgs, com_google_android_gms_internal_zzboi);
    }

    public zzbog zza(zzbog com_google_android_gms_internal_zzbog, zzbmj com_google_android_gms_internal_zzbmj, zzbnb com_google_android_gms_internal_zzbnb, zzbpe com_google_android_gms_internal_zzbpe, zzboi com_google_android_gms_internal_zzboi) {
        if (com_google_android_gms_internal_zzbnb.zzv(com_google_android_gms_internal_zzbmj) != null) {
            return com_google_android_gms_internal_zzbog;
        }
        com.google.android.gms.internal.zzbol.zza com_google_android_gms_internal_zzboh_zzb = new zzb(com_google_android_gms_internal_zzbnb, com_google_android_gms_internal_zzbog, com_google_android_gms_internal_zzbpe);
        zzboz zzYi = com_google_android_gms_internal_zzbog.zzYK().zzYi();
        if (com_google_android_gms_internal_zzbmj.isEmpty() || com_google_android_gms_internal_zzbmj.zzXi().zzZa()) {
            zzYi = this.zzcgr.zza(zzYi, zzboz.zza(com_google_android_gms_internal_zzbog.zzYM().zzYg() ? com_google_android_gms_internal_zzbnb.zzc(com_google_android_gms_internal_zzbog.zzYN()) : com_google_android_gms_internal_zzbnb.zzd(com_google_android_gms_internal_zzbog.zzYM().zzUY()), this.zzcgr.zzYz()), com_google_android_gms_internal_zzboi);
        } else {
            zzbos zzXi = com_google_android_gms_internal_zzbmj.zzXi();
            zzbpe zza = com_google_android_gms_internal_zzbnb.zza(zzXi, com_google_android_gms_internal_zzbog.zzYM());
            if (zza == null && com_google_android_gms_internal_zzbog.zzYM().zzf(zzXi)) {
                zza = zzYi.zzUY().zzm(zzXi);
            }
            if (zza != null) {
                zzYi = this.zzcgr.zza(zzYi, zzXi, zza, com_google_android_gms_internal_zzbmj.zzXj(), com_google_android_gms_internal_zzboh_zzb, com_google_android_gms_internal_zzboi);
            } else if (zza == null && com_google_android_gms_internal_zzbog.zzYK().zzUY().zzk(zzXi)) {
                zzYi = this.zzcgr.zza(zzYi, zzXi, zzbox.zzZp(), com_google_android_gms_internal_zzbmj.zzXj(), com_google_android_gms_internal_zzboh_zzb, com_google_android_gms_internal_zzboi);
            }
            if (zzYi.zzUY().isEmpty() && com_google_android_gms_internal_zzbog.zzYM().zzYg()) {
                zzbpe zzc = com_google_android_gms_internal_zzbnb.zzc(com_google_android_gms_internal_zzbog.zzYN());
                if (zzc.zzZd()) {
                    zzYi = this.zzcgr.zza(zzYi, zzboz.zza(zzc, this.zzcgr.zzYz()), com_google_android_gms_internal_zzboi);
                }
            }
        }
        boolean z = com_google_android_gms_internal_zzbog.zzYM().zzYg() || com_google_android_gms_internal_zzbnb.zzv(zzbmj.zzXf()) != null;
        return com_google_android_gms_internal_zzbog.zza(zzYi, z, this.zzcgr.zzYQ());
    }

    public zza zza(zzbog com_google_android_gms_internal_zzbog, zzbng com_google_android_gms_internal_zzbng, zzbnb com_google_android_gms_internal_zzbnb, zzbpe com_google_android_gms_internal_zzbpe) {
        zzbog zza;
        zzboi com_google_android_gms_internal_zzboi = new zzboi();
        boolean z;
        switch (C12682.zzcgt[com_google_android_gms_internal_zzbng.zzXP().ordinal()]) {
            case MessageApi.FILTER_PREFIX /*1*/:
                zzbni com_google_android_gms_internal_zzbni = (zzbni) com_google_android_gms_internal_zzbng;
                if (com_google_android_gms_internal_zzbni.zzXO().zzXQ()) {
                    zza = zza(com_google_android_gms_internal_zzbog, com_google_android_gms_internal_zzbni.zzVc(), com_google_android_gms_internal_zzbni.zzXU(), com_google_android_gms_internal_zzbnb, com_google_android_gms_internal_zzbpe, com_google_android_gms_internal_zzboi);
                    break;
                } else if ($assertionsDisabled || com_google_android_gms_internal_zzbni.zzXO().zzXR()) {
                    z = com_google_android_gms_internal_zzbni.zzXO().zzXS() || (com_google_android_gms_internal_zzbog.zzYM().zzYh() && !com_google_android_gms_internal_zzbni.zzVc().isEmpty());
                    zza = zza(com_google_android_gms_internal_zzbog, com_google_android_gms_internal_zzbni.zzVc(), com_google_android_gms_internal_zzbni.zzXU(), com_google_android_gms_internal_zzbnb, com_google_android_gms_internal_zzbpe, z, com_google_android_gms_internal_zzboi);
                    break;
                } else {
                    throw new AssertionError();
                }
                break;
            case ChannelListener.CLOSE_REASON_REMOTE_CLOSE /*2*/:
                zzbnf com_google_android_gms_internal_zzbnf = (zzbnf) com_google_android_gms_internal_zzbng;
                if (com_google_android_gms_internal_zzbnf.zzXO().zzXQ()) {
                    zza = zza(com_google_android_gms_internal_zzbog, com_google_android_gms_internal_zzbnf.zzVc(), com_google_android_gms_internal_zzbnf.zzXN(), com_google_android_gms_internal_zzbnb, com_google_android_gms_internal_zzbpe, com_google_android_gms_internal_zzboi);
                    break;
                } else if ($assertionsDisabled || com_google_android_gms_internal_zzbnf.zzXO().zzXR()) {
                    z = com_google_android_gms_internal_zzbnf.zzXO().zzXS() || com_google_android_gms_internal_zzbog.zzYM().zzYh();
                    zza = zza(com_google_android_gms_internal_zzbog, com_google_android_gms_internal_zzbnf.zzVc(), com_google_android_gms_internal_zzbnf.zzXN(), com_google_android_gms_internal_zzbnb, com_google_android_gms_internal_zzbpe, z, com_google_android_gms_internal_zzboi);
                    break;
                } else {
                    throw new AssertionError();
                }
                break;
            case ChannelListener.CLOSE_REASON_LOCAL_CLOSE /*3*/:
                zzbnd com_google_android_gms_internal_zzbnd = (zzbnd) com_google_android_gms_internal_zzbng;
                if (!com_google_android_gms_internal_zzbnd.zzXM()) {
                    zza = zza(com_google_android_gms_internal_zzbog, com_google_android_gms_internal_zzbnd.zzVc(), com_google_android_gms_internal_zzbnd.zzXL(), com_google_android_gms_internal_zzbnb, com_google_android_gms_internal_zzbpe, com_google_android_gms_internal_zzboi);
                    break;
                }
                zza = zza(com_google_android_gms_internal_zzbog, com_google_android_gms_internal_zzbnd.zzVc(), com_google_android_gms_internal_zzbnb, com_google_android_gms_internal_zzbpe, com_google_android_gms_internal_zzboi);
                break;
            case Dimension.UNIT_IN /*4*/:
                zza = zzb(com_google_android_gms_internal_zzbog, com_google_android_gms_internal_zzbng.zzVc(), com_google_android_gms_internal_zzbnb, com_google_android_gms_internal_zzbpe, com_google_android_gms_internal_zzboi);
                break;
            default:
                String valueOf = String.valueOf(com_google_android_gms_internal_zzbng.zzXP());
                throw new AssertionError(new StringBuilder(String.valueOf(valueOf).length() + 19).append("Unknown operation: ").append(valueOf).toString());
        }
        List arrayList = new ArrayList(com_google_android_gms_internal_zzboi.zzYO());
        zza(com_google_android_gms_internal_zzbog, zza, arrayList);
        return new zza(zza, arrayList);
    }
}
