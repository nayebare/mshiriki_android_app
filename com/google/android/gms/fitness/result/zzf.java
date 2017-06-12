package com.google.android.gms.fitness.result;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.common.internal.safeparcel.zzb.zza;
import com.google.android.gms.common.internal.safeparcel.zzc;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.wallet.WalletConstants.CardNetwork;
import com.google.android.gms.wearable.ChannelApi.ChannelListener;
import com.google.android.gms.wearable.MessageApi;
import java.util.List;

public class zzf implements Creator<DataSourcesResult> {
    static void zza(DataSourcesResult dataSourcesResult, Parcel parcel, int i) {
        int zzaV = zzc.zzaV(parcel);
        zzc.zzc(parcel, 1, dataSourcesResult.getDataSources(), false);
        zzc.zza(parcel, 2, dataSourcesResult.getStatus(), i, false);
        zzc.zzc(parcel, CardNetwork.OTHER, dataSourcesResult.getVersionCode());
        zzc.zzJ(parcel, zzaV);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzfe(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzhN(i);
    }

    public DataSourcesResult zzfe(Parcel parcel) {
        Status status = null;
        int zzaU = zzb.zzaU(parcel);
        int i = 0;
        List list = null;
        while (parcel.dataPosition() < zzaU) {
            int zzaT = zzb.zzaT(parcel);
            switch (zzb.zzcW(zzaT)) {
                case MessageApi.FILTER_PREFIX /*1*/:
                    list = zzb.zzc(parcel, zzaT, DataSource.CREATOR);
                    break;
                case ChannelListener.CLOSE_REASON_REMOTE_CLOSE /*2*/:
                    status = (Status) zzb.zza(parcel, zzaT, Status.CREATOR);
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
            return new DataSourcesResult(i, list, status);
        }
        throw new zza("Overread allowed size end=" + zzaU, parcel);
    }

    public DataSourcesResult[] zzhN(int i) {
        return new DataSourcesResult[i];
    }
}
