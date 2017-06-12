package com.google.android.gms.drive.metadata.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.common.internal.safeparcel.zzb.zza;
import com.google.android.gms.common.internal.safeparcel.zzc;
import com.google.android.gms.wearable.ChannelApi.ChannelListener;
import com.google.android.gms.wearable.MessageApi;
import java.util.List;

public class zzm implements Creator<ParentDriveIdSet> {
    static void zza(ParentDriveIdSet parentDriveIdSet, Parcel parcel, int i) {
        int zzaV = zzc.zzaV(parcel);
        zzc.zzc(parcel, 1, parentDriveIdSet.mVersionCode);
        zzc.zzc(parcel, 2, parentDriveIdSet.zzaNy, false);
        zzc.zzJ(parcel, zzaV);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzdh(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzfD(i);
    }

    public ParentDriveIdSet zzdh(Parcel parcel) {
        int zzaU = zzb.zzaU(parcel);
        int i = 0;
        List list = null;
        while (parcel.dataPosition() < zzaU) {
            int zzaT = zzb.zzaT(parcel);
            switch (zzb.zzcW(zzaT)) {
                case MessageApi.FILTER_PREFIX /*1*/:
                    i = zzb.zzg(parcel, zzaT);
                    break;
                case ChannelListener.CLOSE_REASON_REMOTE_CLOSE /*2*/:
                    list = zzb.zzc(parcel, zzaT, zzo.CREATOR);
                    break;
                default:
                    zzb.zzb(parcel, zzaT);
                    break;
            }
        }
        if (parcel.dataPosition() == zzaU) {
            return new ParentDriveIdSet(i, list);
        }
        throw new zza("Overread allowed size end=" + zzaU, parcel);
    }

    public ParentDriveIdSet[] zzfD(int i) {
        return new ParentDriveIdSet[i];
    }
}
