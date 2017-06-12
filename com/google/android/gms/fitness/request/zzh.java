package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.common.internal.safeparcel.zzb.zza;
import com.google.android.gms.common.internal.safeparcel.zzc;
import com.google.android.gms.fitness.data.DataSet;
import com.google.android.gms.wallet.WalletConstants.CardNetwork;
import com.google.android.gms.wallet.fragment.WalletFragmentStyle.Dimension;
import com.google.android.gms.wearable.ChannelApi.ChannelListener;
import com.google.android.gms.wearable.MessageApi;

public class zzh implements Creator<zzg> {
    static void zza(zzg com_google_android_gms_fitness_request_zzg, Parcel parcel, int i) {
        int zzaV = zzc.zzaV(parcel);
        zzc.zza(parcel, 1, com_google_android_gms_fitness_request_zzg.getDataSet(), i, false);
        zzc.zza(parcel, 2, com_google_android_gms_fitness_request_zzg.getCallbackBinder(), false);
        zzc.zza(parcel, 4, com_google_android_gms_fitness_request_zzg.zzCc());
        zzc.zzc(parcel, CardNetwork.OTHER, com_google_android_gms_fitness_request_zzg.getVersionCode());
        zzc.zzJ(parcel, zzaV);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzeq(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzgZ(i);
    }

    public zzg zzeq(Parcel parcel) {
        IBinder iBinder = null;
        boolean z = false;
        int zzaU = zzb.zzaU(parcel);
        DataSet dataSet = null;
        int i = 0;
        while (parcel.dataPosition() < zzaU) {
            int i2;
            DataSet dataSet2;
            boolean z2;
            IBinder iBinder2;
            int zzaT = zzb.zzaT(parcel);
            boolean z3;
            switch (zzb.zzcW(zzaT)) {
                case MessageApi.FILTER_PREFIX /*1*/:
                    i2 = i;
                    IBinder iBinder3 = iBinder;
                    dataSet2 = (DataSet) zzb.zza(parcel, zzaT, DataSet.CREATOR);
                    z2 = z;
                    iBinder2 = iBinder3;
                    break;
                case ChannelListener.CLOSE_REASON_REMOTE_CLOSE /*2*/:
                    dataSet2 = dataSet;
                    i2 = i;
                    z3 = z;
                    iBinder2 = zzb.zzr(parcel, zzaT);
                    z2 = z3;
                    break;
                case Dimension.UNIT_IN /*4*/:
                    z2 = zzb.zzc(parcel, zzaT);
                    iBinder2 = iBinder;
                    dataSet2 = dataSet;
                    i2 = i;
                    break;
                case CardNetwork.OTHER /*1000*/:
                    z3 = z;
                    iBinder2 = iBinder;
                    dataSet2 = dataSet;
                    i2 = zzb.zzg(parcel, zzaT);
                    z2 = z3;
                    break;
                default:
                    zzb.zzb(parcel, zzaT);
                    z2 = z;
                    iBinder2 = iBinder;
                    dataSet2 = dataSet;
                    i2 = i;
                    break;
            }
            i = i2;
            dataSet = dataSet2;
            iBinder = iBinder2;
            z = z2;
        }
        if (parcel.dataPosition() == zzaU) {
            return new zzg(i, dataSet, iBinder, z);
        }
        throw new zza("Overread allowed size end=" + zzaU, parcel);
    }

    public zzg[] zzgZ(int i) {
        return new zzg[i];
    }
}
