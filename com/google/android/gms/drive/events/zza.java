package com.google.android.gms.drive.events;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.common.internal.safeparcel.zzc;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.wearable.ChannelApi.ChannelListener;
import com.google.android.gms.wearable.MessageApi;

public class zza implements Creator<ChangeEvent> {
    static void zza(ChangeEvent changeEvent, Parcel parcel, int i) {
        int zzaV = zzc.zzaV(parcel);
        zzc.zzc(parcel, 1, changeEvent.mVersionCode);
        zzc.zza(parcel, 2, changeEvent.zzaJj, i, false);
        zzc.zzc(parcel, 3, changeEvent.zzaKg);
        zzc.zzJ(parcel, zzaV);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzbP(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzeg(i);
    }

    public ChangeEvent zzbP(Parcel parcel) {
        int i = 0;
        int zzaU = zzb.zzaU(parcel);
        DriveId driveId = null;
        int i2 = 0;
        while (parcel.dataPosition() < zzaU) {
            DriveId driveId2;
            int zzg;
            int zzaT = zzb.zzaT(parcel);
            switch (zzb.zzcW(zzaT)) {
                case MessageApi.FILTER_PREFIX /*1*/:
                    int i3 = i;
                    driveId2 = driveId;
                    zzg = zzb.zzg(parcel, zzaT);
                    zzaT = i3;
                    break;
                case ChannelListener.CLOSE_REASON_REMOTE_CLOSE /*2*/:
                    zzg = i2;
                    DriveId driveId3 = (DriveId) zzb.zza(parcel, zzaT, DriveId.CREATOR);
                    zzaT = i;
                    driveId2 = driveId3;
                    break;
                case ChannelListener.CLOSE_REASON_LOCAL_CLOSE /*3*/:
                    zzaT = zzb.zzg(parcel, zzaT);
                    driveId2 = driveId;
                    zzg = i2;
                    break;
                default:
                    zzb.zzb(parcel, zzaT);
                    zzaT = i;
                    driveId2 = driveId;
                    zzg = i2;
                    break;
            }
            i2 = zzg;
            driveId = driveId2;
            i = zzaT;
        }
        if (parcel.dataPosition() == zzaU) {
            return new ChangeEvent(i2, driveId, i);
        }
        throw new com.google.android.gms.common.internal.safeparcel.zzb.zza("Overread allowed size end=" + zzaU, parcel);
    }

    public ChangeEvent[] zzeg(int i) {
        return new ChangeEvent[i];
    }
}
