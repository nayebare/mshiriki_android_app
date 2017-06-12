package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.common.internal.safeparcel.zzc;
import com.google.android.gms.internal.zzafk.zza;
import com.google.android.gms.wallet.fragment.WalletFragmentStyle.Dimension;
import com.google.android.gms.wearable.ChannelApi.ChannelListener;
import com.google.android.gms.wearable.MessageApi;

public class zzafm implements Creator<zza> {
    static void zza(zza com_google_android_gms_internal_zzafk_zza, Parcel parcel, int i) {
        int zzaV = zzc.zzaV(parcel);
        zzc.zzc(parcel, 1, com_google_android_gms_internal_zzafk_zza.versionCode);
        zzc.zza(parcel, 2, com_google_android_gms_internal_zzafk_zza.zzaIS, false);
        zzc.zza(parcel, 3, com_google_android_gms_internal_zzafk_zza.zzaIT, false);
        zzc.zza(parcel, 4, com_google_android_gms_internal_zzafk_zza.zzaIU, false);
        zzc.zzJ(parcel, zzaV);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzbB(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzdM(i);
    }

    public zza zzbB(Parcel parcel) {
        String[] strArr = null;
        int zzaU = zzb.zzaU(parcel);
        int i = 0;
        String[] strArr2 = null;
        String[] strArr3 = null;
        while (parcel.dataPosition() < zzaU) {
            int zzaT = zzb.zzaT(parcel);
            switch (zzb.zzcW(zzaT)) {
                case MessageApi.FILTER_PREFIX /*1*/:
                    i = zzb.zzg(parcel, zzaT);
                    break;
                case ChannelListener.CLOSE_REASON_REMOTE_CLOSE /*2*/:
                    strArr3 = zzb.zzC(parcel, zzaT);
                    break;
                case ChannelListener.CLOSE_REASON_LOCAL_CLOSE /*3*/:
                    strArr2 = zzb.zzC(parcel, zzaT);
                    break;
                case Dimension.UNIT_IN /*4*/:
                    strArr = zzb.zzC(parcel, zzaT);
                    break;
                default:
                    zzb.zzb(parcel, zzaT);
                    break;
            }
        }
        if (parcel.dataPosition() == zzaU) {
            return new zza(i, strArr3, strArr2, strArr);
        }
        throw new zzb.zza("Overread allowed size end=" + zzaU, parcel);
    }

    public zza[] zzdM(int i) {
        return new zza[i];
    }
}
