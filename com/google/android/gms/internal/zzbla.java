package com.google.android.gms.internal;

import com.google.android.gms.internal.zzblf.zzb;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public abstract class zzbla<K, V> implements Iterable<Entry<K, V>> {

    public static class zza {
        private static final zza zzbYL;

        public interface zza<C, D> {
            D zzai(C c);
        }

        /* renamed from: com.google.android.gms.internal.zzbla.zza.1 */
        class C11881 implements zza {
            C11881() {
            }

            public Object zzai(Object obj) {
                return obj;
            }
        }

        static {
            zzbYL = new C11881();
        }

        public static <A> zza<A, A> zzVm() {
            return zzbYL;
        }

        public static <K, V> zzbla<K, V> zza(Comparator<K> comparator) {
            return new zzbkz(comparator);
        }

        public static <A, B, C> zzbla<A, C> zzb(List<A> list, Map<B, C> map, zza<A, B> com_google_android_gms_internal_zzbla_zza_zza_A__B, Comparator<A> comparator) {
            return list.size() < 25 ? zzbkz.zza(list, map, com_google_android_gms_internal_zzbla_zza_zza_A__B, comparator) : zzbli.zzc(list, map, com_google_android_gms_internal_zzbla_zza_zza_A__B, comparator);
        }

        public static <A, B> zzbla<A, B> zzb(Map<A, B> map, Comparator<A> comparator) {
            return map.size() < 25 ? zzbkz.zza((Map) map, (Comparator) comparator) : zzbli.zzc(map, comparator);
        }
    }

    public abstract boolean containsKey(K k);

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzbla)) {
            return false;
        }
        zzbla com_google_android_gms_internal_zzbla = (zzbla) obj;
        if (!getComparator().equals(com_google_android_gms_internal_zzbla.getComparator())) {
            return false;
        }
        if (size() != com_google_android_gms_internal_zzbla.size()) {
            return false;
        }
        Iterator it = iterator();
        Iterator it2 = com_google_android_gms_internal_zzbla.iterator();
        while (it.hasNext()) {
            if (!((Entry) it.next()).equals(it2.next())) {
                return false;
            }
        }
        return true;
    }

    public abstract V get(K k);

    public abstract Comparator<K> getComparator();

    public int hashCode() {
        int hashCode = getComparator().hashCode();
        Iterator it = iterator();
        int i = hashCode;
        while (it.hasNext()) {
            i = ((Entry) it.next()).hashCode() + (i * 31);
        }
        return i;
    }

    public abstract boolean isEmpty();

    public abstract Iterator<Entry<K, V>> iterator();

    public abstract int size();

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(getClass().getSimpleName());
        stringBuilder.append("{");
        Iterator it = iterator();
        Object obj = 1;
        while (it.hasNext()) {
            Entry entry = (Entry) it.next();
            if (obj != null) {
                obj = null;
            } else {
                stringBuilder.append(", ");
            }
            stringBuilder.append("(");
            stringBuilder.append(entry.getKey());
            stringBuilder.append("=>");
            stringBuilder.append(entry.getValue());
            stringBuilder.append(")");
        }
        stringBuilder.append("};");
        return stringBuilder.toString();
    }

    public abstract K zzVj();

    public abstract K zzVk();

    public abstract Iterator<Entry<K, V>> zzVl();

    public abstract void zza(zzb<K, V> com_google_android_gms_internal_zzblf_zzb_K__V);

    public abstract zzbla<K, V> zzae(K k);

    public abstract K zzaf(K k);

    public abstract zzbla<K, V> zzj(K k, V v);
}
