package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.common.internal.safeparcel.zzc;
import com.google.android.gms.internal.zzafh.zza;
import com.google.android.gms.wallet.fragment.WalletFragmentStyle.Dimension;
import com.google.android.gms.wearable.ChannelApi.ChannelListener;
import com.google.android.gms.wearable.MessageApi;

public class zzafj implements Creator<zza> {
    static void zza(zza com_google_android_gms_internal_zzafh_zza, Parcel parcel, int i) {
        int zzaV = zzc.zzaV(parcel);
        zzc.zzc(parcel, 1, com_google_android_gms_internal_zzafh_zza.versionCode);
        zzc.zzc(parcel, 2, com_google_android_gms_internal_zzafh_zza.type);
        zzc.zza(parcel, 3, com_google_android_gms_internal_zzafh_zza.zzaIQ, i, false);
        zzc.zza(parcel, 4, com_google_android_gms_internal_zzafh_zza.zzaIR, false);
        zzc.zzJ(parcel, zzaV);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzbz(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzdK(i);
    }

    public zza zzbz(Parcel parcel) {
        String str = null;
        int i = 0;
        int zzaU = zzb.zzaU(parcel);
        zzce com_google_android_gms_internal_zzce = null;
        int i2 = 0;
        while (parcel.dataPosition() < zzaU) {
            zzce com_google_android_gms_internal_zzce2;
            int i3;
            String str2;
            int zzaT = zzb.zzaT(parcel);
            String str3;
            switch (zzb.zzcW(zzaT)) {
                case MessageApi.FILTER_PREFIX /*1*/:
                    str3 = str;
                    com_google_android_gms_internal_zzce2 = com_google_android_gms_internal_zzce;
                    i3 = i;
                    i = zzb.zzg(parcel, zzaT);
                    str2 = str3;
                    break;
                case ChannelListener.CLOSE_REASON_REMOTE_CLOSE /*2*/:
                    i = i2;
                    zzce com_google_android_gms_internal_zzce3 = com_google_android_gms_internal_zzce;
                    i3 = zzb.zzg(parcel, zzaT);
                    str2 = str;
                    com_google_android_gms_internal_zzce2 = com_google_android_gms_internal_zzce3;
                    break;
                case ChannelListener.CLOSE_REASON_LOCAL_CLOSE /*3*/:
                    i3 = i;
                    i = i2;
                    str3 = str;
                    com_google_android_gms_internal_zzce2 = (zzce) zzb.zza(parcel, zzaT, zzce.CREATOR);
                    str2 = str3;
                    break;
                case Dimension.UNIT_IN /*4*/:
                    str2 = zzb.zzq(parcel, zzaT);
                    com_google_android_gms_internal_zzce2 = com_google_android_gms_internal_zzce;
                    i3 = i;
                    i = i2;
                    break;
                default:
                    zzb.zzb(parcel, zzaT);
                    str2 = str;
                    com_google_android_gms_internal_zzce2 = com_google_android_gms_internal_zzce;
                    i3 = i;
                    i = i2;
                    break;
            }
            i2 = i;
            i = i3;
            com_google_android_gms_internal_zzce = com_google_android_gms_internal_zzce2;
            str = str2;
        }
        if (parcel.dataPosition() == zzaU) {
            return new zza(i2, i, com_google_android_gms_internal_zzce, str);
        }
        throw new zzb.zza("Overread allowed size end=" + zzaU, parcel);
    }

    public zza[] zzdK(int i) {
        return new zza[i];
    }
}
