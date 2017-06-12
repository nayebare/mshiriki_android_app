package com.google.android.gms.internal;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.common.internal.safeparcel.zzb.zza;
import com.google.android.gms.common.internal.safeparcel.zzc;
import com.google.android.gms.wearable.ChannelApi.ChannelListener;
import com.google.android.gms.wearable.MessageApi;

public class zzael implements Creator<zzaek> {
    static void zza(zzaek com_google_android_gms_internal_zzaek, Parcel parcel, int i) {
        int zzaV = zzc.zzaV(parcel);
        zzc.zzc(parcel, 1, com_google_android_gms_internal_zzaek.versionCode);
        zzc.zza(parcel, 2, com_google_android_gms_internal_zzaek.zzzp(), false);
        zzc.zzJ(parcel, zzaV);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzbq(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzdB(i);
    }

    public zzaek zzbq(Parcel parcel) {
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
            return new zzaek(i, bundle);
        }
        throw new zza("Overread allowed size end=" + zzaU, parcel);
    }

    public zzaek[] zzdB(int i) {
        return new zzaek[i];
    }
}
