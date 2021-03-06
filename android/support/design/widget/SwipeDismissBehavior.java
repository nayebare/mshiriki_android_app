package android.support.design.widget;

import android.support.annotation.NonNull;
import android.support.design.widget.CoordinatorLayout.Behavior;
import android.support.v4.view.MotionEventCompat;
import android.support.v4.view.ViewCompat;
import android.support.v4.widget.ViewDragHelper;
import android.support.v4.widget.ViewDragHelper.Callback;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.google.android.gms.cast.TextTrackStyle;
import com.google.android.gms.wearable.ChannelApi.ChannelListener;

public class SwipeDismissBehavior<V extends View> extends Behavior<V> {
    private static final float DEFAULT_ALPHA_END_DISTANCE = 0.5f;
    private static final float DEFAULT_ALPHA_START_DISTANCE = 0.0f;
    private static final float DEFAULT_DRAG_DISMISS_THRESHOLD = 0.5f;
    public static final int STATE_DRAGGING = 1;
    public static final int STATE_IDLE = 0;
    public static final int STATE_SETTLING = 2;
    public static final int SWIPE_DIRECTION_ANY = 2;
    public static final int SWIPE_DIRECTION_END_TO_START = 1;
    public static final int SWIPE_DIRECTION_START_TO_END = 0;
    float mAlphaEndSwipeDistance;
    float mAlphaStartSwipeDistance;
    private final Callback mDragCallback;
    float mDragDismissThreshold;
    private boolean mInterceptingEvents;
    OnDismissListener mListener;
    private float mSensitivity;
    private boolean mSensitivitySet;
    int mSwipeDirection;
    ViewDragHelper mViewDragHelper;

    public interface OnDismissListener {
        void onDismiss(View view);

        void onDragStateChanged(int i);
    }

    /* renamed from: android.support.design.widget.SwipeDismissBehavior.1 */
    class C00461 extends Callback {
        private static final int INVALID_POINTER_ID = -1;
        private int mActivePointerId;
        private int mOriginalCapturedViewLeft;

        C00461() {
            this.mActivePointerId = INVALID_POINTER_ID;
        }

        public boolean tryCaptureView(View child, int pointerId) {
            return this.mActivePointerId == INVALID_POINTER_ID && SwipeDismissBehavior.this.canSwipeDismissView(child);
        }

        public void onViewCaptured(View capturedChild, int activePointerId) {
            this.mActivePointerId = activePointerId;
            this.mOriginalCapturedViewLeft = capturedChild.getLeft();
            ViewParent parent = capturedChild.getParent();
            if (parent != null) {
                parent.requestDisallowInterceptTouchEvent(true);
            }
        }

        public void onViewDragStateChanged(int state) {
            if (SwipeDismissBehavior.this.mListener != null) {
                SwipeDismissBehavior.this.mListener.onDragStateChanged(state);
            }
        }

        public void onViewReleased(View child, float xvel, float yvel) {
            int targetLeft;
            this.mActivePointerId = INVALID_POINTER_ID;
            int childWidth = child.getWidth();
            boolean dismiss = false;
            if (shouldDismiss(child, xvel)) {
                targetLeft = child.getLeft() < this.mOriginalCapturedViewLeft ? this.mOriginalCapturedViewLeft - childWidth : this.mOriginalCapturedViewLeft + childWidth;
                dismiss = true;
            } else {
                targetLeft = this.mOriginalCapturedViewLeft;
            }
            if (SwipeDismissBehavior.this.mViewDragHelper.settleCapturedViewAt(targetLeft, child.getTop())) {
                ViewCompat.postOnAnimation(child, new SettleRunnable(child, dismiss));
            } else if (dismiss && SwipeDismissBehavior.this.mListener != null) {
                SwipeDismissBehavior.this.mListener.onDismiss(child);
            }
        }

