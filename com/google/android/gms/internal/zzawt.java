package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.common.internal.safeparcel.zzb.zza;
import com.google.android.gms.common.internal.safeparcel.zzc;
import com.google.android.gms.internal.zzawk.zzg;
import com.google.android.gms.wearable.ChannelApi.ChannelListener;
import com.google.android.gms.wearable.MessageApi;
import java.util.HashSet;
import java.util.Set;

public class zzawt implements Creator<zzg> {
    static void zza(zzg com_google_android_gms_internal_zzawk_zzg, Parcel parcel, int i) {
        int zzaV = zzc.zzaV(parcel);
        Set set = com_google_android_gms_internal_zzawk_zzg.zzbAl;
        if (set.contains(Integer.valueOf(1))) {
            zzc.zzc(parcel, 1, com_google_android_gms_internal_zzawk_zzg.mVersionCode);
        }
        if (set.contains(Integer.valueOf(2))) {
            zzc.zza(parcel, 2, com_google_android_gms_internal_zzawk_zzg.zzbAT);
        }
        if (set.contains(Integer.valueOf(3))) {
            zzc.zza(parcel, 3, com_google_android_gms_internal_zzawk_zzg.mValue, true);
        }
        zzc.zzJ(parcel, zzaV);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zziG(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzmz(i);
    }

    public zzg zziG(Parcel parcel) {
        boolean z = false;
        int zzaU = zzb.zzaU(parcel);
        Set hashSet = new HashSet();
        String str = null;
        int i = 0;
        while (parcel.dataPosition() < zzaU) {
            int zzaT = zzb.zzaT(parcel);
            switch (zzb.zzcW(zzaT)) {
                case MessageApi.FILTER_PREFIX /*1*/:
                    i = zzb.zzg(parcel, zzaT);
                    hashSet.add(Integer.valueOf(1));
                    break;
                case ChannelListener.CLOSE_REASON_REMOTE_CLOSE /*2*/:
                    z = zzb.zzc(parcel, zzaT);
                    hashSet.add(Integer.valueOf(2));
                    break;
                case ChannelListener.CLOSE_REASON_LOCAL_CLOSE /*3*/:
                    str = zzb.zzq(parcel, zzaT);
                    hashSet.add(Integer.valueOf(3));
                    break;
                default:
                    zzb.zzb(parcel, zzaT);
                    break;
            }
        }
        if (parcel.dataPosition() == zzaU) {
            return new zzg(hashSet, i, z, str);
        }
        throw new zza("Overread allowed size end=" + zzaU, parcel);
    }

    public zzg[] zzmz(int i) {
        return new zzg[i];
    }
}
