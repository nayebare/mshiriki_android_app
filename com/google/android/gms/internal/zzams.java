package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.common.internal.safeparcel.zzb.zza;
import com.google.android.gms.common.internal.safeparcel.zzc;
import com.google.android.gms.wallet.fragment.WalletFragmentStyle.Dimension;
import com.google.android.gms.wearable.ChannelApi.ChannelListener;
import com.google.android.gms.wearable.MessageApi;

public class zzams implements Creator<zzamr> {
    static void zza(zzamr com_google_android_gms_internal_zzamr, Parcel parcel, int i) {
        int zzaV = zzc.zzaV(parcel);
        zzc.zzc(parcel, 1, com_google_android_gms_internal_zzamr.mVersionCode);
        zzc.zza(parcel, 2, com_google_android_gms_internal_zzamr.zzaPP, false);
        zzc.zza(parcel, 3, com_google_android_gms_internal_zzamr.zzaPQ, false);
        zzc.zzc(parcel, 4, com_google_android_gms_internal_zzamr.zzaPR);
        zzc.zzc(parcel, 5, com_google_android_gms_internal_zzamr.zzaPS);
        zzc.zzJ(parcel, zzaV);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzdG(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzgd(i);
    }

    public zzamr zzdG(Parcel parcel) {
        String str = null;
        int i = 0;
        int zzaU = zzb.zzaU(parcel);
        int i2 = 0;
        String str2 = null;
        int i3 = 0;
        while (parcel.dataPosition() < zzaU) {
            int zzaT = zzb.zzaT(parcel);
            switch (zzb.zzcW(zzaT)) {
                case MessageApi.FILTER_PREFIX /*1*/:
                    i3 = zzb.zzg(parcel, zzaT);
                    break;
                case ChannelListener.CLOSE_REASON_REMOTE_CLOSE /*2*/:
                    str2 = zzb.zzq(parcel, zzaT);
                    break;
                case ChannelListener.CLOSE_REASON_LOCAL_CLOSE /*3*/:
                    str = zzb.zzq(parcel, zzaT);
                    break;
                case Dimension.UNIT_IN /*4*/:
                    i2 = zzb.zzg(parcel, zzaT);
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
            return new zzamr(i3, str2, str, i2, i);
        }
        throw new zza("Overread allowed size end=" + zzaU, parcel);
    }

    public zzamr[] zzgd(int i) {
        return new zzamr[i];
    }
}
