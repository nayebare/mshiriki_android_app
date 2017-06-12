package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.common.internal.safeparcel.zzb.zza;
import com.google.android.gms.common.internal.safeparcel.zzc;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.zzm;
import com.google.android.gms.wallet.fragment.WalletFragmentStyle.BuyButtonText;
import com.google.android.gms.wallet.fragment.WalletFragmentStyle.Dimension;
import com.google.android.gms.wearable.ChannelApi.ChannelListener;
import com.google.android.gms.wearable.MessageApi;

public class zzage implements Creator<zzagd> {
    static void zza(zzagd com_google_android_gms_internal_zzagd, Parcel parcel, int i) {
        int zzaV = zzc.zzaV(parcel);
        zzc.zzc(parcel, 1, com_google_android_gms_internal_zzagd.mVersionCode);
        zzc.zza(parcel, 2, com_google_android_gms_internal_zzagd.zzaJj, i, false);
        zzc.zza(parcel, 3, com_google_android_gms_internal_zzagd.zzaKJ, i, false);
        zzc.zza(parcel, 4, com_google_android_gms_internal_zzagd.zzaKK);
        zzc.zza(parcel, 5, com_google_android_gms_internal_zzagd.zzaKL, false);
        zzc.zza(parcel, 6, com_google_android_gms_internal_zzagd.zzaKM);
        zzc.zza(parcel, 7, com_google_android_gms_internal_zzagd.zzaJF, false);
        zzc.zzJ(parcel, zzaV);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzca(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzer(i);
    }

    public zzagd zzca(Parcel parcel) {
        boolean z = false;
        String str = null;
        int zzaU = zzb.zzaU(parcel);
        String str2 = null;
        boolean z2 = false;
        zzm com_google_android_gms_drive_zzm = null;
        DriveId driveId = null;
        int i = 0;
        while (parcel.dataPosition() < zzaU) {
            int zzaT = zzb.zzaT(parcel);
            switch (zzb.zzcW(zzaT)) {
                case MessageApi.FILTER_PREFIX /*1*/:
                    i = zzb.zzg(parcel, zzaT);
                    break;
                case ChannelListener.CLOSE_REASON_REMOTE_CLOSE /*2*/:
                    driveId = (DriveId) zzb.zza(parcel, zzaT, DriveId.CREATOR);
                    break;
                case ChannelListener.CLOSE_REASON_LOCAL_CLOSE /*3*/:
                    com_google_android_gms_drive_zzm = (zzm) zzb.zza(parcel, zzaT, zzm.CREATOR);
                    break;
                case Dimension.UNIT_IN /*4*/:
                    z2 = zzb.zzc(parcel, zzaT);
                    break;
                case Dimension.UNIT_MM /*5*/:
                    str2 = zzb.zzq(parcel, zzaT);
                    break;
                case BuyButtonText.LOGO_ONLY /*6*/:
                    z = zzb.zzc(parcel, zzaT);
                    break;
                case BuyButtonText.DONATE_WITH /*7*/:
                    str = zzb.zzq(parcel, zzaT);
                    break;
                default:
                    zzb.zzb(parcel, zzaT);
                    break;
            }
        }
        if (parcel.dataPosition() == zzaU) {
            return new zzagd(i, driveId, com_google_android_gms_drive_zzm, z2, str2, z, str);
        }
        throw new zza("Overread allowed size end=" + zzaU, parcel);
    }

    public zzagd[] zzer(int i) {
        return new zzagd[i];
    }
}
