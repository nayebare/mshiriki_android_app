package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.common.internal.safeparcel.zzb.zza;
import com.google.android.gms.common.internal.safeparcel.zzc;
import com.google.android.gms.fitness.data.Goal.DurationObjective;
import com.google.android.gms.fitness.data.Goal.FrequencyObjective;
import com.google.android.gms.fitness.data.Goal.MetricObjective;
import com.google.android.gms.fitness.data.Goal.Recurrence;
import com.google.android.gms.games.request.Requests;
import com.google.android.gms.wallet.WalletConstants.CardNetwork;
import com.google.android.gms.wallet.fragment.WalletFragmentStyle.BuyButtonText;
import com.google.android.gms.wallet.fragment.WalletFragmentStyle.Dimension;
import com.google.android.gms.wearable.ChannelApi.ChannelListener;
import com.google.android.gms.wearable.MessageApi;
import java.util.ArrayList;
import java.util.List;

public class zzr implements Creator<Goal> {
    static void zza(Goal goal, Parcel parcel, int i) {
        int zzaV = zzc.zzaV(parcel);
        zzc.zza(parcel, 1, goal.zzBB());
        zzc.zza(parcel, 2, goal.zzBC());
        zzc.zzd(parcel, 3, goal.zzBD(), false);
        zzc.zza(parcel, 4, goal.getRecurrence(), i, false);
        zzc.zzc(parcel, 5, goal.getObjectiveType());
        zzc.zza(parcel, 6, goal.zzBE(), i, false);
        zzc.zza(parcel, 7, goal.zzBF(), i, false);
        zzc.zzc(parcel, CardNetwork.OTHER, goal.getVersionCode());
        zzc.zza(parcel, 8, goal.zzBG(), i, false);
        zzc.zzJ(parcel, zzaV);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzdZ(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzgF(i);
    }

    public Goal zzdZ(Parcel parcel) {
        long j = 0;
        int i = 0;
        FrequencyObjective frequencyObjective = null;
        int zzaU = zzb.zzaU(parcel);
        List arrayList = new ArrayList();
        DurationObjective durationObjective = null;
        MetricObjective metricObjective = null;
        Recurrence recurrence = null;
        long j2 = 0;
        int i2 = 0;
        while (parcel.dataPosition() < zzaU) {
            int zzaT = zzb.zzaT(parcel);
            switch (zzb.zzcW(zzaT)) {
                case MessageApi.FILTER_PREFIX /*1*/:
                    j2 = zzb.zzi(parcel, zzaT);
                    break;
                case ChannelListener.CLOSE_REASON_REMOTE_CLOSE /*2*/:
                    j = zzb.zzi(parcel, zzaT);
                    break;
                case ChannelListener.CLOSE_REASON_LOCAL_CLOSE /*3*/:
                    zzb.zza(parcel, zzaT, arrayList, getClass().getClassLoader());
                    break;
                case Dimension.UNIT_IN /*4*/:
                    recurrence = (Recurrence) zzb.zza(parcel, zzaT, Recurrence.CREATOR);
                    break;
                case Dimension.UNIT_MM /*5*/:
                    i = zzb.zzg(parcel, zzaT);
                    break;
                case BuyButtonText.LOGO_ONLY /*6*/:
                    metricObjective = (MetricObjective) zzb.zza(parcel, zzaT, MetricObjective.CREATOR);
                    break;
                case BuyButtonText.DONATE_WITH /*7*/:
                    durationObjective = (DurationObjective) zzb.zza(parcel, zzaT, DurationObjective.CREATOR);
                    break;
                case Requests.MAX_REQUEST_RECIPIENTS /*8*/:
                    frequencyObjective = (FrequencyObjective) zzb.zza(parcel, zzaT, FrequencyObjective.CREATOR);
                    break;
                case CardNetwork.OTHER /*1000*/:
                    i2 = zzb.zzg(parcel, zzaT);
                    break;
                default:
                    zzb.zzb(parcel, zzaT);
                    break;
            }
        }
        if (parcel.dataPosition() == zzaU) {
            return new Goal(i2, j2, j, arrayList, recurrence, i, metricObjective, durationObjective, frequencyObjective);
        }
        throw new zza("Overread allowed size end=" + zzaU, parcel);
    }

    public Goal[] zzgF(int i) {
        return new Goal[i];
    }
}
