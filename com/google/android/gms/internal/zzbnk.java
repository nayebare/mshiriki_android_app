package com.google.android.gms.internal;

import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.Callable;

public class zzbnk implements zzbnn {
    static final /* synthetic */ boolean $assertionsDisabled;
    private final zzbop zzbYx;
    private final zzbno zzceT;
    private final zzbnr zzceU;
    private final zzbnj zzceV;
    private long zzceW;

    static {
        $assertionsDisabled = !zzbnk.class.desiredAssertionStatus();
    }

    public zzbnk(zzbmc com_google_android_gms_internal_zzbmc, zzbno com_google_android_gms_internal_zzbno, zzbnj com_google_android_gms_internal_zzbnj) {
        this(com_google_android_gms_internal_zzbmc, com_google_android_gms_internal_zzbno, com_google_android_gms_internal_zzbnj, new zzbpz());
    }

    public zzbnk(zzbmc com_google_android_gms_internal_zzbmc, zzbno com_google_android_gms_internal_zzbno, zzbnj com_google_android_gms_internal_zzbnj, zzbpy com_google_android_gms_internal_zzbpy) {
        this.zzceW = 0;
        this.zzceT = com_google_android_gms_internal_zzbno;
        this.zzbYx = com_google_android_gms_internal_zzbmc.zziW("Persistence");
        this.zzceU = new zzbnr(this.zzceT, this.zzbYx, com_google_android_gms_internal_zzbpy);
        this.zzceV = com_google_android_gms_internal_zzbnj;
    }

    private void zzXX() {
        this.zzceW++;
        if (this.zzceV.zzaN(this.zzceW)) {
            if (this.zzbYx.zzYT()) {
                this.zzbYx.zzi("Reached prune check threshold.", new Object[0]);
            }
            this.zzceW = 0;
            int i = 1;
            long zzVf = this.zzceT.zzVf();
            if (this.zzbYx.zzYT()) {
                this.zzbYx.zzi("Cache size: " + zzVf, new Object[0]);
            }
            while (i != 0 && this.zzceV.zzi(r2, this.zzceU.zzYb())) {
                zzbnp zza = this.zzceU.zza(this.zzceV);
                if (zza.zzXY()) {
                    this.zzceT.zza(zzbmj.zzXf(), zza);
                } else {
                    i = 0;
                }
                zzVf = this.zzceT.zzVf();
                if (this.zzbYx.zzYT()) {
                    this.zzbYx.zzi("Cache size after prune: " + zzVf, new Object[0]);
                }
            }
        }
    }

    public List<zzbmx> zzVe() {
        return this.zzceT.zzVe();
    }

    public void zzVh() {
        this.zzceT.zzVh();
    }

    public void zza(zzbmj com_google_android_gms_internal_zzbmj, zzbma com_google_android_gms_internal_zzbma, long j) {
        this.zzceT.zza(com_google_android_gms_internal_zzbmj, com_google_android_gms_internal_zzbma, j);
    }

    public void zza(zzbmj com_google_android_gms_internal_zzbmj, zzbpe com_google_android_gms_internal_zzbpe, long j) {
        this.zzceT.zza(com_google_android_gms_internal_zzbmj, com_google_android_gms_internal_zzbpe, j);
    }

    public void zza(zzboe com_google_android_gms_internal_zzboe, zzbpe com_google_android_gms_internal_zzbpe) {
        if (com_google_android_gms_internal_zzboe.zzYD()) {
            this.zzceT.zza(com_google_android_gms_internal_zzboe.zzVc(), com_google_android_gms_internal_zzbpe);
        } else {
            this.zzceT.zzb(com_google_android_gms_internal_zzboe.zzVc(), com_google_android_gms_internal_zzbpe);
        }
        zzi(com_google_android_gms_internal_zzboe);
        zzXX();
    }

    public void zza(zzboe com_google_android_gms_internal_zzboe, Set<zzbos> set) {
        if ($assertionsDisabled || !com_google_android_gms_internal_zzboe.zzYD()) {
            zzbnq zzl = this.zzceU.zzl(com_google_android_gms_internal_zzboe);
            if ($assertionsDisabled || (zzl != null && zzl.zzcfh)) {
                this.zzceT.zza(zzl.id, (Set) set);
                return;
            }
            throw new AssertionError("We only expect tracked keys for currently-active queries.");
        }
        throw new AssertionError("We should only track keys for filtered queries.");
    }

