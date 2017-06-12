package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.common.internal.safeparcel.zzb.zza;
import com.google.android.gms.common.internal.safeparcel.zzc;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.wearable.ChannelApi.ChannelListener;
import com.google.android.gms.wearable.MessageApi;
import java.util.ArrayList;
import java.util.List;

public class zzako implements Creator<zzakn> {
    static void zza(zzakn com_google_android_gms_internal_zzakn, Parcel parcel, int i) {
        int zzaV = zzc.zzaV(parcel);
        zzc.zzc(parcel, 1, com_google_android_gms_internal_zzakn.mVersionCode);
        zzc.zza(parcel, 2, com_google_android_gms_internal_zzakn.zzaKO, i, false);
        zzc.zzc(parcel, 3, com_google_android_gms_internal_zzakn.zzaNc, false);
        zzc.zzJ(parcel, zzaV);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzcV(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzfr(i);
    }

    public zzakn zzcV(Parcel parcel) {
        List list = null;
        int zzaU = zzb.zzaU(parcel);
        int i = 0;
        DriveId driveId = null;
        while (parcel.dataPosition() < zzaU) {
            DriveId driveId2;
            int zzg;
            ArrayList zzc;
            int zzaT = zzb.zzaT(parcel);
            List list2;
            switch (zzb.zzcW(zzaT)) {
                case MessageApi.FILTER_PREFIX /*1*/:
                    List list3 = list;
                    driveId2 = driveId;
                    zzg = zzb.zzg(parcel, zzaT);
                    list2 = list3;
                    break;
                case ChannelListener.CLOSE_REASON_REMOTE_CLOSE /*2*/:
                    zzg = i;
                    DriveId driveId3 = (DriveId) zzb.zza(parcel, zzaT, DriveId.CREATOR);
                    list2 = list;
                    driveId2 = driveId3;
                    break;
                case ChannelListener.CLOSE_REASON_LOCAL_CLOSE /*3*/:
                    zzc = zzb.zzc(parcel, zzaT, DriveId.CREATOR);
                    driveId2 = driveId;
                    zzg = i;
                    break;
                default:
                    zzb.zzb(parcel, zzaT);
                    zzc = list;
                    driveId2 = driveId;
                    zzg = i;
                    break;
            }
            i = zzg;
            driveId = driveId2;
            Object obj = zzc;
        }
        if (parcel.dataPosition() == zzaU) {
            return new zzakn(i, driveId, list);
        }
        throw new zza("Overread allowed size end=" + zzaU, parcel);
    }

    public zzakn[] zzfr(int i) {
        return new zzakn[i];
    }
}
