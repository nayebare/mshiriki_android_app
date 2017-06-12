package com.google.android.gms.drive;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.common.internal.safeparcel.zzb.zza;
import com.google.android.gms.common.internal.safeparcel.zzc;
import com.google.android.gms.wallet.fragment.WalletFragmentStyle.BuyButtonText;
import com.google.android.gms.wallet.fragment.WalletFragmentStyle.Dimension;
import com.google.android.gms.wearable.ChannelApi.ChannelListener;
import com.google.android.gms.wearable.MessageApi;

public class zzq implements Creator<UserMetadata> {
    static void zza(UserMetadata userMetadata, Parcel parcel, int i) {
        int zzaV = zzc.zzaV(parcel);
        zzc.zzc(parcel, 1, userMetadata.mVersionCode);
        zzc.zza(parcel, 2, userMetadata.zzaKb, false);
        zzc.zza(parcel, 3, userMetadata.zzaiX, false);
        zzc.zza(parcel, 4, userMetadata.zzaKc, false);
        zzc.zza(parcel, 5, userMetadata.zzaKd);
        zzc.zza(parcel, 6, userMetadata.zzaKe, false);
        zzc.zzJ(parcel, zzaV);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzbO(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzef(i);
    }

    public UserMetadata zzbO(Parcel parcel) {
        boolean z = false;
        String str = null;
        int zzaU = zzb.zzaU(parcel);
        String str2 = null;
        String str3 = null;
        String str4 = null;
        int i = 0;
        while (parcel.dataPosition() < zzaU) {
            int zzaT = zzb.zzaT(parcel);
            switch (zzb.zzcW(zzaT)) {
                case MessageApi.FILTER_PREFIX /*1*/:
                    i = zzb.zzg(parcel, zzaT);
                    break;
                case ChannelListener.CLOSE_REASON_REMOTE_CLOSE /*2*/:
                    str4 = zzb.zzq(parcel, zzaT);
                    break;
                case ChannelListener.CLOSE_REASON_LOCAL_CLOSE /*3*/:
                    str3 = zzb.zzq(parcel, zzaT);
                    break;
                case Dimension.UNIT_IN /*4*/:
                    str2 = zzb.zzq(parcel, zzaT);
                    break;
                case Dimension.UNIT_MM /*5*/:
                    z = zzb.zzc(parcel, zzaT);
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
            return new UserMetadata(i, str4, str3, str2, z, str);
        }
        throw new zza("Overread allowed size end=" + zzaU, parcel);
    }

    public UserMetadata[] zzef(int i) {
        return new UserMetadata[i];
    }
}
