package com.google.android.gms.internal;

import com.google.android.gms.ads.purchase.InAppPurchase;

@zzmb
public class zzlh implements InAppPurchase {
    private final zzky zzPa;

    public zzlh(zzky com_google_android_gms_internal_zzky) {
        this.zzPa = com_google_android_gms_internal_zzky;
    }

    public String getProductId() {
        try {
            return this.zzPa.getProductId();
        } catch (Throwable e) {
            zzpy.zzc("Could not forward getProductId to InAppPurchase", e);
            return null;
        }
    }

    public void recordPlayBillingResolution(int i) {
        try {
            this.zzPa.recordPlayBillingResolution(i);
        } catch (Throwable e) {
            zzpy.zzc("Could not forward recordPlayBillingResolution to InAppPurchase", e);
        }
    }

    public void recordResolution(int i) {
        try {
            this.zzPa.recordResolution(i);
        } catch (Throwable e) {
            zzpy.zzc("Could not forward recordResolution to InAppPurchase", e);
        }
    }
}
