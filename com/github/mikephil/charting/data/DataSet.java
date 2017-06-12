package com.github.mikephil.charting.data;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.support.v4.view.MotionEventCompat;
import android.support.v4.view.ViewCompat;
import android.support.v4.widget.AutoScrollHelper;
import com.github.mikephil.charting.BuildConfig;
import com.github.mikephil.charting.components.YAxis.AxisDependency;
import com.github.mikephil.charting.formatter.DefaultValueFormatter;
import com.github.mikephil.charting.formatter.ValueFormatter;
import com.github.mikephil.charting.utils.ColorTemplate;
import com.github.mikephil.charting.utils.Utils;
import java.util.ArrayList;
import java.util.List;

public abstract class DataSet<T extends Entry> {
    protected AxisDependency mAxisDependency;
    protected List<Integer> mColors;
    protected boolean mDrawValues;
    protected boolean mHighlightEnabled;
    private String mLabel;
    protected int mLastEnd;
    protected int mLastStart;
    private int mValueColor;
    protected transient ValueFormatter mValueFormatter;
    private float mValueTextSize;
    private Typeface mValueTypeface;
    private boolean mVisible;
    protected float mYMax;
    protected float mYMin;
    protected List<T> mYVals;
    private float mYValueSum;

    public abstract DataSet<T> copy();

    public DataSet(List<T> yVals, String label) {
        this.mColors = null;
        this.mYVals = null;
        this.mYMax = 0.0f;
        this.mYMin = 0.0f;
        this.mYValueSum = 0.0f;
        this.mLastStart = 0;
        this.mLastEnd = 0;
        this.mLabel = "DataSet";
        this.mVisible = true;
        this.mDrawValues = true;
        this.mValueColor = ViewCompat.MEASURED_STATE_MASK;
        this.mValueTextSize = 17.0f;
        this.mAxisDependency = AxisDependency.LEFT;
        this.mHighlightEnabled = true;
        this.mLabel = label;
        this.mYVals = yVals;
        if (this.mYVals == null) {
            this.mYVals = new ArrayList();
        }
        this.mColors = new ArrayList();
        this.mColors.add(Integer.valueOf(Color.rgb(140, 234, MotionEventCompat.ACTION_MASK)));
        calcMinMax(this.mLastStart, this.mLastEnd);
        calcYValueSum();
    }

    public void notifyDataSetChanged() {
        calcMinMax(this.mLastStart, this.mLastEnd);
        calcYValueSum();
    }

    protected void calcMinMax(int start, int end) {
        int yValCount = this.mYVals.size();
        if (yValCount != 0) {
            int endValue;
            if (end == 0 || end >= yValCount) {
                endValue = yValCount - 1;
            } else {
                endValue = end;
            }
            this.mLastStart = start;
            this.mLastEnd = endValue;
            this.mYMin = AutoScrollHelper.NO_MAX;
            this.mYMax = -3.4028235E38f;
            for (int i = start; i <= endValue; i++) {
                Entry e = (Entry) this.mYVals.get(i);
                if (!(e == null || Float.isNaN(e.getVal()))) {
                    if (e.getVal() < this.mYMin) {
                        this.mYMin = e.getVal();
                    }
                    if (e.getVal() > this.mYMax) {
                        this.mYMax = e.getVal();
                    }
                }
            }
            if (this.mYMin == AutoScrollHelper.NO_MAX) {
                this.mYMin = 0.0f;
                this.mYMax = 0.0f;
            }
        }
    }

    private void calcYValueSum() {
        this.mYValueSum = 0.0f;
        for (int i = 0; i < this.mYVals.size(); i++) {
            Entry e = (Entry) this.mYVals.get(i);
            if (e != null) {
                this.mYValueSum += Math.abs(e.getVal());
            }
        }
    }

    public float getAverage() {
        return getYValueSum() / ((float) getValueCount());
    }

    public int getEntryCount() {
        return this.mYVals.size();
    }

    public float getYValForXIndex(int xIndex) {
        Entry e = getEntryForXIndex(xIndex);
        if (e == null || e.getXIndex() != xIndex) {
            return Float.NaN;
        }
        return e.getVal();
    }

    public T getEntryForXIndex(int x) {
        int index = getEntryIndex(x);
        if (index > -1) {
            return (Entry) this.mYVals.get(index);
        }
        return null;
    }

