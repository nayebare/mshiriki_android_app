package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.common.internal.safeparcel.zzb.zza;
import com.google.android.gms.common.internal.safeparcel.zzc;
import com.google.android.gms.fitness.data.DataPoint;
import com.google.android.gms.fitness.data.DataSet;
import com.google.android.gms.fitness.data.Session;
import com.google.android.gms.wallet.WalletConstants.CardNetwork;
import com.google.android.gms.wallet.fragment.WalletFragmentStyle.Dimension;
import com.google.android.gms.wearable.ChannelApi.ChannelListener;
import com.google.android.gms.wearable.MessageApi;
import java.util.List;

public class zzaz implements Creator<SessionInsertRequest> {
    static void zza(SessionInsertRequest sessionInsertRequest, Parcel parcel, int i) {
        int zzaV = zzc.zzaV(parcel);
        zzc.zza(parcel, 1, sessionInsertRequest.getSession(), i, false);
        zzc.zzc(parcel, 2, sessionInsertRequest.getDataSets(), false);
        zzc.zzc(parcel, 3, sessionInsertRequest.getAggregateDataPoints(), false);
        zzc.zza(parcel, 4, sessionInsertRequest.getCallbackBinder(), false);
        zzc.zzc(parcel, CardNetwork.OTHER, sessionInsertRequest.getVersionCode());
        zzc.zzJ(parcel, zzaV);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzeO(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzhx(i);
    }

    public SessionInsertRequest zzeO(Parcel parcel) {
        IBinder iBinder = null;
        int zzaU = zzb.zzaU(parcel);
        int i = 0;
        List list = null;
        List list2 = null;
        Session session = null;
        while (parcel.dataPosition() < zzaU) {
            int zzaT = zzb.zzaT(parcel);
            switch (zzb.zzcW(zzaT)) {
                case MessageApi.FILTER_PREFIX /*1*/:
                    session = (Session) zzb.zza(parcel, zzaT, Session.CREATOR);
                    break;
                case ChannelListener.CLOSE_REASON_REMOTE_CLOSE /*2*/:
                    list2 = zzb.zzc(parcel, zzaT, DataSet.CREATOR);
                    break;
                case ChannelListener.CLOSE_REASON_LOCAL_CLOSE /*3*/:
                    list = zzb.zzc(parcel, zzaT, DataPoint.CREATOR);
                    break;
                case Dimension.UNIT_IN /*4*/:
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
            return new SessionInsertRequest(i, session, list2, list, iBinder);
        }
        throw new zza("Overread allowed size end=" + zzaU, parcel);
    }

    public SessionInsertRequest[] zzhx(int i) {
        return new SessionInsertRequest[i];
    }
}
