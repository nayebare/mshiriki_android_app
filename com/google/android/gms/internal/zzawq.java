package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.common.internal.safeparcel.zzb.zza;
import com.google.android.gms.internal.zzawk.zzc;
import com.google.android.gms.wearable.ChannelApi.ChannelListener;
import com.google.android.gms.wearable.MessageApi;
import java.util.HashSet;
import java.util.Set;

public class zzawq implements Creator<zzc> {
    static void zza(zzc com_google_android_gms_internal_zzawk_zzc, Parcel parcel, int i) {
        int zzaV = com.google.android.gms.common.internal.safeparcel.zzc.zzaV(parcel);
        Set set = com_google_android_gms_internal_zzawk_zzc.zzbAl;
        if (set.contains(Integer.valueOf(1))) {
            com.google.android.gms.common.internal.safeparcel.zzc.zzc(parcel, 1, com_google_android_gms_internal_zzawk_zzc.mVersionCode);
        }
        if (set.contains(Integer.valueOf(2))) {
            com.google.android.gms.common.internal.safeparcel.zzc.zza(parcel, 2, com_google_android_gms_internal_zzawk_zzc.zzD, true);
        }
        com.google.android.gms.common.internal.safeparcel.zzc.zzJ(parcel, zzaV);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zziD(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzmw(i);
    }

    public zzc zziD(Parcel parcel) {
        int zzaU = zzb.zzaU(parcel);
        Set hashSet = new HashSet();
        int i = 0;
        String str = null;
        while (parcel.dataPosition() < zzaU) {
            int zzaT = zzb.zzaT(parcel);
            switch (zzb.zzcW(zzaT)) {
                case MessageApi.FILTER_PREFIX /*1*/:
                    i = zzb.zzg(parcel, zzaT);
                    hashSet.add(Integer.valueOf(1));
                    break;
                case ChannelListener.CLOSE_REASON_REMOTE_CLOSE /*2*/:
                    str = zzb.zzq(parcel, zzaT);
                    hashSet.add(Integer.valueOf(2));
                    break;
                default:
                    zzb.zzb(parcel, zzaT);
                    break;
            }
        }
        if (parcel.dataPosition() == zzaU) {
            return new zzc(hashSet, i, str);
        }
        throw new zza("Overread allowed size end=" + zzaU, parcel);
    }

    public zzc[] zzmw(int i) {
        return new zzc[i];
    }
}
