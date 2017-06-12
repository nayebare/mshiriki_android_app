package com.google.android.gms.fitness.service;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.common.internal.safeparcel.zzc;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.wallet.WalletConstants.CardNetwork;
import com.google.android.gms.wallet.fragment.WalletFragmentStyle.Dimension;
import com.google.android.gms.wearable.ChannelApi.ChannelListener;
import com.google.android.gms.wearable.MessageApi;

public class zza implements Creator<FitnessSensorServiceRequest> {
    static void zza(FitnessSensorServiceRequest fitnessSensorServiceRequest, Parcel parcel, int i) {
        int zzaV = zzc.zzaV(parcel);
        zzc.zza(parcel, 1, fitnessSensorServiceRequest.getDataSource(), i, false);
        zzc.zza(parcel, 2, fitnessSensorServiceRequest.zzCt(), false);
        zzc.zza(parcel, 3, fitnessSensorServiceRequest.zzBK());
        zzc.zza(parcel, 4, fitnessSensorServiceRequest.zzCO());
        zzc.zzc(parcel, CardNetwork.OTHER, fitnessSensorServiceRequest.getVersionCode());
        zzc.zzJ(parcel, zzaV);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzfq(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzhZ(i);
    }

    public FitnessSensorServiceRequest zzfq(Parcel parcel) {
        long j = 0;
        IBinder iBinder = null;
        int zzaU = zzb.zzaU(parcel);
        int i = 0;
        long j2 = 0;
        DataSource dataSource = null;
        while (parcel.dataPosition() < zzaU) {
            int zzaT = zzb.zzaT(parcel);
            switch (zzb.zzcW(zzaT)) {
                case MessageApi.FILTER_PREFIX /*1*/:
                    dataSource = (DataSource) zzb.zza(parcel, zzaT, DataSource.CREATOR);
                    break;
                case ChannelListener.CLOSE_REASON_REMOTE_CLOSE /*2*/:
                    iBinder = zzb.zzr(parcel, zzaT);
                    break;
                case ChannelListener.CLOSE_REASON_LOCAL_CLOSE /*3*/:
                    j2 = zzb.zzi(parcel, zzaT);
                    break;
                case Dimension.UNIT_IN /*4*/:
                    j = zzb.zzi(parcel, zzaT);
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
            return new FitnessSensorServiceRequest(i, dataSource, iBinder, j2, j);
        }
        throw new com.google.android.gms.common.internal.safeparcel.zzb.zza("Overread allowed size end=" + zzaU, parcel);
    }

    public FitnessSensorServiceRequest[] zzhZ(int i) {
        return new FitnessSensorServiceRequest[i];
    }
}
