package com.google.android.gms.ads.mediation.customevent;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.mediation.MediationAdRequest;
import com.google.android.gms.ads.mediation.MediationBannerAdapter;
import com.google.android.gms.ads.mediation.MediationBannerListener;
import com.google.android.gms.ads.mediation.MediationInterstitialAdapter;
import com.google.android.gms.ads.mediation.MediationInterstitialListener;
import com.google.android.gms.ads.mediation.MediationNativeAdapter;
import com.google.android.gms.ads.mediation.MediationNativeListener;
import com.google.android.gms.ads.mediation.NativeAdMapper;
import com.google.android.gms.ads.mediation.NativeMediationAdRequest;
import com.google.android.gms.ads.reward.mediation.MediationRewardedVideoAdAdapter;
import com.google.android.gms.common.annotation.KeepName;
import com.google.android.gms.internal.zzpy;

@KeepName
public final class CustomEventAdapter implements MediationBannerAdapter, MediationInterstitialAdapter, MediationNativeAdapter {
    CustomEventBanner zzZQ;
    CustomEventInterstitial zzZR;
    CustomEventNative zzZS;
    private View zzcV;

    static final class zza implements CustomEventBannerListener {
        private final CustomEventAdapter zzZT;
        private final MediationBannerListener zzcN;

        public zza(CustomEventAdapter customEventAdapter, MediationBannerListener mediationBannerListener) {
            this.zzZT = customEventAdapter;
            this.zzcN = mediationBannerListener;
        }

        public void onAdClicked() {
            zzpy.zzbc("Custom event adapter called onAdClicked.");
            this.zzcN.onAdClicked(this.zzZT);
        }

        public void onAdClosed() {
            zzpy.zzbc("Custom event adapter called onAdClosed.");
            this.zzcN.onAdClosed(this.zzZT);
        }

        public void onAdFailedToLoad(int i) {
            zzpy.zzbc("Custom event adapter called onAdFailedToLoad.");
            this.zzcN.onAdFailedToLoad(this.zzZT, i);
        }

        public void onAdLeftApplication() {
            zzpy.zzbc("Custom event adapter called onAdLeftApplication.");
            this.zzcN.onAdLeftApplication(this.zzZT);
        }

        public void onAdLoaded(View view) {
            zzpy.zzbc("Custom event adapter called onAdLoaded.");
            this.zzZT.zza(view);
            this.zzcN.onAdLoaded(this.zzZT);
        }

        public void onAdOpened() {
            zzpy.zzbc("Custom event adapter called onAdOpened.");
            this.zzcN.onAdOpened(this.zzZT);
        }
    }

    class zzb implements CustomEventInterstitialListener {
        private final CustomEventAdapter zzZT;
        final /* synthetic */ CustomEventAdapter zzZU;
        private final MediationInterstitialListener zzcO;

        public zzb(CustomEventAdapter customEventAdapter, CustomEventAdapter customEventAdapter2, MediationInterstitialListener mediationInterstitialListener) {
            this.zzZU = customEventAdapter;
            this.zzZT = customEventAdapter2;
            this.zzcO = mediationInterstitialListener;
        }

        public void onAdClicked() {
            zzpy.zzbc("Custom event adapter called onAdClicked.");
            this.zzcO.onAdClicked(this.zzZT);
        }

        public void onAdClosed() {
            zzpy.zzbc("Custom event adapter called onAdClosed.");
            this.zzcO.onAdClosed(this.zzZT);
        }

        public void onAdFailedToLoad(int i) {
            zzpy.zzbc("Custom event adapter called onFailedToReceiveAd.");
            this.zzcO.onAdFailedToLoad(this.zzZT, i);
        }

        public void onAdLeftApplication() {
            zzpy.zzbc("Custom event adapter called onAdLeftApplication.");
            this.zzcO.onAdLeftApplication(this.zzZT);
        }

        public void onAdLoaded() {
            zzpy.zzbc("Custom event adapter called onReceivedAd.");
            this.zzcO.onAdLoaded(this.zzZU);
        }

        public void onAdOpened() {
            zzpy.zzbc("Custom event adapter called onAdOpened.");
            this.zzcO.onAdOpened(this.zzZT);
        }
    }

    static class zzc implements CustomEventNativeListener {
        private final CustomEventAdapter zzZT;
        private final MediationNativeListener zzcP;

        public zzc(CustomEventAdapter customEventAdapter, MediationNativeListener mediationNativeListener) {
            this.zzZT = customEventAdapter;
            this.zzcP = mediationNativeListener;
        }

        public void onAdClicked() {
            zzpy.zzbc("Custom event adapter called onAdClicked.");
            this.zzcP.onAdClicked(this.zzZT);
        }

        public void onAdClosed() {
            zzpy.zzbc("Custom event adapter called onAdClosed.");
            this.zzcP.onAdClosed(this.zzZT);
        }

