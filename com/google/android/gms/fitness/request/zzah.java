package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.common.internal.safeparcel.zzb.zza;
import com.google.android.gms.common.internal.safeparcel.zzc;
import com.google.android.gms.wallet.WalletConstants.CardNetwork;
import com.google.android.gms.wallet.fragment.WalletFragmentStyle.Dimension;
import com.google.android.gms.wearable.ChannelApi.ChannelListener;
import com.google.android.gms.wearable.MessageApi;
import java.util.ArrayList;
import java.util.List;

public class zzah implements Creator<GoalsReadRequest> {
    static void zza(GoalsReadRequest goalsReadRequest, Parcel parcel, int i) {
        int zzaV = zzc.zzaV(parcel);
        zzc.zza(parcel, 1, goalsReadRequest.getCallbackBinder(), false);
        zzc.zzd(parcel, 2, goalsReadRequest.getDataTypes(), false);
        zzc.zzd(parcel, 3, goalsReadRequest.zzCl(), false);
        zzc.zzd(parcel, 4, goalsReadRequest.zzBD(), false);
        zzc.zzc(parcel, CardNetwork.OTHER, goalsReadRequest.getVersionCode());
        zzc.zzJ(parcel, zzaV);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzeG(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzhp(i);
    }

    public GoalsReadRequest zzeG(Parcel parcel) {
        int zzaU = zzb.zzaU(parcel);
        int i = 0;
        IBinder iBinder = null;
        List arrayList = new ArrayList();
        List arrayList2 = new ArrayList();
        List arrayList3 = new ArrayList();
        while (parcel.dataPosition() < zzaU) {
            int zzaT = zzb.zzaT(parcel);
            switch (zzb.zzcW(zzaT)) {
                case MessageApi.FILTER_PREFIX /*1*/:
                    iBinder = zzb.zzr(parcel, zzaT);
                    break;
                case ChannelListener.CLOSE_REASON_REMOTE_CLOSE /*2*/:
                    zzb.zza(parcel, zzaT, arrayList, getClass().getClassLoader());
                    break;
                case ChannelListener.CLOSE_REASON_LOCAL_CLOSE /*3*/:
                    zzb.zza(parcel, zzaT, arrayList2, getClass().getClassLoader());
                    break;
                case Dimension.UNIT_IN /*4*/:
                    zzb.zza(parcel, zzaT, arrayList3, getClass().getClassLoader());
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
            return new GoalsReadRequest(i, iBinder, arrayList, arrayList2, arrayList3);
        }
        throw new zza("Overread allowed size end=" + zzaU, parcel);
    }

    public GoalsReadRequest[] zzhp(int i) {
        return new GoalsReadRequest[i];
    }
}
