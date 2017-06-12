package com.google.android.gms.internal;

import android.support.annotation.Nullable;
import java.util.Map;

@zzmb
public abstract class zzgc {
    @zzmb
    public static final zzgc zzFk;
    @zzmb
    public static final zzgc zzFl;
    @zzmb
    public static final zzgc zzFm;

    static {
        zzFk = new 1();
        zzFl = new 2();
        zzFm = new 3();
    }

    public final void zza(Map<String, String> map, String str, String str2) {
        map.put(str, zzf((String) map.get(str), str2));
    }

    public abstract String zzf(@Nullable String str, String str2);
}
