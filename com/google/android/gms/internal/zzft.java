package com.google.android.gms.internal;

import android.content.SharedPreferences;
import com.google.android.gms.ads.internal.zzv;

@zzmb
public abstract class zzft<T> {
    private final int zzAG;
    private final String zzAH;
    private final T zzAI;

    private zzft(int i, String str, T t) {
        this.zzAG = i;
        this.zzAH = str;
        this.zzAI = t;
        zzv.zzcU().zza(this);
    }

    public static zzft<String> zza(int i, String str) {
        zzft<String> zza = zza(i, str, null);
        zzv.zzcU().zzb(zza);
        return zza;
    }

    public static zzft<Float> zza(int i, String str, float f) {
        return new 4(i, str, Float.valueOf(f));
    }

    public static zzft<Integer> zza(int i, String str, int i2) {
        return new 2(i, str, Integer.valueOf(i2));
    }

    public static zzft<Long> zza(int i, String str, long j) {
        return new 3(i, str, Long.valueOf(j));
    }

    public static zzft<Boolean> zza(int i, String str, Boolean bool) {
        return new 1(i, str, bool);
    }

    public static zzft<String> zza(int i, String str, String str2) {
        return new 5(i, str, str2);
    }

    public static zzft<String> zzb(int i, String str) {
        zzft<String> zza = zza(i, str, null);
        zzv.zzcU().zzc(zza);
        return zza;
    }

    public T get() {
        return zzv.zzcV().zzd(this);
    }

    public String getKey() {
        return this.zzAH;
    }

    protected abstract T zza(SharedPreferences sharedPreferences);

    public T zzfm() {
        return this.zzAI;
    }
}
