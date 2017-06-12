package com.google.android.gms.common.data;

import android.database.CursorWindow;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.common.internal.safeparcel.zzb.zza;
import com.google.android.gms.common.internal.safeparcel.zzc;
import com.google.android.gms.wallet.WalletConstants.CardNetwork;
import com.google.android.gms.wallet.fragment.WalletFragmentStyle.Dimension;
import com.google.android.gms.wearable.ChannelApi.ChannelListener;
import com.google.android.gms.wearable.MessageApi;

public class zze implements Creator<DataHolder> {
    static void zza(DataHolder dataHolder, Parcel parcel, int i) {
        int zzaV = zzc.zzaV(parcel);
        zzc.zza(parcel, 1, dataHolder.zzwE(), false);
        zzc.zza(parcel, 2, dataHolder.zzwF(), i, false);
        zzc.zzc(parcel, 3, dataHolder.getStatusCode());
        zzc.zza(parcel, 4, dataHolder.zzwy(), false);
        zzc.zzc(parcel, CardNetwork.OTHER, dataHolder.mVersionCode);
        zzc.zzJ(parcel, zzaV);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzaK(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzcF(i);
    }

    public DataHolder zzaK(Parcel parcel) {
        int i = 0;
        Bundle bundle = null;
        int zzaU = zzb.zzaU(parcel);
        CursorWindow[] cursorWindowArr = null;
        String[] strArr = null;
        int i2 = 0;
        while (parcel.dataPosition() < zzaU) {
            int zzaT = zzb.zzaT(parcel);
            switch (zzb.zzcW(zzaT)) {
                case MessageApi.FILTER_PREFIX /*1*/:
                    strArr = zzb.zzC(parcel, zzaT);
                    break;
                case ChannelListener.CLOSE_REASON_REMOTE_CLOSE /*2*/:
                    cursorWindowArr = (CursorWindow[]) zzb.zzb(parcel, zzaT, CursorWindow.CREATOR);
                    break;
                case ChannelListener.CLOSE_REASON_LOCAL_CLOSE /*3*/:
                    i = zzb.zzg(parcel, zzaT);
                    break;
                case Dimension.UNIT_IN /*4*/:
                    bundle = zzb.zzs(parcel, zzaT);
                    break;
                case CardNetwork.OTHER /*1000*/:
                    i2 = zzb.zzg(parcel, zzaT);
                    break;
                default:
                    zzb.zzb(parcel, zzaT);
                    break;
            }
        }
        if (parcel.dataPosition() != zzaU) {
            throw new zza("Overread allowed size end=" + zzaU, parcel);
        }
        DataHolder dataHolder = new DataHolder(i2, strArr, cursorWindowArr, i, bundle);
        dataHolder.zzwD();
        return dataHolder;
    }

    public DataHolder[] zzcF(int i) {
        return new DataHolder[i];
    }
}
