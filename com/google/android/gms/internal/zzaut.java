package com.google.android.gms.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.ConnectionResult;
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

public class zzaut implements Creator<zzaus> {
    static void zza(zzaus com_google_android_gms_internal_zzaus, Parcel parcel, int i) {
        int zzaV = zzc.zzaV(parcel);
        zzc.zza(parcel, 1, com_google_android_gms_internal_zzaus.zzMM(), i, false);
        zzc.zza(parcel, 2, com_google_android_gms_internal_zzaus.getName(), false);
        zzc.zza(parcel, 3, com_google_android_gms_internal_zzaus.getDescription(), false);
        zzc.zza(parcel, 4, com_google_android_gms_internal_zzaus.zzMQ(), false);
        zzc.zza(parcel, 5, com_google_android_gms_internal_zzaus.zzMR(), false);
        zzc.zza(parcel, 6, com_google_android_gms_internal_zzaus.getCallbackBinder(), false);
        zzc.zza(parcel, 7, com_google_android_gms_internal_zzaus.zzMK());
        zzc.zzc(parcel, CardNetwork.OTHER, com_google_android_gms_internal_zzaus.versionCode);
        zzc.zza(parcel, 8, com_google_android_gms_internal_zzaus.zzMN());
        zzc.zza(parcel, 9, com_google_android_gms_internal_zzaus.getToken(), false);
        zzc.zza(parcel, 10, com_google_android_gms_internal_zzaus.zzMO());
        zzc.zza(parcel, 11, com_google_android_gms_internal_zzaus.zzMP());
        zzc.zzJ(parcel, zzaV);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzhP(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzlv(i);
    }

    public zzaus zzhP(Parcel parcel) {
        int zzaU = zzb.zzaU(parcel);
        int i = 0;
        zzauj com_google_android_gms_internal_zzauj = null;
        String str = null;
        String str2 = null;
        byte b = (byte) 0;
        long j = 0;
        String str3 = null;
        byte b2 = (byte) 0;
        byte b3 = (byte) 0;
        IBinder iBinder = null;
        IBinder iBinder2 = null;
        IBinder iBinder3 = null;
        while (parcel.dataPosition() < zzaU) {
            int zzaT = zzb.zzaT(parcel);
            switch (zzb.zzcW(zzaT)) {
                case MessageApi.FILTER_PREFIX /*1*/:
                    com_google_android_gms_internal_zzauj = (zzauj) zzb.zza(parcel, zzaT, zzauj.CREATOR);
                    break;
                case ChannelListener.CLOSE_REASON_REMOTE_CLOSE /*2*/:
                    str = zzb.zzq(parcel, zzaT);
                    break;
                case ChannelListener.CLOSE_REASON_LOCAL_CLOSE /*3*/:
                    str2 = zzb.zzq(parcel, zzaT);
                    break;
                case Dimension.UNIT_IN /*4*/:
                    iBinder = zzb.zzr(parcel, zzaT);
                    break;
                case Dimension.UNIT_MM /*5*/:
                    iBinder2 = zzb.zzr(parcel, zzaT);
                    break;
                case BuyButtonText.LOGO_ONLY /*6*/:
                    iBinder3 = zzb.zzr(parcel, zzaT);
                    break;
                case BuyButtonText.DONATE_WITH /*7*/:
                    b = zzb.zze(parcel, zzaT);
                    break;
                case Requests.MAX_REQUEST_RECIPIENTS /*8*/:
                    j = zzb.zzi(parcel, zzaT);
                    break;
                case HTTP.HT /*9*/:
                    str3 = zzb.zzq(parcel, zzaT);
                    break;
                case HTTP.LF /*10*/:
                    b2 = zzb.zze(parcel, zzaT);
                    break;
                case ConnectionResult.LICENSE_CHECK_FAILED /*11*/:
                    b3 = zzb.zze(parcel, zzaT);
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
            return new zzaus(i, com_google_android_gms_internal_zzauj, str, str2, b, j, str3, b2, b3, iBinder, iBinder2, iBinder3);
        }
        throw new zza("Overread allowed size end=" + zzaU, parcel);
    }

    public zzaus[] zzlv(int i) {
        return new zzaus[i];
    }
}
