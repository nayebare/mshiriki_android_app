package com.google.android.gms.games.internal.constants;

import com.google.android.gms.wearable.ChannelApi.ChannelListener;
import com.google.android.gms.wearable.MessageApi;

public final class PlatformType {
    private PlatformType() {
    }

    public static String zziC(int i) {
        switch (i) {
            case MessageApi.FILTER_LITERAL /*0*/:
                return "ANDROID";
            case MessageApi.FILTER_PREFIX /*1*/:
                return "IOS";
            case ChannelListener.CLOSE_REASON_REMOTE_CLOSE /*2*/:
                return "WEB_APP";
            default:
                throw new IllegalArgumentException("Unknown platform type: " + i);
        }
    }
}
