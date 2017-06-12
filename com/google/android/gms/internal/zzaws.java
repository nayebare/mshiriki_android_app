package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.common.internal.safeparcel.zzb.zza;
import com.google.android.gms.common.internal.safeparcel.zzc;
import com.google.android.gms.games.request.Requests;
import com.google.android.gms.internal.zzawk.zzf;
import com.google.android.gms.wallet.fragment.WalletFragmentStyle.BuyButtonText;
import com.google.android.gms.wallet.fragment.WalletFragmentStyle.Dimension;
import com.google.android.gms.wearable.ChannelApi.ChannelListener;
import com.google.android.gms.wearable.MessageApi;
import java.util.HashSet;
import java.util.Set;
import org.apache.http.protocol.HTTP;

public class zzaws implements Creator<zzf> {
    static void zza(zzf com_google_android_gms_internal_zzawk_zzf, Parcel parcel, int i) {
        int zzaV = zzc.zzaV(parcel);
        Set set = com_google_android_gms_internal_zzawk_zzf.zzbAl;
        if (set.contains(Integer.valueOf(1))) {
            zzc.zzc(parcel, 1, com_google_android_gms_internal_zzawk_zzf.mVersionCode);
        }
        if (set.contains(Integer.valueOf(2))) {
            zzc.zza(parcel, 2, com_google_android_gms_internal_zzawk_zzf.zzbAQ, true);
        }
        if (set.contains(Integer.valueOf(3))) {
            zzc.zza(parcel, 3, com_google_android_gms_internal_zzawk_zzf.zzacd, true);
        }
        if (set.contains(Integer.valueOf(4))) {
            zzc.zza(parcel, 4, com_google_android_gms_internal_zzawk_zzf.zzbAR, true);
        }
        if (set.contains(Integer.valueOf(5))) {
            zzc.zza(parcel, 5, com_google_android_gms_internal_zzawk_zzf.zzbAS, true);
        }
        if (set.contains(Integer.valueOf(6))) {
            zzc.zza(parcel, 6, com_google_android_gms_internal_zzawk_zzf.mName, true);
        }
        if (set.contains(Integer.valueOf(7))) {
            zzc.zza(parcel, 7, com_google_android_gms_internal_zzawk_zzf.zzbAT);
        }
        if (set.contains(Integer.valueOf(8))) {
            zzc.zza(parcel, 8, com_google_android_gms_internal_zzawk_zzf.zzbAU, true);
        }
        if (set.contains(Integer.valueOf(9))) {
            zzc.zza(parcel, 9, com_google_android_gms_internal_zzawk_zzf.zzalD, true);
        }
        if (set.contains(Integer.valueOf(10))) {
            zzc.zzc(parcel, 10, com_google_android_gms_internal_zzawk_zzf.zzanR);
        }
        zzc.zzJ(parcel, zzaV);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zziF(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzmy(i);
    }

    public zzf zziF(Parcel parcel) {
        int i = 0;
        String str = null;
        int zzaU = zzb.zzaU(parcel);
        Set hashSet = new HashSet();
        String str2 = null;
        boolean z = false;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        String str6 = null;
        String str7 = null;
        int i2 = 0;
        while (parcel.dataPosition() < zzaU) {
            int zzaT = zzb.zzaT(parcel);
            switch (zzb.zzcW(zzaT)) {
                case MessageApi.FILTER_PREFIX /*1*/:
                    i2 = zzb.zzg(parcel, zzaT);
                    hashSet.add(Integer.valueOf(1));
                    break;
                case ChannelListener.CLOSE_REASON_REMOTE_CLOSE /*2*/:
                    str7 = zzb.zzq(parcel, zzaT);
                    hashSet.add(Integer.valueOf(2));
                    break;
                case ChannelListener.CLOSE_REASON_LOCAL_CLOSE /*3*/:
                    str6 = zzb.zzq(parcel, zzaT);
                    hashSet.add(Integer.valueOf(3));
                    break;
                case Dimension.UNIT_IN /*4*/:
                    str5 = zzb.zzq(parcel, zzaT);
                    hashSet.add(Integer.valueOf(4));
                    break;
                case Dimension.UNIT_MM /*5*/:
                    str4 = zzb.zzq(parcel, zzaT);
                    hashSet.add(Integer.valueOf(5));
                    break;
                case BuyButtonText.LOGO_ONLY /*6*/:
                    str3 = zzb.zzq(parcel, zzaT);
                    hashSet.add(Integer.valueOf(6));
                    break;
                case BuyButtonText.DONATE_WITH /*7*/:
                    z = zzb.zzc(parcel, zzaT);
                    hashSet.add(Integer.valueOf(7));
                    break;
                case Requests.MAX_REQUEST_RECIPIENTS /*8*/:
                    str2 = zzb.zzq(parcel, zzaT);
                    hashSet.add(Integer.valueOf(8));
                    break;
                case HTTP.HT /*9*/:
                    str = zzb.zzq(parcel, zzaT);
                    hashSet.add(Integer.valueOf(9));
                    break;
                case HTTP.LF /*10*/:
                    i = zzb.zzg(parcel, zzaT);
                    hashSet.add(Integer.valueOf(10));
                    break;
                default:
                    zzb.zzb(parcel, zzaT);
                    break;
            }
        }
        if (parcel.dataPosition() == zzaU) {
            return new zzf(hashSet, i2, str7, str6, str5, str4, str3, z, str2, str, i);
        }
        throw new zza("Overread allowed size end=" + zzaU, parcel);
    }

    public zzf[] zzmy(int i) {
        return new zzf[i];
    }
}
