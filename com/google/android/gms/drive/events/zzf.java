package com.google.android.gms.drive.events;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.common.internal.safeparcel.zzb.zza;
import com.google.android.gms.common.internal.safeparcel.zzc;
import com.google.android.gms.drive.DriveSpace;
import com.google.android.gms.wallet.fragment.WalletFragmentStyle.Dimension;
import com.google.android.gms.wearable.ChannelApi.ChannelListener;
import com.google.android.gms.wearable.MessageApi;
import java.util.List;

public class zzf implements Creator<zze> {
    static void zza(zze com_google_android_gms_drive_events_zze, Parcel parcel, int i) {
        int zzaV = zzc.zzaV(parcel);
        zzc.zzc(parcel, 1, com_google_android_gms_drive_events_zze.mVersionCode);
        zzc.zzc(parcel, 2, com_google_android_gms_drive_events_zze.zzaKi);
        zzc.zza(parcel, 3, com_google_android_gms_drive_events_zze.zzaKj);
        zzc.zzc(parcel, 4, com_google_android_gms_drive_events_zze.zzaKk, false);
        zzc.zzJ(parcel, zzaV);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzbR(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzei(i);
    }

    public zze zzbR(Parcel parcel) {
        boolean z = false;
        int zzaU = zzb.zzaU(parcel);
        List list = null;
        int i = 0;
        int i2 = 0;
        while (parcel.dataPosition() < zzaU) {
            int zzaT = zzb.zzaT(parcel);
            switch (zzb.zzcW(zzaT)) {
                case MessageApi.FILTER_PREFIX /*1*/:
                    i2 = zzb.zzg(parcel, zzaT);
                    break;
                case ChannelListener.CLOSE_REASON_REMOTE_CLOSE /*2*/:
                    i = zzb.zzg(parcel, zzaT);
                    break;
                case ChannelListener.CLOSE_REASON_LOCAL_CLOSE /*3*/:
                    z = zzb.zzc(parcel, zzaT);
                    break;
                case Dimension.UNIT_IN /*4*/:
                    list = zzb.zzc(parcel, zzaT, DriveSpace.CREATOR);
                    break;
                default:
                    zzb.zzb(parcel, zzaT);
                    break;
            }
        }
        if (parcel.dataPosition() == zzaU) {
            return new zze(i2, i, z, list);
        }
        throw new zza("Overread allowed size end=" + zzaU, parcel);
    }

    public zze[] zzei(int i) {
        return new zze[i];
    }
}
