package com.google.android.gms.fitness.result;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.common.internal.safeparcel.zzb.zza;
import com.google.android.gms.common.internal.safeparcel.zzc;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.wallet.WalletConstants.CardNetwork;
import com.google.android.gms.wearable.ChannelApi.ChannelListener;
import com.google.android.gms.wearable.MessageApi;

public class zzi implements Creator<DataTypeResult> {
    static void zza(DataTypeResult dataTypeResult, Parcel parcel, int i) {
        int zzaV = zzc.zzaV(parcel);
        zzc.zza(parcel, 1, dataTypeResult.getStatus(), i, false);
        zzc.zza(parcel, 3, dataTypeResult.getDataType(), i, false);
        zzc.zzc(parcel, CardNetwork.OTHER, dataTypeResult.getVersionCode());
        zzc.zzJ(parcel, zzaV);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzfg(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzhP(i);
    }

    public DataTypeResult zzfg(Parcel parcel) {
        DataType dataType = null;
        int zzaU = zzb.zzaU(parcel);
        int i = 0;
        Status status = null;
        while (parcel.dataPosition() < zzaU) {
            int i2;
            DataType dataType2;
            Status status2;
            int zzaT = zzb.zzaT(parcel);
            switch (zzb.zzcW(zzaT)) {
                case MessageApi.FILTER_PREFIX /*1*/:
                    i2 = i;
                    Status status3 = (Status) zzb.zza(parcel, zzaT, Status.CREATOR);
                    dataType2 = dataType;
                    status2 = status3;
                    break;
                case ChannelListener.CLOSE_REASON_LOCAL_CLOSE /*3*/:
                    dataType2 = (DataType) zzb.zza(parcel, zzaT, DataType.CREATOR);
                    status2 = status;
                    i2 = i;
                    break;
                case CardNetwork.OTHER /*1000*/:
                    DataType dataType3 = dataType;
                    status2 = status;
                    i2 = zzb.zzg(parcel, zzaT);
                    dataType2 = dataType3;
                    break;
                default:
                    zzb.zzb(parcel, zzaT);
                    dataType2 = dataType;
                    status2 = status;
                    i2 = i;
                    break;
            }
            i = i2;
            status = status2;
            dataType = dataType2;
        }
        if (parcel.dataPosition() == zzaU) {
            return new DataTypeResult(i, status, dataType);
        }
        throw new zza("Overread allowed size end=" + zzaU, parcel);
    }

    public DataTypeResult[] zzhP(int i) {
        return new DataTypeResult[i];
    }
}
