package com.google.android.gms.internal;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

class zzbmw implements zzbmg {
    private final ThreadPoolExecutor zzcee;

    /* renamed from: com.google.android.gms.internal.zzbmw.1 */
    class C12471 implements ThreadFactory {
        final /* synthetic */ ThreadFactory zzcef;
        final /* synthetic */ zzbmv zzceg;

        C12471(zzbmw com_google_android_gms_internal_zzbmw, ThreadFactory threadFactory, zzbmv com_google_android_gms_internal_zzbmv) {
            this.zzcef = threadFactory;
            this.zzceg = com_google_android_gms_internal_zzbmv;
        }

        public Thread newThread(Runnable runnable) {
            Thread newThread = this.zzcef.newThread(runnable);
            this.zzceg.zza(newThread, "FirebaseDatabaseEventTarget");
            this.zzceg.zza(newThread, true);
            return newThread;
        }
    }

    public zzbmw(ThreadFactory threadFactory, zzbmv com_google_android_gms_internal_zzbmv) {
        int i = 1;
        this.zzcee = new ThreadPoolExecutor(1, i, 3, TimeUnit.SECONDS, new LinkedBlockingQueue(), new C12471(this, threadFactory, com_google_android_gms_internal_zzbmv));
    }

    public void restart() {
        this.zzcee.setCorePoolSize(1);
    }

    public void shutdown() {
        this.zzcee.setCorePoolSize(0);
    }

    public void zzq(Runnable runnable) {
        this.zzcee.execute(runnable);
    }
}
