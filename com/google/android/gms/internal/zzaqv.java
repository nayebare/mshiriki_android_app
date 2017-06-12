package com.google.android.gms.internal;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.common.internal.safeparcel.zzb.zza;
import com.google.android.gms.common.internal.safeparcel.zzc;
import com.google.android.gms.wallet.fragment.WalletFragmentStyle.Dimension;
import com.google.android.gms.wearable.ChannelApi.ChannelListener;
import com.google.android.gms.wearable.MessageApi;

public class zzaqv implements Creator<zzaqu> {
    static void zza(zzaqu com_google_android_gms_internal_zzaqu, Parcel parcel, int i) {
        int zzaV = zzc.zzaV(parcel);
        zzc.zzc(parcel, 1, com_google_android_gms_internal_zzaqu.version);
        zzc.zzc(parcel, 2, com_google_android_gms_internal_zzaqu.zzGT());
        zzc.zza(parcel, 3, com_google_android_gms_internal_zzaqu.getAccountName(), false);
        zzc.zza(parcel, 4, com_google_android_gms_internal_zzaqu.zzGU(), i, false);
        zzc.zzJ(parcel, zzaV);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzgu(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzjK(i);
    }

    public zzaqu zzgu(Parcel parcel) {
        Account[] accountArr = null;
        int i = 0;
        int zzaU = zzb.zzaU(parcel);
        String str = null;
        int i2 = 0;
        while (parcel.dataPosition() < zzaU) {
            int zzaT = zzb.zzaT(parcel);
            switch (zzb.zzcW(zzaT)) {
                case MessageApi.FILTER_PREFIX /*1*/:
                    i2 = zzb.zzg(parcel, zzaT);
                    break;
                case ChannelListener.CLOSE_REASON_REMOTE_CLOSE /*2*/:
                    i = zzb.zzg(parcel, zzaT);
                    break;
                case ChannelListener.CLOSE_REASON_LOCAL_CLOSE /*3*/:
                    str = zzb.zzq(parcel, zzaT);
                    break;
                case Dimension.UNIT_IN /*4*/:
                    accountArr = (Account[]) zzb.zzb(parcel, zzaT, Account.CREATOR);
                    break;
                default:
                    zzb.zzb(parcel, zzaT);
                    break;
            }
        }
        if (parcel.dataPosition() == zzaU) {
            return new zzaqu(i2, i, str, accountArr);
        }
        throw new zza("Overread allowed size end=" + zzaU, parcel);
    }

    public zzaqu[] zzjK(int i) {
        return new zzaqu[i];
    }
}
