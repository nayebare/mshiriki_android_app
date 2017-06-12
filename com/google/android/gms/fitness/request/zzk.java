package com.google.android.gms.fitness.request;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.common.internal.safeparcel.zzb.zza;
import com.google.android.gms.common.internal.safeparcel.zzc;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.wallet.WalletConstants.CardNetwork;
import com.google.android.gms.wallet.fragment.WalletFragmentStyle.BuyButtonText;
import com.google.android.gms.wallet.fragment.WalletFragmentStyle.Dimension;
import com.google.android.gms.wearable.ChannelApi.ChannelListener;
import com.google.android.gms.wearable.MessageApi;

public class zzk implements Creator<zzj> {
    static void zza(zzj com_google_android_gms_fitness_request_zzj, Parcel parcel, int i) {
        int zzaV = zzc.zzaV(parcel);
        zzc.zza(parcel, 1, com_google_android_gms_fitness_request_zzj.zzaRJ, i, false);
        zzc.zza(parcel, 2, com_google_android_gms_fitness_request_zzj.zzahs);
        zzc.zza(parcel, 3, com_google_android_gms_fitness_request_zzj.zzaTB);
        zzc.zza(parcel, 4, com_google_android_gms_fitness_request_zzj.zzaVk);
        zzc.zzc(parcel, 5, com_google_android_gms_fitness_request_zzj.zzaVe);
        zzc.zzc(parcel, 6, com_google_android_gms_fitness_request_zzj.zzaVl);
        zzc.zzc(parcel, CardNetwork.OTHER, com_google_android_gms_fitness_request_zzj.versionCode);
        zzc.zzJ(parcel, zzaV);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzes(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzhb(i);
    }

    public zzj zzes(Parcel parcel) {
        long j = 0;
        int i = 0;
        int zzaU = zzb.zzaU(parcel);
        DataSource dataSource = null;
        int i2 = 0;
        long j2 = 0;
        long j3 = 0;
        int i3 = 0;
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
                    j2 = zzb.zzi(parcel, zzaT);
                    break;
                case Dimension.UNIT_IN /*4*/:
                    j = zzb.zzi(parcel, zzaT);
                    break;
                case Dimension.UNIT_MM /*5*/:
                    i2 = zzb.zzg(parcel, zzaT);
                    break;
                case BuyButtonText.LOGO_ONLY /*6*/:
                    i = zzb.zzg(parcel, zzaT);
                    break;
                case CardNetwork.OTHER /*1000*/:
                    i3 = zzb.zzg(parcel, zzaT);
                    break;
                default:
                    zzb.zzb(parcel, zzaT);
                    break;
            }
        }
        if (parcel.dataPosition() == zzaU) {
            return new zzj(i3, dataSource, j3, j2, j, i2, i);
        }
        throw new zza("Overread allowed size end=" + zzaU, parcel);
    }

    public zzj[] zzhb(int i) {
        return new zzj[i];
    }
}
