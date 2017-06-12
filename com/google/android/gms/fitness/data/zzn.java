package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.common.internal.safeparcel.zzb.zza;
import com.google.android.gms.common.internal.safeparcel.zzc;
import com.google.android.gms.wallet.WalletConstants.CardNetwork;
import com.google.android.gms.wallet.fragment.WalletFragmentStyle.BuyButtonText;
import com.google.android.gms.wallet.fragment.WalletFragmentStyle.Dimension;
import com.google.android.gms.wearable.ChannelApi.ChannelListener;
import com.google.android.gms.wearable.MessageApi;

public class zzn implements Creator<Device> {
    static void zza(Device device, Parcel parcel, int i) {
        int zzaV = zzc.zzaV(parcel);
        zzc.zza(parcel, 1, device.getManufacturer(), false);
        zzc.zza(parcel, 2, device.getModel(), false);
        zzc.zza(parcel, 3, device.getVersion(), false);
        zzc.zza(parcel, 4, device.zzBA(), false);
        zzc.zzc(parcel, 5, device.getType());
        zzc.zzc(parcel, 6, device.zzBy());
        zzc.zzc(parcel, CardNetwork.OTHER, device.getVersionCode());
        zzc.zzJ(parcel, zzaV);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzdV(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzgy(i);
    }

    public Device zzdV(Parcel parcel) {
        int i = 0;
        String str = null;
        int zzaU = zzb.zzaU(parcel);
        int i2 = 0;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        int i3 = 0;
        while (parcel.dataPosition() < zzaU) {
            int zzaT = zzb.zzaT(parcel);
            switch (zzb.zzcW(zzaT)) {
                case MessageApi.FILTER_PREFIX /*1*/:
                    str4 = zzb.zzq(parcel, zzaT);
                    break;
                case ChannelListener.CLOSE_REASON_REMOTE_CLOSE /*2*/:
                    str3 = zzb.zzq(parcel, zzaT);
                    break;
                case ChannelListener.CLOSE_REASON_LOCAL_CLOSE /*3*/:
                    str2 = zzb.zzq(parcel, zzaT);
                    break;
                case Dimension.UNIT_IN /*4*/:
                    str = zzb.zzq(parcel, zzaT);
                    break;
                case Dimension.UNIT_MM /*5*/:
                    i2 = zzb.zzg(parcel, zzaT);
                    break;
                case BuyButtonText.LOGO_ONLY /*6*/:
                    i = zzb.zzg(parcel, zzaT);
                    break;
                case CardNetwork.OTHER /*1000*/:
                    i3 = zzb.zzg(parcel, zzaT);
                    break;
                default:
                    zzb.zzb(parcel, zzaT);
                    break;
            }
        }
        if (parcel.dataPosition() == zzaU) {
            return new Device(i3, str4, str3, str2, str, i2, i);
        }
        throw new zza("Overread allowed size end=" + zzaU, parcel);
    }

    public Device[] zzgy(int i) {
        return new Device[i];
    }
}
