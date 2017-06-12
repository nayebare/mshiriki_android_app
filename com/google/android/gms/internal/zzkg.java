package com.google.android.gms.internal;

import com.google.ads.AdRequest.ErrorCode;
import com.google.ads.AdRequest.Gender;
import com.google.ads.AdSize;
import com.google.ads.mediation.MediationAdRequest;
import com.google.android.gms.ads.zza;
import com.google.android.gms.wallet.fragment.WalletFragmentStyle.Dimension;
import com.google.android.gms.wearable.ChannelApi.ChannelListener;
import com.google.android.gms.wearable.MessageApi;
import java.util.Date;
import java.util.HashSet;

@zzmb
public final class zzkg {
    public static Gender zzG(int i) {
        switch (i) {
            case MessageApi.FILTER_PREFIX /*1*/:
                return Gender.MALE;
            case ChannelListener.CLOSE_REASON_REMOTE_CLOSE /*2*/:
                return Gender.FEMALE;
            default:
                return Gender.UNKNOWN;
        }
    }

    public static int zza(ErrorCode errorCode) {
        switch (1.zzLf[errorCode.ordinal()]) {
            case ChannelListener.CLOSE_REASON_REMOTE_CLOSE /*2*/:
                return 1;
            case ChannelListener.CLOSE_REASON_LOCAL_CLOSE /*3*/:
                return 2;
            case Dimension.UNIT_IN /*4*/:
                return 3;
            default:
                return 0;
        }
    }

    public static AdSize zzc(zzec com_google_android_gms_internal_zzec) {
        int i = 0;
        AdSize[] adSizeArr = new AdSize[]{AdSize.SMART_BANNER, AdSize.BANNER, AdSize.IAB_MRECT, AdSize.IAB_BANNER, AdSize.IAB_LEADERBOARD, AdSize.IAB_WIDE_SKYSCRAPER};
        while (i < 6) {
            if (adSizeArr[i].getWidth() == com_google_android_gms_internal_zzec.width && adSizeArr[i].getHeight() == com_google_android_gms_internal_zzec.height) {
                return adSizeArr[i];
            }
            i++;
        }
        return new AdSize(zza.zza(com_google_android_gms_internal_zzec.width, com_google_android_gms_internal_zzec.height, com_google_android_gms_internal_zzec.zzzk));
    }

    public static MediationAdRequest zzs(zzdy com_google_android_gms_internal_zzdy) {
        return new MediationAdRequest(new Date(com_google_android_gms_internal_zzdy.zzyF), zzG(com_google_android_gms_internal_zzdy.zzyG), com_google_android_gms_internal_zzdy.zzyH != null ? new HashSet(com_google_android_gms_internal_zzdy.zzyH) : null, com_google_android_gms_internal_zzdy.zzyI, com_google_android_gms_internal_zzdy.zzyN);
    }
}
