package android.support.v4.view.animation;

import android.view.animation.Interpolator;
import com.google.android.gms.cast.TextTrackStyle;

abstract class LookupTableInterpolator implements Interpolator {
    private final float mStepSize;
    private final float[] mValues;

    public LookupTableInterpolator(float[] values) {
        this.mValues = values;
        this.mStepSize = TextTrackStyle.DEFAULT_FONT_SCALE / ((float) (this.mValues.length - 1));
    }

    public float getInterpolation(float input) {
        if (input >= TextTrackStyle.DEFAULT_FONT_SCALE) {
            return TextTrackStyle.DEFAULT_FONT_SCALE;
        }
        if (input <= 0.0f) {
            return 0.0f;
        }
        int position = Math.min((int) (((float) (this.mValues.length - 1)) * input), this.mValues.length - 2);
        return this.mValues[position] + ((this.mValues[position + 1] - this.mValues[position]) * ((input - (((float) position) * this.mStepSize)) / this.mStepSize));
    }
}
