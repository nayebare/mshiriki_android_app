package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.common.internal.safeparcel.zzc;
import com.google.android.gms.internal.zzawk.zzb.zza;
import com.google.android.gms.wearable.ChannelApi.ChannelListener;
import com.google.android.gms.wearable.MessageApi;
import java.util.HashSet;
import java.util.Set;

public class zzawo implements Creator<zza> {
    static void zza(zza com_google_android_gms_internal_zzawk_zzb_zza, Parcel parcel, int i) {
        int zzaV = zzc.zzaV(parcel);
        Set set = com_google_android_gms_internal_zzawk_zzb_zza.zzbAl;
        if (set.contains(Integer.valueOf(1))) {
            zzc.zzc(parcel, 1, com_google_android_gms_internal_zzawk_zzb_zza.mVersionCode);
        }
        if (set.contains(Integer.valueOf(2))) {
            zzc.zzc(parcel, 2, com_google_android_gms_internal_zzawk_zzb_zza.zzbAK);
        }
        if (set.contains(Integer.valueOf(3))) {
            zzc.zzc(parcel, 3, com_google_android_gms_internal_zzawk_zzb_zza.zzbAL);
        }
        zzc.zzJ(parcel, zzaV);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zziB(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzmu(i);
    }

    public zza zziB(Parcel parcel) {
        int i = 0;
        int zzaU = zzb.zzaU(parcel);
        Set hashSet = new HashSet();
        int i2 = 0;
        int i3 = 0;
        while (parcel.dataPosition() < zzaU) {
            int zzaT = zzb.zzaT(parcel);
            switch (zzb.zzcW(zzaT)) {
                case MessageApi.FILTER_PREFIX /*1*/:
                    i3 = zzb.zzg(parcel, zzaT);
                    hashSet.add(Integer.valueOf(1));
                    break;
                case ChannelListener.CLOSE_REASON_REMOTE_CLOSE /*2*/:
                    i2 = zzb.zzg(parcel, zzaT);
                    hashSet.add(Integer.valueOf(2));
                    break;
                case ChannelListener.CLOSE_REASON_LOCAL_CLOSE /*3*/:
                    i = zzb.zzg(parcel, zzaT);
                    hashSet.add(Integer.valueOf(3));
                    break;
                default:
                    zzb.zzb(parcel, zzaT);
                    break;
            }
        }
        if (parcel.dataPosition() == zzaU) {
            return new zza(hashSet, i3, i2, i);
        }
        throw new zzb.zza("Overread allowed size end=" + zzaU, parcel);
    }

    public zza[] zzmu(int i) {
        return new zza[i];
    }
}
