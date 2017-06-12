package com.google.android.gms.internal;

import android.content.Context;
import android.support.annotation.Nullable;
import com.google.android.gms.ads.internal.zzv;
import com.google.android.gms.common.api.Releasable;
import com.google.android.gms.games.request.Requests;
import com.google.android.gms.wallet.fragment.WalletFragmentStyle.BuyButtonText;
import com.google.android.gms.wallet.fragment.WalletFragmentStyle.Dimension;
import com.google.android.gms.wearable.ChannelApi.ChannelListener;
import com.google.android.gms.wearable.MessageApi;
import java.lang.ref.WeakReference;
import java.util.Map;
import org.apache.http.protocol.HTTP;

@zzmb
public abstract class zzil implements Releasable {
    protected Context mContext;
    protected String zzHY;
    protected WeakReference<zzqp> zzHZ;

    public zzil(zzqp com_google_android_gms_internal_zzqp) {
        this.mContext = com_google_android_gms_internal_zzqp.getContext();
        this.zzHY = zzv.zzcJ().zzh(this.mContext, com_google_android_gms_internal_zzqp.zzkY().zzaZ);
        this.zzHZ = new WeakReference(com_google_android_gms_internal_zzqp);
    }

    private void zza(String str, Map<String, String> map) {
        zzqp com_google_android_gms_internal_zzqp = (zzqp) this.zzHZ.get();
        if (com_google_android_gms_internal_zzqp != null) {
            com_google_android_gms_internal_zzqp.zza(str, (Map) map);
        }
    }

    private String zzaf(String str) {
        String str2 = "internal";
        Object obj = -1;
        switch (str.hashCode()) {
            case -1396664534:
                if (str.equals("badUrl")) {
                    obj = 6;
                    break;
                }
                break;
            case -1347010958:
                if (str.equals("inProgress")) {
                    obj = 2;
                    break;
                }
                break;
            case -918817863:
                if (str.equals("downloadTimeout")) {
                    obj = 7;
                    break;
                }
                break;
            case -659376217:
                if (str.equals("contentLengthMissing")) {
                    obj = 3;
                    break;
                }
                break;
            case -642208130:
                if (str.equals("playerFailed")) {
                    obj = 1;
                    break;
                }
                break;
            case -354048396:
                if (str.equals("sizeExceeded")) {
                    obj = 8;
                    break;
                }
                break;
            case -32082395:
                if (str.equals("externalAbort")) {
                    obj = 9;
                    break;
                }
                break;
            case 96784904:
                if (str.equals(MediaRouteProviderProtocol.SERVICE_DATA_ERROR)) {
                    obj = null;
                    break;
                }
                break;
            case 580119100:
                if (str.equals("expireFailed")) {
                    obj = 5;
                    break;
                }
                break;
            case 725497484:
                if (str.equals("noCacheDir")) {
                    obj = 4;
                    break;
                }
                break;
        }
        switch (obj) {
            case MessageApi.FILTER_LITERAL /*0*/:
            case MessageApi.FILTER_PREFIX /*1*/:
            case ChannelListener.CLOSE_REASON_REMOTE_CLOSE /*2*/:
            case ChannelListener.CLOSE_REASON_LOCAL_CLOSE /*3*/:
                return "internal";
            case Dimension.UNIT_IN /*4*/:
            case Dimension.UNIT_MM /*5*/:
                return "io";
            case BuyButtonText.LOGO_ONLY /*6*/:
            case BuyButtonText.DONATE_WITH /*7*/:
                return "network";
            case Requests.MAX_REQUEST_RECIPIENTS /*8*/:
            case HTTP.HT /*9*/:
                return "policy";
            default:
                return str2;
        }
    }

    public abstract void abort();

    public void release() {
    }

    protected void zza(String str, String str2, int i) {
        zzpx.zzXU.post(new 2(this, str, str2, i));
    }

    protected void zza(String str, String str2, int i, int i2, boolean z) {
        zzpx.zzXU.post(new 1(this, str, str2, i, i2, z));
    }

    public void zza(String str, String str2, String str3, @Nullable String str4) {
        zzpx.zzXU.post(new 3(this, str, str2, str3, str4));
    }

    public abstract boolean zzad(String str);

    protected String zzae(String str) {
        return zzeh.zzeO().zzbb(str);
    }
}
