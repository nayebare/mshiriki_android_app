package com.google.android.gms.internal;

import android.content.Intent;
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

public class zzaqo implements Creator<zzaqn> {
    static void zza(zzaqn com_google_android_gms_internal_zzaqn, Parcel parcel, int i) {
        int zzaV = zzc.zzaV(parcel);
        zzc.zzc(parcel, 1, com_google_android_gms_internal_zzaqn.version);
        zzc.zzc(parcel, 2, com_google_android_gms_internal_zzaqn.zzGK());
        zzc.zza(parcel, 3, com_google_android_gms_internal_zzaqn.getAccountName(), false);
        zzc.zza(parcel, 4, com_google_android_gms_internal_zzaqn.zzGL());
        zzc.zza(parcel, 5, com_google_android_gms_internal_zzaqn.zzGM(), i, false);
        zzc.zza(parcel, 6, com_google_android_gms_internal_zzaqn.zzGN(), i, false);
        zzc.zza(parcel, 7, com_google_android_gms_internal_zzaqn.zzGO(), false);
        zzc.zza(parcel, 8, com_google_android_gms_internal_zzaqn.zzGP(), i, false);
        zzc.zza(parcel, 9, com_google_android_gms_internal_zzaqn.zzGQ(), i, false);
        zzc.zza(parcel, 10, com_google_android_gms_internal_zzaqn.zzGR());
        zzc.zzJ(parcel, zzaV);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzgt(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzjI(i);
    }

    public zzaqn zzgt(Parcel parcel) {
        boolean z = false;
        zzara com_google_android_gms_internal_zzara = null;
        int zzaU = zzb.zzaU(parcel);
        zzaqe com_google_android_gms_internal_zzaqe = null;
        byte[] bArr = null;
        Intent intent = null;
        Intent intent2 = null;
        boolean z2 = false;
        String str = null;
        int i = 0;
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
                    z2 = zzb.zzc(parcel, zzaT);
                    break;
                case Dimension.UNIT_MM /*5*/:
                    intent2 = (Intent) zzb.zza(parcel, zzaT, Intent.CREATOR);
                    break;
                case BuyButtonText.LOGO_ONLY /*6*/:
                    intent = (Intent) zzb.zza(parcel, zzaT, Intent.CREATOR);
                    break;
                case BuyButtonText.DONATE_WITH /*7*/:
                    bArr = zzb.zzt(parcel, zzaT);
                    break;
                case Requests.MAX_REQUEST_RECIPIENTS /*8*/:
                    com_google_android_gms_internal_zzaqe = (zzaqe) zzb.zza(parcel, zzaT, zzaqe.CREATOR);
                    break;
                case HTTP.HT /*9*/:
                    com_google_android_gms_internal_zzara = (zzara) zzb.zza(parcel, zzaT, zzara.CREATOR);
                    break;
                case HTTP.LF /*10*/:
                    z = zzb.zzc(parcel, zzaT);
                    break;
                default:
                    zzb.zzb(parcel, zzaT);
                    break;
            }
        }
        if (parcel.dataPosition() == zzaU) {
            return new zzaqn(i2, i, str, z2, intent2, intent, bArr, com_google_android_gms_internal_zzaqe, com_google_android_gms_internal_zzara, z);
        }
        throw new zza("Overread allowed size end=" + zzaU, parcel);
    }

    public zzaqn[] zzjI(int i) {
        return new zzaqn[i];
    }
}
