package com.google.android.gms.internal;

import java.util.Comparator;

public class zzblj<A extends Comparable<A>> implements Comparator<A> {
    private static zzblj zzbZg;

    static {
        zzbZg = new zzblj();
    }

    private zzblj() {
    }

    public static <T extends Comparable<T>> zzblj<T> zzh(Class<T> cls) {
        return zzbZg;
    }

    public /* synthetic */ int compare(Object obj, Object obj2) {
        return zza((Comparable) obj, (Comparable) obj2);
    }

    public int zza(A a, A a2) {
        return a.compareTo(a2);
    }
}
