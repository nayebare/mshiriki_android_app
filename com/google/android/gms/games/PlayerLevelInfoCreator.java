package com.google.android.gms.games;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.common.internal.safeparcel.zzb.zza;
import com.google.android.gms.common.internal.safeparcel.zzc;
import com.google.android.gms.wallet.WalletConstants.CardNetwork;
import com.google.android.gms.wallet.fragment.WalletFragmentStyle.Dimension;
import com.google.android.gms.wearable.ChannelApi.ChannelListener;
import com.google.android.gms.wearable.MessageApi;

public class PlayerLevelInfoCreator implements Creator<PlayerLevelInfo> {
    static void zza(PlayerLevelInfo playerLevelInfo, Parcel parcel, int i) {
        int zzaV = zzc.zzaV(parcel);
        zzc.zza(parcel, 1, playerLevelInfo.getCurrentXpTotal());
        zzc.zza(parcel, 2, playerLevelInfo.getLastLevelUpTimestamp());
        zzc.zza(parcel, 3, playerLevelInfo.getCurrentLevel(), i, false);
        zzc.zza(parcel, 4, playerLevelInfo.getNextLevel(), i, false);
        zzc.zzc(parcel, CardNetwork.OTHER, playerLevelInfo.getVersionCode());
        zzc.zzJ(parcel, zzaV);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzfu(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzie(i);
    }

    public PlayerLevelInfo zzfu(Parcel parcel) {
        long j = 0;
        PlayerLevel playerLevel = null;
        int zzaU = zzb.zzaU(parcel);
        int i = 0;
        PlayerLevel playerLevel2 = null;
        long j2 = 0;
        while (parcel.dataPosition() < zzaU) {
            int zzaT = zzb.zzaT(parcel);
            switch (zzb.zzcW(zzaT)) {
                case MessageApi.FILTER_PREFIX /*1*/:
                    j2 = zzb.zzi(parcel, zzaT);
                    break;
                case ChannelListener.CLOSE_REASON_REMOTE_CLOSE /*2*/:
                    j = zzb.zzi(parcel, zzaT);
                    break;
                case ChannelListener.CLOSE_REASON_LOCAL_CLOSE /*3*/:
                    playerLevel2 = (PlayerLevel) zzb.zza(parcel, zzaT, PlayerLevel.CREATOR);
                    break;
                case Dimension.UNIT_IN /*4*/:
                    playerLevel = (PlayerLevel) zzb.zza(parcel, zzaT, PlayerLevel.CREATOR);
                    break;
                case CardNetwork.OTHER /*1000*/:
                    i = zzb.zzg(parcel, zzaT);
                    break;
                default:
                    zzb.zzb(parcel, zzaT);
                    break;
            }
        }
        if (parcel.dataPosition() == zzaU) {
            return new PlayerLevelInfo(i, j2, j, playerLevel2, playerLevel);
        }
        throw new zza("Overread allowed size end=" + zzaU, parcel);
    }

    public PlayerLevelInfo[] zzie(int i) {
        return new PlayerLevelInfo[i];
    }
}
