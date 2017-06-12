package com.google.android.gms.internal;

import android.view.View;
import com.google.android.gms.ads.doubleclick.CustomRenderedAd;
import com.google.android.gms.dynamic.zze;

@zzmb
public class zzgh implements CustomRenderedAd {
    private final zzgi zzFz;

    public zzgh(zzgi com_google_android_gms_internal_zzgi) {
        this.zzFz = com_google_android_gms_internal_zzgi;
    }

    public String getBaseUrl() {
        try {
            return this.zzFz.zzfB();
        } catch (Throwable e) {
            zzpy.zzc("Could not delegate getBaseURL to CustomRenderedAd", e);
            return null;
        }
    }

    public String getContent() {
        try {
            return this.zzFz.getContent();
        } catch (Throwable e) {
            zzpy.zzc("Could not delegate getContent to CustomRenderedAd", e);
            return null;
        }
    }

    public void onAdRendered(View view) {
        try {
            this.zzFz.zzi(view != null ? zze.zzA(view) : null);
        } catch (Throwable e) {
            zzpy.zzc("Could not delegate onAdRendered to CustomRenderedAd", e);
        }
    }

    public void recordClick() {
        try {
            this.zzFz.recordClick();
        } catch (Throwable e) {
            zzpy.zzc("Could not delegate recordClick to CustomRenderedAd", e);
        }
    }

    public void recordImpression() {
        try {
            this.zzFz.recordImpression();
        } catch (Throwable e) {
            zzpy.zzc("Could not delegate recordImpression to CustomRenderedAd", e);
        }
    }
}
