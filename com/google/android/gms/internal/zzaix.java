package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.common.internal.safeparcel.zzb.zza;
import com.google.android.gms.common.internal.safeparcel.zzc;
import com.google.android.gms.wearable.ChannelApi.ChannelListener;
import com.google.android.gms.wearable.MessageApi;

public class zzaix implements Creator<zzaiw> {
    static void zza(zzaiw com_google_android_gms_internal_zzaiw, Parcel parcel, int i) {
        int zzaV = zzc.zzaV(parcel);
        zzc.zzc(parcel, 1, com_google_android_gms_internal_zzaiw.mVersionCode);
        zzc.zza(parcel, 2, com_google_android_gms_internal_zzaiw.zzaMG, i, false);
        zzc.zzJ(parcel, zzaV);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzcA(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzeW(i);
    }

    public zzaiw zzcA(Parcel parcel) {
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
            return new zzaiw(i, com_google_android_gms_internal_zzahy);
        }
        throw new zza("Overread allowed size end=" + zzaU, parcel);
    }

    public zzaiw[] zzeW(int i) {
        return new zzaiw[i];
    }
}
