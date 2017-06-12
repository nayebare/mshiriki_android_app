package com.google.firebase.crash;

import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import android.support.annotation.Keep;
import android.util.Log;
import com.github.mikephil.charting.BuildConfig;
import com.google.android.gms.dynamic.zze;
import com.google.android.gms.internal.zzbkn;
import com.google.android.gms.internal.zzbko;
import com.google.android.gms.internal.zzbkp;
import com.google.android.gms.internal.zzbkr;
import com.google.android.gms.internal.zzbks;
import com.google.android.gms.internal.zzbkt;
import com.google.android.gms.internal.zzbku;
import com.google.firebase.FirebaseApp;
import com.google.firebase.iid.zzc;

public class FirebaseCrash {
    private static final String LOG_TAG;
    private static volatile FirebaseCrash zzbWY;
    private zzbkr zzbWW;
    private zzbkn zzbWX;
    private boolean zzbqB;

    static {
        LOG_TAG = FirebaseCrash.class.getSimpleName();
    }

    FirebaseCrash(FirebaseApp firebaseApp, boolean z) {
        this.zzbqB = z;
        Context applicationContext = firebaseApp.getApplicationContext();
        if (applicationContext == null) {
            Log.w(LOG_TAG, "Application context is missing, disabling api");
            this.zzbqB = false;
        }
        if (this.zzbqB) {
            try {
                zzbkp com_google_android_gms_internal_zzbkp = new zzbkp(firebaseApp.getOptions().getApplicationId(), firebaseApp.getOptions().getApiKey());
                zzbks.zzUT().zzao(applicationContext);
                this.zzbWW = zzbks.zzUT().zzUU();
                this.zzbWW.zza(zze.zzA(applicationContext), com_google_android_gms_internal_zzbkp);
                this.zzbWX = new zzbkn(applicationContext);
                zzUP();
                String str = LOG_TAG;
                String str2 = "FirebaseCrash reporting initialized ";
                String valueOf = String.valueOf(zzbks.zzUT().toString());
                Log.i(str, valueOf.length() != 0 ? str2.concat(valueOf) : new String(str2));
                return;
            } catch (Exception e) {
                str = LOG_TAG;
                str2 = "Failed to initialize crash reporting: ";
                valueOf = String.valueOf(e.getMessage());
                Log.e(str, valueOf.length() != 0 ? str2.concat(valueOf) : new String(str2));
                this.zzbqB = false;
                return;
            }
        }
        Log.i(LOG_TAG, "Crash reporting is disabled");
    }

    @Keep
    @Deprecated
    public static FirebaseCrash getInstance(FirebaseApp firebaseApp) {
        zzbku.initialize(firebaseApp.getApplicationContext());
        FirebaseCrash firebaseCrash = new FirebaseCrash(firebaseApp, ((Boolean) zzbku.zzbXh.get()).booleanValue());
        synchronized (FirebaseCrash.class) {
            if (zzbWY == null) {
                zzbWY = firebaseCrash;
                try {
                    zzbWY.zzUM();
                } catch (zzbko e) {
                    Log.d(LOG_TAG, "Cannot register Firebase Analytics listener since Firebase Crash Reporting is not enabled");
                }
            }
        }
        return firebaseCrash;
    }

    private boolean isEnabled() {
        return this.zzbqB;
    }

    public static void log(String str) {
        try {
            zzUL().zziC(str);
        } catch (zzbko e) {
            Log.v(LOG_TAG, e.getMessage());
        }
    }

    public static void logcat(int i, String str, String str2) {
        try {
            zzUL().zze(i, str, str2);
        } catch (zzbko e) {
            Log.v(LOG_TAG, e.getMessage());
        }
    }

    public static void report(Throwable th) {
        try {
            zzUL().zzh(th);
        } catch (zzbko e) {
            Log.v(LOG_TAG, e.getMessage());
        }
    }

    public static FirebaseCrash zzUL() {
        if (zzbWY == null) {
            synchronized (FirebaseCrash.class) {
                if (zzbWY == null) {
                    zzbWY = getInstance(FirebaseApp.getInstance());
                }
            }
        }
        return zzbWY;
    }

    private void zzUM() throws zzbko {
        if (isEnabled()) {
            this.zzbWX.zzUR();
            return;
        }
        throw new zzbko("Firebase Crash Reporting is disabled.");
    }

    private zzbkr zzUN() {
        return this.zzbWW;
    }

    private static boolean zzUO() {
        return Looper.getMainLooper().getThread().getId() == Thread.currentThread().getId();
    }

    private void zzUP() {
        if (zzUO()) {
            Thread.setDefaultUncaughtExceptionHandler(new zzbkt(Thread.getDefaultUncaughtExceptionHandler(), this));
            return;
        }
        throw new RuntimeException("FirebaseCrash reporting may only be initialized on the main thread (preferably in your app's Application.onCreate)");
    }

    private String zzUQ() {
        return zzc.zzaab().getId();
    }

    public static void zza(String str, long j, Bundle bundle) {
        try {
            zzUL().zzb(str, j, bundle);
        } catch (zzbko e) {
            Log.v(LOG_TAG, e.getMessage());
        }
    }

    public void zzb(String str, long j, Bundle bundle) throws zzbko {
        if (isEnabled()) {
            zzbkr zzUN = zzUN();
            if (zzUN != null && str != null) {
                try {
                    zzUN.zzb(str, j, bundle);
                    return;
                } catch (Throwable e) {
                    Log.e(LOG_TAG, "log remoting failed", e);
                    return;
                }
            }
            return;
        }
        throw new zzbko("Firebase Crash Reporting is disabled.");
    }

    public void zze(int i, String str, String str2) throws zzbko {
        if (str2 != null) {
            if (str == null) {
                str = BuildConfig.FLAVOR;
            }
            Log.println(i, str, str2);
            zziC(str2);
        }
    }

    public void zzh(Throwable th) throws zzbko {
        if (isEnabled()) {
            zzbkr zzUN = zzUN();
            if (zzUN != null && th != null) {
                this.zzbWX.zza(false, System.currentTimeMillis());
                try {
                    zzUN.zziD(zzUQ());
                    zzUN.zzN(zze.zzA(th));
                    return;
                } catch (Throwable e) {
                    Log.e(LOG_TAG, "report remoting failed", e);
                    return;
                }
            }
            return;
        }
        throw new zzbko("Firebase Crash Reporting is disabled.");
    }

    public void zzi(Throwable th) throws zzbko {
        if (isEnabled()) {
            zzbkr zzUN = zzUN();
            if (zzUN != null && th != null) {
                try {
                    this.zzbWX.zza(true, System.currentTimeMillis());
                    try {
                        Thread.sleep(200);
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                    zzUN.zziD(zzUQ());
                    zzUN.zzO(zze.zzA(th));
                    return;
                } catch (Throwable e2) {
                    Log.e(LOG_TAG, "report remoting failed", e2);
                    return;
                }
            }
            return;
        }
        throw new zzbko("Firebase Crash Reporting is disabled.");
    }

    public void zziC(String str) throws zzbko {
        if (isEnabled()) {
            zzbkr zzUN = zzUN();
            if (zzUN != null && str != null) {
                try {
                    zzUN.log(str);
                    return;
                } catch (Throwable e) {
                    Log.e(LOG_TAG, "log remoting failed", e);
                    return;
                }
            }
            return;
        }
        throw new zzbko("Firebase Crash Reporting is disabled.");
    }
}
