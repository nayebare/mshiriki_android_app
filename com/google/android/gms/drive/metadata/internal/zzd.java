package com.google.android.gms.drive.metadata.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.common.internal.safeparcel.zzb.zza;
import com.google.android.gms.common.internal.safeparcel.zzc;
import com.google.android.gms.drive.metadata.CustomPropertyKey;
import com.google.android.gms.wearable.ChannelApi.ChannelListener;
import com.google.android.gms.wearable.MessageApi;

public class zzd implements Creator<zzc> {
    static void zza(zzc com_google_android_gms_drive_metadata_internal_zzc, Parcel parcel, int i) {
        int zzaV = zzc.zzaV(parcel);
        zzc.zzc(parcel, 1, com_google_android_gms_drive_metadata_internal_zzc.mVersionCode);
        zzc.zza(parcel, 2, com_google_android_gms_drive_metadata_internal_zzc.zzaNt, i, false);
        zzc.zza(parcel, 3, com_google_android_gms_drive_metadata_internal_zzc.mValue, false);
        zzc.zzJ(parcel, zzaV);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzdf(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzfB(i);
    }

    public zzc zzdf(Parcel parcel) {
        String str = null;
        int zzaU = zzb.zzaU(parcel);
        int i = 0;
        CustomPropertyKey customPropertyKey = null;
        while (parcel.dataPosition() < zzaU) {
            CustomPropertyKey customPropertyKey2;
            int zzg;
            String str2;
            int zzaT = zzb.zzaT(parcel);
            switch (zzb.zzcW(zzaT)) {
                case MessageApi.FILTER_PREFIX /*1*/:
                    String str3 = str;
                    customPropertyKey2 = customPropertyKey;
                    zzg = zzb.zzg(parcel, zzaT);
                    str2 = str3;
                    break;
                case ChannelListener.CLOSE_REASON_REMOTE_CLOSE /*2*/:
                    zzg = i;
                    CustomPropertyKey customPropertyKey3 = (CustomPropertyKey) zzb.zza(parcel, zzaT, CustomPropertyKey.CREATOR);
                    str2 = str;
                    customPropertyKey2 = customPropertyKey3;
                    break;
                case ChannelListener.CLOSE_REASON_LOCAL_CLOSE /*3*/:
                    str2 = zzb.zzq(parcel, zzaT);
                    customPropertyKey2 = customPropertyKey;
                    zzg = i;
                    break;
                default:
                    zzb.zzb(parcel, zzaT);
                    str2 = str;
                    customPropertyKey2 = customPropertyKey;
                    zzg = i;
                    break;
            }
            i = zzg;
            customPropertyKey = customPropertyKey2;
            str = str2;
        }
        if (parcel.dataPosition() == zzaU) {
            return new zzc(i, customPropertyKey, str);
        }
        throw new zza("Overread allowed size end=" + zzaU, parcel);
    }

    public zzc[] zzfB(int i) {
        return new zzc[i];
    }
}
