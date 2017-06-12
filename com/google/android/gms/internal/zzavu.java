package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.common.internal.safeparcel.zzb.zza;
import com.google.android.gms.common.internal.safeparcel.zzc;
import com.google.android.gms.wallet.WalletConstants.CardNetwork;
import com.google.android.gms.wearable.ChannelApi.ChannelListener;
import com.google.android.gms.wearable.MessageApi;

public class zzavu implements Creator<zzavt> {
    static void zza(zzavt com_google_android_gms_internal_zzavt, Parcel parcel, int i) {
        int zzaV = zzc.zzaV(parcel);
        zzc.zzc(parcel, 1, com_google_android_gms_internal_zzavt.getType());
        zzc.zza(parcel, 2, com_google_android_gms_internal_zzavt.zzbyp, false);
        zzc.zzc(parcel, CardNetwork.OTHER, com_google_android_gms_internal_zzavt.mVersionCode);
        zzc.zzJ(parcel, zzaV);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzif(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzlU(i);
    }

    public zzavt zzif(Parcel parcel) {
        int i = 0;
        int zzaU = zzb.zzaU(parcel);
        byte[] bArr = null;
        int i2 = 0;
        while (parcel.dataPosition() < zzaU) {
            int zzaT = zzb.zzaT(parcel);
            switch (zzb.zzcW(zzaT)) {
                case MessageApi.FILTER_PREFIX /*1*/:
                    i = zzb.zzg(parcel, zzaT);
                    break;
                case ChannelListener.CLOSE_REASON_REMOTE_CLOSE /*2*/:
                    bArr = zzb.zzt(parcel, zzaT);
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
            return new zzavt(i2, i, bArr);
        }
        throw new zza("Overread allowed size end=" + zzaU, parcel);
    }

    public zzavt[] zzlU(int i) {
        return new zzavt[i];
    }
}
