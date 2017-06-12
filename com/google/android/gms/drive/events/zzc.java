package com.google.android.gms.drive.events;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.common.internal.safeparcel.zzb.zza;
import com.google.android.gms.wearable.ChannelApi.ChannelListener;
import com.google.android.gms.wearable.MessageApi;

public class zzc implements Creator<zzb> {
    static void zza(zzb com_google_android_gms_drive_events_zzb, Parcel parcel, int i) {
        int zzaV = com.google.android.gms.common.internal.safeparcel.zzc.zzaV(parcel);
        com.google.android.gms.common.internal.safeparcel.zzc.zzc(parcel, 1, com_google_android_gms_drive_events_zzb.mVersionCode);
        com.google.android.gms.common.internal.safeparcel.zzc.zza(parcel, 2, com_google_android_gms_drive_events_zzb.zzaht, false);
        com.google.android.gms.common.internal.safeparcel.zzc.zza(parcel, 3, com_google_android_gms_drive_events_zzb.zzaKh, i, false);
        com.google.android.gms.common.internal.safeparcel.zzc.zzJ(parcel, zzaV);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzbQ(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzeh(i);
    }

    public zzb zzbQ(Parcel parcel) {
        zze com_google_android_gms_drive_events_zze = null;
        int zzaU = zzb.zzaU(parcel);
        int i = 0;
        String str = null;
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
                    com_google_android_gms_drive_events_zze = (zze) zzb.zza(parcel, zzaT, zze.CREATOR);
                    break;
                default:
                    zzb.zzb(parcel, zzaT);
                    break;
            }
        }
        if (parcel.dataPosition() == zzaU) {
            return new zzb(i, str, com_google_android_gms_drive_events_zze);
        }
        throw new zza("Overread allowed size end=" + zzaU, parcel);
    }

    public zzb[] zzeh(int i) {
        return new zzb[i];
    }
}
