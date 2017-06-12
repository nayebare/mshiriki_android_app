package com.google.android.gms.drive;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.common.internal.safeparcel.zzb.zza;
import com.google.android.gms.common.internal.safeparcel.zzc;
import com.google.android.gms.wallet.fragment.WalletFragmentStyle.BuyButtonText;
import com.google.android.gms.wallet.fragment.WalletFragmentStyle.Dimension;
import com.google.android.gms.wearable.ChannelApi.ChannelListener;
import com.google.android.gms.wearable.MessageApi;

public class zzn implements Creator<zzm> {
    static void zza(zzm com_google_android_gms_drive_zzm, Parcel parcel, int i) {
        int zzaV = zzc.zzaV(parcel);
        zzc.zzc(parcel, 1, com_google_android_gms_drive_zzm.mVersionCode);
        zzc.zza(parcel, 2, com_google_android_gms_drive_zzm.zzzS(), false);
        zzc.zzc(parcel, 3, com_google_android_gms_drive_zzm.zzzT());
        zzc.zza(parcel, 4, com_google_android_gms_drive_zzm.zzzU(), false);
        zzc.zza(parcel, 5, com_google_android_gms_drive_zzm.zzzV(), false);
        zzc.zzc(parcel, 6, com_google_android_gms_drive_zzm.getRole());
        zzc.zza(parcel, 7, com_google_android_gms_drive_zzm.zzzW());
        zzc.zzJ(parcel, zzaV);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzbM(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzed(i);
    }

    public zzm zzbM(Parcel parcel) {
        String str = null;
        boolean z = false;
        int zzaU = zzb.zzaU(parcel);
        int i = 0;
        String str2 = null;
        int i2 = 0;
        String str3 = null;
        int i3 = 0;
        while (parcel.dataPosition() < zzaU) {
            int zzaT = zzb.zzaT(parcel);
            switch (zzb.zzcW(zzaT)) {
                case MessageApi.FILTER_PREFIX /*1*/:
                    i3 = zzb.zzg(parcel, zzaT);
                    break;
                case ChannelListener.CLOSE_REASON_REMOTE_CLOSE /*2*/:
                    str3 = zzb.zzq(parcel, zzaT);
                    break;
                case ChannelListener.CLOSE_REASON_LOCAL_CLOSE /*3*/:
                    i2 = zzb.zzg(parcel, zzaT);
                    break;
                case Dimension.UNIT_IN /*4*/:
                    str2 = zzb.zzq(parcel, zzaT);
                    break;
                case Dimension.UNIT_MM /*5*/:
                    str = zzb.zzq(parcel, zzaT);
                    break;
                case BuyButtonText.LOGO_ONLY /*6*/:
                    i = zzb.zzg(parcel, zzaT);
                    break;
                case BuyButtonText.DONATE_WITH /*7*/:
                    z = zzb.zzc(parcel, zzaT);
                    break;
                default:
                    zzb.zzb(parcel, zzaT);
                    break;
            }
        }
        if (parcel.dataPosition() == zzaU) {
            return new zzm(i3, str3, i2, str2, str, i, z);
        }
        throw new zza("Overread allowed size end=" + zzaU, parcel);
    }

    public zzm[] zzed(int i) {
        return new zzm[i];
    }
}
