package com.google.android.gms.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.common.internal.safeparcel.zzb.zza;
import com.google.android.gms.common.internal.safeparcel.zzc;
import com.google.android.gms.wallet.WalletConstants.CardNetwork;
import com.google.android.gms.wearable.ChannelApi.ChannelListener;
import com.google.android.gms.wearable.MessageApi;

public class zzavd implements Creator<zzavc> {
    static void zza(zzavc com_google_android_gms_internal_zzavc, Parcel parcel, int i) {
        int zzaV = zzc.zzaV(parcel);
        zzc.zza(parcel, 1, com_google_android_gms_internal_zzavc.zzMM(), i, false);
        zzc.zza(parcel, 2, com_google_android_gms_internal_zzavc.getData(), false);
        zzc.zza(parcel, 3, com_google_android_gms_internal_zzavc.getCallbackBinder(), false);
        zzc.zzc(parcel, CardNetwork.OTHER, com_google_android_gms_internal_zzavc.versionCode);
        zzc.zzJ(parcel, zzaV);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzhU(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzlA(i);
    }

    public zzavc zzhU(Parcel parcel) {
        IBinder iBinder = null;
        int zzaU = zzb.zzaU(parcel);
        int i = 0;
        byte[] bArr = null;
        zzauj com_google_android_gms_internal_zzauj = null;
        while (parcel.dataPosition() < zzaU) {
            int i2;
            zzauj com_google_android_gms_internal_zzauj2;
            IBinder iBinder2;
            byte[] bArr2;
            int zzaT = zzb.zzaT(parcel);
            IBinder iBinder3;
            switch (zzb.zzcW(zzaT)) {
                case MessageApi.FILTER_PREFIX /*1*/:
                    i2 = i;
                    byte[] bArr3 = bArr;
                    com_google_android_gms_internal_zzauj2 = (zzauj) zzb.zza(parcel, zzaT, zzauj.CREATOR);
                    iBinder2 = iBinder;
                    bArr2 = bArr3;
                    break;
                case ChannelListener.CLOSE_REASON_REMOTE_CLOSE /*2*/:
                    com_google_android_gms_internal_zzauj2 = com_google_android_gms_internal_zzauj;
                    i2 = i;
                    iBinder3 = iBinder;
                    bArr2 = zzb.zzt(parcel, zzaT);
                    iBinder2 = iBinder3;
                    break;
                case ChannelListener.CLOSE_REASON_LOCAL_CLOSE /*3*/:
                    iBinder2 = zzb.zzr(parcel, zzaT);
                    bArr2 = bArr;
                    com_google_android_gms_internal_zzauj2 = com_google_android_gms_internal_zzauj;
                    i2 = i;
                    break;
                case CardNetwork.OTHER /*1000*/:
                    iBinder3 = iBinder;
                    bArr2 = bArr;
                    com_google_android_gms_internal_zzauj2 = com_google_android_gms_internal_zzauj;
                    i2 = zzb.zzg(parcel, zzaT);
                    iBinder2 = iBinder3;
                    break;
                default:
                    zzb.zzb(parcel, zzaT);
                    iBinder2 = iBinder;
                    bArr2 = bArr;
                    com_google_android_gms_internal_zzauj2 = com_google_android_gms_internal_zzauj;
                    i2 = i;
                    break;
            }
            i = i2;
            com_google_android_gms_internal_zzauj = com_google_android_gms_internal_zzauj2;
            bArr = bArr2;
            iBinder = iBinder2;
        }
        if (parcel.dataPosition() == zzaU) {
            return new zzavc(i, com_google_android_gms_internal_zzauj, bArr, iBinder);
        }
        throw new zza("Overread allowed size end=" + zzaU, parcel);
    }

    public zzavc[] zzlA(int i) {
        return new zzavc[i];
    }
}
