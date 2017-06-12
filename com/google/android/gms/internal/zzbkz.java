package com.google.android.gms.internal;

import com.google.android.gms.internal.zzbla.zza.zza;
import com.google.android.gms.internal.zzblf.zzb;
import java.util.AbstractMap.SimpleImmutableEntry;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class zzbkz<K, V> extends zzbla<K, V> {
    private final K[] zzbYE;
    private final V[] zzbYF;
    private final Comparator<K> zzbYG;

    /* renamed from: com.google.android.gms.internal.zzbkz.1 */
    class C11871 implements Iterator<Entry<K, V>> {
        int zzbYH;
        final /* synthetic */ int zzbYI;
        final /* synthetic */ boolean zzbYJ;
        final /* synthetic */ zzbkz zzbYK;

        C11871(zzbkz com_google_android_gms_internal_zzbkz, int i, boolean z) {
            this.zzbYK = com_google_android_gms_internal_zzbkz;
            this.zzbYI = i;
            this.zzbYJ = z;
            this.zzbYH = this.zzbYI;
        }

        public boolean hasNext() {
            return this.zzbYJ ? this.zzbYH >= 0 : this.zzbYH < this.zzbYK.zzbYE.length;
        }

        public Entry<K, V> next() {
            Object obj = this.zzbYK.zzbYE[this.zzbYH];
            Object obj2 = this.zzbYK.zzbYF[this.zzbYH];
            this.zzbYH = this.zzbYJ ? this.zzbYH - 1 : this.zzbYH + 1;
            return new SimpleImmutableEntry(obj, obj2);
        }

        public void remove() {
            throw new UnsupportedOperationException("Can't remove elements from ImmutableSortedMap");
        }
    }

    public zzbkz(Comparator<K> comparator) {
        this.zzbYE = new Object[0];
        this.zzbYF = new Object[0];
        this.zzbYG = comparator;
    }

    private zzbkz(Comparator<K> comparator, K[] kArr, V[] vArr) {
        this.zzbYE = kArr;
        this.zzbYF = vArr;
        this.zzbYG = comparator;
    }

    public static <A, B, C> zzbkz<A, C> zza(List<A> list, Map<B, C> map, zza<A, B> com_google_android_gms_internal_zzbla_zza_zza_A__B, Comparator<A> comparator) {
        Collections.sort(list, comparator);
        int size = list.size();
        Object[] objArr = new Object[size];
        Object[] objArr2 = new Object[size];
        size = 0;
        for (Object next : list) {
            objArr[size] = next;
            objArr2[size] = map.get(com_google_android_gms_internal_zzbla_zza_zza_A__B.zzai(next));
            size++;
        }
        return new zzbkz(comparator, objArr, objArr2);
    }

    public static <K, V> zzbkz<K, V> zza(Map<K, V> map, Comparator<K> comparator) {
        return zza(new ArrayList(map.keySet()), map, zzbla.zza.zzVm(), comparator);
    }

    private static <T> T[] zza(T[] tArr, int i) {
        int length = tArr.length - 1;
        Object obj = new Object[length];
        System.arraycopy(tArr, 0, obj, 0, i);
        System.arraycopy(tArr, i + 1, obj, i, length - i);
        return obj;
    }

    private static <T> T[] zza(T[] tArr, int i, T t) {
        int length = tArr.length + 1;
        Object obj = new Object[length];
        System.arraycopy(tArr, 0, obj, 0, i);
        obj[i] = t;
        System.arraycopy(tArr, i, obj, i + 1, (length - i) - 1);
        return obj;
    }

    private int zzag(K k) {
        int i = 0;
        while (i < this.zzbYE.length && this.zzbYG.compare(this.zzbYE[i], k) < 0) {
            i++;
        }
        return i;
    }

    private int zzah(K k) {
        int i = 0;
        Object[] objArr = this.zzbYE;
        int length = objArr.length;
        int i2 = 0;
        while (i2 < length) {
            if (this.zzbYG.compare(k, objArr[i2]) == 0) {
                return i;
            }
            i2++;
            i++;
        }
        return -1;
    }

    private static <T> T[] zzb(T[] tArr, int i, T t) {
        int length = tArr.length;
        Object obj = new Object[length];
        System.arraycopy(tArr, 0, obj, 0, length);
        obj[i] = t;
        return obj;
    }

    private Iterator<Entry<K, V>> zze(int i, boolean z) {
        return new C11871(this, i, z);
    }

    public boolean containsKey(K k) {
        return zzah(k) != -1;
    }

    public V get(K k) {
        int zzah = zzah(k);
        return zzah != -1 ? this.zzbYF[zzah] : null;
    }

    public Comparator<K> getComparator() {
        return this.zzbYG;
    }

    public boolean isEmpty() {
        return this.zzbYE.length == 0;
    }

    public Iterator<Entry<K, V>> iterator() {
        return zze(0, false);
    }

    public int size() {
        return this.zzbYE.length;
    }

    public K zzVj() {
        return this.zzbYE.length > 0 ? this.zzbYE[0] : null;
    }

    public K zzVk() {
        return this.zzbYE.length > 0 ? this.zzbYE[this.zzbYE.length - 1] : null;
    }

    public Iterator<Entry<K, V>> zzVl() {
        return zze(this.zzbYE.length - 1, true);
    }

    public void zza(zzb<K, V> com_google_android_gms_internal_zzblf_zzb_K__V) {
        for (int i = 0; i < this.zzbYE.length; i++) {
            com_google_android_gms_internal_zzblf_zzb_K__V.zzk(this.zzbYE[i], this.zzbYF[i]);
        }
    }

    public zzbla<K, V> zzae(K k) {
        int zzah = zzah(k);
        if (zzah == -1) {
            return this;
        }
        return new zzbkz(this.zzbYG, zza(this.zzbYE, zzah), zza(this.zzbYF, zzah));
    }

    public K zzaf(K k) {
        int zzah = zzah(k);
        if (zzah != -1) {
            return zzah > 0 ? this.zzbYE[zzah - 1] : null;
        } else {
            throw new IllegalArgumentException("Can't find predecessor of nonexistent key");
        }
    }

    public zzbla<K, V> zzj(K k, V v) {
        int zzah = zzah(k);
        if (zzah != -1) {
            if (this.zzbYE[zzah] == k && this.zzbYF[zzah] == v) {
                return this;
            }
            return new zzbkz(this.zzbYG, zzb(this.zzbYE, zzah, k), zzb(this.zzbYF, zzah, v));
        } else if (this.zzbYE.length > 25) {
            Map hashMap = new HashMap(this.zzbYE.length + 1);
            for (zzah = 0; zzah < this.zzbYE.length; zzah++) {
                hashMap.put(this.zzbYE[zzah], this.zzbYF[zzah]);
            }
            hashMap.put(k, v);
            return zzbli.zzc(hashMap, this.zzbYG);
        } else {
            zzah = zzag(k);
            return new zzbkz(this.zzbYG, zza(this.zzbYE, zzah, k), zza(this.zzbYF, zzah, v));
        }
    }
}
