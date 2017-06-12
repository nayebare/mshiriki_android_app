package com.google.android.gms.internal;

import android.support.v7.mediarouter.C0308R;
import com.github.mikephil.charting.BuildConfig;
import com.google.firebase.database.DatabaseException;
import com.google.firebase.database.FirebaseDatabase;
import java.lang.Thread.UncaughtExceptionHandler;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

public abstract class zzbqa implements zzbmo {
    private ScheduledThreadPoolExecutor zzcit;

    /* renamed from: com.google.android.gms.internal.zzbqa.1 */
    class C12831 extends ScheduledThreadPoolExecutor {
        final /* synthetic */ zzbqa zzciu;

        C12831(zzbqa com_google_android_gms_internal_zzbqa, int i, ThreadFactory threadFactory) {
            this.zzciu = com_google_android_gms_internal_zzbqa;
            super(i, threadFactory);
        }

        protected void afterExecute(Runnable runnable, Throwable th) {
            super.afterExecute(runnable, th);
            if (th == null && (runnable instanceof Future)) {
                Future future = (Future) runnable;
                try {
                    if (future.isDone()) {
                        future.get();
                    }
                } catch (CancellationException e) {
                } catch (ExecutionException e2) {
                    th = e2.getCause();
                } catch (InterruptedException e3) {
                    Thread.currentThread().interrupt();
                }
            }
            if (th != null) {
                this.zzciu.zzj(th);
            }
        }
    }

    private class zza implements ThreadFactory {
        final /* synthetic */ zzbqa zzciu;

        /* renamed from: com.google.android.gms.internal.zzbqa.zza.1 */
        class C12841 implements UncaughtExceptionHandler {
            final /* synthetic */ zza zzciv;

            C12841(zza com_google_android_gms_internal_zzbqa_zza) {
                this.zzciv = com_google_android_gms_internal_zzbqa_zza;
            }

            public void uncaughtException(Thread thread, Throwable th) {
                this.zzciv.zzciu.zzj(th);
            }
        }

        private zza(zzbqa com_google_android_gms_internal_zzbqa) {
            this.zzciu = com_google_android_gms_internal_zzbqa;
        }

        public Thread newThread(Runnable runnable) {
            Thread newThread = this.zzciu.getThreadFactory().newThread(runnable);
            zzbmv zzXe = this.zzciu.zzXe();
            zzXe.zza(newThread, "FirebaseDatabaseWorker");
            zzXe.zza(newThread, true);
            zzXe.zza(newThread, new C12841(this));
            return newThread;
        }
    }

    public zzbqa() {
        this.zzcit = new C12831(this, 1, new zza());
        this.zzcit.setKeepAliveTime(3, TimeUnit.SECONDS);
    }

    public static String zzl(Throwable th) {
        if (th instanceof OutOfMemoryError) {
            return "Firebase Database encountered an OutOfMemoryError. You may need to reduce the amount of data you are syncing to the client (e.g. by using queries or syncing a deeper path). See https://firebase.google.com/docs/database/ios/structure-data#best_practices_for_data_structure and https://firebase.google.com/docs/database/android/retrieve-data#filtering_data";
        }
        if (th instanceof DatabaseException) {
            return BuildConfig.FLAVOR;
        }
        String valueOf = String.valueOf(FirebaseDatabase.getSdkVersion());
        return new StringBuilder(String.valueOf(valueOf).length() + C0308R.styleable.AppCompatTheme_checkboxStyle).append("Uncaught exception in Firebase Database runloop (").append(valueOf).append("). Please report to firebase-database-client@google.com").toString();
    }

    protected ThreadFactory getThreadFactory() {
        return Executors.defaultThreadFactory();
    }

    public void restart() {
        this.zzcit.setCorePoolSize(1);
    }

    public void shutdown() {
        this.zzcit.setCorePoolSize(0);
    }

    public ScheduledExecutorService zzVJ() {
        return this.zzcit;
    }

    protected zzbmv zzXe() {
        return zzbmv.zzced;
    }

    public abstract void zzj(Throwable th);

    public void zzs(Runnable runnable) {
        this.zzcit.execute(runnable);
    }
}
