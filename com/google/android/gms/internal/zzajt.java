package com.google.android.gms.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.common.internal.safeparcel.zzb.zza;
import com.google.android.gms.common.internal.safeparcel.zzc;
import com.google.android.gms.wallet.fragment.WalletFragmentStyle.Dimension;
import com.google.android.gms.wearable.ChannelApi.ChannelListener;
import com.google.android.gms.wearable.MessageApi;

public class zzajt implements Creator<zzajs> {
    static void zza(zzajs com_google_android_gms_internal_zzajs, Parcel parcel, int i) {
        int zzaV = zzc.zzaV(parcel);
        zzc.zzc(parcel, 1, com_google_android_gms_internal_zzajs.mVersionCode);
        zzc.zza(parcel, 2, com_google_android_gms_internal_zzajs.zzaMV, i, false);
        zzc.zza(parcel, 3, com_google_android_gms_internal_zzajs.zzaMW, false);
        zzc.zza(parcel, 4, com_google_android_gms_internal_zzajs.zzxq, false);
        zzc.zzJ(parcel, zzaV);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzcL(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzfh(i);
    }

    public zzajs zzcL(Parcel parcel) {
        String str = null;
        int zzaU = zzb.zzaU(parcel);
        int i = 0;
        IBinder iBinder = null;
        ParcelFileDescriptor parcelFileDescriptor = null;
        while (parcel.dataPosition() < zzaU) {
            IBinder iBinder2;
            ParcelFileDescriptor parcelFileDescriptor2;
            int zzg;
            String str2;
            int zzaT = zzb.zzaT(parcel);
            String str3;
            switch (zzb.zzcW(zzaT)) {
                case MessageApi.FILTER_PREFIX /*1*/:
                    str3 = str;
                    iBinder2 = iBinder;
                    parcelFileDescriptor2 = parcelFileDescriptor;
                    zzg = zzb.zzg(parcel, zzaT);
                    str2 = str3;
                    break;
                case ChannelListener.CLOSE_REASON_REMOTE_CLOSE /*2*/:
                    zzg = i;
                    IBinder iBinder3 = iBinder;
                    parcelFileDescriptor2 = (ParcelFileDescriptor) zzb.zza(parcel, zzaT, ParcelFileDescriptor.CREATOR);
                    str2 = str;
                    iBinder2 = iBinder3;
                    break;
                case ChannelListener.CLOSE_REASON_LOCAL_CLOSE /*3*/:
                    parcelFileDescriptor2 = parcelFileDescriptor;
                    zzg = i;
                    str3 = str;
                    iBinder2 = zzb.zzr(parcel, zzaT);
                    str2 = str3;
                    break;
                case Dimension.UNIT_IN /*4*/:
                    str2 = zzb.zzq(parcel, zzaT);
                    iBinder2 = iBinder;
                    parcelFileDescriptor2 = parcelFileDescriptor;
                    zzg = i;
                    break;
                default:
                    zzb.zzb(parcel, zzaT);
                    str2 = str;
                    iBinder2 = iBinder;
                    parcelFileDescriptor2 = parcelFileDescriptor;
                    zzg = i;
                    break;
            }
            i = zzg;
            parcelFileDescriptor = parcelFileDescriptor2;
            iBinder = iBinder2;
            str = str2;
        }
        if (parcel.dataPosition() == zzaU) {
            return new zzajs(i, parcelFileDescriptor, iBinder, str);
        }
        throw new zza("Overread allowed size end=" + zzaU, parcel);
    }

    public zzajs[] zzfh(int i) {
        return new zzajs[i];
    }
}
