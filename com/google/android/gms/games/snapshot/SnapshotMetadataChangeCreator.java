package com.google.android.gms.games.snapshot;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.data.BitmapTeleporter;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.common.internal.safeparcel.zzb.zza;
import com.google.android.gms.common.internal.safeparcel.zzc;
import com.google.android.gms.wallet.WalletConstants.CardNetwork;
import com.google.android.gms.wallet.fragment.WalletFragmentStyle.BuyButtonText;
import com.google.android.gms.wallet.fragment.WalletFragmentStyle.Dimension;
import com.google.android.gms.wearable.ChannelApi.ChannelListener;
import com.google.android.gms.wearable.MessageApi;

public class SnapshotMetadataChangeCreator implements Creator<SnapshotMetadataChangeEntity> {
    static void zza(SnapshotMetadataChangeEntity snapshotMetadataChangeEntity, Parcel parcel, int i) {
        int zzaV = zzc.zzaV(parcel);
        zzc.zza(parcel, 1, snapshotMetadataChangeEntity.getDescription(), false);
        zzc.zza(parcel, 2, snapshotMetadataChangeEntity.getPlayedTimeMillis(), false);
        zzc.zza(parcel, 4, snapshotMetadataChangeEntity.getCoverImageUri(), i, false);
        zzc.zza(parcel, 5, snapshotMetadataChangeEntity.zzFL(), i, false);
        zzc.zza(parcel, 6, snapshotMetadataChangeEntity.getProgressValue(), false);
        zzc.zzc(parcel, CardNetwork.OTHER, snapshotMetadataChangeEntity.getVersionCode());
        zzc.zzJ(parcel, zzaV);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzfY(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzje(i);
    }

    public SnapshotMetadataChangeEntity zzfY(Parcel parcel) {
        Long l = null;
        int zzaU = zzb.zzaU(parcel);
        int i = 0;
        Uri uri = null;
        BitmapTeleporter bitmapTeleporter = null;
        Long l2 = null;
        String str = null;
        while (parcel.dataPosition() < zzaU) {
            int zzaT = zzb.zzaT(parcel);
            switch (zzb.zzcW(zzaT)) {
                case MessageApi.FILTER_PREFIX /*1*/:
                    str = zzb.zzq(parcel, zzaT);
                    break;
                case ChannelListener.CLOSE_REASON_REMOTE_CLOSE /*2*/:
                    l2 = zzb.zzj(parcel, zzaT);
                    break;
                case Dimension.UNIT_IN /*4*/:
                    uri = (Uri) zzb.zza(parcel, zzaT, Uri.CREATOR);
                    break;
                case Dimension.UNIT_MM /*5*/:
                    bitmapTeleporter = (BitmapTeleporter) zzb.zza(parcel, zzaT, BitmapTeleporter.CREATOR);
                    break;
                case BuyButtonText.LOGO_ONLY /*6*/:
                    l = zzb.zzj(parcel, zzaT);
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
            return new SnapshotMetadataChangeEntity(i, str, l2, bitmapTeleporter, uri, l);
        }
        throw new zza("Overread allowed size end=" + zzaU, parcel);
    }

    public SnapshotMetadataChangeEntity[] zzje(int i) {
        return new SnapshotMetadataChangeEntity[i];
    }
}
