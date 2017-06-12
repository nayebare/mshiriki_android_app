package com.google.android.gms.internal;

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

public class zzavq implements Creator<zzavp> {
    static void zza(zzavp com_google_android_gms_internal_zzavp, Parcel parcel, int i) {
        int zzaV = zzc.zzaV(parcel);
        zzc.zza(parcel, 1, com_google_android_gms_internal_zzavp.zzbyg, i, false);
        zzc.zza(parcel, 2, com_google_android_gms_internal_zzavp.zzD, false);
        zzc.zza(parcel, 3, com_google_android_gms_internal_zzavp.zzNg(), false);
        zzc.zza(parcel, 4, com_google_android_gms_internal_zzavp.zzbyi, i, false);
        zzc.zza(parcel, 5, com_google_android_gms_internal_zzavp.zzbyj, false);
        zzc.zza(parcel, 6, com_google_android_gms_internal_zzavp.zzNh(), false);
        zzc.zzc(parcel, CardNetwork.OTHER, com_google_android_gms_internal_zzavp.mVersionCode);
        zzc.zzJ(parcel, zzaV);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzid(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzlS(i);
    }

    public zzavp zzid(Parcel parcel) {
        String str = null;
        int zzaU = zzb.zzaU(parcel);
        int i = 0;
        String[] strArr = null;
        zzavt[] com_google_android_gms_internal_zzavtArr = null;
        String str2 = null;
        String str3 = null;
        zzavt com_google_android_gms_internal_zzavt = null;
        while (parcel.dataPosition() < zzaU) {
            int zzaT = zzb.zzaT(parcel);
            switch (zzb.zzcW(zzaT)) {
                case MessageApi.FILTER_PREFIX /*1*/:
                    com_google_android_gms_internal_zzavt = (zzavt) zzb.zza(parcel, zzaT, zzavt.CREATOR);
                    break;
                case ChannelListener.CLOSE_REASON_REMOTE_CLOSE /*2*/:
                    str3 = zzb.zzq(parcel, zzaT);
                    break;
                case ChannelListener.CLOSE_REASON_LOCAL_CLOSE /*3*/:
                    str2 = zzb.zzq(parcel, zzaT);
                    break;
                case Dimension.UNIT_IN /*4*/:
                    com_google_android_gms_internal_zzavtArr = (zzavt[]) zzb.zzb(parcel, zzaT, zzavt.CREATOR);
                    break;
                case Dimension.UNIT_MM /*5*/:
                    strArr = zzb.zzC(parcel, zzaT);
                    break;
                case BuyButtonText.LOGO_ONLY /*6*/:
                    str = zzb.zzq(parcel, zzaT);
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
            return new zzavp(i, com_google_android_gms_internal_zzavt, str3, str2, com_google_android_gms_internal_zzavtArr, strArr, str);
        }
        throw new zza("Overread allowed size end=" + zzaU, parcel);
    }

    public zzavp[] zzlS(int i) {
        return new zzavp[i];
    }
}
