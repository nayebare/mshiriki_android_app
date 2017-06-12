package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.common.internal.safeparcel.zzb.zza;
import com.google.android.gms.common.internal.safeparcel.zzc;
import com.google.android.gms.wearable.ChannelApi.ChannelListener;
import com.google.android.gms.wearable.MessageApi;

public class zzaiv implements Creator<zzaiu> {
    static void zza(zzaiu com_google_android_gms_internal_zzaiu, Parcel parcel, int i) {
        int zzaV = zzc.zzaV(parcel);
        zzc.zzc(parcel, 1, com_google_android_gms_internal_zzaiu.mVersionCode);
        zzc.zza(parcel, 2, com_google_android_gms_internal_zzaiu.zzaLH, i, false);
        zzc.zza(parcel, 3, com_google_android_gms_internal_zzaiu.zzaMF);
        zzc.zzJ(parcel, zzaV);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzcz(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzeV(i);
    }

    public zzaiu zzcz(Parcel parcel) {
        boolean z = false;
        int zzaU = zzb.zzaU(parcel);
        com.google.android.gms.drive.zzc com_google_android_gms_drive_zzc = null;
        int i = 0;
        while (parcel.dataPosition() < zzaU) {
            com.google.android.gms.drive.zzc com_google_android_gms_drive_zzc2;
            int zzg;
            boolean z2;
            int zzaT = zzb.zzaT(parcel);
            switch (zzb.zzcW(zzaT)) {
                case MessageApi.FILTER_PREFIX /*1*/:
                    boolean z3 = z;
                    com_google_android_gms_drive_zzc2 = com_google_android_gms_drive_zzc;
                    zzg = zzb.zzg(parcel, zzaT);
                    z2 = z3;
                    break;
                case ChannelListener.CLOSE_REASON_REMOTE_CLOSE /*2*/:
                    zzg = i;
                    com.google.android.gms.drive.zzc com_google_android_gms_drive_zzc3 = (com.google.android.gms.drive.zzc) zzb.zza(parcel, zzaT, com.google.android.gms.drive.zzc.CREATOR);
                    z2 = z;
                    com_google_android_gms_drive_zzc2 = com_google_android_gms_drive_zzc3;
                    break;
                case ChannelListener.CLOSE_REASON_LOCAL_CLOSE /*3*/:
                    z2 = zzb.zzc(parcel, zzaT);
                    com_google_android_gms_drive_zzc2 = com_google_android_gms_drive_zzc;
                    zzg = i;
                    break;
                default:
                    zzb.zzb(parcel, zzaT);
                    z2 = z;
                    com_google_android_gms_drive_zzc2 = com_google_android_gms_drive_zzc;
                    zzg = i;
                    break;
            }
            i = zzg;
            com_google_android_gms_drive_zzc = com_google_android_gms_drive_zzc2;
            z = z2;
        }
        if (parcel.dataPosition() == zzaU) {
            return new zzaiu(i, com_google_android_gms_drive_zzc, z);
        }
        throw new zza("Overread allowed size end=" + zzaU, parcel);
    }

    public zzaiu[] zzeV(int i) {
        return new zzaiu[i];
    }
}
