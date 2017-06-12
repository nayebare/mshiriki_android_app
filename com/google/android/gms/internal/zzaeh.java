package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.common.internal.safeparcel.zzc;
import com.google.android.gms.internal.zzaeg.zza;
import com.google.android.gms.wearable.ChannelApi.ChannelListener;
import com.google.android.gms.wearable.MessageApi;

public class zzaeh implements Creator<zzaeg> {
    static void zza(zzaeg com_google_android_gms_internal_zzaeg, Parcel parcel, int i) {
        int zzaV = zzc.zzaV(parcel);
        zzc.zzc(parcel, 1, com_google_android_gms_internal_zzaeg.versionCode);
        zzc.zza(parcel, 2, com_google_android_gms_internal_zzaeg.zzaHV, i, false);
        zzc.zzJ(parcel, zzaV);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzbo(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzdz(i);
    }

    public zzaeg zzbo(Parcel parcel) {
        int zzaU = zzb.zzaU(parcel);
        int i = 0;
        zza com_google_android_gms_internal_zzaeg_zza = null;
        while (parcel.dataPosition() < zzaU) {
            int zzaT = zzb.zzaT(parcel);
            switch (zzb.zzcW(zzaT)) {
                case MessageApi.FILTER_PREFIX /*1*/:
                    i = zzb.zzg(parcel, zzaT);
                    break;
                case ChannelListener.CLOSE_REASON_REMOTE_CLOSE /*2*/:
                    com_google_android_gms_internal_zzaeg_zza = (zza) zzb.zza(parcel, zzaT, zza.CREATOR);
                    break;
                default:
                    zzb.zzb(parcel, zzaT);
                    break;
            }
        }
        if (parcel.dataPosition() == zzaU) {
            return new zzaeg(i, com_google_android_gms_internal_zzaeg_zza);
        }
        throw new zzb.zza("Overread allowed size end=" + zzaU, parcel);
    }

    public zzaeg[] zzdz(int i) {
        return new zzaeg[i];
    }
}
