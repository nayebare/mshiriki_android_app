package com.github.mikephil.charting.charts;

import android.content.Context;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Log;
import com.android.volley.toolbox.ImageRequest;
import com.github.mikephil.charting.components.YAxis.AxisDependency;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.highlight.BarHighlighter;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.interfaces.BarDataProvider;
import com.github.mikephil.charting.renderer.BarChartRenderer;
import com.github.mikephil.charting.renderer.XAxisRendererBarChart;
import com.google.android.gms.cast.TextTrackStyle;

public class BarChart extends BarLineChartBase<BarData> implements BarDataProvider {
    private boolean mDrawBarShadow;
    private boolean mDrawHighlightArrow;
    private boolean mDrawValueAboveBar;

    public BarChart(Context context) {
        super(context);
        this.mDrawHighlightArrow = false;
        this.mDrawValueAboveBar = true;
        this.mDrawBarShadow = false;
    }

    public BarChart(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.mDrawHighlightArrow = false;
        this.mDrawValueAboveBar = true;
        this.mDrawBarShadow = false;
    }

    public BarChart(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        this.mDrawHighlightArrow = false;
        this.mDrawValueAboveBar = true;
        this.mDrawBarShadow = false;
    }

    protected void init() {
        super.init();
        this.mRenderer = new BarChartRenderer(this, this.mAnimator, this.mViewPortHandler);
        this.mXAxisRenderer = new XAxisRendererBarChart(this.mViewPortHandler, this.mXAxis, this.mLeftAxisTransformer, this);
        this.mHighlighter = new BarHighlighter(this);
        this.mXChartMin = -0.5f;
    }

    protected void calcMinMax() {
        super.calcMinMax();
        this.mDeltaX += 0.5f;
        this.mDeltaX = ((float) ((BarData) this.mData).getDataSetCount()) * this.mDeltaX;
        float groupSpace = ((BarData) this.mData).getGroupSpace();
        this.mDeltaX = (((float) ((BarData) this.mData).getXValCount()) * groupSpace) + this.mDeltaX;
        this.mXChartMax = this.mDeltaX - this.mXChartMin;
    }

    public Highlight getHighlightByTouchPoint(float x, float y) {
        if (!this.mDataNotSet && this.mData != null) {
            return this.mHighlighter.getHighlight(x, y);
        }
        Log.e(Chart.LOG_TAG, "Can't select by touch. No data set.");
        return null;
    }

    public RectF getBarBounds(BarEntry e) {
        float bottom = 0.0f;
        BarDataSet set = (BarDataSet) ((BarData) this.mData).getDataSetForEntry(e);
        if (set == null) {
            return null;
        }
        float top;
        float barspace = set.getBarSpace();
        float y = e.getVal();
        float x = (float) e.getXIndex();
        float spaceHalf = barspace / ImageRequest.DEFAULT_IMAGE_BACKOFF_MULT;
        float left = (x - 0.5f) + spaceHalf;
        float right = (x + 0.5f) - spaceHalf;
        if (y >= 0.0f) {
            top = y;
        } else {
            top = 0.0f;
        }
        if (y <= 0.0f) {
            bottom = y;
        }
        RectF bounds = new RectF(left, top, right, bottom);
        getTransformer(set.getAxisDependency()).rectValueToPixel(bounds);
        return bounds;
    }

    public void setDrawHighlightArrow(boolean enabled) {
        this.mDrawHighlightArrow = enabled;
    }

    public boolean isDrawHighlightArrowEnabled() {
        return this.mDrawHighlightArrow;
    }

    public void setDrawValueAboveBar(boolean enabled) {
        this.mDrawValueAboveBar = enabled;
    }

    public boolean isDrawValueAboveBarEnabled() {
        return this.mDrawValueAboveBar;
    }

    public void setDrawBarShadow(boolean enabled) {
        this.mDrawBarShadow = enabled;
    }

    public boolean isDrawBarShadowEnabled() {
        return this.mDrawBarShadow;
    }

    public BarData getBarData() {
        return (BarData) this.mData;
    }

    public int getLowestVisibleXIndex() {
        float f;
        float step = (float) ((BarData) this.mData).getDataSetCount();
        float div = step <= TextTrackStyle.DEFAULT_FONT_SCALE ? TextTrackStyle.DEFAULT_FONT_SCALE : step + ((BarData) this.mData).getGroupSpace();
        float[] pts = new float[]{this.mViewPortHandler.contentLeft(), this.mViewPortHandler.contentBottom()};
        getTransformer(AxisDependency.LEFT).pixelsToValue(pts);
        if (pts[0] <= getXChartMin()) {
            f = 0.0f;
        } else {
            f = (pts[0] / div) + TextTrackStyle.DEFAULT_FONT_SCALE;
        }
        return (int) f;
    }

    public int getHighestVisibleXIndex() {
        float xChartMax;
        float div = TextTrackStyle.DEFAULT_FONT_SCALE;
        float step = (float) ((BarData) this.mData).getDataSetCount();
        if (step > TextTrackStyle.DEFAULT_FONT_SCALE) {
            div = step + ((BarData) this.mData).getGroupSpace();
        }
        float[] pts = new float[]{this.mViewPortHandler.contentRight(), this.mViewPortHandler.contentBottom()};
        getTransformer(AxisDependency.LEFT).pixelsToValue(pts);
        if (pts[0] >= getXChartMax()) {
            xChartMax = getXChartMax() / div;
        } else {
            xChartMax = pts[0] / div;
        }
        return (int) xChartMax;
    }
}
