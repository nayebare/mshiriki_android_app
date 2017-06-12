package com.google.android.gms.cast.framework.internal.featurehighlight;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.annotation.ColorInt;
import android.support.v4.graphics.ColorUtils;
import android.util.TypedValue;
import com.google.android.gms.C0473R;
import com.google.android.gms.cast.TextTrackStyle;
import com.google.android.gms.common.util.zzs;
import com.google.android.gms.internal.zzbim;
import com.google.android.gms.internal.zzbin;

class zze extends Drawable {
    private float centerX;
    private float centerY;
    private final Paint zzapR;
    private float zzapS;
    private final Rect zzapW;
    private final int zzaqB;
    private final int zzaqC;
    private final int zzaqD;
    private float zzaqE;
    private float zzaqF;
    private int zzaqG;
    private float zzaqu;
    private final Rect zzaqv;

    public zze(Context context) {
        this.zzapW = new Rect();
        this.zzaqv = new Rect();
        this.zzapR = new Paint();
        this.zzaqu = TextTrackStyle.DEFAULT_FONT_SCALE;
        this.zzaqE = 0.0f;
        this.zzaqF = 0.0f;
        this.zzaqG = 244;
        if (zzs.zzyI()) {
            setColor(zzag(context));
        } else {
            setColor(context.getResources().getColor(C0473R.color.f22xfbd34f47));
        }
        this.zzapR.setAntiAlias(true);
        this.zzapR.setStyle(Style.FILL);
        Resources resources = context.getResources();
        this.zzaqB = resources.getDimensionPixelSize(C0473R.dimen.cast_libraries_material_featurehighlight_center_threshold);
        this.zzaqC = resources.getDimensionPixelSize(C0473R.dimen.f24xd1678993);
        this.zzaqD = resources.getDimensionPixelSize(C0473R.dimen.cast_libraries_material_featurehighlight_outer_padding);
    }

    private float zza(float f, float f2, Rect rect) {
        return (float) Math.ceil((double) zzbin.zza(f, f2, (float) rect.left, (float) rect.top, (float) rect.right, (float) rect.bottom));
    }

    @TargetApi(21)
    private static int zzag(Context context) {
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(16843827, typedValue, true);
        return ColorUtils.setAlphaComponent(typedValue.data, 244);
    }

    public void draw(Canvas canvas) {
        canvas.drawCircle(this.centerX + 0.0f, this.centerY + 0.0f, this.zzapS * this.zzaqu, this.zzapR);
    }

    public int getAlpha() {
        return this.zzapR.getAlpha();
    }

    public float getCenterX() {
        return this.centerX;
    }

    public float getCenterY() {
        return this.centerY;
    }

    @ColorInt
    public int getColor() {
        return this.zzapR.getColor();
    }

    public int getOpacity() {
        return -3;
    }

    public void setAlpha(int i) {
        this.zzapR.setAlpha(i);
        invalidateSelf();
    }

    public void setColor(@ColorInt int i) {
        this.zzapR.setColor(i);
        this.zzaqG = this.zzapR.getAlpha();
        invalidateSelf();
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.zzapR.setColorFilter(colorFilter);
        invalidateSelf();
    }

    public void zzb(Rect rect, Rect rect2) {
        this.zzapW.set(rect);
        this.zzaqv.set(rect2);
        float exactCenterX = rect.exactCenterX();
        float exactCenterY = rect.exactCenterY();
        Rect bounds = getBounds();
        if (Math.min(exactCenterY - ((float) bounds.top), ((float) bounds.bottom) - exactCenterY) < ((float) this.zzaqB)) {
            this.centerX = exactCenterX;
            this.centerY = exactCenterY;
        } else {
            this.centerX = ((exactCenterX > bounds.exactCenterX() ? 1 : (exactCenterX == bounds.exactCenterX() ? 0 : -1)) <= 0 ? 1 : null) != null ? rect2.exactCenterX() + ((float) this.zzaqC) : rect2.exactCenterX() - ((float) this.zzaqC);
            this.centerY = rect2.exactCenterY();
        }
        this.zzapS = ((float) this.zzaqD) + Math.max(zza(this.centerX, this.centerY, rect), zza(this.centerX, this.centerY, rect2));
        invalidateSelf();
    }

    public boolean zzd(float f, float f2) {
        return zzbin.zzb(f, f2, this.centerX, this.centerY) < this.zzapS;
    }

    public Animator zze(float f, float f2) {
        PropertyValuesHolder ofFloat = PropertyValuesHolder.ofFloat("scale", new float[]{0.0f, TextTrackStyle.DEFAULT_FONT_SCALE});
        PropertyValuesHolder ofFloat2 = PropertyValuesHolder.ofFloat("translationX", new float[]{f, 0.0f});
        PropertyValuesHolder ofFloat3 = PropertyValuesHolder.ofFloat("translationY", new float[]{f2, 0.0f});
        PropertyValuesHolder ofInt = PropertyValuesHolder.ofInt("alpha", new int[]{0, this.zzaqG});
        Animator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(this, new PropertyValuesHolder[]{ofFloat, ofFloat2, ofFloat3, ofInt});
        ofPropertyValuesHolder.setInterpolator(zzbim.zzTk());
        return ofPropertyValuesHolder.setDuration(350);
    }

    public Animator zzf(float f, float f2) {
        PropertyValuesHolder ofFloat = PropertyValuesHolder.ofFloat("scale", new float[]{0.0f});
        PropertyValuesHolder ofInt = PropertyValuesHolder.ofInt("alpha", new int[]{0});
        PropertyValuesHolder ofFloat2 = PropertyValuesHolder.ofFloat("translationX", new float[]{0.0f, f});
        PropertyValuesHolder ofFloat3 = PropertyValuesHolder.ofFloat("translationY", new float[]{0.0f, f2});
        Animator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(this, new PropertyValuesHolder[]{ofFloat, ofFloat2, ofFloat3, ofInt});
        ofPropertyValuesHolder.setInterpolator(zzbim.zzTl());
        return ofPropertyValuesHolder.setDuration(200);
    }

    public Animator zzsO() {
        PropertyValuesHolder ofFloat = PropertyValuesHolder.ofFloat("scale", new float[]{1.125f});
        PropertyValuesHolder ofInt = PropertyValuesHolder.ofInt("alpha", new int[]{0});
        Animator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(this, new PropertyValuesHolder[]{ofFloat, ofInt});
        ofPropertyValuesHolder.setInterpolator(zzbim.zzTl());
        return ofPropertyValuesHolder.setDuration(200);
    }
}
