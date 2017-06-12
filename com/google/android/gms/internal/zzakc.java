package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.common.internal.safeparcel.zzb.zza;
import com.google.android.gms.common.internal.safeparcel.zzc;
import com.google.android.gms.wallet.fragment.WalletFragmentStyle.Dimension;
import com.google.android.gms.wearable.ChannelApi.ChannelListener;
import com.google.android.gms.wearable.MessageApi;

public class zzakc implements Creator<zzakb> {
    static void zza(zzakb com_google_android_gms_internal_zzakb, Parcel parcel, int i) {
        int zzaV = zzc.zzaV(parcel);
        zzc.zzc(parcel, 1, com_google_android_gms_internal_zzakb.mVersionCode);
        zzc.zzc(parcel, 2, com_google_android_gms_internal_zzakb.zzaMm);
        zzc.zzc(parcel, 3, com_google_android_gms_internal_zzakb.zzaMn);
        zzc.zza(parcel, 4, com_google_android_gms_internal_zzakb.zzaNa);
        zzc.zzJ(parcel, zzaV);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzcP(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzfl(i);
    }

    public zzakb zzcP(Parcel parcel) {
        boolean z = false;
        int zzaU = zzb.zzaU(parcel);
        int i = 0;
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
                    z = zzb.zzc(parcel, zzaT);
                    break;
                default:
                    zzb.zzb(parcel, zzaT);
                    break;
            }
        }
        if (parcel.dataPosition() == zzaU) {
            return new zzakb(i3, i2, i, z);
        }
        throw new zza("Overread allowed size end=" + zzaU, parcel);
    }

    public zzakb[] zzfl(int i) {
        return new zzakb[i];
    }
}
