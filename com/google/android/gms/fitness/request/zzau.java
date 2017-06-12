package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.common.internal.safeparcel.zzb.zza;
import com.google.android.gms.common.internal.safeparcel.zzc;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.wallet.WalletConstants.CardNetwork;
import com.google.android.gms.wearable.ChannelApi.ChannelListener;
import com.google.android.gms.wearable.MessageApi;
import java.util.List;

public class zzau implements Creator<zzat> {
    static void zza(zzat com_google_android_gms_fitness_request_zzat, Parcel parcel, int i) {
        int zzaV = zzc.zzaV(parcel);
        zzc.zza(parcel, 1, com_google_android_gms_fitness_request_zzat.getCallbackBinder(), false);
        zzc.zzc(parcel, 3, com_google_android_gms_fitness_request_zzat.getDataSources(), false);
        zzc.zzc(parcel, CardNetwork.OTHER, com_google_android_gms_fitness_request_zzat.getVersionCode());
        zzc.zzJ(parcel, zzaV);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzeL(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzhu(i);
    }

    public zzat zzeL(Parcel parcel) {
        List list = null;
        int zzaU = zzb.zzaU(parcel);
        int i = 0;
        IBinder iBinder = null;
        while (parcel.dataPosition() < zzaU) {
            int zzaT = zzb.zzaT(parcel);
            switch (zzb.zzcW(zzaT)) {
                case MessageApi.FILTER_PREFIX /*1*/:
                    iBinder = zzb.zzr(parcel, zzaT);
                    break;
                case ChannelListener.CLOSE_REASON_LOCAL_CLOSE /*3*/:
                    list = zzb.zzc(parcel, zzaT, DataSource.CREATOR);
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
            return new zzat(i, iBinder, list);
        }
        throw new zza("Overread allowed size end=" + zzaU, parcel);
    }

    public zzat[] zzhu(int i) {
        return new zzat[i];
    }
}
