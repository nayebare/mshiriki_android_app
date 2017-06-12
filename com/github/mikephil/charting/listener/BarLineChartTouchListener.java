package com.github.mikephil.charting.listener;

import android.annotation.SuppressLint;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.support.v4.view.MotionEventCompat;
import android.util.Log;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.animation.AnimationUtils;
import com.android.volley.toolbox.ImageRequest;
import com.github.mikephil.charting.charts.BarLineChartBase;
import com.github.mikephil.charting.charts.HorizontalBarChart;
import com.github.mikephil.charting.data.BarLineScatterCandleBubbleData;
import com.github.mikephil.charting.data.BarLineScatterCandleBubbleDataSet;
import com.github.mikephil.charting.data.DataSet;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.listener.ChartTouchListener.ChartGesture;
import com.github.mikephil.charting.utils.Utils;
import com.github.mikephil.charting.utils.ViewPortHandler;
import com.google.android.gms.cast.TextTrackStyle;
import com.google.android.gms.wallet.WalletConstants.CardNetwork;
import com.google.android.gms.wallet.fragment.WalletFragmentStyle.BuyButtonText;
import com.google.android.gms.wallet.fragment.WalletFragmentStyle.Dimension;
import com.google.android.gms.wearable.ChannelApi.ChannelListener;
import com.google.android.gms.wearable.MessageApi;

public class BarLineChartTouchListener extends ChartTouchListener<BarLineChartBase<? extends BarLineScatterCandleBubbleData<? extends BarLineScatterCandleBubbleDataSet<? extends Entry>>>> {
    private DataSet<?> mClosestDataSetToTouch;
    private PointF mDecelerationCurrentPoint;
    private long mDecelerationLastTime;
    private PointF mDecelerationVelocity;
    private Matrix mMatrix;
    private float mSavedDist;
    private Matrix mSavedMatrix;
    private float mSavedXDist;
    private float mSavedYDist;
    private PointF mTouchPointCenter;
    private PointF mTouchStartPoint;
    private VelocityTracker mVelocityTracker;

