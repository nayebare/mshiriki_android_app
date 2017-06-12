package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.common.internal.safeparcel.zzb.zza;
import com.google.android.gms.common.internal.safeparcel.zzc;
import com.google.android.gms.fitness.data.DataSet;
import com.google.android.gms.wallet.WalletConstants.CardNetwork;
import com.google.android.gms.wallet.fragment.WalletFragmentStyle.Dimension;
import com.google.android.gms.wearable.ChannelApi.ChannelListener;
import com.google.android.gms.wearable.MessageApi;

public class zzs implements Creator<DataUpdateRequest> {
    static void zza(DataUpdateRequest dataUpdateRequest, Parcel parcel, int i) {
        int zzaV = zzc.zzaV(parcel);
        zzc.zza(parcel, 1, dataUpdateRequest.zzpN());
        zzc.zza(parcel, 2, dataUpdateRequest.zzzx());
        zzc.zza(parcel, 3, dataUpdateRequest.getDataSet(), i, false);
        zzc.zza(parcel, 4, dataUpdateRequest.getCallbackBinder(), false);
        zzc.zzc(parcel, CardNetwork.OTHER, dataUpdateRequest.getVersionCode());
        zzc.zzJ(parcel, zzaV);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzey(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzhh(i);
    }

    public DataUpdateRequest zzey(Parcel parcel) {
        long j = 0;
        IBinder iBinder = null;
        int zzaU = zzb.zzaU(parcel);
        int i = 0;
        DataSet dataSet = null;
        long j2 = 0;
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
                    dataSet = (DataSet) zzb.zza(parcel, zzaT, DataSet.CREATOR);
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
            return new DataUpdateRequest(i, j2, j, dataSet, iBinder);
        }
        throw new zza("Overread allowed size end=" + zzaU, parcel);
    }

    public DataUpdateRequest[] zzhh(int i) {
        return new DataUpdateRequest[i];
    }
}
