package com.google.android.gms.fitness.result;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.common.internal.safeparcel.zzb.zza;
import com.google.android.gms.common.internal.safeparcel.zzc;
import com.google.android.gms.wallet.WalletConstants.CardNetwork;
import com.google.android.gms.wearable.ChannelApi.ChannelListener;
import com.google.android.gms.wearable.MessageApi;
import java.util.ArrayList;
import java.util.List;

public class zzq implements Creator<zzp> {
    static void zza(zzp com_google_android_gms_fitness_result_zzp, Parcel parcel, int i) {
        int zzaV = zzc.zzaV(parcel);
        zzc.zza(parcel, 1, com_google_android_gms_fitness_result_zzp.zzAb(), i, false);
        zzc.zzc(parcel, 2, com_google_android_gms_fitness_result_zzp.zzCI(), false);
        zzc.zzc(parcel, CardNetwork.OTHER, com_google_android_gms_fitness_result_zzp.getVersionCode());
        zzc.zzJ(parcel, zzaV);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzfl(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzhU(i);
    }

    public zzp zzfl(Parcel parcel) {
        List list = null;
        int zzaU = zzb.zzaU(parcel);
        int i = 0;
        DataHolder dataHolder = null;
        while (parcel.dataPosition() < zzaU) {
            int i2;
            DataHolder dataHolder2;
            ArrayList zzc;
            int zzaT = zzb.zzaT(parcel);
            List list2;
            switch (zzb.zzcW(zzaT)) {
                case MessageApi.FILTER_PREFIX /*1*/:
                    i2 = i;
                    DataHolder dataHolder3 = (DataHolder) zzb.zza(parcel, zzaT, DataHolder.CREATOR);
                    list2 = list;
                    dataHolder2 = dataHolder3;
                    break;
                case ChannelListener.CLOSE_REASON_REMOTE_CLOSE /*2*/:
                    zzc = zzb.zzc(parcel, zzaT, DataHolder.CREATOR);
                    dataHolder2 = dataHolder;
                    i2 = i;
                    break;
                case CardNetwork.OTHER /*1000*/:
                    List list3 = list;
                    dataHolder2 = dataHolder;
                    i2 = zzb.zzg(parcel, zzaT);
                    list2 = list3;
                    break;
                default:
                    zzb.zzb(parcel, zzaT);
                    zzc = list;
                    dataHolder2 = dataHolder;
                    i2 = i;
                    break;
            }
            i = i2;
            dataHolder = dataHolder2;
            Object obj = zzc;
        }
        if (parcel.dataPosition() == zzaU) {
            return new zzp(i, dataHolder, list);
        }
        throw new zza("Overread allowed size end=" + zzaU, parcel);
    }

    public zzp[] zzhU(int i) {
        return new zzp[i];
    }
}
