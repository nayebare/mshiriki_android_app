package com.google.android.gms.fitness.result;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.common.internal.safeparcel.zzc;
import com.google.android.gms.fitness.data.BleDevice;
import com.google.android.gms.wallet.WalletConstants.CardNetwork;
import com.google.android.gms.wearable.ChannelApi.ChannelListener;
import com.google.android.gms.wearable.MessageApi;
import java.util.List;

public class zza implements Creator<BleDevicesResult> {
    static void zza(BleDevicesResult bleDevicesResult, Parcel parcel, int i) {
        int zzaV = zzc.zzaV(parcel);
        zzc.zzc(parcel, 1, bleDevicesResult.getClaimedBleDevices(), false);
        zzc.zza(parcel, 2, bleDevicesResult.getStatus(), i, false);
        zzc.zzc(parcel, CardNetwork.OTHER, bleDevicesResult.getVersionCode());
        zzc.zzJ(parcel, zzaV);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzfa(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzhJ(i);
    }

    public BleDevicesResult zzfa(Parcel parcel) {
        Status status = null;
        int zzaU = zzb.zzaU(parcel);
        int i = 0;
        List list = null;
        while (parcel.dataPosition() < zzaU) {
            int zzaT = zzb.zzaT(parcel);
            switch (zzb.zzcW(zzaT)) {
                case MessageApi.FILTER_PREFIX /*1*/:
                    list = zzb.zzc(parcel, zzaT, BleDevice.CREATOR);
                    break;
                case ChannelListener.CLOSE_REASON_REMOTE_CLOSE /*2*/:
                    status = (Status) zzb.zza(parcel, zzaT, Status.CREATOR);
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
            return new BleDevicesResult(i, list, status);
        }
        throw new com.google.android.gms.common.internal.safeparcel.zzb.zza("Overread allowed size end=" + zzaU, parcel);
    }

    public BleDevicesResult[] zzhJ(int i) {
        return new BleDevicesResult[i];
    }
}
