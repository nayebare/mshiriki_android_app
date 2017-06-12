package com.google.android.gms.ads;

import android.support.annotation.Nullable;
import com.google.android.gms.common.internal.zzac;
import com.google.android.gms.internal.zzew;
import com.google.android.gms.internal.zzfm;
import com.google.android.gms.internal.zzmb;
import com.google.android.gms.internal.zzpy;

@zzmb
public final class VideoController {
    private final Object zzrN;
    @Nullable
    private zzew zzrO;
    @Nullable
    private VideoLifecycleCallbacks zzrP;

    public static abstract class VideoLifecycleCallbacks {
        public void onVideoEnd() {
        }
    }

    public VideoController() {
        this.zzrN = new Object();
    }

    public float getAspectRatio() {
        float f = 0.0f;
        synchronized (this.zzrN) {
            if (this.zzrO == null) {
            } else {
                try {
                    f = this.zzrO.getAspectRatio();
                } catch (Throwable e) {
                    zzpy.zzb("Unable to call getAspectRatio on video controller.", e);
                }
            }
        }
        return f;
    }

    @Nullable
    public VideoLifecycleCallbacks getVideoLifecycleCallbacks() {
        VideoLifecycleCallbacks videoLifecycleCallbacks;
        synchronized (this.zzrN) {
            videoLifecycleCallbacks = this.zzrP;
        }
        return videoLifecycleCallbacks;
    }

    public boolean hasVideoContent() {
        boolean z;
        synchronized (this.zzrN) {
            z = this.zzrO != null;
        }
        return z;
    }

    public void setVideoLifecycleCallbacks(VideoLifecycleCallbacks videoLifecycleCallbacks) {
        zzac.zzb((Object) videoLifecycleCallbacks, (Object) "VideoLifecycleCallbacks may not be null.");
        synchronized (this.zzrN) {
            this.zzrP = videoLifecycleCallbacks;
            if (this.zzrO == null) {
                return;
            }
            try {
                this.zzrO.zza(new zzfm(videoLifecycleCallbacks));
            } catch (Throwable e) {
                zzpy.zzb("Unable to call setVideoLifecycleCallbacks on video controller.", e);
            }
        }
    }

    public void zza(zzew com_google_android_gms_internal_zzew) {
        synchronized (this.zzrN) {
            this.zzrO = com_google_android_gms_internal_zzew;
            if (this.zzrP != null) {
                setVideoLifecycleCallbacks(this.zzrP);
            }
        }
    }

    public zzew zzbt() {
        zzew com_google_android_gms_internal_zzew;
        synchronized (this.zzrN) {
            com_google_android_gms_internal_zzew = this.zzrO;
        }
        return com_google_android_gms_internal_zzew;
    }
}
