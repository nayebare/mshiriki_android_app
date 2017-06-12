package com.google.ads.mediation.customevent;

import android.app.Activity;
import android.view.View;
import com.google.ads.AdRequest.ErrorCode;
import com.google.ads.AdSize;
import com.google.ads.mediation.MediationAdRequest;
import com.google.ads.mediation.MediationBannerAdapter;
import com.google.ads.mediation.MediationBannerListener;
import com.google.ads.mediation.MediationInterstitialAdapter;
import com.google.ads.mediation.MediationInterstitialListener;
import com.google.android.gms.ads.mediation.customevent.CustomEventExtras;
import com.google.android.gms.common.annotation.KeepName;
import com.google.android.gms.internal.zzpy;

@KeepName
public final class CustomEventAdapter implements MediationBannerAdapter<CustomEventExtras, CustomEventServerParameters>, MediationInterstitialAdapter<CustomEventExtras, CustomEventServerParameters> {
    private View zzcV;
    CustomEventBanner zzcW;
    CustomEventInterstitial zzcX;

    static final class zza implements CustomEventBannerListener {
        private final CustomEventAdapter zzcY;
        private final MediationBannerListener zzcZ;

        public zza(CustomEventAdapter customEventAdapter, MediationBannerListener mediationBannerListener) {
            this.zzcY = customEventAdapter;
            this.zzcZ = mediationBannerListener;
        }

        public void onClick() {
            zzpy.zzbc("Custom event adapter called onFailedToReceiveAd.");
            this.zzcZ.onClick(this.zzcY);
        }

        public void onDismissScreen() {
            zzpy.zzbc("Custom event adapter called onFailedToReceiveAd.");
            this.zzcZ.onDismissScreen(this.zzcY);
        }

        public void onFailedToReceiveAd() {
            zzpy.zzbc("Custom event adapter called onFailedToReceiveAd.");
            this.zzcZ.onFailedToReceiveAd(this.zzcY, ErrorCode.NO_FILL);
        }

        public void onLeaveApplication() {
            zzpy.zzbc("Custom event adapter called onFailedToReceiveAd.");
            this.zzcZ.onLeaveApplication(this.zzcY);
        }

        public void onPresentScreen() {
            zzpy.zzbc("Custom event adapter called onFailedToReceiveAd.");
            this.zzcZ.onPresentScreen(this.zzcY);
        }

        public void onReceivedAd(View view) {
            zzpy.zzbc("Custom event adapter called onReceivedAd.");
            this.zzcY.zza(view);
            this.zzcZ.onReceivedAd(this.zzcY);
        }
    }

    class zzb implements CustomEventInterstitialListener {
        private final CustomEventAdapter zzcY;
        private final MediationInterstitialListener zzda;
        final /* synthetic */ CustomEventAdapter zzdb;

        public zzb(CustomEventAdapter customEventAdapter, CustomEventAdapter customEventAdapter2, MediationInterstitialListener mediationInterstitialListener) {
            this.zzdb = customEventAdapter;
            this.zzcY = customEventAdapter2;
            this.zzda = mediationInterstitialListener;
        }

        public void onDismissScreen() {
            zzpy.zzbc("Custom event adapter called onDismissScreen.");
            this.zzda.onDismissScreen(this.zzcY);
        }

        public void onFailedToReceiveAd() {
            zzpy.zzbc("Custom event adapter called onFailedToReceiveAd.");
            this.zzda.onFailedToReceiveAd(this.zzcY, ErrorCode.NO_FILL);
        }

        public void onLeaveApplication() {
            zzpy.zzbc("Custom event adapter called onLeaveApplication.");
            this.zzda.onLeaveApplication(this.zzcY);
        }

        public void onPresentScreen() {
            zzpy.zzbc("Custom event adapter called onPresentScreen.");
            this.zzda.onPresentScreen(this.zzcY);
        }

        public void onReceivedAd() {
            zzpy.zzbc("Custom event adapter called onReceivedAd.");
            this.zzda.onReceivedAd(this.zzdb);
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

    public void destroy() {
        if (this.zzcW != null) {
            this.zzcW.destroy();
        }
        if (this.zzcX != null) {
            this.zzcX.destroy();
        }
    }

    public Class<CustomEventExtras> getAdditionalParametersType() {
        return CustomEventExtras.class;
    }

    public View getBannerView() {
        return this.zzcV;
    }

    public Class<CustomEventServerParameters> getServerParametersType() {
        return CustomEventServerParameters.class;
    }

    public void requestBannerAd(MediationBannerListener mediationBannerListener, Activity activity, CustomEventServerParameters customEventServerParameters, AdSize adSize, MediationAdRequest mediationAdRequest, CustomEventExtras customEventExtras) {
        this.zzcW = (CustomEventBanner) zzj(customEventServerParameters.className);
        if (this.zzcW == null) {
            mediationBannerListener.onFailedToReceiveAd(this, ErrorCode.INTERNAL_ERROR);
        } else {
            this.zzcW.requestBannerAd(new zza(this, mediationBannerListener), activity, customEventServerParameters.label, customEventServerParameters.parameter, adSize, mediationAdRequest, customEventExtras == null ? null : customEventExtras.getExtra(customEventServerParameters.label));
        }
    }

    public void requestInterstitialAd(MediationInterstitialListener mediationInterstitialListener, Activity activity, CustomEventServerParameters customEventServerParameters, MediationAdRequest mediationAdRequest, CustomEventExtras customEventExtras) {
        this.zzcX = (CustomEventInterstitial) zzj(customEventServerParameters.className);
        if (this.zzcX == null) {
            mediationInterstitialListener.onFailedToReceiveAd(this, ErrorCode.INTERNAL_ERROR);
        } else {
            this.zzcX.requestInterstitialAd(zza(mediationInterstitialListener), activity, customEventServerParameters.label, customEventServerParameters.parameter, mediationAdRequest, customEventExtras == null ? null : customEventExtras.getExtra(customEventServerParameters.label));
        }
    }

    public void showInterstitial() {
        this.zzcX.showInterstitial();
    }

    zzb zza(MediationInterstitialListener mediationInterstitialListener) {
        return new zzb(this, this, mediationInterstitialListener);
    }
}
