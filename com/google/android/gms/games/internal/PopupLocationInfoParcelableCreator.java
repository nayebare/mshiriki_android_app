package com.google.android.gms.games.internal;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.common.internal.safeparcel.zzb.zza;
import com.google.android.gms.common.internal.safeparcel.zzc;
import com.google.android.gms.wallet.WalletConstants.CardNetwork;
import com.google.android.gms.wearable.ChannelApi.ChannelListener;
import com.google.android.gms.wearable.MessageApi;

public class PopupLocationInfoParcelableCreator implements Creator<PopupLocationInfoParcelable> {
    static void zza(PopupLocationInfoParcelable popupLocationInfoParcelable, Parcel parcel, int i) {
        int zzaV = zzc.zzaV(parcel);
        zzc.zza(parcel, 1, popupLocationInfoParcelable.zzEM(), false);
        zzc.zza(parcel, 2, popupLocationInfoParcelable.getWindowToken(), false);
        zzc.zzc(parcel, CardNetwork.OTHER, popupLocationInfoParcelable.getVersionCode());
        zzc.zzJ(parcel, zzaV);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzfE(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zziA(i);
    }

    public PopupLocationInfoParcelable zzfE(Parcel parcel) {
        IBinder iBinder = null;
        int zzaU = zzb.zzaU(parcel);
        int i = 0;
        Bundle bundle = null;
        while (parcel.dataPosition() < zzaU) {
            int zzaT = zzb.zzaT(parcel);
            switch (zzb.zzcW(zzaT)) {
                case MessageApi.FILTER_PREFIX /*1*/:
                    bundle = zzb.zzs(parcel, zzaT);
                    break;
                case ChannelListener.CLOSE_REASON_REMOTE_CLOSE /*2*/:
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
            return new PopupLocationInfoParcelable(i, bundle, iBinder);
        }
        throw new zza("Overread allowed size end=" + zzaU, parcel);
    }

    public PopupLocationInfoParcelable[] zziA(int i) {
        return new PopupLocationInfoParcelable[i];
    }
}
