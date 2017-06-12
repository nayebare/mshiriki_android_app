package com.google.android.gms.ads.internal.overlay;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import com.google.android.gms.ads.AdActivity;
import com.google.android.gms.ads.internal.zzv;
import com.google.android.gms.common.util.zzs;
import com.google.android.gms.drive.DriveFile;
import com.google.android.gms.internal.zzmb;

@zzmb
public class zzf {
    public void zza(Context context, AdOverlayInfoParcel adOverlayInfoParcel) {
        zza(context, adOverlayInfoParcel, true);
    }

    public void zza(Context context, AdOverlayInfoParcel adOverlayInfoParcel, boolean z) {
        if (adOverlayInfoParcel.zzNf == 4 && adOverlayInfoParcel.zzMY == null) {
            if (adOverlayInfoParcel.zzMX != null) {
                adOverlayInfoParcel.zzMX.onAdClicked();
            }
            zzv.zzcG().zza(context, adOverlayInfoParcel.zzMW, adOverlayInfoParcel.zzNe);
            return;
        }
        Intent intent = new Intent();
        intent.setClassName(context, AdActivity.CLASS_NAME);
        intent.putExtra("com.google.android.gms.ads.internal.overlay.useClientJar", adOverlayInfoParcel.zzvf.zzYd);
        intent.putExtra("shouldCallOnOverlayOpened", z);
        AdOverlayInfoParcel.zza(intent, adOverlayInfoParcel);
        if (!zzs.zzyH()) {
            intent.addFlags(AccessibilityNodeInfoCompat.ACTION_COLLAPSE);
        }
        if (!(context instanceof Activity)) {
            intent.addFlags(DriveFile.MODE_READ_ONLY);
        }
        zzv.zzcJ().zzb(context, intent);
    }
}
