package com.google.android.gms.drive.query;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zzb.zza;
import com.google.android.gms.common.internal.safeparcel.zzc;
import com.google.android.gms.drive.query.internal.zzf;
import com.google.android.gms.wallet.WalletConstants.CardNetwork;
import com.google.android.gms.wearable.ChannelApi.ChannelListener;
import com.google.android.gms.wearable.MessageApi;
import java.util.List;

public class zzb implements Creator<SortOrder> {
    static void zza(SortOrder sortOrder, Parcel parcel, int i) {
        int zzaV = zzc.zzaV(parcel);
        zzc.zzc(parcel, 1, sortOrder.zzaOJ, false);
        zzc.zza(parcel, 2, sortOrder.zzaOK);
        zzc.zzc(parcel, CardNetwork.OTHER, sortOrder.mVersionCode);
        zzc.zzJ(parcel, zzaV);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzdk(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzfG(i);
    }

    public SortOrder zzdk(Parcel parcel) {
        boolean z = false;
        int zzaU = com.google.android.gms.common.internal.safeparcel.zzb.zzaU(parcel);
        List list = null;
        int i = 0;
        while (parcel.dataPosition() < zzaU) {
            int zzaT = com.google.android.gms.common.internal.safeparcel.zzb.zzaT(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.zzb.zzcW(zzaT)) {
                case MessageApi.FILTER_PREFIX /*1*/:
                    list = com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, zzaT, zzf.CREATOR);
                    break;
                case ChannelListener.CLOSE_REASON_REMOTE_CLOSE /*2*/:
                    z = com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, zzaT);
                    break;
                case CardNetwork.OTHER /*1000*/:
                    i = com.google.android.gms.common.internal.safeparcel.zzb.zzg(parcel, zzaT);
                    break;
                default:
                    com.google.android.gms.common.internal.safeparcel.zzb.zzb(parcel, zzaT);
                    break;
            }
        }
        if (parcel.dataPosition() == zzaU) {
            return new SortOrder(i, list, z);
        }
        throw new zza("Overread allowed size end=" + zzaU, parcel);
    }

    public SortOrder[] zzfG(int i) {
        return new SortOrder[i];
    }
}
