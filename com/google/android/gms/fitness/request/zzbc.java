package com.google.android.gms.fitness.request;

import android.app.PendingIntent;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.common.internal.safeparcel.zzb.zza;
import com.google.android.gms.common.internal.safeparcel.zzc;
import com.google.android.gms.wallet.WalletConstants.CardNetwork;
import com.google.android.gms.wallet.fragment.WalletFragmentStyle.Dimension;
import com.google.android.gms.wearable.ChannelApi.ChannelListener;
import com.google.android.gms.wearable.MessageApi;

public class zzbc implements Creator<zzbb> {
    static void zza(zzbb com_google_android_gms_fitness_request_zzbb, Parcel parcel, int i) {
        int zzaV = zzc.zzaV(parcel);
        zzc.zza(parcel, 1, com_google_android_gms_fitness_request_zzbb.getIntent(), i, false);
        zzc.zza(parcel, 2, com_google_android_gms_fitness_request_zzbb.getCallbackBinder(), false);
        zzc.zzc(parcel, 4, com_google_android_gms_fitness_request_zzbb.zzCx());
        zzc.zzc(parcel, CardNetwork.OTHER, com_google_android_gms_fitness_request_zzbb.getVersionCode());
        zzc.zzJ(parcel, zzaV);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzeQ(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzhz(i);
    }

    public zzbb zzeQ(Parcel parcel) {
        IBinder iBinder = null;
        int i = 0;
        int zzaU = zzb.zzaU(parcel);
        PendingIntent pendingIntent = null;
        int i2 = 0;
        while (parcel.dataPosition() < zzaU) {
            int i3;
            PendingIntent pendingIntent2;
            IBinder iBinder2;
            int zzaT = zzb.zzaT(parcel);
            int i4;
            switch (zzb.zzcW(zzaT)) {
                case MessageApi.FILTER_PREFIX /*1*/:
                    i3 = i2;
                    IBinder iBinder3 = iBinder;
                    pendingIntent2 = (PendingIntent) zzb.zza(parcel, zzaT, PendingIntent.CREATOR);
                    zzaT = i;
                    iBinder2 = iBinder3;
                    break;
                case ChannelListener.CLOSE_REASON_REMOTE_CLOSE /*2*/:
                    pendingIntent2 = pendingIntent;
                    i3 = i2;
                    i4 = i;
                    iBinder2 = zzb.zzr(parcel, zzaT);
                    zzaT = i4;
                    break;
                case Dimension.UNIT_IN /*4*/:
                    zzaT = zzb.zzg(parcel, zzaT);
                    iBinder2 = iBinder;
                    pendingIntent2 = pendingIntent;
                    i3 = i2;
                    break;
                case CardNetwork.OTHER /*1000*/:
                    i4 = i;
                    iBinder2 = iBinder;
                    pendingIntent2 = pendingIntent;
                    i3 = zzb.zzg(parcel, zzaT);
                    zzaT = i4;
                    break;
                default:
                    zzb.zzb(parcel, zzaT);
                    zzaT = i;
                    iBinder2 = iBinder;
                    pendingIntent2 = pendingIntent;
                    i3 = i2;
                    break;
            }
            i2 = i3;
            pendingIntent = pendingIntent2;
            iBinder = iBinder2;
            i = zzaT;
        }
        if (parcel.dataPosition() == zzaU) {
            return new zzbb(i2, pendingIntent, iBinder, i);
        }
        throw new zza("Overread allowed size end=" + zzaU, parcel);
    }

    public zzbb[] zzhz(int i) {
        return new zzbb[i];
    }
}
