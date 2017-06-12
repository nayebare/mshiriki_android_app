package com.google.android.gms.auth;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.common.internal.safeparcel.zzc;
import com.google.android.gms.wallet.fragment.WalletFragmentStyle.BuyButtonText;
import com.google.android.gms.wallet.fragment.WalletFragmentStyle.Dimension;
import com.google.android.gms.wearable.ChannelApi.ChannelListener;
import com.google.android.gms.wearable.MessageApi;

public class zza implements Creator<AccountChangeEvent> {
    static void zza(AccountChangeEvent accountChangeEvent, Parcel parcel, int i) {
        int zzaV = zzc.zzaV(parcel);
        zzc.zzc(parcel, 1, accountChangeEvent.mVersion);
        zzc.zza(parcel, 2, accountChangeEvent.zzahs);
        zzc.zza(parcel, 3, accountChangeEvent.zzaht, false);
        zzc.zzc(parcel, 4, accountChangeEvent.zzahu);
        zzc.zzc(parcel, 5, accountChangeEvent.zzahv);
        zzc.zza(parcel, 6, accountChangeEvent.zzahw, false);
        zzc.zzJ(parcel, zzaV);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzF(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzaT(i);
    }

    public AccountChangeEvent zzF(Parcel parcel) {
        String str = null;
        int i = 0;
        int zzaU = zzb.zzaU(parcel);
        long j = 0;
        int i2 = 0;
        String str2 = null;
        int i3 = 0;
        while (parcel.dataPosition() < zzaU) {
            int zzaT = zzb.zzaT(parcel);
            switch (zzb.zzcW(zzaT)) {
                case MessageApi.FILTER_PREFIX /*1*/:
                    i3 = zzb.zzg(parcel, zzaT);
                    break;
                case ChannelListener.CLOSE_REASON_REMOTE_CLOSE /*2*/:
                    j = zzb.zzi(parcel, zzaT);
                    break;
                case ChannelListener.CLOSE_REASON_LOCAL_CLOSE /*3*/:
                    str2 = zzb.zzq(parcel, zzaT);
                    break;
                case Dimension.UNIT_IN /*4*/:
                    i2 = zzb.zzg(parcel, zzaT);
                    break;
                case Dimension.UNIT_MM /*5*/:
                    i = zzb.zzg(parcel, zzaT);
                    break;
                case BuyButtonText.LOGO_ONLY /*6*/:
                    str = zzb.zzq(parcel, zzaT);
                    break;
                default:
                    zzb.zzb(parcel, zzaT);
                    break;
            }
        }
        if (parcel.dataPosition() == zzaU) {
            return new AccountChangeEvent(i3, j, str2, i2, i, str);
        }
        throw new com.google.android.gms.common.internal.safeparcel.zzb.zza("Overread allowed size end=" + zzaU, parcel);
    }

    public AccountChangeEvent[] zzaT(int i) {
        return new AccountChangeEvent[i];
    }
}
