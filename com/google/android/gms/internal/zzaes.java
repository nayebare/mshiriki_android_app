package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.common.internal.safeparcel.zzc;
import com.google.android.gms.internal.zzaeg.zza;
import com.google.android.gms.wearable.ChannelApi.ChannelListener;
import com.google.android.gms.wearable.MessageApi;
import java.util.List;

public class zzaes implements Creator<zza> {
    static void zza(zza com_google_android_gms_internal_zzaeg_zza, Parcel parcel, int i) {
        int zzaV = zzc.zzaV(parcel);
        zzc.zzc(parcel, 1, com_google_android_gms_internal_zzaeg_zza.versionCode);
        zzc.zzc(parcel, 2, com_google_android_gms_internal_zzaeg_zza.type);
        zzc.zzb(parcel, 3, com_google_android_gms_internal_zzaeg_zza.zzaHW, false);
        zzc.zzJ(parcel, zzaV);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzbt(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzdE(i);
    }

    public zza zzbt(Parcel parcel) {
        int i = 0;
        int zzaU = zzb.zzaU(parcel);
        List list = null;
        int i2 = 0;
        while (parcel.dataPosition() < zzaU) {
            int zzaT = zzb.zzaT(parcel);
            switch (zzb.zzcW(zzaT)) {
                case MessageApi.FILTER_PREFIX /*1*/:
                    i2 = zzb.zzg(parcel, zzaT);
                    break;
                case ChannelListener.CLOSE_REASON_REMOTE_CLOSE /*2*/:
                    i = zzb.zzg(parcel, zzaT);
                    break;
                case ChannelListener.CLOSE_REASON_LOCAL_CLOSE /*3*/:
                    list = zzb.zzE(parcel, zzaT);
                    break;
                default:
                    zzb.zzb(parcel, zzaT);
                    break;
            }
        }
        if (parcel.dataPosition() == zzaU) {
            return new zza(i2, i, list);
        }
        throw new zzb.zza("Overread allowed size end=" + zzaU, parcel);
    }

    public zza[] zzdE(int i) {
        return new zza[i];
    }
}
