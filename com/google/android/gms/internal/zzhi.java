package com.google.android.gms.internal;

import com.google.android.gms.ads.formats.NativeAd.Image;
import com.google.android.gms.ads.formats.NativeCustomTemplateAd;
import java.util.List;

@zzmb
public class zzhi implements NativeCustomTemplateAd {
    private final zzhh zzGX;

    public zzhi(zzhh com_google_android_gms_internal_zzhh) {
        this.zzGX = com_google_android_gms_internal_zzhh;
    }

    public List<String> getAvailableAssetNames() {
        try {
            return this.zzGX.getAvailableAssetNames();
        } catch (Throwable e) {
            zzpy.zzb("Failed to get available asset names.", e);
            return null;
        }
    }

    public String getCustomTemplateId() {
        try {
            return this.zzGX.getCustomTemplateId();
        } catch (Throwable e) {
            zzpy.zzb("Failed to get custom template id.", e);
            return null;
        }
    }

    public Image getImage(String str) {
        try {
            zzgz zzZ = this.zzGX.zzZ(str);
            if (zzZ != null) {
                return new zzha(zzZ);
            }
        } catch (Throwable e) {
            zzpy.zzb("Failed to get image.", e);
        }
        return null;
    }

    public CharSequence getText(String str) {
        try {
            return this.zzGX.zzY(str);
        } catch (Throwable e) {
            zzpy.zzb("Failed to get string.", e);
            return null;
        }
    }

    public void performClick(String str) {
        try {
            this.zzGX.performClick(str);
        } catch (Throwable e) {
            zzpy.zzb("Failed to perform click.", e);
        }
    }

    public void recordImpression() {
        try {
            this.zzGX.recordImpression();
        } catch (Throwable e) {
            zzpy.zzb("Failed to record impression.", e);
        }
    }
}
