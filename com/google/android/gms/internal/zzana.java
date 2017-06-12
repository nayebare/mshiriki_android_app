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

public class zzana implements Creator<zzamz> {
    static void zza(zzamz com_google_android_gms_internal_zzamz, Parcel parcel, int i) {
        int zzaV = zzc.zzaV(parcel);
        zzc.zzc(parcel, 1, com_google_android_gms_internal_zzamz.mVersionCode);
        zzc.zzc(parcel, 2, com_google_android_gms_internal_zzamz.mIndex);
        zzc.zzc(parcel, 3, com_google_android_gms_internal_zzamz.zzaPv);
        zzc.zzc(parcel, 4, com_google_android_gms_internal_zzamz.zzaPw);
        zzc.zza(parcel, 5, com_google_android_gms_internal_zzamz.zzaPU, false);
        zzc.zzc(parcel, 6, com_google_android_gms_internal_zzamz.zzaPV);
        zzc.zzJ(parcel, zzaV);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzdK(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzgh(i);
    }

    public zzamz zzdK(Parcel parcel) {
        int i = 0;
        int zzaU = zzb.zzaU(parcel);
        String str = null;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        while (parcel.dataPosition() < zzaU) {
            int zzaT = zzb.zzaT(parcel);
            switch (zzb.zzcW(zzaT)) {
                case MessageApi.FILTER_PREFIX /*1*/:
                    i5 = zzb.zzg(parcel, zzaT);
                    break;
                case ChannelListener.CLOSE_REASON_REMOTE_CLOSE /*2*/:
                    i4 = zzb.zzg(parcel, zzaT);
                    break;
                case ChannelListener.CLOSE_REASON_LOCAL_CLOSE /*3*/:
                    i3 = zzb.zzg(parcel, zzaT);
                    break;
                case Dimension.UNIT_IN /*4*/:
                    i2 = zzb.zzg(parcel, zzaT);
                    break;
                case Dimension.UNIT_MM /*5*/:
                    str = zzb.zzq(parcel, zzaT);
                    break;
                case BuyButtonText.LOGO_ONLY /*6*/:
                    i = zzb.zzg(parcel, zzaT);
                    break;
                default:
                    zzb.zzb(parcel, zzaT);
                    break;
            }
        }
        if (parcel.dataPosition() == zzaU) {
            return new zzamz(i5, i4, i3, i2, str, i);
        }
        throw new zza("Overread allowed size end=" + zzaU, parcel);
    }

    public zzamz[] zzgh(int i) {
        return new zzamz[i];
    }
}
