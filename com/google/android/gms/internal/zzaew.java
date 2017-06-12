package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.common.internal.safeparcel.zzc;
import com.google.android.gms.internal.zzaex.zza;
import com.google.android.gms.wallet.fragment.WalletFragmentStyle.Dimension;
import com.google.android.gms.wearable.ChannelApi.ChannelListener;
import com.google.android.gms.wearable.MessageApi;
import java.util.ArrayList;

public class zzaew implements Creator<zzaex> {
    static void zza(zzaex com_google_android_gms_internal_zzaex, Parcel parcel, int i) {
        int zzaV = zzc.zzaV(parcel);
        zzc.zzc(parcel, 1, com_google_android_gms_internal_zzaex.versionCode);
        zzc.zzc(parcel, 2, com_google_android_gms_internal_zzaex.zzaIm, false);
        zzc.zzb(parcel, 3, com_google_android_gms_internal_zzaex.zzaIn, false);
        zzc.zza(parcel, 4, com_google_android_gms_internal_zzaex.zzaIo, i, false);
        zzc.zzJ(parcel, zzaV);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzbv(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzdG(i);
    }

    public zzaex zzbv(Parcel parcel) {
        zzafn com_google_android_gms_internal_zzafn = null;
        int zzaU = zzb.zzaU(parcel);
        int i = 0;
        ArrayList arrayList = null;
        ArrayList arrayList2 = null;
        while (parcel.dataPosition() < zzaU) {
            int zzaT = zzb.zzaT(parcel);
            switch (zzb.zzcW(zzaT)) {
                case MessageApi.FILTER_PREFIX /*1*/:
                    i = zzb.zzg(parcel, zzaT);
                    break;
                case ChannelListener.CLOSE_REASON_REMOTE_CLOSE /*2*/:
                    arrayList2 = zzb.zzc(parcel, zzaT, zza.CREATOR);
                    break;
                case ChannelListener.CLOSE_REASON_LOCAL_CLOSE /*3*/:
                    arrayList = zzb.zzE(parcel, zzaT);
                    break;
                case Dimension.UNIT_IN /*4*/:
                    com_google_android_gms_internal_zzafn = (zzafn) zzb.zza(parcel, zzaT, zzafn.CREATOR);
                    break;
                default:
                    zzb.zzb(parcel, zzaT);
                    break;
            }
        }
        if (parcel.dataPosition() == zzaU) {
            return new zzaex(i, arrayList2, arrayList, com_google_android_gms_internal_zzafn);
        }
        throw new zzb.zza("Overread allowed size end=" + zzaU, parcel);
    }

    public zzaex[] zzdG(int i) {
        return new zzaex[i];
    }
}
