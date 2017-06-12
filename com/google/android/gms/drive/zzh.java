package com.google.android.gms.drive;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.common.internal.safeparcel.zzb.zza;
import com.google.android.gms.common.internal.safeparcel.zzc;
import com.google.android.gms.wallet.fragment.WalletFragmentStyle.Dimension;
import com.google.android.gms.wearable.ChannelApi.ChannelListener;
import com.google.android.gms.wearable.MessageApi;

public class zzh implements Creator<DriveId> {
    static void zza(DriveId driveId, Parcel parcel, int i) {
        int zzaV = zzc.zzaV(parcel);
        zzc.zzc(parcel, 1, driveId.mVersionCode);
        zzc.zza(parcel, 2, driveId.zzaJv, false);
        zzc.zza(parcel, 3, driveId.zzaJw);
        zzc.zza(parcel, 4, driveId.zzaJe);
        zzc.zzc(parcel, 5, driveId.zzaJx);
        zzc.zzJ(parcel, zzaV);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzbK(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzdV(i);
    }

    public DriveId zzbK(Parcel parcel) {
        long j = 0;
        int zzaU = zzb.zzaU(parcel);
        int i = 0;
        String str = null;
        int i2 = -1;
        long j2 = 0;
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
                    j2 = zzb.zzi(parcel, zzaT);
                    break;
                case Dimension.UNIT_IN /*4*/:
                    j = zzb.zzi(parcel, zzaT);
                    break;
                case Dimension.UNIT_MM /*5*/:
                    i2 = zzb.zzg(parcel, zzaT);
                    break;
                default:
                    zzb.zzb(parcel, zzaT);
                    break;
            }
        }
        if (parcel.dataPosition() == zzaU) {
            return new DriveId(i, str, j2, j, i2);
        }
        throw new zza("Overread allowed size end=" + zzaU, parcel);
    }

    public DriveId[] zzdV(int i) {
        return new DriveId[i];
    }
}
