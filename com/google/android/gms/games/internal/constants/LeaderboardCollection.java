package com.google.android.gms.games.internal.constants;

import com.google.android.gms.wearable.ChannelApi.ChannelListener;
import com.google.android.gms.wearable.MessageApi;

public final class LeaderboardCollection {
    private LeaderboardCollection() {
    }

    public static String zziC(int i) {
        switch (i) {
            case MessageApi.UNKNOWN_REQUEST_ID /*-1*/:
                return "UNKNOWN";
            case MessageApi.FILTER_LITERAL /*0*/:
                return "PUBLIC";
            case MessageApi.FILTER_PREFIX /*1*/:
                return "SOCIAL";
            case ChannelListener.CLOSE_REASON_REMOTE_CLOSE /*2*/:
                return "SOCIAL_1P";
            default:
                throw new IllegalArgumentException("Unknown leaderboard collection: " + i);
        }
    }
}
