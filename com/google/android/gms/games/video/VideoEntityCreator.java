package com.google.android.gms.games.video;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.common.internal.safeparcel.zzb.zza;
import com.google.android.gms.common.internal.safeparcel.zzc;
import com.google.android.gms.wallet.WalletConstants.CardNetwork;
import com.google.android.gms.wallet.fragment.WalletFragmentStyle.Dimension;
import com.google.android.gms.wearable.ChannelApi.ChannelListener;
import com.google.android.gms.wearable.MessageApi;

public class VideoEntityCreator implements Creator<VideoEntity> {
    static void zza(VideoEntity videoEntity, Parcel parcel, int i) {
        int zzaV = zzc.zzaV(parcel);
        zzc.zzc(parcel, 1, videoEntity.getDuration());
        zzc.zza(parcel, 2, videoEntity.zzFQ(), false);
        zzc.zza(parcel, 3, videoEntity.getFileSize());
        zzc.zza(parcel, 4, videoEntity.getStartTime());
        zzc.zza(parcel, 5, videoEntity.getPackageName(), false);
        zzc.zzc(parcel, CardNetwork.OTHER, videoEntity.getVersionCode());
        zzc.zzJ(parcel, zzaV);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzge(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzjn(i);
    }

    public VideoEntity zzge(Parcel parcel) {
        long j = 0;
        String str = null;
        int i = 0;
        int zzaU = zzb.zzaU(parcel);
        long j2 = 0;
        String str2 = null;
        int i2 = 0;
        while (parcel.dataPosition() < zzaU) {
            int zzaT = zzb.zzaT(parcel);
            switch (zzb.zzcW(zzaT)) {
                case MessageApi.FILTER_PREFIX /*1*/:
                    i = zzb.zzg(parcel, zzaT);
                    break;
                case ChannelListener.CLOSE_REASON_REMOTE_CLOSE /*2*/:
                    str2 = zzb.zzq(parcel, zzaT);
                    break;
                case ChannelListener.CLOSE_REASON_LOCAL_CLOSE /*3*/:
                    j2 = zzb.zzi(parcel, zzaT);
                    break;
                case Dimension.UNIT_IN /*4*/:
                    j = zzb.zzi(parcel, zzaT);
                    break;
                case Dimension.UNIT_MM /*5*/:
                    str = zzb.zzq(parcel, zzaT);
                    break;
                case CardNetwork.OTHER /*1000*/:
                    i2 = zzb.zzg(parcel, zzaT);
                    break;
                default:
                    zzb.zzb(parcel, zzaT);
                    break;
            }
        }
        if (parcel.dataPosition() == zzaU) {
            return new VideoEntity(i2, i, str2, j2, j, str);
        }
        throw new zza("Overread allowed size end=" + zzaU, parcel);
    }

    public VideoEntity[] zzjn(int i) {
        return new VideoEntity[i];
    }
}
