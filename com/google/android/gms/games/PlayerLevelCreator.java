package com.google.android.gms.games;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.common.internal.safeparcel.zzb.zza;
import com.google.android.gms.common.internal.safeparcel.zzc;
import com.google.android.gms.wallet.WalletConstants.CardNetwork;
import com.google.android.gms.wearable.ChannelApi.ChannelListener;
import com.google.android.gms.wearable.MessageApi;

public class PlayerLevelCreator implements Creator<PlayerLevel> {
    static void zza(PlayerLevel playerLevel, Parcel parcel, int i) {
        int zzaV = zzc.zzaV(parcel);
        zzc.zzc(parcel, 1, playerLevel.getLevelNumber());
        zzc.zza(parcel, 2, playerLevel.getMinXp());
        zzc.zza(parcel, 3, playerLevel.getMaxXp());
        zzc.zzc(parcel, CardNetwork.OTHER, playerLevel.getVersionCode());
        zzc.zzJ(parcel, zzaV);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzft(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzid(i);
    }

    public PlayerLevel zzft(Parcel parcel) {
        long j = 0;
        int i = 0;
        int zzaU = zzb.zzaU(parcel);
        long j2 = 0;
        int i2 = 0;
        while (parcel.dataPosition() < zzaU) {
            int zzaT = zzb.zzaT(parcel);
            switch (zzb.zzcW(zzaT)) {
                case MessageApi.FILTER_PREFIX /*1*/:
                    i = zzb.zzg(parcel, zzaT);
                    break;
                case ChannelListener.CLOSE_REASON_REMOTE_CLOSE /*2*/:
                    j2 = zzb.zzi(parcel, zzaT);
                    break;
                case ChannelListener.CLOSE_REASON_LOCAL_CLOSE /*3*/:
                    j = zzb.zzi(parcel, zzaT);
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
            return new PlayerLevel(i2, i, j2, j);
        }
        throw new zza("Overread allowed size end=" + zzaU, parcel);
    }

    public PlayerLevel[] zzid(int i) {
        return new PlayerLevel[i];
    }
}
