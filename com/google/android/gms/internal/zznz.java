package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.reward.RewardedVideoAd;
import com.google.android.gms.ads.reward.RewardedVideoAdListener;
import com.google.android.gms.dynamic.zze;

@zzmb
public class zznz implements RewardedVideoAd {
    private final Context mContext;
    private final zznr zzUK;
    private RewardedVideoAdListener zzcI;
    private final Object zzrN;

    public zznz(Context context, zznr com_google_android_gms_internal_zznr) {
        this.zzrN = new Object();
        this.zzUK = com_google_android_gms_internal_zznr;
        this.mContext = context;
    }

    public void destroy() {
        destroy(null);
    }

    public void destroy(Context context) {
        synchronized (this.zzrN) {
            if (this.zzUK == null) {
                return;
            }
            try {
                this.zzUK.zzh(zze.zzA(context));
            } catch (Throwable e) {
                zzpy.zzc("Could not forward destroy to RewardedVideoAd", e);
            }
        }
    }

    public RewardedVideoAdListener getRewardedVideoAdListener() {
        RewardedVideoAdListener rewardedVideoAdListener;
        synchronized (this.zzrN) {
            rewardedVideoAdListener = this.zzcI;
        }
        return rewardedVideoAdListener;
    }

    public String getUserId() {
        zzpy.zzbe("RewardedVideoAd.getUserId() is deprecated. Please do not call this method.");
        return null;
    }

    public boolean isLoaded() {
        boolean z = false;
        synchronized (this.zzrN) {
            if (this.zzUK == null) {
            } else {
                try {
                    z = this.zzUK.isLoaded();
                } catch (Throwable e) {
                    zzpy.zzc("Could not forward isLoaded to RewardedVideoAd", e);
                }
            }
        }
        return z;
    }

    public void loadAd(String str, AdRequest adRequest) {
        synchronized (this.zzrN) {
            if (this.zzUK == null) {
                return;
            }
            try {
                this.zzUK.zza(zzeb.zzey().zza(this.mContext, adRequest.zzbq(), str));
            } catch (Throwable e) {
                zzpy.zzc("Could not forward loadAd to RewardedVideoAd", e);
            }
        }
    }

    public void pause() {
        pause(null);
    }

    public void pause(Context context) {
        synchronized (this.zzrN) {
            if (this.zzUK == null) {
                return;
            }
            try {
                this.zzUK.zzf(zze.zzA(context));
            } catch (Throwable e) {
                zzpy.zzc("Could not forward pause to RewardedVideoAd", e);
            }
        }
    }

    public void resume() {
        resume(null);
    }

    public void resume(Context context) {
        synchronized (this.zzrN) {
            if (this.zzUK == null) {
                return;
            }
            try {
                this.zzUK.zzg(zze.zzA(context));
            } catch (Throwable e) {
                zzpy.zzc("Could not forward resume to RewardedVideoAd", e);
            }
        }
    }

    public void setRewardedVideoAdListener(RewardedVideoAdListener rewardedVideoAdListener) {
        synchronized (this.zzrN) {
            this.zzcI = rewardedVideoAdListener;
            if (this.zzUK != null) {
                try {
                    this.zzUK.zza(new zznw(rewardedVideoAdListener));
                } catch (Throwable e) {
                    zzpy.zzc("Could not forward setRewardedVideoAdListener to RewardedVideoAd", e);
                }
            }
        }
    }

    public void setUserId(String str) {
        zzpy.zzbe("RewardedVideoAd.setUserId() is deprecated. Please do not call this method.");
    }

    public void show() {
        synchronized (this.zzrN) {
            if (this.zzUK == null) {
                return;
            }
            try {
                this.zzUK.show();
            } catch (Throwable e) {
                zzpy.zzc("Could not forward show to RewardedVideoAd", e);
            }
        }
    }
}
