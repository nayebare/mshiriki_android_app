package com.google.android.gms.cast.framework.internal.featurehighlight;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.annotation.ColorInt;
import com.android.volley.toolbox.ImageRequest;
import com.google.android.gms.C0473R;
import com.google.android.gms.cast.TextTrackStyle;
import com.google.android.gms.internal.zzbik;
import com.google.android.gms.internal.zzbim;

class zzc extends Drawable {
    private float centerX;
    private float centerY;
    private final Paint zzapR;
    private float zzapS;
    private final Rect zzapW;
    private final Paint zzaqr;
    private final int zzaqs;
    private final int zzaqt;
    private float zzaqu;

    public zzc(Context context) {
        this.zzapR = new Paint();
        this.zzaqr = new Paint();
        this.zzapW = new Rect();
        this.zzaqu = TextTrackStyle.DEFAULT_FONT_SCALE;
        Resources resources = context.getResources();
        this.zzaqs = resources.getDimensionPixelSize(C0473R.dimen.cast_libraries_material_featurehighlight_inner_radius);
        this.zzaqt = resources.getInteger(C0473R.integer.cast_libraries_material_featurehighlight_pulse_base_alpha);
        this.zzapR.setAntiAlias(true);
        this.zzapR.setStyle(Style.FILL);
        this.zzaqr.setAntiAlias(true);
        this.zzaqr.setStyle(Style.FILL);
        setColor(-1);
    }

    public void draw(Canvas canvas) {
        canvas.drawCircle(this.centerX, this.centerY, this.zzapS * this.zzaqu, this.zzapR);
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
        this.zzaqr.setColor(i);
        invalidateSelf();
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.zzapR.setColorFilter(colorFilter);
        invalidateSelf();
    }

    public void zzc(Rect rect) {
        this.zzapW.set(rect);
        this.centerX = this.zzapW.exactCenterX();
        this.centerY = this.zzapW.exactCenterY();
        this.zzapS = Math.max((float) this.zzaqs, Math.max(((float) this.zzapW.width()) / ImageRequest.DEFAULT_IMAGE_BACKOFF_MULT, ((float) this.zzapW.height()) / ImageRequest.DEFAULT_IMAGE_BACKOFF_MULT));
        invalidateSelf();
    }

    public Animator zzsM() {
        PropertyValuesHolder ofFloat = PropertyValuesHolder.ofFloat("scale", new float[]{0.0f, TextTrackStyle.DEFAULT_FONT_SCALE});
        PropertyValuesHolder ofFloat2 = PropertyValuesHolder.ofFloat("alpha", new float[]{0.0f, TextTrackStyle.DEFAULT_FONT_SCALE});
        Animator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(this, new PropertyValuesHolder[]{ofFloat, ofFloat2});
        ofPropertyValuesHolder.setInterpolator(zzbim.zzTk());
        return ofPropertyValuesHolder.setDuration(350);
    }

    public Animator zzsN() {
        Animator animatorSet = new AnimatorSet();
        Animator duration = ObjectAnimator.ofFloat(this, "scale", new float[]{TextTrackStyle.DEFAULT_FONT_SCALE, 1.1f}).setDuration(500);
        Animator duration2 = ObjectAnimator.ofFloat(this, "scale", new float[]{1.1f, TextTrackStyle.DEFAULT_FONT_SCALE}).setDuration(500);
        PropertyValuesHolder ofFloat = PropertyValuesHolder.ofFloat("pulseScale", new float[]{1.1f, ImageRequest.DEFAULT_IMAGE_BACKOFF_MULT});
        PropertyValuesHolder ofFloat2 = PropertyValuesHolder.ofFloat("pulseAlpha", new float[]{TextTrackStyle.DEFAULT_FONT_SCALE, 0.0f});
        Animator duration3 = ObjectAnimator.ofPropertyValuesHolder(this, new PropertyValuesHolder[]{ofFloat, ofFloat2}).setDuration(500);
        animatorSet.play(duration);
        animatorSet.play(duration2).with(duration3).after(duration);
        animatorSet.setInterpolator(zzbim.zzTm());
        animatorSet.setStartDelay(500);
        zzbik.zzc(animatorSet);
        return animatorSet;
    }

    public Animator zzsO() {
        return zzsP();
    }

    public Animator zzsP() {
        PropertyValuesHolder ofFloat = PropertyValuesHolder.ofFloat("scale", new float[]{0.0f});
        PropertyValuesHolder ofFloat2 = PropertyValuesHolder.ofFloat("alpha", new float[]{0.0f});
        PropertyValuesHolder ofFloat3 = PropertyValuesHolder.ofFloat("pulseScale", new float[]{0.0f});
        PropertyValuesHolder ofFloat4 = PropertyValuesHolder.ofFloat("pulseAlpha", new float[]{0.0f});
        Animator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(this, new PropertyValuesHolder[]{ofFloat, ofFloat2, ofFloat3, ofFloat4});
        ofPropertyValuesHolder.setInterpolator(zzbim.zzTl());
        return ofPropertyValuesHolder.setDuration(200);
    }
}
