package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.common.internal.safeparcel.zzb.zza;
import com.google.android.gms.common.internal.safeparcel.zzc;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.wallet.WalletConstants.CardNetwork;
import com.google.android.gms.wearable.ChannelApi.ChannelListener;
import com.google.android.gms.wearable.MessageApi;

public class zzbr implements Creator<zzbq> {
    static void zza(zzbq com_google_android_gms_fitness_request_zzbq, Parcel parcel, int i) {
        int zzaV = zzc.zzaV(parcel);
        zzc.zza(parcel, 1, com_google_android_gms_fitness_request_zzbq.getDataType(), i, false);
        zzc.zza(parcel, 2, com_google_android_gms_fitness_request_zzbq.getDataSource(), i, false);
        zzc.zza(parcel, 3, com_google_android_gms_fitness_request_zzbq.getCallbackBinder(), false);
        zzc.zzc(parcel, CardNetwork.OTHER, com_google_android_gms_fitness_request_zzbq.getVersionCode());
        zzc.zzJ(parcel, zzaV);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzeY(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzhH(i);
    }

    public zzbq zzeY(Parcel parcel) {
        IBinder iBinder = null;
        int zzaU = zzb.zzaU(parcel);
        int i = 0;
        DataSource dataSource = null;
        DataType dataType = null;
        while (parcel.dataPosition() < zzaU) {
            int i2;
            DataType dataType2;
            IBinder iBinder2;
            DataSource dataSource2;
            int zzaT = zzb.zzaT(parcel);
            IBinder iBinder3;
            switch (zzb.zzcW(zzaT)) {
                case MessageApi.FILTER_PREFIX /*1*/:
                    i2 = i;
                    DataSource dataSource3 = dataSource;
                    dataType2 = (DataType) zzb.zza(parcel, zzaT, DataType.CREATOR);
                    iBinder2 = iBinder;
                    dataSource2 = dataSource3;
                    break;
                case ChannelListener.CLOSE_REASON_REMOTE_CLOSE /*2*/:
                    dataType2 = dataType;
                    i2 = i;
                    iBinder3 = iBinder;
                    dataSource2 = (DataSource) zzb.zza(parcel, zzaT, DataSource.CREATOR);
                    iBinder2 = iBinder3;
                    break;
                case ChannelListener.CLOSE_REASON_LOCAL_CLOSE /*3*/:
                    iBinder2 = zzb.zzr(parcel, zzaT);
                    dataSource2 = dataSource;
                    dataType2 = dataType;
                    i2 = i;
                    break;
                case CardNetwork.OTHER /*1000*/:
                    iBinder3 = iBinder;
                    dataSource2 = dataSource;
                    dataType2 = dataType;
                    i2 = zzb.zzg(parcel, zzaT);
                    iBinder2 = iBinder3;
                    break;
                default:
                    zzb.zzb(parcel, zzaT);
                    iBinder2 = iBinder;
                    dataSource2 = dataSource;
                    dataType2 = dataType;
                    i2 = i;
                    break;
            }
            i = i2;
            dataType = dataType2;
            dataSource = dataSource2;
            iBinder = iBinder2;
        }
        if (parcel.dataPosition() == zzaU) {
            return new zzbq(i, dataType, dataSource, iBinder);
        }
        throw new zza("Overread allowed size end=" + zzaU, parcel);
    }

    public zzbq[] zzhH(int i) {
        return new zzbq[i];
    }
}
