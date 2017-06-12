package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.common.internal.safeparcel.zzb.zza;
import com.google.android.gms.common.internal.safeparcel.zzc;
import com.google.android.gms.wallet.WalletConstants.CardNetwork;

public class zzaa implements Creator<zzz> {
    static void zza(zzz com_google_android_gms_drive_query_internal_zzz, Parcel parcel, int i) {
        int zzaV = zzc.zzaV(parcel);
        zzc.zzc(parcel, CardNetwork.OTHER, com_google_android_gms_drive_query_internal_zzz.mVersionCode);
        zzc.zzJ(parcel, zzaV);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzdw(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzfS(i);
    }

    public zzz zzdw(Parcel parcel) {
        int zzaU = zzb.zzaU(parcel);
        int i = 0;
        while (parcel.dataPosition() < zzaU) {
            int zzaT = zzb.zzaT(parcel);
            switch (zzb.zzcW(zzaT)) {
                case CardNetwork.OTHER /*1000*/:
                    i = zzb.zzg(parcel, zzaT);
                    break;
                default:
                    zzb.zzb(parcel, zzaT);
                    break;
            }
        }
        if (parcel.dataPosition() == zzaU) {
            return new zzz(i);
        }
        throw new zza("Overread allowed size end=" + zzaU, parcel);
    }

    public zzz[] zzfS(int i) {
        return new zzz[i];
    }
}
