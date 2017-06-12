package com.google.android.gms.internal;

import com.google.ads.AdRequest.ErrorCode;
import com.google.ads.mediation.MediationBannerAdapter;
import com.google.ads.mediation.MediationBannerListener;
import com.google.ads.mediation.MediationInterstitialAdapter;
import com.google.ads.mediation.MediationInterstitialListener;
import com.google.ads.mediation.MediationServerParameters;
import com.google.ads.mediation.NetworkExtras;

@zzmb
public final class zzkf<NETWORK_EXTRAS extends NetworkExtras, SERVER_PARAMETERS extends MediationServerParameters> implements MediationBannerListener, MediationInterstitialListener {
    private final zzju zzKW;

    public zzkf(zzju com_google_android_gms_internal_zzju) {
        this.zzKW = com_google_android_gms_internal_zzju;
    }

    public void onClick(MediationBannerAdapter<?, ?> mediationBannerAdapter) {
        zzpy.zzbc("Adapter called onClick.");
        if (zzeh.zzeO().zzkJ()) {
            try {
                this.zzKW.onAdClicked();
                return;
            } catch (Throwable e) {
                zzpy.zzc("Could not call onAdClicked.", e);
                return;
            }
        }
        zzpy.zzbe("onClick must be called on the main UI thread.");
        zzpx.zzXU.post(new 1(this));
    }

    public void onDismissScreen(MediationBannerAdapter<?, ?> mediationBannerAdapter) {
        zzpy.zzbc("Adapter called onDismissScreen.");
        if (zzeh.zzeO().zzkJ()) {
            try {
                this.zzKW.onAdClosed();
                return;
            } catch (Throwable e) {
                zzpy.zzc("Could not call onAdClosed.", e);
                return;
            }
        }
        zzpy.zzbe("onDismissScreen must be called on the main UI thread.");
        zzpx.zzXU.post(new 4(this));
    }

    public void onDismissScreen(MediationInterstitialAdapter<?, ?> mediationInterstitialAdapter) {
        zzpy.zzbc("Adapter called onDismissScreen.");
        if (zzeh.zzeO().zzkJ()) {
            try {
                this.zzKW.onAdClosed();
                return;
            } catch (Throwable e) {
                zzpy.zzc("Could not call onAdClosed.", e);
                return;
            }
        }
        zzpy.zzbe("onDismissScreen must be called on the main UI thread.");
        zzpx.zzXU.post(new 9(this));
    }

    public void onFailedToReceiveAd(MediationBannerAdapter<?, ?> mediationBannerAdapter, ErrorCode errorCode) {
        String valueOf = String.valueOf(errorCode);
        zzpy.zzbc(new StringBuilder(String.valueOf(valueOf).length() + 47).append("Adapter called onFailedToReceiveAd with error. ").append(valueOf).toString());
        if (zzeh.zzeO().zzkJ()) {
            try {
                this.zzKW.onAdFailedToLoad(zzkg.zza(errorCode));
                return;
            } catch (Throwable e) {
                zzpy.zzc("Could not call onAdFailedToLoad.", e);
                return;
            }
        }
        zzpy.zzbe("onFailedToReceiveAd must be called on the main UI thread.");
        zzpx.zzXU.post(new 5(this, errorCode));
    }

    public void onFailedToReceiveAd(MediationInterstitialAdapter<?, ?> mediationInterstitialAdapter, ErrorCode errorCode) {
        String valueOf = String.valueOf(errorCode);
        zzpy.zzbc(new StringBuilder(String.valueOf(valueOf).length() + 47).append("Adapter called onFailedToReceiveAd with error ").append(valueOf).append(".").toString());
        if (zzeh.zzeO().zzkJ()) {
            try {
                this.zzKW.onAdFailedToLoad(zzkg.zza(errorCode));
                return;
            } catch (Throwable e) {
                zzpy.zzc("Could not call onAdFailedToLoad.", e);
                return;
            }
        }
        zzpy.zzbe("onFailedToReceiveAd must be called on the main UI thread.");
        zzpx.zzXU.post(new 10(this, errorCode));
    }

    public void onLeaveApplication(MediationBannerAdapter<?, ?> mediationBannerAdapter) {
        zzpy.zzbc("Adapter called onLeaveApplication.");
        if (zzeh.zzeO().zzkJ()) {
            try {
                this.zzKW.onAdLeftApplication();
                return;
            } catch (Throwable e) {
                zzpy.zzc("Could not call onAdLeftApplication.", e);
                return;
            }
        }
        zzpy.zzbe("onLeaveApplication must be called on the main UI thread.");
        zzpx.zzXU.post(new 6(this));
    }

    public void onLeaveApplication(MediationInterstitialAdapter<?, ?> mediationInterstitialAdapter) {
        zzpy.zzbc("Adapter called onLeaveApplication.");
        if (zzeh.zzeO().zzkJ()) {
            try {
                this.zzKW.onAdLeftApplication();
                return;
            } catch (Throwable e) {
                zzpy.zzc("Could not call onAdLeftApplication.", e);
                return;
            }
        }
        zzpy.zzbe("onLeaveApplication must be called on the main UI thread.");
        zzpx.zzXU.post(new 11(this));
    }

    public void onPresentScreen(MediationBannerAdapter<?, ?> mediationBannerAdapter) {
        zzpy.zzbc("Adapter called onPresentScreen.");
        if (zzeh.zzeO().zzkJ()) {
            try {
                this.zzKW.onAdOpened();
                return;
            } catch (Throwable e) {
                zzpy.zzc("Could not call onAdOpened.", e);
                return;
            }
        }
        zzpy.zzbe("onPresentScreen must be called on the main UI thread.");
        zzpx.zzXU.post(new 7(this));
    }

    public void onPresentScreen(MediationInterstitialAdapter<?, ?> mediationInterstitialAdapter) {
        zzpy.zzbc("Adapter called onPresentScreen.");
        if (zzeh.zzeO().zzkJ()) {
            try {
                this.zzKW.onAdOpened();
                return;
            } catch (Throwable e) {
                zzpy.zzc("Could not call onAdOpened.", e);
                return;
            }
        }
        zzpy.zzbe("onPresentScreen must be called on the main UI thread.");
        zzpx.zzXU.post(new 2(this));
    }

    public void onReceivedAd(MediationBannerAdapter<?, ?> mediationBannerAdapter) {
        zzpy.zzbc("Adapter called onReceivedAd.");
        if (zzeh.zzeO().zzkJ()) {
            try {
                this.zzKW.onAdLoaded();
                return;
            } catch (Throwable e) {
                zzpy.zzc("Could not call onAdLoaded.", e);
                return;
            }
        }
        zzpy.zzbe("onReceivedAd must be called on the main UI thread.");
        zzpx.zzXU.post(new 8(this));
    }

    public void onReceivedAd(MediationInterstitialAdapter<?, ?> mediationInterstitialAdapter) {
        zzpy.zzbc("Adapter called onReceivedAd.");
        if (zzeh.zzeO().zzkJ()) {
            try {
                this.zzKW.onAdLoaded();
                return;
            } catch (Throwable e) {
                zzpy.zzc("Could not call onAdLoaded.", e);
                return;
            }
        }
        zzpy.zzbe("onReceivedAd must be called on the main UI thread.");
        zzpx.zzXU.post(new 3(this));
    }
}
