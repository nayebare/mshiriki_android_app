package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.common.internal.safeparcel.zzb.zza;
import com.google.android.gms.common.internal.safeparcel.zzc;
import com.google.android.gms.wearable.ChannelApi.ChannelListener;
import com.google.android.gms.wearable.MessageApi;

public class zzamw implements Creator<zzamv> {
    static void zza(zzamv com_google_android_gms_internal_zzamv, Parcel parcel, int i) {
        int zzaV = zzc.zzaV(parcel);
        zzc.zzc(parcel, 1, com_google_android_gms_internal_zzamv.mVersionCode);
        zzc.zzc(parcel, 2, com_google_android_gms_internal_zzamv.mIndex);
        zzc.zzc(parcel, 3, com_google_android_gms_internal_zzamv.zzaPT);
        zzc.zzJ(parcel, zzaV);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzdI(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzgf(i);
    }

    public zzamv zzdI(Parcel parcel) {
        int i = 0;
        int zzaU = zzb.zzaU(parcel);
        int i2 = 0;
        int i3 = 0;
        while (parcel.dataPosition() < zzaU) {
            int zzaT = zzb.zzaT(parcel);
            switch (zzb.zzcW(zzaT)) {
                case MessageApi.FILTER_PREFIX /*1*/:
                    i3 = zzb.zzg(parcel, zzaT);
                    break;
                case ChannelListener.CLOSE_REASON_REMOTE_CLOSE /*2*/:
                    i2 = zzb.zzg(parcel, zzaT);
                    break;
                case ChannelListener.CLOSE_REASON_LOCAL_CLOSE /*3*/:
                    i = zzb.zzg(parcel, zzaT);
                    break;
                default:
                    zzb.zzb(parcel, zzaT);
                    break;
            }
        }
        if (parcel.dataPosition() == zzaU) {
            return new zzamv(i3, i2, i);
        }
        throw new zza("Overread allowed size end=" + zzaU, parcel);
    }

    public zzamv[] zzgf(int i) {
        return new zzamv[i];
    }
}
