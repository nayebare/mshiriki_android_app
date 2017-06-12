package com.google.android.gms.fitness.result;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.common.internal.safeparcel.zzb.zza;
import com.google.android.gms.common.internal.safeparcel.zzc;
import com.google.android.gms.wallet.WalletConstants.CardNetwork;
import com.google.android.gms.wearable.ChannelApi.ChannelListener;
import com.google.android.gms.wearable.MessageApi;

public class zzk implements Creator<zzj> {
    static void zza(zzj com_google_android_gms_fitness_result_zzj, Parcel parcel, int i) {
        int zzaV = zzc.zzaV(parcel);
        zzc.zza(parcel, 1, com_google_android_gms_fitness_result_zzj.getStatus(), i, false);
        zzc.zza(parcel, 2, com_google_android_gms_fitness_result_zzj.zzCH(), false);
        zzc.zzc(parcel, CardNetwork.OTHER, com_google_android_gms_fitness_result_zzj.getVersionCode());
        zzc.zzJ(parcel, zzaV);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzfh(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzhQ(i);
    }

    public zzj zzfh(Parcel parcel) {
        Bundle bundle = null;
        int zzaU = zzb.zzaU(parcel);
        int i = 0;
        Status status = null;
        while (parcel.dataPosition() < zzaU) {
            int i2;
            Bundle bundle2;
            Status status2;
            int zzaT = zzb.zzaT(parcel);
            switch (zzb.zzcW(zzaT)) {
                case MessageApi.FILTER_PREFIX /*1*/:
                    i2 = i;
                    Status status3 = (Status) zzb.zza(parcel, zzaT, Status.CREATOR);
                    bundle2 = bundle;
                    status2 = status3;
                    break;
                case ChannelListener.CLOSE_REASON_REMOTE_CLOSE /*2*/:
                    bundle2 = zzb.zzs(parcel, zzaT);
                    status2 = status;
                    i2 = i;
                    break;
                case CardNetwork.OTHER /*1000*/:
                    Bundle bundle3 = bundle;
                    status2 = status;
                    i2 = zzb.zzg(parcel, zzaT);
                    bundle2 = bundle3;
                    break;
                default:
                    zzb.zzb(parcel, zzaT);
                    bundle2 = bundle;
                    status2 = status;
                    i2 = i;
                    break;
            }
            i = i2;
            status = status2;
            bundle = bundle2;
        }
        if (parcel.dataPosition() == zzaU) {
            return new zzj(i, status, bundle);
        }
        throw new zza("Overread allowed size end=" + zzaU, parcel);
    }

    public zzj[] zzhQ(int i) {
        return new zzj[i];
    }
}
