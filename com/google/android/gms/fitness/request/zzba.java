package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.common.internal.safeparcel.zzb.zza;
import com.google.android.gms.common.internal.safeparcel.zzc;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.games.request.Requests;
import com.google.android.gms.wallet.WalletConstants.CardNetwork;
import com.google.android.gms.wallet.fragment.WalletFragmentStyle.BuyButtonText;
import com.google.android.gms.wallet.fragment.WalletFragmentStyle.Dimension;
import com.google.android.gms.wearable.ChannelApi.ChannelListener;
import com.google.android.gms.wearable.MessageApi;
import java.util.List;
import org.apache.http.protocol.HTTP;

public class zzba implements Creator<SessionReadRequest> {
    static void zza(SessionReadRequest sessionReadRequest, Parcel parcel, int i) {
        int zzaV = zzc.zzaV(parcel);
        zzc.zza(parcel, 1, sessionReadRequest.getSessionName(), false);
        zzc.zza(parcel, 2, sessionReadRequest.getSessionId(), false);
        zzc.zza(parcel, 3, sessionReadRequest.zzpN());
        zzc.zza(parcel, 4, sessionReadRequest.zzzx());
        zzc.zzc(parcel, 5, sessionReadRequest.getDataTypes(), false);
        zzc.zzc(parcel, 6, sessionReadRequest.getDataSources(), false);
        zzc.zza(parcel, 7, sessionReadRequest.zzCw());
        zzc.zzc(parcel, CardNetwork.OTHER, sessionReadRequest.getVersionCode());
        zzc.zza(parcel, 8, sessionReadRequest.zzCd());
        zzc.zzb(parcel, 9, sessionReadRequest.getExcludedPackages(), false);
        zzc.zza(parcel, 10, sessionReadRequest.getCallbackBinder(), false);
        zzc.zzJ(parcel, zzaV);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzeP(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzhy(i);
    }

    public SessionReadRequest zzeP(Parcel parcel) {
        int zzaU = zzb.zzaU(parcel);
        int i = 0;
        String str = null;
        String str2 = null;
        long j = 0;
        long j2 = 0;
        List list = null;
        List list2 = null;
        boolean z = false;
        boolean z2 = false;
        List list3 = null;
        IBinder iBinder = null;
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
                    j = zzb.zzi(parcel, zzaT);
                    break;
                case Dimension.UNIT_IN /*4*/:
                    j2 = zzb.zzi(parcel, zzaT);
                    break;
                case Dimension.UNIT_MM /*5*/:
                    list = zzb.zzc(parcel, zzaT, DataType.CREATOR);
                    break;
                case BuyButtonText.LOGO_ONLY /*6*/:
                    list2 = zzb.zzc(parcel, zzaT, DataSource.CREATOR);
                    break;
                case BuyButtonText.DONATE_WITH /*7*/:
                    z = zzb.zzc(parcel, zzaT);
                    break;
                case Requests.MAX_REQUEST_RECIPIENTS /*8*/:
                    z2 = zzb.zzc(parcel, zzaT);
                    break;
                case HTTP.HT /*9*/:
                    list3 = zzb.zzE(parcel, zzaT);
                    break;
                case HTTP.LF /*10*/:
                    iBinder = zzb.zzr(parcel, zzaT);
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
            return new SessionReadRequest(i, str, str2, j, j2, list, list2, z, z2, list3, iBinder);
        }
        throw new zza("Overread allowed size end=" + zzaU, parcel);
    }

    public SessionReadRequest[] zzhy(int i) {
        return new SessionReadRequest[i];
    }
}
