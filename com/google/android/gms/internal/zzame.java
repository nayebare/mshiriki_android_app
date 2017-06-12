package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.common.internal.safeparcel.zzb.zza;
import com.google.android.gms.common.internal.safeparcel.zzc;
import com.google.android.gms.wearable.ChannelApi.ChannelListener;
import com.google.android.gms.wearable.MessageApi;
import java.util.List;

public class zzame implements Creator<zzamd> {
    static void zza(zzamd com_google_android_gms_internal_zzamd, Parcel parcel, int i) {
        int zzaV = zzc.zzaV(parcel);
        zzc.zzc(parcel, 1, com_google_android_gms_internal_zzamd.mVersionCode);
        zzc.zza(parcel, 2, com_google_android_gms_internal_zzamd.zzavX);
        zzc.zzc(parcel, 3, com_google_android_gms_internal_zzamd.zztf, false);
        zzc.zzJ(parcel, zzaV);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzdz(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzfW(i);
    }

    public zzamd zzdz(Parcel parcel) {
        int zzaU = zzb.zzaU(parcel);
        int i = 0;
        long j = 0;
        List list = null;
        while (parcel.dataPosition() < zzaU) {
            int zzaT = zzb.zzaT(parcel);
            switch (zzb.zzcW(zzaT)) {
                case MessageApi.FILTER_PREFIX /*1*/:
                    i = zzb.zzg(parcel, zzaT);
                    break;
                case ChannelListener.CLOSE_REASON_REMOTE_CLOSE /*2*/:
                    j = zzb.zzi(parcel, zzaT);
                    break;
                case ChannelListener.CLOSE_REASON_LOCAL_CLOSE /*3*/:
                    list = zzb.zzc(parcel, zzaT, zzamn.CREATOR);
                    break;
                default:
                    zzb.zzb(parcel, zzaT);
                    break;
            }
        }
        if (parcel.dataPosition() == zzaU) {
            return new zzamd(i, j, list);
        }
        throw new zza("Overread allowed size end=" + zzaU, parcel);
    }

    public zzamd[] zzfW(int i) {
        return new zzamd[i];
    }
}
