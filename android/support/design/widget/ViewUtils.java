package android.support.design.widget;

import android.graphics.PorterDuff.Mode;
import android.os.Build.VERSION;
import com.google.android.gms.games.GamesStatusCodes;
import com.google.android.gms.wallet.fragment.WalletFragmentStyle.Dimension;
import com.google.android.gms.wearable.ChannelApi.ChannelListener;
import org.apache.http.protocol.HTTP;

class ViewUtils {
    static final Creator DEFAULT_ANIMATOR_CREATOR;

    /* renamed from: android.support.design.widget.ViewUtils.1 */
    static class C00611 implements Creator {
        C00611() {
        }

        public ValueAnimatorCompat createAnimator() {
            return new ValueAnimatorCompat(VERSION.SDK_INT >= 12 ? new ValueAnimatorCompatImplHoneycombMr1() : new ValueAnimatorCompatImplGingerbread());
        }
    }

    ViewUtils() {
    }

    static {
        DEFAULT_ANIMATOR_CREATOR = new C00611();
    }

    static ValueAnimatorCompat createAnimator() {
        return DEFAULT_ANIMATOR_CREATOR.createAnimator();
    }

    static boolean objectEquals(Object a, Object b) {
        return a == b || (a != null && a.equals(b));
    }

    static Mode parseTintMode(int value, Mode defaultMode) {
        switch (value) {
            case ChannelListener.CLOSE_REASON_LOCAL_CLOSE /*3*/:
                return Mode.SRC_OVER;
            case Dimension.UNIT_MM /*5*/:
                return Mode.SRC_IN;
            case HTTP.HT /*9*/:
                return Mode.SRC_ATOP;
            case GamesStatusCodes.STATUS_INTERRUPTED /*14*/:
                return Mode.MULTIPLY;
            case GamesStatusCodes.STATUS_TIMEOUT /*15*/:
                return Mode.SCREEN;
            default:
                return defaultMode;
        }
    }
}
