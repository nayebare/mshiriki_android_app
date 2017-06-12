package com.google.android.gms.games.internal.player;

import android.net.Uri;
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

public class MostRecentGameInfoEntityCreator implements Creator<MostRecentGameInfoEntity> {
    static void zza(MostRecentGameInfoEntity mostRecentGameInfoEntity, Parcel parcel, int i) {
        int zzaV = zzc.zzaV(parcel);
        zzc.zza(parcel, 1, mostRecentGameInfoEntity.zzFo(), false);
        zzc.zza(parcel, 2, mostRecentGameInfoEntity.zzFp(), false);
        zzc.zza(parcel, 3, mostRecentGameInfoEntity.zzFq());
        zzc.zza(parcel, 4, mostRecentGameInfoEntity.zzFr(), i, false);
        zzc.zza(parcel, 5, mostRecentGameInfoEntity.zzFs(), i, false);
        zzc.zza(parcel, 6, mostRecentGameInfoEntity.zzFt(), i, false);
        zzc.zzc(parcel, CardNetwork.OTHER, mostRecentGameInfoEntity.getVersionCode());
        zzc.zzJ(parcel, zzaV);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzfJ(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zziM(i);
    }

    public MostRecentGameInfoEntity zzfJ(Parcel parcel) {
        Uri uri = null;
        int zzaU = zzb.zzaU(parcel);
        int i = 0;
        long j = 0;
        Uri uri2 = null;
        Uri uri3 = null;
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
                    j = zzb.zzi(parcel, zzaT);
                    break;
                case Dimension.UNIT_IN /*4*/:
                    uri3 = (Uri) zzb.zza(parcel, zzaT, Uri.CREATOR);
                    break;
                case Dimension.UNIT_MM /*5*/:
                    uri2 = (Uri) zzb.zza(parcel, zzaT, Uri.CREATOR);
                    break;
                case BuyButtonText.LOGO_ONLY /*6*/:
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
            return new MostRecentGameInfoEntity(i, str2, str, j, uri3, uri2, uri);
        }
        throw new zza("Overread allowed size end=" + zzaU, parcel);
    }

    public MostRecentGameInfoEntity[] zziM(int i) {
        return new MostRecentGameInfoEntity[i];
    }
}
