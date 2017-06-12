package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.common.internal.safeparcel.zzb.zza;
import com.google.android.gms.common.internal.safeparcel.zzc;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.wallet.fragment.WalletFragmentStyle.BuyButtonText;
import com.google.android.gms.wallet.fragment.WalletFragmentStyle.Dimension;
import com.google.android.gms.wearable.ChannelApi.ChannelListener;
import com.google.android.gms.wearable.MessageApi;

public class zzaga implements Creator<zzafz> {
    static void zza(zzafz com_google_android_gms_internal_zzafz, Parcel parcel, int i) {
        int zzaV = zzc.zzaV(parcel);
        zzc.zzc(parcel, 1, com_google_android_gms_internal_zzafz.mVersionCode);
        zzc.zzc(parcel, 2, com_google_android_gms_internal_zzafz.zzaKC);
        zzc.zza(parcel, 3, com_google_android_gms_internal_zzafz.zzaJj, i, false);
        zzc.zzc(parcel, 4, com_google_android_gms_internal_zzafz.zzJh);
        zzc.zza(parcel, 5, com_google_android_gms_internal_zzafz.zzaKF);
        zzc.zza(parcel, 6, com_google_android_gms_internal_zzafz.zzaKG);
        zzc.zzJ(parcel, zzaV);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzbY(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzep(i);
    }

    public zzafz zzbY(Parcel parcel) {
        long j = 0;
        int i = 0;
        int zzaU = zzb.zzaU(parcel);
        DriveId driveId = null;
        long j2 = 0;
        int i2 = 0;
        int i3 = 0;
        while (parcel.dataPosition() < zzaU) {
            int zzaT = zzb.zzaT(parcel);
            switch (zzb.zzcW(zzaT)) {
                case MessageApi.FILTER_PREFIX /*1*/:
                    i3 = zzb.zzg(parcel, zzaT);
                    break;
                case ChannelListener.CLOSE_REASON_REMOTE_CLOSE /*2*/:
                    i2 = zzb.zzg(parcel, zzaT);
                    break;
                case ChannelListener.CLOSE_REASON_LOCAL_CLOSE /*3*/:
                    driveId = (DriveId) zzb.zza(parcel, zzaT, DriveId.CREATOR);
                    break;
                case Dimension.UNIT_IN /*4*/:
                    i = zzb.zzg(parcel, zzaT);
                    break;
                case Dimension.UNIT_MM /*5*/:
                    j2 = zzb.zzi(parcel, zzaT);
                    break;
                case BuyButtonText.LOGO_ONLY /*6*/:
                    j = zzb.zzi(parcel, zzaT);
                    break;
                default:
                    zzb.zzb(parcel, zzaT);
                    break;
            }
        }
        if (parcel.dataPosition() == zzaU) {
            return new zzafz(i3, i2, driveId, i, j2, j);
        }
        throw new zza("Overread allowed size end=" + zzaU, parcel);
    }

    public zzafz[] zzep(int i) {
        return new zzafz[i];
    }
}
