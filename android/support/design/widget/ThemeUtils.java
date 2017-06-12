package android.support.design.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.v7.appcompat.C0283R;

class ThemeUtils {
    private static final int[] APPCOMPAT_CHECK_ATTRS;

    ThemeUtils() {
    }

    static {
        APPCOMPAT_CHECK_ATTRS = new int[]{C0283R.attr.colorPrimary};
    }

    static void checkAppCompatTheme(Context context) {
        boolean failed = false;
        TypedArray a = context.obtainStyledAttributes(APPCOMPAT_CHECK_ATTRS);
        if (!a.hasValue(0)) {
            failed = true;
        }
        if (a != null) {
            a.recycle();
        }
        if (failed) {
            throw new IllegalArgumentException("You need to use a Theme.AppCompat theme (or descendant) with the design library.");
        }
    }
}
