package com.google.android.gms.instantapps;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zzb.zza;
import com.google.android.gms.common.internal.safeparcel.zzc;
import com.google.android.gms.wearable.MessageApi;

public class zzb implements Creator<LaunchSettings> {
    static void zza(LaunchSettings launchSettings, Parcel parcel, int i) {
        int zzaV = zzc.zzaV(parcel);
        zzc.zzc(parcel, 1, launchSettings.getVersionCode());
        zzc.zzJ(parcel, zzaV);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzgp(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzjD(i);
    }

    public LaunchSettings zzgp(Parcel parcel) {
        int zzaU = com.google.android.gms.common.internal.safeparcel.zzb.zzaU(parcel);
        int i = 0;
        while (parcel.dataPosition() < zzaU) {
            int zzaT = com.google.android.gms.common.internal.safeparcel.zzb.zzaT(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.zzb.zzcW(zzaT)) {
                case MessageApi.FILTER_PREFIX /*1*/:
                    i = com.google.android.gms.common.internal.safeparcel.zzb.zzg(parcel, zzaT);
                    break;
                default:
                    com.google.android.gms.common.internal.safeparcel.zzb.zzb(parcel, zzaT);
                    break;
            }
        }
        if (parcel.dataPosition() == zzaU) {
            return new LaunchSettings(i);
        }
        throw new zza("Overread allowed size end=" + zzaU, parcel);
    }

    public LaunchSettings[] zzjD(int i) {
        return new LaunchSettings[i];
    }
}
