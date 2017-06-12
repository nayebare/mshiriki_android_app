package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.common.internal.safeparcel.zzc;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.zza;
import com.google.android.gms.wallet.fragment.WalletFragmentStyle.Dimension;
import com.google.android.gms.wearable.ChannelApi.ChannelListener;
import com.google.android.gms.wearable.MessageApi;
import java.util.List;

public class zzait implements Creator<zzais> {
    static void zza(zzais com_google_android_gms_internal_zzais, Parcel parcel, int i) {
        int zzaV = zzc.zzaV(parcel);
        zzc.zzc(parcel, 1, com_google_android_gms_internal_zzais.mVersionCode);
        zzc.zza(parcel, 2, com_google_android_gms_internal_zzais.zzaMB, i, false);
        zzc.zzc(parcel, 3, com_google_android_gms_internal_zzais.zzaMC, false);
        zzc.zza(parcel, 4, com_google_android_gms_internal_zzais.zzaMD, i, false);
        zzc.zza(parcel, 5, com_google_android_gms_internal_zzais.zzaME);
        zzc.zzJ(parcel, zzaV);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzcy(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzeU(i);
    }

    public zzais zzcy(Parcel parcel) {
        boolean z = false;
        zza com_google_android_gms_drive_zza = null;
        int zzaU = zzb.zzaU(parcel);
        List list = null;
        DataHolder dataHolder = null;
        int i = 0;
        while (parcel.dataPosition() < zzaU) {
            int zzaT = zzb.zzaT(parcel);
            switch (zzb.zzcW(zzaT)) {
                case MessageApi.FILTER_PREFIX /*1*/:
                    i = zzb.zzg(parcel, zzaT);
                    break;
                case ChannelListener.CLOSE_REASON_REMOTE_CLOSE /*2*/:
                    dataHolder = (DataHolder) zzb.zza(parcel, zzaT, DataHolder.CREATOR);
                    break;
                case ChannelListener.CLOSE_REASON_LOCAL_CLOSE /*3*/:
                    list = zzb.zzc(parcel, zzaT, DriveId.CREATOR);
                    break;
                case Dimension.UNIT_IN /*4*/:
                    com_google_android_gms_drive_zza = (zza) zzb.zza(parcel, zzaT, zza.CREATOR);
                    break;
                case Dimension.UNIT_MM /*5*/:
                    z = zzb.zzc(parcel, zzaT);
                    break;
                default:
                    zzb.zzb(parcel, zzaT);
                    break;
            }
        }
        if (parcel.dataPosition() == zzaU) {
            return new zzais(i, dataHolder, list, com_google_android_gms_drive_zza, z);
        }
        throw new zzb.zza("Overread allowed size end=" + zzaU, parcel);
    }

    public zzais[] zzeU(int i) {
        return new zzais[i];
    }
}
