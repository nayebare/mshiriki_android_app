package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.common.internal.safeparcel.zzb.zza;
import com.google.android.gms.common.internal.safeparcel.zzc;
import com.google.android.gms.wallet.WalletConstants.CardNetwork;
import com.google.android.gms.wearable.ChannelApi.ChannelListener;
import com.google.android.gms.wearable.MessageApi;

public class zzavs implements Creator<zzavr> {
    static void zza(zzavr com_google_android_gms_internal_zzavr, Parcel parcel, int i) {
        int zzaV = zzc.zzaV(parcel);
        zzc.zzc(parcel, 1, com_google_android_gms_internal_zzavr.zzbyl);
        zzc.zza(parcel, 2, com_google_android_gms_internal_zzavr.zzbym, false);
        zzc.zza(parcel, 3, com_google_android_gms_internal_zzavr.zzbyn);
        zzc.zzc(parcel, CardNetwork.OTHER, com_google_android_gms_internal_zzavr.mVersionCode);
        zzc.zzJ(parcel, zzaV);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzie(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzlT(i);
    }

    public zzavr zzie(Parcel parcel) {
        boolean z = false;
        int zzaU = zzb.zzaU(parcel);
        byte[] bArr = null;
        int i = 0;
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
                case ChannelListener.CLOSE_REASON_LOCAL_CLOSE /*3*/:
                    z = zzb.zzc(parcel, zzaT);
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
            return new zzavr(i2, i, bArr, z);
        }
        throw new zza("Overread allowed size end=" + zzaU, parcel);
    }

    public zzavr[] zzlT(int i) {
        return new zzavr[i];
    }
}
