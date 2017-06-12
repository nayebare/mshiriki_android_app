package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.common.internal.safeparcel.zzb.zza;
import com.google.android.gms.common.internal.safeparcel.zzc;
import com.google.android.gms.wallet.WalletConstants.CardNetwork;
import com.google.android.gms.wearable.ChannelApi.ChannelListener;
import com.google.android.gms.wearable.MessageApi;

public class zzp implements Creator<Field> {
    static void zza(Field field, Parcel parcel, int i) {
        int zzaV = zzc.zzaV(parcel);
        zzc.zza(parcel, 1, field.getName(), false);
        zzc.zzc(parcel, 2, field.getFormat());
        zzc.zza(parcel, 3, field.isOptional(), false);
        zzc.zzc(parcel, CardNetwork.OTHER, field.getVersionCode());
        zzc.zzJ(parcel, zzaV);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzdX(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzgA(i);
    }

    public Field zzdX(Parcel parcel) {
        Boolean bool = null;
        int i = 0;
        int zzaU = zzb.zzaU(parcel);
        String str = null;
        int i2 = 0;
        while (parcel.dataPosition() < zzaU) {
            int zzaT = zzb.zzaT(parcel);
            switch (zzb.zzcW(zzaT)) {
                case MessageApi.FILTER_PREFIX /*1*/:
                    str = zzb.zzq(parcel, zzaT);
                    break;
                case ChannelListener.CLOSE_REASON_REMOTE_CLOSE /*2*/:
                    i = zzb.zzg(parcel, zzaT);
                    break;
                case ChannelListener.CLOSE_REASON_LOCAL_CLOSE /*3*/:
                    bool = zzb.zzd(parcel, zzaT);
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
            return new Field(i2, str, i, bool);
        }
        throw new zza("Overread allowed size end=" + zzaU, parcel);
    }

    public Field[] zzgA(int i) {
        return new Field[i];
    }
}
