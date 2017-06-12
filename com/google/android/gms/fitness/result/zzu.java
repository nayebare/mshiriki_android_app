package com.google.android.gms.fitness.result;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.common.internal.safeparcel.zzb.zza;
import com.google.android.gms.common.internal.safeparcel.zzc;
import com.google.android.gms.wallet.WalletConstants.CardNetwork;
import com.google.android.gms.wearable.ChannelApi.ChannelListener;
import com.google.android.gms.wearable.MessageApi;

public class zzu implements Creator<zzt> {
    static void zza(zzt com_google_android_gms_fitness_result_zzt, Parcel parcel, int i) {
        int zzaV = zzc.zzaV(parcel);
        zzc.zza(parcel, 1, com_google_android_gms_fitness_result_zzt.getStatus(), i, false);
        zzc.zza(parcel, 2, com_google_android_gms_fitness_result_zzt.zzCK());
        zzc.zza(parcel, 3, com_google_android_gms_fitness_result_zzt.zzCL(), false);
        zzc.zzc(parcel, CardNetwork.OTHER, com_google_android_gms_fitness_result_zzt.getVersionCode());
        zzc.zzJ(parcel, zzaV);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzfo(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzhX(i);
    }

    public zzt zzfo(Parcel parcel) {
        Boolean bool = null;
        int zzaU = zzb.zzaU(parcel);
        int i = 0;
        long j = 0;
        Status status = null;
        while (parcel.dataPosition() < zzaU) {
            int zzaT = zzb.zzaT(parcel);
            switch (zzb.zzcW(zzaT)) {
                case MessageApi.FILTER_PREFIX /*1*/:
                    status = (Status) zzb.zza(parcel, zzaT, Status.CREATOR);
                    break;
                case ChannelListener.CLOSE_REASON_REMOTE_CLOSE /*2*/:
                    j = zzb.zzi(parcel, zzaT);
                    break;
                case ChannelListener.CLOSE_REASON_LOCAL_CLOSE /*3*/:
                    bool = zzb.zzd(parcel, zzaT);
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
            return new zzt(i, status, j, bool);
        }
        throw new zza("Overread allowed size end=" + zzaU, parcel);
    }

    public zzt[] zzhX(int i) {
        return new zzt[i];
    }
}
