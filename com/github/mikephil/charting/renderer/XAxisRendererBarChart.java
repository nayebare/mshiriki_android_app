package com.github.mikephil.charting.renderer;

import android.graphics.Canvas;
import android.graphics.PointF;
import com.android.volley.toolbox.ImageRequest;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.utils.Transformer;
import com.github.mikephil.charting.utils.Utils;
import com.github.mikephil.charting.utils.ViewPortHandler;
import com.google.android.gms.cast.TextTrackStyle;

public class XAxisRendererBarChart extends XAxisRenderer {
    protected BarChart mChart;

    public XAxisRendererBarChart(ViewPortHandler viewPortHandler, XAxis xAxis, Transformer trans, BarChart chart) {
        super(viewPortHandler, xAxis, trans);
        this.mChart = chart;
    }

    protected void drawLabels(Canvas c, float pos, PointF anchor) {
        float labelRotationAngleDegrees = this.mXAxis.getLabelRotationAngle();
        float[] position = new float[]{0.0f, 0.0f};
        BarData bd = (BarData) this.mChart.getData();
        int step = bd.getDataSetCount();
        int i = this.mMinX;
        while (i <= this.mMaxX) {
            position[0] = (((float) (i * step)) + (((float) i) * bd.getGroupSpace())) + (bd.getGroupSpace() / ImageRequest.DEFAULT_IMAGE_BACKOFF_MULT);
            if (step > 1) {
                position[0] = position[0] + ((((float) step) - TextTrackStyle.DEFAULT_FONT_SCALE) / ImageRequest.DEFAULT_IMAGE_BACKOFF_MULT);
            }
            this.mTrans.pointValuesToPixel(position);
            if (this.mViewPortHandler.isInBoundsX(position[0]) && i >= 0 && i < this.mXAxis.getValues().size()) {
                String label = (String) this.mXAxis.getValues().get(i);
                if (this.mXAxis.isAvoidFirstLastClippingEnabled()) {
                    float width;
                    if (i == this.mXAxis.getValues().size() - 1) {
                        width = (float) Utils.calcTextWidth(this.mAxisLabelPaint, label);
                        if (position[0] + (width / ImageRequest.DEFAULT_IMAGE_BACKOFF_MULT) > this.mViewPortHandler.contentRight()) {
                            position[0] = this.mViewPortHandler.contentRight() - (width / ImageRequest.DEFAULT_IMAGE_BACKOFF_MULT);
                        }
                    } else if (i == 0) {
                        width = (float) Utils.calcTextWidth(this.mAxisLabelPaint, label);
                        if (position[0] - (width / ImageRequest.DEFAULT_IMAGE_BACKOFF_MULT) < this.mViewPortHandler.contentLeft()) {
                            position[0] = this.mViewPortHandler.contentLeft() + (width / ImageRequest.DEFAULT_IMAGE_BACKOFF_MULT);
                        }
                    }
                }
                drawLabel(c, label, i, position[0], pos, anchor, labelRotationAngleDegrees);
            }
            i += this.mXAxis.mAxisLabelModulus;
        }
    }

    public void renderGridLines(Canvas c) {
        if (this.mXAxis.isDrawGridLinesEnabled() && this.mXAxis.isEnabled()) {
            float[] position = new float[]{0.0f, 0.0f};
            this.mGridPaint.setColor(this.mXAxis.getGridColor());
            this.mGridPaint.setStrokeWidth(this.mXAxis.getGridLineWidth());
            BarData bd = (BarData) this.mChart.getData();
            int step = bd.getDataSetCount();
            int i = this.mMinX;
            while (i < this.mMaxX) {
                position[0] = (((float) (i * step)) + (((float) i) * bd.getGroupSpace())) - 0.5f;
                this.mTrans.pointValuesToPixel(position);
                if (this.mViewPortHandler.isInBoundsX(position[0])) {
                    c.drawLine(position[0], this.mViewPortHandler.offsetTop(), position[0], this.mViewPortHandler.contentBottom(), this.mGridPaint);
                }
                i += this.mXAxis.mAxisLabelModulus;
            }
        }
    }
}
