package com.google.android.gms.internal;

import com.google.android.gms.internal.zzblf.zza;

public class zzbld<K, V> extends zzblh<K, V> {
    zzbld(K k, V v, zzblf<K, V> com_google_android_gms_internal_zzblf_K__V, zzblf<K, V> com_google_android_gms_internal_zzblf_K__V2) {
        super(k, v, com_google_android_gms_internal_zzblf_K__V, com_google_android_gms_internal_zzblf_K__V2);
    }

    protected zza zzVp() {
        return zza.BLACK;
    }

    public boolean zzVq() {
        return false;
    }

    protected zzblh<K, V> zza(K k, V v, zzblf<K, V> com_google_android_gms_internal_zzblf_K__V, zzblf<K, V> com_google_android_gms_internal_zzblf_K__V2) {
        Object key;
        Object value;
        zzblf zzVs;
        zzblf zzVt;
        if (k == null) {
            key = getKey();
        }
        if (v == null) {
            value = getValue();
        }
        if (com_google_android_gms_internal_zzblf_K__V == null) {
            zzVs = zzVs();
        }
        if (com_google_android_gms_internal_zzblf_K__V2 == null) {
            zzVt = zzVt();
        }
        return new zzbld(key, value, zzVs, zzVt);
    }
}
