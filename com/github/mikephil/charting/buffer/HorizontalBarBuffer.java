package com.github.mikephil.charting.buffer;

import com.android.volley.toolbox.ImageRequest;
import com.github.mikephil.charting.data.BarEntry;
import java.util.List;

public class HorizontalBarBuffer extends BarBuffer {
    public HorizontalBarBuffer(int size, float groupspace, int dataSetCount, boolean containsStacks) {
        super(size, groupspace, dataSetCount, containsStacks);
    }

    public void feed(List<BarEntry> entries) {
        float size = ((float) entries.size()) * this.phaseX;
        int dataSetOffset = this.mDataSetCount - 1;
        float barSpaceHalf = this.mBarSpace / ImageRequest.DEFAULT_IMAGE_BACKOFF_MULT;
        float groupSpaceHalf = this.mGroupSpace / ImageRequest.DEFAULT_IMAGE_BACKOFF_MULT;
        int i = 0;
        while (true) {
            if (((float) i) < size) {
                BarEntry e = (BarEntry) entries.get(i);
                float x = (((float) ((e.getXIndex() + (e.getXIndex() * dataSetOffset)) + this.mDataSetIndex)) + (this.mGroupSpace * ((float) e.getXIndex()))) + groupSpaceHalf;
                float y = e.getVal();
                float[] vals = e.getVals();
                float bottom;
                float top;
                float left;
                float right;
                if (this.mContainsStacks && vals != null) {
                    float posY = 0.0f;
                    float negY = -e.getNegativeSum();
                    int k = 0;
                    while (true) {
                        int length = vals.length;
                        if (k >= r0) {
                            break;
                        }
                        float yStart;
                        float value = vals[k];
                        if (value >= 0.0f) {
                            y = posY;
                            yStart = posY + value;
                            posY = yStart;
                        } else {
                            y = negY;
                            yStart = negY + Math.abs(value);
                            negY += Math.abs(value);
                        }
                        bottom = (x - 0.5f) + barSpaceHalf;
                        top = (x + 0.5f) - barSpaceHalf;
                        if (this.mInverted) {
                            if (y >= yStart) {
                                left = y;
                            } else {
                                left = yStart;
                            }
                            if (y <= yStart) {
                                right = y;
                            } else {
                                right = yStart;
                            }
                        } else {
                            if (y >= yStart) {
                                right = y;
                            } else {
                                right = yStart;
                            }
                            if (y <= yStart) {
                                left = y;
                            } else {
                                left = yStart;
                            }
                        }
                        addBar(left * this.phaseY, top, right * this.phaseY, bottom);
                        k++;
                    }
                } else {
                    bottom = (x - 0.5f) + barSpaceHalf;
                    top = (x + 0.5f) - barSpaceHalf;
                    if (this.mInverted) {
                        left = y >= 0.0f ? y : 0.0f;
                        right = y <= 0.0f ? y : 0.0f;
                    } else {
                        right = y >= 0.0f ? y : 0.0f;
                        left = y <= 0.0f ? y : 0.0f;
                    }
                    if (right > 0.0f) {
                        right *= this.phaseY;
                    } else {
                        left *= this.phaseY;
                    }
                    addBar(left, top, right, bottom);
                }
                i++;
            } else {
                reset();
                return;
            }
        }
    }
}
