package com.google.android.gms.internal;

import com.google.android.gms.cast.TextTrackStyle;
import com.google.android.gms.internal.zzbns.zza;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class zzbnr {
    static final /* synthetic */ boolean $assertionsDisabled;
    private static final zzbnt<Map<zzbod, zzbnq>> zzcfi;
    private static final zzbnt<Map<zzbod, zzbnq>> zzcfj;
    private static final zzbnt<zzbnq> zzcfk;
    private static final zzbnt<zzbnq> zzcfl;
    private final zzbop zzbYx;
    private final zzbno zzceT;
    private zzbns<Map<zzbod, zzbnq>> zzcfm;
    private final zzbpy zzcfn;
    private long zzcfo;

    /* renamed from: com.google.android.gms.internal.zzbnr.1 */
    class C12541 implements zzbnt<Map<zzbod, zzbnq>> {
        C12541() {
        }

        public boolean zzaC(Map<zzbod, zzbnq> map) {
            zzbnq com_google_android_gms_internal_zzbnq = (zzbnq) map.get(zzbod.zzcfX);
            return com_google_android_gms_internal_zzbnq != null && com_google_android_gms_internal_zzbnq.zzcfg;
        }

        public /* synthetic */ boolean zzaq(Object obj) {
            return zzaC((Map) obj);
        }
    }

    /* renamed from: com.google.android.gms.internal.zzbnr.2 */
    class C12552 implements zzbnt<Map<zzbod, zzbnq>> {
        C12552() {
        }

        public boolean zzaC(Map<zzbod, zzbnq> map) {
            zzbnq com_google_android_gms_internal_zzbnq = (zzbnq) map.get(zzbod.zzcfX);
            return com_google_android_gms_internal_zzbnq != null && com_google_android_gms_internal_zzbnq.zzcfh;
        }

        public /* synthetic */ boolean zzaq(Object obj) {
            return zzaC((Map) obj);
        }
    }

    /* renamed from: com.google.android.gms.internal.zzbnr.3 */
    class C12563 implements zzbnt<zzbnq> {
        C12563() {
        }

        public /* synthetic */ boolean zzaq(Object obj) {
            return zzc((zzbnq) obj);
        }

        public boolean zzc(zzbnq com_google_android_gms_internal_zzbnq) {
            return !com_google_android_gms_internal_zzbnq.zzcfh;
        }
    }

    /* renamed from: com.google.android.gms.internal.zzbnr.4 */
    class C12574 implements zzbnt<zzbnq> {
        C12574() {
        }

        public /* synthetic */ boolean zzaq(Object obj) {
            return zzc((zzbnq) obj);
        }

        public boolean zzc(zzbnq com_google_android_gms_internal_zzbnq) {
            return !zzbnr.zzcfk.zzaq(com_google_android_gms_internal_zzbnq);
        }
    }

    /* renamed from: com.google.android.gms.internal.zzbnr.5 */
    class C12585 implements zza<Map<zzbod, zzbnq>, Void> {
        final /* synthetic */ zzbnr zzcfp;

        C12585(zzbnr com_google_android_gms_internal_zzbnr) {
            this.zzcfp = com_google_android_gms_internal_zzbnr;
        }

        public Void zza(zzbmj com_google_android_gms_internal_zzbmj, Map<zzbod, zzbnq> map, Void voidR) {
            for (Entry value : map.entrySet()) {
                zzbnq com_google_android_gms_internal_zzbnq = (zzbnq) value.getValue();
                if (!com_google_android_gms_internal_zzbnq.zzcfg) {
                    this.zzcfp.zza(com_google_android_gms_internal_zzbnq.zzXZ());
                }
            }
            return null;
        }
    }

    /* renamed from: com.google.android.gms.internal.zzbnr.6 */
    class C12596 implements Comparator<zzbnq> {
        C12596(zzbnr com_google_android_gms_internal_zzbnr) {
        }

        public /* synthetic */ int compare(Object obj, Object obj2) {
            return zza((zzbnq) obj, (zzbnq) obj2);
        }

        public int zza(zzbnq com_google_android_gms_internal_zzbnq, zzbnq com_google_android_gms_internal_zzbnq2) {
            return zzbqg.zzj(com_google_android_gms_internal_zzbnq.zzcff, com_google_android_gms_internal_zzbnq2.zzcff);
        }
    }

    static {
        $assertionsDisabled = !zzbnr.class.desiredAssertionStatus();
        zzcfi = new C12541();
        zzcfj = new C12552();
        zzcfk = new C12563();
        zzcfl = new C12574();
    }

    public zzbnr(zzbno com_google_android_gms_internal_zzbno, zzbop com_google_android_gms_internal_zzbop, zzbpy com_google_android_gms_internal_zzbpy) {
        this.zzcfo = 0;
        this.zzceT = com_google_android_gms_internal_zzbno;
        this.zzbYx = com_google_android_gms_internal_zzbop;
        this.zzcfn = com_google_android_gms_internal_zzbpy;
        this.zzcfm = new zzbns(null);
        zzYa();
        for (zzbnq com_google_android_gms_internal_zzbnq : this.zzceT.zzVg()) {
            this.zzcfo = Math.max(com_google_android_gms_internal_zzbnq.id + 1, this.zzcfo);
            zzb(com_google_android_gms_internal_zzbnq);
        }
    }

    private boolean zzE(zzbmj com_google_android_gms_internal_zzbmj) {
        return this.zzcfm.zza(com_google_android_gms_internal_zzbmj, zzcfi) != null;
    }

    private Set<Long> zzF(zzbmj com_google_android_gms_internal_zzbmj) {
        Set<Long> hashSet = new HashSet();
        Map map = (Map) this.zzcfm.zzK(com_google_android_gms_internal_zzbmj);
        if (map != null) {
            for (zzbnq com_google_android_gms_internal_zzbnq : map.values()) {
                if (!com_google_android_gms_internal_zzbnq.zzcfe.zzYD()) {
                    hashSet.add(Long.valueOf(com_google_android_gms_internal_zzbnq.id));
                }
            }
        }
        return hashSet;
    }

    private void zzYa() {
        try {
            this.zzceT.beginTransaction();
            this.zzceT.zzaC(this.zzcfn.zzZY());
            this.zzceT.setTransactionSuccessful();
        } finally {
            this.zzceT.endTransaction();
        }
    }

    private static long zza(zzbnj com_google_android_gms_internal_zzbnj, long j) {
        return j - Math.min((long) Math.floor((double) ((TextTrackStyle.DEFAULT_FONT_SCALE - com_google_android_gms_internal_zzbnj.zzXV()) * ((float) j))), com_google_android_gms_internal_zzbnj.zzXW());
    }

    private List<zzbnq> zza(zzbnt<zzbnq> com_google_android_gms_internal_zzbnt_com_google_android_gms_internal_zzbnq) {
        List<zzbnq> arrayList = new ArrayList();
        Iterator it = this.zzcfm.iterator();
        while (it.hasNext()) {
            for (zzbnq com_google_android_gms_internal_zzbnq : ((Map) ((Entry) it.next()).getValue()).values()) {
                if (com_google_android_gms_internal_zzbnt_com_google_android_gms_internal_zzbnq.zzaq(com_google_android_gms_internal_zzbnq)) {
                    arrayList.add(com_google_android_gms_internal_zzbnq);
                }
            }
        }
        return arrayList;
    }

    private void zza(zzbnq com_google_android_gms_internal_zzbnq) {
        zzb(com_google_android_gms_internal_zzbnq);
        this.zzceT.zza(com_google_android_gms_internal_zzbnq);
    }

    private void zzb(zzbnq com_google_android_gms_internal_zzbnq) {
        Map map;
        zzj(com_google_android_gms_internal_zzbnq.zzcfe);
        Map map2 = (Map) this.zzcfm.zzK(com_google_android_gms_internal_zzbnq.zzcfe.zzVc());
        if (map2 == null) {
            map2 = new HashMap();
            this.zzcfm = this.zzcfm.zzb(com_google_android_gms_internal_zzbnq.zzcfe.zzVc(), (Object) map2);
            map = map2;
        } else {
            map = map2;
        }
        zzbnq com_google_android_gms_internal_zzbnq2 = (zzbnq) map.get(com_google_android_gms_internal_zzbnq.zzcfe.zzYG());
        boolean z = com_google_android_gms_internal_zzbnq2 == null || com_google_android_gms_internal_zzbnq2.id == com_google_android_gms_internal_zzbnq.id;
        zzbqg.zzaW(z);
        map.put(com_google_android_gms_internal_zzbnq.zzcfe.zzYG(), com_google_android_gms_internal_zzbnq);
    }

    private void zzb(zzboe com_google_android_gms_internal_zzboe, boolean z) {
        zzboe zzk = zzk(com_google_android_gms_internal_zzboe);
        zzbnq zzl = zzl(zzk);
        long zzZY = this.zzcfn.zzZY();
        if (zzl != null) {
            zzl = zzl.zzaO(zzZY).zzbb(z);
        } else if ($assertionsDisabled || z) {
            long j = this.zzcfo;
            this.zzcfo = 1 + j;
            zzl = new zzbnq(j, zzk, zzZY, false, z);
        } else {
            throw new AssertionError("If we're setting the query to inactive, we should already be tracking it!");
        }
        zza(zzl);
    }

    private static void zzj(zzboe com_google_android_gms_internal_zzboe) {
        boolean z = !com_google_android_gms_internal_zzboe.zzYD() || com_google_android_gms_internal_zzboe.isDefault();
        zzbqg.zzb(z, "Can't have tracked non-default query that loads all data");
    }

    private static zzboe zzk(zzboe com_google_android_gms_internal_zzboe) {
        return com_google_android_gms_internal_zzboe.zzYD() ? zzboe.zzN(com_google_android_gms_internal_zzboe.zzVc()) : com_google_android_gms_internal_zzboe;
    }

    public void zzA(zzbmj com_google_android_gms_internal_zzbmj) {
        this.zzcfm.zzI(com_google_android_gms_internal_zzbmj).zza(new C12585(this));
    }

    public Set<zzbos> zzB(zzbmj com_google_android_gms_internal_zzbmj) {
        if ($assertionsDisabled || !zzo(zzboe.zzN(com_google_android_gms_internal_zzbmj))) {
            Set<zzbos> hashSet = new HashSet();
            Set zzF = zzF(com_google_android_gms_internal_zzbmj);
            if (!zzF.isEmpty()) {
                hashSet.addAll(this.zzceT.zzg(zzF));
            }
            Iterator it = this.zzcfm.zzI(com_google_android_gms_internal_zzbmj).zzYe().iterator();
            while (it.hasNext()) {
                Entry entry = (Entry) it.next();
                zzbos com_google_android_gms_internal_zzbos = (zzbos) entry.getKey();
                zzbns com_google_android_gms_internal_zzbns = (zzbns) entry.getValue();
                if (com_google_android_gms_internal_zzbns.getValue() != null && zzcfi.zzaq((Map) com_google_android_gms_internal_zzbns.getValue())) {
                    hashSet.add(com_google_android_gms_internal_zzbos);
                }
            }
            return hashSet;
        }
        throw new AssertionError("Path is fully complete.");
    }

    public void zzC(zzbmj com_google_android_gms_internal_zzbmj) {
        if (!zzE(com_google_android_gms_internal_zzbmj)) {
            zzboe zzN = zzboe.zzN(com_google_android_gms_internal_zzbmj);
            zzbnq zzl = zzl(zzN);
            if (zzl == null) {
                long j = this.zzcfo;
                this.zzcfo = 1 + j;
                zzl = new zzbnq(j, zzN, this.zzcfn.zzZY(), true, false);
            } else if ($assertionsDisabled || !zzl.zzcfg) {
                zzl = zzl.zzXZ();
            } else {
                throw new AssertionError("This should have been handled above!");
            }
            zza(zzl);
        }
    }

    public boolean zzD(zzbmj com_google_android_gms_internal_zzbmj) {
        return this.zzcfm.zzb(com_google_android_gms_internal_zzbmj, zzcfj) != null;
    }

    public long zzYb() {
        return (long) zza(zzcfk).size();
    }

    public zzbnp zza(zzbnj com_google_android_gms_internal_zzbnj) {
        List zza = zza(zzcfk);
        long zza2 = zza(com_google_android_gms_internal_zzbnj, (long) zza.size());
        zzbnp com_google_android_gms_internal_zzbnp = new zzbnp();
        if (this.zzbYx.zzYT()) {
            this.zzbYx.zzi("Pruning old queries.  Prunable: " + zza.size() + " Count to prune: " + zza2, new Object[0]);
        }
        Collections.sort(zza, new C12596(this));
        for (int i = 0; ((long) i) < zza2; i++) {
            zzbnq com_google_android_gms_internal_zzbnq = (zzbnq) zza.get(i);
            com_google_android_gms_internal_zzbnp = com_google_android_gms_internal_zzbnp.zzy(com_google_android_gms_internal_zzbnq.zzcfe.zzVc());
            zzm(com_google_android_gms_internal_zzbnq.zzcfe);
        }
        zzbnp com_google_android_gms_internal_zzbnp2 = com_google_android_gms_internal_zzbnp;
        for (int i2 = (int) zza2; i2 < zza.size(); i2++) {
            com_google_android_gms_internal_zzbnp2 = com_google_android_gms_internal_zzbnp2.zzz(((zzbnq) zza.get(i2)).zzcfe.zzVc());
        }
        List<zzbnq> zza3 = zza(zzcfl);
        if (this.zzbYx.zzYT()) {
            this.zzbYx.zzi("Unprunable queries: " + zza3.size(), new Object[0]);
        }
        for (zzbnq com_google_android_gms_internal_zzbnq2 : zza3) {
            com_google_android_gms_internal_zzbnp2 = com_google_android_gms_internal_zzbnp2.zzz(com_google_android_gms_internal_zzbnq2.zzcfe.zzVc());
        }
        return com_google_android_gms_internal_zzbnp2;
    }

    public void zzg(zzboe com_google_android_gms_internal_zzboe) {
        zzb(com_google_android_gms_internal_zzboe, true);
    }

    public void zzh(zzboe com_google_android_gms_internal_zzboe) {
        zzb(com_google_android_gms_internal_zzboe, false);
    }

    public zzbnq zzl(zzboe com_google_android_gms_internal_zzboe) {
        zzboe zzk = zzk(com_google_android_gms_internal_zzboe);
        Map map = (Map) this.zzcfm.zzK(zzk.zzVc());
        return map != null ? (zzbnq) map.get(zzk.zzYG()) : null;
    }

    public void zzm(zzboe com_google_android_gms_internal_zzboe) {
        zzboe zzk = zzk(com_google_android_gms_internal_zzboe);
        zzbnq zzl = zzl(zzk);
        if ($assertionsDisabled || zzl != null) {
            this.zzceT.zzaB(zzl.id);
            Map map = (Map) this.zzcfm.zzK(zzk.zzVc());
            map.remove(zzk.zzYG());
            if (map.isEmpty()) {
                this.zzcfm = this.zzcfm.zzJ(zzk.zzVc());
                return;
            }
            return;
        }
        throw new AssertionError("Query must exist to be removed.");
    }

    public void zzn(zzboe com_google_android_gms_internal_zzboe) {
        zzbnq zzl = zzl(zzk(com_google_android_gms_internal_zzboe));
        if (zzl != null && !zzl.zzcfg) {
            zza(zzl.zzXZ());
        }
    }

    public boolean zzo(zzboe com_google_android_gms_internal_zzboe) {
        if (zzE(com_google_android_gms_internal_zzboe.zzVc())) {
            return true;
        }
        if (com_google_android_gms_internal_zzboe.zzYD()) {
            return false;
        }
        Map map = (Map) this.zzcfm.zzK(com_google_android_gms_internal_zzboe.zzVc());
        boolean z = map != null && map.containsKey(com_google_android_gms_internal_zzboe.zzYG()) && ((zzbnq) map.get(com_google_android_gms_internal_zzboe.zzYG())).zzcfg;
        return z;
    }
}
