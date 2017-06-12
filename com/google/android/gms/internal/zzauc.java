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

public class zzauc implements Creator<zzaub> {
    static void zza(zzaub com_google_android_gms_internal_zzaub, Parcel parcel, int i) {
        int zzaV = zzc.zzaV(parcel);
        zzc.zzc(parcel, 1, com_google_android_gms_internal_zzaub.versionCode);
        zzc.zza(parcel, 2, com_google_android_gms_internal_zzaub.name, false);
        zzc.zza(parcel, 3, com_google_android_gms_internal_zzaub.zzbuZ);
        zzc.zza(parcel, 4, com_google_android_gms_internal_zzaub.zzbva, false);
        zzc.zza(parcel, 5, com_google_android_gms_internal_zzaub.zzbvb, false);
        zzc.zza(parcel, 6, com_google_android_gms_internal_zzaub.zzaFy, false);
        zzc.zza(parcel, 7, com_google_android_gms_internal_zzaub.zzbqQ, false);
        zzc.zza(parcel, 8, com_google_android_gms_internal_zzaub.zzbvc, false);
        zzc.zzJ(parcel, zzaV);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzhN(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzlt(i);
    }

    public zzaub zzhN(Parcel parcel) {
        Double d = null;
        int zzaU = zzb.zzaU(parcel);
        int i = 0;
        long j = 0;
        String str = null;
        String str2 = null;
        Float f = null;
        Long l = null;
        String str3 = null;
        while (parcel.dataPosition() < zzaU) {
            int zzaT = zzb.zzaT(parcel);
            switch (zzb.zzcW(zzaT)) {
                case MessageApi.FILTER_PREFIX /*1*/:
                    i = zzb.zzg(parcel, zzaT);
                    break;
                case ChannelListener.CLOSE_REASON_REMOTE_CLOSE /*2*/:
                    str3 = zzb.zzq(parcel, zzaT);
                    break;
                case ChannelListener.CLOSE_REASON_LOCAL_CLOSE /*3*/:
                    j = zzb.zzi(parcel, zzaT);
                    break;
                case Dimension.UNIT_IN /*4*/:
                    l = zzb.zzj(parcel, zzaT);
                    break;
                case Dimension.UNIT_MM /*5*/:
                    f = zzb.zzm(parcel, zzaT);
                    break;
                case BuyButtonText.LOGO_ONLY /*6*/:
                    str2 = zzb.zzq(parcel, zzaT);
                    break;
                case BuyButtonText.DONATE_WITH /*7*/:
                    str = zzb.zzq(parcel, zzaT);
                    break;
                case Requests.MAX_REQUEST_RECIPIENTS /*8*/:
                    d = zzb.zzo(parcel, zzaT);
                    break;
                default:
                    zzb.zzb(parcel, zzaT);
                    break;
            }
        }
        if (parcel.dataPosition() == zzaU) {
            return new zzaub(i, str3, j, l, f, str2, str, d);
        }
        throw new zza("Overread allowed size end=" + zzaU, parcel);
    }

    public zzaub[] zzlt(int i) {
        return new zzaub[i];
    }
}
