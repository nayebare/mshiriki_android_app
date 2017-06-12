package com.google.android.gms.drive;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zzb.zza;
import com.google.android.gms.common.internal.safeparcel.zzc;
import com.google.android.gms.wallet.fragment.WalletFragmentStyle.Dimension;
import com.google.android.gms.wearable.ChannelApi.ChannelListener;
import com.google.android.gms.wearable.MessageApi;

public class zzb implements Creator<zza> {
    static void zza(zza com_google_android_gms_drive_zza, Parcel parcel, int i) {
        int zzaV = zzc.zzaV(parcel);
        zzc.zzc(parcel, 1, com_google_android_gms_drive_zza.mVersionCode);
        zzc.zza(parcel, 2, com_google_android_gms_drive_zza.zzaJd);
        zzc.zza(parcel, 3, com_google_android_gms_drive_zza.zzaJe);
        zzc.zza(parcel, 4, com_google_android_gms_drive_zza.zzaJf);
        zzc.zzJ(parcel, zzaV);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzbH(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzdS(i);
    }

    public zza zzbH(Parcel parcel) {
        long j = 0;
        int zzaU = com.google.android.gms.common.internal.safeparcel.zzb.zzaU(parcel);
        int i = 0;
        long j2 = 0;
        long j3 = 0;
        while (parcel.dataPosition() < zzaU) {
            int zzaT = com.google.android.gms.common.internal.safeparcel.zzb.zzaT(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.zzb.zzcW(zzaT)) {
                case MessageApi.FILTER_PREFIX /*1*/:
                    i = com.google.android.gms.common.internal.safeparcel.zzb.zzg(parcel, zzaT);
                    break;
                case ChannelListener.CLOSE_REASON_REMOTE_CLOSE /*2*/:
                    j3 = com.google.android.gms.common.internal.safeparcel.zzb.zzi(parcel, zzaT);
                    break;
                case ChannelListener.CLOSE_REASON_LOCAL_CLOSE /*3*/:
                    j2 = com.google.android.gms.common.internal.safeparcel.zzb.zzi(parcel, zzaT);
                    break;
                case Dimension.UNIT_IN /*4*/:
                    j = com.google.android.gms.common.internal.safeparcel.zzb.zzi(parcel, zzaT);
                    break;
                default:
                    com.google.android.gms.common.internal.safeparcel.zzb.zzb(parcel, zzaT);
                    break;
            }
        }
        if (parcel.dataPosition() == zzaU) {
            return new zza(i, j3, j2, j);
        }
        throw new zza("Overread allowed size end=" + zzaU, parcel);
    }

    public zza[] zzdS(int i) {
        return new zza[i];
    }
}
