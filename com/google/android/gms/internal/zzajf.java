package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.common.internal.safeparcel.zzb.zza;
import com.google.android.gms.common.internal.safeparcel.zzc;
import com.google.android.gms.wearable.ChannelApi.ChannelListener;
import com.google.android.gms.wearable.MessageApi;

public class zzajf implements Creator<zzaje> {
    static void zza(zzaje com_google_android_gms_internal_zzaje, Parcel parcel, int i) {
        int zzaV = zzc.zzaV(parcel);
        zzc.zzc(parcel, 1, com_google_android_gms_internal_zzaje.mVersionCode);
        zzc.zza(parcel, 2, com_google_android_gms_internal_zzaje.zzaMR, i, false);
        zzc.zzJ(parcel, zzaV);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzcE(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzfa(i);
    }

    public zzaje zzcE(Parcel parcel) {
        int zzaU = zzb.zzaU(parcel);
        int i = 0;
        ParcelFileDescriptor parcelFileDescriptor = null;
        while (parcel.dataPosition() < zzaU) {
            int zzaT = zzb.zzaT(parcel);
            switch (zzb.zzcW(zzaT)) {
                case MessageApi.FILTER_PREFIX /*1*/:
                    i = zzb.zzg(parcel, zzaT);
                    break;
                case ChannelListener.CLOSE_REASON_REMOTE_CLOSE /*2*/:
                    parcelFileDescriptor = (ParcelFileDescriptor) zzb.zza(parcel, zzaT, ParcelFileDescriptor.CREATOR);
                    break;
                default:
                    zzb.zzb(parcel, zzaT);
                    break;
            }
        }
        if (parcel.dataPosition() == zzaU) {
            return new zzaje(i, parcelFileDescriptor);
        }
        throw new zza("Overread allowed size end=" + zzaU, parcel);
    }

    public zzaje[] zzfa(int i) {
        return new zzaje[i];
    }
}
