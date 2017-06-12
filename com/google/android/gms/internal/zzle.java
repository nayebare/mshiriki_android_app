package com.google.android.gms.internal;

import com.google.android.gms.ads.purchase.InAppPurchaseListener;
import com.google.android.gms.internal.zzkz.zza;

@zzmb
public final class zzle extends zza {
    private final InAppPurchaseListener zzAa;

    public zzle(InAppPurchaseListener inAppPurchaseListener) {
        this.zzAa = inAppPurchaseListener;
    }

    public void zza(zzky com_google_android_gms_internal_zzky) {
        this.zzAa.onInAppPurchaseRequested(new zzlh(com_google_android_gms_internal_zzky));
    }
}
