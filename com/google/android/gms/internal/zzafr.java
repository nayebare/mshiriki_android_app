package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.common.internal.safeparcel.zzc;
import com.google.android.gms.internal.zzafs.zza;
import com.google.android.gms.wearable.ChannelApi.ChannelListener;
import com.google.android.gms.wearable.MessageApi;
import java.util.ArrayList;

public class zzafr implements Creator<zzafs> {
    static void zza(zzafs com_google_android_gms_internal_zzafs, Parcel parcel, int i) {
        int zzaV = zzc.zzaV(parcel);
        zzc.zzc(parcel, 1, com_google_android_gms_internal_zzafs.versionCode);
        zzc.zzc(parcel, 2, com_google_android_gms_internal_zzafs.zzaIX, false);
        zzc.zza(parcel, 3, com_google_android_gms_internal_zzafs.zzaIY, false);
        zzc.zzJ(parcel, zzaV);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzbE(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzdP(i);
    }

    public zzafs zzbE(Parcel parcel) {
        int[] iArr = null;
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
                case ChannelListener.CLOSE_REASON_LOCAL_CLOSE /*3*/:
                    iArr = zzb.zzw(parcel, zzaT);
                    break;
                default:
                    zzb.zzb(parcel, zzaT);
                    break;
            }
        }
        if (parcel.dataPosition() == zzaU) {
            return new zzafs(i, arrayList, iArr);
        }
        throw new zzb.zza("Overread allowed size end=" + zzaU, parcel);
    }

    public zzafs[] zzdP(int i) {
        return new zzafs[i];
    }
}