        private boolean shouldDismiss(View child, float xvel) {
            if (xvel != SwipeDismissBehavior.DEFAULT_ALPHA_START_DISTANCE) {
                boolean isRtl = ViewCompat.getLayoutDirection(child) == SwipeDismissBehavior.SWIPE_DIRECTION_END_TO_START;
                if (SwipeDismissBehavior.this.mSwipeDirection == SwipeDismissBehavior.SWIPE_DIRECTION_ANY) {
                    return true;
                }
                if (SwipeDismissBehavior.this.mSwipeDirection == 0) {
                    if (isRtl) {
                        if (xvel >= SwipeDismissBehavior.DEFAULT_ALPHA_START_DISTANCE) {
                            return false;
                        }
                        return true;
                    } else if (xvel <= SwipeDismissBehavior.DEFAULT_ALPHA_START_DISTANCE) {
                        return false;
                    } else {
                        return true;
                    }
                } else if (SwipeDismissBehavior.this.mSwipeDirection != SwipeDismissBehavior.SWIPE_DIRECTION_END_TO_START) {
                    return false;
                } else {
                    if (isRtl) {
                        if (xvel <= SwipeDismissBehavior.DEFAULT_ALPHA_START_DISTANCE) {
                            return false;
                        }
                        return true;
                    } else if (xvel >= SwipeDismissBehavior.DEFAULT_ALPHA_START_DISTANCE) {
                        return false;
                    } else {
                        return true;
                    }
                }
            }
            if (Math.abs(child.getLeft() - this.mOriginalCapturedViewLeft) < Math.round(((float) child.getWidth()) * SwipeDismissBehavior.this.mDragDismissThreshold)) {
                return false;
            }
            return true;
        }

        public int getViewHorizontalDragRange(View child) {
            return child.getWidth();
        }

        public int clampViewPositionHorizontal(View child, int left, int dx) {
            int min;
            int max;
            boolean isRtl = ViewCompat.getLayoutDirection(child) == SwipeDismissBehavior.SWIPE_DIRECTION_END_TO_START;
            if (SwipeDismissBehavior.this.mSwipeDirection == 0) {
                if (isRtl) {
                    min = this.mOriginalCapturedViewLeft - child.getWidth();
                    max = this.mOriginalCapturedViewLeft;
                } else {
                    min = this.mOriginalCapturedViewLeft;
                    max = this.mOriginalCapturedViewLeft + child.getWidth();
                }
            } else if (SwipeDismissBehavior.this.mSwipeDirection != SwipeDismissBehavior.SWIPE_DIRECTION_END_TO_START) {
                min = this.mOriginalCapturedViewLeft - child.getWidth();
                max = this.mOriginalCapturedViewLeft + child.getWidth();
            } else if (isRtl) {
                min = this.mOriginalCapturedViewLeft;
                max = this.mOriginalCapturedViewLeft + child.getWidth();
            } else {
                min = this.mOriginalCapturedViewLeft - child.getWidth();
                max = this.mOriginalCapturedViewLeft;
            }
            return SwipeDismissBehavior.clamp(min, left, max);
        }

        public int clampViewPositionVertical(View child, int top, int dy) {
            return child.getTop();
        }

        public void onViewPositionChanged(View child, int left, int top, int dx, int dy) {
            float startAlphaDistance = ((float) this.mOriginalCapturedViewLeft) + (((float) child.getWidth()) * SwipeDismissBehavior.this.mAlphaStartSwipeDistance);
            float endAlphaDistance = ((float) this.mOriginalCapturedViewLeft) + (((float) child.getWidth()) * SwipeDismissBehavior.this.mAlphaEndSwipeDistance);
            if (((float) left) <= startAlphaDistance) {
                ViewCompat.setAlpha(child, TextTrackStyle.DEFAULT_FONT_SCALE);
            } else if (((float) left) >= endAlphaDistance) {
                ViewCompat.setAlpha(child, SwipeDismissBehavior.DEFAULT_ALPHA_START_DISTANCE);
            } else {
                ViewCompat.setAlpha(child, SwipeDismissBehavior.clamp((float) SwipeDismissBehavior.DEFAULT_ALPHA_START_DISTANCE, TextTrackStyle.DEFAULT_FONT_SCALE - SwipeDismissBehavior.fraction(startAlphaDistance, endAlphaDistance, (float) left), (float) TextTrackStyle.DEFAULT_FONT_SCALE));
            }
        }
    }

    private class SettleRunnable implements Runnable {
        private final boolean mDismiss;
        private final View mView;

        SettleRunnable(View view, boolean dismiss) {
            this.mView = view;
            this.mDismiss = dismiss;
        }

