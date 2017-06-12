package com.google.android.gms.games.internal.constants;

import com.google.android.gms.wallet.fragment.WalletFragmentStyle.Dimension;
import com.google.android.gms.wearable.ChannelApi.ChannelListener;
import com.google.android.gms.wearable.MessageApi;

public final class MatchResult {
    public static boolean isValid(int i) {
        switch (i) {
            case MessageApi.FILTER_LITERAL /*0*/:
            case MessageApi.FILTER_PREFIX /*1*/:
            case ChannelListener.CLOSE_REASON_REMOTE_CLOSE /*2*/:
            case ChannelListener.CLOSE_REASON_LOCAL_CLOSE /*3*/:
            case Dimension.UNIT_IN /*4*/:
            case Dimension.UNIT_MM /*5*/:
                return true;
            default:
                return false;
        }
    }
}
