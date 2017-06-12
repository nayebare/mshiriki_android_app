package com.google.android.gms.internal;

import android.animation.Animator;
import android.support.annotation.Nullable;
import com.google.android.gms.internal.zzbil.zza;

public class zzbik extends zzbij {
    protected final Animator zzbTU;
    private final zzbil zzbTV;
    private final Runnable zzbTW;
    private zza zzbTX;

    /* renamed from: com.google.android.gms.internal.zzbik.1 */
    class C11701 extends zza {
        final /* synthetic */ zzbik zzbTY;

        C11701(zzbik com_google_android_gms_internal_zzbik) {
            this.zzbTY = com_google_android_gms_internal_zzbik;
        }

        public void doFrame(long j) {
            if (!this.zzbTY.zzb(this.zzbTY.zzbTU) && !this.zzbTY.zzbTU.isStarted()) {
                if (this.zzbTY.zzbTW != null) {
                    this.zzbTY.zzbTW.run();
                }
                this.zzbTY.zzbTU.start();
            }
        }
    }

    private zzbik(Animator animator, @Nullable Runnable runnable) {
        this.zzbTX = new C11701(this);
        this.zzbTU = animator;
        this.zzbTW = runnable;
        this.zzbTV = zzbil.zzTg();
    }

    public static void zza(Animator animator, @Nullable Runnable runnable) {
        animator.addListener(new zzbik(animator, runnable));
    }

    public static void zzc(Animator animator) {
        zza(animator, null);
    }

    public void onAnimationEnd(Animator animator) {
        if (!zzb(animator)) {
            this.zzbTV.zza(this.zzbTX);
        }
    }
}
