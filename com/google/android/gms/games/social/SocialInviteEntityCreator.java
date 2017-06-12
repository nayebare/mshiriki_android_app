package com.google.android.gms.games.social;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.common.internal.safeparcel.zzb.zza;
import com.google.android.gms.common.internal.safeparcel.zzc;
import com.google.android.gms.games.PlayerEntity;
import com.google.android.gms.wallet.WalletConstants.CardNetwork;
import com.google.android.gms.wallet.fragment.WalletFragmentStyle.Dimension;
import com.google.android.gms.wearable.ChannelApi.ChannelListener;
import com.google.android.gms.wearable.MessageApi;

public class SocialInviteEntityCreator implements Creator<SocialInviteEntity> {
    static void zza(SocialInviteEntity socialInviteEntity, Parcel parcel, int i) {
        int zzaV = zzc.zzaV(parcel);
        zzc.zza(parcel, 1, socialInviteEntity.zzFM(), false);
        zzc.zza(parcel, 2, socialInviteEntity.getPlayer(), i, false);
        zzc.zzc(parcel, 3, socialInviteEntity.getType());
        zzc.zzc(parcel, 4, socialInviteEntity.getDirection());
        zzc.zza(parcel, 5, socialInviteEntity.getLastModifiedTimestamp());
        zzc.zzc(parcel, CardNetwork.OTHER, socialInviteEntity.getVersionCode());
        zzc.zzJ(parcel, zzaV);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzga(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzjh(i);
    }

    public SocialInviteEntity zzga(Parcel parcel) {
        PlayerEntity playerEntity = null;
        int i = 0;
        int zzaU = zzb.zzaU(parcel);
        long j = 0;
        int i2 = 0;
        String str = null;
        int i3 = 0;
        while (parcel.dataPosition() < zzaU) {
            int zzaT = zzb.zzaT(parcel);
            switch (zzb.zzcW(zzaT)) {
                case MessageApi.FILTER_PREFIX /*1*/:
                    str = zzb.zzq(parcel, zzaT);
                    break;
                case ChannelListener.CLOSE_REASON_REMOTE_CLOSE /*2*/:
                    playerEntity = (PlayerEntity) zzb.zza(parcel, zzaT, PlayerEntity.CREATOR);
                    break;
                case ChannelListener.CLOSE_REASON_LOCAL_CLOSE /*3*/:
                    i2 = zzb.zzg(parcel, zzaT);
                    break;
                case Dimension.UNIT_IN /*4*/:
                    i = zzb.zzg(parcel, zzaT);
                    break;
                case Dimension.UNIT_MM /*5*/:
                    j = zzb.zzi(parcel, zzaT);
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
            return new SocialInviteEntity(i3, str, playerEntity, i2, i, j);
        }
        throw new zza("Overread allowed size end=" + zzaU, parcel);
    }

    public SocialInviteEntity[] zzjh(int i) {
        return new SocialInviteEntity[i];
    }
}
