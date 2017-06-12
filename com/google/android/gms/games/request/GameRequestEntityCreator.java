package com.google.android.gms.games.request;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.C0473R;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.common.internal.safeparcel.zzb.zza;
import com.google.android.gms.common.internal.safeparcel.zzc;
import com.google.android.gms.games.GameEntity;
import com.google.android.gms.games.PlayerEntity;
import com.google.android.gms.wallet.WalletConstants.CardNetwork;
import com.google.android.gms.wallet.fragment.WalletFragmentStyle.BuyButtonText;
import com.google.android.gms.wallet.fragment.WalletFragmentStyle.Dimension;
import com.google.android.gms.wearable.ChannelApi.ChannelListener;
import com.google.android.gms.wearable.MessageApi;
import java.util.ArrayList;
import org.apache.http.protocol.HTTP;

public class GameRequestEntityCreator implements Creator<GameRequestEntity> {
    static void zza(GameRequestEntity gameRequestEntity, Parcel parcel, int i) {
        int zzaV = zzc.zzaV(parcel);
        zzc.zza(parcel, 1, gameRequestEntity.getGame(), i, false);
        zzc.zza(parcel, 2, gameRequestEntity.getSender(), i, false);
        zzc.zza(parcel, 3, gameRequestEntity.getData(), false);
        zzc.zza(parcel, 4, gameRequestEntity.getRequestId(), false);
        zzc.zzc(parcel, 5, gameRequestEntity.getRecipients(), false);
        zzc.zzc(parcel, 7, gameRequestEntity.getType());
        zzc.zzc(parcel, CardNetwork.OTHER, gameRequestEntity.getVersionCode());
        zzc.zza(parcel, 9, gameRequestEntity.getCreationTimestamp());
        zzc.zza(parcel, 10, gameRequestEntity.getExpirationTimestamp());
        zzc.zza(parcel, 11, gameRequestEntity.zzFK(), false);
        zzc.zzc(parcel, 12, gameRequestEntity.getStatus());
        zzc.zzJ(parcel, zzaV);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzfV(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzja(i);
    }

    public GameRequestEntity zzfV(Parcel parcel) {
        int zzaU = zzb.zzaU(parcel);
        int i = 0;
        GameEntity gameEntity = null;
        PlayerEntity playerEntity = null;
        byte[] bArr = null;
        String str = null;
        ArrayList arrayList = null;
        int i2 = 0;
        long j = 0;
        long j2 = 0;
        Bundle bundle = null;
        int i3 = 0;
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
                    bArr = zzb.zzt(parcel, zzaT);
                    break;
                case Dimension.UNIT_IN /*4*/:
                    str = zzb.zzq(parcel, zzaT);
                    break;
                case Dimension.UNIT_MM /*5*/:
                    arrayList = zzb.zzc(parcel, zzaT, PlayerEntity.CREATOR);
                    break;
                case BuyButtonText.DONATE_WITH /*7*/:
                    i2 = zzb.zzg(parcel, zzaT);
                    break;
                case HTTP.HT /*9*/:
                    j = zzb.zzi(parcel, zzaT);
                    break;
                case HTTP.LF /*10*/:
                    j2 = zzb.zzi(parcel, zzaT);
                    break;
                case ConnectionResult.LICENSE_CHECK_FAILED /*11*/:
                    bundle = zzb.zzs(parcel, zzaT);
                    break;
                case C0473R.styleable.MapAttrs_uiZoomGestures /*12*/:
                    i3 = zzb.zzg(parcel, zzaT);
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
            return new GameRequestEntity(i, gameEntity, playerEntity, bArr, str, arrayList, i2, j, j2, bundle, i3);
        }
        throw new zza("Overread allowed size end=" + zzaU, parcel);
    }

    public GameRequestEntity[] zzja(int i) {
        return new GameRequestEntity[i];
    }
}
