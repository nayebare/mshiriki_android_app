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

public class zzagt implements Creator<zzags> {
    static void zza(zzags com_google_android_gms_internal_zzags, Parcel parcel, int i) {
        int zzaV = zzc.zzaV(parcel);
        zzc.zzc(parcel, 1, com_google_android_gms_internal_zzags.mVersionCode);
        zzc.zzc(parcel, 2, com_google_android_gms_internal_zzags.zzaKZ);
        zzc.zzc(parcel, 3, com_google_android_gms_internal_zzags.zzaLa);
        zzc.zza(parcel, 4, com_google_android_gms_internal_zzags.zzaJj, i, false);
        zzc.zza(parcel, 5, com_google_android_gms_internal_zzags.zzaLb, i, false);
        zzc.zzJ(parcel, zzaV);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzch(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzey(i);
    }

    public zzags zzch(Parcel parcel) {
        zzakb com_google_android_gms_internal_zzakb = null;
        int i = 0;
        int zzaU = zzb.zzaU(parcel);
        DriveId driveId = null;
        int i2 = 0;
        int i3 = 0;
        while (parcel.dataPosition() < zzaU) {
            int zzaT = zzb.zzaT(parcel);
            switch (zzb.zzcW(zzaT)) {
                case MessageApi.FILTER_PREFIX /*1*/:
                    i3 = zzb.zzg(parcel, zzaT);
                    break;
                case ChannelListener.CLOSE_REASON_REMOTE_CLOSE /*2*/:
                    i2 = zzb.zzg(parcel, zzaT);
                    break;
                case ChannelListener.CLOSE_REASON_LOCAL_CLOSE /*3*/:
                    i = zzb.zzg(parcel, zzaT);
                    break;
                case Dimension.UNIT_IN /*4*/:
                    driveId = (DriveId) zzb.zza(parcel, zzaT, DriveId.CREATOR);
                    break;
                case Dimension.UNIT_MM /*5*/:
                    com_google_android_gms_internal_zzakb = (zzakb) zzb.zza(parcel, zzaT, zzakb.CREATOR);
                    break;
                default:
                    zzb.zzb(parcel, zzaT);
                    break;
            }
        }
        if (parcel.dataPosition() == zzaU) {
            return new zzags(i3, i2, i, driveId, com_google_android_gms_internal_zzakb);
        }
        throw new zza("Overread allowed size end=" + zzaU, parcel);
    }

    public zzags[] zzey(int i) {
        return new zzags[i];
    }
}
