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

public class zzafc implements Creator<zzafb> {
    static void zza(zzafb com_google_android_gms_internal_zzafb, Parcel parcel, int i) {
        int zzaV = zzc.zzaV(parcel);
        zzc.zzc(parcel, 1, com_google_android_gms_internal_zzafb.versionCode);
        zzc.zza(parcel, 2, com_google_android_gms_internal_zzafb.zzaIv, false);
        zzc.zza(parcel, 3, com_google_android_gms_internal_zzafb.packageName, false);
        zzc.zzc(parcel, 4, com_google_android_gms_internal_zzafb.uid);
        zzc.zza(parcel, 5, com_google_android_gms_internal_zzafb.moduleId, false);
        zzc.zzc(parcel, 6, com_google_android_gms_internal_zzafb.zzaIw);
        zzc.zzc(parcel, 7, com_google_android_gms_internal_zzafb.zzaIx);
        zzc.zza(parcel, 8, com_google_android_gms_internal_zzafb.zzaIy, false);
        zzc.zza(parcel, 9, com_google_android_gms_internal_zzafb.zzaIz, false);
        zzc.zzc(parcel, 10, com_google_android_gms_internal_zzafb.zzaIA);
        zzc.zzJ(parcel, zzaV);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzbx(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzdI(i);
    }

    public zzafb zzbx(Parcel parcel) {
        String str = null;
        int i = 0;
        int zzaU = zzb.zzaU(parcel);
        String str2 = null;
        int i2 = 0;
        int i3 = 0;
        String str3 = null;
        int i4 = 0;
        String str4 = null;
        String str5 = null;
        int i5 = 0;
        while (parcel.dataPosition() < zzaU) {
            int zzaT = zzb.zzaT(parcel);
            switch (zzb.zzcW(zzaT)) {
                case MessageApi.FILTER_PREFIX /*1*/:
                    i5 = zzb.zzg(parcel, zzaT);
                    break;
                case ChannelListener.CLOSE_REASON_REMOTE_CLOSE /*2*/:
                    str5 = zzb.zzq(parcel, zzaT);
                    break;
                case ChannelListener.CLOSE_REASON_LOCAL_CLOSE /*3*/:
                    str4 = zzb.zzq(parcel, zzaT);
                    break;
                case Dimension.UNIT_IN /*4*/:
                    i4 = zzb.zzg(parcel, zzaT);
                    break;
                case Dimension.UNIT_MM /*5*/:
                    str3 = zzb.zzq(parcel, zzaT);
                    break;
                case BuyButtonText.LOGO_ONLY /*6*/:
                    i3 = zzb.zzg(parcel, zzaT);
                    break;
                case BuyButtonText.DONATE_WITH /*7*/:
                    i2 = zzb.zzg(parcel, zzaT);
                    break;
                case Requests.MAX_REQUEST_RECIPIENTS /*8*/:
                    str2 = zzb.zzq(parcel, zzaT);
                    break;
                case HTTP.HT /*9*/:
                    str = zzb.zzq(parcel, zzaT);
                    break;
                case HTTP.LF /*10*/:
                    i = zzb.zzg(parcel, zzaT);
                    break;
                default:
                    zzb.zzb(parcel, zzaT);
                    break;
            }
        }
        if (parcel.dataPosition() == zzaU) {
            return new zzafb(i5, str5, str4, i4, str3, i3, i2, str2, str, i);
        }
        throw new zza("Overread allowed size end=" + zzaU, parcel);
    }

    public zzafb[] zzdI(int i) {
        return new zzafb[i];
    }
}
