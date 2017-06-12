package com.google.android.gms.fitness.result;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.zzb.zza;
import com.google.android.gms.common.internal.safeparcel.zzc;
import com.google.android.gms.fitness.data.DataSet;
import com.google.android.gms.wallet.WalletConstants.CardNetwork;
import com.google.android.gms.wearable.ChannelApi.ChannelListener;
import com.google.android.gms.wearable.MessageApi;

public class zzb implements Creator<DailyTotalResult> {
    static void zza(DailyTotalResult dailyTotalResult, Parcel parcel, int i) {
        int zzaV = zzc.zzaV(parcel);
        zzc.zza(parcel, 1, dailyTotalResult.getStatus(), i, false);
        zzc.zza(parcel, 2, dailyTotalResult.getTotal(), i, false);
        zzc.zzc(parcel, CardNetwork.OTHER, dailyTotalResult.getVersionCode());
        zzc.zzJ(parcel, zzaV);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzfb(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzhK(i);
    }

    public DailyTotalResult zzfb(Parcel parcel) {
        DataSet dataSet = null;
        int zzaU = com.google.android.gms.common.internal.safeparcel.zzb.zzaU(parcel);
        int i = 0;
        Status status = null;
        while (parcel.dataPosition() < zzaU) {
            int i2;
            DataSet dataSet2;
            Status status2;
            int zzaT = com.google.android.gms.common.internal.safeparcel.zzb.zzaT(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.zzb.zzcW(zzaT)) {
                case MessageApi.FILTER_PREFIX /*1*/:
                    i2 = i;
                    Status status3 = (Status) com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, zzaT, Status.CREATOR);
                    dataSet2 = dataSet;
                    status2 = status3;
                    break;
                case ChannelListener.CLOSE_REASON_REMOTE_CLOSE /*2*/:
                    dataSet2 = (DataSet) com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, zzaT, DataSet.CREATOR);
                    status2 = status;
                    i2 = i;
                    break;
                case CardNetwork.OTHER /*1000*/:
                    DataSet dataSet3 = dataSet;
                    status2 = status;
                    i2 = com.google.android.gms.common.internal.safeparcel.zzb.zzg(parcel, zzaT);
                    dataSet2 = dataSet3;
                    break;
                default:
                    com.google.android.gms.common.internal.safeparcel.zzb.zzb(parcel, zzaT);
                    dataSet2 = dataSet;
                    status2 = status;
                    i2 = i;
                    break;
            }
            i = i2;
            status = status2;
            dataSet = dataSet2;
        }
        if (parcel.dataPosition() == zzaU) {
            return new DailyTotalResult(i, status, dataSet);
        }
        throw new zza("Overread allowed size end=" + zzaU, parcel);
    }

    public DailyTotalResult[] zzhK(int i) {
        return new DailyTotalResult[i];
    }
}
