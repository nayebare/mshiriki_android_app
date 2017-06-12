package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.common.internal.safeparcel.zzb.zza;
import com.google.android.gms.common.internal.safeparcel.zzc;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.wallet.fragment.WalletFragmentStyle.Dimension;
import com.google.android.gms.wearable.ChannelApi.ChannelListener;
import com.google.android.gms.wearable.MessageApi;

public class zzajx implements Creator<zzajw> {
    static void zza(zzajw com_google_android_gms_internal_zzajw, Parcel parcel, int i) {
        int zzaV = zzc.zzaV(parcel);
        zzc.zzc(parcel, 1, com_google_android_gms_internal_zzajw.mVersionCode);
        zzc.zza(parcel, 2, com_google_android_gms_internal_zzajw.zzaKS, i, false);
        zzc.zzc(parcel, 3, com_google_android_gms_internal_zzajw.zzaJi);
        zzc.zzc(parcel, 4, com_google_android_gms_internal_zzajw.zzaMX);
        zzc.zzJ(parcel, zzaV);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzcN(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzfj(i);
    }

    public zzajw zzcN(Parcel parcel) {
        int i = 0;
        int zzaU = zzb.zzaU(parcel);
        DriveId driveId = null;
        int i2 = 0;
        int i3 = 0;
        while (parcel.dataPosition() < zzaU) {
            DriveId driveId2;
            int zzg;
            int zzaT = zzb.zzaT(parcel);
            int i4;
            switch (zzb.zzcW(zzaT)) {
                case MessageApi.FILTER_PREFIX /*1*/:
                    i4 = i;
                    i = i2;
                    driveId2 = driveId;
                    zzg = zzb.zzg(parcel, zzaT);
                    zzaT = i4;
                    break;
                case ChannelListener.CLOSE_REASON_REMOTE_CLOSE /*2*/:
                    zzg = i3;
                    i4 = i2;
                    driveId2 = (DriveId) zzb.zza(parcel, zzaT, DriveId.CREATOR);
                    zzaT = i;
                    i = i4;
                    break;
                case ChannelListener.CLOSE_REASON_LOCAL_CLOSE /*3*/:
                    driveId2 = driveId;
                    zzg = i3;
                    i4 = i;
                    i = zzb.zzg(parcel, zzaT);
                    zzaT = i4;
                    break;
                case Dimension.UNIT_IN /*4*/:
                    zzaT = zzb.zzg(parcel, zzaT);
                    i = i2;
                    driveId2 = driveId;
                    zzg = i3;
                    break;
                default:
                    zzb.zzb(parcel, zzaT);
                    zzaT = i;
                    i = i2;
                    driveId2 = driveId;
                    zzg = i3;
                    break;
            }
            i3 = zzg;
            driveId = driveId2;
            i2 = i;
            i = zzaT;
        }
        if (parcel.dataPosition() == zzaU) {
            return new zzajw(i3, driveId, i2, i);
        }
        throw new zza("Overread allowed size end=" + zzaU, parcel);
    }

    public zzajw[] zzfj(int i) {
        return new zzajw[i];
    }
}
