package com.google.android.gms.drive.events;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.common.internal.safeparcel.zzb.zza;
import com.google.android.gms.common.internal.safeparcel.zzc;
import com.google.android.gms.internal.zzafz;
import com.google.android.gms.wearable.ChannelApi.ChannelListener;
import com.google.android.gms.wearable.MessageApi;

public class zzo implements Creator<zzn> {
    static void zza(zzn com_google_android_gms_drive_events_zzn, Parcel parcel, int i) {
        int zzaV = zzc.zzaV(parcel);
        zzc.zzc(parcel, 1, com_google_android_gms_drive_events_zzn.mVersionCode);
        zzc.zza(parcel, 2, com_google_android_gms_drive_events_zzn.zzaKB, i, false);
        zzc.zzJ(parcel, zzaV);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzbU(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzel(i);
    }

    public zzn zzbU(Parcel parcel) {
        int zzaU = zzb.zzaU(parcel);
        int i = 0;
        zzafz com_google_android_gms_internal_zzafz = null;
        while (parcel.dataPosition() < zzaU) {
            int zzaT = zzb.zzaT(parcel);
            switch (zzb.zzcW(zzaT)) {
                case MessageApi.FILTER_PREFIX /*1*/:
                    i = zzb.zzg(parcel, zzaT);
                    break;
                case ChannelListener.CLOSE_REASON_REMOTE_CLOSE /*2*/:
                    com_google_android_gms_internal_zzafz = (zzafz) zzb.zza(parcel, zzaT, zzafz.CREATOR);
                    break;
                default:
                    zzb.zzb(parcel, zzaT);
                    break;
            }
        }
        if (parcel.dataPosition() == zzaU) {
            return new zzn(i, com_google_android_gms_internal_zzafz);
        }
        throw new zza("Overread allowed size end=" + zzaU, parcel);
    }

    public zzn[] zzel(int i) {
        return new zzn[i];
    }
}
