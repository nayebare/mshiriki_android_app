package com.google.android.gms.games.snapshot;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.common.internal.safeparcel.zzb.zza;
import com.google.android.gms.common.internal.safeparcel.zzc;
import com.google.android.gms.wallet.WalletConstants.CardNetwork;
import com.google.android.gms.wearable.MessageApi;

public class SnapshotContentsEntityCreator implements Creator<SnapshotContentsEntity> {
    static void zza(SnapshotContentsEntity snapshotContentsEntity, Parcel parcel, int i) {
        int zzaV = zzc.zzaV(parcel);
        zzc.zza(parcel, 1, snapshotContentsEntity.zzzB(), i, false);
        zzc.zzc(parcel, CardNetwork.OTHER, snapshotContentsEntity.getVersionCode());
        zzc.zzJ(parcel, zzaV);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzfW(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzjc(i);
    }

    public SnapshotContentsEntity zzfW(Parcel parcel) {
        int zzaU = zzb.zzaU(parcel);
        int i = 0;
        com.google.android.gms.drive.zzc com_google_android_gms_drive_zzc = null;
        while (parcel.dataPosition() < zzaU) {
            int zzaT = zzb.zzaT(parcel);
            switch (zzb.zzcW(zzaT)) {
                case MessageApi.FILTER_PREFIX /*1*/:
                    com_google_android_gms_drive_zzc = (com.google.android.gms.drive.zzc) zzb.zza(parcel, zzaT, com.google.android.gms.drive.zzc.CREATOR);
                    break;
                case CardNetwork.OTHER /*1000*/:
                    i = zzb.zzg(parcel, zzaT);
                    break;
                default:
                    zzb.zzb(parcel, zzaT);
                    break;
            }
        }
        if (parcel.dataPosition() == zzaU) {
            return new SnapshotContentsEntity(i, com_google_android_gms_drive_zzc);
        }
        throw new zza("Overread allowed size end=" + zzaU, parcel);
    }

    public SnapshotContentsEntity[] zzjc(int i) {
        return new SnapshotContentsEntity[i];
    }
}