        public void onAdFailedToLoad(int i) {
            zzpy.zzbc("Custom event adapter called onAdFailedToLoad.");
            this.zzcP.onAdFailedToLoad(this.zzZT, i);
        }

        public void onAdImpression() {
            zzpy.zzbc("Custom event adapter called onAdImpression.");
            this.zzcP.onAdImpression(this.zzZT);
        }

        public void onAdLeftApplication() {
            zzpy.zzbc("Custom event adapter called onAdLeftApplication.");
            this.zzcP.onAdLeftApplication(this.zzZT);
        }

        public void onAdLoaded(NativeAdMapper nativeAdMapper) {
            zzpy.zzbc("Custom event adapter called onAdLoaded.");
            this.zzcP.onAdLoaded(this.zzZT, nativeAdMapper);
        }

        public void onAdOpened() {
            zzpy.zzbc("Custom event adapter called onAdOpened.");
            this.zzcP.onAdOpened(this.zzZT);
        }
    }

    private void zza(View view) {
        this.zzcV = view;
    }

    private static <T> T zzj(String str) {
        try {
            return Class.forName(str).newInstance();
        } catch (Throwable th) {
            String valueOf = String.valueOf(th.getMessage());
            zzpy.zzbe(new StringBuilder((String.valueOf(str).length() + 46) + String.valueOf(valueOf).length()).append("Could not instantiate custom event adapter: ").append(str).append(". ").append(valueOf).toString());
            return null;
        }
    }

    public View getBannerView() {
        return this.zzcV;
    }

    public void onDestroy() {
        if (this.zzZQ != null) {
            this.zzZQ.onDestroy();
        }
        if (this.zzZR != null) {
            this.zzZR.onDestroy();
        }
        if (this.zzZS != null) {
            this.zzZS.onDestroy();
        }
    }

    public void onPause() {
        if (this.zzZQ != null) {
            this.zzZQ.onPause();
        }
        if (this.zzZR != null) {
            this.zzZR.onPause();
        }
        if (this.zzZS != null) {
            this.zzZS.onPause();
        }
    }

    public void onResume() {
        if (this.zzZQ != null) {
            this.zzZQ.onResume();
        }
        if (this.zzZR != null) {
            this.zzZR.onResume();
        }
        if (this.zzZS != null) {
            this.zzZS.onResume();
        }
    }

    public void requestBannerAd(Context context, MediationBannerListener mediationBannerListener, Bundle bundle, AdSize adSize, MediationAdRequest mediationAdRequest, Bundle bundle2) {
        this.zzZQ = (CustomEventBanner) zzj(bundle.getString("class_name"));
        if (this.zzZQ == null) {
            mediationBannerListener.onAdFailedToLoad(this, 0);
            return;
        }
        this.zzZQ.requestBannerAd(context, new zza(this, mediationBannerListener), bundle.getString(MediationRewardedVideoAdAdapter.CUSTOM_EVENT_SERVER_PARAMETER_FIELD), adSize, mediationAdRequest, bundle2 == null ? null : bundle2.getBundle(bundle.getString("class_name")));
    }

    public void requestInterstitialAd(Context context, MediationInterstitialListener mediationInterstitialListener, Bundle bundle, MediationAdRequest mediationAdRequest, Bundle bundle2) {
        this.zzZR = (CustomEventInterstitial) zzj(bundle.getString("class_name"));
        if (this.zzZR == null) {
            mediationInterstitialListener.onAdFailedToLoad(this, 0);
            return;
        }
        this.zzZR.requestInterstitialAd(context, zza(mediationInterstitialListener), bundle.getString(MediationRewardedVideoAdAdapter.CUSTOM_EVENT_SERVER_PARAMETER_FIELD), mediationAdRequest, bundle2 == null ? null : bundle2.getBundle(bundle.getString("class_name")));
    }

    public void requestNativeAd(Context context, MediationNativeListener mediationNativeListener, Bundle bundle, NativeMediationAdRequest nativeMediationAdRequest, Bundle bundle2) {
        this.zzZS = (CustomEventNative) zzj(bundle.getString("class_name"));
        if (this.zzZS == null) {
            mediationNativeListener.onAdFailedToLoad(this, 0);
            return;
        }
        this.zzZS.requestNativeAd(context, new zzc(this, mediationNativeListener), bundle.getString(MediationRewardedVideoAdAdapter.CUSTOM_EVENT_SERVER_PARAMETER_FIELD), nativeMediationAdRequest, bundle2 == null ? null : bundle2.getBundle(bundle.getString("class_name")));
    }

    public void showInterstitial() {
        this.zzZR.showInterstitial();
    }

    zzb zza(MediationInterstitialListener mediationInterstitialListener) {
        return new zzb(this, this, mediationInterstitialListener);
    }
}