    public BarLineChartTouchListener(BarLineChartBase<? extends BarLineScatterCandleBubbleData<? extends BarLineScatterCandleBubbleDataSet<? extends Entry>>> chart, Matrix touchMatrix) {
        super(chart);
        this.mMatrix = new Matrix();
        this.mSavedMatrix = new Matrix();
        this.mTouchStartPoint = new PointF();
        this.mTouchPointCenter = new PointF();
        this.mSavedXDist = TextTrackStyle.DEFAULT_FONT_SCALE;
        this.mSavedYDist = TextTrackStyle.DEFAULT_FONT_SCALE;
        this.mSavedDist = TextTrackStyle.DEFAULT_FONT_SCALE;
        this.mDecelerationLastTime = 0;
        this.mDecelerationCurrentPoint = new PointF();
        this.mDecelerationVelocity = new PointF();
        this.mMatrix = touchMatrix;
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public boolean onTouch(View v, MotionEvent event) {
        if (this.mVelocityTracker == null) {
            this.mVelocityTracker = VelocityTracker.obtain();
        }
        this.mVelocityTracker.addMovement(event);
        if (event.getActionMasked() == 3 && this.mVelocityTracker != null) {
            this.mVelocityTracker.recycle();
            this.mVelocityTracker = null;
        }
        if (this.mTouchMode == 0) {
            this.mGestureDetector.onTouchEvent(event);
        }
        if (((BarLineChartBase) this.mChart).isDragEnabled() || ((BarLineChartBase) this.mChart).isScaleXEnabled() || ((BarLineChartBase) this.mChart).isScaleYEnabled()) {
            switch (event.getAction() & MotionEventCompat.ACTION_MASK) {
                case MessageApi.FILTER_LITERAL /*0*/:
                    startAction(event);
                    stopDeceleration();
                    saveTouchStart(event);
                    break;
                case MessageApi.FILTER_PREFIX /*1*/:
                    VelocityTracker velocityTracker = this.mVelocityTracker;
                    int pointerId = event.getPointerId(0);
                    velocityTracker.computeCurrentVelocity(CardNetwork.OTHER, (float) Utils.getMaximumFlingVelocity());
                    float velocityY = velocityTracker.getYVelocity(pointerId);
                    float velocityX = velocityTracker.getXVelocity(pointerId);
                    if ((Math.abs(velocityX) > ((float) Utils.getMinimumFlingVelocity()) || Math.abs(velocityY) > ((float) Utils.getMinimumFlingVelocity())) && this.mTouchMode == 1 && ((BarLineChartBase) this.mChart).isDragDecelerationEnabled()) {
                        stopDeceleration();
                        this.mDecelerationLastTime = AnimationUtils.currentAnimationTimeMillis();
                        this.mDecelerationCurrentPoint = new PointF(event.getX(), event.getY());
                        this.mDecelerationVelocity = new PointF(velocityX, velocityY);
                        Utils.postInvalidateOnAnimation(this.mChart);
                    }
                    if (this.mTouchMode == 2 || this.mTouchMode == 3 || this.mTouchMode == 4 || this.mTouchMode == 5) {
                        ((BarLineChartBase) this.mChart).calculateOffsets();
                        ((BarLineChartBase) this.mChart).postInvalidate();
                    }
                    this.mTouchMode = 0;
                    ((BarLineChartBase) this.mChart).enableScroll();
                    if (this.mVelocityTracker != null) {
                        this.mVelocityTracker.recycle();
                        this.mVelocityTracker = null;
                    }
                    endAction(event);
                    break;
                case ChannelListener.CLOSE_REASON_REMOTE_CLOSE /*2*/:
                    if (this.mTouchMode != 1) {
                        if (this.mTouchMode != 2 && this.mTouchMode != 3 && this.mTouchMode != 4) {
                            if (this.mTouchMode == 0 && Math.abs(ChartTouchListener.distance(event.getX(), this.mTouchStartPoint.x, event.getY(), this.mTouchStartPoint.y)) > 5.0f) {
                                if (!((BarLineChartBase) this.mChart).hasNoDragOffset()) {
                                    if (((BarLineChartBase) this.mChart).isDragEnabled()) {
                                        this.mLastGesture = ChartGesture.DRAG;
                                        this.mTouchMode = 1;
                                        break;
                                    }
                                } else if (!((BarLineChartBase) this.mChart).isFullyZoomedOut() && ((BarLineChartBase) this.mChart).isDragEnabled()) {
                                    this.mTouchMode = 1;
                                    break;
                                } else {
                                    this.mLastGesture = ChartGesture.DRAG;
                                    if (((BarLineChartBase) this.mChart).isHighlightPerDragEnabled()) {
                                        performHighlightDrag(event);
                                        break;
                                    }
                                }
                            }
                        }
                        ((BarLineChartBase) this.mChart).disableScroll();
                        if (((BarLineChartBase) this.mChart).isScaleXEnabled() || ((BarLineChartBase) this.mChart).isScaleYEnabled()) {
                            performZoom(event);
                            break;
                        }
                    }
                    ((BarLineChartBase) this.mChart).disableScroll();
                    performDrag(event);
                    break;
                    break;
                case ChannelListener.CLOSE_REASON_LOCAL_CLOSE /*3*/:
                    this.mTouchMode = 0;
                    endAction(event);
                    break;
                case Dimension.UNIT_MM /*5*/:
                    if (event.getPointerCount() >= 2) {
                        ((BarLineChartBase) this.mChart).disableScroll();
                        saveTouchStart(event);
                        this.mSavedXDist = getXDist(event);
                        this.mSavedYDist = getYDist(event);
                        this.mSavedDist = spacing(event);
                        if (this.mSavedDist > 10.0f) {
                            if (((BarLineChartBase) this.mChart).isPinchZoomEnabled()) {
                                this.mTouchMode = 4;
                            } else if (this.mSavedXDist > this.mSavedYDist) {
                                this.mTouchMode = 2;
                            } else {
                                this.mTouchMode = 3;
                            }
                        }
                        midPoint(this.mTouchPointCenter, event);
                        break;
                    }
                    break;
                case BuyButtonText.LOGO_ONLY /*6*/:
                    Utils.velocityTrackerPointerUpCleanUpIfNecessary(event, this.mVelocityTracker);
                    this.mTouchMode = 5;
                    break;
            }
            this.mMatrix = ((BarLineChartBase) this.mChart).getViewPortHandler().refresh(this.mMatrix, this.mChart, true);
        }
        return true;
    }

    private void saveTouchStart(MotionEvent event) {
        this.mSavedMatrix.set(this.mMatrix);
        this.mTouchStartPoint.set(event.getX(), event.getY());
        this.mClosestDataSetToTouch = ((BarLineChartBase) this.mChart).getDataSetByTouchPoint(event.getX(), event.getY());
    }

    private void performDrag(MotionEvent event) {
        float dX;
        float dY;
        this.mLastGesture = ChartGesture.DRAG;
        this.mMatrix.set(this.mSavedMatrix);
        OnChartGestureListener l = ((BarLineChartBase) this.mChart).getOnChartGestureListener();
        if (!((BarLineChartBase) this.mChart).isAnyAxisInverted() || this.mClosestDataSetToTouch == null || !((BarLineChartBase) this.mChart).getAxis(this.mClosestDataSetToTouch.getAxisDependency()).isInverted()) {
            dX = event.getX() - this.mTouchStartPoint.x;
            dY = event.getY() - this.mTouchStartPoint.y;
        } else if (this.mChart instanceof HorizontalBarChart) {
            dX = -(event.getX() - this.mTouchStartPoint.x);
            dY = event.getY() - this.mTouchStartPoint.y;
        } else {
            dX = event.getX() - this.mTouchStartPoint.x;
            dY = -(event.getY() - this.mTouchStartPoint.y);
        }
        this.mMatrix.postTranslate(dX, dY);
        if (l != null) {
            l.onChartTranslate(event, dX, dY);
        }
    }

    private void performZoom(MotionEvent event) {
        if (event.getPointerCount() >= 2) {
            OnChartGestureListener l = ((BarLineChartBase) this.mChart).getOnChartGestureListener();
            float totalDist = spacing(event);
            if (totalDist > 10.0f) {
                PointF t = getTrans(this.mTouchPointCenter.x, this.mTouchPointCenter.y);
                boolean canZoomMoreX;
                float scaleX;
                float scaleY;
                if (this.mTouchMode == 4) {
                    this.mLastGesture = ChartGesture.PINCH_ZOOM;
                    float scale = totalDist / this.mSavedDist;
                    canZoomMoreX = (scale > TextTrackStyle.DEFAULT_FONT_SCALE ? 1 : (scale == TextTrackStyle.DEFAULT_FONT_SCALE ? 0 : -1)) < 0 ? ((BarLineChartBase) this.mChart).getViewPortHandler().canZoomOutMoreX() : ((BarLineChartBase) this.mChart).getViewPortHandler().canZoomInMoreX();
                    scaleX = ((BarLineChartBase) this.mChart).isScaleXEnabled() ? scale : TextTrackStyle.DEFAULT_FONT_SCALE;
                    scaleY = ((BarLineChartBase) this.mChart).isScaleYEnabled() ? scale : TextTrackStyle.DEFAULT_FONT_SCALE;
                    if (((BarLineChartBase) this.mChart).isScaleYEnabled() || canZoomMoreX) {
                        this.mMatrix.set(this.mSavedMatrix);
                        this.mMatrix.postScale(scaleX, scaleY, t.x, t.y);
                        if (l != null) {
                            l.onChartScale(event, scaleX, scaleY);
                        }
                    }
                } else if (this.mTouchMode == 2 && ((BarLineChartBase) this.mChart).isScaleXEnabled()) {
                    this.mLastGesture = ChartGesture.X_ZOOM;
                    scaleX = getXDist(event) / this.mSavedXDist;
                    if (scaleX < TextTrackStyle.DEFAULT_FONT_SCALE) {
                        canZoomMoreX = ((BarLineChartBase) this.mChart).getViewPortHandler().canZoomOutMoreX();
                    } else {
                        canZoomMoreX = ((BarLineChartBase) this.mChart).getViewPortHandler().canZoomInMoreX();
                    }
                    if (canZoomMoreX) {
                        this.mMatrix.set(this.mSavedMatrix);
                        this.mMatrix.postScale(scaleX, TextTrackStyle.DEFAULT_FONT_SCALE, t.x, t.y);
                        if (l != null) {
                            l.onChartScale(event, scaleX, TextTrackStyle.DEFAULT_FONT_SCALE);
                        }
                    }
                } else if (this.mTouchMode == 3 && ((BarLineChartBase) this.mChart).isScaleYEnabled()) {
                    this.mLastGesture = ChartGesture.Y_ZOOM;
                    scaleY = getYDist(event) / this.mSavedYDist;
                    this.mMatrix.set(this.mSavedMatrix);
                    this.mMatrix.postScale(TextTrackStyle.DEFAULT_FONT_SCALE, scaleY, t.x, t.y);
                    if (l != null) {
                        l.onChartScale(event, TextTrackStyle.DEFAULT_FONT_SCALE, scaleY);
                    }
                }
            }
        }
    }

    private void performHighlightDrag(MotionEvent e) {
        Highlight h = ((BarLineChartBase) this.mChart).getHighlightByTouchPoint(e.getX(), e.getY());
        if (h != null && !h.equalTo(this.mLastHighlighted)) {
            this.mLastHighlighted = h;
            ((BarLineChartBase) this.mChart).highlightTouch(h);
        }
    }

    private static void midPoint(PointF point, MotionEvent event) {
        point.set((event.getX(0) + event.getX(1)) / ImageRequest.DEFAULT_IMAGE_BACKOFF_MULT, (event.getY(0) + event.getY(1)) / ImageRequest.DEFAULT_IMAGE_BACKOFF_MULT);
    }

    private static float spacing(MotionEvent event) {
        float x = event.getX(0) - event.getX(1);
        float y = event.getY(0) - event.getY(1);
        return (float) Math.sqrt((double) ((x * x) + (y * y)));
    }

    private static float getXDist(MotionEvent e) {
        return Math.abs(e.getX(0) - e.getX(1));
    }

    private static float getYDist(MotionEvent e) {
        return Math.abs(e.getY(0) - e.getY(1));
    }

    public PointF getTrans(float x, float y) {
        float yTrans;
        ViewPortHandler vph = ((BarLineChartBase) this.mChart).getViewPortHandler();
        float xTrans = x - vph.offsetLeft();
        if (((BarLineChartBase) this.mChart).isAnyAxisInverted() && this.mClosestDataSetToTouch != null && ((BarLineChartBase) this.mChart).isInverted(this.mClosestDataSetToTouch.getAxisDependency())) {
            yTrans = -(y - vph.offsetTop());
        } else {
            yTrans = -((((float) ((BarLineChartBase) this.mChart).getMeasuredHeight()) - y) - vph.offsetBottom());
        }
        return new PointF(xTrans, yTrans);
    }

    public Matrix getMatrix() {
        return this.mMatrix;
    }

    public boolean onDoubleTap(MotionEvent e) {
        float f = 1.4f;
        this.mLastGesture = ChartGesture.DOUBLE_TAP;
        OnChartGestureListener l = ((BarLineChartBase) this.mChart).getOnChartGestureListener();
        if (l != null) {
            l.onChartDoubleTapped(e);
            return super.onDoubleTap(e);
        }
        if (((BarLineChartBase) this.mChart).isDoubleTapToZoomEnabled()) {
            float f2;
            PointF trans = getTrans(e.getX(), e.getY());
            BarLineChartBase barLineChartBase = (BarLineChartBase) this.mChart;
            if (((BarLineChartBase) this.mChart).isScaleXEnabled()) {
                f2 = 1.4f;
            } else {
                f2 = TextTrackStyle.DEFAULT_FONT_SCALE;
            }
            if (!((BarLineChartBase) this.mChart).isScaleYEnabled()) {
                f = TextTrackStyle.DEFAULT_FONT_SCALE;
            }
            barLineChartBase.zoom(f2, f, trans.x, trans.y);
            if (((BarLineChartBase) this.mChart).isLogEnabled()) {
                Log.i("BarlineChartTouch", "Double-Tap, Zooming In, x: " + trans.x + ", y: " + trans.y);
            }
        }
        return super.onDoubleTap(e);
    }

    public void onLongPress(MotionEvent e) {
        this.mLastGesture = ChartGesture.LONG_PRESS;
        OnChartGestureListener l = ((BarLineChartBase) this.mChart).getOnChartGestureListener();
        if (l != null) {
            l.onChartLongPressed(e);
        }
    }

    public boolean onSingleTapUp(MotionEvent e) {
        this.mLastGesture = ChartGesture.SINGLE_TAP;
        OnChartGestureListener l = ((BarLineChartBase) this.mChart).getOnChartGestureListener();
        if (l != null) {
            l.onChartSingleTapped(e);
        }
        if (!((BarLineChartBase) this.mChart).isHighlightPerTapEnabled()) {
            return false;
        }
        performHighlight(((BarLineChartBase) this.mChart).getHighlightByTouchPoint(e.getX(), e.getY()), e);
        return super.onSingleTapUp(e);
    }

    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
        this.mLastGesture = ChartGesture.FLING;
        OnChartGestureListener l = ((BarLineChartBase) this.mChart).getOnChartGestureListener();
        if (l != null) {
            l.onChartFling(e1, e2, velocityX, velocityY);
        }
        return super.onFling(e1, e2, velocityX, velocityY);
    }

