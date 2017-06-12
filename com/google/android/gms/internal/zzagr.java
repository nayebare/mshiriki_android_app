package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.common.internal.safeparcel.zzb.zza;
import com.google.android.gms.common.internal.safeparcel.zzc;
import com.google.android.gms.wallet.fragment.WalletFragmentStyle.Dimension;
import com.google.android.gms.wearable.ChannelApi.ChannelListener;
import com.google.android.gms.wearable.MessageApi;

public class zzagr implements Creator<zzagq> {
    static void zza(zzagq com_google_android_gms_internal_zzagq, Parcel parcel, int i) {
        int zzaV = zzc.zzaV(parcel);
        zzc.zzc(parcel, 1, com_google_android_gms_internal_zzagq.mVersionCode);
        zzc.zza(parcel, 2, com_google_android_gms_internal_zzagq.zzaKU, i, false);
        zzc.zza(parcel, 3, com_google_android_gms_internal_zzagq.zzaKY, false);
        zzc.zzc(parcel, 4, com_google_android_gms_internal_zzagq.zzaKW);
        zzc.zzJ(parcel, zzaV);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzcg(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzex(i);
    }

    public zzagq zzcg(Parcel parcel) {
        Boolean bool = null;
        int i = 0;
        int zzaU = zzb.zzaU(parcel);
        com.google.android.gms.drive.zzc com_google_android_gms_drive_zzc = null;
        int i2 = 0;
        while (parcel.dataPosition() < zzaU) {
            Boolean bool2;
            com.google.android.gms.drive.zzc com_google_android_gms_drive_zzc2;
            int zzg;
            int zzaT = zzb.zzaT(parcel);
            int i3;
            switch (zzb.zzcW(zzaT)) {
                case MessageApi.FILTER_PREFIX /*1*/:
                    i3 = i;
                    bool2 = bool;
                    com_google_android_gms_drive_zzc2 = com_google_android_gms_drive_zzc;
                    zzg = zzb.zzg(parcel, zzaT);
                    zzaT = i3;
                    break;
                case ChannelListener.CLOSE_REASON_REMOTE_CLOSE /*2*/:
                    zzg = i2;
                    Boolean bool3 = bool;
                    com_google_android_gms_drive_zzc2 = (com.google.android.gms.drive.zzc) zzb.zza(parcel, zzaT, com.google.android.gms.drive.zzc.CREATOR);
                    zzaT = i;
                    bool2 = bool3;
                    break;
                case ChannelListener.CLOSE_REASON_LOCAL_CLOSE /*3*/:
                    com_google_android_gms_drive_zzc2 = com_google_android_gms_drive_zzc;
                    zzg = i2;
                    i3 = i;
                    bool2 = zzb.zzd(parcel, zzaT);
                    zzaT = i3;
                    break;
                case Dimension.UNIT_IN /*4*/:
                    zzaT = zzb.zzg(parcel, zzaT);
                    bool2 = bool;
                    com_google_android_gms_drive_zzc2 = com_google_android_gms_drive_zzc;
                    zzg = i2;
                    break;
                default:
                    zzb.zzb(parcel, zzaT);
                    zzaT = i;
                    bool2 = bool;
                    com_google_android_gms_drive_zzc2 = com_google_android_gms_drive_zzc;
                    zzg = i2;
                    break;
            }
            i2 = zzg;
            com_google_android_gms_drive_zzc = com_google_android_gms_drive_zzc2;
            bool = bool2;
            i = zzaT;
        }
        if (parcel.dataPosition() == zzaU) {
            return new zzagq(i2, com_google_android_gms_drive_zzc, bool, i);
        }
        throw new zza("Overread allowed size end=" + zzaU, parcel);
    }

    public zzagq[] zzex(int i) {
        return new zzagq[i];
    }
}
