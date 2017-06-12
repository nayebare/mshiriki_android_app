package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.common.internal.safeparcel.zzb.zza;
import com.google.android.gms.common.internal.safeparcel.zzc;
import com.google.android.gms.drive.zze;
import com.google.android.gms.wallet.fragment.WalletFragmentStyle.Dimension;
import com.google.android.gms.wearable.ChannelApi.ChannelListener;
import com.google.android.gms.wearable.MessageApi;
import java.util.List;

public class zzaiz implements Creator<zzaiy> {
    static void zza(zzaiy com_google_android_gms_internal_zzaiy, Parcel parcel, int i) {
        int zzaV = zzc.zzaV(parcel);
        zzc.zzc(parcel, 1, com_google_android_gms_internal_zzaiy.mVersionCode);
        zzc.zza(parcel, 2, com_google_android_gms_internal_zzaiy.zzaMI);
        zzc.zza(parcel, 3, com_google_android_gms_internal_zzaiy.zzaMJ);
        zzc.zzc(parcel, 4, com_google_android_gms_internal_zzaiy.zzJh);
        zzc.zzc(parcel, 5, com_google_android_gms_internal_zzaiy.zzaMK, false);
        zzc.zzJ(parcel, zzaV);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzcB(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzeX(i);
    }

    public zzaiy zzcB(Parcel parcel) {
        long j = 0;
        int i = 0;
        int zzaU = zzb.zzaU(parcel);
        List list = null;
        long j2 = 0;
        int i2 = 0;
        while (parcel.dataPosition() < zzaU) {
            int zzaT = zzb.zzaT(parcel);
            switch (zzb.zzcW(zzaT)) {
                case MessageApi.FILTER_PREFIX /*1*/:
                    i2 = zzb.zzg(parcel, zzaT);
                    break;
                case ChannelListener.CLOSE_REASON_REMOTE_CLOSE /*2*/:
                    j2 = zzb.zzi(parcel, zzaT);
                    break;
                case ChannelListener.CLOSE_REASON_LOCAL_CLOSE /*3*/:
                    j = zzb.zzi(parcel, zzaT);
                    break;
                case Dimension.UNIT_IN /*4*/:
                    i = zzb.zzg(parcel, zzaT);
                    break;
                case Dimension.UNIT_MM /*5*/:
                    list = zzb.zzc(parcel, zzaT, zze.CREATOR);
                    break;
                default:
                    zzb.zzb(parcel, zzaT);
                    break;
            }
        }
        if (parcel.dataPosition() == zzaU) {
            return new zzaiy(i2, j2, j, i, list);
        }
        throw new zza("Overread allowed size end=" + zzaU, parcel);
    }

    public zzaiy[] zzeX(int i) {
        return new zzaiy[i];
    }
}
