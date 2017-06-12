package com.google.android.gms.internal;

import com.google.android.gms.internal.zzblf.zza;
import com.google.android.gms.internal.zzblf.zzb;
import java.util.Comparator;

public class zzble<K, V> implements zzblf<K, V> {
    private static final zzble zzbYQ;

    static {
        zzbYQ = new zzble();
    }

    private zzble() {
    }

    public static <K, V> zzble<K, V> zzVr() {
        return zzbYQ;
    }

    public K getKey() {
        return null;
    }

    public V getValue() {
        return null;
    }

    public boolean isEmpty() {
        return true;
    }

    public boolean zzVq() {
        return false;
    }

    public zzblf<K, V> zzVs() {
        return this;
    }

    public zzblf<K, V> zzVt() {
        return this;
    }

    public zzblf<K, V> zzVu() {
        return this;
    }

    public zzblf<K, V> zzVv() {
        return this;
    }

    public int zzVw() {
        return 0;
    }

    public zzblf<K, V> zza(K k, V v, zza com_google_android_gms_internal_zzblf_zza, zzblf<K, V> com_google_android_gms_internal_zzblf_K__V, zzblf<K, V> com_google_android_gms_internal_zzblf_K__V2) {
        return this;
    }

    public zzblf<K, V> zza(K k, V v, Comparator<K> comparator) {
        return new zzblg(k, v);
    }

    public zzblf<K, V> zza(K k, Comparator<K> comparator) {
        return this;
    }

    public void zza(zzb<K, V> com_google_android_gms_internal_zzblf_zzb_K__V) {
    }
}
