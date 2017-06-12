package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.common.internal.safeparcel.zzb.zza;
import com.google.android.gms.common.internal.safeparcel.zzc;
import com.google.android.gms.fitness.data.Goal.FrequencyObjective;
import com.google.android.gms.wallet.WalletConstants.CardNetwork;
import com.google.android.gms.wearable.MessageApi;

public class zzq implements Creator<FrequencyObjective> {
    static void zza(FrequencyObjective frequencyObjective, Parcel parcel, int i) {
        int zzaV = zzc.zzaV(parcel);
        zzc.zzc(parcel, 1, frequencyObjective.getFrequency());
        zzc.zzc(parcel, CardNetwork.OTHER, frequencyObjective.getVersionCode());
        zzc.zzJ(parcel, zzaV);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzdY(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzgB(i);
    }

    public FrequencyObjective zzdY(Parcel parcel) {
        int i = 0;
        int zzaU = zzb.zzaU(parcel);
        int i2 = 0;
        while (parcel.dataPosition() < zzaU) {
            int zzaT = zzb.zzaT(parcel);
            switch (zzb.zzcW(zzaT)) {
                case MessageApi.FILTER_PREFIX /*1*/:
                    i = zzb.zzg(parcel, zzaT);
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
            return new FrequencyObjective(i2, i);
        }
        throw new zza("Overread allowed size end=" + zzaU, parcel);
    }

    public FrequencyObjective[] zzgB(int i) {
        return new FrequencyObjective[i];
    }
}
