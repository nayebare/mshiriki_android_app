package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.common.internal.safeparcel.zzb.zza;
import com.google.android.gms.common.internal.safeparcel.zzc;
import com.google.android.gms.fitness.data.Goal.MetricObjective;
import com.google.android.gms.wallet.WalletConstants.CardNetwork;
import com.google.android.gms.wearable.ChannelApi.ChannelListener;
import com.google.android.gms.wearable.MessageApi;

public class zzw implements Creator<MetricObjective> {
    static void zza(MetricObjective metricObjective, Parcel parcel, int i) {
        int zzaV = zzc.zzaV(parcel);
        zzc.zza(parcel, 1, metricObjective.getDataTypeName(), false);
        zzc.zza(parcel, 2, metricObjective.getValue());
        zzc.zza(parcel, 3, metricObjective.zzBH());
        zzc.zzc(parcel, CardNetwork.OTHER, metricObjective.getVersionCode());
        zzc.zzJ(parcel, zzaV);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzeb(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzgH(i);
    }

    public MetricObjective zzeb(Parcel parcel) {
        double d = 0.0d;
        int zzaU = zzb.zzaU(parcel);
        int i = 0;
        String str = null;
        double d2 = 0.0d;
        while (parcel.dataPosition() < zzaU) {
            int zzaT = zzb.zzaT(parcel);
            switch (zzb.zzcW(zzaT)) {
                case MessageApi.FILTER_PREFIX /*1*/:
                    str = zzb.zzq(parcel, zzaT);
                    break;
                case ChannelListener.CLOSE_REASON_REMOTE_CLOSE /*2*/:
                    d2 = zzb.zzn(parcel, zzaT);
                    break;
                case ChannelListener.CLOSE_REASON_LOCAL_CLOSE /*3*/:
                    d = zzb.zzn(parcel, zzaT);
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
            return new MetricObjective(i, str, d2, d);
        }
        throw new zza("Overread allowed size end=" + zzaU, parcel);
    }

    public MetricObjective[] zzgH(int i) {
        return new MetricObjective[i];
    }
}