        public void run() {
            if (SwipeDismissBehavior.this.mViewDragHelper != null && SwipeDismissBehavior.this.mViewDragHelper.continueSettling(true)) {
                ViewCompat.postOnAnimation(this.mView, this);
            } else if (this.mDismiss && SwipeDismissBehavior.this.mListener != null) {
                SwipeDismissBehavior.this.mListener.onDismiss(this.mView);
            }
        }
    }

    public SwipeDismissBehavior() {
        this.mSensitivity = DEFAULT_ALPHA_START_DISTANCE;
        this.mSwipeDirection = SWIPE_DIRECTION_ANY;
        this.mDragDismissThreshold = DEFAULT_DRAG_DISMISS_THRESHOLD;
        this.mAlphaStartSwipeDistance = DEFAULT_ALPHA_START_DISTANCE;
        this.mAlphaEndSwipeDistance = DEFAULT_DRAG_DISMISS_THRESHOLD;
        this.mDragCallback = new C00461();
    }

    public void setListener(OnDismissListener listener) {
        this.mListener = listener;
    }

    public void setSwipeDirection(int direction) {
        this.mSwipeDirection = direction;
    }

    public void setDragDismissDistance(float distance) {
        this.mDragDismissThreshold = clamp((float) DEFAULT_ALPHA_START_DISTANCE, distance, (float) TextTrackStyle.DEFAULT_FONT_SCALE);
    }

    public void setStartAlphaSwipeDistance(float fraction) {
        this.mAlphaStartSwipeDistance = clamp((float) DEFAULT_ALPHA_START_DISTANCE, fraction, (float) TextTrackStyle.DEFAULT_FONT_SCALE);
    }

    public void setEndAlphaSwipeDistance(float fraction) {
        this.mAlphaEndSwipeDistance = clamp((float) DEFAULT_ALPHA_START_DISTANCE, fraction, (float) TextTrackStyle.DEFAULT_FONT_SCALE);
    }

    public void setSensitivity(float sensitivity) {
        this.mSensitivity = sensitivity;
        this.mSensitivitySet = true;
    }

    public boolean onInterceptTouchEvent(CoordinatorLayout parent, V child, MotionEvent event) {
        boolean dispatchEventToHelper = this.mInterceptingEvents;
        switch (MotionEventCompat.getActionMasked(event)) {
            case STATE_IDLE /*0*/:
                this.mInterceptingEvents = parent.isPointInChildBounds(child, (int) event.getX(), (int) event.getY());
                dispatchEventToHelper = this.mInterceptingEvents;
                break;
            case SWIPE_DIRECTION_END_TO_START /*1*/:
            case ChannelListener.CLOSE_REASON_LOCAL_CLOSE /*3*/:
                this.mInterceptingEvents = false;
                break;
        }
        if (!dispatchEventToHelper) {
            return false;
        }
        ensureViewDragHelper(parent);
        return this.mViewDragHelper.shouldInterceptTouchEvent(event);
    }

    public boolean onTouchEvent(CoordinatorLayout parent, V v, MotionEvent event) {
        if (this.mViewDragHelper == null) {
            return false;
        }
        this.mViewDragHelper.processTouchEvent(event);
        return true;
    }

    public boolean canSwipeDismissView(@NonNull View view) {
        return true;
    }

    private void ensureViewDragHelper(ViewGroup parent) {
        if (this.mViewDragHelper == null) {
            ViewDragHelper create;
            if (this.mSensitivitySet) {
                create = ViewDragHelper.create(parent, this.mSensitivity, this.mDragCallback);
            } else {
                create = ViewDragHelper.create(parent, this.mDragCallback);
            }
            this.mViewDragHelper = create;
        }
    }

    static float clamp(float min, float value, float max) {
        return Math.min(Math.max(min, value), max);
    }

    static int clamp(int min, int value, int max) {
        return Math.min(Math.max(min, value), max);
    }

    public int getDragState() {
        return this.mViewDragHelper != null ? this.mViewDragHelper.getViewDragState() : STATE_IDLE;
    }

    static float fraction(float startValue, float endValue, float value) {
        return (value - startValue) / (endValue - startValue);
    }
}
