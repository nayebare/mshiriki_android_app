package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.common.internal.safeparcel.zzb.zza;
import com.google.android.gms.common.internal.safeparcel.zzc;
import com.google.android.gms.games.request.Requests;
import com.google.android.gms.wallet.WalletConstants.CardNetwork;
import com.google.android.gms.wallet.fragment.WalletFragmentStyle.BuyButtonText;
import com.google.android.gms.wallet.fragment.WalletFragmentStyle.Dimension;
import com.google.android.gms.wearable.ChannelApi.ChannelListener;
import com.google.android.gms.wearable.MessageApi;

public class zzj implements Creator<DataSource> {
    static void zza(DataSource dataSource, Parcel parcel, int i) {
        int zzaV = zzc.zzaV(parcel);
        zzc.zza(parcel, 1, dataSource.getDataType(), i, false);
        zzc.zza(parcel, 2, dataSource.getName(), false);
        zzc.zzc(parcel, 3, dataSource.getType());
        zzc.zza(parcel, 4, dataSource.getDevice(), i, false);
        zzc.zza(parcel, 5, dataSource.zzBs(), i, false);
        zzc.zza(parcel, 6, dataSource.getStreamName(), false);
        zzc.zzc(parcel, CardNetwork.OTHER, dataSource.getVersionCode());
        zzc.zza(parcel, 8, dataSource.zzBt(), false);
        zzc.zzJ(parcel, zzaV);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzdS(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzgv(i);
    }

    public DataSource zzdS(Parcel parcel) {
        int i = 0;
        int[] iArr = null;
        int zzaU = zzb.zzaU(parcel);
        String str = null;
        zzb com_google_android_gms_fitness_data_zzb = null;
        Device device = null;
        String str2 = null;
        DataType dataType = null;
        int i2 = 0;
        while (parcel.dataPosition() < zzaU) {
            int zzaT = zzb.zzaT(parcel);
            switch (zzb.zzcW(zzaT)) {
                case MessageApi.FILTER_PREFIX /*1*/:
                    dataType = (DataType) zzb.zza(parcel, zzaT, DataType.CREATOR);
                    break;
                case ChannelListener.CLOSE_REASON_REMOTE_CLOSE /*2*/:
                    str2 = zzb.zzq(parcel, zzaT);
                    break;
                case ChannelListener.CLOSE_REASON_LOCAL_CLOSE /*3*/:
                    i = zzb.zzg(parcel, zzaT);
                    break;
                case Dimension.UNIT_IN /*4*/:
                    device = (Device) zzb.zza(parcel, zzaT, Device.CREATOR);
                    break;
                case Dimension.UNIT_MM /*5*/:
                    com_google_android_gms_fitness_data_zzb = (zzb) zzb.zza(parcel, zzaT, zzb.CREATOR);
                    break;
                case BuyButtonText.LOGO_ONLY /*6*/:
                    str = zzb.zzq(parcel, zzaT);
                    break;
                case Requests.MAX_REQUEST_RECIPIENTS /*8*/:
                    iArr = zzb.zzw(parcel, zzaT);
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
            return new DataSource(i2, dataType, str2, i, device, com_google_android_gms_fitness_data_zzb, str, iArr);
        }
        throw new zza("Overread allowed size end=" + zzaU, parcel);
    }

    public DataSource[] zzgv(int i) {
        return new DataSource[i];
    }
}
