package com.google.android.gms.internal;

import android.content.Context;
import android.net.Uri.Builder;
import android.os.Build.VERSION;
import android.os.Looper;
import android.text.TextUtils;
import com.github.mikephil.charting.BuildConfig;
import com.google.android.gms.ads.internal.zzv;
import com.google.android.gms.fitness.FitnessActivities;
import com.google.android.gms.internal.zzma.zza;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.WeakHashMap;

@zzmb
public class zzlz implements zzma {
    private static zzma zzQJ;
    private static final Object zztU;
    private final Object zzQK;
    private final String zzQL;
    private final WeakHashMap<Thread, Boolean> zzQM;
    private final zzqa zztZ;

    static {
        zztU = new Object();
        zzQJ = null;
    }

    zzlz(String str, zzqa com_google_android_gms_internal_zzqa) {
        this.zzQK = new Object();
        this.zzQM = new WeakHashMap();
        this.zzQL = str;
        this.zztZ = com_google_android_gms_internal_zzqa;
        zziW();
        zziV();
    }

    public static zzma zzb(Context context, zzqa com_google_android_gms_internal_zzqa) {
        synchronized (zztU) {
            if (zzQJ == null) {
                if (((Boolean) zzfx.zzAW.get()).booleanValue()) {
                    String str = FitnessActivities.UNKNOWN;
                    try {
                        str = context.getApplicationContext().getPackageName();
                    } catch (Throwable th) {
                        zzpy.zzbe("Cannot obtain package name, proceeding.");
                    }
                    zzQJ = new zzlz(str, com_google_android_gms_internal_zzqa);
                } else {
                    zzQJ = new zza();
                }
            }
        }
        return zzQJ;
    }

    private Throwable zzd(Throwable th) {
        if (((Boolean) zzfx.zzAX.get()).booleanValue()) {
            return th;
        }
        LinkedList linkedList = new LinkedList();
        while (th != null) {
            linkedList.push(th);
            th = th.getCause();
        }
        Throwable th2 = null;
        while (!linkedList.isEmpty()) {
            Throwable th3;
            Throwable th4 = (Throwable) linkedList.pop();
            StackTraceElement[] stackTrace = th4.getStackTrace();
            ArrayList arrayList = new ArrayList();
            arrayList.add(new StackTraceElement(th4.getClass().getName(), "<filtered>", "<filtered>", 1));
            int i = 0;
            for (StackTraceElement stackTraceElement : stackTrace) {
                if (zzaH(stackTraceElement.getClassName())) {
                    arrayList.add(stackTraceElement);
                    i = 1;
                } else if (zzaI(stackTraceElement.getClassName())) {
                    arrayList.add(stackTraceElement);
                } else {
                    arrayList.add(new StackTraceElement("<filtered>", "<filtered>", "<filtered>", 1));
                }
            }
            if (i != 0) {
                th3 = th2 == null ? new Throwable(th4.getMessage()) : new Throwable(th4.getMessage(), th2);
                th3.setStackTrace((StackTraceElement[]) arrayList.toArray(new StackTraceElement[0]));
            } else {
                th3 = th2;
            }
            th2 = th3;
        }
        return th2;
    }

    private void zziV() {
        Thread.setDefaultUncaughtExceptionHandler(new 1(this, Thread.getDefaultUncaughtExceptionHandler()));
    }

    private void zziW() {
        zza(Looper.getMainLooper().getThread());
    }

    String zza(Class cls, Throwable th, String str) {
        Writer stringWriter = new StringWriter();
        th.printStackTrace(new PrintWriter(stringWriter));
        return new Builder().scheme("https").path("//pagead2.googlesyndication.com/pagead/gen_204").appendQueryParameter("id", "gmob-apps-report-exception").appendQueryParameter("os", VERSION.RELEASE).appendQueryParameter("api", String.valueOf(VERSION.SDK_INT)).appendQueryParameter("device", zzv.zzcJ().zzkm()).appendQueryParameter("js", this.zztZ.zzaZ).appendQueryParameter("appid", this.zzQL).appendQueryParameter("exceptiontype", cls.getName()).appendQueryParameter("stacktrace", stringWriter.toString()).appendQueryParameter("eids", TextUtils.join(",", zzfx.zzfn())).appendQueryParameter("exceptionkey", str).appendQueryParameter("cl", "139965458").appendQueryParameter("rc", "dev").toString();
    }

    public void zza(Thread thread) {
        if (thread != null) {
            synchronized (this.zzQK) {
                this.zzQM.put(thread, Boolean.valueOf(true));
            }
            thread.setUncaughtExceptionHandler(new 2(this, thread.getUncaughtExceptionHandler()));
        }
    }

    protected void zza(Thread thread, Throwable th) {
        if (zzb(th)) {
            zzc(th);
        }
    }

    public void zza(Throwable th, String str) {
        Throwable zzd = zzd(th);
        if (zzd != null) {
            Class cls = th.getClass();
            List arrayList = new ArrayList();
            arrayList.add(zza(cls, zzd, str));
            zzv.zzcJ().zza(arrayList, zzv.zzcN().zzjQ());
        }
    }

    protected boolean zzaH(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (str.startsWith((String) zzfx.zzAY.get())) {
            return true;
        }
        try {
            return Class.forName(str).isAnnotationPresent(zzmb.class);
        } catch (Throwable e) {
            Throwable th = e;
            String str2 = "Fail to check class type for class ";
            String valueOf = String.valueOf(str);
            zzpy.zza(valueOf.length() != 0 ? str2.concat(valueOf) : new String(str2), th);
            return false;
        }
    }

    protected boolean zzaI(String str) {
        return TextUtils.isEmpty(str) ? false : str.startsWith("android.") || str.startsWith("java.");
    }

    protected boolean zzb(Throwable th) {
        boolean z = true;
        if (th == null) {
            return false;
        }
        boolean z2 = false;
        boolean z3 = false;
        while (th != null) {
            for (StackTraceElement stackTraceElement : th.getStackTrace()) {
                if (zzaH(stackTraceElement.getClassName())) {
                    z3 = true;
                }
                if (getClass().getName().equals(stackTraceElement.getClassName())) {
                    z2 = true;
                }
            }
            th = th.getCause();
        }
        if (!z3 || r2) {
            z = false;
        }
        return z;
    }

    public void zzc(Throwable th) {
        zza(th, BuildConfig.FLAVOR);
    }
}
