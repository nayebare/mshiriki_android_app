package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.common.internal.safeparcel.zzb.zza;
import com.google.android.gms.common.internal.safeparcel.zzc;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.wallet.WalletConstants.CardNetwork;
import com.google.android.gms.wallet.fragment.WalletFragmentStyle.Dimension;
import com.google.android.gms.wearable.ChannelApi.ChannelListener;
import com.google.android.gms.wearable.MessageApi;
import java.util.List;

public class zzl implements Creator<DataSourcesRequest> {
    static void zza(DataSourcesRequest dataSourcesRequest, Parcel parcel, int i) {
        int zzaV = zzc.zzaV(parcel);
        zzc.zzc(parcel, 1, dataSourcesRequest.getDataTypes(), false);
        zzc.zza(parcel, 2, dataSourcesRequest.zzCi(), false);
        zzc.zza(parcel, 3, dataSourcesRequest.zzCj());
        zzc.zza(parcel, 4, dataSourcesRequest.getCallbackBinder(), false);
        zzc.zzc(parcel, CardNetwork.OTHER, dataSourcesRequest.getVersionCode());
        zzc.zzJ(parcel, zzaV);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzet(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzhc(i);
    }

    public DataSourcesRequest zzet(Parcel parcel) {
        boolean z = false;
        IBinder iBinder = null;
        int zzaU = zzb.zzaU(parcel);
        List list = null;
        List list2 = null;
        int i = 0;
        while (parcel.dataPosition() < zzaU) {
            int zzaT = zzb.zzaT(parcel);
            switch (zzb.zzcW(zzaT)) {
                case MessageApi.FILTER_PREFIX /*1*/:
                    list2 = zzb.zzc(parcel, zzaT, DataType.CREATOR);
                    break;
                case ChannelListener.CLOSE_REASON_REMOTE_CLOSE /*2*/:
                    list = zzb.zzD(parcel, zzaT);
                    break;
                case ChannelListener.CLOSE_REASON_LOCAL_CLOSE /*3*/:
                    z = zzb.zzc(parcel, zzaT);
                    break;
                case Dimension.UNIT_IN /*4*/:
                    iBinder = zzb.zzr(parcel, zzaT);
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
            return new DataSourcesRequest(i, list2, list, z, iBinder);
        }
        throw new zza("Overread allowed size end=" + zzaU, parcel);
    }

    public DataSourcesRequest[] zzhc(int i) {
        return new DataSourcesRequest[i];
    }
}
