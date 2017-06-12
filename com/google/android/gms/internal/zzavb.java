package com.google.android.gms.internal;

import android.os.IBinder;
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

public class zzavb implements Creator<zzava> {
    static void zza(zzava com_google_android_gms_internal_zzava, Parcel parcel, int i) {
        int zzaV = zzc.zzaV(parcel);
        zzc.zza(parcel, 1, com_google_android_gms_internal_zzava.getName(), false);
        zzc.zza(parcel, 2, com_google_android_gms_internal_zzava.getDescription(), false);
        zzc.zza(parcel, 3, com_google_android_gms_internal_zzava.zzMQ(), false);
        zzc.zza(parcel, 4, com_google_android_gms_internal_zzava.zzMR(), false);
        zzc.zza(parcel, 5, com_google_android_gms_internal_zzava.getCallbackBinder(), false);
        zzc.zza(parcel, 6, com_google_android_gms_internal_zzava.zzMK());
        zzc.zza(parcel, 7, com_google_android_gms_internal_zzava.zzMP());
        zzc.zzc(parcel, CardNetwork.OTHER, com_google_android_gms_internal_zzava.versionCode);
        zzc.zzJ(parcel, zzaV);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzhT(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzlz(i);
    }

    public zzava zzhT(Parcel parcel) {
        byte b = (byte) 0;
        IBinder iBinder = null;
        int zzaU = zzb.zzaU(parcel);
        IBinder iBinder2 = null;
        IBinder iBinder3 = null;
        byte b2 = (byte) 0;
        String str = null;
        String str2 = null;
        int i = 0;
        while (parcel.dataPosition() < zzaU) {
            int zzaT = zzb.zzaT(parcel);
            switch (zzb.zzcW(zzaT)) {
                case MessageApi.FILTER_PREFIX /*1*/:
                    str2 = zzb.zzq(parcel, zzaT);
                    break;
                case ChannelListener.CLOSE_REASON_REMOTE_CLOSE /*2*/:
                    str = zzb.zzq(parcel, zzaT);
                    break;
                case ChannelListener.CLOSE_REASON_LOCAL_CLOSE /*3*/:
                    iBinder3 = zzb.zzr(parcel, zzaT);
                    break;
                case Dimension.UNIT_IN /*4*/:
                    iBinder2 = zzb.zzr(parcel, zzaT);
                    break;
                case Dimension.UNIT_MM /*5*/:
                    iBinder = zzb.zzr(parcel, zzaT);
                    break;
                case BuyButtonText.LOGO_ONLY /*6*/:
                    b2 = zzb.zze(parcel, zzaT);
                    break;
                case BuyButtonText.DONATE_WITH /*7*/:
                    b = zzb.zze(parcel, zzaT);
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
            return new zzava(i, str2, str, b2, b, iBinder3, iBinder2, iBinder);
        }
        throw new zza("Overread allowed size end=" + zzaU, parcel);
    }

    public zzava[] zzlz(int i) {
        return new zzava[i];
    }
}
