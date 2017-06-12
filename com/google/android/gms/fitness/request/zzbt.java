package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.common.internal.safeparcel.zzb.zza;
import com.google.android.gms.common.internal.safeparcel.zzc;
import com.google.android.gms.wallet.WalletConstants.CardNetwork;
import com.google.android.gms.wearable.ChannelApi.ChannelListener;
import com.google.android.gms.wearable.MessageApi;

public class zzbt implements Creator<zzbs> {
    static void zza(zzbs com_google_android_gms_fitness_request_zzbs, Parcel parcel, int i) {
        int zzaV = zzc.zzaV(parcel);
        zzc.zza(parcel, 1, com_google_android_gms_fitness_request_zzbs.getCallbackBinder(), false);
        zzc.zza(parcel, 2, com_google_android_gms_fitness_request_zzbs.zzCB(), false);
        zzc.zzc(parcel, CardNetwork.OTHER, com_google_android_gms_fitness_request_zzbs.getVersionCode());
        zzc.zzJ(parcel, zzaV);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzeZ(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzhI(i);
    }

    public zzbs zzeZ(Parcel parcel) {
        IBinder iBinder = null;
        int zzaU = zzb.zzaU(parcel);
        int i = 0;
        IBinder iBinder2 = null;
        while (parcel.dataPosition() < zzaU) {
            int zzaT = zzb.zzaT(parcel);
            switch (zzb.zzcW(zzaT)) {
                case MessageApi.FILTER_PREFIX /*1*/:
                    iBinder2 = zzb.zzr(parcel, zzaT);
                    break;
                case ChannelListener.CLOSE_REASON_REMOTE_CLOSE /*2*/:
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
            return new zzbs(i, iBinder2, iBinder);
        }
        throw new zza("Overread allowed size end=" + zzaU, parcel);
    }

    public zzbs[] zzhI(int i) {
        return new zzbs[i];
    }
}
