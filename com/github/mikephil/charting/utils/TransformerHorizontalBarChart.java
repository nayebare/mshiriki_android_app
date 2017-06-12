package com.github.mikephil.charting.utils;

import com.google.android.gms.cast.TextTrackStyle;
import com.google.android.gms.games.stats.PlayerStats;

public class TransformerHorizontalBarChart extends Transformer {
    public TransformerHorizontalBarChart(ViewPortHandler viewPortHandler) {
        super(viewPortHandler);
    }

    public void prepareMatrixOffset(boolean inverted) {
        this.mMatrixOffset.reset();
        if (inverted) {
            this.mMatrixOffset.setTranslate(-(this.mViewPortHandler.getChartWidth() - this.mViewPortHandler.offsetRight()), this.mViewPortHandler.getChartHeight() - this.mViewPortHandler.offsetBottom());
            this.mMatrixOffset.postScale(PlayerStats.UNSET_VALUE, TextTrackStyle.DEFAULT_FONT_SCALE);
            return;
        }
        this.mMatrixOffset.postTranslate(this.mViewPortHandler.offsetLeft(), this.mViewPortHandler.getChartHeight() - this.mViewPortHandler.offsetBottom());
    }
}
