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
import com.google.android.gms.games.request.Requests;
import com.google.android.gms.wallet.WalletConstants.CardNetwork;
import com.google.android.gms.wallet.fragment.WalletFragmentStyle.BuyButtonText;
import com.google.android.gms.wallet.fragment.WalletFragmentStyle.Dimension;
import com.google.android.gms.wearable.ChannelApi.ChannelListener;
import com.google.android.gms.wearable.MessageApi;
import org.apache.http.protocol.HTTP;

public class GameEntityCreator implements Creator<GameEntity> {
    static void zza(GameEntity gameEntity, Parcel parcel, int i) {
        int zzaV = zzc.zzaV(parcel);
        zzc.zza(parcel, 1, gameEntity.getApplicationId(), false);
        zzc.zza(parcel, 2, gameEntity.getDisplayName(), false);
        zzc.zza(parcel, 3, gameEntity.getPrimaryCategory(), false);
        zzc.zza(parcel, 4, gameEntity.getSecondaryCategory(), false);
        zzc.zza(parcel, 5, gameEntity.getDescription(), false);
        zzc.zza(parcel, 6, gameEntity.getDeveloperName(), false);
        zzc.zza(parcel, 7, gameEntity.getIconImageUri(), i, false);
        zzc.zza(parcel, 8, gameEntity.getHiResImageUri(), i, false);
        zzc.zza(parcel, 9, gameEntity.getFeaturedImageUri(), i, false);
        zzc.zza(parcel, 10, gameEntity.zzCV());
        zzc.zza(parcel, 11, gameEntity.zzCX());
        zzc.zza(parcel, 12, gameEntity.zzCY(), false);
        zzc.zzc(parcel, 13, gameEntity.zzCZ());
        zzc.zzc(parcel, 14, gameEntity.getAchievementTotalCount());
        zzc.zzc(parcel, 15, gameEntity.getLeaderboardCount());
        zzc.zza(parcel, 16, gameEntity.isRealTimeMultiplayerEnabled());
        zzc.zza(parcel, 17, gameEntity.isTurnBasedMultiplayerEnabled());
        zzc.zza(parcel, 18, gameEntity.getIconImageUrl(), false);
        zzc.zza(parcel, 19, gameEntity.getHiResImageUrl(), false);
        zzc.zza(parcel, 20, gameEntity.getFeaturedImageUrl(), false);
        zzc.zza(parcel, 21, gameEntity.isMuted());
        zzc.zza(parcel, 22, gameEntity.zzCW());
        zzc.zza(parcel, 23, gameEntity.areSnapshotsEnabled());
        zzc.zza(parcel, 24, gameEntity.getThemeColor(), false);
        zzc.zza(parcel, 25, gameEntity.hasGamepadSupport());
        zzc.zzc(parcel, CardNetwork.OTHER, gameEntity.getVersionCode());
        zzc.zzJ(parcel, zzaV);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzfr(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzia(i);
    }

    public GameEntity zzfr(Parcel parcel) {
        int zzaU = zzb.zzaU(parcel);
        int i = 0;
        String str = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        String str6 = null;
        Uri uri = null;
        Uri uri2 = null;
        Uri uri3 = null;
        boolean z = false;
        boolean z2 = false;
        String str7 = null;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        boolean z3 = false;
        boolean z4 = false;
        String str8 = null;
        String str9 = null;
        String str10 = null;
        boolean z5 = false;
        boolean z6 = false;
        boolean z7 = false;
        String str11 = null;
        boolean z8 = false;
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
                    str3 = zzb.zzq(parcel, zzaT);
                    break;
                case Dimension.UNIT_IN /*4*/:
                    str4 = zzb.zzq(parcel, zzaT);
                    break;
                case Dimension.UNIT_MM /*5*/:
                    str5 = zzb.zzq(parcel, zzaT);
                    break;
                case BuyButtonText.LOGO_ONLY /*6*/:
                    str6 = zzb.zzq(parcel, zzaT);
                    break;
                case BuyButtonText.DONATE_WITH /*7*/:
                    uri = (Uri) zzb.zza(parcel, zzaT, Uri.CREATOR);
                    break;
                case Requests.MAX_REQUEST_RECIPIENTS /*8*/:
                    uri2 = (Uri) zzb.zza(parcel, zzaT, Uri.CREATOR);
                    break;
                case HTTP.HT /*9*/:
                    uri3 = (Uri) zzb.zza(parcel, zzaT, Uri.CREATOR);
                    break;
                case HTTP.LF /*10*/:
                    z = zzb.zzc(parcel, zzaT);
                    break;
                case ConnectionResult.LICENSE_CHECK_FAILED /*11*/:
                    z2 = zzb.zzc(parcel, zzaT);
                    break;
                case C0473R.styleable.MapAttrs_uiZoomGestures /*12*/:
                    str7 = zzb.zzq(parcel, zzaT);
                    break;
                case HTTP.CR /*13*/:
                    i2 = zzb.zzg(parcel, zzaT);
                    break;
                case GamesStatusCodes.STATUS_INTERRUPTED /*14*/:
                    i3 = zzb.zzg(parcel, zzaT);
                    break;
                case GamesStatusCodes.STATUS_TIMEOUT /*15*/:
                    i4 = zzb.zzg(parcel, zzaT);
                    break;
                case Notifications.NOTIFICATION_TYPE_LEVEL_UP /*16*/:
                    z3 = zzb.zzc(parcel, zzaT);
                    break;
                case ConnectionResult.SIGN_IN_FAILED /*17*/:
                    z4 = zzb.zzc(parcel, zzaT);
                    break;
                case ConnectionResult.SERVICE_UPDATING /*18*/:
                    str8 = zzb.zzq(parcel, zzaT);
                    break;
                case ConnectionResult.SERVICE_MISSING_PERMISSION /*19*/:
                    str9 = zzb.zzq(parcel, zzaT);
                    break;
                case ConnectionResult.RESTRICTED_PROFILE /*20*/:
                    str10 = zzb.zzq(parcel, zzaT);
                    break;
                case C0473R.styleable.MapAttrs_latLngBoundsNorthEastLatitude /*21*/:
                    z5 = zzb.zzc(parcel, zzaT);
                    break;
                case C0473R.styleable.MapAttrs_latLngBoundsNorthEastLongitude /*22*/:
                    z6 = zzb.zzc(parcel, zzaT);
                    break;
                case C0308R.styleable.Toolbar_collapseContentDescription /*23*/:
                    z7 = zzb.zzc(parcel, zzaT);
                    break;
                case C0308R.styleable.Toolbar_navigationIcon /*24*/:
                    str11 = zzb.zzq(parcel, zzaT);
                    break;
                case C0308R.styleable.Toolbar_navigationContentDescription /*25*/:
                    z8 = zzb.zzc(parcel, zzaT);
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
            return new GameEntity(i, str, str2, str3, str4, str5, str6, uri, uri2, uri3, z, z2, str7, i2, i3, i4, z3, z4, str8, str9, str10, z5, z6, z7, str11, z8);
        }
        throw new zza("Overread allowed size end=" + zzaU, parcel);
    }

    public GameEntity[] zzia(int i) {
        return new GameEntity[i];
    }
}
