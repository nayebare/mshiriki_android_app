package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.common.internal.safeparcel.zzb.zza;
import com.google.android.gms.common.internal.safeparcel.zzc;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.wallet.fragment.WalletFragmentStyle.Dimension;
import com.google.android.gms.wearable.ChannelApi.ChannelListener;
import com.google.android.gms.wearable.MessageApi;

public class zzaki implements Creator<zzakh> {
    static void zza(zzakh com_google_android_gms_internal_zzakh, Parcel parcel, int i) {
        int zzaV = zzc.zzaV(parcel);
        zzc.zzc(parcel, 1, com_google_android_gms_internal_zzakh.mVersionCode);
        zzc.zza(parcel, 2, com_google_android_gms_internal_zzakh.zzaJj, i, false);
        zzc.zza(parcel, 3, com_google_android_gms_internal_zzakh.zzaJT, false);
        zzc.zza(parcel, 4, com_google_android_gms_internal_zzakh.zzaKM);
        zzc.zza(parcel, 5, com_google_android_gms_internal_zzakh.zzaJF, false);
        zzc.zzJ(parcel, zzaV);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzcS(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzfo(i);
    }

    public zzakh zzcS(Parcel parcel) {
        boolean z = false;
        String str = null;
        int zzaU = zzb.zzaU(parcel);
        String str2 = null;
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
                    str2 = zzb.zzq(parcel, zzaT);
                    break;
                case Dimension.UNIT_IN /*4*/:
                    z = zzb.zzc(parcel, zzaT);
                    break;
                case Dimension.UNIT_MM /*5*/:
                    str = zzb.zzq(parcel, zzaT);
                    break;
                default:
                    zzb.zzb(parcel, zzaT);
                    break;
            }
        }
        if (parcel.dataPosition() == zzaU) {
            return new zzakh(i, driveId, str2, z, str);
        }
        throw new zza("Overread allowed size end=" + zzaU, parcel);
    }

    public zzakh[] zzfo(int i) {
        return new zzakh[i];
    }
}
