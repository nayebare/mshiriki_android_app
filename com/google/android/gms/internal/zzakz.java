package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.common.internal.safeparcel.zzb.zza;
import com.google.android.gms.common.internal.safeparcel.zzc;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.wearable.ChannelApi.ChannelListener;
import com.google.android.gms.wearable.MessageApi;

public class zzakz implements Creator<zzaky> {
    static void zza(zzaky com_google_android_gms_internal_zzaky, Parcel parcel, int i) {
        int zzaV = zzc.zzaV(parcel);
        zzc.zzc(parcel, 1, com_google_android_gms_internal_zzaky.mVersionCode);
        zzc.zza(parcel, 2, com_google_android_gms_internal_zzaky.zzaKS, i, false);
        zzc.zzJ(parcel, zzaV);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzda(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzfw(i);
    }

    public zzaky zzda(Parcel parcel) {
        int zzaU = zzb.zzaU(parcel);
        int i = 0;
        DriveId driveId = null;
        while (parcel.dataPosition() < zzaU) {
            int zzaT = zzb.zzaT(parcel);
            switch (zzb.zzcW(zzaT)) {
                case MessageApi.FILTER_PREFIX /*1*/:
                    i = zzb.zzg(parcel, zzaT);
                    break;
                case ChannelListener.CLOSE_REASON_REMOTE_CLOSE /*2*/:
                    driveId = (DriveId) zzb.zza(parcel, zzaT, DriveId.CREATOR);
                    break;
                default:
                    zzb.zzb(parcel, zzaT);
                    break;
            }
        }
        if (parcel.dataPosition() == zzaU) {
            return new zzaky(i, driveId);
        }
        throw new zza("Overread allowed size end=" + zzaU, parcel);
    }

    public zzaky[] zzfw(int i) {
        return new zzaky[i];
    }
}
