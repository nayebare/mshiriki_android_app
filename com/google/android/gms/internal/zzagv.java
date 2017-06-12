package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.common.internal.safeparcel.zzb.zza;
import com.google.android.gms.common.internal.safeparcel.zzc;
import com.google.android.gms.drive.DriveFile;
import com.google.android.gms.wearable.ChannelApi.ChannelListener;
import com.google.android.gms.wearable.MessageApi;

public class zzagv implements Creator<zzagu> {
    static void zza(zzagu com_google_android_gms_internal_zzagu, Parcel parcel, int i) {
        int zzaV = zzc.zzaV(parcel);
        zzc.zzc(parcel, 1, com_google_android_gms_internal_zzagu.mVersionCode);
        zzc.zzc(parcel, 2, com_google_android_gms_internal_zzagu.zzaJi);
        zzc.zzJ(parcel, zzaV);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzci(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzez(i);
    }

    public zzagu zzci(Parcel parcel) {
        int zzaU = zzb.zzaU(parcel);
        int i = 0;
        int i2 = DriveFile.MODE_WRITE_ONLY;
        while (parcel.dataPosition() < zzaU) {
            int zzaT = zzb.zzaT(parcel);
            switch (zzb.zzcW(zzaT)) {
                case MessageApi.FILTER_PREFIX /*1*/:
                    i = zzb.zzg(parcel, zzaT);
                    break;
                case ChannelListener.CLOSE_REASON_REMOTE_CLOSE /*2*/:
                    i2 = zzb.zzg(parcel, zzaT);
                    break;
                default:
                    zzb.zzb(parcel, zzaT);
                    break;
            }
        }
        if (parcel.dataPosition() == zzaU) {
            return new zzagu(i, i2);
        }
        throw new zza("Overread allowed size end=" + zzaU, parcel);
    }

    public zzagu[] zzez(int i) {
        return new zzagu[i];
    }
}
