package com.google.android.gms.cast.framework.internal.featurehighlight;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.annotation.ColorInt;
import android.support.annotation.Nullable;
import android.support.v4.view.GestureDetectorCompat;
import android.util.AttributeSet;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnLayoutChangeListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import com.google.android.gms.C0473R;
import com.google.android.gms.cast.TextTrackStyle;
import com.google.android.gms.internal.zzbim;
import com.google.android.gms.internal.zzbir;

public final class zza extends ViewGroup {
    private View targetView;
    private final int[] zzapV;
    private final Rect zzapW;
    private final Rect zzapX;
    private final zze zzapY;
    private final zzc zzapZ;
    private zzb zzaqa;
    @Nullable
    private View zzaqb;
    @Nullable
    private Animator zzaqc;
    private final zzd zzaqd;
    private final GestureDetectorCompat zzaqe;
    @Nullable
    private GestureDetectorCompat zzaqf;
    private zza zzaqg;
    private boolean zzaqh;

    /* renamed from: com.google.android.gms.cast.framework.internal.featurehighlight.zza.1 */
    class C06041 extends SimpleOnGestureListener {
        final /* synthetic */ zza zzaqi;

        C06041(zza com_google_android_gms_cast_framework_internal_featurehighlight_zza) {
            this.zzaqi = com_google_android_gms_cast_framework_internal_featurehighlight_zza;
        }

        public boolean onSingleTapUp(MotionEvent motionEvent) {
            float x = motionEvent.getX();
            float y = motionEvent.getY();
            if (!(this.zzaqi.zzc(x, y) && this.zzaqi.zzapY.zzd(x, y))) {
                this.zzaqi.zzaqg.dismiss();
            }
            return true;
        }
    }

    /* renamed from: com.google.android.gms.cast.framework.internal.featurehighlight.zza.2 */
    class C06052 extends SimpleOnGestureListener {
        final /* synthetic */ View zzaqj;
        final /* synthetic */ boolean zzaqk;
        final /* synthetic */ zza zzaql;

        C06052(zza com_google_android_gms_cast_framework_internal_featurehighlight_zza, View view, boolean z, zza com_google_android_gms_cast_framework_internal_featurehighlight_zza_zza) {
            this.zzaqj = view;
            this.zzaqk = z;
            this.zzaql = com_google_android_gms_cast_framework_internal_featurehighlight_zza_zza;
        }

        public boolean onSingleTapUp(MotionEvent motionEvent) {
            if (this.zzaqj.getParent() != null) {
                this.zzaqj.performClick();
            }
            if (this.zzaqk) {
                this.zzaql.zzsE();
            }
            return true;
        }
    }

    /* renamed from: com.google.android.gms.cast.framework.internal.featurehighlight.zza.3 */
    class C06063 implements OnLayoutChangeListener {
        final /* synthetic */ zza zzaqi;
        final /* synthetic */ Runnable zzaqm;

        C06063(zza com_google_android_gms_cast_framework_internal_featurehighlight_zza, Runnable runnable) {
            this.zzaqi = com_google_android_gms_cast_framework_internal_featurehighlight_zza;
            this.zzaqm = runnable;
        }

