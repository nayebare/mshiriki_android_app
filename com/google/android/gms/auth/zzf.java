package com.google.android.gms.auth;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.common.internal.safeparcel.zzb.zza;
import com.google.android.gms.common.internal.safeparcel.zzc;
import com.google.android.gms.wallet.fragment.WalletFragmentStyle.BuyButtonText;
import com.google.android.gms.wallet.fragment.WalletFragmentStyle.Dimension;
import com.google.android.gms.wearable.ChannelApi.ChannelListener;
import com.google.android.gms.wearable.MessageApi;
import java.util.List;

public class zzf implements Creator<TokenData> {
    static void zza(TokenData tokenData, Parcel parcel, int i) {
        int zzaV = zzc.zzaV(parcel);
        zzc.zzc(parcel, 1, tokenData.mVersionCode);
        zzc.zza(parcel, 2, tokenData.getToken(), false);
        zzc.zza(parcel, 3, tokenData.zzqo(), false);
        zzc.zza(parcel, 4, tokenData.zzqp());
        zzc.zza(parcel, 5, tokenData.zzqq());
        zzc.zzb(parcel, 6, tokenData.zzqr(), false);
        zzc.zzJ(parcel, zzaV);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzI(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzaW(i);
    }

    public TokenData zzI(Parcel parcel) {
        List list = null;
        boolean z = false;
        int zzaU = zzb.zzaU(parcel);
        boolean z2 = false;
        Long l = null;
        String str = null;
        int i = 0;
        while (parcel.dataPosition() < zzaU) {
            int zzaT = zzb.zzaT(parcel);
            switch (zzb.zzcW(zzaT)) {
                case MessageApi.FILTER_PREFIX /*1*/:
                    i = zzb.zzg(parcel, zzaT);
                    break;
                case ChannelListener.CLOSE_REASON_REMOTE_CLOSE /*2*/:
                    str = zzb.zzq(parcel, zzaT);
                    break;
                case ChannelListener.CLOSE_REASON_LOCAL_CLOSE /*3*/:
                    l = zzb.zzj(parcel, zzaT);
                    break;
                case Dimension.UNIT_IN /*4*/:
                    z2 = zzb.zzc(parcel, zzaT);
                    break;
                case Dimension.UNIT_MM /*5*/:
                    z = zzb.zzc(parcel, zzaT);
                    break;
                case BuyButtonText.LOGO_ONLY /*6*/:
                    list = zzb.zzE(parcel, zzaT);
                    break;
                default:
                    zzb.zzb(parcel, zzaT);
                    break;
            }
        }
        if (parcel.dataPosition() == zzaU) {
            return new TokenData(i, str, l, z2, z, list);
        }
        throw new zza("Overread allowed size end=" + zzaU, parcel);
    }

    public TokenData[] zzaW(int i) {
        return new TokenData[i];
    }
}
