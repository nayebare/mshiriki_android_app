package com.google.android.gms.fitness.request;

import android.app.PendingIntent;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.common.internal.safeparcel.zzb.zza;
import com.google.android.gms.common.internal.safeparcel.zzc;
import com.google.android.gms.wallet.WalletConstants.CardNetwork;
import com.google.android.gms.wearable.ChannelApi.ChannelListener;
import com.google.android.gms.wearable.MessageApi;

public class zzbi implements Creator<zzbh> {
    static void zza(zzbh com_google_android_gms_fitness_request_zzbh, Parcel parcel, int i) {
        int zzaV = zzc.zzaV(parcel);
        zzc.zza(parcel, 1, com_google_android_gms_fitness_request_zzbh.getIntent(), i, false);
        zzc.zza(parcel, 2, com_google_android_gms_fitness_request_zzbh.getCallbackBinder(), false);
        zzc.zzc(parcel, CardNetwork.OTHER, com_google_android_gms_fitness_request_zzbh.getVersionCode());
        zzc.zzJ(parcel, zzaV);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzeT(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzhC(i);
    }

    public zzbh zzeT(Parcel parcel) {
        IBinder iBinder = null;
        int zzaU = zzb.zzaU(parcel);
        int i = 0;
        PendingIntent pendingIntent = null;
        while (parcel.dataPosition() < zzaU) {
            int i2;
            IBinder iBinder2;
            PendingIntent pendingIntent2;
            int zzaT = zzb.zzaT(parcel);
            switch (zzb.zzcW(zzaT)) {
                case MessageApi.FILTER_PREFIX /*1*/:
                    i2 = i;
                    PendingIntent pendingIntent3 = (PendingIntent) zzb.zza(parcel, zzaT, PendingIntent.CREATOR);
                    iBinder2 = iBinder;
                    pendingIntent2 = pendingIntent3;
                    break;
                case ChannelListener.CLOSE_REASON_REMOTE_CLOSE /*2*/:
                    iBinder2 = zzb.zzr(parcel, zzaT);
                    pendingIntent2 = pendingIntent;
                    i2 = i;
                    break;
                case CardNetwork.OTHER /*1000*/:
                    IBinder iBinder3 = iBinder;
                    pendingIntent2 = pendingIntent;
                    i2 = zzb.zzg(parcel, zzaT);
                    iBinder2 = iBinder3;
                    break;
                default:
                    zzb.zzb(parcel, zzaT);
                    iBinder2 = iBinder;
                    pendingIntent2 = pendingIntent;
                    i2 = i;
                    break;
            }
            i = i2;
            pendingIntent = pendingIntent2;
            iBinder = iBinder2;
        }
        if (parcel.dataPosition() == zzaU) {
            return new zzbh(i, pendingIntent, iBinder);
        }
        throw new zza("Overread allowed size end=" + zzaU, parcel);
    }

    public zzbh[] zzhC(int i) {
        return new zzbh[i];
    }
}
