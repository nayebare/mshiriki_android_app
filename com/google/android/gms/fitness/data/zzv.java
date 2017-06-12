package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.common.internal.safeparcel.zzb.zza;
import com.google.android.gms.common.internal.safeparcel.zzc;
import com.google.android.gms.wallet.WalletConstants.CardNetwork;
import com.google.android.gms.wearable.ChannelApi.ChannelListener;
import com.google.android.gms.wearable.MessageApi;

public class zzv implements Creator<MapValue> {
    static void zza(MapValue mapValue, Parcel parcel, int i) {
        int zzaV = zzc.zzaV(parcel);
        zzc.zzc(parcel, 1, mapValue.getFormat());
        zzc.zza(parcel, 2, mapValue.zzBI());
        zzc.zzc(parcel, CardNetwork.OTHER, mapValue.getVersionCode());
        zzc.zzJ(parcel, zzaV);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzea(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzgG(i);
    }

    public MapValue zzea(Parcel parcel) {
        int i = 0;
        int zzaU = zzb.zzaU(parcel);
        float f = 0.0f;
        int i2 = 0;
        while (parcel.dataPosition() < zzaU) {
            int zzaT = zzb.zzaT(parcel);
            switch (zzb.zzcW(zzaT)) {
                case MessageApi.FILTER_PREFIX /*1*/:
                    i = zzb.zzg(parcel, zzaT);
                    break;
                case ChannelListener.CLOSE_REASON_REMOTE_CLOSE /*2*/:
                    f = zzb.zzl(parcel, zzaT);
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
            return new MapValue(i2, i, f);
        }
        throw new zza("Overread allowed size end=" + zzaU, parcel);
    }

    public MapValue[] zzgG(int i) {
        return new MapValue[i];
    }
}
