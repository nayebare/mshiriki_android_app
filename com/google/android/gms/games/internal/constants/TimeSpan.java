package com.google.android.gms.games.internal.constants;

import com.google.android.gms.wearable.ChannelApi.ChannelListener;
import com.google.android.gms.wearable.MessageApi;

public final class TimeSpan {
    private TimeSpan() {
        throw new AssertionError("Uninstantiable");
    }

    public static String zziC(int i) {
        switch (i) {
            case MessageApi.FILTER_LITERAL /*0*/:
                return "DAILY";
            case MessageApi.FILTER_PREFIX /*1*/:
                return "WEEKLY";
            case ChannelListener.CLOSE_REASON_REMOTE_CLOSE /*2*/:
                return "ALL_TIME";
            default:
                throw new IllegalArgumentException("Unknown time span " + i);
        }
    }
}
