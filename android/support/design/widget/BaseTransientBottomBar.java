package android.support.design.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.support.annotation.IntRange;
import android.support.annotation.NonNull;
import android.support.annotation.RestrictTo;
import android.support.annotation.RestrictTo.Scope;
import android.support.design.C0003R;
import android.support.design.widget.SwipeDismissBehavior.OnDismissListener;
import android.support.v4.view.OnApplyWindowInsetsListener;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewPropertyAnimatorListenerAdapter;
import android.support.v4.view.WindowInsetsCompat;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityManager;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import com.google.android.gms.wearable.ChannelApi.ChannelListener;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.List;

public abstract class BaseTransientBottomBar<B extends BaseTransientBottomBar<B>> {
    static final int ANIMATION_DURATION = 250;
    static final int ANIMATION_FADE_DURATION = 180;
    public static final int LENGTH_INDEFINITE = -2;
    public static final int LENGTH_LONG = 0;
    public static final int LENGTH_SHORT = -1;
    static final int MSG_DISMISS = 1;
    static final int MSG_SHOW = 0;
    static final Handler sHandler;
    private final AccessibilityManager mAccessibilityManager;
    private List<BaseCallback<B>> mCallbacks;
    private final ContentViewCallback mContentViewCallback;
    private final Context mContext;
    private int mDuration;
    final Callback mManagerCallback;
    private final ViewGroup mTargetParent;
    final SnackbarBaseLayout mView;

    public interface ContentViewCallback {
        void animateContentIn(int i, int i2);

        void animateContentOut(int i, int i2);
    }

    /* renamed from: android.support.design.widget.BaseTransientBottomBar.10 */
    class AnonymousClass10 implements AnimationListener {
        final /* synthetic */ int val$event;

        AnonymousClass10(int i) {
            this.val$event = i;
        }

        public void onAnimationEnd(Animation animation) {
            BaseTransientBottomBar.this.onViewHidden(this.val$event);
        }

        public void onAnimationStart(Animation animation) {
        }

        public void onAnimationRepeat(Animation animation) {
        }
    }

    /* renamed from: android.support.design.widget.BaseTransientBottomBar.1 */
    static class C00131 implements Callback {
        C00131() {
        }

        public boolean handleMessage(Message message) {
            switch (message.what) {
                case BaseTransientBottomBar.LENGTH_LONG /*0*/:
                    ((BaseTransientBottomBar) message.obj).showView();
                    return true;
                case BaseTransientBottomBar.MSG_DISMISS /*1*/:
                    ((BaseTransientBottomBar) message.obj).hideView(message.arg1);
                    return true;
                default:
                    return false;
            }
        }
    }

    /* renamed from: android.support.design.widget.BaseTransientBottomBar.2 */
    class C00142 implements OnApplyWindowInsetsListener {
        C00142() {
        }

        public WindowInsetsCompat onApplyWindowInsets(View v, WindowInsetsCompat insets) {
            v.setPadding(v.getPaddingLeft(), v.getPaddingTop(), v.getPaddingRight(), insets.getSystemWindowInsetBottom());
            return insets;
        }
    }

    /* renamed from: android.support.design.widget.BaseTransientBottomBar.3 */
    class C00153 implements Callback {
        C00153() {
        }

        public void show() {
            BaseTransientBottomBar.sHandler.sendMessage(BaseTransientBottomBar.sHandler.obtainMessage(BaseTransientBottomBar.LENGTH_LONG, BaseTransientBottomBar.this));
        }

        public void dismiss(int event) {
            BaseTransientBottomBar.sHandler.sendMessage(BaseTransientBottomBar.sHandler.obtainMessage(BaseTransientBottomBar.MSG_DISMISS, event, BaseTransientBottomBar.LENGTH_LONG, BaseTransientBottomBar.this));
        }
    }

    /* renamed from: android.support.design.widget.BaseTransientBottomBar.4 */
    class C00164 implements OnDismissListener {
        C00164() {
        }

        public void onDismiss(View view) {
            view.setVisibility(8);
            BaseTransientBottomBar.this.dispatchDismiss(BaseTransientBottomBar.LENGTH_LONG);
        }

        public void onDragStateChanged(int state) {
            switch (state) {
                case BaseTransientBottomBar.LENGTH_LONG /*0*/:
                    SnackbarManager.getInstance().restoreTimeout(BaseTransientBottomBar.this.mManagerCallback);
                case BaseTransientBottomBar.MSG_DISMISS /*1*/:
                case ChannelListener.CLOSE_REASON_REMOTE_CLOSE /*2*/:
                    SnackbarManager.getInstance().cancelTimeout(BaseTransientBottomBar.this.mManagerCallback);
                default:
            }
        }
    }

