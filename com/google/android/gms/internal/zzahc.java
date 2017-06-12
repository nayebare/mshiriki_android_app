package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.common.internal.safeparcel.zzb.zza;
import com.google.android.gms.common.internal.safeparcel.zzc;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;
import com.google.android.gms.wearable.ChannelApi.ChannelListener;
import com.google.android.gms.wearable.MessageApi;

public class zzahc implements Creator<zzahb> {
    static void zza(zzahb com_google_android_gms_internal_zzahb, Parcel parcel, int i) {
        int zzaV = zzc.zzaV(parcel);
        zzc.zzc(parcel, 1, com_google_android_gms_internal_zzahb.mVersionCode);
        zzc.zza(parcel, 2, com_google_android_gms_internal_zzahb.zzaLh, i, false);
        zzc.zza(parcel, 3, com_google_android_gms_internal_zzahb.zzaLf, i, false);
        zzc.zzJ(parcel, zzaV);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzcl(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzeD(i);
    }

    public zzahb zzcl(Parcel parcel) {
        MetadataBundle metadataBundle = null;
        int zzaU = zzb.zzaU(parcel);
        int i = 0;
        DriveId driveId = null;
        while (parcel.dataPosition() < zzaU) {
            DriveId driveId2;
            int zzg;
            MetadataBundle metadataBundle2;
            int zzaT = zzb.zzaT(parcel);
            switch (zzb.zzcW(zzaT)) {
                case MessageApi.FILTER_PREFIX /*1*/:
                    MetadataBundle metadataBundle3 = metadataBundle;
                    driveId2 = driveId;
                    zzg = zzb.zzg(parcel, zzaT);
                    metadataBundle2 = metadataBundle3;
                    break;
                case ChannelListener.CLOSE_REASON_REMOTE_CLOSE /*2*/:
                    zzg = i;
                    DriveId driveId3 = (DriveId) zzb.zza(parcel, zzaT, DriveId.CREATOR);
                    metadataBundle2 = metadataBundle;
                    driveId2 = driveId3;
                    break;
                case ChannelListener.CLOSE_REASON_LOCAL_CLOSE /*3*/:
                    metadataBundle2 = (MetadataBundle) zzb.zza(parcel, zzaT, MetadataBundle.CREATOR);
                    driveId2 = driveId;
                    zzg = i;
                    break;
                default:
                    zzb.zzb(parcel, zzaT);
                    metadataBundle2 = metadataBundle;
                    driveId2 = driveId;
                    zzg = i;
                    break;
            }
            i = zzg;
            driveId = driveId2;
            metadataBundle = metadataBundle2;
        }
        if (parcel.dataPosition() == zzaU) {
            return new zzahb(i, driveId, metadataBundle);
        }
        throw new zza("Overread allowed size end=" + zzaU, parcel);
    }

    public zzahb[] zzeD(int i) {
        return new zzahb[i];
    }
}
