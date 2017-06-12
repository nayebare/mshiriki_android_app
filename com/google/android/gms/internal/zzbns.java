package com.google.android.gms.internal;

import java.util.AbstractMap.SimpleImmutableEntry;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;

public class zzbns<T> implements Iterable<Entry<zzbmj, T>> {
    private static final zzbla zzcfr;
    private static final zzbns zzcfs;
    private final T value;
    private final zzbla<zzbos, zzbns<T>> zzcfq;

    public interface zza<T, R> {
        R zza(zzbmj com_google_android_gms_internal_zzbmj, T t, R r);
    }

    /* renamed from: com.google.android.gms.internal.zzbns.1 */
    class C12601 implements zza<T, Void> {
        final /* synthetic */ ArrayList zzcft;

        C12601(zzbns com_google_android_gms_internal_zzbns, ArrayList arrayList) {
            this.zzcft = arrayList;
        }

        public Void zza(zzbmj com_google_android_gms_internal_zzbmj, T t, Void voidR) {
            this.zzcft.add(t);
            return null;
        }
    }

    /* renamed from: com.google.android.gms.internal.zzbns.2 */
    class C12612 implements zza<T, Void> {
        final /* synthetic */ List zzcfu;

        C12612(zzbns com_google_android_gms_internal_zzbns, List list) {
            this.zzcfu = list;
        }

        public Void zza(zzbmj com_google_android_gms_internal_zzbmj, T t, Void voidR) {
            this.zzcfu.add(new SimpleImmutableEntry(com_google_android_gms_internal_zzbmj, t));
            return null;
        }
    }

    static {
        zzcfr = com.google.android.gms.internal.zzbla.zza.zza(zzblj.zzh(zzbos.class));
        zzcfs = new zzbns(null, zzcfr);
    }

    public zzbns(T t) {
        this(t, zzcfr);
    }

    public zzbns(T t, zzbla<zzbos, zzbns<T>> com_google_android_gms_internal_zzbla_com_google_android_gms_internal_zzbos__com_google_android_gms_internal_zzbns_T) {
        this.value = t;
        this.zzcfq = com_google_android_gms_internal_zzbla_com_google_android_gms_internal_zzbos__com_google_android_gms_internal_zzbns_T;
    }

    public static <V> zzbns<V> zzYd() {
        return zzcfs;
    }

    private <R> R zza(zzbmj com_google_android_gms_internal_zzbmj, zza<? super T, R> com_google_android_gms_internal_zzbns_zza__super_T__R, R r) {
        Iterator it = this.zzcfq.iterator();
        while (it.hasNext()) {
            Entry entry = (Entry) it.next();
            r = ((zzbns) entry.getValue()).zza(com_google_android_gms_internal_zzbmj.zza((zzbos) entry.getKey()), com_google_android_gms_internal_zzbns_zza__super_T__R, r);
        }
        return this.value != null ? com_google_android_gms_internal_zzbns_zza__super_T__R.zza(com_google_android_gms_internal_zzbmj, this.value, r) : r;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        zzbns com_google_android_gms_internal_zzbns = (zzbns) obj;
        if (this.zzcfq == null ? com_google_android_gms_internal_zzbns.zzcfq != null : !this.zzcfq.equals(com_google_android_gms_internal_zzbns.zzcfq)) {
            return false;
        }
        if (this.value != null) {
            if (this.value.equals(com_google_android_gms_internal_zzbns.value)) {
                return true;
            }
        } else if (com_google_android_gms_internal_zzbns.value == null) {
            return true;
        }
        return false;
    }

    public T getValue() {
        return this.value;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = (this.value != null ? this.value.hashCode() : 0) * 31;
        if (this.zzcfq != null) {
            i = this.zzcfq.hashCode();
        }
        return hashCode + i;
    }

    public boolean isEmpty() {
        return this.value == null && this.zzcfq.isEmpty();
    }

    public Iterator<Entry<zzbmj, T>> iterator() {
        List arrayList = new ArrayList();
        zza(new C12612(this, arrayList));
        return arrayList.iterator();
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("ImmutableTree { value=");
        stringBuilder.append(getValue());
        stringBuilder.append(", children={");
        Iterator it = this.zzcfq.iterator();
        while (it.hasNext()) {
            Entry entry = (Entry) it.next();
            stringBuilder.append(((zzbos) entry.getKey()).asString());
            stringBuilder.append("=");
            stringBuilder.append(entry.getValue());
        }
        stringBuilder.append("} }");
        return stringBuilder.toString();
    }

