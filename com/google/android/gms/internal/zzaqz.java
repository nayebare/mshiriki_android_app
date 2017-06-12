package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.common.internal.safeparcel.zzb.zza;
import com.google.android.gms.common.internal.safeparcel.zzc;
import com.google.android.gms.wallet.WalletConstants.CardNetwork;
import com.google.android.gms.wallet.fragment.WalletFragmentStyle.Dimension;
import com.google.android.gms.wearable.ChannelApi.ChannelListener;
import com.google.android.gms.wearable.MessageApi;

public class zzaqz implements Creator<zzaqy> {
    static void zza(zzaqy com_google_android_gms_internal_zzaqy, Parcel parcel, int i) {
        int zzaV = zzc.zzaV(parcel);
        zzc.zza(parcel, 1, com_google_android_gms_internal_zzaqy.zzGV(), false);
        zzc.zza(parcel, 2, com_google_android_gms_internal_zzaqy.zzGW(), false);
        zzc.zza(parcel, 3, com_google_android_gms_internal_zzaqy.zzGY(), false);
        zzc.zza(parcel, 4, com_google_android_gms_internal_zzaqy.zzGX(), false);
        zzc.zzc(parcel, CardNetwork.OTHER, com_google_android_gms_internal_zzaqy.versionCode);
        zzc.zzJ(parcel, zzaV);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzgw(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzjN(i);
    }

    public zzaqy zzgw(Parcel parcel) {
        String[] strArr = null;
        int zzaU = zzb.zzaU(parcel);
        int i = 0;
        String[] strArr2 = null;
        String[] strArr3 = null;
        String[] strArr4 = null;
        while (parcel.dataPosition() < zzaU) {
            int zzaT = zzb.zzaT(parcel);
            switch (zzb.zzcW(zzaT)) {
                case MessageApi.FILTER_PREFIX /*1*/:
                    strArr4 = zzb.zzC(parcel, zzaT);
                    break;
                case ChannelListener.CLOSE_REASON_REMOTE_CLOSE /*2*/:
                    strArr3 = zzb.zzC(parcel, zzaT);
                    break;
                case ChannelListener.CLOSE_REASON_LOCAL_CLOSE /*3*/:
                    strArr = zzb.zzC(parcel, zzaT);
                    break;
                case Dimension.UNIT_IN /*4*/:
                    strArr2 = zzb.zzC(parcel, zzaT);
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
            return new zzaqy(i, strArr4, strArr3, strArr2, strArr);
        }
        throw new zza("Overread allowed size end=" + zzaU, parcel);
    }

    public zzaqy[] zzjN(int i) {
        return new zzaqy[i];
    }
}
