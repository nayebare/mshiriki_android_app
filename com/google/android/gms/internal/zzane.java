package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.common.internal.safeparcel.zzb.zza;
import com.google.android.gms.common.internal.safeparcel.zzc;
import com.google.android.gms.wallet.fragment.WalletFragmentStyle.Dimension;
import com.google.android.gms.wearable.ChannelApi.ChannelListener;
import com.google.android.gms.wearable.MessageApi;

public class zzane implements Creator<zzand> {
    static void zza(zzand com_google_android_gms_internal_zzand, Parcel parcel, int i) {
        int zzaV = zzc.zzaV(parcel);
        zzc.zzc(parcel, 1, com_google_android_gms_internal_zzand.mVersionCode);
        zzc.zzc(parcel, 2, com_google_android_gms_internal_zzand.mIndex);
        zzc.zzc(parcel, 3, com_google_android_gms_internal_zzand.zzaPv);
        zzc.zzc(parcel, 4, com_google_android_gms_internal_zzand.zzaPw);
        zzc.zzJ(parcel, zzaV);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzdM(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzgj(i);
    }

    public zzand zzdM(Parcel parcel) {
        int i = 0;
        int zzaU = zzb.zzaU(parcel);
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        while (parcel.dataPosition() < zzaU) {
            int zzaT = zzb.zzaT(parcel);
            switch (zzb.zzcW(zzaT)) {
                case MessageApi.FILTER_PREFIX /*1*/:
                    i4 = zzb.zzg(parcel, zzaT);
                    break;
                case ChannelListener.CLOSE_REASON_REMOTE_CLOSE /*2*/:
                    i3 = zzb.zzg(parcel, zzaT);
                    break;
                case ChannelListener.CLOSE_REASON_LOCAL_CLOSE /*3*/:
                    i2 = zzb.zzg(parcel, zzaT);
                    break;
                case Dimension.UNIT_IN /*4*/:
                    i = zzb.zzg(parcel, zzaT);
                    break;
                default:
                    zzb.zzb(parcel, zzaT);
                    break;
            }
        }
        if (parcel.dataPosition() == zzaU) {
            return new zzand(i4, i3, i2, i);
        }
        throw new zza("Overread allowed size end=" + zzaU, parcel);
    }

    public zzand[] zzgj(int i) {
        return new zzand[i];
    }
}
