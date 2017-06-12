package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.common.internal.safeparcel.zzb.zza;
import com.google.android.gms.common.internal.safeparcel.zzc;
import com.google.android.gms.wearable.ChannelApi.ChannelListener;
import com.google.android.gms.wearable.MessageApi;

public class zzajo implements Creator<zzajn> {
    static void zza(zzajn com_google_android_gms_internal_zzajn, Parcel parcel, int i) {
        int zzaV = zzc.zzaV(parcel);
        zzc.zzc(parcel, 1, com_google_android_gms_internal_zzajn.mVersionCode);
        zzc.zza(parcel, 2, com_google_android_gms_internal_zzajn.zzaMU, i, false);
        zzc.zzJ(parcel, zzaV);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzcI(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzfe(i);
    }

    public zzajn zzcI(Parcel parcel) {
        int zzaU = zzb.zzaU(parcel);
        int i = 0;
        zzakb com_google_android_gms_internal_zzakb = null;
        while (parcel.dataPosition() < zzaU) {
            int zzaT = zzb.zzaT(parcel);
            switch (zzb.zzcW(zzaT)) {
                case MessageApi.FILTER_PREFIX /*1*/:
                    i = zzb.zzg(parcel, zzaT);
                    break;
                case ChannelListener.CLOSE_REASON_REMOTE_CLOSE /*2*/:
                    com_google_android_gms_internal_zzakb = (zzakb) zzb.zza(parcel, zzaT, zzakb.CREATOR);
                    break;
                default:
                    zzb.zzb(parcel, zzaT);
                    break;
            }
        }
        if (parcel.dataPosition() == zzaU) {
            return new zzajn(i, com_google_android_gms_internal_zzakb);
        }
        throw new zza("Overread allowed size end=" + zzaU, parcel);
    }

    public zzajn[] zzfe(int i) {
        return new zzajn[i];
    }
}
