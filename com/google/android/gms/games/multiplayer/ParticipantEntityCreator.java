package com.google.android.gms.games.multiplayer;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.C0473R;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.common.internal.safeparcel.zzb.zza;
import com.google.android.gms.common.internal.safeparcel.zzc;
import com.google.android.gms.games.PlayerEntity;
import com.google.android.gms.games.request.Requests;
import com.google.android.gms.wallet.WalletConstants.CardNetwork;
import com.google.android.gms.wallet.fragment.WalletFragmentStyle.BuyButtonText;
import com.google.android.gms.wallet.fragment.WalletFragmentStyle.Dimension;
import com.google.android.gms.wearable.ChannelApi.ChannelListener;
import com.google.android.gms.wearable.MessageApi;
import org.apache.http.protocol.HTTP;

public class ParticipantEntityCreator implements Creator<ParticipantEntity> {
    static void zza(ParticipantEntity participantEntity, Parcel parcel, int i) {
        int zzaV = zzc.zzaV(parcel);
        zzc.zza(parcel, 1, participantEntity.getParticipantId(), false);
        zzc.zza(parcel, 2, participantEntity.getDisplayName(), false);
        zzc.zza(parcel, 3, participantEntity.getIconImageUri(), i, false);
        zzc.zza(parcel, 4, participantEntity.getHiResImageUri(), i, false);
        zzc.zzc(parcel, 5, participantEntity.getStatus());
        zzc.zza(parcel, 6, participantEntity.zzDY(), false);
        zzc.zza(parcel, 7, participantEntity.isConnectedToRoom());
        zzc.zzc(parcel, CardNetwork.OTHER, participantEntity.getVersionCode());
        zzc.zza(parcel, 8, participantEntity.getPlayer(), i, false);
        zzc.zzc(parcel, 9, participantEntity.getCapabilities());
        zzc.zza(parcel, 10, participantEntity.getResult(), i, false);
        zzc.zza(parcel, 11, participantEntity.getIconImageUrl(), false);
        zzc.zza(parcel, 12, participantEntity.getHiResImageUrl(), false);
        zzc.zzJ(parcel, zzaV);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzfO(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zziT(i);
    }

    public ParticipantEntity zzfO(Parcel parcel) {
        int zzaU = zzb.zzaU(parcel);
        int i = 0;
        String str = null;
        String str2 = null;
        Uri uri = null;
        Uri uri2 = null;
        int i2 = 0;
        String str3 = null;
        boolean z = false;
        PlayerEntity playerEntity = null;
        int i3 = 0;
        ParticipantResult participantResult = null;
        String str4 = null;
        String str5 = null;
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
                    i2 = zzb.zzg(parcel, zzaT);
                    break;
                case BuyButtonText.LOGO_ONLY /*6*/:
                    str3 = zzb.zzq(parcel, zzaT);
                    break;
                case BuyButtonText.DONATE_WITH /*7*/:
                    z = zzb.zzc(parcel, zzaT);
                    break;
                case Requests.MAX_REQUEST_RECIPIENTS /*8*/:
                    playerEntity = (PlayerEntity) zzb.zza(parcel, zzaT, PlayerEntity.CREATOR);
                    break;
                case HTTP.HT /*9*/:
                    i3 = zzb.zzg(parcel, zzaT);
                    break;
                case HTTP.LF /*10*/:
                    participantResult = (ParticipantResult) zzb.zza(parcel, zzaT, ParticipantResult.CREATOR);
                    break;
                case ConnectionResult.LICENSE_CHECK_FAILED /*11*/:
                    str4 = zzb.zzq(parcel, zzaT);
                    break;
                case C0473R.styleable.MapAttrs_uiZoomGestures /*12*/:
                    str5 = zzb.zzq(parcel, zzaT);
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
            return new ParticipantEntity(i, str, str2, uri, uri2, i2, str3, z, playerEntity, i3, participantResult, str4, str5);
        }
        throw new zza("Overread allowed size end=" + zzaU, parcel);
    }

    public ParticipantEntity[] zziT(int i) {
        return new ParticipantEntity[i];
    }
}
