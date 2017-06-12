package com.google.android.gms.games.internal.constants;

import com.google.android.gms.games.internal.GamesLog;
import com.google.android.gms.wearable.ChannelApi.ChannelListener;
import com.google.android.gms.wearable.MessageApi;

public final class RequestType {
    private RequestType() {
    }

    public static String zziC(int i) {
        switch (i) {
            case MessageApi.FILTER_PREFIX /*1*/:
                return "GIFT";
            case ChannelListener.CLOSE_REASON_REMOTE_CLOSE /*2*/:
                return "WISH";
            default:
                GamesLog.zzF("RequestType", "Unknown request type: " + i);
                return "UNKNOWN_TYPE";
        }
    }
}
