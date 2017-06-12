package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.common.internal.safeparcel.zzb.zza;
import com.google.android.gms.common.internal.safeparcel.zzc;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.wearable.ChannelApi.ChannelListener;
import com.google.android.gms.wearable.MessageApi;

public class zzaif implements Creator<zzaie> {
    static void zza(zzaie com_google_android_gms_internal_zzaie, Parcel parcel, int i) {
        int zzaV = zzc.zzaV(parcel);
        zzc.zzc(parcel, 1, com_google_android_gms_internal_zzaie.mVersionCode);
        zzc.zza(parcel, 2, com_google_android_gms_internal_zzaie.zzaKS, i, false);
        zzc.zza(parcel, 3, com_google_android_gms_internal_zzaie.zzaMt);
        zzc.zzJ(parcel, zzaV);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzct(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzeP(i);
    }

    public zzaie zzct(Parcel parcel) {
        boolean z = false;
        int zzaU = zzb.zzaU(parcel);
        DriveId driveId = null;
        int i = 0;
        while (parcel.dataPosition() < zzaU) {
            DriveId driveId2;
            int zzg;
            boolean z2;
            int zzaT = zzb.zzaT(parcel);
            switch (zzb.zzcW(zzaT)) {
                case MessageApi.FILTER_PREFIX /*1*/:
                    boolean z3 = z;
                    driveId2 = driveId;
                    zzg = zzb.zzg(parcel, zzaT);
                    z2 = z3;
                    break;
                case ChannelListener.CLOSE_REASON_REMOTE_CLOSE /*2*/:
                    zzg = i;
                    DriveId driveId3 = (DriveId) zzb.zza(parcel, zzaT, DriveId.CREATOR);
                    z2 = z;
                    driveId2 = driveId3;
                    break;
                case ChannelListener.CLOSE_REASON_LOCAL_CLOSE /*3*/:
                    z2 = zzb.zzc(parcel, zzaT);
                    driveId2 = driveId;
                    zzg = i;
                    break;
                default:
                    zzb.zzb(parcel, zzaT);
                    z2 = z;
                    driveId2 = driveId;
                    zzg = i;
                    break;
            }
            i = zzg;
            driveId = driveId2;
            z = z2;
        }
        if (parcel.dataPosition() == zzaU) {
            return new zzaie(i, driveId, z);
        }
        throw new zza("Overread allowed size end=" + zzaU, parcel);
    }

    public zzaie[] zzeP(int i) {
        return new zzaie[i];
    }
}
