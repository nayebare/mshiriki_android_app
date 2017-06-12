package com.google.android.gms.internal;

import com.google.android.gms.internal.zzbns.zza;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class zzbma implements Iterable<Entry<zzbmj, zzbpe>> {
    static final /* synthetic */ boolean $assertionsDisabled;
    private static final zzbma zzcbB;
    private final zzbns<zzbpe> zzcbC;

    /* renamed from: com.google.android.gms.internal.zzbma.1 */
    class C12071 implements zza<zzbpe, zzbma> {
        final /* synthetic */ zzbmj zzcbD;

        C12071(zzbma com_google_android_gms_internal_zzbma, zzbmj com_google_android_gms_internal_zzbmj) {
            this.zzcbD = com_google_android_gms_internal_zzbmj;
        }

        public zzbma zza(zzbmj com_google_android_gms_internal_zzbmj, zzbpe com_google_android_gms_internal_zzbpe, zzbma com_google_android_gms_internal_zzbma) {
            return com_google_android_gms_internal_zzbma.zze(this.zzcbD.zzh(com_google_android_gms_internal_zzbmj), com_google_android_gms_internal_zzbpe);
        }
    }

    /* renamed from: com.google.android.gms.internal.zzbma.2 */
    class C12082 implements zza<zzbpe, Void> {
        final /* synthetic */ Map zzcbE;
        final /* synthetic */ boolean zzcbF;

        C12082(zzbma com_google_android_gms_internal_zzbma, Map map, boolean z) {
            this.zzcbE = map;
            this.zzcbF = z;
        }

        public Void zza(zzbmj com_google_android_gms_internal_zzbmj, zzbpe com_google_android_gms_internal_zzbpe, Void voidR) {
            this.zzcbE.put(com_google_android_gms_internal_zzbmj.zzXg(), com_google_android_gms_internal_zzbpe.getValue(this.zzcbF));
            return null;
        }
    }

    static {
        $assertionsDisabled = !zzbma.class.desiredAssertionStatus();
        zzcbB = new zzbma(new zzbns(null));
    }

    private zzbma(zzbns<zzbpe> com_google_android_gms_internal_zzbns_com_google_android_gms_internal_zzbpe) {
        this.zzcbC = com_google_android_gms_internal_zzbns_com_google_android_gms_internal_zzbpe;
    }

    public static zzbma zzWE() {
        return zzcbB;
    }

    private zzbpe zza(zzbmj com_google_android_gms_internal_zzbmj, zzbns<zzbpe> com_google_android_gms_internal_zzbns_com_google_android_gms_internal_zzbpe, zzbpe com_google_android_gms_internal_zzbpe) {
        if (com_google_android_gms_internal_zzbns_com_google_android_gms_internal_zzbpe.getValue() != null) {
            return com_google_android_gms_internal_zzbpe.zzl(com_google_android_gms_internal_zzbmj, (zzbpe) com_google_android_gms_internal_zzbns_com_google_android_gms_internal_zzbpe.getValue());
        }
        zzbpe com_google_android_gms_internal_zzbpe2 = null;
        Iterator it = com_google_android_gms_internal_zzbns_com_google_android_gms_internal_zzbpe.zzYe().iterator();
        zzbpe com_google_android_gms_internal_zzbpe3 = com_google_android_gms_internal_zzbpe;
        while (it.hasNext()) {
            zzbpe zza;
            zzbpe com_google_android_gms_internal_zzbpe4;
            Entry entry = (Entry) it.next();
            zzbns com_google_android_gms_internal_zzbns = (zzbns) entry.getValue();
            zzbos com_google_android_gms_internal_zzbos = (zzbos) entry.getKey();
            if (!com_google_android_gms_internal_zzbos.zzZa()) {
                zza = zza(com_google_android_gms_internal_zzbmj.zza(com_google_android_gms_internal_zzbos), com_google_android_gms_internal_zzbns, com_google_android_gms_internal_zzbpe3);
                com_google_android_gms_internal_zzbpe4 = com_google_android_gms_internal_zzbpe2;
            } else if ($assertionsDisabled || com_google_android_gms_internal_zzbns.getValue() != null) {
                com_google_android_gms_internal_zzbpe4 = (zzbpe) com_google_android_gms_internal_zzbns.getValue();
                zza = com_google_android_gms_internal_zzbpe3;
            } else {
                throw new AssertionError("Priority writes must always be leaf nodes");
            }
            com_google_android_gms_internal_zzbpe2 = com_google_android_gms_internal_zzbpe4;
            com_google_android_gms_internal_zzbpe3 = zza;
        }
        return (com_google_android_gms_internal_zzbpe3.zzO(com_google_android_gms_internal_zzbmj).isEmpty() || com_google_android_gms_internal_zzbpe2 == null) ? com_google_android_gms_internal_zzbpe3 : com_google_android_gms_internal_zzbpe3.zzl(com_google_android_gms_internal_zzbmj.zza(zzbos.zzYY()), com_google_android_gms_internal_zzbpe2);
    }

    public static zzbma zzaA(Map<String, Object> map) {
        zzbns zzYd = zzbns.zzYd();
        zzbns com_google_android_gms_internal_zzbns = zzYd;
        for (Entry entry : map.entrySet()) {
            com_google_android_gms_internal_zzbns = com_google_android_gms_internal_zzbns.zza(new zzbmj((String) entry.getKey()), new zzbns(zzbpf.zzar(entry.getValue())));
        }
        return new zzbma(com_google_android_gms_internal_zzbns);
    }

    public static zzbma zzaB(Map<zzbmj, zzbpe> map) {
        zzbns zzYd = zzbns.zzYd();
        zzbns com_google_android_gms_internal_zzbns = zzYd;
        for (Entry entry : map.entrySet()) {
            com_google_android_gms_internal_zzbns = com_google_android_gms_internal_zzbns.zza((zzbmj) entry.getKey(), new zzbns((zzbpe) entry.getValue()));
        }
        return new zzbma(com_google_android_gms_internal_zzbns);
    }

    public boolean equals(Object obj) {
        return obj == this ? true : (obj == null || obj.getClass() != getClass()) ? false : ((zzbma) obj).zzaZ(true).equals(zzaZ(true));
    }

    public int hashCode() {
        return zzaZ(true).hashCode();
    }

    public boolean isEmpty() {
        return this.zzcbC.isEmpty();
    }

    public Iterator<Entry<zzbmj, zzbpe>> iterator() {
        return this.zzcbC.iterator();
    }

    public String toString() {
        String valueOf = String.valueOf(zzaZ(true).toString());
        return new StringBuilder(String.valueOf(valueOf).length() + 15).append("CompoundWrite{").append(valueOf).append("}").toString();
    }

    public zzbpe zzWF() {
        return (zzbpe) this.zzcbC.getValue();
    }

    public List<zzbpd> zzWG() {
        List<zzbpd> arrayList = new ArrayList();
        if (this.zzcbC.getValue() != null) {
            for (zzbpd com_google_android_gms_internal_zzbpd : (zzbpe) this.zzcbC.getValue()) {
                arrayList.add(new zzbpd(com_google_android_gms_internal_zzbpd.zzZz(), com_google_android_gms_internal_zzbpd.zzUY()));
            }
        } else {
            Iterator it = this.zzcbC.zzYe().iterator();
            while (it.hasNext()) {
                Entry entry = (Entry) it.next();
                zzbns com_google_android_gms_internal_zzbns = (zzbns) entry.getValue();
                if (com_google_android_gms_internal_zzbns.getValue() != null) {
                    arrayList.add(new zzbpd((zzbos) entry.getKey(), (zzbpe) com_google_android_gms_internal_zzbns.getValue()));
                }
            }
        }
        return arrayList;
    }

    public Map<zzbos, zzbma> zzWH() {
        Map<zzbos, zzbma> hashMap = new HashMap();
        Iterator it = this.zzcbC.zzYe().iterator();
        while (it.hasNext()) {
            Entry entry = (Entry) it.next();
            hashMap.put((zzbos) entry.getKey(), new zzbma((zzbns) entry.getValue()));
        }
        return hashMap;
    }

    public zzbma zza(zzbos com_google_android_gms_internal_zzbos, zzbpe com_google_android_gms_internal_zzbpe) {
        return zze(new zzbmj(com_google_android_gms_internal_zzbos), com_google_android_gms_internal_zzbpe);
    }

    public Map<String, Object> zzaZ(boolean z) {
        Map<String, Object> hashMap = new HashMap();
        this.zzcbC.zza(new C12082(this, hashMap, z));
        return hashMap;
    }

    public zzbma zzb(zzbmj com_google_android_gms_internal_zzbmj, zzbma com_google_android_gms_internal_zzbma) {
        return (zzbma) com_google_android_gms_internal_zzbma.zzcbC.zzb((Object) this, new C12071(this, com_google_android_gms_internal_zzbmj));
    }

    public zzbpe zzb(zzbpe com_google_android_gms_internal_zzbpe) {
        return zza(zzbmj.zzXf(), this.zzcbC, com_google_android_gms_internal_zzbpe);
    }

    public zzbma zzd(zzbmj com_google_android_gms_internal_zzbmj) {
        return com_google_android_gms_internal_zzbmj.isEmpty() ? zzcbB : new zzbma(this.zzcbC.zza(com_google_android_gms_internal_zzbmj, zzbns.zzYd()));
    }

    public zzbma zze(zzbmj com_google_android_gms_internal_zzbmj, zzbpe com_google_android_gms_internal_zzbpe) {
        if (com_google_android_gms_internal_zzbmj.isEmpty()) {
            return new zzbma(new zzbns(com_google_android_gms_internal_zzbpe));
        }
        zzbmj zzG = this.zzcbC.zzG(com_google_android_gms_internal_zzbmj);
        if (zzG != null) {
            zzbmj zza = zzbmj.zza(zzG, com_google_android_gms_internal_zzbmj);
            zzbpe com_google_android_gms_internal_zzbpe2 = (zzbpe) this.zzcbC.zzK(zzG);
            zzbos zzXl = zza.zzXl();
            if (zzXl != null && zzXl.zzZa() && com_google_android_gms_internal_zzbpe2.zzO(zza.zzXk()).isEmpty()) {
                return this;
            }
            return new zzbma(this.zzcbC.zzb(zzG, com_google_android_gms_internal_zzbpe2.zzl(zza, com_google_android_gms_internal_zzbpe)));
        }
        return new zzbma(this.zzcbC.zza(com_google_android_gms_internal_zzbmj, new zzbns(com_google_android_gms_internal_zzbpe)));
    }

    public boolean zze(zzbmj com_google_android_gms_internal_zzbmj) {
        return zzf(com_google_android_gms_internal_zzbmj) != null;
    }

    public zzbpe zzf(zzbmj com_google_android_gms_internal_zzbmj) {
        zzbmj zzG = this.zzcbC.zzG(com_google_android_gms_internal_zzbmj);
        return zzG != null ? ((zzbpe) this.zzcbC.zzK(zzG)).zzO(zzbmj.zza(zzG, com_google_android_gms_internal_zzbmj)) : null;
    }

    public zzbma zzg(zzbmj com_google_android_gms_internal_zzbmj) {
        if (com_google_android_gms_internal_zzbmj.isEmpty()) {
            return this;
        }
        zzbpe zzf = zzf(com_google_android_gms_internal_zzbmj);
        return zzf != null ? new zzbma(new zzbns(zzf)) : new zzbma(this.zzcbC.zzI(com_google_android_gms_internal_zzbmj));
    }
}
