package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.common.internal.safeparcel.zzb.zza;
import com.google.android.gms.common.internal.safeparcel.zzc;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.wallet.WalletConstants.CardNetwork;
import com.google.android.gms.wearable.MessageApi;
import java.util.List;

public class zzapj implements Creator<zzapi> {
    static void zza(zzapi com_google_android_gms_internal_zzapi, Parcel parcel, int i) {
        int zzaV = zzc.zzaV(parcel);
        zzc.zzc(parcel, 1, com_google_android_gms_internal_zzapi.getDataTypes(), false);
        zzc.zzc(parcel, CardNetwork.OTHER, com_google_android_gms_internal_zzapi.getVersionCode());
        zzc.zzJ(parcel, zzaV);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzel(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzgU(i);
    }

    public zzapi zzel(Parcel parcel) {
        int zzaU = zzb.zzaU(parcel);
        int i = 0;
        List list = null;
        while (parcel.dataPosition() < zzaU) {
            int zzaT = zzb.zzaT(parcel);
            switch (zzb.zzcW(zzaT)) {
                case MessageApi.FILTER_PREFIX /*1*/:
                    list = zzb.zzc(parcel, zzaT, DataType.CREATOR);
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
            return new zzapi(i, list);
        }
        throw new zza("Overread allowed size end=" + zzaU, parcel);
    }

    public zzapi[] zzgU(int i) {
        return new zzapi[i];
    }
}
