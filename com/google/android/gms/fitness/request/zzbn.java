package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.common.internal.safeparcel.zzb.zza;
import com.google.android.gms.common.internal.safeparcel.zzc;
import com.google.android.gms.fitness.data.Subscription;
import com.google.android.gms.wallet.WalletConstants.CardNetwork;
import com.google.android.gms.wearable.ChannelApi.ChannelListener;
import com.google.android.gms.wearable.MessageApi;

public class zzbn implements Creator<zzbm> {
    static void zza(zzbm com_google_android_gms_fitness_request_zzbm, Parcel parcel, int i) {
        int zzaV = zzc.zzaV(parcel);
        zzc.zza(parcel, 1, com_google_android_gms_fitness_request_zzbm.zzCz(), i, false);
        zzc.zza(parcel, 2, com_google_android_gms_fitness_request_zzbm.zzCA());
        zzc.zza(parcel, 3, com_google_android_gms_fitness_request_zzbm.getCallbackBinder(), false);
        zzc.zzc(parcel, CardNetwork.OTHER, com_google_android_gms_fitness_request_zzbm.getVersionCode());
        zzc.zzJ(parcel, zzaV);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzeW(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzhF(i);
    }

    public zzbm zzeW(Parcel parcel) {
        IBinder iBinder = null;
        boolean z = false;
        int zzaU = zzb.zzaU(parcel);
        Subscription subscription = null;
        int i = 0;
        while (parcel.dataPosition() < zzaU) {
            int i2;
            Subscription subscription2;
            IBinder iBinder2;
            boolean z2;
            int zzaT = zzb.zzaT(parcel);
            IBinder iBinder3;
            switch (zzb.zzcW(zzaT)) {
                case MessageApi.FILTER_PREFIX /*1*/:
                    i2 = i;
                    boolean z3 = z;
                    subscription2 = (Subscription) zzb.zza(parcel, zzaT, Subscription.CREATOR);
                    iBinder2 = iBinder;
                    z2 = z3;
                    break;
                case ChannelListener.CLOSE_REASON_REMOTE_CLOSE /*2*/:
                    subscription2 = subscription;
                    i2 = i;
                    iBinder3 = iBinder;
                    z2 = zzb.zzc(parcel, zzaT);
                    iBinder2 = iBinder3;
                    break;
                case ChannelListener.CLOSE_REASON_LOCAL_CLOSE /*3*/:
                    iBinder2 = zzb.zzr(parcel, zzaT);
                    z2 = z;
                    subscription2 = subscription;
                    i2 = i;
                    break;
                case CardNetwork.OTHER /*1000*/:
                    iBinder3 = iBinder;
                    z2 = z;
                    subscription2 = subscription;
                    i2 = zzb.zzg(parcel, zzaT);
                    iBinder2 = iBinder3;
                    break;
                default:
                    zzb.zzb(parcel, zzaT);
                    iBinder2 = iBinder;
                    z2 = z;
                    subscription2 = subscription;
                    i2 = i;
                    break;
            }
            i = i2;
            subscription = subscription2;
            z = z2;
            iBinder = iBinder2;
        }
        if (parcel.dataPosition() == zzaU) {
            return new zzbm(i, subscription, z, iBinder);
        }
        throw new zza("Overread allowed size end=" + zzaU, parcel);
    }

    public zzbm[] zzhF(int i) {
        return new zzbm[i];
    }
}
