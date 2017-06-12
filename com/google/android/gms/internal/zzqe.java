package com.google.android.gms.internal;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.atomic.AtomicInteger;

@zzmb
public class zzqe {
    public static <A, B> zzqf<B> zza(zzqf<A> com_google_android_gms_internal_zzqf_A, zza<A, B> com_google_android_gms_internal_zzqe_zza_A__B) {
        zzqc com_google_android_gms_internal_zzqc = new zzqc();
        com_google_android_gms_internal_zzqf_A.zzc(new 1(com_google_android_gms_internal_zzqc, com_google_android_gms_internal_zzqe_zza_A__B, com_google_android_gms_internal_zzqf_A));
        return com_google_android_gms_internal_zzqc;
    }

    public static <V> zzqf<List<V>> zzo(List<zzqf<V>> list) {
        zzqc com_google_android_gms_internal_zzqc = new zzqc();
        int size = list.size();
        AtomicInteger atomicInteger = new AtomicInteger(0);
        Iterator it = list.iterator();
        while (it.hasNext()) {
            ((zzqf) it.next()).zzc(new 2(atomicInteger, size, com_google_android_gms_internal_zzqc, list));
        }
        return com_google_android_gms_internal_zzqc;
    }

    private static <V> List<V> zzp(List<zzqf<V>> list) throws ExecutionException, InterruptedException {
        List<V> arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            Object obj = ((zzqf) it.next()).get();
            if (obj != null) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }
}
