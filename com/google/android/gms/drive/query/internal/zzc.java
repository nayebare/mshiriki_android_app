package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.common.internal.safeparcel.zzb.zza;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;
import com.google.android.gms.wallet.WalletConstants.CardNetwork;
import com.google.android.gms.wearable.ChannelApi.ChannelListener;
import com.google.android.gms.wearable.MessageApi;

public class zzc implements Creator<zzb> {
    static void zza(zzb com_google_android_gms_drive_query_internal_zzb, Parcel parcel, int i) {
        int zzaV = com.google.android.gms.common.internal.safeparcel.zzc.zzaV(parcel);
        com.google.android.gms.common.internal.safeparcel.zzc.zza(parcel, 1, com_google_android_gms_drive_query_internal_zzb.zzaOM, i, false);
        com.google.android.gms.common.internal.safeparcel.zzc.zza(parcel, 2, com_google_android_gms_drive_query_internal_zzb.zzaON, i, false);
        com.google.android.gms.common.internal.safeparcel.zzc.zzc(parcel, CardNetwork.OTHER, com_google_android_gms_drive_query_internal_zzb.mVersionCode);
        com.google.android.gms.common.internal.safeparcel.zzc.zzJ(parcel, zzaV);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzdl(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzfH(i);
    }

    public zzb zzdl(Parcel parcel) {
        MetadataBundle metadataBundle = null;
        int zzaU = zzb.zzaU(parcel);
        int i = 0;
        zzx com_google_android_gms_drive_query_internal_zzx = null;
        while (parcel.dataPosition() < zzaU) {
            int i2;
            MetadataBundle metadataBundle2;
            zzx com_google_android_gms_drive_query_internal_zzx2;
            int zzaT = zzb.zzaT(parcel);
            switch (zzb.zzcW(zzaT)) {
                case MessageApi.FILTER_PREFIX /*1*/:
                    i2 = i;
                    zzx com_google_android_gms_drive_query_internal_zzx3 = (zzx) zzb.zza(parcel, zzaT, zzx.CREATOR);
                    metadataBundle2 = metadataBundle;
                    com_google_android_gms_drive_query_internal_zzx2 = com_google_android_gms_drive_query_internal_zzx3;
                    break;
                case ChannelListener.CLOSE_REASON_REMOTE_CLOSE /*2*/:
                    metadataBundle2 = (MetadataBundle) zzb.zza(parcel, zzaT, MetadataBundle.CREATOR);
                    com_google_android_gms_drive_query_internal_zzx2 = com_google_android_gms_drive_query_internal_zzx;
                    i2 = i;
                    break;
                case CardNetwork.OTHER /*1000*/:
                    MetadataBundle metadataBundle3 = metadataBundle;
                    com_google_android_gms_drive_query_internal_zzx2 = com_google_android_gms_drive_query_internal_zzx;
                    i2 = zzb.zzg(parcel, zzaT);
                    metadataBundle2 = metadataBundle3;
                    break;
                default:
                    zzb.zzb(parcel, zzaT);
                    metadataBundle2 = metadataBundle;
                    com_google_android_gms_drive_query_internal_zzx2 = com_google_android_gms_drive_query_internal_zzx;
                    i2 = i;
                    break;
            }
            i = i2;
            com_google_android_gms_drive_query_internal_zzx = com_google_android_gms_drive_query_internal_zzx2;
            metadataBundle = metadataBundle2;
        }
        if (parcel.dataPosition() == zzaU) {
            return new zzb(i, com_google_android_gms_drive_query_internal_zzx, metadataBundle);
        }
        throw new zza("Overread allowed size end=" + zzaU, parcel);
    }

    public zzb[] zzfH(int i) {
        return new zzb[i];
    }
}
