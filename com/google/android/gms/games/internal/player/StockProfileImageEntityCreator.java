package com.google.android.gms.games.internal.player;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.common.internal.safeparcel.zzb.zza;
import com.google.android.gms.common.internal.safeparcel.zzc;
import com.google.android.gms.wallet.WalletConstants.CardNetwork;
import com.google.android.gms.wearable.ChannelApi.ChannelListener;
import com.google.android.gms.wearable.MessageApi;

public class StockProfileImageEntityCreator implements Creator<StockProfileImageEntity> {
    static void zza(StockProfileImageEntity stockProfileImageEntity, Parcel parcel, int i) {
        int zzaV = zzc.zzaV(parcel);
        zzc.zza(parcel, 1, stockProfileImageEntity.getImageUrl(), false);
        zzc.zza(parcel, 2, stockProfileImageEntity.zzDA(), i, false);
        zzc.zzc(parcel, CardNetwork.OTHER, stockProfileImageEntity.getVersionCode());
        zzc.zzJ(parcel, zzaV);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzfL(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zziP(i);
    }

    public StockProfileImageEntity zzfL(Parcel parcel) {
        Uri uri = null;
        int zzaU = zzb.zzaU(parcel);
        int i = 0;
        String str = null;
        while (parcel.dataPosition() < zzaU) {
            int zzaT = zzb.zzaT(parcel);
            switch (zzb.zzcW(zzaT)) {
                case MessageApi.FILTER_PREFIX /*1*/:
                    str = zzb.zzq(parcel, zzaT);
                    break;
                case ChannelListener.CLOSE_REASON_REMOTE_CLOSE /*2*/:
                    uri = (Uri) zzb.zza(parcel, zzaT, Uri.CREATOR);
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
            return new StockProfileImageEntity(i, str, uri);
        }
        throw new zza("Overread allowed size end=" + zzaU, parcel);
    }

    public StockProfileImageEntity[] zziP(int i) {
        return new StockProfileImageEntity[i];
    }
}
