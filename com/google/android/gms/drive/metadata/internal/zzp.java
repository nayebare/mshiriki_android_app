package com.google.android.gms.drive.metadata.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.common.internal.safeparcel.zzb.zza;
import com.google.android.gms.common.internal.safeparcel.zzc;
import com.google.android.gms.wallet.fragment.WalletFragmentStyle.Dimension;
import com.google.android.gms.wearable.ChannelApi.ChannelListener;
import com.google.android.gms.wearable.MessageApi;

public class zzp implements Creator<zzo> {
    static void zza(zzo com_google_android_gms_drive_metadata_internal_zzo, Parcel parcel, int i) {
        int zzaV = zzc.zzaV(parcel);
        zzc.zzc(parcel, 1, com_google_android_gms_drive_metadata_internal_zzo.mVersionCode);
        zzc.zza(parcel, 2, com_google_android_gms_drive_metadata_internal_zzo.zzaJv, false);
        zzc.zza(parcel, 3, com_google_android_gms_drive_metadata_internal_zzo.zzaJw);
        zzc.zzc(parcel, 4, com_google_android_gms_drive_metadata_internal_zzo.zzaJx);
        zzc.zzJ(parcel, zzaV);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzdi(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzfE(i);
    }

    public zzo zzdi(Parcel parcel) {
        int zzaU = zzb.zzaU(parcel);
        int i = 0;
        String str = null;
        long j = 0;
        int i2 = -1;
        while (parcel.dataPosition() < zzaU) {
            int zzaT = zzb.zzaT(parcel);
            switch (zzb.zzcW(zzaT)) {
                case MessageApi.FILTER_PREFIX /*1*/:
                    i = zzb.zzg(parcel, zzaT);
                    break;
                case ChannelListener.CLOSE_REASON_REMOTE_CLOSE /*2*/:
                    str = zzb.zzq(parcel, zzaT);
                    break;
                case ChannelListener.CLOSE_REASON_LOCAL_CLOSE /*3*/:
                    j = zzb.zzi(parcel, zzaT);
                    break;
                case Dimension.UNIT_IN /*4*/:
                    i2 = zzb.zzg(parcel, zzaT);
                    break;
                default:
                    zzb.zzb(parcel, zzaT);
                    break;
            }
        }
        if (parcel.dataPosition() == zzaU) {
            return new zzo(i, str, j, i2);
        }
        throw new zza("Overread allowed size end=" + zzaU, parcel);
    }

    public zzo[] zzfE(int i) {
        return new zzo[i];
    }
}
