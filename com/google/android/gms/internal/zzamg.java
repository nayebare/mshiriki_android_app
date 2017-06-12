package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.common.internal.safeparcel.zzb.zza;
import com.google.android.gms.common.internal.safeparcel.zzc;
import com.google.android.gms.games.request.Requests;
import com.google.android.gms.wallet.fragment.WalletFragmentStyle.BuyButtonText;
import com.google.android.gms.wallet.fragment.WalletFragmentStyle.Dimension;
import com.google.android.gms.wearable.ChannelApi.ChannelListener;
import com.google.android.gms.wearable.MessageApi;

public class zzamg implements Creator<zzamf> {
    static void zza(zzamf com_google_android_gms_internal_zzamf, Parcel parcel, int i) {
        int zzaV = zzc.zzaV(parcel);
        zzc.zzc(parcel, 1, com_google_android_gms_internal_zzamf.mVersionCode);
        zzc.zza(parcel, 2, com_google_android_gms_internal_zzamf.zzaPo);
        zzc.zza(parcel, 3, com_google_android_gms_internal_zzamf.zzawq);
        zzc.zza(parcel, 4, com_google_android_gms_internal_zzamf.zzVW, false);
        zzc.zza(parcel, 5, com_google_android_gms_internal_zzamf.zzach, false);
        zzc.zza(parcel, 6, com_google_android_gms_internal_zzamf.zzaiX, false);
        zzc.zza(parcel, 7, com_google_android_gms_internal_zzamf.zzaPp, false);
        zzc.zza(parcel, 8, com_google_android_gms_internal_zzamf.zzaPq, false);
        zzc.zzJ(parcel, zzaV);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzdA(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzfX(i);
    }

    public zzamf zzdA(Parcel parcel) {
        boolean z = false;
        String str = null;
        int zzaU = zzb.zzaU(parcel);
        String str2 = null;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        boolean z2 = false;
        int i = 0;
        while (parcel.dataPosition() < zzaU) {
            int zzaT = zzb.zzaT(parcel);
            switch (zzb.zzcW(zzaT)) {
                case MessageApi.FILTER_PREFIX /*1*/:
                    i = zzb.zzg(parcel, zzaT);
                    break;
                case ChannelListener.CLOSE_REASON_REMOTE_CLOSE /*2*/:
                    z2 = zzb.zzc(parcel, zzaT);
                    break;
                case ChannelListener.CLOSE_REASON_LOCAL_CLOSE /*3*/:
                    z = zzb.zzc(parcel, zzaT);
                    break;
                case Dimension.UNIT_IN /*4*/:
                    str5 = zzb.zzq(parcel, zzaT);
                    break;
                case Dimension.UNIT_MM /*5*/:
                    str4 = zzb.zzq(parcel, zzaT);
                    break;
                case BuyButtonText.LOGO_ONLY /*6*/:
                    str3 = zzb.zzq(parcel, zzaT);
                    break;
                case BuyButtonText.DONATE_WITH /*7*/:
                    str2 = zzb.zzq(parcel, zzaT);
                    break;
                case Requests.MAX_REQUEST_RECIPIENTS /*8*/:
                    str = zzb.zzq(parcel, zzaT);
                    break;
                default:
                    zzb.zzb(parcel, zzaT);
                    break;
            }
        }
        if (parcel.dataPosition() == zzaU) {
            return new zzamf(i, z2, z, str5, str4, str3, str2, str);
        }
        throw new zza("Overread allowed size end=" + zzaU, parcel);
    }

    public zzamf[] zzfX(int i) {
        return new zzamf[i];
    }
}
