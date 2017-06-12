package com.google.android.gms.internal;

import com.google.android.gms.internal.zzblf.zzb;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class zzbli<K, V> extends zzbla<K, V> {
    private Comparator<K> zzbYG;
    private zzblf<K, V> zzbYX;

    private static class zza<A, B, C> {
        private final Map<B, C> values;
        private final List<A> zzbYY;
        private final com.google.android.gms.internal.zzbla.zza.zza<A, B> zzbYZ;
        private zzblh<A, C> zzbZa;
        private zzblh<A, C> zzbZb;

        static class zza implements Iterable<zzb> {
            private final int length;
            private long value;

            /* renamed from: com.google.android.gms.internal.zzbli.zza.zza.1 */
            class C11901 implements Iterator<zzb> {
                private int zzbZc;
                final /* synthetic */ zza zzbZd;

                C11901(zza com_google_android_gms_internal_zzbli_zza_zza) {
                    this.zzbZd = com_google_android_gms_internal_zzbli_zza_zza;
                    this.zzbZc = this.zzbZd.length - 1;
                }

                public boolean hasNext() {
                    return this.zzbZc >= 0;
                }

                public /* synthetic */ Object next() {
                    return zzVE();
                }

                public void remove() {
                }

                public zzb zzVE() {
                    boolean z = true;
                    long zzb = this.zzbZd.value & ((long) (1 << this.zzbZc));
                    zzb com_google_android_gms_internal_zzbli_zza_zzb = new zzb();
                    if (zzb != 0) {
                        z = false;
                    }
                    com_google_android_gms_internal_zzbli_zza_zzb.zzbZe = z;
                    com_google_android_gms_internal_zzbli_zza_zzb.zzbZf = (int) Math.pow(2.0d, (double) this.zzbZc);
                    this.zzbZc--;
                    return com_google_android_gms_internal_zzbli_zza_zzb;
                }
            }

            public zza(int i) {
                int i2 = i + 1;
                this.length = (int) Math.floor(Math.log((double) i2) / Math.log(2.0d));
                this.value = ((long) i2) & (((long) Math.pow(2.0d, (double) this.length)) - 1);
            }

            public Iterator<zzb> iterator() {
                return new C11901(this);
            }
        }

        static class zzb {
            public boolean zzbZe;
            public int zzbZf;

            zzb() {
            }
        }

        private zza(List<A> list, Map<B, C> map, com.google.android.gms.internal.zzbla.zza.zza<A, B> com_google_android_gms_internal_zzbla_zza_zza_A__B) {
            this.zzbYY = list;
            this.values = map;
            this.zzbYZ = com_google_android_gms_internal_zzbla_zza_zza_A__B;
        }

        private zzblf<A, C> zzB(int i, int i2) {
            if (i2 == 0) {
                return zzble.zzVr();
            }
            if (i2 == 1) {
                Object obj = this.zzbYY.get(i);
                return new zzbld(obj, zzan(obj), null, null);
            }
            int i3 = i2 / 2;
            int i4 = i + i3;
            zzblf zzB = zzB(i, i3);
            zzblf zzB2 = zzB(i4 + 1, i3);
            obj = this.zzbYY.get(i4);
            return new zzbld(obj, zzan(obj), zzB, zzB2);
        }

        private void zza(com.google.android.gms.internal.zzblf.zza com_google_android_gms_internal_zzblf_zza, int i, int i2) {
            zzblf zzB = zzB(i2 + 1, i - 1);
            Object obj = this.zzbYY.get(i2);
            Object com_google_android_gms_internal_zzblg = com_google_android_gms_internal_zzblf_zza == com.google.android.gms.internal.zzblf.zza.RED ? new zzblg(obj, zzan(obj), null, zzB) : new zzbld(obj, zzan(obj), null, zzB);
            if (this.zzbZa == null) {
                this.zzbZa = com_google_android_gms_internal_zzblg;
                this.zzbZb = com_google_android_gms_internal_zzblg;
                return;
            }
            this.zzbZb.zzb(com_google_android_gms_internal_zzblg);
            this.zzbZb = com_google_android_gms_internal_zzblg;
        }

        private C zzan(A a) {
            return this.values.get(this.zzbYZ.zzai(a));
        }

        public static <A, B, C> zzbli<A, C> zzc(List<A> list, Map<B, C> map, com.google.android.gms.internal.zzbla.zza.zza<A, B> com_google_android_gms_internal_zzbla_zza_zza_A__B, Comparator<A> comparator) {
            zza com_google_android_gms_internal_zzbli_zza = new zza(list, map, com_google_android_gms_internal_zzbla_zza_zza_A__B);
            Collections.sort(list, comparator);
            Iterator it = new zza(list.size()).iterator();
            int size = list.size();
            while (it.hasNext()) {
                int i;
                zzb com_google_android_gms_internal_zzbli_zza_zzb = (zzb) it.next();
                size -= com_google_android_gms_internal_zzbli_zza_zzb.zzbZf;
                if (com_google_android_gms_internal_zzbli_zza_zzb.zzbZe) {
                    com_google_android_gms_internal_zzbli_zza.zza(com.google.android.gms.internal.zzblf.zza.BLACK, com_google_android_gms_internal_zzbli_zza_zzb.zzbZf, size);
                    i = size;
                } else {
                    com_google_android_gms_internal_zzbli_zza.zza(com.google.android.gms.internal.zzblf.zza.BLACK, com_google_android_gms_internal_zzbli_zza_zzb.zzbZf, size);
                    size -= com_google_android_gms_internal_zzbli_zza_zzb.zzbZf;
                    com_google_android_gms_internal_zzbli_zza.zza(com.google.android.gms.internal.zzblf.zza.RED, com_google_android_gms_internal_zzbli_zza_zzb.zzbZf, size);
                    i = size;
                }
                size = i;
            }
            return new zzbli(comparator, null);
        }
    }

    private zzbli(zzblf<K, V> com_google_android_gms_internal_zzblf_K__V, Comparator<K> comparator) {
        this.zzbYX = com_google_android_gms_internal_zzblf_K__V;
        this.zzbYG = comparator;
    }

    private zzblf<K, V> zzam(K k) {
        zzblf<K, V> com_google_android_gms_internal_zzblf_K__V = this.zzbYX;
        while (!com_google_android_gms_internal_zzblf_K__V.isEmpty()) {
            int compare = this.zzbYG.compare(k, com_google_android_gms_internal_zzblf_K__V.getKey());
            if (compare < 0) {
                com_google_android_gms_internal_zzblf_K__V = com_google_android_gms_internal_zzblf_K__V.zzVs();
            } else if (compare == 0) {
                return com_google_android_gms_internal_zzblf_K__V;
            } else {
                com_google_android_gms_internal_zzblf_K__V = com_google_android_gms_internal_zzblf_K__V.zzVt();
            }
        }
        return null;
    }

    public static <A, B, C> zzbli<A, C> zzc(List<A> list, Map<B, C> map, com.google.android.gms.internal.zzbla.zza.zza<A, B> com_google_android_gms_internal_zzbla_zza_zza_A__B, Comparator<A> comparator) {
        return zza.zzc(list, map, com_google_android_gms_internal_zzbla_zza_zza_A__B, comparator);
    }

    public static <A, B> zzbli<A, B> zzc(Map<A, B> map, Comparator<A> comparator) {
        return zza.zzc(new ArrayList(map.keySet()), map, com.google.android.gms.internal.zzbla.zza.zzVm(), comparator);
    }

    public boolean containsKey(K k) {
        return zzam(k) != null;
    }

    public V get(K k) {
        zzblf zzam = zzam(k);
        return zzam != null ? zzam.getValue() : null;
    }

    public Comparator<K> getComparator() {
        return this.zzbYG;
    }

    public boolean isEmpty() {
        return this.zzbYX.isEmpty();
    }

    public Iterator<Entry<K, V>> iterator() {
        return new zzblb(this.zzbYX, null, this.zzbYG, false);
    }

    public int size() {
        return this.zzbYX.zzVw();
    }

    public K zzVj() {
        return this.zzbYX.zzVu().getKey();
    }

    public K zzVk() {
        return this.zzbYX.zzVv().getKey();
    }

    public Iterator<Entry<K, V>> zzVl() {
        return new zzblb(this.zzbYX, null, this.zzbYG, true);
    }

    public void zza(zzb<K, V> com_google_android_gms_internal_zzblf_zzb_K__V) {
        this.zzbYX.zza(com_google_android_gms_internal_zzblf_zzb_K__V);
    }

    public zzbla<K, V> zzae(K k) {
        if (!containsKey(k)) {
            return this;
        }
        return new zzbli(this.zzbYX.zza(k, this.zzbYG).zza(null, null, com.google.android.gms.internal.zzblf.zza.BLACK, null, null), this.zzbYG);
    }

    public K zzaf(K k) {
        zzblf com_google_android_gms_internal_zzblf = this.zzbYX;
        zzblf com_google_android_gms_internal_zzblf2 = null;
        while (!com_google_android_gms_internal_zzblf.isEmpty()) {
            int compare = this.zzbYG.compare(k, com_google_android_gms_internal_zzblf.getKey());
            if (compare == 0) {
                if (com_google_android_gms_internal_zzblf.zzVs().isEmpty()) {
                    return com_google_android_gms_internal_zzblf2 != null ? com_google_android_gms_internal_zzblf2.getKey() : null;
                } else {
                    com_google_android_gms_internal_zzblf2 = com_google_android_gms_internal_zzblf.zzVs();
                    while (!com_google_android_gms_internal_zzblf2.zzVt().isEmpty()) {
                        com_google_android_gms_internal_zzblf2 = com_google_android_gms_internal_zzblf2.zzVt();
                    }
                    return com_google_android_gms_internal_zzblf2.getKey();
                }
            } else if (compare < 0) {
                com_google_android_gms_internal_zzblf = com_google_android_gms_internal_zzblf.zzVs();
            } else {
                zzblf com_google_android_gms_internal_zzblf3 = com_google_android_gms_internal_zzblf;
                com_google_android_gms_internal_zzblf = com_google_android_gms_internal_zzblf.zzVt();
                com_google_android_gms_internal_zzblf2 = com_google_android_gms_internal_zzblf3;
            }
        }
        String valueOf = String.valueOf(k);
        throw new IllegalArgumentException(new StringBuilder(String.valueOf(valueOf).length() + 50).append("Couldn't find predecessor key of non-present key: ").append(valueOf).toString());
    }

    public zzbla<K, V> zzj(K k, V v) {
        return new zzbli(this.zzbYX.zza(k, v, this.zzbYG).zza(null, null, com.google.android.gms.internal.zzblf.zza.BLACK, null, null), this.zzbYG);
    }
}
