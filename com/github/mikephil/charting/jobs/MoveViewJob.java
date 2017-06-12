package com.github.mikephil.charting.jobs;

import android.view.View;
import com.github.mikephil.charting.utils.Transformer;
import com.github.mikephil.charting.utils.ViewPortHandler;

public class MoveViewJob implements Runnable {
    protected Transformer mTrans;
    protected ViewPortHandler mViewPortHandler;
    protected View view;
    protected float xIndex;
    protected float yValue;

    public MoveViewJob(ViewPortHandler viewPortHandler, float xIndex, float yValue, Transformer trans, View v) {
        this.xIndex = 0.0f;
        this.yValue = 0.0f;
        this.mViewPortHandler = viewPortHandler;
        this.xIndex = xIndex;
        this.yValue = yValue;
        this.mTrans = trans;
        this.view = v;
    }

    public void run() {
        float[] pts = new float[]{this.xIndex, this.yValue};
        this.mTrans.pointValuesToPixel(pts);
        this.mViewPortHandler.centerViewPort(pts, this.view);
    }
}
