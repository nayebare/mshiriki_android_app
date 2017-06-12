package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.common.internal.safeparcel.zzb.zza;
import com.google.android.gms.common.internal.safeparcel.zzc;
import com.google.android.gms.wearable.ChannelApi.ChannelListener;
import com.google.android.gms.wearable.MessageApi;

public class zzakk implements Creator<zzakj> {
    static void zza(zzakj com_google_android_gms_internal_zzakj, Parcel parcel, int i) {
        int zzaV = zzc.zzaV(parcel);
        zzc.zzc(parcel, 1, com_google_android_gms_internal_zzakj.mVersionCode);
        zzc.zza(parcel, 2, com_google_android_gms_internal_zzakj.zzaMG, i, false);
        zzc.zzJ(parcel, zzaV);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzcT(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzfp(i);
    }

    public zzakj zzcT(Parcel parcel) {
        int zzaU = zzb.zzaU(parcel);
        int i = 0;
        zzahy com_google_android_gms_internal_zzahy = null;
        while (parcel.dataPosition() < zzaU) {
            int zzaT = zzb.zzaT(parcel);
            switch (zzb.zzcW(zzaT)) {
                case MessageApi.FILTER_PREFIX /*1*/:
                    i = zzb.zzg(parcel, zzaT);
                    break;
                case ChannelListener.CLOSE_REASON_REMOTE_CLOSE /*2*/:
                    com_google_android_gms_internal_zzahy = (zzahy) zzb.zza(parcel, zzaT, zzahy.CREATOR);
                    break;
                default:
                    zzb.zzb(parcel, zzaT);
                    break;
            }
        }
        if (parcel.dataPosition() == zzaU) {
            return new zzakj(i, com_google_android_gms_internal_zzahy);
        }
        throw new zza("Overread allowed size end=" + zzaU, parcel);
    }

    public zzakj[] zzfp(int i) {
        return new zzakj[i];
    }
}
