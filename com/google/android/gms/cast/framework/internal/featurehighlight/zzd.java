package com.google.android.gms.cast.framework.internal.featurehighlight;

import android.content.res.Resources;
import android.graphics.Rect;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.MarginLayoutParams;
import com.bumptech.glide.request.target.Target;
import com.google.android.gms.C0473R;
import com.google.android.gms.internal.zzbir;

class zzd {
    private final zza zzaqA;
    private final Rect zzaqv;
    private final int zzaqw;
    private final int zzaqx;
    private final int zzaqy;
    private final int zzaqz;

    zzd(zza com_google_android_gms_cast_framework_internal_featurehighlight_zza) {
        this.zzaqv = new Rect();
        this.zzaqA = (zza) zzbir.zzw(com_google_android_gms_cast_framework_internal_featurehighlight_zza);
        Resources resources = com_google_android_gms_cast_framework_internal_featurehighlight_zza.getResources();
        this.zzaqw = resources.getDimensionPixelSize(C0473R.dimen.cast_libraries_material_featurehighlight_inner_radius);
        this.zzaqx = resources.getDimensionPixelOffset(C0473R.dimen.cast_libraries_material_featurehighlight_inner_margin);
        this.zzaqy = resources.getDimensionPixelSize(C0473R.dimen.cast_libraries_material_featurehighlight_text_max_width);
        this.zzaqz = resources.getDimensionPixelSize(C0473R.dimen.cast_libraries_material_featurehighlight_text_horizontal_offset);
    }

    private int zza(View view, int i, int i2, int i3, int i4) {
        MarginLayoutParams marginLayoutParams = (MarginLayoutParams) view.getLayoutParams();
        int i5 = i3 / 2;
        int i6 = (i4 - i <= i2 - i4 ? 1 : null) != null ? (i4 - i5) + this.zzaqz : (i4 - i5) - this.zzaqz;
        return i6 - marginLayoutParams.leftMargin < i ? i + marginLayoutParams.leftMargin : (i6 + i3) + marginLayoutParams.rightMargin > i2 ? (i2 - i3) - marginLayoutParams.rightMargin : i6;
    }

    private void zza(View view, int i, int i2) {
        MarginLayoutParams marginLayoutParams = (MarginLayoutParams) view.getLayoutParams();
        view.measure(MeasureSpec.makeMeasureSpec(Math.min((i - marginLayoutParams.leftMargin) - marginLayoutParams.rightMargin, this.zzaqy), 1073741824), MeasureSpec.makeMeasureSpec(i2, Target.SIZE_ORIGINAL));
    }

    private void zza(View view, Rect rect) {
        rect.set(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
    }

    private void zzb(View view, int i, int i2) {
        view.layout(i, i2, view.getMeasuredWidth() + i, view.getMeasuredHeight() + i2);
    }

    private void zzc(View view, int i, int i2) {
        view.layout(i, i2 - view.getMeasuredHeight(), view.getMeasuredWidth() + i, i2);
    }

    private int zzd(Rect rect) {
        this.zzaqA.zzsI();
        return Math.max(this.zzaqw * 2, rect.height());
    }

    void zza(Rect rect, Rect rect2) {
        int i = 0;
        View zzsJ = this.zzaqA.zzsJ();
        if (rect.isEmpty() || rect2.isEmpty()) {
            zzsJ.layout(0, 0, 0, 0);
        } else {
            int centerY = rect.centerY();
            int centerX = rect.centerX();
            if (centerY < rect2.centerY()) {
                i = 1;
            }
            int zzd = zzd(rect);
            int i2 = this.zzaqx + ((zzd / 2) + centerY);
            if (i != 0) {
                zza(zzsJ, rect2.width(), rect2.bottom - i2);
                zzb(zzsJ, zza(zzsJ, rect2.left, rect2.right, zzsJ.getMeasuredWidth(), centerX), i2);
            } else {
                i2 = (centerY - (zzd / 2)) - this.zzaqx;
                zza(zzsJ, rect2.width(), i2 - rect2.top);
                zzc(zzsJ, zza(zzsJ, rect2.left, rect2.right, zzsJ.getMeasuredWidth(), centerX), i2);
            }
        }
        zza(zzsJ, this.zzaqv);
        this.zzaqA.zzsK().zzb(rect, this.zzaqv);
        this.zzaqA.zzsL().zzc(rect);
    }
}
