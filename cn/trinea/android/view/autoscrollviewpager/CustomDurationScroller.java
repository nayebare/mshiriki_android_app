package cn.trinea.android.view.autoscrollviewpager;

import android.content.Context;
import android.view.animation.Interpolator;
import android.widget.Scroller;

public class CustomDurationScroller extends Scroller {
    private double scrollFactor;

    public CustomDurationScroller(Context context) {
        super(context);
        this.scrollFactor = 1.0d;
    }

    public CustomDurationScroller(Context context, Interpolator interpolator) {
        super(context, interpolator);
        this.scrollFactor = 1.0d;
    }

    public void setScrollDurationFactor(double scrollFactor) {
        this.scrollFactor = scrollFactor;
    }

    public void startScroll(int startX, int startY, int dx, int dy, int duration) {
        super.startScroll(startX, startY, dx, dy, (int) (((double) duration) * this.scrollFactor));
    }
}
