package com.google.android.gms.games.multiplayer.realtime;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.common.internal.safeparcel.zzb.zza;
import com.google.android.gms.common.internal.safeparcel.zzc;
import com.google.android.gms.games.multiplayer.ParticipantEntity;
import com.google.android.gms.games.request.Requests;
import com.google.android.gms.wallet.WalletConstants.CardNetwork;
import com.google.android.gms.wallet.fragment.WalletFragmentStyle.BuyButtonText;
import com.google.android.gms.wallet.fragment.WalletFragmentStyle.Dimension;
import com.google.android.gms.wearable.ChannelApi.ChannelListener;
import com.google.android.gms.wearable.MessageApi;
import java.util.ArrayList;
import org.apache.http.protocol.HTTP;

public class RoomEntityCreator implements Creator<RoomEntity> {
    static void zza(RoomEntity roomEntity, Parcel parcel, int i) {
        int zzaV = zzc.zzaV(parcel);
        zzc.zza(parcel, 1, roomEntity.getRoomId(), false);
        zzc.zza(parcel, 2, roomEntity.getCreatorId(), false);
        zzc.zza(parcel, 3, roomEntity.getCreationTimestamp());
        zzc.zzc(parcel, 4, roomEntity.getStatus());
        zzc.zza(parcel, 5, roomEntity.getDescription(), false);
        zzc.zzc(parcel, 6, roomEntity.getVariant());
        zzc.zza(parcel, 7, roomEntity.getAutoMatchCriteria(), false);
        zzc.zzc(parcel, CardNetwork.OTHER, roomEntity.getVersionCode());
        zzc.zzc(parcel, 8, roomEntity.getParticipants(), false);
        zzc.zzc(parcel, 9, roomEntity.getAutoMatchWaitEstimateSeconds());
        zzc.zzJ(parcel, zzaV);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzfR(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zziW(i);
    }

    public RoomEntity zzfR(Parcel parcel) {
        int i = 0;
        ArrayList arrayList = null;
        int zzaU = zzb.zzaU(parcel);
        long j = 0;
        Bundle bundle = null;
        int i2 = 0;
        String str = null;
        int i3 = 0;
        String str2 = null;
        String str3 = null;
        int i4 = 0;
        while (parcel.dataPosition() < zzaU) {
            int zzaT = zzb.zzaT(parcel);
            switch (zzb.zzcW(zzaT)) {
                case MessageApi.FILTER_PREFIX /*1*/:
                    str3 = zzb.zzq(parcel, zzaT);
                    break;
                case ChannelListener.CLOSE_REASON_REMOTE_CLOSE /*2*/:
                    str2 = zzb.zzq(parcel, zzaT);
                    break;
                case ChannelListener.CLOSE_REASON_LOCAL_CLOSE /*3*/:
                    j = zzb.zzi(parcel, zzaT);
                    break;
                case Dimension.UNIT_IN /*4*/:
                    i3 = zzb.zzg(parcel, zzaT);
                    break;
                case Dimension.UNIT_MM /*5*/:
                    str = zzb.zzq(parcel, zzaT);
                    break;
                case BuyButtonText.LOGO_ONLY /*6*/:
                    i2 = zzb.zzg(parcel, zzaT);
                    break;
                case BuyButtonText.DONATE_WITH /*7*/:
                    bundle = zzb.zzs(parcel, zzaT);
                    break;
                case Requests.MAX_REQUEST_RECIPIENTS /*8*/:
                    arrayList = zzb.zzc(parcel, zzaT, ParticipantEntity.CREATOR);
                    break;
                case HTTP.HT /*9*/:
                    i = zzb.zzg(parcel, zzaT);
                    break;
                case CardNetwork.OTHER /*1000*/:
                    i4 = zzb.zzg(parcel, zzaT);
                    break;
                default:
                    zzb.zzb(parcel, zzaT);
                    break;
            }
        }
        if (parcel.dataPosition() == zzaU) {
            return new RoomEntity(i4, str3, str2, j, i3, str, i2, bundle, arrayList, i);
        }
        throw new zza("Overread allowed size end=" + zzaU, parcel);
    }

    public RoomEntity[] zziW(int i) {
        return new RoomEntity[i];
    }
}
