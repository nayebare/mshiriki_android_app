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
import java.util.List;

public class zzz implements Creator<RawDataSet> {
    static void zza(RawDataSet rawDataSet, Parcel parcel, int i) {
        int zzaV = zzc.zzaV(parcel);
        zzc.zzc(parcel, 1, rawDataSet.zzaTD);
        zzc.zzc(parcel, 2, rawDataSet.zzaTH);
        zzc.zzc(parcel, 3, rawDataSet.zzaTI, false);
        zzc.zza(parcel, 4, rawDataSet.zzaQZ);
        zzc.zzc(parcel, CardNetwork.OTHER, rawDataSet.mVersionCode);
        zzc.zzJ(parcel, zzaV);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzee(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzgK(i);
    }

    public RawDataSet zzee(Parcel parcel) {
        boolean z = false;
        int zzaU = zzb.zzaU(parcel);
        List list = null;
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        while (parcel.dataPosition() < zzaU) {
            int zzaT = zzb.zzaT(parcel);
            switch (zzb.zzcW(zzaT)) {
                case MessageApi.FILTER_PREFIX /*1*/:
                    i2 = zzb.zzg(parcel, zzaT);
                    break;
                case ChannelListener.CLOSE_REASON_REMOTE_CLOSE /*2*/:
                    i = zzb.zzg(parcel, zzaT);
                    break;
                case ChannelListener.CLOSE_REASON_LOCAL_CLOSE /*3*/:
                    list = zzb.zzc(parcel, zzaT, RawDataPoint.CREATOR);
                    break;
                case Dimension.UNIT_IN /*4*/:
                    z = zzb.zzc(parcel, zzaT);
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
            return new RawDataSet(i3, i2, i, list, z);
        }
        throw new zza("Overread allowed size end=" + zzaU, parcel);
    }

    public RawDataSet[] zzgK(int i) {
        return new RawDataSet[i];
    }
}
