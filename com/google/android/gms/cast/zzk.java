package com.google.android.gms.cast;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.common.internal.safeparcel.zzb.zza;
import com.google.android.gms.common.internal.safeparcel.zzc;
import com.google.android.gms.games.request.Requests;
import com.google.android.gms.wallet.fragment.WalletFragmentStyle.BuyButtonText;
import com.google.android.gms.wallet.fragment.WalletFragmentStyle.Dimension;
import com.google.android.gms.wearable.ChannelApi.ChannelListener;
import com.google.android.gms.wearable.MessageApi;
import org.apache.http.protocol.HTTP;

public class zzk implements Creator<MediaQueueItem> {
    static void zza(MediaQueueItem mediaQueueItem, Parcel parcel, int i) {
        int zzaV = zzc.zzaV(parcel);
        zzc.zzc(parcel, 1, mediaQueueItem.getVersionCode());
        zzc.zza(parcel, 2, mediaQueueItem.getMedia(), i, false);
        zzc.zzc(parcel, 3, mediaQueueItem.getItemId());
        zzc.zza(parcel, 4, mediaQueueItem.getAutoplay());
        zzc.zza(parcel, 5, mediaQueueItem.getStartTime());
        zzc.zza(parcel, 6, mediaQueueItem.getPlaybackDuration());
        zzc.zza(parcel, 7, mediaQueueItem.getPreloadTime());
        zzc.zza(parcel, 8, mediaQueueItem.getActiveTrackIds(), false);
        zzc.zza(parcel, 9, mediaQueueItem.zzalH, false);
        zzc.zzJ(parcel, zzaV);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzau(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzbN(i);
    }

    public MediaQueueItem zzau(Parcel parcel) {
        int zzaU = zzb.zzaU(parcel);
        int i = 0;
        MediaInfo mediaInfo = null;
        int i2 = 0;
        boolean z = false;
        double d = 0.0d;
        double d2 = 0.0d;
        double d3 = 0.0d;
        long[] jArr = null;
        String str = null;
        while (parcel.dataPosition() < zzaU) {
            int zzaT = zzb.zzaT(parcel);
            switch (zzb.zzcW(zzaT)) {
                case MessageApi.FILTER_PREFIX /*1*/:
                    i = zzb.zzg(parcel, zzaT);
                    break;
                case ChannelListener.CLOSE_REASON_REMOTE_CLOSE /*2*/:
                    mediaInfo = (MediaInfo) zzb.zza(parcel, zzaT, MediaInfo.CREATOR);
                    break;
                case ChannelListener.CLOSE_REASON_LOCAL_CLOSE /*3*/:
                    i2 = zzb.zzg(parcel, zzaT);
                    break;
                case Dimension.UNIT_IN /*4*/:
                    z = zzb.zzc(parcel, zzaT);
                    break;
                case Dimension.UNIT_MM /*5*/:
                    d = zzb.zzn(parcel, zzaT);
                    break;
                case BuyButtonText.LOGO_ONLY /*6*/:
                    d2 = zzb.zzn(parcel, zzaT);
                    break;
                case BuyButtonText.DONATE_WITH /*7*/:
                    d3 = zzb.zzn(parcel, zzaT);
                    break;
                case Requests.MAX_REQUEST_RECIPIENTS /*8*/:
                    jArr = zzb.zzx(parcel, zzaT);
                    break;
                case HTTP.HT /*9*/:
                    str = zzb.zzq(parcel, zzaT);
                    break;
                default:
                    zzb.zzb(parcel, zzaT);
                    break;
            }
        }
        if (parcel.dataPosition() == zzaU) {
            return new MediaQueueItem(i, mediaInfo, i2, z, d, d2, d3, jArr, str);
        }
        throw new zza("Overread allowed size end=" + zzaU, parcel);
    }

    public MediaQueueItem[] zzbN(int i) {
        return new MediaQueueItem[i];
    }
}
