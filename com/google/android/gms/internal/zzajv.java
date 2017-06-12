package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.common.internal.safeparcel.zzb.zza;
import com.google.android.gms.common.internal.safeparcel.zzc;
import com.google.android.gms.wearable.ChannelApi.ChannelListener;
import com.google.android.gms.wearable.MessageApi;

public class zzajv implements Creator<zzaju> {
    static void zza(zzaju com_google_android_gms_internal_zzaju, Parcel parcel, int i) {
        int zzaV = zzc.zzaV(parcel);
        zzc.zzc(parcel, 1, com_google_android_gms_internal_zzaju.mVersionCode);
        zzc.zza(parcel, 2, com_google_android_gms_internal_zzaju.zzaLq);
        zzc.zzJ(parcel, zzaV);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzcM(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzfi(i);
    }

    public zzaju zzcM(Parcel parcel) {
        boolean z = false;
        int zzaU = zzb.zzaU(parcel);
        int i = 0;
        while (parcel.dataPosition() < zzaU) {
            int zzaT = zzb.zzaT(parcel);
            switch (zzb.zzcW(zzaT)) {
                case MessageApi.FILTER_PREFIX /*1*/:
                    i = zzb.zzg(parcel, zzaT);
                    break;
                case ChannelListener.CLOSE_REASON_REMOTE_CLOSE /*2*/:
                    z = zzb.zzc(parcel, zzaT);
                    break;
                default:
                    zzb.zzb(parcel, zzaT);
                    break;
            }
        }
        if (parcel.dataPosition() == zzaU) {
            return new zzaju(i, z);
        }
        throw new zza("Overread allowed size end=" + zzaU, parcel);
    }

    public zzaju[] zzfi(int i) {
        return new zzaju[i];
    }
}
