package com.google.android.gms.drive.metadata;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.common.internal.safeparcel.zzb.zza;
import com.google.android.gms.wearable.ChannelApi.ChannelListener;
import com.google.android.gms.wearable.MessageApi;

public class zzc implements Creator<CustomPropertyKey> {
    static void zza(CustomPropertyKey customPropertyKey, Parcel parcel, int i) {
        int zzaV = com.google.android.gms.common.internal.safeparcel.zzc.zzaV(parcel);
        com.google.android.gms.common.internal.safeparcel.zzc.zzc(parcel, 1, customPropertyKey.mVersionCode);
        com.google.android.gms.common.internal.safeparcel.zzc.zza(parcel, 2, customPropertyKey.zzAH, false);
        com.google.android.gms.common.internal.safeparcel.zzc.zzc(parcel, 3, customPropertyKey.mVisibility);
        com.google.android.gms.common.internal.safeparcel.zzc.zzJ(parcel, zzaV);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzdd(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzfz(i);
    }

    public CustomPropertyKey zzdd(Parcel parcel) {
        int i = 0;
        int zzaU = zzb.zzaU(parcel);
        String str = null;
        int i2 = 0;
        while (parcel.dataPosition() < zzaU) {
            int zzaT = zzb.zzaT(parcel);
            switch (zzb.zzcW(zzaT)) {
                case MessageApi.FILTER_PREFIX /*1*/:
                    i2 = zzb.zzg(parcel, zzaT);
                    break;
                case ChannelListener.CLOSE_REASON_REMOTE_CLOSE /*2*/:
                    str = zzb.zzq(parcel, zzaT);
                    break;
                case ChannelListener.CLOSE_REASON_LOCAL_CLOSE /*3*/:
                    i = zzb.zzg(parcel, zzaT);
                    break;
                default:
                    zzb.zzb(parcel, zzaT);
                    break;
            }
        }
        if (parcel.dataPosition() == zzaU) {
            return new CustomPropertyKey(i2, str, i);
        }
        throw new zza("Overread allowed size end=" + zzaU, parcel);
    }

    public CustomPropertyKey[] zzfz(int i) {
        return new CustomPropertyKey[i];
    }
}