    public Collection<T> values() {
        Collection arrayList = new ArrayList();
        zza(new C12601(this, arrayList));
        return arrayList;
    }

    public zzbmj zzG(zzbmj com_google_android_gms_internal_zzbmj) {
        return zza(com_google_android_gms_internal_zzbmj, zzbnt.zzcfv);
    }

    public T zzH(zzbmj com_google_android_gms_internal_zzbmj) {
        return zzc(com_google_android_gms_internal_zzbmj, zzbnt.zzcfv);
    }

    public zzbns<T> zzI(zzbmj com_google_android_gms_internal_zzbmj) {
        if (com_google_android_gms_internal_zzbmj.isEmpty()) {
            return this;
        }
        zzbns com_google_android_gms_internal_zzbns = (zzbns) this.zzcfq.get(com_google_android_gms_internal_zzbmj.zzXi());
        return com_google_android_gms_internal_zzbns != null ? com_google_android_gms_internal_zzbns.zzI(com_google_android_gms_internal_zzbmj.zzXj()) : zzYd();
    }

    public zzbns<T> zzJ(zzbmj com_google_android_gms_internal_zzbmj) {
        if (com_google_android_gms_internal_zzbmj.isEmpty()) {
            return this.zzcfq.isEmpty() ? zzYd() : new zzbns(null, this.zzcfq);
        } else {
            zzbos zzXi = com_google_android_gms_internal_zzbmj.zzXi();
            zzbns com_google_android_gms_internal_zzbns = (zzbns) this.zzcfq.get(zzXi);
            if (com_google_android_gms_internal_zzbns == null) {
                return this;
            }
            com_google_android_gms_internal_zzbns = com_google_android_gms_internal_zzbns.zzJ(com_google_android_gms_internal_zzbmj.zzXj());
            zzbla zzae = com_google_android_gms_internal_zzbns.isEmpty() ? this.zzcfq.zzae(zzXi) : this.zzcfq.zzj(zzXi, com_google_android_gms_internal_zzbns);
            return (this.value == null && zzae.isEmpty()) ? zzYd() : new zzbns(this.value, zzae);
        }
    }

    public T zzK(zzbmj com_google_android_gms_internal_zzbmj) {
        if (com_google_android_gms_internal_zzbmj.isEmpty()) {
            return this.value;
        }
        zzbns com_google_android_gms_internal_zzbns = (zzbns) this.zzcfq.get(com_google_android_gms_internal_zzbmj.zzXi());
        return com_google_android_gms_internal_zzbns != null ? com_google_android_gms_internal_zzbns.zzK(com_google_android_gms_internal_zzbmj.zzXj()) : null;
    }

    public zzbla<zzbos, zzbns<T>> zzYe() {
        return this.zzcfq;
    }

    public zzbmj zza(zzbmj com_google_android_gms_internal_zzbmj, zzbnt<? super T> com_google_android_gms_internal_zzbnt__super_T) {
        if (this.value != null && com_google_android_gms_internal_zzbnt__super_T.zzaq(this.value)) {
            return zzbmj.zzXf();
        }
        if (com_google_android_gms_internal_zzbmj.isEmpty()) {
            return null;
        }
        zzbns com_google_android_gms_internal_zzbns = (zzbns) this.zzcfq.get(com_google_android_gms_internal_zzbmj.zzXi());
        if (com_google_android_gms_internal_zzbns == null) {
            return null;
        }
        zzbmj zza = com_google_android_gms_internal_zzbns.zza(com_google_android_gms_internal_zzbmj.zzXj(), (zzbnt) com_google_android_gms_internal_zzbnt__super_T);
        if (zza == null) {
            return null;
        }
        return new zzbmj(r2).zzh(zza);
    }

    public zzbns<T> zza(zzbmj com_google_android_gms_internal_zzbmj, zzbns<T> com_google_android_gms_internal_zzbns_T) {
        if (com_google_android_gms_internal_zzbmj.isEmpty()) {
            return com_google_android_gms_internal_zzbns_T;
        }
        zzbos zzXi = com_google_android_gms_internal_zzbmj.zzXi();
        zzbns com_google_android_gms_internal_zzbns = (zzbns) this.zzcfq.get(zzXi);
        if (com_google_android_gms_internal_zzbns == null) {
            com_google_android_gms_internal_zzbns = zzYd();
        }
        com_google_android_gms_internal_zzbns = com_google_android_gms_internal_zzbns.zza(com_google_android_gms_internal_zzbmj.zzXj(), (zzbns) com_google_android_gms_internal_zzbns_T);
        return new zzbns(this.value, com_google_android_gms_internal_zzbns.isEmpty() ? this.zzcfq.zzae(zzXi) : this.zzcfq.zzj(zzXi, com_google_android_gms_internal_zzbns));
    }

