package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.common.internal.safeparcel.zzb.zza;
import com.google.android.gms.common.internal.safeparcel.zzc;
import com.google.android.gms.wearable.ChannelApi.ChannelListener;
import com.google.android.gms.wearable.MessageApi;

public class zzajh implements Creator<zzajg> {
    static void zza(zzajg com_google_android_gms_internal_zzajg, Parcel parcel, int i) {
        int zzaV = zzc.zzaV(parcel);
        zzc.zzc(parcel, 1, com_google_android_gms_internal_zzajg.mVersionCode);
        zzc.zza(parcel, 2, com_google_android_gms_internal_zzajg.zzaMS, i, false);
        zzc.zza(parcel, 3, com_google_android_gms_internal_zzajg.zzaLq);
        zzc.zzJ(parcel, zzaV);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzcF(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzfb(i);
    }

    public zzajg zzcF(Parcel parcel) {
        boolean z = false;
        int zzaU = zzb.zzaU(parcel);
        DataHolder dataHolder = null;
        int i = 0;
        while (parcel.dataPosition() < zzaU) {
            DataHolder dataHolder2;
            int zzg;
            boolean z2;
            int zzaT = zzb.zzaT(parcel);
            switch (zzb.zzcW(zzaT)) {
                case MessageApi.FILTER_PREFIX /*1*/:
                    boolean z3 = z;
                    dataHolder2 = dataHolder;
                    zzg = zzb.zzg(parcel, zzaT);
                    z2 = z3;
                    break;
                case ChannelListener.CLOSE_REASON_REMOTE_CLOSE /*2*/:
                    zzg = i;
                    DataHolder dataHolder3 = (DataHolder) zzb.zza(parcel, zzaT, DataHolder.CREATOR);
                    z2 = z;
                    dataHolder2 = dataHolder3;
                    break;
                case ChannelListener.CLOSE_REASON_LOCAL_CLOSE /*3*/:
                    z2 = zzb.zzc(parcel, zzaT);
                    dataHolder2 = dataHolder;
                    zzg = i;
                    break;
                default:
                    zzb.zzb(parcel, zzaT);
                    z2 = z;
                    dataHolder2 = dataHolder;
                    zzg = i;
                    break;
            }
            i = zzg;
            dataHolder = dataHolder2;
            z = z2;
        }
        if (parcel.dataPosition() == zzaU) {
            return new zzajg(i, dataHolder, z);
        }
        throw new zza("Overread allowed size end=" + zzaU, parcel);
    }

    public zzajg[] zzfb(int i) {
        return new zzajg[i];
    }
}
