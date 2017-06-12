package com.google.android.gms.drive.metadata.internal;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.common.internal.safeparcel.zzb.zza;
import com.google.android.gms.common.internal.safeparcel.zzc;
import com.google.android.gms.wearable.ChannelApi.ChannelListener;
import com.google.android.gms.wearable.MessageApi;

public class zzi implements Creator<MetadataBundle> {
    static void zza(MetadataBundle metadataBundle, Parcel parcel, int i) {
        int zzaV = zzc.zzaV(parcel);
        zzc.zzc(parcel, 1, metadataBundle.mVersionCode);
        zzc.zza(parcel, 2, metadataBundle.zzaNw, false);
        zzc.zzJ(parcel, zzaV);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzdg(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzfC(i);
    }

    public MetadataBundle zzdg(Parcel parcel) {
        int zzaU = zzb.zzaU(parcel);
        int i = 0;
        Bundle bundle = null;
        while (parcel.dataPosition() < zzaU) {
            int zzaT = zzb.zzaT(parcel);
            switch (zzb.zzcW(zzaT)) {
                case MessageApi.FILTER_PREFIX /*1*/:
                    i = zzb.zzg(parcel, zzaT);
                    break;
                case ChannelListener.CLOSE_REASON_REMOTE_CLOSE /*2*/:
                    bundle = zzb.zzs(parcel, zzaT);
                    break;
                default:
                    zzb.zzb(parcel, zzaT);
                    break;
            }
        }
        if (parcel.dataPosition() == zzaU) {
            return new MetadataBundle(i, bundle);
        }
        throw new zza("Overread allowed size end=" + zzaU, parcel);
    }

    public MetadataBundle[] zzfC(int i) {
        return new MetadataBundle[i];
    }
}
