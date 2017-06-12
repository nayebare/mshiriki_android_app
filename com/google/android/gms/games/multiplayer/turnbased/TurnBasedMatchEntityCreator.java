package com.google.android.gms.games.multiplayer.turnbased;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.C0473R;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.common.internal.safeparcel.zzb.zza;
import com.google.android.gms.common.internal.safeparcel.zzc;
import com.google.android.gms.games.GameEntity;
import com.google.android.gms.games.GamesStatusCodes;
import com.google.android.gms.games.Notifications;
import com.google.android.gms.games.multiplayer.ParticipantEntity;
import com.google.android.gms.games.request.Requests;
import com.google.android.gms.wallet.WalletConstants.CardNetwork;
import com.google.android.gms.wallet.fragment.WalletFragmentStyle.BuyButtonText;
import com.google.android.gms.wallet.fragment.WalletFragmentStyle.Dimension;
import com.google.android.gms.wearable.ChannelApi.ChannelListener;
import com.google.android.gms.wearable.MessageApi;
import java.util.ArrayList;
import org.apache.http.protocol.HTTP;

public class TurnBasedMatchEntityCreator implements Creator<TurnBasedMatchEntity> {
    static void zza(TurnBasedMatchEntity turnBasedMatchEntity, Parcel parcel, int i) {
        int zzaV = zzc.zzaV(parcel);
        zzc.zza(parcel, 1, turnBasedMatchEntity.getGame(), i, false);
        zzc.zza(parcel, 2, turnBasedMatchEntity.getMatchId(), false);
        zzc.zza(parcel, 3, turnBasedMatchEntity.getCreatorId(), false);
        zzc.zza(parcel, 4, turnBasedMatchEntity.getCreationTimestamp());
        zzc.zza(parcel, 5, turnBasedMatchEntity.getLastUpdaterId(), false);
        zzc.zza(parcel, 6, turnBasedMatchEntity.getLastUpdatedTimestamp());
        zzc.zza(parcel, 7, turnBasedMatchEntity.getPendingParticipantId(), false);
        zzc.zzc(parcel, CardNetwork.OTHER, turnBasedMatchEntity.getVersionCode());
        zzc.zzc(parcel, 8, turnBasedMatchEntity.getStatus());
        zzc.zzc(parcel, 10, turnBasedMatchEntity.getVariant());
        zzc.zzc(parcel, 11, turnBasedMatchEntity.getVersion());
        zzc.zza(parcel, 12, turnBasedMatchEntity.getData(), false);
        zzc.zzc(parcel, 13, turnBasedMatchEntity.getParticipants(), false);
        zzc.zza(parcel, 14, turnBasedMatchEntity.getRematchId(), false);
        zzc.zza(parcel, 15, turnBasedMatchEntity.getPreviousMatchData(), false);
        zzc.zzc(parcel, 16, turnBasedMatchEntity.getMatchNumber());
        zzc.zza(parcel, 17, turnBasedMatchEntity.getAutoMatchCriteria(), false);
        zzc.zzc(parcel, 18, turnBasedMatchEntity.getTurnStatus());
        zzc.zza(parcel, 19, turnBasedMatchEntity.isLocallyModified());
        zzc.zza(parcel, 20, turnBasedMatchEntity.getDescription(), false);
        zzc.zza(parcel, 21, turnBasedMatchEntity.getDescriptionParticipantId(), false);
        zzc.zzJ(parcel, zzaV);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzfS(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zziX(i);
    }

    public TurnBasedMatchEntity zzfS(Parcel parcel) {
        int zzaU = zzb.zzaU(parcel);
        int i = 0;
        GameEntity gameEntity = null;
        String str = null;
        String str2 = null;
        long j = 0;
        String str3 = null;
        long j2 = 0;
        String str4 = null;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        byte[] bArr = null;
        ArrayList arrayList = null;
        String str5 = null;
        byte[] bArr2 = null;
        int i5 = 0;
        Bundle bundle = null;
        int i6 = 0;
        boolean z = false;
        String str6 = null;
        String str7 = null;
        while (parcel.dataPosition() < zzaU) {
            int zzaT = zzb.zzaT(parcel);
            switch (zzb.zzcW(zzaT)) {
                case MessageApi.FILTER_PREFIX /*1*/:
                    gameEntity = (GameEntity) zzb.zza(parcel, zzaT, GameEntity.CREATOR);
                    break;
                case ChannelListener.CLOSE_REASON_REMOTE_CLOSE /*2*/:
                    str = zzb.zzq(parcel, zzaT);
                    break;
                case ChannelListener.CLOSE_REASON_LOCAL_CLOSE /*3*/:
                    str2 = zzb.zzq(parcel, zzaT);
                    break;
                case Dimension.UNIT_IN /*4*/:
                    j = zzb.zzi(parcel, zzaT);
                    break;
                case Dimension.UNIT_MM /*5*/:
                    str3 = zzb.zzq(parcel, zzaT);
                    break;
                case BuyButtonText.LOGO_ONLY /*6*/:
                    j2 = zzb.zzi(parcel, zzaT);
                    break;
                case BuyButtonText.DONATE_WITH /*7*/:
                    str4 = zzb.zzq(parcel, zzaT);
                    break;
                case Requests.MAX_REQUEST_RECIPIENTS /*8*/:
                    i2 = zzb.zzg(parcel, zzaT);
                    break;
                case HTTP.LF /*10*/:
                    i3 = zzb.zzg(parcel, zzaT);
                    break;
                case ConnectionResult.LICENSE_CHECK_FAILED /*11*/:
                    i4 = zzb.zzg(parcel, zzaT);
                    break;
                case C0473R.styleable.MapAttrs_uiZoomGestures /*12*/:
                    bArr = zzb.zzt(parcel, zzaT);
                    break;
                case HTTP.CR /*13*/:
                    arrayList = zzb.zzc(parcel, zzaT, ParticipantEntity.CREATOR);
                    break;
                case GamesStatusCodes.STATUS_INTERRUPTED /*14*/:
                    str5 = zzb.zzq(parcel, zzaT);
                    break;
                case GamesStatusCodes.STATUS_TIMEOUT /*15*/:
                    bArr2 = zzb.zzt(parcel, zzaT);
                    break;
                case Notifications.NOTIFICATION_TYPE_LEVEL_UP /*16*/:
                    i5 = zzb.zzg(parcel, zzaT);
                    break;
                case ConnectionResult.SIGN_IN_FAILED /*17*/:
                    bundle = zzb.zzs(parcel, zzaT);
                    break;
                case ConnectionResult.SERVICE_UPDATING /*18*/:
                    i6 = zzb.zzg(parcel, zzaT);
                    break;
                case ConnectionResult.SERVICE_MISSING_PERMISSION /*19*/:
                    z = zzb.zzc(parcel, zzaT);
                    break;
                case ConnectionResult.RESTRICTED_PROFILE /*20*/:
                    str6 = zzb.zzq(parcel, zzaT);
                    break;
                case C0473R.styleable.MapAttrs_latLngBoundsNorthEastLatitude /*21*/:
                    str7 = zzb.zzq(parcel, zzaT);
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
            return new TurnBasedMatchEntity(i, gameEntity, str, str2, j, str3, j2, str4, i2, i3, i4, bArr, arrayList, str5, bArr2, i5, bundle, i6, z, str6, str7);
        }
        throw new zza("Overread allowed size end=" + zzaU, parcel);
    }

    public TurnBasedMatchEntity[] zziX(int i) {
        return new TurnBasedMatchEntity[i];
    }
}
