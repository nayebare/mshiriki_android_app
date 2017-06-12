package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.common.internal.safeparcel.zzb.zza;
import com.google.android.gms.common.internal.safeparcel.zzc;
import com.google.android.gms.wallet.WalletConstants.CardNetwork;
import com.google.android.gms.wallet.fragment.WalletFragmentStyle.Dimension;
import com.google.android.gms.wearable.ChannelApi.ChannelListener;
import com.google.android.gms.wearable.MessageApi;
import java.util.List;

public class zzd implements Creator<BleDevice> {
    static void zza(BleDevice bleDevice, Parcel parcel, int i) {
        int zzaV = zzc.zzaV(parcel);
        zzc.zza(parcel, 1, bleDevice.getAddress(), false);
        zzc.zza(parcel, 2, bleDevice.getName(), false);
        zzc.zzb(parcel, 3, bleDevice.getSupportedProfiles(), false);
        zzc.zzc(parcel, 4, bleDevice.getDataTypes(), false);
        zzc.zzc(parcel, CardNetwork.OTHER, bleDevice.getVersionCode());
        zzc.zzJ(parcel, zzaV);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzdO(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzgm(i);
    }

    public BleDevice zzdO(Parcel parcel) {
        List list = null;
        int zzaU = zzb.zzaU(parcel);
        int i = 0;
        List list2 = null;
        String str = null;
        String str2 = null;
        while (parcel.dataPosition() < zzaU) {
            int zzaT = zzb.zzaT(parcel);
            switch (zzb.zzcW(zzaT)) {
                case MessageApi.FILTER_PREFIX /*1*/:
                    str2 = zzb.zzq(parcel, zzaT);
                    break;
                case ChannelListener.CLOSE_REASON_REMOTE_CLOSE /*2*/:
                    str = zzb.zzq(parcel, zzaT);
                    break;
                case ChannelListener.CLOSE_REASON_LOCAL_CLOSE /*3*/:
                    list2 = zzb.zzE(parcel, zzaT);
                    break;
                case Dimension.UNIT_IN /*4*/:
                    list = zzb.zzc(parcel, zzaT, DataType.CREATOR);
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
            return new BleDevice(i, str2, str, list2, list);
        }
        throw new zza("Overread allowed size end=" + zzaU, parcel);
    }

    public BleDevice[] zzgm(int i) {
        return new BleDevice[i];
    }
}
