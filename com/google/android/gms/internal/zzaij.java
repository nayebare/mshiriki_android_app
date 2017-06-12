package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.common.internal.safeparcel.zzb.zza;
import com.google.android.gms.common.internal.safeparcel.zzc;
import com.google.android.gms.drive.zzm;
import com.google.android.gms.wearable.ChannelApi.ChannelListener;
import com.google.android.gms.wearable.MessageApi;
import java.util.List;

public class zzaij implements Creator<zzaii> {
    static void zza(zzaii com_google_android_gms_internal_zzaii, Parcel parcel, int i) {
        int zzaV = zzc.zzaV(parcel);
        zzc.zzc(parcel, 1, com_google_android_gms_internal_zzaii.mVersionCode);
        zzc.zzc(parcel, 2, com_google_android_gms_internal_zzaii.zzaMu, false);
        zzc.zzc(parcel, 3, com_google_android_gms_internal_zzaii.zzHJ);
        zzc.zzJ(parcel, zzaV);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzcv(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzeR(i);
    }

    public zzaii zzcv(Parcel parcel) {
        int i = 0;
        int zzaU = zzb.zzaU(parcel);
        List list = null;
        int i2 = 0;
        while (parcel.dataPosition() < zzaU) {
            int zzaT = zzb.zzaT(parcel);
            switch (zzb.zzcW(zzaT)) {
                case MessageApi.FILTER_PREFIX /*1*/:
                    i2 = zzb.zzg(parcel, zzaT);
                    break;
                case ChannelListener.CLOSE_REASON_REMOTE_CLOSE /*2*/:
                    list = zzb.zzc(parcel, zzaT, zzm.CREATOR);
                    break;
                case ChannelListener.CLOSE_REASON_LOCAL_CLOSE /*3*/:
                    i = zzb.zzg(parcel, zzaT);
                    break;
                default:
                    zzb.zzb(parcel, zzaT);
                    break;
            }
        }
        if (parcel.dataPosition() == zzaU) {
            return new zzaii(i2, list, i);
        }
        throw new zza("Overread allowed size end=" + zzaU, parcel);
    }

    public zzaii[] zzeR(int i) {
        return new zzaii[i];
    }
}
