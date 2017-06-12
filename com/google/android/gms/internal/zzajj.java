package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.common.internal.safeparcel.zzb.zza;
import com.google.android.gms.common.internal.safeparcel.zzc;
import com.google.android.gms.wearable.ChannelApi.ChannelListener;
import com.google.android.gms.wearable.MessageApi;

public class zzajj implements Creator<zzaji> {
    static void zza(zzaji com_google_android_gms_internal_zzaji, Parcel parcel, int i) {
        int zzaV = zzc.zzaV(parcel);
        zzc.zzc(parcel, 1, com_google_android_gms_internal_zzaji.mVersionCode);
        zzc.zza(parcel, 2, com_google_android_gms_internal_zzaji.zzaMT, i, false);
        zzc.zzJ(parcel, zzaV);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzcG(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzfc(i);
    }

    public zzaji zzcG(Parcel parcel) {
        int zzaU = zzb.zzaU(parcel);
        int i = 0;
        DataHolder dataHolder = null;
        while (parcel.dataPosition() < zzaU) {
            int zzaT = zzb.zzaT(parcel);
            switch (zzb.zzcW(zzaT)) {
                case MessageApi.FILTER_PREFIX /*1*/:
                    i = zzb.zzg(parcel, zzaT);
                    break;
                case ChannelListener.CLOSE_REASON_REMOTE_CLOSE /*2*/:
                    dataHolder = (DataHolder) zzb.zza(parcel, zzaT, DataHolder.CREATOR);
                    break;
                default:
                    zzb.zzb(parcel, zzaT);
                    break;
            }
        }
        if (parcel.dataPosition() == zzaU) {
            return new zzaji(i, dataHolder);
        }
        throw new zza("Overread allowed size end=" + zzaU, parcel);
    }

    public zzaji[] zzfc(int i) {
        return new zzaji[i];
    }
}
