package com.google.android.gms.ads.internal.overlay;

import android.annotation.TargetApi;
import android.graphics.SurfaceTexture;
import com.google.android.gms.internal.zzfx;
import com.google.android.gms.internal.zzmb;
import com.google.android.gms.internal.zzpi;
import java.util.concurrent.TimeUnit;

@TargetApi(14)
@zzmb
public class zzw {
    private final long zzNC;
    private long zzND;
    private boolean zzNE;

    /* renamed from: com.google.android.gms.ads.internal.overlay.zzw.1 */
    class C04941 implements Runnable {
        final /* synthetic */ zzi zzNF;

        C04941(zzw com_google_android_gms_ads_internal_overlay_zzw, zzi com_google_android_gms_ads_internal_overlay_zzi) {
            this.zzNF = com_google_android_gms_ads_internal_overlay_zzi;
        }

        public void run() {
            this.zzNF.zzhD();
        }
    }

    zzw() {
        this.zzNC = TimeUnit.MILLISECONDS.toNanos(((Long) zzfx.zzBs.get()).longValue());
        this.zzNE = true;
    }

    public void zza(SurfaceTexture surfaceTexture, zzi com_google_android_gms_ads_internal_overlay_zzi) {
        if (com_google_android_gms_ads_internal_overlay_zzi != null) {
            long timestamp = surfaceTexture.getTimestamp();
            if (this.zzNE || Math.abs(timestamp - this.zzND) >= this.zzNC) {
                this.zzNE = false;
                this.zzND = timestamp;
                zzpi.zzWR.post(new C04941(this, com_google_android_gms_ads_internal_overlay_zzi));
            }
        }
    }

    public void zzhA() {
        this.zzNE = true;
    }
}
