package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.common.internal.safeparcel.zzb.zza;
import com.google.android.gms.common.internal.safeparcel.zzc;
import com.google.android.gms.wallet.WalletConstants.CardNetwork;
import com.google.android.gms.wearable.ChannelApi.ChannelListener;
import com.google.android.gms.wearable.MessageApi;

public class zzad implements Creator<zzac> {
    static void zza(zzac com_google_android_gms_fitness_data_zzac, Parcel parcel, int i) {
        int zzaV = zzc.zzaV(parcel);
        zzc.zza(parcel, 1, com_google_android_gms_fitness_data_zzac.getSession(), i, false);
        zzc.zza(parcel, 2, com_google_android_gms_fitness_data_zzac.getDataSet(), i, false);
        zzc.zzc(parcel, CardNetwork.OTHER, com_google_android_gms_fitness_data_zzac.mVersionCode);
        zzc.zzJ(parcel, zzaV);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzeh(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzgO(i);
    }

    public zzac zzeh(Parcel parcel) {
        DataSet dataSet = null;
        int zzaU = zzb.zzaU(parcel);
        int i = 0;
        Session session = null;
        while (parcel.dataPosition() < zzaU) {
            int i2;
            DataSet dataSet2;
            Session session2;
            int zzaT = zzb.zzaT(parcel);
            switch (zzb.zzcW(zzaT)) {
                case MessageApi.FILTER_PREFIX /*1*/:
                    i2 = i;
                    Session session3 = (Session) zzb.zza(parcel, zzaT, Session.CREATOR);
                    dataSet2 = dataSet;
                    session2 = session3;
                    break;
                case ChannelListener.CLOSE_REASON_REMOTE_CLOSE /*2*/:
                    dataSet2 = (DataSet) zzb.zza(parcel, zzaT, DataSet.CREATOR);
                    session2 = session;
                    i2 = i;
                    break;
                case CardNetwork.OTHER /*1000*/:
                    DataSet dataSet3 = dataSet;
                    session2 = session;
                    i2 = zzb.zzg(parcel, zzaT);
                    dataSet2 = dataSet3;
                    break;
                default:
                    zzb.zzb(parcel, zzaT);
                    dataSet2 = dataSet;
                    session2 = session;
                    i2 = i;
                    break;
            }
            i = i2;
            session = session2;
            dataSet = dataSet2;
        }
        if (parcel.dataPosition() == zzaU) {
            return new zzac(i, session, dataSet);
        }
        throw new zza("Overread allowed size end=" + zzaU, parcel);
    }

    public zzac[] zzgO(int i) {
        return new zzac[i];
    }
}
