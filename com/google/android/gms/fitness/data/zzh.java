package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.common.internal.safeparcel.zzb.zza;
import com.google.android.gms.common.internal.safeparcel.zzc;
import com.google.android.gms.games.request.Requests;
import com.google.android.gms.wallet.WalletConstants.CardNetwork;
import com.google.android.gms.wallet.fragment.WalletFragmentStyle.BuyButtonText;
import com.google.android.gms.wallet.fragment.WalletFragmentStyle.Dimension;
import com.google.android.gms.wearable.ChannelApi.ChannelListener;
import com.google.android.gms.wearable.MessageApi;

public class zzh implements Creator<DataPoint> {
    static void zza(DataPoint dataPoint, Parcel parcel, int i) {
        int zzaV = zzc.zzaV(parcel);
        zzc.zza(parcel, 1, dataPoint.getDataSource(), i, false);
        zzc.zza(parcel, 3, dataPoint.getTimestampNanos());
        zzc.zza(parcel, 4, dataPoint.zzBp());
        zzc.zza(parcel, 5, dataPoint.zzBk(), i, false);
        zzc.zza(parcel, 6, dataPoint.zzBl(), i, false);
        zzc.zza(parcel, 7, dataPoint.zzBm());
        zzc.zzc(parcel, CardNetwork.OTHER, dataPoint.getVersionCode());
        zzc.zza(parcel, 8, dataPoint.zzBn());
        zzc.zzJ(parcel, zzaV);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzdQ(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzgr(i);
    }

    public DataPoint zzdQ(Parcel parcel) {
        int zzaU = zzb.zzaU(parcel);
        int i = 0;
        DataSource dataSource = null;
        long j = 0;
        long j2 = 0;
        Value[] valueArr = null;
        DataSource dataSource2 = null;
        long j3 = 0;
        long j4 = 0;
        while (parcel.dataPosition() < zzaU) {
            int zzaT = zzb.zzaT(parcel);
            switch (zzb.zzcW(zzaT)) {
                case MessageApi.FILTER_PREFIX /*1*/:
                    dataSource = (DataSource) zzb.zza(parcel, zzaT, DataSource.CREATOR);
                    break;
                case ChannelListener.CLOSE_REASON_LOCAL_CLOSE /*3*/:
                    j = zzb.zzi(parcel, zzaT);
                    break;
                case Dimension.UNIT_IN /*4*/:
                    j2 = zzb.zzi(parcel, zzaT);
                    break;
                case Dimension.UNIT_MM /*5*/:
                    valueArr = (Value[]) zzb.zzb(parcel, zzaT, Value.CREATOR);
                    break;
                case BuyButtonText.LOGO_ONLY /*6*/:
                    dataSource2 = (DataSource) zzb.zza(parcel, zzaT, DataSource.CREATOR);
                    break;
                case BuyButtonText.DONATE_WITH /*7*/:
                    j3 = zzb.zzi(parcel, zzaT);
                    break;
                case Requests.MAX_REQUEST_RECIPIENTS /*8*/:
                    j4 = zzb.zzi(parcel, zzaT);
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
            return new DataPoint(i, dataSource, j, j2, valueArr, dataSource2, j3, j4);
        }
        throw new zza("Overread allowed size end=" + zzaU, parcel);
    }

    public DataPoint[] zzgr(int i) {
        return new DataPoint[i];
    }
}