    public void zza(zza<T, Void> com_google_android_gms_internal_zzbns_zza_T__java_lang_Void) {
        zza(zzbmj.zzXf(), com_google_android_gms_internal_zzbns_zza_T__java_lang_Void, null);
    }

    public zzbns<T> zzb(zzbmj com_google_android_gms_internal_zzbmj, T t) {
        if (com_google_android_gms_internal_zzbmj.isEmpty()) {
            return new zzbns(t, this.zzcfq);
        }
        zzbos zzXi = com_google_android_gms_internal_zzbmj.zzXi();
        zzbns com_google_android_gms_internal_zzbns = (zzbns) this.zzcfq.get(zzXi);
        if (com_google_android_gms_internal_zzbns == null) {
            com_google_android_gms_internal_zzbns = zzYd();
        }
        return new zzbns(this.value, this.zzcfq.zzj(zzXi, com_google_android_gms_internal_zzbns.zzb(com_google_android_gms_internal_zzbmj.zzXj(), (Object) t)));
    }

    public T zzb(zzbmj com_google_android_gms_internal_zzbmj, zzbnt<? super T> com_google_android_gms_internal_zzbnt__super_T) {
        if (this.value != null && com_google_android_gms_internal_zzbnt__super_T.zzaq(this.value)) {
            return this.value;
        }
        Iterator it = com_google_android_gms_internal_zzbmj.iterator();
        while (it.hasNext()) {
            zzbns com_google_android_gms_internal_zzbns = (zzbns) this.zzcfq.get((zzbos) it.next());
            if (com_google_android_gms_internal_zzbns == null) {
                return null;
            }
            if (com_google_android_gms_internal_zzbns.value != null && com_google_android_gms_internal_zzbnt__super_T.zzaq(com_google_android_gms_internal_zzbns.value)) {
                return com_google_android_gms_internal_zzbns.value;
            }
            this = com_google_android_gms_internal_zzbns;
        }
        return null;
    }

    public <R> R zzb(R r, zza<? super T, R> com_google_android_gms_internal_zzbns_zza__super_T__R) {
        return zza(zzbmj.zzXf(), com_google_android_gms_internal_zzbns_zza__super_T__R, r);
    }

    public boolean zzb(zzbnt<? super T> com_google_android_gms_internal_zzbnt__super_T) {
        if (this.value != null && com_google_android_gms_internal_zzbnt__super_T.zzaq(this.value)) {
            return true;
        }
        Iterator it = this.zzcfq.iterator();
        while (it.hasNext()) {
            if (((zzbns) ((Entry) it.next()).getValue()).zzb(com_google_android_gms_internal_zzbnt__super_T)) {
                return true;
            }
        }
        return false;
    }

    public T zzc(zzbmj com_google_android_gms_internal_zzbmj, zzbnt<? super T> com_google_android_gms_internal_zzbnt__super_T) {
        T t = (this.value == null || !com_google_android_gms_internal_zzbnt__super_T.zzaq(this.value)) ? null : this.value;
        Iterator it = com_google_android_gms_internal_zzbmj.iterator();
        T t2 = t;
        while (it.hasNext()) {
            zzbns com_google_android_gms_internal_zzbns = (zzbns) this.zzcfq.get((zzbos) it.next());
            if (com_google_android_gms_internal_zzbns == null) {
                break;
            }
            if (com_google_android_gms_internal_zzbns.value != null && com_google_android_gms_internal_zzbnt__super_T.zzaq(com_google_android_gms_internal_zzbns.value)) {
                t2 = com_google_android_gms_internal_zzbns.value;
            }
            this = com_google_android_gms_internal_zzbns;
        }
        return t2;
    }

    public zzbns<T> zze(zzbos com_google_android_gms_internal_zzbos) {
        zzbns<T> com_google_android_gms_internal_zzbns_T = (zzbns) this.zzcfq.get(com_google_android_gms_internal_zzbos);
        return com_google_android_gms_internal_zzbns_T != null ? com_google_android_gms_internal_zzbns_T : zzYd();
    }
}
