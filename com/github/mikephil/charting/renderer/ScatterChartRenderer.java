package com.github.mikephil.charting.renderer;

import android.graphics.Canvas;
import android.graphics.Paint.Style;
import android.graphics.Path;
import com.android.volley.toolbox.ImageRequest;
import com.github.mikephil.charting.animation.ChartAnimator;
import com.github.mikephil.charting.buffer.ScatterBuffer;
import com.github.mikephil.charting.charts.ScatterChart.ScatterShape;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.ScatterData;
import com.github.mikephil.charting.data.ScatterDataSet;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.interfaces.ScatterDataProvider;
import com.github.mikephil.charting.utils.Transformer;
import com.github.mikephil.charting.utils.Utils;
import com.github.mikephil.charting.utils.ViewPortHandler;
import com.google.android.gms.cast.TextTrackStyle;
import com.google.android.gms.wallet.fragment.WalletFragmentStyle.Dimension;
import com.google.android.gms.wearable.ChannelApi.ChannelListener;
import com.google.android.gms.wearable.MessageApi;
import java.util.List;

public class ScatterChartRenderer extends LineScatterCandleRadarRenderer {
    protected ScatterDataProvider mChart;
    protected ScatterBuffer[] mScatterBuffers;

    /* renamed from: com.github.mikephil.charting.renderer.ScatterChartRenderer.1 */
    static /* synthetic */ class C04711 {
        static final /* synthetic */ int[] f19x9beb7303;

        static {
            f19x9beb7303 = new int[ScatterShape.values().length];
            try {
                f19x9beb7303[ScatterShape.SQUARE.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f19x9beb7303[ScatterShape.CIRCLE.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f19x9beb7303[ScatterShape.TRIANGLE.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f19x9beb7303[ScatterShape.CROSS.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
        }
    }

    public ScatterChartRenderer(ScatterDataProvider chart, ChartAnimator animator, ViewPortHandler viewPortHandler) {
        super(animator, viewPortHandler);
        this.mChart = chart;
        this.mRenderPaint.setStrokeWidth(Utils.convertDpToPixel(TextTrackStyle.DEFAULT_FONT_SCALE));
    }

    public void initBuffers() {
        ScatterData scatterData = this.mChart.getScatterData();
        this.mScatterBuffers = new ScatterBuffer[scatterData.getDataSetCount()];
        for (int i = 0; i < this.mScatterBuffers.length; i++) {
            this.mScatterBuffers[i] = new ScatterBuffer(((ScatterDataSet) scatterData.getDataSetByIndex(i)).getEntryCount() * 2);
        }
    }

    public void drawData(Canvas c) {
        for (ScatterDataSet set : this.mChart.getScatterData().getDataSets()) {
            if (set.isVisible()) {
                drawDataSet(c, set);
            }
        }
    }

    protected void drawDataSet(Canvas c, ScatterDataSet dataSet) {
        Transformer trans = this.mChart.getTransformer(dataSet.getAxisDependency());
        float phaseX = this.mAnimator.getPhaseX();
        float phaseY = this.mAnimator.getPhaseY();
        List<Entry> entries = dataSet.getYVals();
        float shapeHalf = dataSet.getScatterShapeSize() / ImageRequest.DEFAULT_IMAGE_BACKOFF_MULT;
        ScatterShape shape = dataSet.getScatterShape();
        ScatterBuffer buffer = this.mScatterBuffers[this.mChart.getScatterData().getIndexOfDataSet(dataSet)];
        buffer.setPhases(phaseX, phaseY);
        buffer.feed(entries);
        trans.pointValuesToPixel(buffer.buffer);
        int i;
        switch (C04711.f19x9beb7303[shape.ordinal()]) {
            case MessageApi.FILTER_PREFIX /*1*/:
                this.mRenderPaint.setStyle(Style.FILL);
                i = 0;
                while (i < buffer.size() && this.mViewPortHandler.isInBoundsRight(buffer.buffer[i])) {
                    if (this.mViewPortHandler.isInBoundsLeft(buffer.buffer[i]) && this.mViewPortHandler.isInBoundsY(buffer.buffer[i + 1])) {
                        this.mRenderPaint.setColor(dataSet.getColor(i / 2));
                        c.drawRect(buffer.buffer[i] - shapeHalf, buffer.buffer[i + 1] - shapeHalf, buffer.buffer[i] + shapeHalf, buffer.buffer[i + 1] + shapeHalf, this.mRenderPaint);
                    }
                    i += 2;
                }
            case ChannelListener.CLOSE_REASON_REMOTE_CLOSE /*2*/:
                this.mRenderPaint.setStyle(Style.FILL);
                i = 0;
                while (i < buffer.size() && this.mViewPortHandler.isInBoundsRight(buffer.buffer[i])) {
                    if (this.mViewPortHandler.isInBoundsLeft(buffer.buffer[i]) && this.mViewPortHandler.isInBoundsY(buffer.buffer[i + 1])) {
                        this.mRenderPaint.setColor(dataSet.getColor(i / 2));
                        c.drawCircle(buffer.buffer[i], buffer.buffer[i + 1], shapeHalf, this.mRenderPaint);
                    }
                    i += 2;
                }
            case ChannelListener.CLOSE_REASON_LOCAL_CLOSE /*3*/:
                this.mRenderPaint.setStyle(Style.FILL);
                Path tri = new Path();
                i = 0;
                while (i < buffer.size() && this.mViewPortHandler.isInBoundsRight(buffer.buffer[i])) {
                    if (this.mViewPortHandler.isInBoundsLeft(buffer.buffer[i]) && this.mViewPortHandler.isInBoundsY(buffer.buffer[i + 1])) {
                        this.mRenderPaint.setColor(dataSet.getColor(i / 2));
                        tri.moveTo(buffer.buffer[i], buffer.buffer[i + 1] - shapeHalf);
                        tri.lineTo(buffer.buffer[i] + shapeHalf, buffer.buffer[i + 1] + shapeHalf);
                        tri.lineTo(buffer.buffer[i] - shapeHalf, buffer.buffer[i + 1] + shapeHalf);
                        tri.close();
                        c.drawPath(tri, this.mRenderPaint);
                        tri.reset();
                    }
                    i += 2;
                }
            case Dimension.UNIT_IN /*4*/:
                this.mRenderPaint.setStyle(Style.STROKE);
                i = 0;
                while (i < buffer.size() && this.mViewPortHandler.isInBoundsRight(buffer.buffer[i])) {
                    if (this.mViewPortHandler.isInBoundsLeft(buffer.buffer[i]) && this.mViewPortHandler.isInBoundsY(buffer.buffer[i + 1])) {
                        this.mRenderPaint.setColor(dataSet.getColor(i / 2));
                        c.drawLine(buffer.buffer[i] - shapeHalf, buffer.buffer[i + 1], buffer.buffer[i] + shapeHalf, buffer.buffer[i + 1], this.mRenderPaint);
                        c.drawLine(buffer.buffer[i], buffer.buffer[i + 1] - shapeHalf, buffer.buffer[i], buffer.buffer[i + 1] + shapeHalf, this.mRenderPaint);
                    }
                    i += 2;
                }
            default:
        }
    }

    public void drawValues(Canvas c) {
        if (((float) this.mChart.getScatterData().getYValCount()) < ((float) this.mChart.getMaxVisibleCount()) * this.mViewPortHandler.getScaleX()) {
            List<ScatterDataSet> dataSets = this.mChart.getScatterData().getDataSets();
            for (int i = 0; i < this.mChart.getScatterData().getDataSetCount(); i++) {
                ScatterDataSet dataSet = (ScatterDataSet) dataSets.get(i);
                if (dataSet.isDrawValuesEnabled() && dataSet.getEntryCount() != 0) {
                    applyValueTextStyle(dataSet);
                    List<Entry> entries = dataSet.getYVals();
                    float[] positions = this.mChart.getTransformer(dataSet.getAxisDependency()).generateTransformedValuesScatter(entries, this.mAnimator.getPhaseY());
                    float shapeSize = dataSet.getScatterShapeSize();
                    int j = 0;
                    while (((float) j) < ((float) positions.length) * this.mAnimator.getPhaseX() && this.mViewPortHandler.isInBoundsRight(positions[j])) {
                        if (this.mViewPortHandler.isInBoundsLeft(positions[j]) && this.mViewPortHandler.isInBoundsY(positions[j + 1])) {
                            Entry entry = (Entry) entries.get(j / 2);
                            drawValue(c, dataSet.getValueFormatter(), entry.getVal(), entry, i, positions[j], positions[j + 1] - shapeSize);
                        }
                        j += 2;
                    }
                }
            }
        }
    }

    public void drawExtras(Canvas c) {
    }

    public void drawHighlighted(Canvas c, Highlight[] indices) {
        for (int i = 0; i < indices.length; i++) {
            ScatterDataSet set = (ScatterDataSet) this.mChart.getScatterData().getDataSetByIndex(indices[i].getDataSetIndex());
            if (set != null && set.isHighlightEnabled()) {
                int xIndex = indices[i].getXIndex();
                if (((float) xIndex) <= this.mChart.getXChartMax() * this.mAnimator.getPhaseX()) {
                    float yVal = set.getYValForXIndex(xIndex);
                    if (yVal != Float.NaN) {
                        float y = yVal * this.mAnimator.getPhaseY();
                        float[] pts = new float[]{(float) xIndex, y};
                        this.mChart.getTransformer(set.getAxisDependency()).pointValuesToPixel(pts);
                        drawHighlightLines(c, pts, set);
                    }
                }
            }
        }
    }
}