    public int getEntryIndex(int x) {
        int low = 0;
        int high = this.mYVals.size() - 1;
        int closest = -1;
        while (low <= high) {
            int m = (high + low) / 2;
            if (x == ((Entry) this.mYVals.get(m)).getXIndex()) {
                while (m > 0 && ((Entry) this.mYVals.get(m - 1)).getXIndex() == x) {
                    m--;
                }
                return m;
            }
            if (x > ((Entry) this.mYVals.get(m)).getXIndex()) {
                low = m + 1;
            } else {
                high = m - 1;
            }
            closest = m;
        }
        return closest;
    }

    public List<T> getEntriesForXIndex(int x) {
        List<T> entries = new ArrayList();
        int low = 0;
        int high = this.mYVals.size() - 1;
        while (low <= high) {
            int m = (high + low) / 2;
            T entry = (Entry) this.mYVals.get(m);
            if (x == entry.getXIndex()) {
                while (m > 0 && ((Entry) this.mYVals.get(m - 1)).getXIndex() == x) {
                    m--;
                }
                high = this.mYVals.size();
                while (m < high) {
                    entry = (Entry) this.mYVals.get(m);
                    if (entry.getXIndex() != x) {
                        break;
                    }
                    entries.add(entry);
                    m++;
                }
            }
            if (x > entry.getXIndex()) {
                low = m + 1;
            } else {
                high = m - 1;
            }
        }
        return entries;
    }

    public List<T> getYVals() {
        return this.mYVals;
    }

    public float getYValueSum() {
        return this.mYValueSum;
    }

    public float getYMin() {
        return this.mYMin;
    }

    public float getYMax() {
        return this.mYMax;
    }

    public int getValueCount() {
        return this.mYVals.size();
    }

    public int getIndexInEntries(int xIndex) {
        for (int i = 0; i < this.mYVals.size(); i++) {
            if (xIndex == ((Entry) this.mYVals.get(i)).getXIndex()) {
                return i;
            }
        }
        return -1;
    }

    public String toString() {
        StringBuffer buffer = new StringBuffer();
        buffer.append(toSimpleString());
        for (int i = 0; i < this.mYVals.size(); i++) {
            buffer.append(((Entry) this.mYVals.get(i)).toString() + " ");
        }
        return buffer.toString();
    }

    public String toSimpleString() {
        StringBuffer buffer = new StringBuffer();
        buffer.append("DataSet, label: " + (this.mLabel == null ? BuildConfig.FLAVOR : this.mLabel) + ", entries: " + this.mYVals.size() + "\n");
        return buffer.toString();
    }

    public void setLabel(String label) {
        this.mLabel = label;
    }

    public String getLabel() {
        return this.mLabel;
    }

    public void setVisible(boolean visible) {
        this.mVisible = visible;
    }

    public boolean isVisible() {
        return this.mVisible;
    }

    public AxisDependency getAxisDependency() {
        return this.mAxisDependency;
    }

    public void setAxisDependency(AxisDependency dependency) {
        this.mAxisDependency = dependency;
    }

    public void setDrawValues(boolean enabled) {
        this.mDrawValues = enabled;
    }

    public boolean isDrawValuesEnabled() {
        return this.mDrawValues;
    }

    public void addEntry(Entry e) {
        if (e != null) {
            float val = e.getVal();
            if (this.mYVals == null) {
                this.mYVals = new ArrayList();
            }
            if (this.mYVals.size() == 0) {
                this.mYMax = val;
                this.mYMin = val;
            } else {
                if (this.mYMax < val) {
                    this.mYMax = val;
                }
                if (this.mYMin > val) {
                    this.mYMin = val;
                }
            }
            this.mYValueSum += val;
            this.mYVals.add(e);
        }
    }

    public void addEntryOrdered(Entry e) {
        if (e != null) {
            float val = e.getVal();
            if (this.mYVals == null) {
                this.mYVals = new ArrayList();
            }
            if (this.mYVals.size() == 0) {
                this.mYMax = val;
                this.mYMin = val;
            } else {
                if (this.mYMax < val) {
                    this.mYMax = val;
                }
                if (this.mYMin > val) {
                    this.mYMin = val;
                }
            }
            this.mYValueSum += val;
            if (this.mYVals.size() <= 0 || ((Entry) this.mYVals.get(this.mYVals.size() - 1)).getXIndex() <= e.getXIndex()) {
                this.mYVals.add(e);
                return;
            }
            int closestIndex = getEntryIndex(e.getXIndex());
            if (((Entry) this.mYVals.get(closestIndex)).getXIndex() < e.getXIndex()) {
                closestIndex++;
            }
            this.mYVals.add(closestIndex, e);
        }
    }

