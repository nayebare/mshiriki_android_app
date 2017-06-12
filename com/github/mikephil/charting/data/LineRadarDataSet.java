package com.github.mikephil.charting.data;

import android.graphics.Color;
import android.support.v4.view.MotionEventCompat;
import com.github.mikephil.charting.utils.Utils;
import java.util.List;

public abstract class LineRadarDataSet<T extends Entry> extends LineScatterCandleRadarDataSet<T> {
    private boolean mDrawFilled;
    private int mFillAlpha;
    private int mFillColor;
    private float mLineWidth;

    public LineRadarDataSet(List<T> yVals, String label) {
        super(yVals, label);
        this.mFillColor = Color.rgb(140, 234, MotionEventCompat.ACTION_MASK);
        this.mFillAlpha = 85;
        this.mLineWidth = 2.5f;
        this.mDrawFilled = false;
    }

    public int getFillColor() {
        return this.mFillColor;
    }

    public void setFillColor(int color) {
        this.mFillColor = color;
    }

    public int getFillAlpha() {
        return this.mFillAlpha;
    }

    public void setFillAlpha(int alpha) {
        this.mFillAlpha = alpha;
    }

    public void setLineWidth(float width) {
        if (width < 0.2f) {
            width = 0.2f;
        }
        if (width > 10.0f) {
            width = 10.0f;
        }
        this.mLineWidth = Utils.convertDpToPixel(width);
    }

    public float getLineWidth() {
        return this.mLineWidth;
    }

    public void setDrawFilled(boolean filled) {
        this.mDrawFilled = filled;
    }

    public boolean isDrawFilledEnabled() {
        return this.mDrawFilled;
    }
}
