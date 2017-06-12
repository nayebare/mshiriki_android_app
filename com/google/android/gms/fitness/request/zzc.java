package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.common.internal.safeparcel.zzb.zza;
import com.google.android.gms.fitness.data.BleDevice;
import com.google.android.gms.wallet.WalletConstants.CardNetwork;
import com.google.android.gms.wearable.ChannelApi.ChannelListener;
import com.google.android.gms.wearable.MessageApi;

public class zzc implements Creator<zzb> {
    static void zza(zzb com_google_android_gms_fitness_request_zzb, Parcel parcel, int i) {
        int zzaV = com.google.android.gms.common.internal.safeparcel.zzc.zzaV(parcel);
        com.google.android.gms.common.internal.safeparcel.zzc.zza(parcel, 1, com_google_android_gms_fitness_request_zzb.getDeviceAddress(), false);
        com.google.android.gms.common.internal.safeparcel.zzc.zza(parcel, 2, com_google_android_gms_fitness_request_zzb.zzBX(), i, false);
        com.google.android.gms.common.internal.safeparcel.zzc.zza(parcel, 3, com_google_android_gms_fitness_request_zzb.getCallbackBinder(), false);
        com.google.android.gms.common.internal.safeparcel.zzc.zzc(parcel, CardNetwork.OTHER, com_google_android_gms_fitness_request_zzb.getVersionCode());
        com.google.android.gms.common.internal.safeparcel.zzc.zzJ(parcel, zzaV);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzen(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzgW(i);
    }

    public zzb zzen(Parcel parcel) {
        IBinder iBinder = null;
        int zzaU = zzb.zzaU(parcel);
        int i = 0;
        BleDevice bleDevice = null;
        String str = null;
        while (parcel.dataPosition() < zzaU) {
            int i2;
            String zzq;
            IBinder iBinder2;
            BleDevice bleDevice2;
            int zzaT = zzb.zzaT(parcel);
            IBinder iBinder3;
            switch (zzb.zzcW(zzaT)) {
                case MessageApi.FILTER_PREFIX /*1*/:
                    i2 = i;
                    BleDevice bleDevice3 = bleDevice;
                    zzq = zzb.zzq(parcel, zzaT);
                    iBinder2 = iBinder;
                    bleDevice2 = bleDevice3;
                    break;
                case ChannelListener.CLOSE_REASON_REMOTE_CLOSE /*2*/:
                    zzq = str;
                    i2 = i;
                    iBinder3 = iBinder;
                    bleDevice2 = (BleDevice) zzb.zza(parcel, zzaT, BleDevice.CREATOR);
                    iBinder2 = iBinder3;
                    break;
                case ChannelListener.CLOSE_REASON_LOCAL_CLOSE /*3*/:
                    iBinder2 = zzb.zzr(parcel, zzaT);
                    bleDevice2 = bleDevice;
                    zzq = str;
                    i2 = i;
                    break;
                case CardNetwork.OTHER /*1000*/:
                    iBinder3 = iBinder;
                    bleDevice2 = bleDevice;
                    zzq = str;
                    i2 = zzb.zzg(parcel, zzaT);
                    iBinder2 = iBinder3;
                    break;
                default:
                    zzb.zzb(parcel, zzaT);
                    iBinder2 = iBinder;
                    bleDevice2 = bleDevice;
                    zzq = str;
                    i2 = i;
                    break;
            }
            i = i2;
            str = zzq;
            bleDevice = bleDevice2;
            iBinder = iBinder2;
        }
        if (parcel.dataPosition() == zzaU) {
            return new zzb(i, str, bleDevice, iBinder);
        }
        throw new zza("Overread allowed size end=" + zzaU, parcel);
    }

    public zzb[] zzgW(int i) {
        return new zzb[i];
    }
}