        public void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
            if (this.zzaqm != null) {
                this.zzaqm.run();
            }
            this.zzaqi.zzsH();
            this.zzaqi.removeOnLayoutChangeListener(this);
        }
    }

    /* renamed from: com.google.android.gms.cast.framework.internal.featurehighlight.zza.4 */
    class C06074 extends AnimatorListenerAdapter {
        final /* synthetic */ zza zzaqi;

        C06074(zza com_google_android_gms_cast_framework_internal_featurehighlight_zza) {
            this.zzaqi = com_google_android_gms_cast_framework_internal_featurehighlight_zza;
        }

        public void onAnimationEnd(Animator animator) {
            this.zzaqi.zzaqc = this.zzaqi.zzsN();
            this.zzaqi.zzaqc.start();
        }
    }

    /* renamed from: com.google.android.gms.cast.framework.internal.featurehighlight.zza.5 */
    class C06085 extends AnimatorListenerAdapter {
        final /* synthetic */ zza zzaqi;
        final /* synthetic */ Runnable zzaqn;

        C06085(zza com_google_android_gms_cast_framework_internal_featurehighlight_zza, Runnable runnable) {
            this.zzaqi = com_google_android_gms_cast_framework_internal_featurehighlight_zza;
            this.zzaqn = runnable;
        }

        public void onAnimationEnd(Animator animator) {
            this.zzaqi.setVisibility(8);
            this.zzaqi.zzaqc = null;
            if (this.zzaqn != null) {
                this.zzaqn.run();
            }
        }
    }

    /* renamed from: com.google.android.gms.cast.framework.internal.featurehighlight.zza.6 */
    class C06096 extends AnimatorListenerAdapter {
        final /* synthetic */ zza zzaqi;
        final /* synthetic */ Runnable zzaqo;

        C06096(zza com_google_android_gms_cast_framework_internal_featurehighlight_zza, Runnable runnable) {
            this.zzaqi = com_google_android_gms_cast_framework_internal_featurehighlight_zza;
            this.zzaqo = runnable;
        }

        public void onAnimationEnd(Animator animator) {
            this.zzaqi.setVisibility(8);
            this.zzaqi.zzaqc = null;
            if (this.zzaqo != null) {
                this.zzaqo.run();
            }
        }
    }

    public interface zza {
        void dismiss();

        void zzsE();
    }

    public zza(Context context) {
        super(context);
        this.zzapV = new int[2];
        this.zzapW = new Rect();
        this.zzapX = new Rect();
        setId(C0473R.id.cast_featurehighlight_view);
        setWillNotDraw(false);
        this.zzapZ = new zzc(context);
        this.zzapZ.setCallback(this);
        this.zzapY = new zze(context);
        this.zzapY.setCallback(this);
        this.zzaqd = new zzd(this);
        this.zzaqe = new GestureDetectorCompat(context, new C06041(this));
        this.zzaqe.setIsLongpressEnabled(false);
        setVisibility(8);
    }

    private void zza(Animator animator) {
        if (this.zzaqc != null) {
            this.zzaqc.cancel();
        }
        this.zzaqc = animator;
        this.zzaqc.start();
    }

    private void zza(int[] iArr, View view) {
        getLocationInWindow(iArr);
        int i = iArr[0];
        int i2 = iArr[1];
        view.getLocationInWindow(iArr);
        iArr[0] = iArr[0] - i;
        iArr[1] = iArr[1] - i2;
    }

    private boolean zzc(float f, float f2) {
        return this.zzapX.contains(Math.round(f), Math.round(f2));
    }

    private Animator zzk(@Nullable Runnable runnable) {
        ObjectAnimator.ofFloat(this.zzaqa.asView(), "alpha", new float[]{0.0f}).setDuration(200).setInterpolator(zzbim.zzTl());
        Animator zzsO = this.zzapY.zzsO();
        Animator zzsO2 = this.zzapZ.zzsO();
        Animator animatorSet = new AnimatorSet();
        animatorSet.playTogether(new Animator[]{r0, zzsO, zzsO2});
        animatorSet.addListener(new C06085(this, runnable));
        return animatorSet;
    }

    private Animator zzl(@Nullable Runnable runnable) {
        ObjectAnimator.ofFloat(this.zzaqa.asView(), "alpha", new float[]{0.0f}).setDuration(200).setInterpolator(zzbim.zzTl());
        Animator zzf = this.zzapY.zzf(this.zzapW.exactCenterX() - this.zzapY.getCenterX(), this.zzapW.exactCenterY() - this.zzapY.getCenterY());
        Animator zzsP = this.zzapZ.zzsP();
        Animator animatorSet = new AnimatorSet();
        animatorSet.playTogether(new Animator[]{r0, zzf, zzsP});
        animatorSet.addListener(new C06096(this, runnable));
        return animatorSet;
    }

    private Animator zzsM() {
        ObjectAnimator.ofFloat(this.zzaqa.asView(), "alpha", new float[]{0.0f, TextTrackStyle.DEFAULT_FONT_SCALE}).setDuration(350).setInterpolator(zzbim.zzTk());
        Animator zze = this.zzapY.zze(this.zzapW.exactCenterX() - this.zzapY.getCenterX(), this.zzapW.exactCenterY() - this.zzapY.getCenterY());
        Animator zzsM = this.zzapZ.zzsM();
        Animator animatorSet = new AnimatorSet();
        animatorSet.playTogether(new Animator[]{r0, zze, zzsM});
        animatorSet.addListener(new C06074(this));
        return animatorSet;
    }

    private Animator zzsN() {
        return this.zzapZ.zzsN();
    }

    protected boolean checkLayoutParams(LayoutParams layoutParams) {
        return layoutParams instanceof MarginLayoutParams;
    }

    protected LayoutParams generateDefaultLayoutParams() {
        return new MarginLayoutParams(-2, -2);
    }

    public LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new MarginLayoutParams(getContext(), attributeSet);
    }

    protected LayoutParams generateLayoutParams(LayoutParams layoutParams) {
        return new MarginLayoutParams(layoutParams);
    }

    protected void onDraw(Canvas canvas) {
        canvas.save();
        if (this.zzaqb != null) {
            canvas.clipRect(this.zzapX);
        }
        this.zzapY.draw(canvas);
        this.zzapZ.draw(canvas);
        if (this.targetView != null) {
            if (this.targetView.getParent() != null) {
                Bitmap createBitmap = Bitmap.createBitmap(this.targetView.getWidth(), this.targetView.getHeight(), Config.ARGB_8888);
                this.targetView.draw(new Canvas(createBitmap));
                int color = this.zzapY.getColor();
                int red = Color.red(color);
                int green = Color.green(color);
                int blue = Color.blue(color);
                for (color = 0; color < createBitmap.getHeight(); color++) {
                    for (int i = 0; i < createBitmap.getWidth(); i++) {
                        int pixel = createBitmap.getPixel(i, color);
                        if (Color.alpha(pixel) != 0) {
                            createBitmap.setPixel(i, color, Color.argb(Color.alpha(pixel), red, green, blue));
                        }
                    }
                }
                canvas.drawBitmap(createBitmap, (float) this.zzapW.left, (float) this.zzapW.top, null);
            }
            canvas.restore();
            return;
        }
        throw new IllegalStateException("Neither target view nor drawable was set");
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (this.targetView == null) {
            throw new IllegalStateException("Target view must be set before layout");
        }
        if (this.targetView.getParent() != null) {
            zza(this.zzapV, this.targetView);
        }
        this.zzapW.set(this.zzapV[0], this.zzapV[1], this.zzapV[0] + this.targetView.getWidth(), this.zzapV[1] + this.targetView.getHeight());
        if (this.zzaqb != null) {
            zza(this.zzapV, this.zzaqb);
            this.zzapX.set(this.zzapV[0], this.zzapV[1], this.zzapV[0] + this.zzaqb.getMeasuredWidth(), this.zzapV[1] + this.zzaqb.getMeasuredHeight());
        } else {
            this.zzapX.set(i, i2, i3, i4);
        }
        this.zzapY.setBounds(this.zzapX);
        this.zzapZ.setBounds(this.zzapX);
        this.zzaqd.zza(this.zzapW, this.zzapX);
    }

    protected void onMeasure(int i, int i2) {
        setMeasuredDimension(resolveSize(MeasureSpec.getSize(i), i), resolveSize(MeasureSpec.getSize(i2), i2));
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.zzaqh = this.zzapW.contains((int) motionEvent.getX(), (int) motionEvent.getY());
        }
        if (this.zzaqh) {
            if (this.zzaqf != null) {
                this.zzaqf.onTouchEvent(motionEvent);
                if (actionMasked == 1) {
                    motionEvent = MotionEvent.obtain(motionEvent);
                    motionEvent.setAction(3);
                }
            }
            if (this.targetView.getParent() != null) {
                this.targetView.onTouchEvent(motionEvent);
            }
        } else {
            this.zzaqe.onTouchEvent(motionEvent);
        }
        return true;
    }

    protected boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.zzapY || drawable == this.zzapZ || drawable == null;
    }

    public void zza(View view, @Nullable View view2, boolean z, zza com_google_android_gms_cast_framework_internal_featurehighlight_zza_zza) {
        this.targetView = (View) zzbir.zzw(view);
        this.zzaqb = view2;
        this.zzaqg = (zza) zzbir.zzw(com_google_android_gms_cast_framework_internal_featurehighlight_zza_zza);
        this.zzaqf = new GestureDetectorCompat(getContext(), new C06052(this, view, z, com_google_android_gms_cast_framework_internal_featurehighlight_zza_zza));
        this.zzaqf.setIsLongpressEnabled(false);
        setVisibility(4);
    }

    public void zza(zzb com_google_android_gms_cast_framework_internal_featurehighlight_zzb) {
        this.zzaqa = (zzb) zzbir.zzw(com_google_android_gms_cast_framework_internal_featurehighlight_zzb);
        addView(com_google_android_gms_cast_framework_internal_featurehighlight_zzb.asView(), 0);
    }

    public void zzbX(@ColorInt int i) {
        this.zzapY.setColor(i);
    }

    public void zzh(@Nullable Runnable runnable) {
        addOnLayoutChangeListener(new C06063(this, runnable));
    }

    public void zzi(@Nullable Runnable runnable) {
        zza(zzl(runnable));
    }

    public void zzj(@Nullable Runnable runnable) {
        zza(zzk(runnable));
    }

    public void zzsH() {
        if (this.targetView == null) {
            throw new IllegalStateException("Target view must be set before animation");
        }
        setVisibility(0);
        zza(zzsM());
    }

    @Nullable
    Drawable zzsI() {
        return null;
    }

    View zzsJ() {
        return this.zzaqa.asView();
    }

    zze zzsK() {
        return this.zzapY;
    }

    zzc zzsL() {
        return this.zzapZ;
    }
}
