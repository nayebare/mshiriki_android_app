package com.google.android.gms.auth.api.proxy;

import android.app.PendingIntent;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.common.internal.safeparcel.zzb.zza;
import com.google.android.gms.common.internal.safeparcel.zzc;
import com.google.android.gms.wallet.WalletConstants.CardNetwork;
import com.google.android.gms.wallet.fragment.WalletFragmentStyle.Dimension;
import com.google.android.gms.wearable.ChannelApi.ChannelListener;
import com.google.android.gms.wearable.MessageApi;

public class zzd implements Creator<ProxyResponse> {
    static void zza(ProxyResponse proxyResponse, Parcel parcel, int i) {
        int zzaV = zzc.zzaV(parcel);
        zzc.zzc(parcel, 1, proxyResponse.googlePlayServicesStatusCode);
        zzc.zza(parcel, 2, proxyResponse.recoveryAction, i, false);
        zzc.zzc(parcel, 3, proxyResponse.statusCode);
        zzc.zza(parcel, 4, proxyResponse.zzaiN, false);
        zzc.zza(parcel, 5, proxyResponse.body, false);
        zzc.zzc(parcel, CardNetwork.OTHER, proxyResponse.versionCode);
        zzc.zzJ(parcel, zzaV);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzU(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzbi(i);
    }

    public ProxyResponse zzU(Parcel parcel) {
        byte[] bArr = null;
        int i = 0;
        int zzaU = zzb.zzaU(parcel);
        Bundle bundle = null;
        PendingIntent pendingIntent = null;
        int i2 = 0;
        int i3 = 0;
        while (parcel.dataPosition() < zzaU) {
            int zzaT = zzb.zzaT(parcel);
            switch (zzb.zzcW(zzaT)) {
                case MessageApi.FILTER_PREFIX /*1*/:
                    i2 = zzb.zzg(parcel, zzaT);
                    break;
                case ChannelListener.CLOSE_REASON_REMOTE_CLOSE /*2*/:
                    pendingIntent = (PendingIntent) zzb.zza(parcel, zzaT, PendingIntent.CREATOR);
                    break;
                case ChannelListener.CLOSE_REASON_LOCAL_CLOSE /*3*/:
                    i = zzb.zzg(parcel, zzaT);
                    break;
                case Dimension.UNIT_IN /*4*/:
                    bundle = zzb.zzs(parcel, zzaT);
                    break;
                case Dimension.UNIT_MM /*5*/:
                    bArr = zzb.zzt(parcel, zzaT);
                    break;
                case CardNetwork.OTHER /*1000*/:
                    i3 = zzb.zzg(parcel, zzaT);
                    break;
                default:
                    zzb.zzb(parcel, zzaT);
                    break;
            }
        }
        if (parcel.dataPosition() == zzaU) {
            return new ProxyResponse(i3, i2, pendingIntent, i, bundle, bArr);
        }
        throw new zza("Overread allowed size end=" + zzaU, parcel);
    }

    public ProxyResponse[] zzbi(int i) {
        return new ProxyResponse[i];
    }
}
