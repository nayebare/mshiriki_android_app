package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.common.internal.safeparcel.zzb.zza;
import com.google.android.gms.common.internal.safeparcel.zzc;
import com.google.android.gms.fitness.data.Goal.DurationObjective;
import com.google.android.gms.wallet.WalletConstants.CardNetwork;
import com.google.android.gms.wearable.MessageApi;

public class zzo implements Creator<DurationObjective> {
    static void zza(DurationObjective durationObjective, Parcel parcel, int i) {
        int zzaV = zzc.zzaV(parcel);
        zzc.zza(parcel, 1, durationObjective.getDuration());
        zzc.zzc(parcel, CardNetwork.OTHER, durationObjective.getVersionCode());
        zzc.zzJ(parcel, zzaV);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzdW(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzgz(i);
    }

    public DurationObjective zzdW(Parcel parcel) {
        int zzaU = zzb.zzaU(parcel);
        int i = 0;
        long j = 0;
        while (parcel.dataPosition() < zzaU) {
            int zzaT = zzb.zzaT(parcel);
            switch (zzb.zzcW(zzaT)) {
                case MessageApi.FILTER_PREFIX /*1*/:
                    j = zzb.zzi(parcel, zzaT);
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
            return new DurationObjective(i, j);
        }
        throw new zza("Overread allowed size end=" + zzaU, parcel);
    }

    public DurationObjective[] zzgz(int i) {
        return new DurationObjective[i];
    }
}
