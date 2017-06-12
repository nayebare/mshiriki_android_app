package com.google.android.gms.ads.doubleclick;

import android.content.Context;
import android.support.annotation.RequiresPermission;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.Correlator;
import com.google.android.gms.internal.zzfa;

public final class PublisherInterstitialAd {
    private final zzfa zzrL;

    public PublisherInterstitialAd(Context context) {
        this.zzrL = new zzfa(context, this);
    }

    public AdListener getAdListener() {
        return this.zzrL.getAdListener();
    }

    public String getAdUnitId() {
        return this.zzrL.getAdUnitId();
    }

    public AppEventListener getAppEventListener() {
        return this.zzrL.getAppEventListener();
    }

    public String getMediationAdapterClassName() {
        return this.zzrL.getMediationAdapterClassName();
    }

    public OnCustomRenderedAdLoadedListener getOnCustomRenderedAdLoadedListener() {
        return this.zzrL.getOnCustomRenderedAdLoadedListener();
    }

    public boolean isLoaded() {
        return this.zzrL.isLoaded();
    }

    public boolean isLoading() {
        return this.zzrL.isLoading();
    }

    @RequiresPermission("android.permission.INTERNET")
    public void loadAd(PublisherAdRequest publisherAdRequest) {
        this.zzrL.zza(publisherAdRequest.zzbq());
    }

    public void setAdListener(AdListener adListener) {
        this.zzrL.setAdListener(adListener);
    }

    public void setAdUnitId(String str) {
        this.zzrL.setAdUnitId(str);
    }

    public void setAppEventListener(AppEventListener appEventListener) {
        this.zzrL.setAppEventListener(appEventListener);
    }

    public void setCorrelator(Correlator correlator) {
        this.zzrL.setCorrelator(correlator);
    }

    public void setOnCustomRenderedAdLoadedListener(OnCustomRenderedAdLoadedListener onCustomRenderedAdLoadedListener) {
        this.zzrL.setOnCustomRenderedAdLoadedListener(onCustomRenderedAdLoadedListener);
    }

    public void show() {
        this.zzrL.show();
    }
}