    public boolean removeEntry(T e) {
        if (e == null) {
            return false;
        }
        boolean removed = this.mYVals.remove(e);
        if (!removed) {
            return removed;
        }
        this.mYValueSum -= e.getVal();
        calcMinMax(this.mLastStart, this.mLastEnd);
        return removed;
    }

    public boolean removeEntry(int xIndex) {
        return removeEntry(getEntryForXIndex(xIndex));
    }

    public boolean removeFirst() {
        boolean removed = false;
        Entry entry = (Entry) this.mYVals.remove(0);
        if (entry != null) {
            removed = true;
        }
        if (removed) {
            this.mYValueSum -= entry.getVal();
            calcMinMax(this.mLastStart, this.mLastEnd);
        }
        return removed;
    }

    public boolean removeLast() {
        boolean removed = false;
        if (this.mYVals.size() > 0) {
            Entry entry = (Entry) this.mYVals.remove(this.mYVals.size() - 1);
            if (entry != null) {
                removed = true;
            }
            if (removed) {
                this.mYValueSum -= entry.getVal();
                calcMinMax(this.mLastStart, this.mLastEnd);
            }
        }
        return removed;
    }

    public void setColors(List<Integer> colors) {
        this.mColors = colors;
    }

    public void setColors(int[] colors) {
        this.mColors = ColorTemplate.createColors(colors);
    }

    public void setColors(int[] colors, Context c) {
        List<Integer> clrs = new ArrayList();
        for (int color : colors) {
            clrs.add(Integer.valueOf(c.getResources().getColor(color)));
        }
        this.mColors = clrs;
    }

    public void addColor(int color) {
        if (this.mColors == null) {
            this.mColors = new ArrayList();
        }
        this.mColors.add(Integer.valueOf(color));
    }

    public void setColor(int color) {
        resetColors();
        this.mColors.add(Integer.valueOf(color));
    }

    public List<Integer> getColors() {
        return this.mColors;
    }

    public int getColor(int index) {
        return ((Integer) this.mColors.get(index % this.mColors.size())).intValue();
    }

    public int getColor() {
        return ((Integer) this.mColors.get(0)).intValue();
    }

    public void resetColors() {
        this.mColors = new ArrayList();
    }

    public void setHighlightEnabled(boolean enabled) {
        this.mHighlightEnabled = enabled;
    }

    public boolean isHighlightEnabled() {
        return this.mHighlightEnabled;
    }

    public int getEntryPosition(Entry e) {
        for (int i = 0; i < this.mYVals.size(); i++) {
            if (e.equalTo((Entry) this.mYVals.get(i))) {
                return i;
            }
        }
        return -1;
    }

    public void setValueFormatter(ValueFormatter f) {
        if (f != null) {
            this.mValueFormatter = f;
        }
    }

    public ValueFormatter getValueFormatter() {
        if (this.mValueFormatter == null) {
            return new DefaultValueFormatter(1);
        }
        return this.mValueFormatter;
    }

    public boolean needsDefaultFormatter() {
        if (this.mValueFormatter == null || (this.mValueFormatter instanceof DefaultValueFormatter)) {
            return true;
        }
        return false;
    }

    public void setValueTextColor(int color) {
        this.mValueColor = color;
    }

    public int getValueTextColor() {
        return this.mValueColor;
    }

    public void setValueTypeface(Typeface tf) {
        this.mValueTypeface = tf;
    }

    public Typeface getValueTypeface() {
        return this.mValueTypeface;
    }

    public void setValueTextSize(float size) {
        this.mValueTextSize = Utils.convertDpToPixel(size);
    }

    public float getValueTextSize() {
        return this.mValueTextSize;
    }

    public boolean contains(Entry e) {
        for (Entry entry : this.mYVals) {
            if (entry.equals(e)) {
                return true;
            }
        }
        return false;
    }

    public void clear() {
        this.mYVals.clear();
        this.mLastStart = 0;
        this.mLastEnd = 0;
        notifyDataSetChanged();
    }
}
