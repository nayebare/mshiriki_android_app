package com.google.android.gms.ads.formats;

import android.annotation.TargetApi;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.google.android.gms.common.internal.zzac;
import com.google.android.gms.dynamic.zzd;
import com.google.android.gms.dynamic.zze;
import com.google.android.gms.internal.zzeh;
import com.google.android.gms.internal.zzhb;
import com.google.android.gms.internal.zzpy;

public abstract class NativeAdView extends FrameLayout {
    private final FrameLayout zzsc;
    private final zzhb zzsd;

    public NativeAdView(Context context) {
        super(context);
        this.zzsc = zzd(context);
        this.zzsd = zzbw();
    }

    public NativeAdView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.zzsc = zzd(context);
        this.zzsd = zzbw();
    }

    public NativeAdView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.zzsc = zzd(context);
        this.zzsd = zzbw();
    }

    @TargetApi(21)
    public NativeAdView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.zzsc = zzd(context);
        this.zzsd = zzbw();
    }

    private zzhb zzbw() {
        zzac.zzb(this.zzsc, (Object) "createDelegate must be called after mOverlayFrame has been created");
        return zzeh.zzeP().zza(this.zzsc.getContext(), (FrameLayout) this, this.zzsc);
    }

    private FrameLayout zzd(Context context) {
        View zze = zze(context);
        zze.setLayoutParams(new LayoutParams(-1, -1));
        addView(zze);
        return zze;
    }

    public void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        super.addView(view, i, layoutParams);
        super.bringChildToFront(this.zzsc);
    }

    public void bringChildToFront(View view) {
        super.bringChildToFront(view);
        if (this.zzsc != view) {
            super.bringChildToFront(this.zzsc);
        }
    }

    public void destroy() {
        try {
            this.zzsd.destroy();
        } catch (Throwable e) {
            zzpy.zzb("Unable to destroy native ad view", e);
        }
    }

    public void removeAllViews() {
        super.removeAllViews();
        super.addView(this.zzsc);
    }

    public void removeView(View view) {
        if (this.zzsc != view) {
            super.removeView(view);
        }
    }

    public void setNativeAd(NativeAd nativeAd) {
        try {
            this.zzsd.zze((zzd) nativeAd.zzbv());
        } catch (Throwable e) {
            zzpy.zzb("Unable to call setNativeAd on delegate", e);
        }
    }

    protected void zza(String str, View view) {
        try {
            this.zzsd.zzc(str, zze.zzA(view));
        } catch (Throwable e) {
            zzpy.zzb("Unable to call setAssetView on delegate", e);
        }
    }

    FrameLayout zze(Context context) {
        return new FrameLayout(context);
    }

    protected View zzt(String str) {
        try {
            zzd zzU = this.zzsd.zzU(str);
            if (zzU != null) {
                return (View) zze.zzE(zzU);
            }
        } catch (Throwable e) {
            zzpy.zzb("Unable to call getAssetView on delegate", e);
        }
        return null;
    }
}
