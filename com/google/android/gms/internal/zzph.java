package com.google.android.gms.internal;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

@zzmb
public final class zzph {
    private static final ThreadPoolExecutor zzWJ;
    private static final ThreadPoolExecutor zzWK;

    static {
        zzWJ = new ThreadPoolExecutor(10, 10, 1, TimeUnit.MINUTES, new LinkedBlockingQueue(), zzaU("Default"));
        zzWK = new ThreadPoolExecutor(5, 5, 1, TimeUnit.MINUTES, new LinkedBlockingQueue(), zzaU("Loader"));
        zzWJ.allowCoreThreadTimeOut(true);
        zzWK.allowCoreThreadTimeOut(true);
    }

    public static zzqf<Void> zza(int i, Runnable runnable) {
        return i == 1 ? zza(zzWK, new 1(runnable)) : zza(zzWJ, new 2(runnable));
    }

    public static zzqf<Void> zza(Runnable runnable) {
        return zza(0, runnable);
    }

    public static <T> zzqf<T> zza(Callable<T> callable) {
        return zza(zzWJ, (Callable) callable);
    }

    public static <T> zzqf<T> zza(ExecutorService executorService, Callable<T> callable) {
        zzqc com_google_android_gms_internal_zzqc = new zzqc();
        try {
            com_google_android_gms_internal_zzqc.zzd(new 4(com_google_android_gms_internal_zzqc, executorService.submit(new 3(com_google_android_gms_internal_zzqc, callable))));
        } catch (Throwable e) {
            zzpy.zzc("Thread execution is rejected.", e);
            com_google_android_gms_internal_zzqc.cancel(true);
        }
        return com_google_android_gms_internal_zzqc;
    }

    private static ThreadFactory zzaU(String str) {
        return new 5(str);
    }
}
