package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.common.internal.safeparcel.zzb.zza;
import com.google.android.gms.common.internal.safeparcel.zzc;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.wallet.WalletConstants.CardNetwork;
import com.google.android.gms.wearable.MessageApi;

public class zzapl implements Creator<zzapk> {
    static void zza(zzapk com_google_android_gms_internal_zzapk, Parcel parcel, int i) {
        int zzaV = zzc.zzaV(parcel);
        zzc.zza(parcel, 1, com_google_android_gms_internal_zzapk.getDataSource(), i, false);
        zzc.zzc(parcel, CardNetwork.OTHER, com_google_android_gms_internal_zzapk.getVersionCode());
        zzc.zzJ(parcel, zzaV);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzem(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzgV(i);
    }

    public zzapk zzem(Parcel parcel) {
        int zzaU = zzb.zzaU(parcel);
        int i = 0;
        DataSource dataSource = null;
        while (parcel.dataPosition() < zzaU) {
            int zzaT = zzb.zzaT(parcel);
            switch (zzb.zzcW(zzaT)) {
                case MessageApi.FILTER_PREFIX /*1*/:
                    dataSource = (DataSource) zzb.zza(parcel, zzaT, DataSource.CREATOR);
                    break;
                case CardNetwork.OTHER /*1000*/:
                    i = zzb.zzg(parcel, zzaT);
                    break;
                default:
                    zzb.zzb(parcel, zzaT);
                    break;
            }
        }
        if (parcel.dataPosition() == zzaU) {
            return new zzapk(i, dataSource);
        }
        throw new zza("Overread allowed size end=" + zzaU, parcel);
    }

    public zzapk[] zzgV(int i) {
        return new zzapk[i];
    }
}
