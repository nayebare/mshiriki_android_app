package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.common.internal.safeparcel.zzb.zza;
import com.google.android.gms.common.internal.safeparcel.zzc;
import com.google.android.gms.wearable.ChannelApi.ChannelListener;
import com.google.android.gms.wearable.MessageApi;

public class zzaen implements Creator<zzaem> {
    static void zza(zzaem com_google_android_gms_internal_zzaem, Parcel parcel, int i) {
        int zzaV = zzc.zzaV(parcel);
        zzc.zzc(parcel, 1, com_google_android_gms_internal_zzaem.versionCode);
        zzc.zza(parcel, 2, com_google_android_gms_internal_zzaem.zzaIc);
        zzc.zza(parcel, 3, com_google_android_gms_internal_zzaem.zzaA, false);
        zzc.zzJ(parcel, zzaV);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzbr(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzdC(i);
    }

    public zzaem zzbr(Parcel parcel) {
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
                    z = zzb.zzc(parcel, zzaT);
                    break;
                case ChannelListener.CLOSE_REASON_LOCAL_CLOSE /*3*/:
                    str = zzb.zzq(parcel, zzaT);
                    break;
                default:
                    zzb.zzb(parcel, zzaT);
                    break;
            }
        }
        if (parcel.dataPosition() == zzaU) {
            return new zzaem(i, z, str);
        }
        throw new zza("Overread allowed size end=" + zzaU, parcel);
    }

    public zzaem[] zzdC(int i) {
        return new zzaem[i];
    }
}
