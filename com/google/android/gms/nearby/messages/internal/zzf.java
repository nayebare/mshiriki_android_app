package com.google.android.gms.nearby.messages.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.common.internal.safeparcel.zzb.zza;
import com.google.android.gms.common.internal.safeparcel.zzc;
import com.google.android.gms.wearable.ChannelApi.ChannelListener;
import com.google.android.gms.wearable.MessageApi;

public class zzf implements Creator<zze> {
    static void zza(zze com_google_android_gms_nearby_messages_internal_zze, Parcel parcel, int i) {
        int zzaV = zzc.zzaV(parcel);
        zzc.zzc(parcel, 1, com_google_android_gms_nearby_messages_internal_zze.mVersionCode);
        zzc.zzc(parcel, 2, com_google_android_gms_nearby_messages_internal_zze.accuracy);
        zzc.zza(parcel, 3, com_google_android_gms_nearby_messages_internal_zze.zzbyy);
        zzc.zzJ(parcel, zzaV);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzii(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzlY(i);
    }

    public zze zzii(Parcel parcel) {
        int i = 0;
        int zzaU = zzb.zzaU(parcel);
        double d = 0.0d;
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
                    d = zzb.zzn(parcel, zzaT);
                    break;
                default:
                    zzb.zzb(parcel, zzaT);
                    break;
            }
        }
        if (parcel.dataPosition() == zzaU) {
            return new zze(i2, i, d);
        }
        throw new zza("Overread allowed size end=" + zzaU, parcel);
    }

    public zze[] zzlY(int i) {
        return new zze[i];
    }
}
