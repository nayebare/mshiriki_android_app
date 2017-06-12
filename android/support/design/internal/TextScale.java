package android.support.design.internal;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.annotation.TargetApi;
import android.support.annotation.RequiresApi;
import android.support.transition.Transition;
import android.support.transition.TransitionValues;
import android.view.ViewGroup;
import android.widget.TextView;
import com.google.android.gms.cast.TextTrackStyle;
import java.util.Map;

@TargetApi(14)
@RequiresApi(14)
public class TextScale extends Transition {
    private static final String PROPNAME_SCALE = "android:textscale:scale";

    /* renamed from: android.support.design.internal.TextScale.1 */
    class C00091 implements AnimatorUpdateListener {
        final /* synthetic */ TextView val$view;

        C00091(TextView textView) {
            this.val$view = textView;
        }

        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            float animatedValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            this.val$view.setScaleX(animatedValue);
            this.val$view.setScaleY(animatedValue);
        }
    }

    public void captureStartValues(TransitionValues transitionValues) {
        captureValues(transitionValues);
    }

    public void captureEndValues(TransitionValues transitionValues) {
        captureValues(transitionValues);
    }

    private void captureValues(TransitionValues transitionValues) {
        if (transitionValues.view instanceof TextView) {
            transitionValues.values.put(PROPNAME_SCALE, Float.valueOf(transitionValues.view.getScaleX()));
        }
    }

    public Animator createAnimator(ViewGroup sceneRoot, TransitionValues startValues, TransitionValues endValues) {
        if (startValues == null || endValues == null || !(startValues.view instanceof TextView) || !(endValues.view instanceof TextView)) {
            return null;
        }
        float startSize;
        float endSize;
        TextView view = endValues.view;
        Map<String, Object> startVals = startValues.values;
        Map<String, Object> endVals = endValues.values;
        if (startVals.get(PROPNAME_SCALE) != null) {
            startSize = ((Float) startVals.get(PROPNAME_SCALE)).floatValue();
        } else {
            startSize = TextTrackStyle.DEFAULT_FONT_SCALE;
        }
        if (endVals.get(PROPNAME_SCALE) != null) {
            endSize = ((Float) endVals.get(PROPNAME_SCALE)).floatValue();
        } else {
            endSize = TextTrackStyle.DEFAULT_FONT_SCALE;
        }
        if (startSize == endSize) {
            return null;
        }
        Animator animator = ValueAnimator.ofFloat(new float[]{startSize, endSize});
        animator.addUpdateListener(new C00091(view));
        return animator;
    }
}
