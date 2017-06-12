package com.google.android.gms.fitness.result;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.common.internal.safeparcel.zzb.zza;
import com.google.android.gms.common.internal.safeparcel.zzc;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.wallet.WalletConstants.CardNetwork;
import com.google.android.gms.wallet.fragment.WalletFragmentStyle.Dimension;
import com.google.android.gms.wearable.ChannelApi.ChannelListener;
import com.google.android.gms.wearable.MessageApi;

public class zze implements Creator<zzd> {
    static void zza(zzd com_google_android_gms_fitness_result_zzd, Parcel parcel, int i) {
        int zzaV = zzc.zzaV(parcel);
        zzc.zza(parcel, 1, com_google_android_gms_fitness_result_zzd.zzaRJ, i, false);
        zzc.zza(parcel, 2, com_google_android_gms_fitness_result_zzd.zzahs);
        zzc.zza(parcel, 3, com_google_android_gms_fitness_result_zzd.zzaWs);
        zzc.zza(parcel, 4, com_google_android_gms_fitness_result_zzd.zzaWt);
        zzc.zza(parcel, 5, com_google_android_gms_fitness_result_zzd.zzaWu);
        zzc.zzc(parcel, CardNetwork.OTHER, com_google_android_gms_fitness_result_zzd.mVersionCode);
        zzc.zzJ(parcel, zzaV);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzfd(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzhM(i);
    }

    public zzd zzfd(Parcel parcel) {
        boolean z = false;
        long j = 0;
        int zzaU = zzb.zzaU(parcel);
        DataSource dataSource = null;
        long j2 = 0;
        long j3 = 0;
        int i = 0;
        while (parcel.dataPosition() < zzaU) {
            int zzaT = zzb.zzaT(parcel);
            switch (zzb.zzcW(zzaT)) {
                case MessageApi.FILTER_PREFIX /*1*/:
                    dataSource = (DataSource) zzb.zza(parcel, zzaT, DataSource.CREATOR);
                    break;
                case ChannelListener.CLOSE_REASON_REMOTE_CLOSE /*2*/:
                    j3 = zzb.zzi(parcel, zzaT);
                    break;
                case ChannelListener.CLOSE_REASON_LOCAL_CLOSE /*3*/:
                    z = zzb.zzc(parcel, zzaT);
                    break;
                case Dimension.UNIT_IN /*4*/:
                    j2 = zzb.zzi(parcel, zzaT);
                    break;
                case Dimension.UNIT_MM /*5*/:
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
            return new zzd(i, dataSource, j3, z, j2, j);
        }
        throw new zza("Overread allowed size end=" + zzaU, parcel);
    }

    public zzd[] zzhM(int i) {
        return new zzd[i];
    }
}
