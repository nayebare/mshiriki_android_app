package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.common.internal.safeparcel.zzc;
import com.google.android.gms.internal.zzafh.zza;
import com.google.android.gms.wearable.ChannelApi.ChannelListener;
import com.google.android.gms.wearable.MessageApi;
import java.util.ArrayList;

public class zzafi implements Creator<zzafh> {
    static void zza(zzafh com_google_android_gms_internal_zzafh, Parcel parcel, int i) {
        int zzaV = zzc.zzaV(parcel);
        zzc.zzc(parcel, 1, com_google_android_gms_internal_zzafh.versionCode);
        zzc.zzc(parcel, 2, com_google_android_gms_internal_zzafh.zzaId, false);
        zzc.zzJ(parcel, zzaV);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzby(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzdJ(i);
    }

    public zzafh zzby(Parcel parcel) {
        int zzaU = zzb.zzaU(parcel);
        int i = 0;
        ArrayList arrayList = null;
        while (parcel.dataPosition() < zzaU) {
            int zzaT = zzb.zzaT(parcel);
            switch (zzb.zzcW(zzaT)) {
                case MessageApi.FILTER_PREFIX /*1*/:
                    i = zzb.zzg(parcel, zzaT);
                    break;
                case ChannelListener.CLOSE_REASON_REMOTE_CLOSE /*2*/:
                    arrayList = zzb.zzc(parcel, zzaT, zza.CREATOR);
                    break;
                default:
                    zzb.zzb(parcel, zzaT);
                    break;
            }
        }
        if (parcel.dataPosition() == zzaU) {
            return new zzafh(i, arrayList);
        }
        throw new zzb.zza("Overread allowed size end=" + zzaU, parcel);
    }

    public zzafh[] zzdJ(int i) {
        return new zzafh[i];
    }
}
