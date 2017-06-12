package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;
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

public class zzab implements Creator<Session> {
    static void zza(Session session, Parcel parcel, int i) {
        int zzaV = zzc.zzaV(parcel);
        zzc.zza(parcel, 1, session.zzpN());
        zzc.zza(parcel, 2, session.zzzx());
        zzc.zza(parcel, 3, session.getName(), false);
        zzc.zza(parcel, 4, session.getIdentifier(), false);
        zzc.zza(parcel, 5, session.getDescription(), false);
        zzc.zzc(parcel, 7, session.zzBg());
        zzc.zzc(parcel, CardNetwork.OTHER, session.getVersionCode());
        zzc.zza(parcel, 8, session.zzBs(), i, false);
        zzc.zza(parcel, 9, session.zzBJ(), false);
        zzc.zzJ(parcel, zzaV);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzeg(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzgN(i);
    }

    public Session zzeg(Parcel parcel) {
        long j = 0;
        int i = 0;
        Long l = null;
        int zzaU = zzb.zzaU(parcel);
        zzb com_google_android_gms_fitness_data_zzb = null;
        String str = null;
        String str2 = null;
        String str3 = null;
        long j2 = 0;
        int i2 = 0;
        while (parcel.dataPosition() < zzaU) {
            int zzaT = zzb.zzaT(parcel);
            switch (zzb.zzcW(zzaT)) {
                case MessageApi.FILTER_PREFIX /*1*/:
                    j2 = zzb.zzi(parcel, zzaT);
                    break;
                case ChannelListener.CLOSE_REASON_REMOTE_CLOSE /*2*/:
                    j = zzb.zzi(parcel, zzaT);
                    break;
                case ChannelListener.CLOSE_REASON_LOCAL_CLOSE /*3*/:
                    str3 = zzb.zzq(parcel, zzaT);
                    break;
                case Dimension.UNIT_IN /*4*/:
                    str2 = zzb.zzq(parcel, zzaT);
                    break;
                case Dimension.UNIT_MM /*5*/:
                    str = zzb.zzq(parcel, zzaT);
                    break;
                case BuyButtonText.DONATE_WITH /*7*/:
                    i = zzb.zzg(parcel, zzaT);
                    break;
                case Requests.MAX_REQUEST_RECIPIENTS /*8*/:
                    com_google_android_gms_fitness_data_zzb = (zzb) zzb.zza(parcel, zzaT, zzb.CREATOR);
                    break;
                case HTTP.HT /*9*/:
                    l = zzb.zzj(parcel, zzaT);
                    break;
                case CardNetwork.OTHER /*1000*/:
                    i2 = zzb.zzg(parcel, zzaT);
                    break;
                default:
                    zzb.zzb(parcel, zzaT);
                    break;
            }
        }
        if (parcel.dataPosition() == zzaU) {
            return new Session(i2, j2, j, str3, str2, str, i, com_google_android_gms_fitness_data_zzb, l);
        }
        throw new zza("Overread allowed size end=" + zzaU, parcel);
    }

    public Session[] zzgN(int i) {
        return new Session[i];
    }
}
