package com.google.android.gms.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.common.internal.safeparcel.zzb.zza;
import com.google.android.gms.common.internal.safeparcel.zzc;
import com.google.android.gms.wallet.WalletConstants.CardNetwork;
import com.google.android.gms.wearable.MessageApi;

public class zzavh implements Creator<zzavg> {
    static void zza(zzavg com_google_android_gms_internal_zzavg, Parcel parcel, int i) {
        int zzaV = zzc.zzaV(parcel);
        zzc.zza(parcel, 1, com_google_android_gms_internal_zzavg.getCallbackBinder(), false);
        zzc.zzc(parcel, CardNetwork.OTHER, com_google_android_gms_internal_zzavg.versionCode);
        zzc.zzJ(parcel, zzaV);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzhW(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzlC(i);
    }

    public zzavg zzhW(Parcel parcel) {
        int zzaU = zzb.zzaU(parcel);
        int i = 0;
        IBinder iBinder = null;
        while (parcel.dataPosition() < zzaU) {
            int zzaT = zzb.zzaT(parcel);
            switch (zzb.zzcW(zzaT)) {
                case MessageApi.FILTER_PREFIX /*1*/:
                    iBinder = zzb.zzr(parcel, zzaT);
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
            return new zzavg(i, iBinder);
        }
        throw new zza("Overread allowed size end=" + zzaU, parcel);
    }

    public zzavg[] zzlC(int i) {
        return new zzavg[i];
    }
}
