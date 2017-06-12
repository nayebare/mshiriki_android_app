package cn.trinea.android.view.autoscrollviewpager;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.animation.Interpolator;
import java.lang.reflect.Field;

public class AutoScrollViewPager extends ViewPager {
    public static final int DEFAULT_INTERVAL = 1500;
    public static final int LEFT = 0;
    public static final int RIGHT = 1;
    public static final int SCROLL_WHAT = 0;
    public static final int SLIDE_BORDER_MODE_CYCLE = 1;
    public static final int SLIDE_BORDER_MODE_NONE = 0;
    public static final int SLIDE_BORDER_MODE_TO_PARENT = 2;
    private int direction;
    private float downX;
    private Handler handler;
    private long interval;
    private boolean isAutoScroll;
    private boolean isBorderAnimation;
    private boolean isCycle;
    private boolean isStopByTouch;
    private CustomDurationScroller scroller;
    private int slideBorderMode;
    private boolean stopScrollWhenTouch;
    private float touchX;

    private class MyHandler extends Handler {
        private MyHandler() {
        }

        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case AutoScrollViewPager.SLIDE_BORDER_MODE_NONE /*0*/:
                    AutoScrollViewPager.this.scrollOnce();
                    AutoScrollViewPager.this.sendScrollMessage(AutoScrollViewPager.this.interval);
                default:
            }
        }
    }

    public AutoScrollViewPager(Context paramContext) {
        super(paramContext);
        this.interval = 1500;
        this.direction = SLIDE_BORDER_MODE_CYCLE;
        this.isCycle = true;
        this.stopScrollWhenTouch = true;
        this.slideBorderMode = SLIDE_BORDER_MODE_NONE;
        this.isBorderAnimation = true;
        this.isAutoScroll = false;
        this.isStopByTouch = false;
        this.touchX = 0.0f;
        this.downX = 0.0f;
        this.scroller = null;
        init();
    }

    public AutoScrollViewPager(Context paramContext, AttributeSet paramAttributeSet) {
        super(paramContext, paramAttributeSet);
        this.interval = 1500;
        this.direction = SLIDE_BORDER_MODE_CYCLE;
        this.isCycle = true;
        this.stopScrollWhenTouch = true;
        this.slideBorderMode = SLIDE_BORDER_MODE_NONE;
        this.isBorderAnimation = true;
        this.isAutoScroll = false;
        this.isStopByTouch = false;
        this.touchX = 0.0f;
        this.downX = 0.0f;
        this.scroller = null;
        init();
    }

    private void init() {
        this.handler = new MyHandler();
        setViewPagerScroller();
    }

    public void startAutoScroll() {
        this.isAutoScroll = true;
        sendScrollMessage(this.interval);
    }

    public void startAutoScroll(int delayTimeInMills) {
        this.isAutoScroll = true;
        sendScrollMessage((long) delayTimeInMills);
    }

    public void stopAutoScroll() {
        this.isAutoScroll = false;
        this.handler.removeMessages(SLIDE_BORDER_MODE_NONE);
    }

    public void setScrollDurationFactor(double scrollFactor) {
        this.scroller.setScrollDurationFactor(scrollFactor);
    }

    private void sendScrollMessage(long delayTimeInMills) {
        this.handler.removeMessages(SLIDE_BORDER_MODE_NONE);
        this.handler.sendEmptyMessageDelayed(SLIDE_BORDER_MODE_NONE, delayTimeInMills);
    }

    private void setViewPagerScroller() {
        try {
            Field scrollerField = ViewPager.class.getDeclaredField("mScroller");
            scrollerField.setAccessible(true);
            Field interpolatorField = ViewPager.class.getDeclaredField("sInterpolator");
            interpolatorField.setAccessible(true);
            this.scroller = new CustomDurationScroller(getContext(), (Interpolator) interpolatorField.get(null));
            scrollerField.set(this, this.scroller);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void scrollOnce() {
        PagerAdapter adapter = getAdapter();
        int nextItem = getCurrentItem();
        if (adapter != null) {
            int totalCount = adapter.getCount();
            if (totalCount > SLIDE_BORDER_MODE_CYCLE) {
                int currentItem;
                if (this.direction == 0) {
                    nextItem--;
                    currentItem = nextItem;
                } else {
                    nextItem += SLIDE_BORDER_MODE_CYCLE;
                    currentItem = nextItem;
                }
                if (nextItem < 0) {
                    if (this.isCycle) {
                        setCurrentItem(totalCount - 1, this.isBorderAnimation);
                    }
                } else if (nextItem != totalCount) {
                    setCurrentItem(nextItem, true);
                } else if (this.isCycle) {
                    setCurrentItem(SLIDE_BORDER_MODE_NONE, this.isBorderAnimation);
                }
                nextItem = currentItem;
            }
        }
    }

    public boolean onTouchEvent(MotionEvent ev) {
        if (this.stopScrollWhenTouch) {
            if (ev.getAction() == 0 && this.isAutoScroll) {
                this.isStopByTouch = true;
                stopAutoScroll();
            } else if (ev.getAction() == SLIDE_BORDER_MODE_CYCLE && this.isStopByTouch) {
                startAutoScroll();
            }
        }
        if (this.slideBorderMode == SLIDE_BORDER_MODE_TO_PARENT || this.slideBorderMode == SLIDE_BORDER_MODE_CYCLE) {
            this.touchX = ev.getX();
            if (ev.getAction() == 0) {
                this.downX = this.touchX;
            }
            int currentItem = getCurrentItem();
            PagerAdapter adapter = getAdapter();
            int pageCount = adapter == null ? SLIDE_BORDER_MODE_NONE : adapter.getCount();
            if ((currentItem == 0 && this.downX <= this.touchX) || (currentItem == pageCount - 1 && this.downX >= this.touchX)) {
                if (this.slideBorderMode == SLIDE_BORDER_MODE_TO_PARENT) {
                    getParent().requestDisallowInterceptTouchEvent(false);
                } else {
                    if (pageCount > SLIDE_BORDER_MODE_CYCLE) {
                        setCurrentItem((pageCount - currentItem) - 1, this.isBorderAnimation);
                    }
                    getParent().requestDisallowInterceptTouchEvent(true);
                }
                return super.onTouchEvent(ev);
            }
        }
        getParent().requestDisallowInterceptTouchEvent(true);
        return super.onTouchEvent(ev);
    }

    public long getInterval() {
        return this.interval;
    }

    public void setInterval(long interval) {
        this.interval = interval;
    }

    public int getDirection() {
        return this.direction == 0 ? SLIDE_BORDER_MODE_NONE : SLIDE_BORDER_MODE_CYCLE;
    }

    public void setDirection(int direction) {
        this.direction = direction;
    }

    public boolean isCycle() {
        return this.isCycle;
    }

    public void setCycle(boolean isCycle) {
        this.isCycle = isCycle;
    }

    public boolean isStopScrollWhenTouch() {
        return this.stopScrollWhenTouch;
    }

    public void setStopScrollWhenTouch(boolean stopScrollWhenTouch) {
        this.stopScrollWhenTouch = stopScrollWhenTouch;
    }

    public int getSlideBorderMode() {
        return this.slideBorderMode;
    }

    public void setSlideBorderMode(int slideBorderMode) {
        this.slideBorderMode = slideBorderMode;
    }

    public boolean isBorderAnimation() {
        return this.isBorderAnimation;
    }

    public void setBorderAnimation(boolean isBorderAnimation) {
        this.isBorderAnimation = isBorderAnimation;
    }
}
