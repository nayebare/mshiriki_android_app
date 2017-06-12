package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.common.internal.safeparcel.zzb.zza;
import com.google.android.gms.common.internal.safeparcel.zzc;
import com.google.android.gms.wallet.WalletConstants.CardNetwork;
import com.google.android.gms.wearable.MessageApi;

public class zzarn implements Creator<zzarm> {
    static void zza(zzarm com_google_android_gms_internal_zzarm, Parcel parcel, int i) {
        int zzaV = zzc.zzaV(parcel);
        zzc.zza(parcel, 1, com_google_android_gms_internal_zzarm.getStatus(), i, false);
        zzc.zzc(parcel, CardNetwork.OTHER, com_google_android_gms_internal_zzarm.getVersionCode());
        zzc.zzJ(parcel, zzaV);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzgQ(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzko(i);
    }

    public zzarm zzgQ(Parcel parcel) {
        int zzaU = zzb.zzaU(parcel);
        int i = 0;
        Status status = null;
        while (parcel.dataPosition() < zzaU) {
            int zzaT = zzb.zzaT(parcel);
            switch (zzb.zzcW(zzaT)) {
                case MessageApi.FILTER_PREFIX /*1*/:
                    status = (Status) zzb.zza(parcel, zzaT, Status.CREATOR);
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
            return new zzarm(i, status);
        }
        throw new zza("Overread allowed size end=" + zzaU, parcel);
    }

    public zzarm[] zzko(int i) {
        return new zzarm[i];
    }
}
