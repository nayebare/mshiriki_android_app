package com.google.android.gms.ads;

import android.content.Context;
import android.support.annotation.RequiresPermission;
import com.google.android.gms.ads.reward.RewardedVideoAd;
import com.google.android.gms.internal.zzfb;
import com.google.android.gms.internal.zzfc;

public class MobileAds {

    public static final class Settings {
        private final zzfc zzrM;

        public Settings() {
            this.zzrM = new zzfc();
        }

        @Deprecated
        public String getTrackingId() {
            return null;
        }

        @Deprecated
        public boolean isGoogleAnalyticsEnabled() {
            return false;
        }

        @Deprecated
        public Settings setGoogleAnalyticsEnabled(boolean z) {
            return this;
        }

        @Deprecated
        public Settings setTrackingId(String str) {
            return this;
        }

        zzfc zzbs() {
            return this.zzrM;
        }
    }

    private MobileAds() {
    }

    public static RewardedVideoAd getRewardedVideoAdInstance(Context context) {
        return zzfb.zzff().getRewardedVideoAdInstance(context);
    }

    public static void initialize(Context context) {
        initialize(context, null, null);
    }

    @RequiresPermission("android.permission.INTERNET")
    public static void initialize(Context context, String str) {
        initialize(context, str, null);
    }

    @RequiresPermission("android.permission.INTERNET")
    @Deprecated
    public static void initialize(Context context, String str, Settings settings) {
        zzfb.zzff().zza(context, str, settings == null ? null : settings.zzbs());
    }

    public static void openDebugMenu(Context context, String str) {
        zzfb.zzff().openDebugMenu(context, str);
    }

    public static void setAppMuted(boolean z) {
        zzfb.zzff().setAppMuted(z);
    }

    public static void setAppVolume(float f) {
        zzfb.zzff().setAppVolume(f);
    }
}