    public void stopDeceleration() {
        this.mDecelerationVelocity = new PointF(0.0f, 0.0f);
    }

    public void computeScroll() {
        if (this.mDecelerationVelocity.x != 0.0f || this.mDecelerationVelocity.y != 0.0f) {
            long currentTime = AnimationUtils.currentAnimationTimeMillis();
            PointF pointF = this.mDecelerationVelocity;
            pointF.x = ((BarLineChartBase) this.mChart).getDragDecelerationFrictionCoef() * pointF.x;
            pointF = this.mDecelerationVelocity;
            pointF.y = ((BarLineChartBase) this.mChart).getDragDecelerationFrictionCoef() * pointF.y;
            float timeInterval = ((float) (currentTime - this.mDecelerationLastTime)) / 1000.0f;
            float distanceX = this.mDecelerationVelocity.x * timeInterval;
            float distanceY = this.mDecelerationVelocity.y * timeInterval;
            PointF pointF2 = this.mDecelerationCurrentPoint;
            pointF2.x += distanceX;
            pointF2 = this.mDecelerationCurrentPoint;
            pointF2.y += distanceY;
            MotionEvent event = MotionEvent.obtain(currentTime, currentTime, 2, this.mDecelerationCurrentPoint.x, this.mDecelerationCurrentPoint.y, 0);
            performDrag(event);
            event.recycle();
            this.mMatrix = ((BarLineChartBase) this.mChart).getViewPortHandler().refresh(this.mMatrix, this.mChart, false);
            this.mDecelerationLastTime = currentTime;
            if (((double) Math.abs(this.mDecelerationVelocity.x)) >= 0.01d || ((double) Math.abs(this.mDecelerationVelocity.y)) >= 0.01d) {
                Utils.postInvalidateOnAnimation(this.mChart);
                return;
            }
            ((BarLineChartBase) this.mChart).calculateOffsets();
            ((BarLineChartBase) this.mChart).postInvalidate();
            stopDeceleration();
        }
    }
}
