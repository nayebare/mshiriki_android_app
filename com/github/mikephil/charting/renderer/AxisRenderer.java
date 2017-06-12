package com.github.mikephil.charting.renderer;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.support.v4.view.ViewCompat;
import com.github.mikephil.charting.utils.Transformer;
import com.github.mikephil.charting.utils.ViewPortHandler;
import com.google.android.gms.cast.TextTrackStyle;

public abstract class AxisRenderer extends Renderer {
    protected Paint mAxisLabelPaint;
    protected Paint mAxisLinePaint;
    protected Paint mGridPaint;
    protected Paint mLimitLinePaint;
    protected Transformer mTrans;

    public abstract void renderAxisLabels(Canvas canvas);

    public abstract void renderAxisLine(Canvas canvas);

    public abstract void renderGridLines(Canvas canvas);

    public abstract void renderLimitLines(Canvas canvas);

    public AxisRenderer(ViewPortHandler viewPortHandler, Transformer trans) {
        super(viewPortHandler);
        this.mTrans = trans;
        this.mAxisLabelPaint = new Paint(1);
        this.mGridPaint = new Paint();
        this.mGridPaint.setColor(-7829368);
        this.mGridPaint.setStrokeWidth(TextTrackStyle.DEFAULT_FONT_SCALE);
        this.mGridPaint.setStyle(Style.STROKE);
        this.mGridPaint.setAlpha(90);
        this.mAxisLinePaint = new Paint();
        this.mAxisLinePaint.setColor(ViewCompat.MEASURED_STATE_MASK);
        this.mAxisLinePaint.setStrokeWidth(TextTrackStyle.DEFAULT_FONT_SCALE);
        this.mAxisLinePaint.setStyle(Style.STROKE);
        this.mLimitLinePaint = new Paint(1);
        this.mLimitLinePaint.setStyle(Style.STROKE);
    }

    public Paint getPaintAxisLabels() {
        return this.mAxisLabelPaint;
    }

    public Paint getPaintGrid() {
        return this.mGridPaint;
    }

    public Paint getPaintAxisLine() {
        return this.mAxisLinePaint;
    }

    public Transformer getTransformer() {
        return this.mTrans;
    }
}
