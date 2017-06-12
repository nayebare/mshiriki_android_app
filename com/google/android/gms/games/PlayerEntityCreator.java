package com.google.android.gms.games;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.v7.mediarouter.C0308R;
import com.google.android.gms.C0473R;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.common.internal.safeparcel.zzb.zza;
import com.google.android.gms.common.internal.safeparcel.zzc;
import com.google.android.gms.games.internal.player.MostRecentGameInfoEntity;
import com.google.android.gms.games.request.Requests;
import com.google.android.gms.wallet.WalletConstants.CardNetwork;
import com.google.android.gms.wallet.fragment.WalletFragmentStyle.BuyButtonText;
import com.google.android.gms.wallet.fragment.WalletFragmentStyle.Dimension;
import com.google.android.gms.wearable.ChannelApi.ChannelListener;
import com.google.android.gms.wearable.MessageApi;
import org.apache.http.protocol.HTTP;

public class PlayerEntityCreator implements Creator<PlayerEntity> {
    static void zza(PlayerEntity playerEntity, Parcel parcel, int i) {
        int zzaV = zzc.zzaV(parcel);
        zzc.zza(parcel, 1, playerEntity.getPlayerId(), false);
        zzc.zza(parcel, 2, playerEntity.getDisplayName(), false);
        zzc.zza(parcel, 3, playerEntity.getIconImageUri(), i, false);
        zzc.zza(parcel, 4, playerEntity.getHiResImageUri(), i, false);
        zzc.zza(parcel, 5, playerEntity.getRetrievedTimestamp());
        zzc.zzc(parcel, 6, playerEntity.zzDe());
        zzc.zza(parcel, 7, playerEntity.getLastPlayedWithTimestamp());
        zzc.zzc(parcel, CardNetwork.OTHER, playerEntity.getVersionCode());
        zzc.zza(parcel, 8, playerEntity.getIconImageUrl(), false);
        zzc.zza(parcel, 9, playerEntity.getHiResImageUrl(), false);
        zzc.zza(parcel, 14, playerEntity.getTitle(), false);
        zzc.zza(parcel, 15, playerEntity.zzDg(), i, false);
        zzc.zza(parcel, 16, playerEntity.getLevelInfo(), i, false);
        zzc.zza(parcel, 18, playerEntity.zzDf());
        zzc.zza(parcel, 19, playerEntity.zzDd());
        zzc.zza(parcel, 20, playerEntity.zzDc(), false);
        zzc.zza(parcel, 21, playerEntity.getName(), false);
        zzc.zza(parcel, 22, playerEntity.getBannerImageLandscapeUri(), i, false);
        zzc.zza(parcel, 23, playerEntity.getBannerImageLandscapeUrl(), false);
        zzc.zza(parcel, 24, playerEntity.getBannerImagePortraitUri(), i, false);
        zzc.zza(parcel, 25, playerEntity.getBannerImagePortraitUrl(), false);
        zzc.zzc(parcel, 26, playerEntity.zzDh());
        zzc.zza(parcel, 27, playerEntity.zzDi());
        zzc.zza(parcel, 28, playerEntity.isMuted());
        zzc.zzJ(parcel, zzaV);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzfs(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzic(i);
    }

    public PlayerEntity zzfs(Parcel parcel) {
        int zzaU = zzb.zzaU(parcel);
        int i = 0;
        String str = null;
        String str2 = null;
        Uri uri = null;
        Uri uri2 = null;
        long j = 0;
        int i2 = 0;
        long j2 = 0;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        MostRecentGameInfoEntity mostRecentGameInfoEntity = null;
        PlayerLevelInfo playerLevelInfo = null;
        boolean z = false;
        boolean z2 = false;
        String str6 = null;
        String str7 = null;
        Uri uri3 = null;
        String str8 = null;
        Uri uri4 = null;
        String str9 = null;
        int i3 = 0;
        long j3 = 0;
        boolean z3 = false;
        while (parcel.dataPosition() < zzaU) {
            int zzaT = zzb.zzaT(parcel);
            switch (zzb.zzcW(zzaT)) {
                case MessageApi.FILTER_PREFIX /*1*/:
                    str = zzb.zzq(parcel, zzaT);
                    break;
                case ChannelListener.CLOSE_REASON_REMOTE_CLOSE /*2*/:
                    str2 = zzb.zzq(parcel, zzaT);
                    break;
                case ChannelListener.CLOSE_REASON_LOCAL_CLOSE /*3*/:
                    uri = (Uri) zzb.zza(parcel, zzaT, Uri.CREATOR);
                    break;
                case Dimension.UNIT_IN /*4*/:
                    uri2 = (Uri) zzb.zza(parcel, zzaT, Uri.CREATOR);
                    break;
                case Dimension.UNIT_MM /*5*/:
                    j = zzb.zzi(parcel, zzaT);
                    break;
                case BuyButtonText.LOGO_ONLY /*6*/:
                    i2 = zzb.zzg(parcel, zzaT);
                    break;
                case BuyButtonText.DONATE_WITH /*7*/:
                    j2 = zzb.zzi(parcel, zzaT);
                    break;
                case Requests.MAX_REQUEST_RECIPIENTS /*8*/:
                    str3 = zzb.zzq(parcel, zzaT);
                    break;
                case HTTP.HT /*9*/:
                    str4 = zzb.zzq(parcel, zzaT);
                    break;
                case GamesStatusCodes.STATUS_INTERRUPTED /*14*/:
                    str5 = zzb.zzq(parcel, zzaT);
                    break;
                case GamesStatusCodes.STATUS_TIMEOUT /*15*/:
                    mostRecentGameInfoEntity = (MostRecentGameInfoEntity) zzb.zza(parcel, zzaT, MostRecentGameInfoEntity.CREATOR);
                    break;
                case Notifications.NOTIFICATION_TYPE_LEVEL_UP /*16*/:
                    playerLevelInfo = (PlayerLevelInfo) zzb.zza(parcel, zzaT, PlayerLevelInfo.CREATOR);
                    break;
                case ConnectionResult.SERVICE_UPDATING /*18*/:
                    z = zzb.zzc(parcel, zzaT);
                    break;
                case ConnectionResult.SERVICE_MISSING_PERMISSION /*19*/:
                    z2 = zzb.zzc(parcel, zzaT);
                    break;
                case ConnectionResult.RESTRICTED_PROFILE /*20*/:
                    str6 = zzb.zzq(parcel, zzaT);
                    break;
                case C0473R.styleable.MapAttrs_latLngBoundsNorthEastLatitude /*21*/:
                    str7 = zzb.zzq(parcel, zzaT);
                    break;
                case C0473R.styleable.MapAttrs_latLngBoundsNorthEastLongitude /*22*/:
                    uri3 = (Uri) zzb.zza(parcel, zzaT, Uri.CREATOR);
                    break;
                case C0308R.styleable.Toolbar_collapseContentDescription /*23*/:
                    str8 = zzb.zzq(parcel, zzaT);
                    break;
                case C0308R.styleable.Toolbar_navigationIcon /*24*/:
                    uri4 = (Uri) zzb.zza(parcel, zzaT, Uri.CREATOR);
                    break;
                case C0308R.styleable.Toolbar_navigationContentDescription /*25*/:
                    str9 = zzb.zzq(parcel, zzaT);
                    break;
                case C0308R.styleable.Toolbar_logoDescription /*26*/:
                    i3 = zzb.zzg(parcel, zzaT);
                    break;
                case C0308R.styleable.Toolbar_titleTextColor /*27*/:
                    j3 = zzb.zzi(parcel, zzaT);
                    break;
                case C0308R.styleable.Toolbar_subtitleTextColor /*28*/:
                    z3 = zzb.zzc(parcel, zzaT);
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
            return new PlayerEntity(i, str, str2, uri, uri2, j, i2, j2, str3, str4, str5, mostRecentGameInfoEntity, playerLevelInfo, z, z2, str6, str7, uri3, str8, uri4, str9, i3, j3, z3);
        }
        throw new zza("Overread allowed size end=" + zzaU, parcel);
    }

    public PlayerEntity[] zzic(int i) {
        return new PlayerEntity[i];
    }
}
