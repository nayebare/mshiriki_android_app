package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.common.internal.safeparcel.zzb.zza;
import com.google.android.gms.wallet.WalletConstants.CardNetwork;
import com.google.android.gms.wearable.ChannelApi.ChannelListener;
import com.google.android.gms.wearable.MessageApi;

public class zzc implements Creator<zzb> {
    static void zza(zzb com_google_android_gms_fitness_data_zzb, Parcel parcel, int i) {
        int zzaV = com.google.android.gms.common.internal.safeparcel.zzc.zzaV(parcel);
        com.google.android.gms.common.internal.safeparcel.zzc.zza(parcel, 1, com_google_android_gms_fitness_data_zzb.getPackageName(), false);
        com.google.android.gms.common.internal.safeparcel.zzc.zza(parcel, 2, com_google_android_gms_fitness_data_zzb.getVersion(), false);
        com.google.android.gms.common.internal.safeparcel.zzc.zza(parcel, 3, com_google_android_gms_fitness_data_zzb.zzBf(), false);
        com.google.android.gms.common.internal.safeparcel.zzc.zzc(parcel, CardNetwork.OTHER, com_google_android_gms_fitness_data_zzb.getVersionCode());
        com.google.android.gms.common.internal.safeparcel.zzc.zzJ(parcel, zzaV);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzdN(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzgl(i);
    }

    public zzb zzdN(Parcel parcel) {
        String str = null;
        int zzaU = zzb.zzaU(parcel);
        int i = 0;
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
                case CardNetwork.OTHER /*1000*/:
                    i = zzb.zzg(parcel, zzaT);
                    break;
                default:
                    zzb.zzb(parcel, zzaT);
                    break;
            }
        }
        if (parcel.dataPosition() == zzaU) {
            return new zzb(i, str3, str2, str);
        }
        throw new zza("Overread allowed size end=" + zzaU, parcel);
    }

    public zzb[] zzgl(int i) {
        return new zzb[i];
    }
}
