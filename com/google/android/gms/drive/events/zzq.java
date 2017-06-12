package com.google.android.gms.drive.events;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.common.internal.safeparcel.zzb.zza;
import com.google.android.gms.common.internal.safeparcel.zzc;
import com.google.android.gms.wearable.ChannelApi.ChannelListener;
import com.google.android.gms.wearable.MessageApi;

public class zzq implements Creator<zzp> {
    static void zza(zzp com_google_android_gms_drive_events_zzp, Parcel parcel, int i) {
        int zzaV = zzc.zzaV(parcel);
        zzc.zzc(parcel, 1, com_google_android_gms_drive_events_zzp.mVersionCode);
        zzc.zzc(parcel, 2, com_google_android_gms_drive_events_zzp.zzaKC);
        zzc.zzJ(parcel, zzaV);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzbV(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzem(i);
    }

    public zzp zzbV(Parcel parcel) {
        int i = 0;
        int zzaU = zzb.zzaU(parcel);
        int i2 = 0;
        while (parcel.dataPosition() < zzaU) {
            int zzaT = zzb.zzaT(parcel);
            switch (zzb.zzcW(zzaT)) {
                case MessageApi.FILTER_PREFIX /*1*/:
                    i2 = zzb.zzg(parcel, zzaT);
                    break;
                case ChannelListener.CLOSE_REASON_REMOTE_CLOSE /*2*/:
                    i = zzb.zzg(parcel, zzaT);
                    break;
                default:
                    zzb.zzb(parcel, zzaT);
                    break;
            }
        }
        if (parcel.dataPosition() == zzaU) {
            return new zzp(i2, i);
        }
        throw new zza("Overread allowed size end=" + zzaU, parcel);
    }

    public zzp[] zzem(int i) {
        return new zzp[i];
    }
}
