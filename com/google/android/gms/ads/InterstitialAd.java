package com.google.android.gms.ads;

import android.content.Context;
import android.support.annotation.RequiresPermission;
import com.google.android.gms.ads.purchase.InAppPurchaseListener;
import com.google.android.gms.ads.purchase.PlayStorePurchaseListener;
import com.google.android.gms.ads.reward.RewardedVideoAdListener;
import com.google.android.gms.internal.zzdt;
import com.google.android.gms.internal.zzfa;

public final class InterstitialAd {
    private final zzfa zzrL;

    public InterstitialAd(Context context) {
        this.zzrL = new zzfa(context);
    }

    public AdListener getAdListener() {
        return this.zzrL.getAdListener();
    }

    public String getAdUnitId() {
        return this.zzrL.getAdUnitId();
    }

    public InAppPurchaseListener getInAppPurchaseListener() {
        return this.zzrL.getInAppPurchaseListener();
    }

    public String getMediationAdapterClassName() {
        return this.zzrL.getMediationAdapterClassName();
    }

    public boolean isLoaded() {
        return this.zzrL.isLoaded();
    }

    public boolean isLoading() {
        return this.zzrL.isLoading();
    }

    @RequiresPermission("android.permission.INTERNET")
    public void loadAd(AdRequest adRequest) {
        this.zzrL.zza(adRequest.zzbq());
    }

    public void setAdListener(AdListener adListener) {
        this.zzrL.setAdListener(adListener);
        if (adListener != null && (adListener instanceof zzdt)) {
            this.zzrL.zza((zzdt) adListener);
        } else if (adListener == null) {
            this.zzrL.zza(null);
        }
    }

    public void setAdUnitId(String str) {
        this.zzrL.setAdUnitId(str);
    }

    public void setInAppPurchaseListener(InAppPurchaseListener inAppPurchaseListener) {
        this.zzrL.setInAppPurchaseListener(inAppPurchaseListener);
    }

    public void setPlayStorePurchaseParams(PlayStorePurchaseListener playStorePurchaseListener, String str) {
        this.zzrL.setPlayStorePurchaseParams(playStorePurchaseListener, str);
    }

    public void setRewardedVideoAdListener(RewardedVideoAdListener rewardedVideoAdListener) {
        this.zzrL.setRewardedVideoAdListener(rewardedVideoAdListener);
    }

    public void show() {
        this.zzrL.show();
    }

    public void zzd(boolean z) {
        this.zzrL.zzd(z);
    }
}
