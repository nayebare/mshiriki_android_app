package com.google.android.gms.games.video;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.common.internal.safeparcel.zzb.zza;
import com.google.android.gms.common.internal.safeparcel.zzc;
import com.google.android.gms.wallet.WalletConstants.CardNetwork;
import com.google.android.gms.wallet.fragment.WalletFragmentStyle.BuyButtonText;
import com.google.android.gms.wallet.fragment.WalletFragmentStyle.Dimension;
import com.google.android.gms.wearable.ChannelApi.ChannelListener;
import com.google.android.gms.wearable.MessageApi;

public class VideoConfigurationCreator implements Creator<VideoConfiguration> {
    static void zza(VideoConfiguration videoConfiguration, Parcel parcel, int i) {
        int zzaV = zzc.zzaV(parcel);
        zzc.zzc(parcel, 1, videoConfiguration.getQualityLevel());
        zzc.zzc(parcel, 2, videoConfiguration.getCaptureMode());
        zzc.zza(parcel, 3, videoConfiguration.getStreamUrl(), false);
        zzc.zza(parcel, 4, videoConfiguration.zzFR(), false);
        zzc.zza(parcel, 5, videoConfiguration.zzFS(), false);
        zzc.zza(parcel, 6, videoConfiguration.zzFT(), false);
        zzc.zza(parcel, 7, videoConfiguration.zzFU());
        zzc.zzc(parcel, CardNetwork.OTHER, videoConfiguration.getVersionCode());
        zzc.zzJ(parcel, zzaV);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzgd(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzjm(i);
    }

    public VideoConfiguration zzgd(Parcel parcel) {
        String str = null;
        boolean z = false;
        int zzaU = zzb.zzaU(parcel);
        String str2 = null;
        String str3 = null;
        String str4 = null;
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        while (parcel.dataPosition() < zzaU) {
            int zzaT = zzb.zzaT(parcel);
            switch (zzb.zzcW(zzaT)) {
                case MessageApi.FILTER_PREFIX /*1*/:
                    i2 = zzb.zzg(parcel, zzaT);
                    break;
                case ChannelListener.CLOSE_REASON_REMOTE_CLOSE /*2*/:
                    i = zzb.zzg(parcel, zzaT);
                    break;
                case ChannelListener.CLOSE_REASON_LOCAL_CLOSE /*3*/:
                    str4 = zzb.zzq(parcel, zzaT);
                    break;
                case Dimension.UNIT_IN /*4*/:
                    str3 = zzb.zzq(parcel, zzaT);
                    break;
                case Dimension.UNIT_MM /*5*/:
                    str2 = zzb.zzq(parcel, zzaT);
                    break;
                case BuyButtonText.LOGO_ONLY /*6*/:
                    str = zzb.zzq(parcel, zzaT);
                    break;
                case BuyButtonText.DONATE_WITH /*7*/:
                    z = zzb.zzc(parcel, zzaT);
                    break;
                case CardNetwork.OTHER /*1000*/:
                    i3 = zzb.zzg(parcel, zzaT);
                    break;
                default:
                    zzb.zzb(parcel, zzaT);
                    break;
            }
        }
        if (parcel.dataPosition() == zzaU) {
            return new VideoConfiguration(i3, i2, i, str4, str3, str2, str, z);
        }
        throw new zza("Overread allowed size end=" + zzaU, parcel);
    }

    public VideoConfiguration[] zzjm(int i) {
        return new VideoConfiguration[i];
    }
}
