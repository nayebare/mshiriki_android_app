package com.google.android.gms.internal;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.support.annotation.VisibleForTesting;
import android.widget.FrameLayout;
import com.google.android.gms.internal.zzes.zza;

@zzmb
public class zzeg {
    private final Object zzrN;
    private zzes zzzs;
    private final zzdx zzzt;
    private final zzdw zzzu;
    private final zzfd zzzv;
    private final zzhn zzzw;
    private final zznv zzzx;
    private final zzlf zzzy;
    private final zzkq zzzz;

    public zzeg(zzdx com_google_android_gms_internal_zzdx, zzdw com_google_android_gms_internal_zzdw, zzfd com_google_android_gms_internal_zzfd, zzhn com_google_android_gms_internal_zzhn, zznv com_google_android_gms_internal_zznv, zzlf com_google_android_gms_internal_zzlf, zzkq com_google_android_gms_internal_zzkq) {
        this.zzrN = new Object();
        this.zzzt = com_google_android_gms_internal_zzdx;
        this.zzzu = com_google_android_gms_internal_zzdw;
        this.zzzv = com_google_android_gms_internal_zzfd;
        this.zzzw = com_google_android_gms_internal_zzhn;
        this.zzzx = com_google_android_gms_internal_zznv;
        this.zzzy = com_google_android_gms_internal_zzlf;
        this.zzzz = com_google_android_gms_internal_zzkq;
    }

    private static boolean zza(Activity activity, String str) {
        Intent intent = activity.getIntent();
        if (intent.hasExtra(str)) {
            return intent.getBooleanExtra(str, false);
        }
        zzpy.m25e("useClientJar flag not found in activity intent extras.");
        return false;
    }

    private void zzc(Context context, String str) {
        Bundle bundle = new Bundle();
        bundle.putString("action", "no_ads_fallback");
        bundle.putString("flow", str);
        zzeh.zzeO().zza(context, null, "gmob-apps", bundle, true);
    }

    @Nullable
    private static zzes zzeB() {
        try {
            Object newInstance = zzeg.class.getClassLoader().loadClass("com.google.android.gms.ads.internal.ClientApi").newInstance();
            if (newInstance instanceof IBinder) {
                return zza.asInterface((IBinder) newInstance);
            }
            zzpy.zzbe("ClientApi class is not an instance of IBinder");
            return null;
        } catch (Throwable e) {
            zzpy.zzc("Failed to instantiate ClientApi class.", e);
            return null;
        }
    }

    @Nullable
    private zzes zzeC() {
        zzes com_google_android_gms_internal_zzes;
        synchronized (this.zzrN) {
            if (this.zzzs == null) {
                this.zzzs = zzeB();
            }
            com_google_android_gms_internal_zzes = this.zzzs;
        }
        return com_google_android_gms_internal_zzes;
    }

    public zzep zza(Context context, zzec com_google_android_gms_internal_zzec, String str) {
        return (zzep) zza(context, false, new 2(this, context, com_google_android_gms_internal_zzec, str));
    }

    public zzep zza(Context context, zzec com_google_android_gms_internal_zzec, String str, zzjs com_google_android_gms_internal_zzjs) {
        return (zzep) zza(context, false, new 1(this, context, com_google_android_gms_internal_zzec, str, com_google_android_gms_internal_zzjs));
    }

    public zzhb zza(Context context, FrameLayout frameLayout, FrameLayout frameLayout2) {
        return (zzhb) zza(context, false, new 6(this, frameLayout, frameLayout2, context));
    }

    public zznr zza(Context context, zzjs com_google_android_gms_internal_zzjs) {
        return (zznr) zza(context, false, new 7(this, context, com_google_android_gms_internal_zzjs));
    }

    @VisibleForTesting
    <T> T zza(Context context, boolean z, zza<T> com_google_android_gms_internal_zzeg_zza_T) {
        if (!(z || zzeh.zzeO().zzP(context))) {
            zzpy.zzbc("Google Play Services is not available");
            z = true;
        }
        T zzeL;
        if (z) {
            zzeL = com_google_android_gms_internal_zzeg_zza_T.zzeL();
            return zzeL == null ? com_google_android_gms_internal_zzeg_zza_T.zzeM() : zzeL;
        } else {
            zzeL = com_google_android_gms_internal_zzeg_zza_T.zzeM();
            return zzeL == null ? com_google_android_gms_internal_zzeg_zza_T.zzeL() : zzeL;
        }
    }

    public zzen zzb(Context context, String str, zzjs com_google_android_gms_internal_zzjs) {
        return (zzen) zza(context, false, new 4(this, context, str, com_google_android_gms_internal_zzjs));
    }

    public zzep zzb(Context context, zzec com_google_android_gms_internal_zzec, String str, zzjs com_google_android_gms_internal_zzjs) {
        return (zzep) zza(context, false, new 3(this, context, com_google_android_gms_internal_zzec, str, com_google_android_gms_internal_zzjs));
    }

    @Nullable
    public zzla zzb(Activity activity) {
        return (zzla) zza((Context) activity, zza(activity, "com.google.android.gms.ads.internal.purchase.useClientJar"), new 8(this, activity));
    }

    @Nullable
    public zzkr zzc(Activity activity) {
        return (zzkr) zza((Context) activity, zza(activity, "com.google.android.gms.ads.internal.overlay.useClientJar"), new 9(this, activity));
    }

    public zzeu zzk(Context context) {
        return (zzeu) zza(context, false, new 5(this, context));
    }
}
