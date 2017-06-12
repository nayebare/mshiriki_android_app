package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.common.internal.safeparcel.zzb.zza;
import com.google.android.gms.common.internal.safeparcel.zzc;
import com.google.android.gms.wallet.fragment.WalletFragmentStyle.Dimension;
import com.google.android.gms.wearable.ChannelApi.ChannelListener;
import com.google.android.gms.wearable.MessageApi;

public class zzafo implements Creator<zzafn> {
    static void zza(zzafn com_google_android_gms_internal_zzafn, Parcel parcel, int i) {
        int zzaV = zzc.zzaV(parcel);
        zzc.zzc(parcel, 1, com_google_android_gms_internal_zzafn.versionCode);
        zzc.zzc(parcel, 2, com_google_android_gms_internal_zzafn.zzaIV);
        zzc.zzc(parcel, 3, com_google_android_gms_internal_zzafn.limit);
        zzc.zza(parcel, 4, com_google_android_gms_internal_zzafn.zzaIW, false);
        zzc.zzJ(parcel, zzaV);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzbC(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzdN(i);
    }

    public zzafn zzbC(Parcel parcel) {
        int i = 0;
        int zzaU = zzb.zzaU(parcel);
        int[] iArr = null;
        int i2 = 0;
        int i3 = 0;
        while (parcel.dataPosition() < zzaU) {
            int zzaT = zzb.zzaT(parcel);
            switch (zzb.zzcW(zzaT)) {
                case MessageApi.FILTER_PREFIX /*1*/:
                    i3 = zzb.zzg(parcel, zzaT);
                    break;
                case ChannelListener.CLOSE_REASON_REMOTE_CLOSE /*2*/:
                    i2 = zzb.zzg(parcel, zzaT);
                    break;
                case ChannelListener.CLOSE_REASON_LOCAL_CLOSE /*3*/:
                    i = zzb.zzg(parcel, zzaT);
                    break;
                case Dimension.UNIT_IN /*4*/:
                    iArr = zzb.zzw(parcel, zzaT);
                    break;
                default:
                    zzb.zzb(parcel, zzaT);
                    break;
            }
        }
        if (parcel.dataPosition() == zzaU) {
            return new zzafn(i3, i2, i, iArr);
        }
        throw new zza("Overread allowed size end=" + zzaU, parcel);
    }

    public zzafn[] zzdN(int i) {
        return new zzafn[i];
    }
}
