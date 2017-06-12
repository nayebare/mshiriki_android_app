package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.common.internal.safeparcel.zzb.zza;
import com.google.android.gms.common.internal.safeparcel.zzc;
import com.google.android.gms.wearable.ChannelApi.ChannelListener;
import com.google.android.gms.wearable.MessageApi;

public class zzamk implements Creator<zzamj> {
    static void zza(zzamj com_google_android_gms_internal_zzamj, Parcel parcel, int i) {
        int zzaV = zzc.zzaV(parcel);
        zzc.zzc(parcel, 1, com_google_android_gms_internal_zzamj.mVersionCode);
        zzc.zzc(parcel, 2, com_google_android_gms_internal_zzamj.zzaPu);
        zzc.zzJ(parcel, zzaV);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzdC(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzfZ(i);
    }

    public zzamj zzdC(Parcel parcel) {
        int i = 0;
        int zzaU = zzb.zzaU(parcel);
        int i2 = 0;
        while (parcel.dataPosition() < zzaU) {
            int zzaT = zzb.zzaT(parcel);
            switch (zzb.zzcW(zzaT)) {
                case MessageApi.FILTER_PREFIX /*1*/:
                    i2 = zzb.zzg(parcel, zzaT);
                    break;
                case ChannelListener.CLOSE_REASON_REMOTE_CLOSE /*2*/:
                    i = zzb.zzg(parcel, zzaT);
                    break;
                default:
                    zzb.zzb(parcel, zzaT);
                    break;
            }
        }
        if (parcel.dataPosition() == zzaU) {
            return new zzamj(i2, i);
        }
        throw new zza("Overread allowed size end=" + zzaU, parcel);
    }

    public zzamj[] zzfZ(int i) {
        return new zzamj[i];
    }
}
