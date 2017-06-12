package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.common.internal.safeparcel.zzb.zza;
import com.google.android.gms.common.internal.safeparcel.zzc;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.fitness.data.Session;
import com.google.android.gms.games.request.Requests;
import com.google.android.gms.wallet.WalletConstants.CardNetwork;
import com.google.android.gms.wallet.fragment.WalletFragmentStyle.BuyButtonText;
import com.google.android.gms.wallet.fragment.WalletFragmentStyle.Dimension;
import com.google.android.gms.wearable.ChannelApi.ChannelListener;
import com.google.android.gms.wearable.MessageApi;
import java.util.List;

public class zzf implements Creator<DataDeleteRequest> {
    static void zza(DataDeleteRequest dataDeleteRequest, Parcel parcel, int i) {
        int zzaV = zzc.zzaV(parcel);
        zzc.zza(parcel, 1, dataDeleteRequest.zzpN());
        zzc.zza(parcel, 2, dataDeleteRequest.zzzx());
        zzc.zzc(parcel, 3, dataDeleteRequest.getDataSources(), false);
        zzc.zzc(parcel, 4, dataDeleteRequest.getDataTypes(), false);
        zzc.zzc(parcel, 5, dataDeleteRequest.getSessions(), false);
        zzc.zza(parcel, 6, dataDeleteRequest.zzBZ());
        zzc.zza(parcel, 7, dataDeleteRequest.zzCa());
        zzc.zzc(parcel, CardNetwork.OTHER, dataDeleteRequest.getVersionCode());
        zzc.zza(parcel, 8, dataDeleteRequest.getCallbackBinder(), false);
        zzc.zzJ(parcel, zzaV);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzep(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzgY(i);
    }

    public DataDeleteRequest zzep(Parcel parcel) {
        long j = 0;
        boolean z = false;
        IBinder iBinder = null;
        int zzaU = zzb.zzaU(parcel);
        boolean z2 = false;
        List list = null;
        List list2 = null;
        List list3 = null;
        long j2 = 0;
        int i = 0;
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
                    list3 = zzb.zzc(parcel, zzaT, DataSource.CREATOR);
                    break;
                case Dimension.UNIT_IN /*4*/:
                    list2 = zzb.zzc(parcel, zzaT, DataType.CREATOR);
                    break;
                case Dimension.UNIT_MM /*5*/:
                    list = zzb.zzc(parcel, zzaT, Session.CREATOR);
                    break;
                case BuyButtonText.LOGO_ONLY /*6*/:
                    z2 = zzb.zzc(parcel, zzaT);
                    break;
                case BuyButtonText.DONATE_WITH /*7*/:
                    z = zzb.zzc(parcel, zzaT);
                    break;
                case Requests.MAX_REQUEST_RECIPIENTS /*8*/:
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
            return new DataDeleteRequest(i, j2, j, list3, list2, list, z2, z, iBinder);
        }
        throw new zza("Overread allowed size end=" + zzaU, parcel);
    }

    public DataDeleteRequest[] zzgY(int i) {
        return new DataDeleteRequest[i];
    }
}
