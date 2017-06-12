package com.google.android.gms.games.quest;

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

public class MilestoneEntityCreator implements Creator<MilestoneEntity> {
    static void zza(MilestoneEntity milestoneEntity, Parcel parcel, int i) {
        int zzaV = zzc.zzaV(parcel);
        zzc.zza(parcel, 1, milestoneEntity.getMilestoneId(), false);
        zzc.zza(parcel, 2, milestoneEntity.getCurrentProgress());
        zzc.zza(parcel, 3, milestoneEntity.getTargetProgress());
        zzc.zza(parcel, 4, milestoneEntity.getCompletionRewardData(), false);
        zzc.zzc(parcel, 5, milestoneEntity.getState());
        zzc.zza(parcel, 6, milestoneEntity.getEventId(), false);
        zzc.zzc(parcel, CardNetwork.OTHER, milestoneEntity.getVersionCode());
        zzc.zzJ(parcel, zzaV);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzfT(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zziY(i);
    }

    public MilestoneEntity zzfT(Parcel parcel) {
        long j = 0;
        int i = 0;
        String str = null;
        int zzaU = zzb.zzaU(parcel);
        byte[] bArr = null;
        long j2 = 0;
        String str2 = null;
        int i2 = 0;
        while (parcel.dataPosition() < zzaU) {
            int zzaT = zzb.zzaT(parcel);
            switch (zzb.zzcW(zzaT)) {
                case MessageApi.FILTER_PREFIX /*1*/:
                    str2 = zzb.zzq(parcel, zzaT);
                    break;
                case ChannelListener.CLOSE_REASON_REMOTE_CLOSE /*2*/:
                    j2 = zzb.zzi(parcel, zzaT);
                    break;
                case ChannelListener.CLOSE_REASON_LOCAL_CLOSE /*3*/:
                    j = zzb.zzi(parcel, zzaT);
                    break;
                case Dimension.UNIT_IN /*4*/:
                    bArr = zzb.zzt(parcel, zzaT);
                    break;
                case Dimension.UNIT_MM /*5*/:
                    i = zzb.zzg(parcel, zzaT);
                    break;
                case BuyButtonText.LOGO_ONLY /*6*/:
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
            return new MilestoneEntity(i2, str2, j2, j, bArr, i, str);
        }
        throw new zza("Overread allowed size end=" + zzaU, parcel);
    }

    public MilestoneEntity[] zziY(int i) {
        return new MilestoneEntity[i];
    }
}
