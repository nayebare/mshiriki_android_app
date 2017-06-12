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

public class zzm implements Creator<MediaTrack> {
    static void zza(MediaTrack mediaTrack, Parcel parcel, int i) {
        int zzaV = zzc.zzaV(parcel);
        zzc.zzc(parcel, 1, mediaTrack.getVersionCode());
        zzc.zza(parcel, 2, mediaTrack.getId());
        zzc.zzc(parcel, 3, mediaTrack.getType());
        zzc.zza(parcel, 4, mediaTrack.getContentId(), false);
        zzc.zza(parcel, 5, mediaTrack.getContentType(), false);
        zzc.zza(parcel, 6, mediaTrack.getName(), false);
        zzc.zza(parcel, 7, mediaTrack.getLanguage(), false);
        zzc.zzc(parcel, 8, mediaTrack.getSubtype());
        zzc.zza(parcel, 9, mediaTrack.zzalH, false);
        zzc.zzJ(parcel, zzaV);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzaw(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzbQ(i);
    }

    public MediaTrack zzaw(Parcel parcel) {
        int i = 0;
        String str = null;
        int zzaU = zzb.zzaU(parcel);
        long j = 0;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        int i2 = 0;
        int i3 = 0;
        while (parcel.dataPosition() < zzaU) {
            int zzaT = zzb.zzaT(parcel);
            switch (zzb.zzcW(zzaT)) {
                case MessageApi.FILTER_PREFIX /*1*/:
                    i3 = zzb.zzg(parcel, zzaT);
                    break;
                case ChannelListener.CLOSE_REASON_REMOTE_CLOSE /*2*/:
                    j = zzb.zzi(parcel, zzaT);
                    break;
                case ChannelListener.CLOSE_REASON_LOCAL_CLOSE /*3*/:
                    i2 = zzb.zzg(parcel, zzaT);
                    break;
                case Dimension.UNIT_IN /*4*/:
                    str5 = zzb.zzq(parcel, zzaT);
                    break;
                case Dimension.UNIT_MM /*5*/:
                    str4 = zzb.zzq(parcel, zzaT);
                    break;
                case BuyButtonText.LOGO_ONLY /*6*/:
                    str3 = zzb.zzq(parcel, zzaT);
                    break;
                case BuyButtonText.DONATE_WITH /*7*/:
                    str2 = zzb.zzq(parcel, zzaT);
                    break;
                case Requests.MAX_REQUEST_RECIPIENTS /*8*/:
                    i = zzb.zzg(parcel, zzaT);
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
            return new MediaTrack(i3, j, i2, str5, str4, str3, str2, i, str);
        }
        throw new zza("Overread allowed size end=" + zzaU, parcel);
    }

    public MediaTrack[] zzbQ(int i) {
        return new MediaTrack[i];
    }
}
