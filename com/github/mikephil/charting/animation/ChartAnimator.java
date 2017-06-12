package com.github.mikephil.charting.animation;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.annotation.SuppressLint;
import android.os.Build.VERSION;
import com.github.mikephil.charting.animation.Easing.EasingOption;
import com.google.android.gms.cast.TextTrackStyle;

@SuppressLint({"NewApi"})
public class ChartAnimator {
    private AnimatorUpdateListener mListener;
    protected float mPhaseX;
    protected float mPhaseY;

    public ChartAnimator() {
        this.mPhaseY = TextTrackStyle.DEFAULT_FONT_SCALE;
        this.mPhaseX = TextTrackStyle.DEFAULT_FONT_SCALE;
    }

    public ChartAnimator(AnimatorUpdateListener listener) {
        this.mPhaseY = TextTrackStyle.DEFAULT_FONT_SCALE;
        this.mPhaseX = TextTrackStyle.DEFAULT_FONT_SCALE;
        this.mListener = listener;
    }

    public void animateXY(int durationMillisX, int durationMillisY, EasingFunction easingX, EasingFunction easingY) {
        if (VERSION.SDK_INT >= 11) {
            ObjectAnimator animatorY = ObjectAnimator.ofFloat(this, "phaseY", new float[]{0.0f, TextTrackStyle.DEFAULT_FONT_SCALE});
            animatorY.setInterpolator(easingY);
            animatorY.setDuration((long) durationMillisY);
            ObjectAnimator animatorX = ObjectAnimator.ofFloat(this, "phaseX", new float[]{0.0f, TextTrackStyle.DEFAULT_FONT_SCALE});
            animatorX.setInterpolator(easingX);
            animatorX.setDuration((long) durationMillisX);
            if (durationMillisX > durationMillisY) {
                animatorX.addUpdateListener(this.mListener);
            } else {
                animatorY.addUpdateListener(this.mListener);
            }
            animatorX.start();
            animatorY.start();
        }
    }

    public void animateX(int durationMillis, EasingFunction easing) {
        if (VERSION.SDK_INT >= 11) {
            ObjectAnimator animatorX = ObjectAnimator.ofFloat(this, "phaseX", new float[]{0.0f, TextTrackStyle.DEFAULT_FONT_SCALE});
            animatorX.setInterpolator(easing);
            animatorX.setDuration((long) durationMillis);
            animatorX.addUpdateListener(this.mListener);
            animatorX.start();
        }
    }

    public void animateY(int durationMillis, EasingFunction easing) {
        if (VERSION.SDK_INT >= 11) {
            ObjectAnimator animatorY = ObjectAnimator.ofFloat(this, "phaseY", new float[]{0.0f, TextTrackStyle.DEFAULT_FONT_SCALE});
            animatorY.setInterpolator(easing);
            animatorY.setDuration((long) durationMillis);
            animatorY.addUpdateListener(this.mListener);
            animatorY.start();
        }
    }

    public void animateXY(int durationMillisX, int durationMillisY, EasingOption easingX, EasingOption easingY) {
        if (VERSION.SDK_INT >= 11) {
            ObjectAnimator animatorY = ObjectAnimator.ofFloat(this, "phaseY", new float[]{0.0f, TextTrackStyle.DEFAULT_FONT_SCALE});
            animatorY.setInterpolator(Easing.getEasingFunctionFromOption(easingY));
            animatorY.setDuration((long) durationMillisY);
            ObjectAnimator animatorX = ObjectAnimator.ofFloat(this, "phaseX", new float[]{0.0f, TextTrackStyle.DEFAULT_FONT_SCALE});
            animatorX.setInterpolator(Easing.getEasingFunctionFromOption(easingX));
            animatorX.setDuration((long) durationMillisX);
            if (durationMillisX > durationMillisY) {
                animatorX.addUpdateListener(this.mListener);
            } else {
                animatorY.addUpdateListener(this.mListener);
            }
            animatorX.start();
            animatorY.start();
        }
    }

    public void animateX(int durationMillis, EasingOption easing) {
        if (VERSION.SDK_INT >= 11) {
            ObjectAnimator animatorX = ObjectAnimator.ofFloat(this, "phaseX", new float[]{0.0f, TextTrackStyle.DEFAULT_FONT_SCALE});
            animatorX.setInterpolator(Easing.getEasingFunctionFromOption(easing));
            animatorX.setDuration((long) durationMillis);
            animatorX.addUpdateListener(this.mListener);
            animatorX.start();
        }
    }

    public void animateY(int durationMillis, EasingOption easing) {
        if (VERSION.SDK_INT >= 11) {
            ObjectAnimator animatorY = ObjectAnimator.ofFloat(this, "phaseY", new float[]{0.0f, TextTrackStyle.DEFAULT_FONT_SCALE});
            animatorY.setInterpolator(Easing.getEasingFunctionFromOption(easing));
            animatorY.setDuration((long) durationMillis);
            animatorY.addUpdateListener(this.mListener);
            animatorY.start();
        }
    }

    public void animateXY(int durationMillisX, int durationMillisY) {
        if (VERSION.SDK_INT >= 11) {
            ObjectAnimator animatorY = ObjectAnimator.ofFloat(this, "phaseY", new float[]{0.0f, TextTrackStyle.DEFAULT_FONT_SCALE});
            animatorY.setDuration((long) durationMillisY);
            ObjectAnimator animatorX = ObjectAnimator.ofFloat(this, "phaseX", new float[]{0.0f, TextTrackStyle.DEFAULT_FONT_SCALE});
            animatorX.setDuration((long) durationMillisX);
            if (durationMillisX > durationMillisY) {
                animatorX.addUpdateListener(this.mListener);
            } else {
                animatorY.addUpdateListener(this.mListener);
            }
            animatorX.start();
            animatorY.start();
        }
    }

    public void animateX(int durationMillis) {
        if (VERSION.SDK_INT >= 11) {
            ObjectAnimator animatorX = ObjectAnimator.ofFloat(this, "phaseX", new float[]{0.0f, TextTrackStyle.DEFAULT_FONT_SCALE});
            animatorX.setDuration((long) durationMillis);
            animatorX.addUpdateListener(this.mListener);
            animatorX.start();
        }
    }

    public void animateY(int durationMillis) {
        if (VERSION.SDK_INT >= 11) {
            ObjectAnimator animatorY = ObjectAnimator.ofFloat(this, "phaseY", new float[]{0.0f, TextTrackStyle.DEFAULT_FONT_SCALE});
            animatorY.setDuration((long) durationMillis);
            animatorY.addUpdateListener(this.mListener);
            animatorY.start();
        }
    }

    public float getPhaseY() {
        return this.mPhaseY;
    }

    public void setPhaseY(float phase) {
        this.mPhaseY = phase;
    }

    public float getPhaseX() {
        return this.mPhaseX;
    }

    public void setPhaseX(float phase) {
        this.mPhaseX = phase;
    }
}