    @RestrictTo({Scope.LIBRARY_GROUP})
    interface OnAttachStateChangeListener {
        void onViewAttachedToWindow(View view);

        void onViewDetachedFromWindow(View view);
    }

    /* renamed from: android.support.design.widget.BaseTransientBottomBar.5 */
    class C00185 implements OnAttachStateChangeListener {

        /* renamed from: android.support.design.widget.BaseTransientBottomBar.5.1 */
        class C00171 implements Runnable {
            C00171() {
            }

            public void run() {
                BaseTransientBottomBar.this.onViewHidden(3);
            }
        }

        C00185() {
        }

        public void onViewAttachedToWindow(View v) {
        }

        public void onViewDetachedFromWindow(View v) {
            if (BaseTransientBottomBar.this.isShownOrQueued()) {
                BaseTransientBottomBar.sHandler.post(new C00171());
            }
        }
    }

    @RestrictTo({Scope.LIBRARY_GROUP})
    interface OnLayoutChangeListener {
        void onLayoutChange(View view, int i, int i2, int i3, int i4);
    }

    /* renamed from: android.support.design.widget.BaseTransientBottomBar.6 */
    class C00196 implements OnLayoutChangeListener {
        C00196() {
        }

        public void onLayoutChange(View view, int left, int top, int right, int bottom) {
            BaseTransientBottomBar.this.mView.setOnLayoutChangeListener(null);
            if (BaseTransientBottomBar.this.shouldAnimate()) {
                BaseTransientBottomBar.this.animateViewIn();
            } else {
                BaseTransientBottomBar.this.onViewShown();
            }
        }
    }

    /* renamed from: android.support.design.widget.BaseTransientBottomBar.7 */
    class C00207 extends ViewPropertyAnimatorListenerAdapter {
        C00207() {
        }

        public void onAnimationStart(View view) {
            BaseTransientBottomBar.this.mContentViewCallback.animateContentIn(70, BaseTransientBottomBar.ANIMATION_FADE_DURATION);
        }

        public void onAnimationEnd(View view) {
            BaseTransientBottomBar.this.onViewShown();
        }
    }

    /* renamed from: android.support.design.widget.BaseTransientBottomBar.8 */
    class C00218 implements AnimationListener {
        C00218() {
        }

        public void onAnimationEnd(Animation animation) {
            BaseTransientBottomBar.this.onViewShown();
        }

        public void onAnimationStart(Animation animation) {
        }

        public void onAnimationRepeat(Animation animation) {
        }
    }

    /* renamed from: android.support.design.widget.BaseTransientBottomBar.9 */
    class C00229 extends ViewPropertyAnimatorListenerAdapter {
        final /* synthetic */ int val$event;

        C00229(int i) {
            this.val$event = i;
        }

        public void onAnimationStart(View view) {
            BaseTransientBottomBar.this.mContentViewCallback.animateContentOut(BaseTransientBottomBar.LENGTH_LONG, BaseTransientBottomBar.ANIMATION_FADE_DURATION);
        }

        public void onAnimationEnd(View view) {
            BaseTransientBottomBar.this.onViewHidden(this.val$event);
        }
    }

    public static abstract class BaseCallback<B> {
        public static final int DISMISS_EVENT_ACTION = 1;
        public static final int DISMISS_EVENT_CONSECUTIVE = 4;
        public static final int DISMISS_EVENT_MANUAL = 3;
        public static final int DISMISS_EVENT_SWIPE = 0;
        public static final int DISMISS_EVENT_TIMEOUT = 2;

        @RestrictTo({Scope.LIBRARY_GROUP})
        @Retention(RetentionPolicy.SOURCE)
        public @interface DismissEvent {
        }

        public void onDismissed(B b, int event) {
        }

        public void onShown(B b) {
        }
    }

    final class Behavior extends SwipeDismissBehavior<SnackbarBaseLayout> {
        Behavior() {
        }

        public boolean canSwipeDismissView(View child) {
            return child instanceof SnackbarBaseLayout;
        }

        public boolean onInterceptTouchEvent(CoordinatorLayout parent, SnackbarBaseLayout child, MotionEvent event) {
            if (parent.isPointInChildBounds(child, (int) event.getX(), (int) event.getY())) {
                switch (event.getActionMasked()) {
                    case BaseTransientBottomBar.LENGTH_LONG /*0*/:
                        SnackbarManager.getInstance().cancelTimeout(BaseTransientBottomBar.this.mManagerCallback);
                        break;
                    case BaseTransientBottomBar.MSG_DISMISS /*1*/:
                    case ChannelListener.CLOSE_REASON_LOCAL_CLOSE /*3*/:
                        SnackbarManager.getInstance().restoreTimeout(BaseTransientBottomBar.this.mManagerCallback);
                        break;
                }
            }
            return super.onInterceptTouchEvent(parent, child, event);
        }
    }

