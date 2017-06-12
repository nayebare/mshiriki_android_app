package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.common.internal.safeparcel.zzb.zza;
import com.google.android.gms.common.internal.safeparcel.zzc;
import com.google.android.gms.wallet.fragment.WalletFragmentStyle.Dimension;
import com.google.android.gms.wearable.ChannelApi.ChannelListener;
import com.google.android.gms.wearable.MessageApi;

public class zzami implements Creator<zzamh> {
    static void zza(zzamh com_google_android_gms_internal_zzamh, Parcel parcel, int i) {
        int zzaV = zzc.zzaV(parcel);
        zzc.zzc(parcel, 1, com_google_android_gms_internal_zzamh.mVersionCode);
        zzc.zza(parcel, 2, com_google_android_gms_internal_zzamh.zzaPr, false);
        zzc.zzc(parcel, 3, com_google_android_gms_internal_zzamh.mIndex);
        zzc.zza(parcel, 4, com_google_android_gms_internal_zzamh.zzaPs);
        zzc.zzc(parcel, 5, com_google_android_gms_internal_zzamh.zzaPt);
        zzc.zzJ(parcel, zzaV);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzdB(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzfY(i);
    }

    public zzamh zzdB(Parcel parcel) {
        boolean z = false;
        int zzaU = zzb.zzaU(parcel);
        String str = null;
        int i = -1;
        int i2 = 0;
        int i3 = 0;
        while (parcel.dataPosition() < zzaU) {
            int zzaT = zzb.zzaT(parcel);
            switch (zzb.zzcW(zzaT)) {
                case MessageApi.FILTER_PREFIX /*1*/:
                    i3 = zzb.zzg(parcel, zzaT);
                    break;
                case ChannelListener.CLOSE_REASON_REMOTE_CLOSE /*2*/:
                    str = zzb.zzq(parcel, zzaT);
                    break;
                case ChannelListener.CLOSE_REASON_LOCAL_CLOSE /*3*/:
                    i2 = zzb.zzg(parcel, zzaT);
                    break;
                case Dimension.UNIT_IN /*4*/:
                    z = zzb.zzc(parcel, zzaT);
                    break;
                case Dimension.UNIT_MM /*5*/:
                    i = zzb.zzg(parcel, zzaT);
                    break;
                default:
                    zzb.zzb(parcel, zzaT);
                    break;
            }
        }
        if (parcel.dataPosition() == zzaU) {
            return new zzamh(i3, str, i2, z, i);
        }
        throw new zza("Overread allowed size end=" + zzaU, parcel);
    }

    public zzamh[] zzfY(int i) {
        return new zzamh[i];
    }
}
