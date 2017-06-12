package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.common.internal.safeparcel.zzb.zza;
import com.google.android.gms.common.internal.safeparcel.zzc;
import com.google.android.gms.wearable.ChannelApi.ChannelListener;
import com.google.android.gms.wearable.MessageApi;
import java.util.ArrayList;

public class zzafv implements Creator<zzafu> {
    static void zza(zzafu com_google_android_gms_internal_zzafu, Parcel parcel, int i) {
        int zzaV = zzc.zzaV(parcel);
        zzc.zzc(parcel, 1, com_google_android_gms_internal_zzafu.versionCode);
        zzc.zza(parcel, 2, com_google_android_gms_internal_zzafu.zzaJb);
        zzc.zzc(parcel, 3, com_google_android_gms_internal_zzafu.zzaJc, false);
        zzc.zzJ(parcel, zzaV);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzbG(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzdR(i);
    }

    public zzafu zzbG(Parcel parcel) {
        boolean z = false;
        int zzaU = zzb.zzaU(parcel);
        ArrayList arrayList = null;
        int i = 0;
        while (parcel.dataPosition() < zzaU) {
            int zzaT = zzb.zzaT(parcel);
            switch (zzb.zzcW(zzaT)) {
                case MessageApi.FILTER_PREFIX /*1*/:
                    i = zzb.zzg(parcel, zzaT);
                    break;
                case ChannelListener.CLOSE_REASON_REMOTE_CLOSE /*2*/:
                    z = zzb.zzc(parcel, zzaT);
                    break;
                case ChannelListener.CLOSE_REASON_LOCAL_CLOSE /*3*/:
                    arrayList = zzb.zzc(parcel, zzaT, zzadr.CREATOR);
                    break;
                default:
                    zzb.zzb(parcel, zzaT);
                    break;
            }
        }
        if (parcel.dataPosition() == zzaU) {
            return new zzafu(i, z, arrayList);
        }
        throw new zza("Overread allowed size end=" + zzaU, parcel);
    }

    public zzafu[] zzdR(int i) {
        return new zzafu[i];
    }
}
