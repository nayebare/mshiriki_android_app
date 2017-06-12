package com.google.android.gms.fitness.result;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.common.internal.safeparcel.zzb.zza;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.wallet.WalletConstants.CardNetwork;
import com.google.android.gms.wallet.fragment.WalletFragmentStyle.BuyButtonText;
import com.google.android.gms.wallet.fragment.WalletFragmentStyle.Dimension;
import com.google.android.gms.wearable.ChannelApi.ChannelListener;
import com.google.android.gms.wearable.MessageApi;
import java.util.ArrayList;
import java.util.List;

public class zzc implements Creator<DataReadResult> {
    static void zza(DataReadResult dataReadResult, Parcel parcel, int i) {
        int zzaV = com.google.android.gms.common.internal.safeparcel.zzc.zzaV(parcel);
        com.google.android.gms.common.internal.safeparcel.zzc.zzd(parcel, 1, dataReadResult.zzCE(), false);
        com.google.android.gms.common.internal.safeparcel.zzc.zza(parcel, 2, dataReadResult.getStatus(), i, false);
        com.google.android.gms.common.internal.safeparcel.zzc.zzd(parcel, 3, dataReadResult.zzCD(), false);
        com.google.android.gms.common.internal.safeparcel.zzc.zzc(parcel, 5, dataReadResult.zzCC());
        com.google.android.gms.common.internal.safeparcel.zzc.zzc(parcel, 6, dataReadResult.zzBr(), false);
        com.google.android.gms.common.internal.safeparcel.zzc.zzc(parcel, 7, dataReadResult.zzCF(), false);
        com.google.android.gms.common.internal.safeparcel.zzc.zzc(parcel, CardNetwork.OTHER, dataReadResult.getVersionCode());
        com.google.android.gms.common.internal.safeparcel.zzc.zzJ(parcel, zzaV);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzfc(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzhL(i);
    }

    public DataReadResult zzfc(Parcel parcel) {
        int i = 0;
        List list = null;
        int zzaU = zzb.zzaU(parcel);
        List arrayList = new ArrayList();
        List arrayList2 = new ArrayList();
        List list2 = null;
        Status status = null;
        int i2 = 0;
        while (parcel.dataPosition() < zzaU) {
            int zzaT = zzb.zzaT(parcel);
            switch (zzb.zzcW(zzaT)) {
                case MessageApi.FILTER_PREFIX /*1*/:
                    zzb.zza(parcel, zzaT, arrayList, getClass().getClassLoader());
                    break;
                case ChannelListener.CLOSE_REASON_REMOTE_CLOSE /*2*/:
                    status = (Status) zzb.zza(parcel, zzaT, Status.CREATOR);
                    break;
                case ChannelListener.CLOSE_REASON_LOCAL_CLOSE /*3*/:
                    zzb.zza(parcel, zzaT, arrayList2, getClass().getClassLoader());
                    break;
                case Dimension.UNIT_MM /*5*/:
                    i = zzb.zzg(parcel, zzaT);
                    break;
                case BuyButtonText.LOGO_ONLY /*6*/:
                    list2 = zzb.zzc(parcel, zzaT, DataSource.CREATOR);
                    break;
                case BuyButtonText.DONATE_WITH /*7*/:
                    list = zzb.zzc(parcel, zzaT, DataType.CREATOR);
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
            return new DataReadResult(i2, arrayList, status, arrayList2, i, list2, list);
        }
        throw new zza("Overread allowed size end=" + zzaU, parcel);
    }

    public DataReadResult[] zzhL(int i) {
        return new DataReadResult[i];
    }
}
