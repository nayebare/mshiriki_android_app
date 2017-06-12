package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.common.internal.safeparcel.zzb.zza;
import com.google.android.gms.common.internal.safeparcel.zzc;
import com.google.android.gms.wearable.ChannelApi.ChannelListener;
import com.google.android.gms.wearable.MessageApi;

public class zzaid implements Creator<zzaic> {
    static void zza(zzaic com_google_android_gms_internal_zzaic, Parcel parcel, int i) {
        int zzaV = zzc.zzaV(parcel);
        zzc.zzc(parcel, 1, com_google_android_gms_internal_zzaic.mVersionCode);
        zzc.zza(parcel, 2, com_google_android_gms_internal_zzaic.zzaJJ, false);
        zzc.zza(parcel, 3, com_google_android_gms_internal_zzaic.zzaMs);
        zzc.zzJ(parcel, zzaV);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzcs(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzeO(i);
    }

    public zzaic zzcs(Parcel parcel) {
        boolean z = false;
        int zzaU = zzb.zzaU(parcel);
        String str = null;
        int i = 0;
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
                    z = zzb.zzc(parcel, zzaT);
                    break;
                default:
                    zzb.zzb(parcel, zzaT);
                    break;
            }
        }
        if (parcel.dataPosition() == zzaU) {
            return new zzaic(i, str, z);
        }
        throw new zza("Overread allowed size end=" + zzaU, parcel);
    }

    public zzaic[] zzeO(int i) {
        return new zzaic[i];
    }
}