    public void zza(zzboe com_google_android_gms_internal_zzboe, Set<zzbos> set, Set<zzbos> set2) {
        if ($assertionsDisabled || !com_google_android_gms_internal_zzboe.zzYD()) {
            zzbnq zzl = this.zzceU.zzl(com_google_android_gms_internal_zzboe);
            if ($assertionsDisabled || (zzl != null && zzl.zzcfh)) {
                this.zzceT.zza(zzl.id, (Set) set, (Set) set2);
                return;
            }
            throw new AssertionError("We only expect tracked keys for currently-active queries.");
        }
        throw new AssertionError("We should only track keys for filtered queries.");
    }

    public void zzaA(long j) {
        this.zzceT.zzaA(j);
    }

    public void zzc(zzbmj com_google_android_gms_internal_zzbmj, zzbma com_google_android_gms_internal_zzbma) {
        Iterator it = com_google_android_gms_internal_zzbma.iterator();
        while (it.hasNext()) {
            Entry entry = (Entry) it.next();
            zzk(com_google_android_gms_internal_zzbmj.zzh((zzbmj) entry.getKey()), (zzbpe) entry.getValue());
        }
    }

    public void zzd(zzbmj com_google_android_gms_internal_zzbmj, zzbma com_google_android_gms_internal_zzbma) {
        this.zzceT.zza(com_google_android_gms_internal_zzbmj, com_google_android_gms_internal_zzbma);
        zzXX();
    }

    public zzbnw zzf(zzboe com_google_android_gms_internal_zzboe) {
        boolean z;
        Set zzaD;
        if (this.zzceU.zzo(com_google_android_gms_internal_zzboe)) {
            zzbnq zzl = this.zzceU.zzl(com_google_android_gms_internal_zzboe);
            zzaD = (com_google_android_gms_internal_zzboe.zzYD() || zzl == null || !zzl.zzcfg) ? null : this.zzceT.zzaD(zzl.id);
            z = true;
        } else {
            zzaD = this.zzceU.zzB(com_google_android_gms_internal_zzboe.zzVc());
            z = false;
        }
        zzbpe zza = this.zzceT.zza(com_google_android_gms_internal_zzboe.zzVc());
        if (r0 == null) {
            return new zzbnw(zzboz.zza(zza, com_google_android_gms_internal_zzboe.zzYz()), true, false);
        }
        zzbpe zzZp = zzbox.zzZp();
        for (zzbos com_google_android_gms_internal_zzbos : r0) {
            zzZp = zzZp.zze(com_google_android_gms_internal_zzbos, zza.zzm(com_google_android_gms_internal_zzbos));
        }
        return new zzbnw(zzboz.zza(zzZp, com_google_android_gms_internal_zzboe.zzYz()), z, true);
    }

    public <T> T zzf(Callable<T> callable) {
        this.zzceT.beginTransaction();
        try {
            T call = callable.call();
            this.zzceT.setTransactionSuccessful();
            this.zzceT.endTransaction();
            return call;
        } catch (Throwable th) {
            this.zzceT.endTransaction();
        }
    }

    public void zzg(zzboe com_google_android_gms_internal_zzboe) {
        this.zzceU.zzg(com_google_android_gms_internal_zzboe);
    }

    public void zzh(zzboe com_google_android_gms_internal_zzboe) {
        this.zzceU.zzh(com_google_android_gms_internal_zzboe);
    }

    public void zzi(zzboe com_google_android_gms_internal_zzboe) {
        if (com_google_android_gms_internal_zzboe.zzYD()) {
            this.zzceU.zzA(com_google_android_gms_internal_zzboe.zzVc());
        } else {
            this.zzceU.zzn(com_google_android_gms_internal_zzboe);
        }
    }

    public void zzk(zzbmj com_google_android_gms_internal_zzbmj, zzbpe com_google_android_gms_internal_zzbpe) {
        if (!this.zzceU.zzD(com_google_android_gms_internal_zzbmj)) {
            this.zzceT.zza(com_google_android_gms_internal_zzbmj, com_google_android_gms_internal_zzbpe);
            this.zzceU.zzC(com_google_android_gms_internal_zzbmj);
        }
    }
}
