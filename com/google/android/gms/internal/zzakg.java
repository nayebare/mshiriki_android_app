package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.common.internal.safeparcel.zzb.zza;
import com.google.android.gms.common.internal.safeparcel.zzc;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.events.zzp;
import com.google.android.gms.wallet.fragment.WalletFragmentStyle.Dimension;
import com.google.android.gms.wearable.ChannelApi.ChannelListener;
import com.google.android.gms.wearable.MessageApi;

public class zzakg implements Creator<zzakf> {
    static void zza(zzakf com_google_android_gms_internal_zzakf, Parcel parcel, int i) {
        int zzaV = zzc.zzaV(parcel);
        zzc.zzc(parcel, 1, com_google_android_gms_internal_zzakf.mVersionCode);
        zzc.zza(parcel, 2, com_google_android_gms_internal_zzakf.zzaJj, i, false);
        zzc.zzc(parcel, 3, com_google_android_gms_internal_zzakf.zzaGv);
        zzc.zza(parcel, 4, com_google_android_gms_internal_zzakf.zzaKI, i, false);
        zzc.zzJ(parcel, zzaV);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzcR(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzfn(i);
    }

    public zzakf zzcR(Parcel parcel) {
        zzp com_google_android_gms_drive_events_zzp = null;
        int i = 0;
        int zzaU = zzb.zzaU(parcel);
        DriveId driveId = null;
        int i2 = 0;
        while (parcel.dataPosition() < zzaU) {
            int i3;
            DriveId driveId2;
            int zzg;
            zzp com_google_android_gms_drive_events_zzp2;
            int zzaT = zzb.zzaT(parcel);
            zzp com_google_android_gms_drive_events_zzp3;
            switch (zzb.zzcW(zzaT)) {
                case MessageApi.FILTER_PREFIX /*1*/:
                    com_google_android_gms_drive_events_zzp3 = com_google_android_gms_drive_events_zzp;
                    i3 = i;
                    driveId2 = driveId;
                    zzg = zzb.zzg(parcel, zzaT);
                    com_google_android_gms_drive_events_zzp2 = com_google_android_gms_drive_events_zzp3;
                    break;
                case ChannelListener.CLOSE_REASON_REMOTE_CLOSE /*2*/:
                    zzg = i2;
                    int i4 = i;
                    driveId2 = (DriveId) zzb.zza(parcel, zzaT, DriveId.CREATOR);
                    com_google_android_gms_drive_events_zzp2 = com_google_android_gms_drive_events_zzp;
                    i3 = i4;
                    break;
                case ChannelListener.CLOSE_REASON_LOCAL_CLOSE /*3*/:
                    driveId2 = driveId;
                    zzg = i2;
                    com_google_android_gms_drive_events_zzp3 = com_google_android_gms_drive_events_zzp;
                    i3 = zzb.zzg(parcel, zzaT);
                    com_google_android_gms_drive_events_zzp2 = com_google_android_gms_drive_events_zzp3;
                    break;
                case Dimension.UNIT_IN /*4*/:
                    com_google_android_gms_drive_events_zzp2 = (zzp) zzb.zza(parcel, zzaT, zzp.CREATOR);
                    i3 = i;
                    driveId2 = driveId;
                    zzg = i2;
                    break;
                default:
                    zzb.zzb(parcel, zzaT);
                    com_google_android_gms_drive_events_zzp2 = com_google_android_gms_drive_events_zzp;
                    i3 = i;
                    driveId2 = driveId;
                    zzg = i2;
                    break;
            }
            i2 = zzg;
            driveId = driveId2;
            i = i3;
            com_google_android_gms_drive_events_zzp = com_google_android_gms_drive_events_zzp2;
        }
        if (parcel.dataPosition() == zzaU) {
            return new zzakf(i2, driveId, i, com_google_android_gms_drive_events_zzp);
        }
        throw new zza("Overread allowed size end=" + zzaU, parcel);
    }

    public zzakf[] zzfn(int i) {
        return new zzakf[i];
    }
}
