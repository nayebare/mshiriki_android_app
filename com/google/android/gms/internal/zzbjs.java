package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.common.internal.safeparcel.zzb.zza;
import com.google.android.gms.common.internal.safeparcel.zzc;
import com.google.android.gms.wallet.fragment.WalletFragmentStyle.BuyButtonText;
import com.google.android.gms.wallet.fragment.WalletFragmentStyle.Dimension;
import com.google.android.gms.wearable.ChannelApi.ChannelListener;
import com.google.android.gms.wearable.MessageApi;

public class zzbjs implements Creator<zzbjr> {
    static void zza(zzbjr com_google_android_gms_internal_zzbjr, Parcel parcel, int i) {
        int zzaV = zzc.zzaV(parcel);
        zzc.zzc(parcel, 1, com_google_android_gms_internal_zzbjr.mVersionCode);
        zzc.zza(parcel, 2, com_google_android_gms_internal_zzbjr.zzUw(), false);
        zzc.zza(parcel, 3, com_google_android_gms_internal_zzbjr.getDisplayName(), false);
        zzc.zza(parcel, 4, com_google_android_gms_internal_zzbjr.zzUb(), false);
        zzc.zza(parcel, 5, com_google_android_gms_internal_zzbjr.getProviderId(), false);
        zzc.zza(parcel, 6, com_google_android_gms_internal_zzbjr.getRawUserInfo(), false);
        zzc.zzJ(parcel, zzaV);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzla(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzpC(i);
    }

    public zzbjr zzla(Parcel parcel) {
        String str = null;
        int zzaU = zzb.zzaU(parcel);
        int i = 0;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        while (parcel.dataPosition() < zzaU) {
            int zzaT = zzb.zzaT(parcel);
            switch (zzb.zzcW(zzaT)) {
                case MessageApi.FILTER_PREFIX /*1*/:
                    i = zzb.zzg(parcel, zzaT);
                    break;
                case ChannelListener.CLOSE_REASON_REMOTE_CLOSE /*2*/:
                    str5 = zzb.zzq(parcel, zzaT);
                    break;
                case ChannelListener.CLOSE_REASON_LOCAL_CLOSE /*3*/:
                    str4 = zzb.zzq(parcel, zzaT);
                    break;
                case Dimension.UNIT_IN /*4*/:
                    str3 = zzb.zzq(parcel, zzaT);
                    break;
                case Dimension.UNIT_MM /*5*/:
                    str2 = zzb.zzq(parcel, zzaT);
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
            return new zzbjr(i, str5, str4, str3, str2, str);
        }
        throw new zza("Overread allowed size end=" + zzaU, parcel);
    }

    public zzbjr[] zzpC(int i) {
        return new zzbjr[i];
    }
}
