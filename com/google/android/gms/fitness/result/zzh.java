package com.google.android.gms.fitness.result;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.common.internal.safeparcel.zzb.zza;
import com.google.android.gms.common.internal.safeparcel.zzc;
import com.google.android.gms.wallet.WalletConstants.CardNetwork;
import com.google.android.gms.wearable.ChannelApi.ChannelListener;
import com.google.android.gms.wearable.MessageApi;
import java.util.ArrayList;
import java.util.List;

public class zzh implements Creator<zzg> {
    static void zza(zzg com_google_android_gms_fitness_result_zzg, Parcel parcel, int i) {
        int zzaV = zzc.zzaV(parcel);
        zzc.zza(parcel, 1, com_google_android_gms_fitness_result_zzg.getStatus(), i, false);
        zzc.zzc(parcel, 2, com_google_android_gms_fitness_result_zzg.zzCG(), false);
        zzc.zzc(parcel, CardNetwork.OTHER, com_google_android_gms_fitness_result_zzg.getVersionCode());
        zzc.zzJ(parcel, zzaV);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzff(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzhO(i);
    }

    public zzg zzff(Parcel parcel) {
        List list = null;
        int zzaU = zzb.zzaU(parcel);
        int i = 0;
        Status status = null;
        while (parcel.dataPosition() < zzaU) {
            int i2;
            Status status2;
            ArrayList zzc;
            int zzaT = zzb.zzaT(parcel);
            List list2;
            switch (zzb.zzcW(zzaT)) {
                case MessageApi.FILTER_PREFIX /*1*/:
                    i2 = i;
                    Status status3 = (Status) zzb.zza(parcel, zzaT, Status.CREATOR);
                    list2 = list;
                    status2 = status3;
                    break;
                case ChannelListener.CLOSE_REASON_REMOTE_CLOSE /*2*/:
                    zzc = zzb.zzc(parcel, zzaT, zzd.CREATOR);
                    status2 = status;
                    i2 = i;
                    break;
                case CardNetwork.OTHER /*1000*/:
                    List list3 = list;
                    status2 = status;
                    i2 = zzb.zzg(parcel, zzaT);
                    list2 = list3;
                    break;
                default:
                    zzb.zzb(parcel, zzaT);
                    zzc = list;
                    status2 = status;
                    i2 = i;
                    break;
            }
            i = i2;
            status = status2;
            Object obj = zzc;
        }
        if (parcel.dataPosition() == zzaU) {
            return new zzg(i, status, list);
        }
        throw new zza("Overread allowed size end=" + zzaU, parcel);
    }

    public zzg[] zzhO(int i) {
        return new zzg[i];
    }
}
