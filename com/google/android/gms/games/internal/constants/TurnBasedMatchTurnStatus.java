package com.google.android.gms.games.internal.constants;

import com.google.android.gms.games.internal.GamesLog;
import com.google.android.gms.wearable.ChannelApi.ChannelListener;
import com.google.android.gms.wearable.MessageApi;

public final class TurnBasedMatchTurnStatus {
    public static String zziC(int i) {
        switch (i) {
            case MessageApi.FILTER_LITERAL /*0*/:
                return "TURN_STATUS_INVITED";
            case MessageApi.FILTER_PREFIX /*1*/:
                return "TURN_STATUS_MY_TURN";
            case ChannelListener.CLOSE_REASON_REMOTE_CLOSE /*2*/:
                return "TURN_STATUS_THEIR_TURN";
            case ChannelListener.CLOSE_REASON_LOCAL_CLOSE /*3*/:
                return "TURN_STATUS_COMPLETE";
            default:
                GamesLog.zzF("MatchTurnStatus", "Unknown match turn status: " + i);
                return "TURN_STATUS_UNKNOWN";
        }
    }
}
