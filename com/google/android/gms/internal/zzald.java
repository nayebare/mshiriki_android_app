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

public class zzald implements Creator<zzalc> {
    static void zza(zzalc com_google_android_gms_internal_zzalc, Parcel parcel, int i) {
        int zzaV = zzc.zzaV(parcel);
        zzc.zzc(parcel, 1, com_google_android_gms_internal_zzalc.mVersionCode);
        zzc.zza(parcel, 2, com_google_android_gms_internal_zzalc.zzaJj, i, false);
        zzc.zza(parcel, 3, com_google_android_gms_internal_zzalc.zzaJT, false);
        zzc.zzc(parcel, 4, com_google_android_gms_internal_zzalc.zzaNe);
        zzc.zza(parcel, 5, com_google_android_gms_internal_zzalc.zzaKM);
        zzc.zza(parcel, 6, com_google_android_gms_internal_zzalc.zzaJF, false);
        zzc.zzJ(parcel, zzaV);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzdc(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzfy(i);
    }

    public zzalc zzdc(Parcel parcel) {
        String str = null;
        boolean z = false;
        int zzaU = zzb.zzaU(parcel);
        int i = 0;
        String str2 = null;
        DriveId driveId = null;
        int i2 = 0;
        while (parcel.dataPosition() < zzaU) {
            int zzaT = zzb.zzaT(parcel);
            switch (zzb.zzcW(zzaT)) {
                case MessageApi.FILTER_PREFIX /*1*/:
                    i2 = zzb.zzg(parcel, zzaT);
                    break;
                case ChannelListener.CLOSE_REASON_REMOTE_CLOSE /*2*/:
                    driveId = (DriveId) zzb.zza(parcel, zzaT, DriveId.CREATOR);
                    break;
                case ChannelListener.CLOSE_REASON_LOCAL_CLOSE /*3*/:
                    str2 = zzb.zzq(parcel, zzaT);
                    break;
                case Dimension.UNIT_IN /*4*/:
                    i = zzb.zzg(parcel, zzaT);
                    break;
                case Dimension.UNIT_MM /*5*/:
                    z = zzb.zzc(parcel, zzaT);
                    break;
                case BuyButtonText.LOGO_ONLY /*6*/:
                    str = zzb.zzq(parcel, zzaT);
                    break;
                default:
                    zzb.zzb(parcel, zzaT);
                    break;
            }
        }
        if (parcel.dataPosition() == zzaU) {
            return new zzalc(i2, driveId, str2, i, z, str);
        }
        throw new zza("Overread allowed size end=" + zzaU, parcel);
    }

    public zzalc[] zzfy(int i) {
        return new zzalc[i];
    }
}
