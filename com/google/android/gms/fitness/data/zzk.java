package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.common.internal.safeparcel.zzb.zza;
import com.google.android.gms.common.internal.safeparcel.zzc;
import com.google.android.gms.wallet.WalletConstants.CardNetwork;
import com.google.android.gms.wearable.ChannelApi.ChannelListener;
import com.google.android.gms.wearable.MessageApi;
import java.util.List;

public class zzk implements Creator<DataType> {
    static void zza(DataType dataType, Parcel parcel, int i) {
        int zzaV = zzc.zzaV(parcel);
        zzc.zza(parcel, 1, dataType.getName(), false);
        zzc.zzc(parcel, 2, dataType.getFields(), false);
        zzc.zzc(parcel, CardNetwork.OTHER, dataType.getVersionCode());
        zzc.zzJ(parcel, zzaV);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzdT(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzgw(i);
    }

    public DataType zzdT(Parcel parcel) {
        List list = null;
        int zzaU = zzb.zzaU(parcel);
        int i = 0;
        String str = null;
        while (parcel.dataPosition() < zzaU) {
            int zzaT = zzb.zzaT(parcel);
            switch (zzb.zzcW(zzaT)) {
                case MessageApi.FILTER_PREFIX /*1*/:
                    str = zzb.zzq(parcel, zzaT);
                    break;
                case ChannelListener.CLOSE_REASON_REMOTE_CLOSE /*2*/:
                    list = zzb.zzc(parcel, zzaT, Field.CREATOR);
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
            return new DataType(i, str, list);
        }
        throw new zza("Overread allowed size end=" + zzaU, parcel);
    }

    public DataType[] zzgw(int i) {
        return new DataType[i];
    }
}
