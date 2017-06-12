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
import org.apache.http.protocol.HTTP;

public class zzarb implements Creator<zzara> {
    static void zza(zzara com_google_android_gms_internal_zzara, Parcel parcel, int i) {
        int zzaV = zzc.zzaV(parcel);
        zzc.zzc(parcel, 1, com_google_android_gms_internal_zzara.version);
        zzc.zza(parcel, 2, com_google_android_gms_internal_zzara.zzGZ(), false);
        zzc.zzc(parcel, 3, com_google_android_gms_internal_zzara.getPort());
        zzc.zza(parcel, 4, com_google_android_gms_internal_zzara.getPath(), false);
        zzc.zza(parcel, 5, com_google_android_gms_internal_zzara.zzHa(), false);
        zzc.zza(parcel, 6, com_google_android_gms_internal_zzara.zzHb(), false);
        zzc.zza(parcel, 7, com_google_android_gms_internal_zzara.zzGG(), false);
        zzc.zza(parcel, 8, com_google_android_gms_internal_zzara.zzHd(), false);
        zzc.zza(parcel, 9, com_google_android_gms_internal_zzara.zzHc(), false);
        zzc.zzJ(parcel, zzaV);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzgx(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzjO(i);
    }

    public zzara zzgx(Parcel parcel) {
        int i = 0;
        String str = null;
        int zzaU = zzb.zzaU(parcel);
        String str2 = null;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        String str6 = null;
        String str7 = null;
        int i2 = 0;
        while (parcel.dataPosition() < zzaU) {
            int zzaT = zzb.zzaT(parcel);
            switch (zzb.zzcW(zzaT)) {
                case MessageApi.FILTER_PREFIX /*1*/:
                    i2 = zzb.zzg(parcel, zzaT);
                    break;
                case ChannelListener.CLOSE_REASON_REMOTE_CLOSE /*2*/:
                    str7 = zzb.zzq(parcel, zzaT);
                    break;
                case ChannelListener.CLOSE_REASON_LOCAL_CLOSE /*3*/:
                    i = zzb.zzg(parcel, zzaT);
                    break;
                case Dimension.UNIT_IN /*4*/:
                    str6 = zzb.zzq(parcel, zzaT);
                    break;
                case Dimension.UNIT_MM /*5*/:
                    str5 = zzb.zzq(parcel, zzaT);
                    break;
                case BuyButtonText.LOGO_ONLY /*6*/:
                    str4 = zzb.zzq(parcel, zzaT);
                    break;
                case BuyButtonText.DONATE_WITH /*7*/:
                    str2 = zzb.zzq(parcel, zzaT);
                    break;
                case Requests.MAX_REQUEST_RECIPIENTS /*8*/:
                    str = zzb.zzq(parcel, zzaT);
                    break;
                case HTTP.HT /*9*/:
                    str3 = zzb.zzq(parcel, zzaT);
                    break;
                default:
                    zzb.zzb(parcel, zzaT);
                    break;
            }
        }
        if (parcel.dataPosition() == zzaU) {
            return new zzara(i2, str7, i, str6, str5, str4, str3, str2, str);
        }
        throw new zza("Overread allowed size end=" + zzaU, parcel);
    }

    public zzara[] zzjO(int i) {
        return new zzara[i];
    }
}
