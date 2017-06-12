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

public class zzay implements Creator<zzax> {
    static void zza(zzax com_google_android_gms_fitness_request_zzax, Parcel parcel, int i) {
        int zzaV = zzc.zzaV(parcel);
        zzc.zza(parcel, 1, com_google_android_gms_fitness_request_zzax.zzCt(), false);
        zzc.zza(parcel, 2, com_google_android_gms_fitness_request_zzax.getIntent(), i, false);
        zzc.zza(parcel, 3, com_google_android_gms_fitness_request_zzax.getCallbackBinder(), false);
        zzc.zzc(parcel, CardNetwork.OTHER, com_google_android_gms_fitness_request_zzax.getVersionCode());
        zzc.zzJ(parcel, zzaV);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzeN(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzhw(i);
    }

    public zzax zzeN(Parcel parcel) {
        IBinder iBinder = null;
        int zzaU = zzb.zzaU(parcel);
        int i = 0;
        PendingIntent pendingIntent = null;
        IBinder iBinder2 = null;
        while (parcel.dataPosition() < zzaU) {
            int i2;
            IBinder zzr;
            IBinder iBinder3;
            PendingIntent pendingIntent2;
            int zzaT = zzb.zzaT(parcel);
            IBinder iBinder4;
            switch (zzb.zzcW(zzaT)) {
                case MessageApi.FILTER_PREFIX /*1*/:
                    i2 = i;
                    PendingIntent pendingIntent3 = pendingIntent;
                    zzr = zzb.zzr(parcel, zzaT);
                    iBinder3 = iBinder;
                    pendingIntent2 = pendingIntent3;
                    break;
                case ChannelListener.CLOSE_REASON_REMOTE_CLOSE /*2*/:
                    zzr = iBinder2;
                    i2 = i;
                    iBinder4 = iBinder;
                    pendingIntent2 = (PendingIntent) zzb.zza(parcel, zzaT, PendingIntent.CREATOR);
                    iBinder3 = iBinder4;
                    break;
                case ChannelListener.CLOSE_REASON_LOCAL_CLOSE /*3*/:
                    iBinder3 = zzb.zzr(parcel, zzaT);
                    pendingIntent2 = pendingIntent;
                    zzr = iBinder2;
                    i2 = i;
                    break;
                case CardNetwork.OTHER /*1000*/:
                    iBinder4 = iBinder;
                    pendingIntent2 = pendingIntent;
                    zzr = iBinder2;
                    i2 = zzb.zzg(parcel, zzaT);
                    iBinder3 = iBinder4;
                    break;
                default:
                    zzb.zzb(parcel, zzaT);
                    iBinder3 = iBinder;
                    pendingIntent2 = pendingIntent;
                    zzr = iBinder2;
                    i2 = i;
                    break;
            }
            i = i2;
            iBinder2 = zzr;
            pendingIntent = pendingIntent2;
            iBinder = iBinder3;
        }
        if (parcel.dataPosition() == zzaU) {
            return new zzax(i, iBinder2, pendingIntent, iBinder);
        }
        throw new zza("Overread allowed size end=" + zzaU, parcel);
    }

    public zzax[] zzhw(int i) {
        return new zzax[i];
    }
}
