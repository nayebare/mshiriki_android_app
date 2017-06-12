package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.common.internal.safeparcel.zzb.zza;
import com.google.android.gms.common.internal.safeparcel.zzc;
import com.google.android.gms.wallet.fragment.WalletFragmentStyle.Dimension;
import com.google.android.gms.wearable.ChannelApi.ChannelListener;
import com.google.android.gms.wearable.MessageApi;

public class zzadm implements Creator<zzadl> {
    static void zza(zzadl com_google_android_gms_internal_zzadl, Parcel parcel, int i) {
        int zzaV = zzc.zzaV(parcel);
        zzc.zzc(parcel, 1, com_google_android_gms_internal_zzadl.getVersionCode());
        zzc.zzc(parcel, 2, com_google_android_gms_internal_zzadl.getStatusCode());
        zzc.zza(parcel, 3, com_google_android_gms_internal_zzadl.zzzb(), i, false);
        zzc.zza(parcel, 4, com_google_android_gms_internal_zzadl.getThrottleEndTimeMillis());
        zzc.zzJ(parcel, zzaV);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzbj(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzdr(i);
    }

    public zzadl zzbj(Parcel parcel) {
        int i = 0;
        int zzaU = zzb.zzaU(parcel);
        DataHolder dataHolder = null;
        long j = 0;
        int i2 = 0;
        while (parcel.dataPosition() < zzaU) {
            int zzaT = zzb.zzaT(parcel);
            switch (zzb.zzcW(zzaT)) {
                case MessageApi.FILTER_PREFIX /*1*/:
                    i2 = zzb.zzg(parcel, zzaT);
                    break;
                case ChannelListener.CLOSE_REASON_REMOTE_CLOSE /*2*/:
                    i = zzb.zzg(parcel, zzaT);
                    break;
                case ChannelListener.CLOSE_REASON_LOCAL_CLOSE /*3*/:
                    dataHolder = (DataHolder) zzb.zza(parcel, zzaT, DataHolder.CREATOR);
                    break;
                case Dimension.UNIT_IN /*4*/:
                    j = zzb.zzi(parcel, zzaT);
                    break;
                default:
                    zzb.zzb(parcel, zzaT);
                    break;
            }
        }
        if (parcel.dataPosition() == zzaU) {
            return new zzadl(i2, i, dataHolder, j);
        }
        throw new zza("Overread allowed size end=" + zzaU, parcel);
    }

    public zzadl[] zzdr(int i) {
        return new zzadl[i];
    }
}
