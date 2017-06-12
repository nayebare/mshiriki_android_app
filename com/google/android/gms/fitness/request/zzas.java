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
import java.util.List;

public class zzas implements Creator<zzar> {
    static void zza(zzar com_google_android_gms_fitness_request_zzar, Parcel parcel, int i) {
        int zzaV = zzc.zzaV(parcel);
        zzc.zza(parcel, 1, com_google_android_gms_fitness_request_zzar.getCallbackBinder(), false);
        zzc.zzc(parcel, 3, com_google_android_gms_fitness_request_zzar.zzCo(), false);
        zzc.zza(parcel, 4, com_google_android_gms_fitness_request_zzar.zzCe());
        zzc.zza(parcel, 5, com_google_android_gms_fitness_request_zzar.zzCd());
        zzc.zzc(parcel, CardNetwork.OTHER, com_google_android_gms_fitness_request_zzar.getVersionCode());
        zzc.zzJ(parcel, zzaV);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzeK(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzht(i);
    }

    public zzar zzeK(Parcel parcel) {
        List list = null;
        boolean z = false;
        int zzaU = zzb.zzaU(parcel);
        boolean z2 = false;
        IBinder iBinder = null;
        int i = 0;
        while (parcel.dataPosition() < zzaU) {
            int zzaT = zzb.zzaT(parcel);
            switch (zzb.zzcW(zzaT)) {
                case MessageApi.FILTER_PREFIX /*1*/:
                    iBinder = zzb.zzr(parcel, zzaT);
                    break;
                case ChannelListener.CLOSE_REASON_LOCAL_CLOSE /*3*/:
                    list = zzb.zzc(parcel, zzaT, zzj.CREATOR);
                    break;
                case Dimension.UNIT_IN /*4*/:
                    z2 = zzb.zzc(parcel, zzaT);
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
            return new zzar(i, iBinder, list, z2, z);
        }
        throw new zza("Overread allowed size end=" + zzaU, parcel);
    }

    public zzar[] zzht(int i) {
        return new zzar[i];
    }
}
