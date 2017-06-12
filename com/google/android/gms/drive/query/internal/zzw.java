package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.common.internal.safeparcel.zzb.zza;
import com.google.android.gms.common.internal.safeparcel.zzc;
import com.google.android.gms.wallet.WalletConstants.CardNetwork;
import com.google.android.gms.wearable.MessageApi;

public class zzw implements Creator<zzv> {
    static void zza(zzv com_google_android_gms_drive_query_internal_zzv, Parcel parcel, int i) {
        int zzaV = zzc.zzaV(parcel);
        zzc.zza(parcel, 1, com_google_android_gms_drive_query_internal_zzv.zzaPc, i, false);
        zzc.zzc(parcel, CardNetwork.OTHER, com_google_android_gms_drive_query_internal_zzv.mVersionCode);
        zzc.zzJ(parcel, zzaV);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzdu(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzfQ(i);
    }

    public zzv zzdu(Parcel parcel) {
        int zzaU = zzb.zzaU(parcel);
        int i = 0;
        FilterHolder filterHolder = null;
        while (parcel.dataPosition() < zzaU) {
            int zzaT = zzb.zzaT(parcel);
            switch (zzb.zzcW(zzaT)) {
                case MessageApi.FILTER_PREFIX /*1*/:
                    filterHolder = (FilterHolder) zzb.zza(parcel, zzaT, FilterHolder.CREATOR);
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
            return new zzv(i, filterHolder);
        }
        throw new zza("Overread allowed size end=" + zzaU, parcel);
    }

    public zzv[] zzfQ(int i) {
        return new zzv[i];
    }
}
