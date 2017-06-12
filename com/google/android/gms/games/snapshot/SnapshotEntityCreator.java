package com.google.android.gms.games.snapshot;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.common.internal.safeparcel.zzb.zza;
import com.google.android.gms.common.internal.safeparcel.zzc;
import com.google.android.gms.wallet.WalletConstants.CardNetwork;
import com.google.android.gms.wearable.ChannelApi.ChannelListener;
import com.google.android.gms.wearable.MessageApi;

public class SnapshotEntityCreator implements Creator<SnapshotEntity> {
    static void zza(SnapshotEntity snapshotEntity, Parcel parcel, int i) {
        int zzaV = zzc.zzaV(parcel);
        zzc.zza(parcel, 1, snapshotEntity.getMetadata(), i, false);
        zzc.zza(parcel, 3, snapshotEntity.getSnapshotContents(), i, false);
        zzc.zzc(parcel, CardNetwork.OTHER, snapshotEntity.getVersionCode());
        zzc.zzJ(parcel, zzaV);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzfX(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzjd(i);
    }

    public SnapshotEntity zzfX(Parcel parcel) {
        SnapshotContentsEntity snapshotContentsEntity = null;
        int zzaU = zzb.zzaU(parcel);
        int i = 0;
        SnapshotMetadata snapshotMetadata = null;
        while (parcel.dataPosition() < zzaU) {
            int i2;
            SnapshotContentsEntity snapshotContentsEntity2;
            SnapshotMetadata snapshotMetadata2;
            int zzaT = zzb.zzaT(parcel);
            switch (zzb.zzcW(zzaT)) {
                case MessageApi.FILTER_PREFIX /*1*/:
                    i2 = i;
                    SnapshotMetadataEntity snapshotMetadataEntity = (SnapshotMetadataEntity) zzb.zza(parcel, zzaT, SnapshotMetadataEntity.CREATOR);
                    snapshotContentsEntity2 = snapshotContentsEntity;
                    Object obj = snapshotMetadataEntity;
                    break;
                case ChannelListener.CLOSE_REASON_LOCAL_CLOSE /*3*/:
                    snapshotContentsEntity2 = (SnapshotContentsEntity) zzb.zza(parcel, zzaT, SnapshotContentsEntity.CREATOR);
                    snapshotMetadata2 = snapshotMetadata;
                    i2 = i;
                    break;
                case CardNetwork.OTHER /*1000*/:
                    SnapshotContentsEntity snapshotContentsEntity3 = snapshotContentsEntity;
                    snapshotMetadata2 = snapshotMetadata;
                    i2 = zzb.zzg(parcel, zzaT);
                    snapshotContentsEntity2 = snapshotContentsEntity3;
                    break;
                default:
                    zzb.zzb(parcel, zzaT);
                    snapshotContentsEntity2 = snapshotContentsEntity;
                    snapshotMetadata2 = snapshotMetadata;
                    i2 = i;
                    break;
            }
            i = i2;
            snapshotMetadata = snapshotMetadata2;
            snapshotContentsEntity = snapshotContentsEntity2;
        }
        if (parcel.dataPosition() == zzaU) {
            return new SnapshotEntity(i, snapshotMetadata, snapshotContentsEntity);
        }
        throw new zza("Overread allowed size end=" + zzaU, parcel);
    }

    public SnapshotEntity[] zzjd(int i) {
        return new SnapshotEntity[i];
    }
}
