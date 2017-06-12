package com.google.android.gms.internal;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;

class zzazo {

    private static class zza {
        private static final ExecutorService zzbJl;

        /* renamed from: com.google.android.gms.internal.zzazo.zza.1 */
        class C11391 implements ThreadFactory {
            C11391() {
            }

            public Thread newThread(Runnable runnable) {
                return new Thread(runnable, "google-tag-manager-background-thread");
            }
        }

        static {
            zzbJl = Executors.newSingleThreadExecutor(new C11391());
        }
    }

    private static class zzb {
        private static final ScheduledExecutorService zzbJm;

        /* renamed from: com.google.android.gms.internal.zzazo.zzb.1 */
        class C11401 implements ThreadFactory {
            C11401() {
            }

            public Thread newThread(Runnable runnable) {
                return new Thread(runnable, "google-tag-manager-scheduler-thread");
            }
        }

        static {
            zzbJm = Executors.newSingleThreadScheduledExecutor(new C11401());
        }
    }

    static ExecutorService zzQR() {
        return zza.zzbJl;
    }

    static ScheduledExecutorService zzQS() {
        return zzb.zzbJm;
    }
}
