package com.google.android.gms.internal;

import android.content.Context;
import com.github.mikephil.charting.BuildConfig;
import com.google.android.gms.analytics.GoogleAnalytics;
import com.google.android.gms.analytics.Logger;
import com.google.android.gms.analytics.Tracker;
import com.google.android.gms.wallet.fragment.WalletFragmentStyle.Dimension;
import com.google.android.gms.wearable.ChannelApi.ChannelListener;

public class zzazq {
    private Context mContext;
    private Tracker zzaaC;
    private GoogleAnalytics zzaaE;

    static class zza implements Logger {
        zza() {
        }

        private static int zzmX(int i) {
            switch (i) {
                case ChannelListener.CLOSE_REASON_REMOTE_CLOSE /*2*/:
                    return 0;
                case ChannelListener.CLOSE_REASON_LOCAL_CLOSE /*3*/:
                case Dimension.UNIT_IN /*4*/:
                    return 1;
                case Dimension.UNIT_MM /*5*/:
                    return 2;
                default:
                    return 3;
            }
        }

        public void error(Exception exception) {
            zzayx.zzb(BuildConfig.FLAVOR, exception);
        }

        public void error(String str) {
            zzayx.m23e(str);
        }

        public int getLogLevel() {
            return zzmX(zzayx.getLogLevel());
        }

        public void info(String str) {
            zzayx.zzbd(str);
        }

        public void setLogLevel(int i) {
            zzayx.zzbe("GA uses GTM logger. Please use TagManager.setLogLevel(int) instead.");
        }

        public void verbose(String str) {
            zzayx.m24v(str);
        }

        public void warn(String str) {
            zzayx.zzbe(str);
        }
    }

    public zzazq(Context context) {
        this.mContext = context;
    }

    private synchronized void zzhx(String str) {
        if (this.zzaaE == null) {
            this.zzaaE = GoogleAnalytics.getInstance(this.mContext);
            this.zzaaE.setLogger(new zza());
            this.zzaaC = this.zzaaE.newTracker(str);
        }
    }

    public Tracker zzhw(String str) {
        zzhx(str);
        return this.zzaaC;
    }
}
