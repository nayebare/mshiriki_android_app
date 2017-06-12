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

public class zzavf implements Creator<zzave> {
    static void zza(zzave com_google_android_gms_internal_zzave, Parcel parcel, int i) {
        int zzaV = zzc.zzaV(parcel);
        zzc.zza(parcel, 1, com_google_android_gms_internal_zzave.zzMS(), false);
        zzc.zza(parcel, 2, com_google_android_gms_internal_zzave.getCallbackBinder(), false);
        zzc.zza(parcel, 3, com_google_android_gms_internal_zzave.zzMP());
        zzc.zzc(parcel, CardNetwork.OTHER, com_google_android_gms_internal_zzave.versionCode);
        zzc.zzJ(parcel, zzaV);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzhV(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzlB(i);
    }

    public zzave zzhV(Parcel parcel) {
        IBinder iBinder = null;
        byte b = (byte) 0;
        int zzaU = zzb.zzaU(parcel);
        IBinder iBinder2 = null;
        int i = 0;
        while (parcel.dataPosition() < zzaU) {
            int zzaT = zzb.zzaT(parcel);
            switch (zzb.zzcW(zzaT)) {
                case MessageApi.FILTER_PREFIX /*1*/:
                    iBinder2 = zzb.zzr(parcel, zzaT);
                    break;
                case ChannelListener.CLOSE_REASON_REMOTE_CLOSE /*2*/:
                    iBinder = zzb.zzr(parcel, zzaT);
                    break;
                case ChannelListener.CLOSE_REASON_LOCAL_CLOSE /*3*/:
                    b = zzb.zze(parcel, zzaT);
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
            return new zzave(i, b, iBinder2, iBinder);
        }
        throw new zza("Overread allowed size end=" + zzaU, parcel);
    }

    public zzave[] zzlB(int i) {
        return new zzave[i];
    }
}
