package com.google.android.gms.games.snapshot;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.C0473R;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.common.internal.safeparcel.zzb.zza;
import com.google.android.gms.common.internal.safeparcel.zzc;
import com.google.android.gms.games.GameEntity;
import com.google.android.gms.games.GamesStatusCodes;
import com.google.android.gms.games.PlayerEntity;
import com.google.android.gms.games.request.Requests;
import com.google.android.gms.wallet.WalletConstants.CardNetwork;
import com.google.android.gms.wallet.fragment.WalletFragmentStyle.BuyButtonText;
import com.google.android.gms.wallet.fragment.WalletFragmentStyle.Dimension;
import com.google.android.gms.wearable.ChannelApi.ChannelListener;
import com.google.android.gms.wearable.MessageApi;
import org.apache.http.protocol.HTTP;

public class SnapshotMetadataEntityCreator implements Creator<SnapshotMetadataEntity> {
    static void zza(SnapshotMetadataEntity snapshotMetadataEntity, Parcel parcel, int i) {
        int zzaV = zzc.zzaV(parcel);
        zzc.zza(parcel, 1, snapshotMetadataEntity.getGame(), i, false);
        zzc.zza(parcel, 2, snapshotMetadataEntity.getOwner(), i, false);
        zzc.zza(parcel, 3, snapshotMetadataEntity.getSnapshotId(), false);
        zzc.zza(parcel, 5, snapshotMetadataEntity.getCoverImageUri(), i, false);
        zzc.zza(parcel, 6, snapshotMetadataEntity.getCoverImageUrl(), false);
        zzc.zza(parcel, 7, snapshotMetadataEntity.getTitle(), false);
        zzc.zzc(parcel, CardNetwork.OTHER, snapshotMetadataEntity.getVersionCode());
        zzc.zza(parcel, 8, snapshotMetadataEntity.getDescription(), false);
        zzc.zza(parcel, 9, snapshotMetadataEntity.getLastModifiedTimestamp());
        zzc.zza(parcel, 10, snapshotMetadataEntity.getPlayedTime());
        zzc.zza(parcel, 11, snapshotMetadataEntity.getCoverImageAspectRatio());
        zzc.zza(parcel, 12, snapshotMetadataEntity.getUniqueName(), false);
        zzc.zza(parcel, 13, snapshotMetadataEntity.hasChangePending());
        zzc.zza(parcel, 14, snapshotMetadataEntity.getProgressValue());
        zzc.zza(parcel, 15, snapshotMetadataEntity.getDeviceName(), false);
        zzc.zzJ(parcel, zzaV);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzfZ(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzjf(i);
    }

    public SnapshotMetadataEntity zzfZ(Parcel parcel) {
        int zzaU = zzb.zzaU(parcel);
        int i = 0;
        GameEntity gameEntity = null;
        PlayerEntity playerEntity = null;
        String str = null;
        Uri uri = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        long j = 0;
        long j2 = 0;
        float f = 0.0f;
        String str5 = null;
        boolean z = false;
        long j3 = 0;
        String str6 = null;
        while (parcel.dataPosition() < zzaU) {
            int zzaT = zzb.zzaT(parcel);
            switch (zzb.zzcW(zzaT)) {
                case MessageApi.FILTER_PREFIX /*1*/:
                    gameEntity = (GameEntity) zzb.zza(parcel, zzaT, GameEntity.CREATOR);
                    break;
                case ChannelListener.CLOSE_REASON_REMOTE_CLOSE /*2*/:
                    playerEntity = (PlayerEntity) zzb.zza(parcel, zzaT, PlayerEntity.CREATOR);
                    break;
                case ChannelListener.CLOSE_REASON_LOCAL_CLOSE /*3*/:
                    str = zzb.zzq(parcel, zzaT);
                    break;
                case Dimension.UNIT_MM /*5*/:
                    uri = (Uri) zzb.zza(parcel, zzaT, Uri.CREATOR);
                    break;
                case BuyButtonText.LOGO_ONLY /*6*/:
                    str2 = zzb.zzq(parcel, zzaT);
                    break;
                case BuyButtonText.DONATE_WITH /*7*/:
                    str3 = zzb.zzq(parcel, zzaT);
                    break;
                case Requests.MAX_REQUEST_RECIPIENTS /*8*/:
                    str4 = zzb.zzq(parcel, zzaT);
                    break;
                case HTTP.HT /*9*/:
                    j = zzb.zzi(parcel, zzaT);
                    break;
                case HTTP.LF /*10*/:
                    j2 = zzb.zzi(parcel, zzaT);
                    break;
                case ConnectionResult.LICENSE_CHECK_FAILED /*11*/:
                    f = zzb.zzl(parcel, zzaT);
                    break;
                case C0473R.styleable.MapAttrs_uiZoomGestures /*12*/:
                    str5 = zzb.zzq(parcel, zzaT);
                    break;
                case HTTP.CR /*13*/:
                    z = zzb.zzc(parcel, zzaT);
                    break;
                case GamesStatusCodes.STATUS_INTERRUPTED /*14*/:
                    j3 = zzb.zzi(parcel, zzaT);
                    break;
                case GamesStatusCodes.STATUS_TIMEOUT /*15*/:
                    str6 = zzb.zzq(parcel, zzaT);
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
            return new SnapshotMetadataEntity(i, gameEntity, playerEntity, str, uri, str2, str3, str4, j, j2, f, str5, z, j3, str6);
        }
        throw new zza("Overread allowed size end=" + zzaU, parcel);
    }

    public SnapshotMetadataEntity[] zzjf(int i) {
        return new SnapshotMetadataEntity[i];
    }
}
