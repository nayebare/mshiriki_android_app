package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.common.internal.safeparcel.zzb.zza;
import com.google.android.gms.common.internal.safeparcel.zzc;
import com.google.android.gms.games.request.Requests;
import com.google.android.gms.wallet.WalletConstants.CardNetwork;
import com.google.android.gms.wallet.fragment.WalletFragmentStyle.BuyButtonText;
import com.google.android.gms.wallet.fragment.WalletFragmentStyle.Dimension;
import com.google.android.gms.wearable.ChannelApi.ChannelListener;
import com.google.android.gms.wearable.MessageApi;
import org.apache.http.protocol.HTTP;

public class zzasa implements Creator<zzarz> {
    static void zza(zzarz com_google_android_gms_internal_zzarz, Parcel parcel, int i) {
        int zzaV = zzc.zzaV(parcel);
        zzc.zza(parcel, 1, com_google_android_gms_internal_zzarz.getRequestId(), false);
        zzc.zza(parcel, 2, com_google_android_gms_internal_zzarz.getExpirationTime());
        zzc.zza(parcel, 3, com_google_android_gms_internal_zzarz.zzHG());
        zzc.zza(parcel, 4, com_google_android_gms_internal_zzarz.getLatitude());
        zzc.zza(parcel, 5, com_google_android_gms_internal_zzarz.getLongitude());
        zzc.zza(parcel, 6, com_google_android_gms_internal_zzarz.getRadius());
        zzc.zzc(parcel, 7, com_google_android_gms_internal_zzarz.zzHH());
        zzc.zzc(parcel, CardNetwork.OTHER, com_google_android_gms_internal_zzarz.getVersionCode());
        zzc.zzc(parcel, 8, com_google_android_gms_internal_zzarz.zzHI());
        zzc.zzc(parcel, 9, com_google_android_gms_internal_zzarz.zzHJ());
        zzc.zzJ(parcel, zzaV);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzgT(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzku(i);
    }

    public zzarz zzgT(Parcel parcel) {
        int zzaU = zzb.zzaU(parcel);
        int i = 0;
        String str = null;
        int i2 = 0;
        short s = (short) 0;
        double d = 0.0d;
        double d2 = 0.0d;
        float f = 0.0f;
        long j = 0;
        int i3 = 0;
        int i4 = -1;
        while (parcel.dataPosition() < zzaU) {
            int zzaT = zzb.zzaT(parcel);
            switch (zzb.zzcW(zzaT)) {
                case MessageApi.FILTER_PREFIX /*1*/:
                    str = zzb.zzq(parcel, zzaT);
                    break;
                case ChannelListener.CLOSE_REASON_REMOTE_CLOSE /*2*/:
                    j = zzb.zzi(parcel, zzaT);
                    break;
                case ChannelListener.CLOSE_REASON_LOCAL_CLOSE /*3*/:
                    s = zzb.zzf(parcel, zzaT);
                    break;
                case Dimension.UNIT_IN /*4*/:
                    d = zzb.zzn(parcel, zzaT);
                    break;
                case Dimension.UNIT_MM /*5*/:
                    d2 = zzb.zzn(parcel, zzaT);
                    break;
                case BuyButtonText.LOGO_ONLY /*6*/:
                    f = zzb.zzl(parcel, zzaT);
                    break;
                case BuyButtonText.DONATE_WITH /*7*/:
                    i2 = zzb.zzg(parcel, zzaT);
                    break;
                case Requests.MAX_REQUEST_RECIPIENTS /*8*/:
                    i3 = zzb.zzg(parcel, zzaT);
                    break;
                case HTTP.HT /*9*/:
                    i4 = zzb.zzg(parcel, zzaT);
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
            return new zzarz(i, str, i2, s, d, d2, f, j, i3, i4);
        }
        throw new zza("Overread allowed size end=" + zzaU, parcel);
    }

    public zzarz[] zzku(int i) {
        return new zzarz[i];
    }
}
