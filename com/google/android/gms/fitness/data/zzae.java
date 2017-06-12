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

public class zzae implements Creator<Subscription> {
    static void zza(Subscription subscription, Parcel parcel, int i) {
        int zzaV = zzc.zzaV(parcel);
        zzc.zza(parcel, 1, subscription.getDataSource(), i, false);
        zzc.zza(parcel, 2, subscription.getDataType(), i, false);
        zzc.zza(parcel, 3, subscription.zzBK());
        zzc.zzc(parcel, 4, subscription.getAccuracyMode());
        zzc.zzc(parcel, CardNetwork.OTHER, subscription.getVersionCode());
        zzc.zzJ(parcel, zzaV);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzei(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzgP(i);
    }

    public Subscription zzei(Parcel parcel) {
        DataType dataType = null;
        int i = 0;
        int zzaU = zzb.zzaU(parcel);
        long j = 0;
        DataSource dataSource = null;
        int i2 = 0;
        while (parcel.dataPosition() < zzaU) {
            int zzaT = zzb.zzaT(parcel);
            switch (zzb.zzcW(zzaT)) {
                case MessageApi.FILTER_PREFIX /*1*/:
                    dataSource = (DataSource) zzb.zza(parcel, zzaT, DataSource.CREATOR);
                    break;
                case ChannelListener.CLOSE_REASON_REMOTE_CLOSE /*2*/:
                    dataType = (DataType) zzb.zza(parcel, zzaT, DataType.CREATOR);
                    break;
                case ChannelListener.CLOSE_REASON_LOCAL_CLOSE /*3*/:
                    j = zzb.zzi(parcel, zzaT);
                    break;
                case Dimension.UNIT_IN /*4*/:
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
            return new Subscription(i2, dataSource, dataType, j, i);
        }
        throw new zza("Overread allowed size end=" + zzaU, parcel);
    }

    public Subscription[] zzgP(int i) {
        return new Subscription[i];
    }
}
