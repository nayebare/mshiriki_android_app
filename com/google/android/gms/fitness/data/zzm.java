package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.common.internal.safeparcel.zzb.zza;
import com.google.android.gms.common.internal.safeparcel.zzc;
import com.google.android.gms.wallet.WalletConstants.CardNetwork;
import com.google.android.gms.wallet.fragment.WalletFragmentStyle.Dimension;
import com.google.android.gms.wearable.ChannelApi.ChannelListener;
import com.google.android.gms.wearable.MessageApi;

public class zzm implements Creator<DataUpdateNotification> {
    static void zza(DataUpdateNotification dataUpdateNotification, Parcel parcel, int i) {
        int zzaV = zzc.zzaV(parcel);
        zzc.zza(parcel, 1, dataUpdateNotification.zzBw());
        zzc.zza(parcel, 2, dataUpdateNotification.zzBx());
        zzc.zzc(parcel, 3, dataUpdateNotification.getOperationType());
        zzc.zza(parcel, 4, dataUpdateNotification.getDataSource(), i, false);
        zzc.zza(parcel, 5, dataUpdateNotification.getDataType(), i, false);
        zzc.zzc(parcel, CardNetwork.OTHER, dataUpdateNotification.mVersionCode);
        zzc.zzJ(parcel, zzaV);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzdU(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzgx(i);
    }

    public DataUpdateNotification zzdU(Parcel parcel) {
        long j = 0;
        DataType dataType = null;
        int i = 0;
        int zzaU = zzb.zzaU(parcel);
        DataSource dataSource = null;
        long j2 = 0;
        int i2 = 0;
        while (parcel.dataPosition() < zzaU) {
            int zzaT = zzb.zzaT(parcel);
            switch (zzb.zzcW(zzaT)) {
                case MessageApi.FILTER_PREFIX /*1*/:
                    j2 = zzb.zzi(parcel, zzaT);
                    break;
                case ChannelListener.CLOSE_REASON_REMOTE_CLOSE /*2*/:
                    j = zzb.zzi(parcel, zzaT);
                    break;
                case ChannelListener.CLOSE_REASON_LOCAL_CLOSE /*3*/:
                    i = zzb.zzg(parcel, zzaT);
                    break;
                case Dimension.UNIT_IN /*4*/:
                    dataSource = (DataSource) zzb.zza(parcel, zzaT, DataSource.CREATOR);
                    break;
                case Dimension.UNIT_MM /*5*/:
                    dataType = (DataType) zzb.zza(parcel, zzaT, DataType.CREATOR);
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
            return new DataUpdateNotification(i2, j2, j, i, dataSource, dataType);
        }
        throw new zza("Overread allowed size end=" + zzaU, parcel);
    }

    public DataUpdateNotification[] zzgx(int i) {
        return new DataUpdateNotification[i];
    }
}
