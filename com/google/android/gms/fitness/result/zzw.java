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

public class zzw implements Creator<zzv> {
    static void zza(zzv com_google_android_gms_fitness_result_zzv, Parcel parcel, int i) {
        int zzaV = zzc.zzaV(parcel);
        zzc.zza(parcel, 1, com_google_android_gms_fitness_result_zzv.getStatus(), i, false);
        zzc.zza(parcel, 2, com_google_android_gms_fitness_result_zzv.zzCM());
        zzc.zzc(parcel, CardNetwork.OTHER, com_google_android_gms_fitness_result_zzv.getVersionCode());
        zzc.zzJ(parcel, zzaV);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzfp(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzhY(i);
    }

    public zzv zzfp(Parcel parcel) {
        int zzaU = zzb.zzaU(parcel);
        int i = 0;
        Status status = null;
        long j = 0;
        while (parcel.dataPosition() < zzaU) {
            Status status2;
            int i2;
            long j2;
            int zzaT = zzb.zzaT(parcel);
            long j3;
            switch (zzb.zzcW(zzaT)) {
                case MessageApi.FILTER_PREFIX /*1*/:
                    j3 = j;
                    status2 = (Status) zzb.zza(parcel, zzaT, Status.CREATOR);
                    i2 = i;
                    j2 = j3;
                    break;
                case ChannelListener.CLOSE_REASON_REMOTE_CLOSE /*2*/:
                    j2 = zzb.zzi(parcel, zzaT);
                    status2 = status;
                    i2 = i;
                    break;
                case CardNetwork.OTHER /*1000*/:
                    j3 = j;
                    status2 = status;
                    i2 = zzb.zzg(parcel, zzaT);
                    j2 = j3;
                    break;
                default:
                    zzb.zzb(parcel, zzaT);
                    j2 = j;
                    status2 = status;
                    i2 = i;
                    break;
            }
            status = status2;
            i = i2;
            j = j2;
        }
        if (parcel.dataPosition() == zzaU) {
            return new zzv(i, status, j);
        }
        throw new zza("Overread allowed size end=" + zzaU, parcel);
    }

    public zzv[] zzhY(int i) {
        return new zzv[i];
    }
}
