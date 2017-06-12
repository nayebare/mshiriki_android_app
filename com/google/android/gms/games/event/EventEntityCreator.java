package com.google.android.gms.games.event;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.common.internal.safeparcel.zzb.zza;
import com.google.android.gms.common.internal.safeparcel.zzc;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.PlayerEntity;
import com.google.android.gms.games.request.Requests;
import com.google.android.gms.wallet.WalletConstants.CardNetwork;
import com.google.android.gms.wallet.fragment.WalletFragmentStyle.BuyButtonText;
import com.google.android.gms.wallet.fragment.WalletFragmentStyle.Dimension;
import com.google.android.gms.wearable.ChannelApi.ChannelListener;
import com.google.android.gms.wearable.MessageApi;
import org.apache.http.protocol.HTTP;

public class EventEntityCreator implements Creator<EventEntity> {
    static void zza(EventEntity eventEntity, Parcel parcel, int i) {
        int zzaV = zzc.zzaV(parcel);
        zzc.zza(parcel, 1, eventEntity.getEventId(), false);
        zzc.zza(parcel, 2, eventEntity.getName(), false);
        zzc.zza(parcel, 3, eventEntity.getDescription(), false);
        zzc.zza(parcel, 4, eventEntity.getIconImageUri(), i, false);
        zzc.zza(parcel, 5, eventEntity.getIconImageUrl(), false);
        zzc.zza(parcel, 6, eventEntity.getPlayer(), i, false);
        zzc.zza(parcel, 7, eventEntity.getValue());
        zzc.zzc(parcel, CardNetwork.OTHER, eventEntity.getVersionCode());
        zzc.zza(parcel, 8, eventEntity.getFormattedValue(), false);
        zzc.zza(parcel, 9, eventEntity.isVisible());
        zzc.zzJ(parcel, zzaV);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzfC(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzim(i);
    }

    public EventEntity zzfC(Parcel parcel) {
        boolean z = false;
        String str = null;
        int zzaU = zzb.zzaU(parcel);
        long j = 0;
        Player player = null;
        String str2 = null;
        Uri uri = null;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        int i = 0;
        while (parcel.dataPosition() < zzaU) {
            int zzaT = zzb.zzaT(parcel);
            switch (zzb.zzcW(zzaT)) {
                case MessageApi.FILTER_PREFIX /*1*/:
                    str5 = zzb.zzq(parcel, zzaT);
                    break;
                case ChannelListener.CLOSE_REASON_REMOTE_CLOSE /*2*/:
                    str4 = zzb.zzq(parcel, zzaT);
                    break;
                case ChannelListener.CLOSE_REASON_LOCAL_CLOSE /*3*/:
                    str3 = zzb.zzq(parcel, zzaT);
                    break;
                case Dimension.UNIT_IN /*4*/:
                    uri = (Uri) zzb.zza(parcel, zzaT, Uri.CREATOR);
                    break;
                case Dimension.UNIT_MM /*5*/:
                    str2 = zzb.zzq(parcel, zzaT);
                    break;
                case BuyButtonText.LOGO_ONLY /*6*/:
                    player = (PlayerEntity) zzb.zza(parcel, zzaT, PlayerEntity.CREATOR);
                    break;
                case BuyButtonText.DONATE_WITH /*7*/:
                    j = zzb.zzi(parcel, zzaT);
                    break;
                case Requests.MAX_REQUEST_RECIPIENTS /*8*/:
                    str = zzb.zzq(parcel, zzaT);
                    break;
                case HTTP.HT /*9*/:
                    z = zzb.zzc(parcel, zzaT);
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
            return new EventEntity(i, str5, str4, str3, uri, str2, player, j, str, z);
        }
        throw new zza("Overread allowed size end=" + zzaU, parcel);
    }

    public EventEntity[] zzim(int i) {
        return new EventEntity[i];
    }
}
