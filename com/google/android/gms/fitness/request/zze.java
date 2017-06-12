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

public class zze implements Creator<zzd> {
    static void zza(zzd com_google_android_gms_fitness_request_zzd, Parcel parcel, int i) {
        int zzaV = zzc.zzaV(parcel);
        zzc.zza(parcel, 1, com_google_android_gms_fitness_request_zzd.getCallbackBinder(), false);
        zzc.zza(parcel, 2, com_google_android_gms_fitness_request_zzd.getDataType(), i, false);
        zzc.zza(parcel, 4, com_google_android_gms_fitness_request_zzd.zzBY());
        zzc.zzc(parcel, CardNetwork.OTHER, com_google_android_gms_fitness_request_zzd.getVersionCode());
        zzc.zzJ(parcel, zzaV);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzeo(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzgX(i);
    }

    public zzd zzeo(Parcel parcel) {
        DataType dataType = null;
        boolean z = false;
        int zzaU = zzb.zzaU(parcel);
        IBinder iBinder = null;
        int i = 0;
        while (parcel.dataPosition() < zzaU) {
            int i2;
            IBinder zzr;
            boolean z2;
            DataType dataType2;
            int zzaT = zzb.zzaT(parcel);
            boolean z3;
            switch (zzb.zzcW(zzaT)) {
                case MessageApi.FILTER_PREFIX /*1*/:
                    i2 = i;
                    DataType dataType3 = dataType;
                    zzr = zzb.zzr(parcel, zzaT);
                    z2 = z;
                    dataType2 = dataType3;
                    break;
                case ChannelListener.CLOSE_REASON_REMOTE_CLOSE /*2*/:
                    zzr = iBinder;
                    i2 = i;
                    z3 = z;
                    dataType2 = (DataType) zzb.zza(parcel, zzaT, DataType.CREATOR);
                    z2 = z3;
                    break;
                case Dimension.UNIT_IN /*4*/:
                    z2 = zzb.zzc(parcel, zzaT);
                    dataType2 = dataType;
                    zzr = iBinder;
                    i2 = i;
                    break;
                case CardNetwork.OTHER /*1000*/:
                    z3 = z;
                    dataType2 = dataType;
                    zzr = iBinder;
                    i2 = zzb.zzg(parcel, zzaT);
                    z2 = z3;
                    break;
                default:
                    zzb.zzb(parcel, zzaT);
                    z2 = z;
                    dataType2 = dataType;
                    zzr = iBinder;
                    i2 = i;
                    break;
            }
            i = i2;
            iBinder = zzr;
            dataType = dataType2;
            z = z2;
        }
        if (parcel.dataPosition() == zzaU) {
            return new zzd(i, iBinder, dataType, z);
        }
        throw new zza("Overread allowed size end=" + zzaU, parcel);
    }

    public zzd[] zzgX(int i) {
        return new zzd[i];
    }
}
