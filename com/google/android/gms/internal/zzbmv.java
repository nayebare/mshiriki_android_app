package com.google.android.gms.internal;

import java.lang.Thread.UncaughtExceptionHandler;

public interface zzbmv {
    public static final zzbmv zzced;

    /* renamed from: com.google.android.gms.internal.zzbmv.1 */
    class C12461 implements zzbmv {
        C12461() {
        }

        public void zza(Thread thread, String str) {
            thread.setName(str);
        }

        public void zza(Thread thread, UncaughtExceptionHandler uncaughtExceptionHandler) {
            thread.setUncaughtExceptionHandler(uncaughtExceptionHandler);
        }

        public void zza(Thread thread, boolean z) {
            thread.setDaemon(z);
        }
    }

    static {
        zzced = new C12461();
    }

    void zza(Thread thread, String str);

    void zza(Thread thread, UncaughtExceptionHandler uncaughtExceptionHandler);

    void zza(Thread thread, boolean z);
}
