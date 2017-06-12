package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.common.internal.safeparcel.zzb.zza;
import com.google.android.gms.common.internal.safeparcel.zzc;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.wallet.WalletConstants.CardNetwork;
import com.google.android.gms.wearable.ChannelApi.ChannelListener;
import com.google.android.gms.wearable.MessageApi;

public class zzan implements Creator<zzam> {
    static void zza(zzam com_google_android_gms_fitness_request_zzam, Parcel parcel, int i) {
        int zzaV = zzc.zzaV(parcel);
        zzc.zza(parcel, 1, com_google_android_gms_fitness_request_zzam.getDataType(), i, false);
        zzc.zza(parcel, 2, com_google_android_gms_fitness_request_zzam.getCallbackBinder(), false);
        zzc.zzc(parcel, CardNetwork.OTHER, com_google_android_gms_fitness_request_zzam.getVersionCode());
        zzc.zzJ(parcel, zzaV);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzeI(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzhr(i);
    }

    public zzam zzeI(Parcel parcel) {
        IBinder iBinder = null;
        int zzaU = zzb.zzaU(parcel);
        int i = 0;
        DataType dataType = null;
        while (parcel.dataPosition() < zzaU) {
            int i2;
            IBinder iBinder2;
            DataType dataType2;
            int zzaT = zzb.zzaT(parcel);
            switch (zzb.zzcW(zzaT)) {
                case MessageApi.FILTER_PREFIX /*1*/:
                    i2 = i;
                    DataType dataType3 = (DataType) zzb.zza(parcel, zzaT, DataType.CREATOR);
                    iBinder2 = iBinder;
                    dataType2 = dataType3;
                    break;
                case ChannelListener.CLOSE_REASON_REMOTE_CLOSE /*2*/:
                    iBinder2 = zzb.zzr(parcel, zzaT);
                    dataType2 = dataType;
                    i2 = i;
                    break;
                case CardNetwork.OTHER /*1000*/:
                    IBinder iBinder3 = iBinder;
                    dataType2 = dataType;
                    i2 = zzb.zzg(parcel, zzaT);
                    iBinder2 = iBinder3;
                    break;
                default:
                    zzb.zzb(parcel, zzaT);
                    iBinder2 = iBinder;
                    dataType2 = dataType;
                    i2 = i;
                    break;
            }
            i = i2;
            dataType = dataType2;
            iBinder = iBinder2;
        }
        if (parcel.dataPosition() == zzaU) {
            return new zzam(i, dataType, iBinder);
        }
        throw new zza("Overread allowed size end=" + zzaU, parcel);
    }

    public zzam[] zzhr(int i) {
        return new zzam[i];
    }
}
