package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.common.internal.safeparcel.zzb.zza;
import com.google.android.gms.common.internal.safeparcel.zzc;
import com.google.android.gms.wearable.ChannelApi.ChannelListener;
import com.google.android.gms.wearable.MessageApi;

public class zzakm implements Creator<zzakl> {
    static void zza(zzakl com_google_android_gms_internal_zzakl, Parcel parcel, int i) {
        int zzaV = zzc.zzaV(parcel);
        zzc.zzc(parcel, 1, com_google_android_gms_internal_zzakl.mVersionCode);
        zzc.zza(parcel, 2, com_google_android_gms_internal_zzakl.zzaMU, i, false);
        zzc.zzJ(parcel, zzaV);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzcU(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzfq(i);
    }

    public zzakl zzcU(Parcel parcel) {
        int zzaU = zzb.zzaU(parcel);
        int i = 0;
        zzakb com_google_android_gms_internal_zzakb = null;
        while (parcel.dataPosition() < zzaU) {
            int zzaT = zzb.zzaT(parcel);
            switch (zzb.zzcW(zzaT)) {
                case MessageApi.FILTER_PREFIX /*1*/:
                    i = zzb.zzg(parcel, zzaT);
                    break;
                case ChannelListener.CLOSE_REASON_REMOTE_CLOSE /*2*/:
                    com_google_android_gms_internal_zzakb = (zzakb) zzb.zza(parcel, zzaT, zzakb.CREATOR);
                    break;
                default:
                    zzb.zzb(parcel, zzaT);
                    break;
            }
        }
        if (parcel.dataPosition() == zzaU) {
            return new zzakl(i, com_google_android_gms_internal_zzakb);
        }
        throw new zza("Overread allowed size end=" + zzaU, parcel);
    }

    public zzakl[] zzfq(int i) {
        return new zzakl[i];
    }
}
