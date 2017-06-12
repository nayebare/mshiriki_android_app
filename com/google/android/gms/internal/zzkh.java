package com.google.android.gms.internal;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.customtabs.CustomTabsIntent;
import android.support.customtabs.CustomTabsIntent.Builder;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel;
import com.google.android.gms.ads.internal.overlay.zzc;
import com.google.android.gms.ads.internal.zzv;
import com.google.android.gms.ads.mediation.MediationAdRequest;
import com.google.android.gms.ads.mediation.MediationInterstitialAdapter;
import com.google.android.gms.ads.mediation.MediationInterstitialListener;

@zzmb
public class zzkh implements MediationInterstitialAdapter {
    private Uri mUri;
    private Activity zzLg;
    private zzgl zzLh;
    private MediationInterstitialListener zzLi;

    public static boolean zzo(Context context) {
        return zzgl.zzn(context);
    }

    public void onDestroy() {
        zzpy.zzbc("Destroying AdMobCustomTabsAdapter adapter.");
        try {
            this.zzLh.zzd(this.zzLg);
        } catch (Throwable e) {
            zzpy.zzb("Exception while unbinding from CustomTabsService.", e);
        }
    }

    public void onPause() {
        zzpy.zzbc("Pausing AdMobCustomTabsAdapter adapter.");
    }

    public void onResume() {
        zzpy.zzbc("Resuming AdMobCustomTabsAdapter adapter.");
    }

    public void requestInterstitialAd(Context context, MediationInterstitialListener mediationInterstitialListener, Bundle bundle, MediationAdRequest mediationAdRequest, Bundle bundle2) {
        this.zzLi = mediationInterstitialListener;
        if (this.zzLi == null) {
            zzpy.zzbe("Listener not set for mediation. Returning.");
        } else if (!(context instanceof Activity)) {
            zzpy.zzbe("AdMobCustomTabs can only work with Activity context. Bailing out.");
            this.zzLi.onAdFailedToLoad(this, 0);
        } else if (zzo(context)) {
            Object string = bundle.getString("tab_url");
            if (TextUtils.isEmpty(string)) {
                zzpy.zzbe("The tab_url retrieved from mediation metadata is empty. Bailing out.");
                this.zzLi.onAdFailedToLoad(this, 0);
                return;
            }
            this.zzLg = (Activity) context;
            this.mUri = Uri.parse(string);
            this.zzLh = new zzgl();
            this.zzLh.zza(new 1(this));
            this.zzLh.zze(this.zzLg);
            this.zzLi.onAdLoaded(this);
        } else {
            zzpy.zzbe("Default browser does not support custom tabs. Bailing out.");
            this.zzLi.onAdFailedToLoad(this, 0);
        }
    }

    public void showInterstitial() {
        CustomTabsIntent build = new Builder(this.zzLh.zzfC()).build();
        build.intent.setData(this.mUri);
        zzpi.zzWR.post(new 3(this, new AdOverlayInfoParcel(new zzc(build.intent), null, new 2(this), null, new zzqa(0, 0, false))));
        zzv.zzcN().zzG(false);
    }
}
