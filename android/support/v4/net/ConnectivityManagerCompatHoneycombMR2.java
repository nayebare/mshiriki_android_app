package android.support.v4.net;

import android.annotation.TargetApi;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.annotation.RequiresApi;
import com.google.android.gms.wallet.fragment.WalletFragmentStyle.BuyButtonText;
import com.google.android.gms.wallet.fragment.WalletFragmentStyle.Dimension;
import com.google.android.gms.wearable.ChannelApi.ChannelListener;
import com.google.android.gms.wearable.MessageApi;
import org.apache.http.protocol.HTTP;

@TargetApi(13)
@RequiresApi(13)
class ConnectivityManagerCompatHoneycombMR2 {
    ConnectivityManagerCompatHoneycombMR2() {
    }

    public static boolean isActiveNetworkMetered(ConnectivityManager cm) {
        NetworkInfo info = cm.getActiveNetworkInfo();
        if (info == null) {
            return true;
        }
        switch (info.getType()) {
            case MessageApi.FILTER_LITERAL /*0*/:
            case ChannelListener.CLOSE_REASON_REMOTE_CLOSE /*2*/:
            case ChannelListener.CLOSE_REASON_LOCAL_CLOSE /*3*/:
            case Dimension.UNIT_IN /*4*/:
            case Dimension.UNIT_MM /*5*/:
            case BuyButtonText.LOGO_ONLY /*6*/:
                return true;
            case MessageApi.FILTER_PREFIX /*1*/:
            case BuyButtonText.DONATE_WITH /*7*/:
            case HTTP.HT /*9*/:
                return false;
            default:
                return true;
        }
    }
}
