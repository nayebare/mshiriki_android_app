package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.common.internal.safeparcel.zzc;
import com.google.android.gms.internal.zzafs.zza;
import com.google.android.gms.wearable.ChannelApi.ChannelListener;
import com.google.android.gms.wearable.MessageApi;

public class zzaft implements Creator<zza> {
    static void zza(zza com_google_android_gms_internal_zzafs_zza, Parcel parcel, int i) {
        int zzaV = zzc.zzaV(parcel);
        zzc.zzc(parcel, 1, com_google_android_gms_internal_zzafs_zza.versionCode);
        zzc.zza(parcel, 2, com_google_android_gms_internal_zzafs_zza.zzaIZ);
        zzc.zza(parcel, 3, com_google_android_gms_internal_zzafs_zza.zzaJa);
        zzc.zzJ(parcel, zzaV);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzbF(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzdQ(i);
    }

    public zza zzbF(Parcel parcel) {
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
            return new zza(i, j2, j);
        }
        throw new zzb.zza("Overread allowed size end=" + zzaU, parcel);
    }

    public zza[] zzdQ(int i) {
        return new zza[i];
    }
}
