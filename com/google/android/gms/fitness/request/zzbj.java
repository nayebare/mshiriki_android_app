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
import java.util.List;

public class zzbj implements Creator<StartBleScanRequest> {
    static void zza(StartBleScanRequest startBleScanRequest, Parcel parcel, int i) {
        int zzaV = zzc.zzaV(parcel);
        zzc.zzc(parcel, 1, startBleScanRequest.getDataTypes(), false);
        zzc.zza(parcel, 2, startBleScanRequest.zzCy(), false);
        zzc.zzc(parcel, 3, startBleScanRequest.getTimeoutSecs());
        zzc.zza(parcel, 4, startBleScanRequest.getCallbackBinder(), false);
        zzc.zzc(parcel, CardNetwork.OTHER, startBleScanRequest.getVersionCode());
        zzc.zzJ(parcel, zzaV);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzeU(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzhD(i);
    }

    public StartBleScanRequest zzeU(Parcel parcel) {
        int i = 0;
        IBinder iBinder = null;
        int zzaU = zzb.zzaU(parcel);
        IBinder iBinder2 = null;
        List list = null;
        int i2 = 0;
        while (parcel.dataPosition() < zzaU) {
            int zzaT = zzb.zzaT(parcel);
            switch (zzb.zzcW(zzaT)) {
                case MessageApi.FILTER_PREFIX /*1*/:
                    list = zzb.zzc(parcel, zzaT, DataType.CREATOR);
                    break;
                case ChannelListener.CLOSE_REASON_REMOTE_CLOSE /*2*/:
                    iBinder2 = zzb.zzr(parcel, zzaT);
                    break;
                case ChannelListener.CLOSE_REASON_LOCAL_CLOSE /*3*/:
                    i = zzb.zzg(parcel, zzaT);
                    break;
                case Dimension.UNIT_IN /*4*/:
                    iBinder = zzb.zzr(parcel, zzaT);
                    break;
                case CardNetwork.OTHER /*1000*/:
                    i2 = zzb.zzg(parcel, zzaT);
                    break;
                default:
                    zzb.zzb(parcel, zzaT);
                    break;
            }
        }
        if (parcel.dataPosition() == zzaU) {
            return new StartBleScanRequest(i2, list, iBinder2, i, iBinder);
        }
        throw new zza("Overread allowed size end=" + zzaU, parcel);
    }

    public StartBleScanRequest[] zzhD(int i) {
        return new StartBleScanRequest[i];
    }
}
