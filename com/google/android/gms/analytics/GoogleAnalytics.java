package com.google.android.gms.analytics;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application;
import android.app.Application.ActivityLifecycleCallbacks;
import android.content.Context;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.annotation.RequiresPermission;
import android.support.v7.mediarouter.C0308R;
import android.util.Log;
import com.google.android.gms.common.internal.zzac;
import com.google.android.gms.internal.zzrs;
import com.google.android.gms.internal.zzrw;
import com.google.android.gms.internal.zzsq;
import com.google.android.gms.internal.zzsw;
import com.google.android.gms.internal.zzte;
import com.google.android.gms.internal.zztf;
import com.google.android.gms.internal.zzth;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public final class GoogleAnalytics extends zza {
    private static List<Runnable> zzaaF;
    private Set<zza> zzaaG;
    private boolean zzaaH;
    private boolean zzaaI;
    private volatile boolean zzaaJ;
    private boolean zzaaK;
    private boolean zztW;

    interface zza {
        void zzo(Activity activity);

        void zzp(Activity activity);
    }

    @TargetApi(14)
    class zzb implements ActivityLifecycleCallbacks {
        final /* synthetic */ GoogleAnalytics zzaaL;

        zzb(GoogleAnalytics googleAnalytics) {
            this.zzaaL = googleAnalytics;
        }

        public void onActivityCreated(Activity activity, Bundle bundle) {
        }

        public void onActivityDestroyed(Activity activity) {
        }

        public void onActivityPaused(Activity activity) {
        }

        public void onActivityResumed(Activity activity) {
        }

        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }

        public void onActivityStarted(Activity activity) {
            this.zzaaL.zzm(activity);
        }

        public void onActivityStopped(Activity activity) {
            this.zzaaL.zzn(activity);
        }
    }

    static {
        zzaaF = new ArrayList();
    }

    public GoogleAnalytics(zzrw com_google_android_gms_internal_zzrw) {
        super(com_google_android_gms_internal_zzrw);
        this.zzaaG = new HashSet();
    }

    @RequiresPermission(allOf = {"android.permission.INTERNET", "android.permission.ACCESS_NETWORK_STATE"})
    public static GoogleAnalytics getInstance(Context context) {
        return zzrw.zzW(context).zznE();
    }

    public static void zzlW() {
        synchronized (GoogleAnalytics.class) {
            if (zzaaF != null) {
                for (Runnable run : zzaaF) {
                    run.run();
                }
                zzaaF = null;
            }
        }
    }

    private zzrs zzlZ() {
        return zzlM().zzlZ();
    }

    private zzth zzma() {
        return zzlM().zzma();
    }

    public void dispatchLocalHits() {
        zzlZ().zznk();
    }

    @TargetApi(14)
    public void enableAutoActivityReports(Application application) {
        if (VERSION.SDK_INT >= 14 && !this.zzaaH) {
            application.registerActivityLifecycleCallbacks(new zzb(this));
            this.zzaaH = true;
        }
    }

    public boolean getAppOptOut() {
        return this.zzaaJ;
    }

    @Deprecated
    public Logger getLogger() {
        return zzsw.getLogger();
    }

    public void initialize() {
        zzlV();
        this.zztW = true;
    }

    public boolean isDryRunEnabled() {
        return this.zzaaI;
    }

    public boolean isInitialized() {
        return this.zztW;
    }

    public Tracker newTracker(int i) {
        Tracker tracker;
        synchronized (this) {
            tracker = new Tracker(zzlM(), null, null);
            if (i > 0) {
                zztf com_google_android_gms_internal_zztf = (zztf) new zzte(zzlM()).zzaG(i);
                if (com_google_android_gms_internal_zztf != null) {
                    tracker.zza(com_google_android_gms_internal_zztf);
                }
            }
            tracker.initialize();
        }
        return tracker;
    }

    public Tracker newTracker(String str) {
        Tracker tracker;
        synchronized (this) {
            tracker = new Tracker(zzlM(), str, null);
            tracker.initialize();
        }
        return tracker;
    }

    public void reportActivityStart(Activity activity) {
        if (!this.zzaaH) {
            zzm(activity);
        }
    }

    public void reportActivityStop(Activity activity) {
        if (!this.zzaaH) {
            zzn(activity);
        }
    }

    public void setAppOptOut(boolean z) {
        this.zzaaJ = z;
        if (this.zzaaJ) {
            zzlZ().zznj();
        }
    }

    public void setDryRun(boolean z) {
        this.zzaaI = z;
    }

    public void setLocalDispatchPeriod(int i) {
        zzlZ().setLocalDispatchPeriod(i);
    }

    @Deprecated
    public void setLogger(Logger logger) {
        zzsw.setLogger(logger);
        if (!this.zzaaK) {
            String str = (String) zzsq.zzaek.get();
            Log.i((String) zzsq.zzaek.get(), new StringBuilder(String.valueOf(str).length() + C0308R.styleable.AppCompatTheme_spinnerStyle).append("GoogleAnalytics.setLogger() is deprecated. To enable debug logging, please run:\nadb shell setprop log.tag.").append(str).append(" DEBUG").toString());
            this.zzaaK = true;
        }
    }

    void zza(zza com_google_android_gms_analytics_GoogleAnalytics_zza) {
        this.zzaaG.add(com_google_android_gms_analytics_GoogleAnalytics_zza);
        Context context = zzlM().getContext();
        if (context instanceof Application) {
            enableAutoActivityReports((Application) context);
        }
    }

    void zzb(zza com_google_android_gms_analytics_GoogleAnalytics_zza) {
        this.zzaaG.remove(com_google_android_gms_analytics_GoogleAnalytics_zza);
    }

    void zzlV() {
        zzth zzma = zzma();
        zzma.zzpi();
        if (zzma.zzpm()) {
            setDryRun(zzma.zzpn());
        }
        zzma.zzpi();
    }

    public String zzlX() {
        zzac.zzdo("getClientId can not be called from the main thread");
        return zzlM().zznH().zzop();
    }

    void zzlY() {
        zzlZ().zznl();
    }

    void zzm(Activity activity) {
        for (zza zzo : this.zzaaG) {
            zzo.zzo(activity);
        }
    }

    void zzn(Activity activity) {
        for (zza zzp : this.zzaaG) {
            zzp.zzp(activity);
        }
    }
}
