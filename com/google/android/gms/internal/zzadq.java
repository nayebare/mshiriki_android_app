package com.google.android.gms.internal;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.common.internal.safeparcel.zzb.zza;
import com.google.android.gms.common.internal.safeparcel.zzc;
import com.google.android.gms.wearable.ChannelApi.ChannelListener;
import com.google.android.gms.wearable.MessageApi;

public class zzadq implements Creator<zzadp> {
    static void zza(zzadp com_google_android_gms_internal_zzadp, Parcel parcel, int i) {
        int zzaV = zzc.zzaV(parcel);
        zzc.zzc(parcel, 1, com_google_android_gms_internal_zzadp.getVersionCode());
        zzc.zza(parcel, 2, com_google_android_gms_internal_zzadp.zzzd(), false);
        zzc.zzJ(parcel, zzaV);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzbk(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzds(i);
    }

    public zzadp zzbk(Parcel parcel) {
        int zzaU = zzb.zzaU(parcel);
        int i = 0;
        Bundle bundle = null;
        while (parcel.dataPosition() < zzaU) {
            int zzaT = zzb.zzaT(parcel);
            switch (zzb.zzcW(zzaT)) {
                case MessageApi.FILTER_PREFIX /*1*/:
                    i = zzb.zzg(parcel, zzaT);
                    break;
                case ChannelListener.CLOSE_REASON_REMOTE_CLOSE /*2*/:
                    bundle = zzb.zzs(parcel, zzaT);
                    break;
                default:
                    zzb.zzb(parcel, zzaT);
                    break;
            }
        }
        if (parcel.dataPosition() == zzaU) {
            return new zzadp(i, bundle);
        }
        throw new zza("Overread allowed size end=" + zzaU, parcel);
    }

    public zzadp[] zzds(int i) {
        return new zzadp[i];
    }
}
