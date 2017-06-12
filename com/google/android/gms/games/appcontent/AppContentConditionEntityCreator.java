package com.google.android.gms.games.appcontent;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.common.internal.safeparcel.zzb.zza;
import com.google.android.gms.common.internal.safeparcel.zzc;
import com.google.android.gms.wallet.WalletConstants.CardNetwork;
import com.google.android.gms.wallet.fragment.WalletFragmentStyle.Dimension;
import com.google.android.gms.wearable.ChannelApi.ChannelListener;
import com.google.android.gms.wearable.MessageApi;

public class AppContentConditionEntityCreator implements Creator<AppContentConditionEntity> {
    static void zza(AppContentConditionEntity appContentConditionEntity, Parcel parcel, int i) {
        int zzaV = zzc.zzaV(parcel);
        zzc.zza(parcel, 1, appContentConditionEntity.zzDK(), false);
        zzc.zza(parcel, 2, appContentConditionEntity.zzDL(), false);
        zzc.zza(parcel, 3, appContentConditionEntity.zzDM(), false);
        zzc.zza(parcel, 4, appContentConditionEntity.zzDN(), false);
        zzc.zzc(parcel, CardNetwork.OTHER, appContentConditionEntity.getVersionCode());
        zzc.zzJ(parcel, zzaV);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzfz(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzij(i);
    }

    public AppContentConditionEntity zzfz(Parcel parcel) {
        Bundle bundle = null;
        int zzaU = zzb.zzaU(parcel);
        int i = 0;
        String str = null;
        String str2 = null;
        String str3 = null;
        while (parcel.dataPosition() < zzaU) {
            int zzaT = zzb.zzaT(parcel);
            switch (zzb.zzcW(zzaT)) {
                case MessageApi.FILTER_PREFIX /*1*/:
                    str3 = zzb.zzq(parcel, zzaT);
                    break;
                case ChannelListener.CLOSE_REASON_REMOTE_CLOSE /*2*/:
                    str2 = zzb.zzq(parcel, zzaT);
                    break;
                case ChannelListener.CLOSE_REASON_LOCAL_CLOSE /*3*/:
                    str = zzb.zzq(parcel, zzaT);
                    break;
                case Dimension.UNIT_IN /*4*/:
                    bundle = zzb.zzs(parcel, zzaT);
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
            return new AppContentConditionEntity(i, str3, str2, str, bundle);
        }
        throw new zza("Overread allowed size end=" + zzaU, parcel);
    }

    public AppContentConditionEntity[] zzij(int i) {
        return new AppContentConditionEntity[i];
    }
}
