package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.common.internal.safeparcel.zzb.zza;
import com.google.android.gms.common.internal.safeparcel.zzc;
import com.google.android.gms.wallet.fragment.WalletFragmentStyle.Dimension;
import com.google.android.gms.wearable.ChannelApi.ChannelListener;
import com.google.android.gms.wearable.MessageApi;

public class zzaln implements Creator<zzalm> {
    static void zza(zzalm com_google_android_gms_internal_zzalm, Parcel parcel, int i) {
        int zzaV = zzc.zzaV(parcel);
        zzc.zzc(parcel, 1, com_google_android_gms_internal_zzalm.mVersionCode);
        zzc.zza(parcel, 2, com_google_android_gms_internal_zzalm.zzaPm);
        zzc.zza(parcel, 3, com_google_android_gms_internal_zzalm.mName, false);
        zzc.zza(parcel, 4, com_google_android_gms_internal_zzalm.zzaPn);
        zzc.zzJ(parcel, zzaV);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzdx(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzfT(i);
    }

    public zzalm zzdx(Parcel parcel) {
        boolean z = false;
        int zzaU = zzb.zzaU(parcel);
        String str = null;
        boolean z2 = true;
        int i = 0;
        while (parcel.dataPosition() < zzaU) {
            int zzaT = zzb.zzaT(parcel);
            switch (zzb.zzcW(zzaT)) {
                case MessageApi.FILTER_PREFIX /*1*/:
                    i = zzb.zzg(parcel, zzaT);
                    break;
                case ChannelListener.CLOSE_REASON_REMOTE_CLOSE /*2*/:
                    z = zzb.zzc(parcel, zzaT);
                    break;
                case ChannelListener.CLOSE_REASON_LOCAL_CLOSE /*3*/:
                    str = zzb.zzq(parcel, zzaT);
                    break;
                case Dimension.UNIT_IN /*4*/:
                    z2 = zzb.zzc(parcel, zzaT);
                    break;
                default:
                    zzb.zzb(parcel, zzaT);
                    break;
            }
        }
        if (parcel.dataPosition() == zzaU) {
            return new zzalm(i, z, str, z2);
        }
        throw new zza("Overread allowed size end=" + zzaU, parcel);
    }

    public zzalm[] zzfT(int i) {
        return new zzalm[i];
    }
}