    @IntRange(from = 1)
    @RestrictTo({Scope.LIBRARY_GROUP})
    @Retention(RetentionPolicy.SOURCE)
    public @interface Duration {
    }

    @RestrictTo({Scope.LIBRARY_GROUP})
    static class SnackbarBaseLayout extends FrameLayout {
        private OnAttachStateChangeListener mOnAttachStateChangeListener;
        private OnLayoutChangeListener mOnLayoutChangeListener;

        SnackbarBaseLayout(Context context) {
            this(context, null);
        }

        SnackbarBaseLayout(Context context, AttributeSet attrs) {
            super(context, attrs);
            TypedArray a = context.obtainStyledAttributes(attrs, C0003R.styleable.SnackbarLayout);
            if (a.hasValue(C0003R.styleable.SnackbarLayout_elevation)) {
                ViewCompat.setElevation(this, (float) a.getDimensionPixelSize(C0003R.styleable.SnackbarLayout_elevation, BaseTransientBottomBar.LENGTH_LONG));
            }
            a.recycle();
            setClickable(true);
        }

        protected void onLayout(boolean changed, int l, int t, int r, int b) {
            super.onLayout(changed, l, t, r, b);
            if (this.mOnLayoutChangeListener != null) {
                this.mOnLayoutChangeListener.onLayoutChange(this, l, t, r, b);
            }
        }

        protected void onAttachedToWindow() {
            super.onAttachedToWindow();
            if (this.mOnAttachStateChangeListener != null) {
                this.mOnAttachStateChangeListener.onViewAttachedToWindow(this);
            }
            ViewCompat.requestApplyInsets(this);
        }

        protected void onDetachedFromWindow() {
            super.onDetachedFromWindow();
            if (this.mOnAttachStateChangeListener != null) {
                this.mOnAttachStateChangeListener.onViewDetachedFromWindow(this);
            }
        }

        void setOnLayoutChangeListener(OnLayoutChangeListener onLayoutChangeListener) {
            this.mOnLayoutChangeListener = onLayoutChangeListener;
        }

        void setOnAttachStateChangeListener(OnAttachStateChangeListener listener) {
            this.mOnAttachStateChangeListener = listener;
        }
    }

    static {
        sHandler = new Handler(Looper.getMainLooper(), new C00131());
    }

    protected BaseTransientBottomBar(@NonNull ViewGroup parent, @NonNull View content, @NonNull ContentViewCallback contentViewCallback) {
        this.mManagerCallback = new C00153();
        if (parent == null) {
            throw new IllegalArgumentException("Transient bottom bar must have non-null parent");
        } else if (content == null) {
            throw new IllegalArgumentException("Transient bottom bar must have non-null content");
        } else if (contentViewCallback == null) {
            throw new IllegalArgumentException("Transient bottom bar must have non-null callback");
        } else {
            this.mTargetParent = parent;
            this.mContentViewCallback = contentViewCallback;
            this.mContext = parent.getContext();
            ThemeUtils.checkAppCompatTheme(this.mContext);
            this.mView = (SnackbarBaseLayout) LayoutInflater.from(this.mContext).inflate(C0003R.layout.design_layout_snackbar, this.mTargetParent, false);
            this.mView.addView(content);
            ViewCompat.setAccessibilityLiveRegion(this.mView, MSG_DISMISS);
            ViewCompat.setImportantForAccessibility(this.mView, MSG_DISMISS);
            ViewCompat.setFitsSystemWindows(this.mView, true);
            ViewCompat.setOnApplyWindowInsetsListener(this.mView, new C00142());
            this.mAccessibilityManager = (AccessibilityManager) this.mContext.getSystemService("accessibility");
        }
    }

    @NonNull
    public B setDuration(int duration) {
        this.mDuration = duration;
        return this;
    }

    public int getDuration() {
        return this.mDuration;
    }

    @NonNull
    public Context getContext() {
        return this.mContext;
    }

    @NonNull
    public View getView() {
        return this.mView;
    }

    public void show() {
        SnackbarManager.getInstance().show(this.mDuration, this.mManagerCallback);
    }

    public void dismiss() {
        dispatchDismiss(3);
    }

    void dispatchDismiss(int event) {
        SnackbarManager.getInstance().dismiss(this.mManagerCallback, event);
    }

