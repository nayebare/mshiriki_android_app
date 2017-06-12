package com.google.android.gms.drive.metadata.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.common.internal.safeparcel.zzc;
import com.google.android.gms.wearable.ChannelApi.ChannelListener;
import com.google.android.gms.wearable.MessageApi;
import java.util.Collection;

public class zza implements Creator<AppVisibleCustomProperties> {
    static void zza(AppVisibleCustomProperties appVisibleCustomProperties, Parcel parcel, int i) {
        int zzaV = zzc.zzaV(parcel);
        zzc.zzc(parcel, 1, appVisibleCustomProperties.mVersionCode);
        zzc.zzc(parcel, 2, appVisibleCustomProperties.zzaNr, false);
        zzc.zzJ(parcel, zzaV);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzde(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzfA(i);
    }

    public AppVisibleCustomProperties zzde(Parcel parcel) {
        int zzaU = zzb.zzaU(parcel);
        int i = 0;
        Collection collection = null;
        while (parcel.dataPosition() < zzaU) {
            int zzaT = zzb.zzaT(parcel);
            switch (zzb.zzcW(zzaT)) {
                case MessageApi.FILTER_PREFIX /*1*/:
                    i = zzb.zzg(parcel, zzaT);
                    break;
                case ChannelListener.CLOSE_REASON_REMOTE_CLOSE /*2*/:
                    collection = zzb.zzc(parcel, zzaT, zzc.CREATOR);
                    break;
                default:
                    zzb.zzb(parcel, zzaT);
                    break;
            }
        }
        if (parcel.dataPosition() == zzaU) {
            return new AppVisibleCustomProperties(i, collection);
        }
        throw new com.google.android.gms.common.internal.safeparcel.zzb.zza("Overread allowed size end=" + zzaU, parcel);
    }

    public AppVisibleCustomProperties[] zzfA(int i) {
        return new AppVisibleCustomProperties[i];
    }
}
