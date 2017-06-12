package com.google.android.gms.internal;

import com.google.android.gms.C0473R;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.zzac;
import com.google.android.gms.games.GamesStatusCodes;
import com.google.android.gms.games.Notifications;
import com.google.android.gms.games.request.Requests;
import com.google.android.gms.wallet.fragment.WalletFragmentStyle.BuyButtonText;
import com.google.android.gms.wallet.fragment.WalletFragmentStyle.Dimension;
import com.google.android.gms.wearable.ChannelApi.ChannelListener;
import com.google.android.gms.wearable.MessageApi;
import org.apache.http.protocol.HTTP;

public class zzady {
    private final zzbto zzaHK;

    public zzady(zzbto com_google_android_gms_internal_zzbto) {
        this.zzaHK = (zzbto) zzac.zzw(com_google_android_gms_internal_zzbto);
    }

    private static zzbto zza(int i, long j, int i2) {
        zzbto com_google_android_gms_internal_zzbto = new zzbto();
        com_google_android_gms_internal_zzbto.zzcqk = i;
        com_google_android_gms_internal_zzbto.zzcql = j;
        switch (i) {
            case MessageApi.FILTER_PREFIX /*1*/:
            case ChannelListener.CLOSE_REASON_REMOTE_CLOSE /*2*/:
            case ChannelListener.CLOSE_REASON_LOCAL_CLOSE /*3*/:
                com_google_android_gms_internal_zzbto.zzcqn = i2;
                break;
            case Dimension.UNIT_IN /*4*/:
            case Dimension.UNIT_MM /*5*/:
            case BuyButtonText.LOGO_ONLY /*6*/:
                com_google_android_gms_internal_zzbto.zzcqo = i2;
                break;
            case BuyButtonText.DONATE_WITH /*7*/:
            case Requests.MAX_REQUEST_RECIPIENTS /*8*/:
            case HTTP.HT /*9*/:
                com_google_android_gms_internal_zzbto.zzcqp = i2;
                break;
            case HTTP.LF /*10*/:
            case ConnectionResult.LICENSE_CHECK_FAILED /*11*/:
            case C0473R.styleable.MapAttrs_uiZoomGestures /*12*/:
                com_google_android_gms_internal_zzbto.zzcqq = i2;
                break;
            case HTTP.CR /*13*/:
            case GamesStatusCodes.STATUS_INTERRUPTED /*14*/:
            case GamesStatusCodes.STATUS_TIMEOUT /*15*/:
                com_google_android_gms_internal_zzbto.zzcqr = i2;
                break;
            case Notifications.NOTIFICATION_TYPE_LEVEL_UP /*16*/:
            case ConnectionResult.SIGN_IN_FAILED /*17*/:
            case ConnectionResult.SERVICE_UPDATING /*18*/:
                com_google_android_gms_internal_zzbto.zzcqs = i2;
                break;
            default:
                zzcd.zza("AudioStateFenceStub", "Unknown trigger type=%s", Integer.valueOf(i));
                break;
        }
        return com_google_android_gms_internal_zzbto;
    }

    public static zzady zzdv(int i) {
        return new zzady(zza(1, 0, i));
    }

    public static zzady zzzj() {
        return new zzady(zza(2, 3000, 0));
    }

    public static zzady zzzk() {
        return new zzady(zza(3, 3000, 0));
    }

    public zzbto zzzl() {
        return this.zzaHK;
    }
}
