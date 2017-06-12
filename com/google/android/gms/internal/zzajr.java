package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.common.internal.safeparcel.zzb.zza;
import com.google.android.gms.common.internal.safeparcel.zzc;
import com.google.android.gms.wearable.ChannelApi.ChannelListener;
import com.google.android.gms.wearable.MessageApi;
import java.util.List;

public class zzajr implements Creator<zzajq> {
    static void zza(zzajq com_google_android_gms_internal_zzajq, Parcel parcel, int i) {
        int zzaV = zzc.zzaV(parcel);
        zzc.zzc(parcel, 1, com_google_android_gms_internal_zzajq.getVersionCode());
        zzc.zzb(parcel, 2, com_google_android_gms_internal_zzajq.zzAg(), false);
        zzc.zzJ(parcel, zzaV);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzcK(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzfg(i);
    }

    public zzajq zzcK(Parcel parcel) {
        int zzaU = zzb.zzaU(parcel);
        int i = 0;
        List list = null;
        while (parcel.dataPosition() < zzaU) {
            int zzaT = zzb.zzaT(parcel);
            switch (zzb.zzcW(zzaT)) {
                case MessageApi.FILTER_PREFIX /*1*/:
                    i = zzb.zzg(parcel, zzaT);
                    break;
                case ChannelListener.CLOSE_REASON_REMOTE_CLOSE /*2*/:
                    list = zzb.zzE(parcel, zzaT);
                    break;
                default:
                    zzb.zzb(parcel, zzaT);
                    break;
            }
        }
        if (parcel.dataPosition() == zzaU) {
            return new zzajq(i, list);
        }
        throw new zza("Overread allowed size end=" + zzaU, parcel);
    }

    public zzajq[] zzfg(int i) {
        return new zzajq[i];
    }
}
