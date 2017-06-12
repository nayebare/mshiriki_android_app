package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.common.internal.safeparcel.zzb.zza;
import com.google.android.gms.common.internal.safeparcel.zzc;
import com.google.android.gms.wearable.ChannelApi.ChannelListener;
import com.google.android.gms.wearable.MessageApi;

public class zzare implements Creator<zzard> {
    static void zza(zzard com_google_android_gms_internal_zzard, Parcel parcel, int i) {
        int zzaV = zzc.zzaV(parcel);
        zzc.zzc(parcel, 1, com_google_android_gms_internal_zzard.version);
        zzc.zza(parcel, 2, com_google_android_gms_internal_zzard.getPackageName(), false);
        zzc.zzJ(parcel, zzaV);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzgy(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzjP(i);
    }

    public zzard zzgy(Parcel parcel) {
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
                default:
                    zzb.zzb(parcel, zzaT);
                    break;
            }
        }
        if (parcel.dataPosition() == zzaU) {
            return new zzard(i, str);
        }
        throw new zza("Overread allowed size end=" + zzaU, parcel);
    }

    public zzard[] zzjP(int i) {
        return new zzard[i];
    }
}
