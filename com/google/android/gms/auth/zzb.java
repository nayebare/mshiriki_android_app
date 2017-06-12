package com.google.android.gms.auth;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zzb.zza;
import com.google.android.gms.common.internal.safeparcel.zzc;
import com.google.android.gms.wallet.fragment.WalletFragmentStyle.Dimension;
import com.google.android.gms.wearable.ChannelApi.ChannelListener;
import com.google.android.gms.wearable.MessageApi;

public class zzb implements Creator<AccountChangeEventsRequest> {
    static void zza(AccountChangeEventsRequest accountChangeEventsRequest, Parcel parcel, int i) {
        int zzaV = zzc.zzaV(parcel);
        zzc.zzc(parcel, 1, accountChangeEventsRequest.mVersion);
        zzc.zzc(parcel, 2, accountChangeEventsRequest.zzahv);
        zzc.zza(parcel, 3, accountChangeEventsRequest.zzaht, false);
        zzc.zza(parcel, 4, accountChangeEventsRequest.zzagg, i, false);
        zzc.zzJ(parcel, zzaV);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzG(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzaU(i);
    }

    public AccountChangeEventsRequest zzG(Parcel parcel) {
        Account account = null;
        int i = 0;
        int zzaU = com.google.android.gms.common.internal.safeparcel.zzb.zzaU(parcel);
        String str = null;
        int i2 = 0;
        while (parcel.dataPosition() < zzaU) {
            int zzaT = com.google.android.gms.common.internal.safeparcel.zzb.zzaT(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.zzb.zzcW(zzaT)) {
                case MessageApi.FILTER_PREFIX /*1*/:
                    i2 = com.google.android.gms.common.internal.safeparcel.zzb.zzg(parcel, zzaT);
                    break;
                case ChannelListener.CLOSE_REASON_REMOTE_CLOSE /*2*/:
                    i = com.google.android.gms.common.internal.safeparcel.zzb.zzg(parcel, zzaT);
                    break;
                case ChannelListener.CLOSE_REASON_LOCAL_CLOSE /*3*/:
                    str = com.google.android.gms.common.internal.safeparcel.zzb.zzq(parcel, zzaT);
                    break;
                case Dimension.UNIT_IN /*4*/:
                    account = (Account) com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, zzaT, Account.CREATOR);
                    break;
                default:
                    com.google.android.gms.common.internal.safeparcel.zzb.zzb(parcel, zzaT);
                    break;
            }
        }
        if (parcel.dataPosition() == zzaU) {
            return new AccountChangeEventsRequest(i2, i, str, account);
        }
        throw new zza("Overread allowed size end=" + zzaU, parcel);
    }

    public AccountChangeEventsRequest[] zzaU(int i) {
        return new AccountChangeEventsRequest[i];
    }
}
