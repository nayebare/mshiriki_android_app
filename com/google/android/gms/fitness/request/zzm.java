package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.common.internal.safeparcel.zzb.zza;
import com.google.android.gms.common.internal.safeparcel.zzc;
import com.google.android.gms.fitness.data.Field;
import com.google.android.gms.wallet.WalletConstants.CardNetwork;
import com.google.android.gms.wearable.ChannelApi.ChannelListener;
import com.google.android.gms.wearable.MessageApi;
import java.util.List;

public class zzm implements Creator<DataTypeCreateRequest> {
    static void zza(DataTypeCreateRequest dataTypeCreateRequest, Parcel parcel, int i) {
        int zzaV = zzc.zzaV(parcel);
        zzc.zza(parcel, 1, dataTypeCreateRequest.getName(), false);
        zzc.zzc(parcel, 2, dataTypeCreateRequest.getFields(), false);
        zzc.zza(parcel, 3, dataTypeCreateRequest.getCallbackBinder(), false);
        zzc.zzc(parcel, CardNetwork.OTHER, dataTypeCreateRequest.getVersionCode());
        zzc.zzJ(parcel, zzaV);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzeu(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzhd(i);
    }

    public DataTypeCreateRequest zzeu(Parcel parcel) {
        IBinder iBinder = null;
        int zzaU = zzb.zzaU(parcel);
        int i = 0;
        List list = null;
        String str = null;
        while (parcel.dataPosition() < zzaU) {
            int zzaT = zzb.zzaT(parcel);
            switch (zzb.zzcW(zzaT)) {
                case MessageApi.FILTER_PREFIX /*1*/:
                    str = zzb.zzq(parcel, zzaT);
                    break;
                case ChannelListener.CLOSE_REASON_REMOTE_CLOSE /*2*/:
                    list = zzb.zzc(parcel, zzaT, Field.CREATOR);
                    break;
                case ChannelListener.CLOSE_REASON_LOCAL_CLOSE /*3*/:
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
            return new DataTypeCreateRequest(i, str, list, iBinder);
        }
        throw new zza("Overread allowed size end=" + zzaU, parcel);
    }

    public DataTypeCreateRequest[] zzhd(int i) {
        return new DataTypeCreateRequest[i];
    }
}
