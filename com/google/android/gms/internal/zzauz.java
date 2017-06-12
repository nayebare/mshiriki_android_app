package com.google.android.gms.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.common.internal.safeparcel.zzb.zza;
import com.google.android.gms.common.internal.safeparcel.zzc;
import com.google.android.gms.wallet.WalletConstants.CardNetwork;
import com.google.android.gms.wearable.ChannelApi.ChannelListener;
import com.google.android.gms.wearable.MessageApi;

public class zzauz implements Creator<zzauy> {
    static void zza(zzauy com_google_android_gms_internal_zzauy, Parcel parcel, int i) {
        int zzaV = zzc.zzaV(parcel);
        zzc.zza(parcel, 1, com_google_android_gms_internal_zzauy.zzMM(), i, false);
        zzc.zza(parcel, 2, com_google_android_gms_internal_zzauy.getCallbackBinder(), false);
        zzc.zzc(parcel, CardNetwork.OTHER, com_google_android_gms_internal_zzauy.versionCode);
        zzc.zzJ(parcel, zzaV);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzhS(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzly(i);
    }

    public zzauy zzhS(Parcel parcel) {
        IBinder iBinder = null;
        int zzaU = zzb.zzaU(parcel);
        int i = 0;
        zzauj com_google_android_gms_internal_zzauj = null;
        while (parcel.dataPosition() < zzaU) {
            int i2;
            IBinder iBinder2;
            zzauj com_google_android_gms_internal_zzauj2;
            int zzaT = zzb.zzaT(parcel);
            switch (zzb.zzcW(zzaT)) {
                case MessageApi.FILTER_PREFIX /*1*/:
                    i2 = i;
                    zzauj com_google_android_gms_internal_zzauj3 = (zzauj) zzb.zza(parcel, zzaT, zzauj.CREATOR);
                    iBinder2 = iBinder;
                    com_google_android_gms_internal_zzauj2 = com_google_android_gms_internal_zzauj3;
                    break;
                case ChannelListener.CLOSE_REASON_REMOTE_CLOSE /*2*/:
                    iBinder2 = zzb.zzr(parcel, zzaT);
                    com_google_android_gms_internal_zzauj2 = com_google_android_gms_internal_zzauj;
                    i2 = i;
                    break;
                case CardNetwork.OTHER /*1000*/:
                    IBinder iBinder3 = iBinder;
                    com_google_android_gms_internal_zzauj2 = com_google_android_gms_internal_zzauj;
                    i2 = zzb.zzg(parcel, zzaT);
                    iBinder2 = iBinder3;
                    break;
                default:
                    zzb.zzb(parcel, zzaT);
                    iBinder2 = iBinder;
                    com_google_android_gms_internal_zzauj2 = com_google_android_gms_internal_zzauj;
                    i2 = i;
                    break;
            }
            i = i2;
            com_google_android_gms_internal_zzauj = com_google_android_gms_internal_zzauj2;
            iBinder = iBinder2;
        }
        if (parcel.dataPosition() == zzaU) {
            return new zzauy(i, com_google_android_gms_internal_zzauj, iBinder);
        }
        throw new zza("Overread allowed size end=" + zzaU, parcel);
    }

    public zzauy[] zzly(int i) {
        return new zzauy[i];
    }
}
