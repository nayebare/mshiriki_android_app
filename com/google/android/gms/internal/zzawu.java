package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.common.internal.safeparcel.zzb.zza;
import com.google.android.gms.common.internal.safeparcel.zzc;
import com.google.android.gms.internal.zzawk.zzh;
import com.google.android.gms.wallet.fragment.WalletFragmentStyle.BuyButtonText;
import com.google.android.gms.wallet.fragment.WalletFragmentStyle.Dimension;
import com.google.android.gms.wearable.ChannelApi.ChannelListener;
import com.google.android.gms.wearable.MessageApi;
import java.util.HashSet;
import java.util.Set;

public class zzawu implements Creator<zzh> {
    static void zza(zzh com_google_android_gms_internal_zzawk_zzh, Parcel parcel, int i) {
        int zzaV = zzc.zzaV(parcel);
        Set set = com_google_android_gms_internal_zzawk_zzh.zzbAl;
        if (set.contains(Integer.valueOf(1))) {
            zzc.zzc(parcel, 1, com_google_android_gms_internal_zzawk_zzh.mVersionCode);
        }
        if (set.contains(Integer.valueOf(3))) {
            zzc.zzc(parcel, 3, com_google_android_gms_internal_zzawk_zzh.zzNP());
        }
        if (set.contains(Integer.valueOf(4))) {
            zzc.zza(parcel, 4, com_google_android_gms_internal_zzawk_zzh.mValue, true);
        }
        if (set.contains(Integer.valueOf(5))) {
            zzc.zza(parcel, 5, com_google_android_gms_internal_zzawk_zzh.zzacb, true);
        }
        if (set.contains(Integer.valueOf(6))) {
            zzc.zzc(parcel, 6, com_google_android_gms_internal_zzawk_zzh.zzanR);
        }
        zzc.zzJ(parcel, zzaV);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zziH(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzmA(i);
    }

    public zzh zziH(Parcel parcel) {
        String str = null;
        int i = 0;
        int zzaU = zzb.zzaU(parcel);
        Set hashSet = new HashSet();
        int i2 = 0;
        String str2 = null;
        int i3 = 0;
        while (parcel.dataPosition() < zzaU) {
            int zzaT = zzb.zzaT(parcel);
            switch (zzb.zzcW(zzaT)) {
                case MessageApi.FILTER_PREFIX /*1*/:
                    i3 = zzb.zzg(parcel, zzaT);
                    hashSet.add(Integer.valueOf(1));
                    break;
                case ChannelListener.CLOSE_REASON_LOCAL_CLOSE /*3*/:
                    i = zzb.zzg(parcel, zzaT);
                    hashSet.add(Integer.valueOf(3));
                    break;
                case Dimension.UNIT_IN /*4*/:
                    str = zzb.zzq(parcel, zzaT);
                    hashSet.add(Integer.valueOf(4));
                    break;
                case Dimension.UNIT_MM /*5*/:
                    str2 = zzb.zzq(parcel, zzaT);
                    hashSet.add(Integer.valueOf(5));
                    break;
                case BuyButtonText.LOGO_ONLY /*6*/:
                    i2 = zzb.zzg(parcel, zzaT);
                    hashSet.add(Integer.valueOf(6));
                    break;
                default:
                    zzb.zzb(parcel, zzaT);
                    break;
            }
        }
        if (parcel.dataPosition() == zzaU) {
            return new zzh(hashSet, i3, str2, i2, str, i);
        }
        throw new zza("Overread allowed size end=" + zzaU, parcel);
    }

    public zzh[] zzmA(int i) {
        return new zzh[i];
    }
}
