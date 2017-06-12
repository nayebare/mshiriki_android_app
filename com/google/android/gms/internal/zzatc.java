package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.common.internal.safeparcel.zzb.zza;
import com.google.android.gms.common.internal.safeparcel.zzc;
import com.google.android.gms.wallet.fragment.WalletFragmentStyle.Dimension;
import com.google.android.gms.wearable.ChannelApi.ChannelListener;
import com.google.android.gms.wearable.MessageApi;

public class zzatc implements Creator<zzatb> {
    static void zza(zzatb com_google_android_gms_internal_zzatb, Parcel parcel, int i) {
        int zzaV = zzc.zzaV(parcel);
        zzc.zzc(parcel, 1, com_google_android_gms_internal_zzatb.versionCode);
        zzc.zza(parcel, 2, com_google_android_gms_internal_zzatb.name, false);
        zzc.zza(parcel, 3, com_google_android_gms_internal_zzatb.zzbqP, i, false);
        zzc.zza(parcel, 4, com_google_android_gms_internal_zzatb.zzbqQ, false);
        zzc.zza(parcel, 5, com_google_android_gms_internal_zzatb.zzbqR);
        zzc.zzJ(parcel, zzaV);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzhM(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzlr(i);
    }

    public zzatb zzhM(Parcel parcel) {
        String str = null;
        int zzaU = zzb.zzaU(parcel);
        int i = 0;
        long j = 0;
        zzasz com_google_android_gms_internal_zzasz = null;
        String str2 = null;
        while (parcel.dataPosition() < zzaU) {
            int zzaT = zzb.zzaT(parcel);
            switch (zzb.zzcW(zzaT)) {
                case MessageApi.FILTER_PREFIX /*1*/:
                    i = zzb.zzg(parcel, zzaT);
                    break;
                case ChannelListener.CLOSE_REASON_REMOTE_CLOSE /*2*/:
                    str2 = zzb.zzq(parcel, zzaT);
                    break;
                case ChannelListener.CLOSE_REASON_LOCAL_CLOSE /*3*/:
                    com_google_android_gms_internal_zzasz = (zzasz) zzb.zza(parcel, zzaT, zzasz.CREATOR);
                    break;
                case Dimension.UNIT_IN /*4*/:
                    str = zzb.zzq(parcel, zzaT);
                    break;
                case Dimension.UNIT_MM /*5*/:
                    j = zzb.zzi(parcel, zzaT);
                    break;
                default:
                    zzb.zzb(parcel, zzaT);
                    break;
            }
        }
        if (parcel.dataPosition() == zzaU) {
            return new zzatb(i, str2, com_google_android_gms_internal_zzasz, str, j);
        }
        throw new zza("Overread allowed size end=" + zzaU, parcel);
    }

    public zzatb[] zzlr(int i) {
        return new zzatb[i];
    }
}
