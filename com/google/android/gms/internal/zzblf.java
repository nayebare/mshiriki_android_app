package com.google.android.gms.internal;

import java.util.Comparator;

public interface zzblf<K, V> {

    public enum zza {
        RED,
        BLACK
    }

    public static abstract class zzb<K, V> {
        public abstract void zzk(K k, V v);
    }

    K getKey();

    V getValue();

    boolean isEmpty();

    boolean zzVq();

    zzblf<K, V> zzVs();

    zzblf<K, V> zzVt();

    zzblf<K, V> zzVu();

    zzblf<K, V> zzVv();

    int zzVw();

    zzblf<K, V> zza(K k, V v, zza com_google_android_gms_internal_zzblf_zza, zzblf<K, V> com_google_android_gms_internal_zzblf_K__V, zzblf<K, V> com_google_android_gms_internal_zzblf_K__V2);

    zzblf<K, V> zza(K k, V v, Comparator<K> comparator);

    zzblf<K, V> zza(K k, Comparator<K> comparator);

    void zza(zzb<K, V> com_google_android_gms_internal_zzblf_zzb_K__V);
}
