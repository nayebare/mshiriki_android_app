package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.common.internal.safeparcel.zzb.zza;
import com.google.android.gms.common.internal.safeparcel.zzc;
import com.google.android.gms.drive.query.Query;
import com.google.android.gms.wearable.ChannelApi.ChannelListener;
import com.google.android.gms.wearable.MessageApi;

public class zzake implements Creator<zzakd> {
    static void zza(zzakd com_google_android_gms_internal_zzakd, Parcel parcel, int i) {
        int zzaV = zzc.zzaV(parcel);
        zzc.zzc(parcel, 1, com_google_android_gms_internal_zzakd.mVersionCode);
        zzc.zza(parcel, 2, com_google_android_gms_internal_zzakd.zzaNb, i, false);
        zzc.zzJ(parcel, zzaV);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzcQ(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzfm(i);
    }

    public zzakd zzcQ(Parcel parcel) {
        int zzaU = zzb.zzaU(parcel);
        int i = 0;
        Query query = null;
        while (parcel.dataPosition() < zzaU) {
            int zzaT = zzb.zzaT(parcel);
            switch (zzb.zzcW(zzaT)) {
                case MessageApi.FILTER_PREFIX /*1*/:
                    i = zzb.zzg(parcel, zzaT);
                    break;
                case ChannelListener.CLOSE_REASON_REMOTE_CLOSE /*2*/:
                    query = (Query) zzb.zza(parcel, zzaT, Query.CREATOR);
                    break;
                default:
                    zzb.zzb(parcel, zzaT);
                    break;
            }
        }
        if (parcel.dataPosition() == zzaU) {
            return new zzakd(i, query);
        }
        throw new zza("Overread allowed size end=" + zzaU, parcel);
    }

    public zzakd[] zzfm(int i) {
        return new zzakd[i];
    }
}
