package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.common.internal.safeparcel.zzb.zza;
import com.google.android.gms.common.internal.safeparcel.zzc;
import com.google.android.gms.internal.zzawk.zzd;
import com.google.android.gms.wallet.fragment.WalletFragmentStyle.BuyButtonText;
import com.google.android.gms.wallet.fragment.WalletFragmentStyle.Dimension;
import com.google.android.gms.wearable.ChannelApi.ChannelListener;
import com.google.android.gms.wearable.MessageApi;
import java.util.HashSet;
import java.util.Set;

public class zzawr implements Creator<zzd> {
    static void zza(zzd com_google_android_gms_internal_zzawk_zzd, Parcel parcel, int i) {
        int zzaV = zzc.zzaV(parcel);
        Set set = com_google_android_gms_internal_zzawk_zzd.zzbAl;
        if (set.contains(Integer.valueOf(1))) {
            zzc.zzc(parcel, 1, com_google_android_gms_internal_zzawk_zzd.mVersionCode);
        }
        if (set.contains(Integer.valueOf(2))) {
            zzc.zza(parcel, 2, com_google_android_gms_internal_zzawk_zzd.zzail, true);
        }
        if (set.contains(Integer.valueOf(3))) {
            zzc.zza(parcel, 3, com_google_android_gms_internal_zzawk_zzd.zzbAM, true);
        }
        if (set.contains(Integer.valueOf(4))) {
            zzc.zza(parcel, 4, com_google_android_gms_internal_zzawk_zzd.zzaik, true);
        }
        if (set.contains(Integer.valueOf(5))) {
            zzc.zza(parcel, 5, com_google_android_gms_internal_zzawk_zzd.zzbAN, true);
        }
        if (set.contains(Integer.valueOf(6))) {
            zzc.zza(parcel, 6, com_google_android_gms_internal_zzawk_zzd.zzbAO, true);
        }
        if (set.contains(Integer.valueOf(7))) {
            zzc.zza(parcel, 7, com_google_android_gms_internal_zzawk_zzd.zzbAP, true);
        }
        zzc.zzJ(parcel, zzaV);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zziE(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzmx(i);
    }

    public zzd zziE(Parcel parcel) {
        String str = null;
        int zzaU = zzb.zzaU(parcel);
        Set hashSet = new HashSet();
        int i = 0;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        String str6 = null;
        while (parcel.dataPosition() < zzaU) {
            int zzaT = zzb.zzaT(parcel);
            switch (zzb.zzcW(zzaT)) {
                case MessageApi.FILTER_PREFIX /*1*/:
                    i = zzb.zzg(parcel, zzaT);
                    hashSet.add(Integer.valueOf(1));
                    break;
                case ChannelListener.CLOSE_REASON_REMOTE_CLOSE /*2*/:
                    str6 = zzb.zzq(parcel, zzaT);
                    hashSet.add(Integer.valueOf(2));
                    break;
                case ChannelListener.CLOSE_REASON_LOCAL_CLOSE /*3*/:
                    str5 = zzb.zzq(parcel, zzaT);
                    hashSet.add(Integer.valueOf(3));
                    break;
                case Dimension.UNIT_IN /*4*/:
                    str4 = zzb.zzq(parcel, zzaT);
                    hashSet.add(Integer.valueOf(4));
                    break;
                case Dimension.UNIT_MM /*5*/:
                    str3 = zzb.zzq(parcel, zzaT);
                    hashSet.add(Integer.valueOf(5));
                    break;
                case BuyButtonText.LOGO_ONLY /*6*/:
                    str2 = zzb.zzq(parcel, zzaT);
                    hashSet.add(Integer.valueOf(6));
                    break;
                case BuyButtonText.DONATE_WITH /*7*/:
                    str = zzb.zzq(parcel, zzaT);
                    hashSet.add(Integer.valueOf(7));
                    break;
                default:
                    zzb.zzb(parcel, zzaT);
                    break;
            }
        }
        if (parcel.dataPosition() == zzaU) {
            return new zzd(hashSet, i, str6, str5, str4, str3, str2, str);
        }
        throw new zza("Overread allowed size end=" + zzaU, parcel);
    }

    public zzd[] zzmx(int i) {
        return new zzd[i];
    }
}
