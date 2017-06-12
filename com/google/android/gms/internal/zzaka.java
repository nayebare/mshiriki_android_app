package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.common.internal.safeparcel.zzb.zza;
import com.google.android.gms.common.internal.safeparcel.zzc;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.query.internal.FilterHolder;
import com.google.android.gms.wallet.fragment.WalletFragmentStyle.Dimension;
import com.google.android.gms.wearable.ChannelApi.ChannelListener;
import com.google.android.gms.wearable.MessageApi;

public class zzaka implements Creator<zzajz> {
    static void zza(zzajz com_google_android_gms_internal_zzajz, Parcel parcel, int i) {
        int zzaV = zzc.zzaV(parcel);
        zzc.zzc(parcel, 1, com_google_android_gms_internal_zzajz.mVersionCode);
        zzc.zza(parcel, 2, com_google_android_gms_internal_zzajz.zzalD, false);
        zzc.zza(parcel, 3, com_google_android_gms_internal_zzajz.zzaJQ, false);
        zzc.zza(parcel, 4, com_google_android_gms_internal_zzajz.zzaJS, i, false);
        zzc.zza(parcel, 5, com_google_android_gms_internal_zzajz.zzaMZ, i, false);
        zzc.zzJ(parcel, zzaV);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzcO(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzfk(i);
    }

    public zzajz zzcO(Parcel parcel) {
        FilterHolder filterHolder = null;
        int zzaU = zzb.zzaU(parcel);
        int i = 0;
        DriveId driveId = null;
        String[] strArr = null;
        String str = null;
        while (parcel.dataPosition() < zzaU) {
            int zzaT = zzb.zzaT(parcel);
            switch (zzb.zzcW(zzaT)) {
                case MessageApi.FILTER_PREFIX /*1*/:
                    i = zzb.zzg(parcel, zzaT);
                    break;
                case ChannelListener.CLOSE_REASON_REMOTE_CLOSE /*2*/:
                    str = zzb.zzq(parcel, zzaT);
                    break;
                case ChannelListener.CLOSE_REASON_LOCAL_CLOSE /*3*/:
                    strArr = zzb.zzC(parcel, zzaT);
                    break;
                case Dimension.UNIT_IN /*4*/:
                    driveId = (DriveId) zzb.zza(parcel, zzaT, DriveId.CREATOR);
                    break;
                case Dimension.UNIT_MM /*5*/:
                    filterHolder = (FilterHolder) zzb.zza(parcel, zzaT, FilterHolder.CREATOR);
                    break;
                default:
                    zzb.zzb(parcel, zzaT);
                    break;
            }
        }
        if (parcel.dataPosition() == zzaU) {
            return new zzajz(i, str, strArr, driveId, filterHolder);
        }
        throw new zza("Overread allowed size end=" + zzaU, parcel);
    }

    public zzajz[] zzfk(int i) {
        return new zzajz[i];
    }
}
