package com.google.android.gms.fitness.result;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.common.internal.safeparcel.zzb.zza;
import com.google.android.gms.common.internal.safeparcel.zzc;
import com.google.android.gms.fitness.data.Session;
import com.google.android.gms.fitness.data.zzac;
import com.google.android.gms.wallet.WalletConstants.CardNetwork;
import com.google.android.gms.wearable.ChannelApi.ChannelListener;
import com.google.android.gms.wearable.MessageApi;
import java.util.List;

public class zzr implements Creator<SessionReadResult> {
    static void zza(SessionReadResult sessionReadResult, Parcel parcel, int i) {
        int zzaV = zzc.zzaV(parcel);
        zzc.zzc(parcel, 1, sessionReadResult.getSessions(), false);
        zzc.zzc(parcel, 2, sessionReadResult.zzCJ(), false);
        zzc.zza(parcel, 3, sessionReadResult.getStatus(), i, false);
        zzc.zzc(parcel, CardNetwork.OTHER, sessionReadResult.getVersionCode());
        zzc.zzJ(parcel, zzaV);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzfm(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzhV(i);
    }

    public SessionReadResult zzfm(Parcel parcel) {
        Status status = null;
        int zzaU = zzb.zzaU(parcel);
        int i = 0;
        List list = null;
        List list2 = null;
        while (parcel.dataPosition() < zzaU) {
            int zzaT = zzb.zzaT(parcel);
            switch (zzb.zzcW(zzaT)) {
                case MessageApi.FILTER_PREFIX /*1*/:
                    list2 = zzb.zzc(parcel, zzaT, Session.CREATOR);
                    break;
                case ChannelListener.CLOSE_REASON_REMOTE_CLOSE /*2*/:
                    list = zzb.zzc(parcel, zzaT, zzac.CREATOR);
                    break;
                case ChannelListener.CLOSE_REASON_LOCAL_CLOSE /*3*/:
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
            return new SessionReadResult(i, list2, list, status);
        }
        throw new zza("Overread allowed size end=" + zzaU, parcel);
    }

    public SessionReadResult[] zzhV(int i) {
        return new SessionReadResult[i];
    }
}
