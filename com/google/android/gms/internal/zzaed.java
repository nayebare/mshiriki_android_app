package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.common.internal.safeparcel.zzb.zza;
import com.google.android.gms.common.internal.safeparcel.zzc;
import com.google.android.gms.wearable.ChannelApi.ChannelListener;
import com.google.android.gms.wearable.MessageApi;

public class zzaed implements Creator<zzaec> {
    static void zza(zzaec com_google_android_gms_internal_zzaec, Parcel parcel, int i) {
        int zzaV = zzc.zzaV(parcel);
        zzc.zzc(parcel, 1, com_google_android_gms_internal_zzaec.versionCode);
        zzc.zza(parcel, 2, com_google_android_gms_internal_zzaec.zzaHR, false);
        zzc.zza(parcel, 3, com_google_android_gms_internal_zzaec.zzaHS, i, false);
        zzc.zzJ(parcel, zzaV);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzbm(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzdw(i);
    }

    public zzaec zzbm(Parcel parcel) {
        zzaee com_google_android_gms_internal_zzaee = null;
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
                case ChannelListener.CLOSE_REASON_LOCAL_CLOSE /*3*/:
                    com_google_android_gms_internal_zzaee = (zzaee) zzb.zza(parcel, zzaT, zzaee.CREATOR);
                    break;
                default:
                    zzb.zzb(parcel, zzaT);
                    break;
            }
        }
        if (parcel.dataPosition() == zzaU) {
            return new zzaec(i, str, com_google_android_gms_internal_zzaee);
        }
        throw new zza("Overread allowed size end=" + zzaU, parcel);
    }

    public zzaec[] zzdw(int i) {
        return new zzaec[i];
    }
}
