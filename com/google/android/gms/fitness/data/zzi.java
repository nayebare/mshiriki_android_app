package com.google.android.gms.fitness.data;

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

public class zzi implements Creator<DataSet> {
    static void zza(DataSet dataSet, Parcel parcel, int i) {
        int zzaV = zzc.zzaV(parcel);
        zzc.zza(parcel, 1, dataSet.getDataSource(), i, false);
        zzc.zza(parcel, 2, dataSet.getDataType(), i, false);
        zzc.zzd(parcel, 3, dataSet.zzBq(), false);
        zzc.zzc(parcel, 4, dataSet.zzBr(), false);
        zzc.zza(parcel, 5, dataSet.zzBh());
        zzc.zzc(parcel, CardNetwork.OTHER, dataSet.getVersionCode());
        zzc.zzJ(parcel, zzaV);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzdR(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzgs(i);
    }

    public DataSet zzdR(Parcel parcel) {
        boolean z = false;
        List list = null;
        int zzaU = zzb.zzaU(parcel);
        List arrayList = new ArrayList();
        DataType dataType = null;
        DataSource dataSource = null;
        int i = 0;
        while (parcel.dataPosition() < zzaU) {
            int zzaT = zzb.zzaT(parcel);
            switch (zzb.zzcW(zzaT)) {
                case MessageApi.FILTER_PREFIX /*1*/:
                    dataSource = (DataSource) zzb.zza(parcel, zzaT, DataSource.CREATOR);
                    break;
                case ChannelListener.CLOSE_REASON_REMOTE_CLOSE /*2*/:
                    dataType = (DataType) zzb.zza(parcel, zzaT, DataType.CREATOR);
                    break;
                case ChannelListener.CLOSE_REASON_LOCAL_CLOSE /*3*/:
                    zzb.zza(parcel, zzaT, arrayList, getClass().getClassLoader());
                    break;
                case Dimension.UNIT_IN /*4*/:
                    list = zzb.zzc(parcel, zzaT, DataSource.CREATOR);
                    break;
                case Dimension.UNIT_MM /*5*/:
                    z = zzb.zzc(parcel, zzaT);
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
            return new DataSet(i, dataSource, dataType, arrayList, list, z);
        }
        throw new zza("Overread allowed size end=" + zzaU, parcel);
    }

    public DataSet[] zzgs(int i) {
        return new DataSet[i];
    }
}