    @NonNull
    public B addCallback(@NonNull BaseCallback<B> callback) {
        if (callback != null) {
            if (this.mCallbacks == null) {
                this.mCallbacks = new ArrayList();
            }
            this.mCallbacks.add(callback);
        }
        return this;
    }

    @NonNull
    public B removeCallback(@NonNull BaseCallback<B> callback) {
        if (!(callback == null || this.mCallbacks == null)) {
            this.mCallbacks.remove(callback);
        }
        return this;
    }

    public boolean isShown() {
        return SnackbarManager.getInstance().isCurrent(this.mManagerCallback);
    }

    public boolean isShownOrQueued() {
        return SnackbarManager.getInstance().isCurrentOrNext(this.mManagerCallback);
    }

    final void showView() {
        if (this.mView.getParent() == null) {
            LayoutParams lp = this.mView.getLayoutParams();
            if (lp instanceof CoordinatorLayout.LayoutParams) {
                CoordinatorLayout.LayoutParams clp = (CoordinatorLayout.LayoutParams) lp;
                Behavior behavior = new Behavior();
                behavior.setStartAlphaSwipeDistance(0.1f);
                behavior.setEndAlphaSwipeDistance(0.6f);
                behavior.setSwipeDirection(LENGTH_LONG);
                behavior.setListener(new C00164());
                clp.setBehavior(behavior);
                clp.insetEdge = 80;
            }
            this.mTargetParent.addView(this.mView);
        }
        this.mView.setOnAttachStateChangeListener(new C00185());
        if (!ViewCompat.isLaidOut(this.mView)) {
            this.mView.setOnLayoutChangeListener(new C00196());
        } else if (shouldAnimate()) {
            animateViewIn();
        } else {
            onViewShown();
        }
    }

    void animateViewIn() {
        if (VERSION.SDK_INT >= 14) {
            ViewCompat.setTranslationY(this.mView, (float) this.mView.getHeight());
            ViewCompat.animate(this.mView).translationY(0.0f).setInterpolator(AnimationUtils.FAST_OUT_SLOW_IN_INTERPOLATOR).setDuration(250).setListener(new C00207()).start();
            return;
        }
        Animation anim = AnimationUtils.loadAnimation(this.mView.getContext(), C0003R.anim.design_snackbar_in);
        anim.setInterpolator(AnimationUtils.FAST_OUT_SLOW_IN_INTERPOLATOR);
        anim.setDuration(250);
        anim.setAnimationListener(new C00218());
        this.mView.startAnimation(anim);
    }

    private void animateViewOut(int event) {
        if (VERSION.SDK_INT >= 14) {
            ViewCompat.animate(this.mView).translationY((float) this.mView.getHeight()).setInterpolator(AnimationUtils.FAST_OUT_SLOW_IN_INTERPOLATOR).setDuration(250).setListener(new C00229(event)).start();
            return;
        }
        Animation anim = AnimationUtils.loadAnimation(this.mView.getContext(), C0003R.anim.design_snackbar_out);
        anim.setInterpolator(AnimationUtils.FAST_OUT_SLOW_IN_INTERPOLATOR);
        anim.setDuration(250);
        anim.setAnimationListener(new AnonymousClass10(event));
        this.mView.startAnimation(anim);
    }

    final void hideView(int event) {
        if (shouldAnimate() && this.mView.getVisibility() == 0) {
            animateViewOut(event);
        } else {
            onViewHidden(event);
        }
    }

    void onViewShown() {
        SnackbarManager.getInstance().onShown(this.mManagerCallback);
        if (this.mCallbacks != null) {
            for (int i = this.mCallbacks.size() + LENGTH_SHORT; i >= 0; i += LENGTH_SHORT) {
                ((BaseCallback) this.mCallbacks.get(i)).onShown(this);
            }
        }
    }

    void onViewHidden(int event) {
        SnackbarManager.getInstance().onDismissed(this.mManagerCallback);
        if (this.mCallbacks != null) {
            for (int i = this.mCallbacks.size() + LENGTH_SHORT; i >= 0; i += LENGTH_SHORT) {
                ((BaseCallback) this.mCallbacks.get(i)).onDismissed(this, event);
            }
        }
        if (VERSION.SDK_INT < 11) {
            this.mView.setVisibility(8);
        }
        ViewParent parent = this.mView.getParent();
        if (parent instanceof ViewGroup) {
            ((ViewGroup) parent).removeView(this.mView);
        }
    }

    boolean shouldAnimate() {
        return !this.mAccessibilityManager.isEnabled();
    }
}
