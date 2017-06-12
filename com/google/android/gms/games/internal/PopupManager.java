package com.google.android.gms.games.internal;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.view.Display;
import android.view.View;
import android.view.View.OnAttachStateChangeListener;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import com.google.android.gms.common.util.zzs;
import java.lang.ref.WeakReference;

public class PopupManager {
    protected GamesClientImpl zzbaG;
    protected PopupLocationInfo zzbaH;

    public static final class PopupLocationInfo {
        public int bottom;
        public int gravity;
        public int left;
        public int right;
        public int top;
        public IBinder zzbaI;
        public int zzbaJ;

        private PopupLocationInfo(int i, IBinder iBinder) {
            this.zzbaJ = -1;
            this.left = 0;
            this.top = 0;
            this.right = 0;
            this.bottom = 0;
            this.gravity = i;
            this.zzbaI = iBinder;
        }

        public Bundle zzEM() {
            Bundle bundle = new Bundle();
            bundle.putInt("popupLocationInfo.gravity", this.gravity);
            bundle.putInt("popupLocationInfo.displayId", this.zzbaJ);
            bundle.putInt("popupLocationInfo.left", this.left);
            bundle.putInt("popupLocationInfo.top", this.top);
            bundle.putInt("popupLocationInfo.right", this.right);
            bundle.putInt("popupLocationInfo.bottom", this.bottom);
            return bundle;
        }
    }

    @TargetApi(12)
    private static final class PopupManagerHCMR1 extends PopupManager implements OnAttachStateChangeListener, OnGlobalLayoutListener {
        private boolean zzaYU;
        private WeakReference<View> zzbaK;

        protected PopupManagerHCMR1(GamesClientImpl gamesClientImpl, int i) {
            super(i, null);
            this.zzaYU = false;
        }

        @TargetApi(17)
        private void zzx(View view) {
            int i = -1;
            if (zzs.zzyD()) {
                Display display = view.getDisplay();
                if (display != null) {
                    i = display.getDisplayId();
                }
            }
            IBinder windowToken = view.getWindowToken();
            int[] iArr = new int[2];
            view.getLocationInWindow(iArr);
            int width = view.getWidth();
            int height = view.getHeight();
            this.zzbaH.zzbaJ = i;
            this.zzbaH.zzbaI = windowToken;
            this.zzbaH.left = iArr[0];
            this.zzbaH.top = iArr[1];
            this.zzbaH.right = iArr[0] + width;
            this.zzbaH.bottom = iArr[1] + height;
            if (this.zzaYU) {
                zzEN();
                this.zzaYU = false;
            }
        }

        public void onGlobalLayout() {
            if (this.zzbaK != null) {
                View view = (View) this.zzbaK.get();
                if (view != null) {
                    zzx(view);
                }
            }
        }

        public void onViewAttachedToWindow(View view) {
            zzx(view);
        }

        public void onViewDetachedFromWindow(View view) {
            this.zzbaG.zzEy();
            view.removeOnAttachStateChangeListener(this);
        }

        public void zzEN() {
            if (this.zzbaH.zzbaI != null) {
                super.zzEN();
            } else {
                this.zzaYU = this.zzbaK != null;
            }
        }

        protected void zziB(int i) {
            this.zzbaH = new PopupLocationInfo(null, null);
        }

        @TargetApi(16)
        public void zzw(View view) {
            View view2;
            Context context;
            this.zzbaG.zzEy();
            if (this.zzbaK != null) {
                view2 = (View) this.zzbaK.get();
                context = this.zzbaG.getContext();
                if (view2 == null && (context instanceof Activity)) {
                    view2 = ((Activity) context).getWindow().getDecorView();
                }
                if (view2 != null) {
                    view2.removeOnAttachStateChangeListener(this);
                    ViewTreeObserver viewTreeObserver = view2.getViewTreeObserver();
                    if (zzs.zzyC()) {
                        viewTreeObserver.removeOnGlobalLayoutListener(this);
                    } else {
                        viewTreeObserver.removeGlobalOnLayoutListener(this);
                    }
                }
            }
            this.zzbaK = null;
            context = this.zzbaG.getContext();
            if (view == null && (context instanceof Activity)) {
                view2 = ((Activity) context).findViewById(16908290);
                if (view2 == null) {
                    view2 = ((Activity) context).getWindow().getDecorView();
                }
                GamesLog.zzE("PopupManager", "You have not specified a View to use as content view for popups. Falling back to the Activity content view. Note that this may not work as expected in multi-screen environments");
                view = view2;
            }
            if (view != null) {
                zzx(view);
                this.zzbaK = new WeakReference(view);
                view.addOnAttachStateChangeListener(this);
                view.getViewTreeObserver().addOnGlobalLayoutListener(this);
                return;
            }
            GamesLog.zzF("PopupManager", "No content view usable to display popups. Popups will not be displayed in response to this client's calls. Use setViewForPopups() to set your content view.");
        }
    }

    private PopupManager(GamesClientImpl gamesClientImpl, int i) {
        this.zzbaG = gamesClientImpl;
        zziB(i);
    }

    public static PopupManager zza(GamesClientImpl gamesClientImpl, int i) {
        return zzs.zzyy() ? new PopupManagerHCMR1(gamesClientImpl, i) : new PopupManager(gamesClientImpl, i);
    }

    public void setGravity(int i) {
        this.zzbaH.gravity = i;
    }

    public void zzEN() {
        this.zzbaG.zza(this.zzbaH.zzbaI, this.zzbaH.zzEM());
    }

    public Bundle zzEO() {
        return this.zzbaH.zzEM();
    }

    public IBinder zzEP() {
        return this.zzbaH.zzbaI;
    }

    public PopupLocationInfo zzEQ() {
        return this.zzbaH;
    }

    protected void zziB(int i) {
        this.zzbaH = new PopupLocationInfo(new Binder(), null);
    }

    public void zzw(View view) {
    }
}
