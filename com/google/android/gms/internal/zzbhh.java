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

public class zzbhh implements Creator<zzbhg> {
    static void zza(zzbhg com_google_android_gms_internal_zzbhg, Parcel parcel, int i) {
        int zzaV = zzc.zzaV(parcel);
        zzc.zzc(parcel, 1, com_google_android_gms_internal_zzbhg.versionCode);
        zzc.zzc(parcel, 2, com_google_android_gms_internal_zzbhg.left);
        zzc.zzc(parcel, 3, com_google_android_gms_internal_zzbhg.top);
        zzc.zzc(parcel, 4, com_google_android_gms_internal_zzbhg.width);
        zzc.zzc(parcel, 5, com_google_android_gms_internal_zzbhg.height);
        zzc.zza(parcel, 6, com_google_android_gms_internal_zzbhg.zzbNA);
        zzc.zzJ(parcel, zzaV);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzjl(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zznC(i);
    }

    public zzbhg zzjl(Parcel parcel) {
        int i = 0;
        int zzaU = zzb.zzaU(parcel);
        float f = 0.0f;
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
                    i = zzb.zzg(parcel, zzaT);
                    break;
                case BuyButtonText.LOGO_ONLY /*6*/:
                    f = zzb.zzl(parcel, zzaT);
                    break;
                default:
                    zzb.zzb(parcel, zzaT);
                    break;
            }
        }
        if (parcel.dataPosition() == zzaU) {
            return new zzbhg(i5, i4, i3, i2, i, f);
        }
        throw new zza("Overread allowed size end=" + zzaU, parcel);
    }

    public zzbhg[] zznC(int i) {
        return new zzbhg[i];
    }
}
