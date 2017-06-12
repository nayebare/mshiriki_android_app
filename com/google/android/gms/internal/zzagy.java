package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.common.internal.safeparcel.zzb.zza;
import com.google.android.gms.common.internal.safeparcel.zzc;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;
import com.google.android.gms.wallet.fragment.WalletFragmentStyle.BuyButtonText;
import com.google.android.gms.wallet.fragment.WalletFragmentStyle.Dimension;
import com.google.android.gms.wearable.ChannelApi.ChannelListener;
import com.google.android.gms.wearable.MessageApi;

public class zzagy implements Creator<zzagx> {
    static void zza(zzagx com_google_android_gms_internal_zzagx, Parcel parcel, int i) {
        int zzaV = zzc.zzaV(parcel);
        zzc.zzc(parcel, 1, com_google_android_gms_internal_zzagx.mVersionCode);
        zzc.zza(parcel, 2, com_google_android_gms_internal_zzagx.zzaLf, i, false);
        zzc.zzc(parcel, 3, com_google_android_gms_internal_zzagx.zzaJh);
        zzc.zza(parcel, 4, com_google_android_gms_internal_zzagx.zzalD, false);
        zzc.zza(parcel, 5, com_google_android_gms_internal_zzagx.zzaJS, i, false);
        zzc.zza(parcel, 6, com_google_android_gms_internal_zzagx.zzaLg, false);
        zzc.zzJ(parcel, zzaV);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzcj(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzeB(i);
    }

    public zzagx zzcj(Parcel parcel) {
        int i = 0;
        Integer num = null;
        int zzaU = zzb.zzaU(parcel);
        DriveId driveId = null;
        String str = null;
        MetadataBundle metadataBundle = null;
        int i2 = 0;
        while (parcel.dataPosition() < zzaU) {
            int zzaT = zzb.zzaT(parcel);
            switch (zzb.zzcW(zzaT)) {
                case MessageApi.FILTER_PREFIX /*1*/:
                    i2 = zzb.zzg(parcel, zzaT);
                    break;
                case ChannelListener.CLOSE_REASON_REMOTE_CLOSE /*2*/:
                    metadataBundle = (MetadataBundle) zzb.zza(parcel, zzaT, MetadataBundle.CREATOR);
                    break;
                case ChannelListener.CLOSE_REASON_LOCAL_CLOSE /*3*/:
                    i = zzb.zzg(parcel, zzaT);
                    break;
                case Dimension.UNIT_IN /*4*/:
                    str = zzb.zzq(parcel, zzaT);
                    break;
                case Dimension.UNIT_MM /*5*/:
                    driveId = (DriveId) zzb.zza(parcel, zzaT, DriveId.CREATOR);
                    break;
                case BuyButtonText.LOGO_ONLY /*6*/:
                    num = zzb.zzh(parcel, zzaT);
                    break;
                default:
                    zzb.zzb(parcel, zzaT);
                    break;
            }
        }
        if (parcel.dataPosition() == zzaU) {
            return new zzagx(i2, metadataBundle, i, str, driveId, num);
        }
        throw new zza("Overread allowed size end=" + zzaU, parcel);
    }

    public zzagx[] zzeB(int i) {
        return new zzagx[i];
    }
}
