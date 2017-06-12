package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.common.internal.safeparcel.zzb.zza;
import com.google.android.gms.common.internal.safeparcel.zzc;
import com.google.android.gms.wallet.fragment.WalletFragmentStyle.Dimension;
import com.google.android.gms.wearable.ChannelApi.ChannelListener;
import com.google.android.gms.wearable.MessageApi;

public class zzaej implements Creator<zzaei> {
    static void zza(zzaei com_google_android_gms_internal_zzaei, Parcel parcel, int i) {
        int zzaV = zzc.zzaV(parcel);
        zzc.zzc(parcel, 1, com_google_android_gms_internal_zzaei.versionCode);
        zzc.zzc(parcel, 2, com_google_android_gms_internal_zzaei.zzaHX);
        zzc.zza(parcel, 3, com_google_android_gms_internal_zzaei.zzaHY);
        zzc.zza(parcel, 4, com_google_android_gms_internal_zzaei.zzaHZ, false);
        zzc.zzc(parcel, 5, com_google_android_gms_internal_zzaei.zzaIa);
        zzc.zzJ(parcel, zzaV);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzbp(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzdA(i);
    }

    public zzaei zzbp(Parcel parcel) {
        int i = 0;
        int zzaU = zzb.zzaU(parcel);
        long j = 0;
        String str = null;
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
                    j = zzb.zzi(parcel, zzaT);
                    break;
                case Dimension.UNIT_IN /*4*/:
                    str = zzb.zzq(parcel, zzaT);
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
            return new zzaei(i3, i2, j, str, i);
        }
        throw new zza("Overread allowed size end=" + zzaU, parcel);
    }

    public zzaei[] zzdA(int i) {
        return new zzaei[i];
    }
}
