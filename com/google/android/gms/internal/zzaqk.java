package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.common.internal.safeparcel.zzb.zza;
import com.google.android.gms.common.internal.safeparcel.zzc;
import com.google.android.gms.wearable.ChannelApi.ChannelListener;
import com.google.android.gms.wearable.MessageApi;

public class zzaqk implements Creator<zzaqj> {
    static void zza(zzaqj com_google_android_gms_internal_zzaqj, Parcel parcel, int i) {
        int zzaV = zzc.zzaV(parcel);
        zzc.zzc(parcel, 1, com_google_android_gms_internal_zzaqj.version);
        zzc.zza(parcel, 2, com_google_android_gms_internal_zzaqj.getTitle(), false);
        zzc.zza(parcel, 3, com_google_android_gms_internal_zzaqj.getImageUrl(), false);
        zzc.zzJ(parcel, zzaV);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzgs(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzjG(i);
    }

    public zzaqj zzgs(Parcel parcel) {
        String str = null;
        int zzaU = zzb.zzaU(parcel);
        int i = 0;
        String str2 = null;
        while (parcel.dataPosition() < zzaU) {
            int zzaT = zzb.zzaT(parcel);
            switch (zzb.zzcW(zzaT)) {
                case MessageApi.FILTER_PREFIX /*1*/:
                    i = zzb.zzg(parcel, zzaT);
                    break;
                case ChannelListener.CLOSE_REASON_REMOTE_CLOSE /*2*/:
                    str2 = zzb.zzq(parcel, zzaT);
                    break;
                case ChannelListener.CLOSE_REASON_LOCAL_CLOSE /*3*/:
                    str = zzb.zzq(parcel, zzaT);
                    break;
                default:
                    zzb.zzb(parcel, zzaT);
                    break;
            }
        }
        if (parcel.dataPosition() == zzaU) {
            return new zzaqj(i, str2, str);
        }
        throw new zza("Overread allowed size end=" + zzaU, parcel);
    }

    public zzaqj[] zzjG(int i) {
        return new zzaqj[i];
    }
}
