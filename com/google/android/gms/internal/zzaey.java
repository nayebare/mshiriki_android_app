package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.common.internal.safeparcel.zzc;
import com.google.android.gms.internal.zzaex.zza;
import com.google.android.gms.wallet.fragment.WalletFragmentStyle.Dimension;
import com.google.android.gms.wearable.ChannelApi.ChannelListener;
import com.google.android.gms.wearable.MessageApi;

public class zzaey implements Creator<zza> {
    static void zza(zza com_google_android_gms_internal_zzaex_zza, Parcel parcel, int i) {
        int zzaV = zzc.zzaV(parcel);
        zzc.zzc(parcel, 1, com_google_android_gms_internal_zzaex_zza.versionCode);
        zzc.zzc(parcel, 2, com_google_android_gms_internal_zzaex_zza.zzaIp);
        zzc.zzc(parcel, 3, com_google_android_gms_internal_zzaex_zza.name);
        zzc.zza(parcel, 4, com_google_android_gms_internal_zzaex_zza.zzaIq, i, false);
        zzc.zza(parcel, 5, com_google_android_gms_internal_zzaex_zza.zzaIr, i, false);
        zzc.zzJ(parcel, zzaV);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzbw(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzdH(i);
    }

    public zza zzbw(Parcel parcel) {
        zzafk com_google_android_gms_internal_zzafk = null;
        int i = 0;
        int zzaU = zzb.zzaU(parcel);
        zzafs com_google_android_gms_internal_zzafs = null;
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
                    com_google_android_gms_internal_zzafs = (zzafs) zzb.zza(parcel, zzaT, zzafs.CREATOR);
                    break;
                case Dimension.UNIT_MM /*5*/:
                    com_google_android_gms_internal_zzafk = (zzafk) zzb.zza(parcel, zzaT, zzafk.CREATOR);
                    break;
                default:
                    zzb.zzb(parcel, zzaT);
                    break;
            }
        }
        if (parcel.dataPosition() == zzaU) {
            return new zza(i3, i2, i, com_google_android_gms_internal_zzafs, com_google_android_gms_internal_zzafk);
        }
        throw new zzb.zza("Overread allowed size end=" + zzaU, parcel);
    }

    public zza[] zzdH(int i) {
        return new zza[i];
    }
}
