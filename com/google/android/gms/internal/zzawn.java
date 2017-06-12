package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zzc;
import com.google.android.gms.internal.zzawk.zzb;
import com.google.android.gms.internal.zzawk.zzb.zza;
import com.google.android.gms.wallet.fragment.WalletFragmentStyle.Dimension;
import com.google.android.gms.wearable.ChannelApi.ChannelListener;
import com.google.android.gms.wearable.MessageApi;
import java.util.HashSet;
import java.util.Set;

public class zzawn implements Creator<zzb> {
    static void zza(zzb com_google_android_gms_internal_zzawk_zzb, Parcel parcel, int i) {
        int zzaV = zzc.zzaV(parcel);
        Set set = com_google_android_gms_internal_zzawk_zzb.zzbAl;
        if (set.contains(Integer.valueOf(1))) {
            zzc.zzc(parcel, 1, com_google_android_gms_internal_zzawk_zzb.mVersionCode);
        }
        if (set.contains(Integer.valueOf(2))) {
            zzc.zza(parcel, 2, com_google_android_gms_internal_zzawk_zzb.zzbAH, i, true);
        }
        if (set.contains(Integer.valueOf(3))) {
            zzc.zza(parcel, 3, com_google_android_gms_internal_zzawk_zzb.zzbAI, i, true);
        }
        if (set.contains(Integer.valueOf(4))) {
            zzc.zzc(parcel, 4, com_google_android_gms_internal_zzawk_zzb.zzbAJ);
        }
        zzc.zzJ(parcel, zzaV);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zziA(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzmt(i);
    }

    public zzb zziA(Parcel parcel) {
        zzb.zzb com_google_android_gms_internal_zzawk_zzb_zzb = null;
        int i = 0;
        int zzaU = com.google.android.gms.common.internal.safeparcel.zzb.zzaU(parcel);
        Set hashSet = new HashSet();
        zza com_google_android_gms_internal_zzawk_zzb_zza = null;
        int i2 = 0;
        while (parcel.dataPosition() < zzaU) {
            int zzaT = com.google.android.gms.common.internal.safeparcel.zzb.zzaT(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.zzb.zzcW(zzaT)) {
                case MessageApi.FILTER_PREFIX /*1*/:
                    i2 = com.google.android.gms.common.internal.safeparcel.zzb.zzg(parcel, zzaT);
                    hashSet.add(Integer.valueOf(1));
                    break;
                case ChannelListener.CLOSE_REASON_REMOTE_CLOSE /*2*/:
                    zza com_google_android_gms_internal_zzawk_zzb_zza2 = (zza) com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, zzaT, zza.CREATOR);
                    hashSet.add(Integer.valueOf(2));
                    com_google_android_gms_internal_zzawk_zzb_zza = com_google_android_gms_internal_zzawk_zzb_zza2;
                    break;
                case ChannelListener.CLOSE_REASON_LOCAL_CLOSE /*3*/:
                    zzb.zzb com_google_android_gms_internal_zzawk_zzb_zzb2 = (zzb.zzb) com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, zzaT, zzb.zzb.CREATOR);
                    hashSet.add(Integer.valueOf(3));
                    com_google_android_gms_internal_zzawk_zzb_zzb = com_google_android_gms_internal_zzawk_zzb_zzb2;
                    break;
                case Dimension.UNIT_IN /*4*/:
                    i = com.google.android.gms.common.internal.safeparcel.zzb.zzg(parcel, zzaT);
                    hashSet.add(Integer.valueOf(4));
                    break;
                default:
                    com.google.android.gms.common.internal.safeparcel.zzb.zzb(parcel, zzaT);
                    break;
            }
        }
        if (parcel.dataPosition() == zzaU) {
            return new zzb(hashSet, i2, com_google_android_gms_internal_zzawk_zzb_zza, com_google_android_gms_internal_zzawk_zzb_zzb, i);
        }
        throw new com.google.android.gms.common.internal.safeparcel.zzb.zza("Overread allowed size end=" + zzaU, parcel);
    }

    public zzb[] zzmt(int i) {
        return new zzb[i];
    }
}
