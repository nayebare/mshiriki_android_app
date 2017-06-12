package com.google.android.gms.drive;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.common.internal.safeparcel.zzb.zza;
import com.google.android.gms.common.internal.safeparcel.zzc;
import com.google.android.gms.wearable.ChannelApi.ChannelListener;
import com.google.android.gms.wearable.MessageApi;

public class zzf implements Creator<zze> {
    static void zza(zze com_google_android_gms_drive_zze, Parcel parcel, int i) {
        int zzaV = zzc.zzaV(parcel);
        zzc.zzc(parcel, 1, com_google_android_gms_drive_zze.mVersionCode);
        zzc.zza(parcel, 2, com_google_android_gms_drive_zze.zzaJt);
        zzc.zza(parcel, 3, com_google_android_gms_drive_zze.zzaJu);
        zzc.zzJ(parcel, zzaV);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzbJ(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzdU(i);
    }

    public zze zzbJ(Parcel parcel) {
        long j = 0;
        int zzaU = zzb.zzaU(parcel);
        int i = 0;
        long j2 = 0;
        while (parcel.dataPosition() < zzaU) {
            int zzaT = zzb.zzaT(parcel);
            switch (zzb.zzcW(zzaT)) {
                case MessageApi.FILTER_PREFIX /*1*/:
                    i = zzb.zzg(parcel, zzaT);
                    break;
                case ChannelListener.CLOSE_REASON_REMOTE_CLOSE /*2*/:
                    j2 = zzb.zzi(parcel, zzaT);
                    break;
                case ChannelListener.CLOSE_REASON_LOCAL_CLOSE /*3*/:
                    j = zzb.zzi(parcel, zzaT);
                    break;
                default:
                    zzb.zzb(parcel, zzaT);
                    break;
            }
        }
        if (parcel.dataPosition() == zzaU) {
            return new zze(i, j2, j);
        }
        throw new zza("Overread allowed size end=" + zzaU, parcel);
    }

    public zze[] zzdU(int i) {
        return new zze[i];
    }
}
