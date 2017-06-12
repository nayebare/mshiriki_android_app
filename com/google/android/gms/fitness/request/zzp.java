package com.google.android.gms.fitness.request;

import android.app.PendingIntent;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.common.internal.safeparcel.zzb.zza;
import com.google.android.gms.common.internal.safeparcel.zzc;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.wallet.WalletConstants.CardNetwork;
import com.google.android.gms.wallet.fragment.WalletFragmentStyle.Dimension;
import com.google.android.gms.wearable.ChannelApi.ChannelListener;
import com.google.android.gms.wearable.MessageApi;

public class zzp implements Creator<DataUpdateListenerRegistrationRequest> {
    static void zza(DataUpdateListenerRegistrationRequest dataUpdateListenerRegistrationRequest, Parcel parcel, int i) {
        int zzaV = zzc.zzaV(parcel);
        zzc.zza(parcel, 1, dataUpdateListenerRegistrationRequest.getDataSource(), i, false);
        zzc.zza(parcel, 2, dataUpdateListenerRegistrationRequest.getDataType(), i, false);
        zzc.zza(parcel, 3, dataUpdateListenerRegistrationRequest.getIntent(), i, false);
        zzc.zza(parcel, 4, dataUpdateListenerRegistrationRequest.getCallbackBinder(), false);
        zzc.zzc(parcel, CardNetwork.OTHER, dataUpdateListenerRegistrationRequest.getVersionCode());
        zzc.zzJ(parcel, zzaV);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzew(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzhf(i);
    }

    public DataUpdateListenerRegistrationRequest zzew(Parcel parcel) {
        IBinder iBinder = null;
        int zzaU = zzb.zzaU(parcel);
        int i = 0;
        PendingIntent pendingIntent = null;
        DataType dataType = null;
        DataSource dataSource = null;
        while (parcel.dataPosition() < zzaU) {
            int zzaT = zzb.zzaT(parcel);
            switch (zzb.zzcW(zzaT)) {
                case MessageApi.FILTER_PREFIX /*1*/:
                    dataSource = (DataSource) zzb.zza(parcel, zzaT, DataSource.CREATOR);
                    break;
                case ChannelListener.CLOSE_REASON_REMOTE_CLOSE /*2*/:
                    dataType = (DataType) zzb.zza(parcel, zzaT, DataType.CREATOR);
                    break;
                case ChannelListener.CLOSE_REASON_LOCAL_CLOSE /*3*/:
                    pendingIntent = (PendingIntent) zzb.zza(parcel, zzaT, PendingIntent.CREATOR);
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
            return new DataUpdateListenerRegistrationRequest(i, dataSource, dataType, pendingIntent, iBinder);
        }
        throw new zza("Overread allowed size end=" + zzaU, parcel);
    }

    public DataUpdateListenerRegistrationRequest[] zzhf(int i) {
        return new DataUpdateListenerRegistrationRequest[i];
    }
}
