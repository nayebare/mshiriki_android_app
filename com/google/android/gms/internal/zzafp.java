package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.common.internal.safeparcel.zzb.zza;
import com.google.android.gms.common.internal.safeparcel.zzc;
import com.google.android.gms.wearable.MessageApi;

public class zzafp implements Creator<zzafq> {
    static void zza(zzafq com_google_android_gms_internal_zzafq, Parcel parcel, int i) {
        int zzaV = zzc.zzaV(parcel);
        zzc.zzc(parcel, 1, com_google_android_gms_internal_zzafq.versionCode);
        zzc.zzJ(parcel, zzaV);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzbD(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzdO(i);
    }

    public zzafq zzbD(Parcel parcel) {
        int zzaU = zzb.zzaU(parcel);
        int i = 0;
        while (parcel.dataPosition() < zzaU) {
            int zzaT = zzb.zzaT(parcel);
            switch (zzb.zzcW(zzaT)) {
                case MessageApi.FILTER_PREFIX /*1*/:
                    i = zzb.zzg(parcel, zzaT);
                    break;
                default:
                    zzb.zzb(parcel, zzaT);
                    break;
            }
        }
        if (parcel.dataPosition() == zzaU) {
            return new zzafq(i);
        }
        throw new zza("Overread allowed size end=" + zzaU, parcel);
    }

    public zzafq[] zzdO(int i) {
        return new zzafq[i];
    }
}
