package com.google.android.gms.cast.framework;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.preference.PreferenceManager;
import android.support.annotation.ColorRes;
import android.support.annotation.DimenRes;
import android.support.annotation.StringRes;
import android.support.v7.app.MediaRouteButton;
import android.view.MenuItem;
import android.view.View;
import com.google.android.gms.common.internal.zzac;
import com.google.android.gms.common.util.zzs;
import com.google.android.gms.internal.zzww;
import com.google.android.gms.internal.zzwx;

public interface IntroductoryOverlay {

    public static class Builder {
        private Activity mActivity;
        private View zzapr;
        private int zzaps;
        private String zzapt;
        private OnOverlayDismissedListener zzapu;
        private boolean zzapv;
        private float zzapw;
        private String zzapx;

        public Builder(Activity activity, MediaRouteButton mediaRouteButton) {
            this.mActivity = (Activity) zzac.zzw(activity);
            this.zzapr = (View) zzac.zzw(mediaRouteButton);
        }

        @TargetApi(11)
        public Builder(Activity activity, MenuItem menuItem) {
            this.mActivity = (Activity) zzac.zzw(activity);
            if (zzs.zzyx()) {
                this.zzapr = ((MenuItem) zzac.zzw(menuItem)).getActionView();
            }
        }

        public IntroductoryOverlay build() {
            return zzs.zzyC() ? new zzww(this) : new zzwx(this);
        }

        public Activity getActivity() {
            return this.mActivity;
        }

        public Builder setButtonText(@StringRes int i) {
            this.zzapx = this.mActivity.getResources().getString(i);
            return this;
        }

        public Builder setButtonText(String str) {
            this.zzapx = str;
            return this;
        }

        public Builder setFocusRadius(float f) {
            this.zzapw = f;
            return this;
        }

        public Builder setFocusRadiusId(@DimenRes int i) {
            this.zzapw = this.mActivity.getResources().getDimension(i);
            return this;
        }

        public Builder setOnOverlayDismissedListener(OnOverlayDismissedListener onOverlayDismissedListener) {
            this.zzapu = onOverlayDismissedListener;
            return this;
        }

        public Builder setOverlayColor(@ColorRes int i) {
            this.zzaps = this.mActivity.getResources().getColor(i);
            return this;
        }

        public Builder setSingleTime() {
            this.zzapv = true;
            return this;
        }

        public Builder setTitleText(@StringRes int i) {
            this.zzapt = this.mActivity.getResources().getString(i);
            return this;
        }

        public Builder setTitleText(String str) {
            this.zzapt = str;
            return this;
        }

        public View zzst() {
            return this.zzapr;
        }

        public OnOverlayDismissedListener zzsu() {
            return this.zzapu;
        }

        public int zzsv() {
            return this.zzaps;
        }

        public boolean zzsw() {
            return this.zzapv;
        }

        public String zzsx() {
            return this.zzapt;
        }

        public String zzsy() {
            return this.zzapx;
        }

        public float zzsz() {
            return this.zzapw;
        }
    }

    public interface OnOverlayDismissedListener {
        void onOverlayDismissed();
    }

    public static class zza {
        public static void zzac(Context context) {
            PreferenceManager.getDefaultSharedPreferences(context).edit().putBoolean("googlecast-introOverlayShown", true).apply();
        }

        public static boolean zzad(Context context) {
            return PreferenceManager.getDefaultSharedPreferences(context).getBoolean("googlecast-introOverlayShown", false);
        }
    }

    void remove();

    void show();
}
