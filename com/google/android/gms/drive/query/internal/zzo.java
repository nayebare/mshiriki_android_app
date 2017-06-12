package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.common.internal.safeparcel.zzb.zza;
import com.google.android.gms.common.internal.safeparcel.zzc;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;
import com.google.android.gms.wallet.WalletConstants.CardNetwork;
import com.google.android.gms.wearable.MessageApi;

public class zzo implements Creator<zzn> {
    static void zza(zzn com_google_android_gms_drive_query_internal_zzn, Parcel parcel, int i) {
        int zzaV = zzc.zzaV(parcel);
        zzc.zza(parcel, 1, com_google_android_gms_drive_query_internal_zzn.zzaON, i, false);
        zzc.zzc(parcel, CardNetwork.OTHER, com_google_android_gms_drive_query_internal_zzn.mVersionCode);
        zzc.zzJ(parcel, zzaV);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzdq(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzfM(i);
    }

    public zzn zzdq(Parcel parcel) {
        int zzaU = zzb.zzaU(parcel);
        int i = 0;
        MetadataBundle metadataBundle = null;
        while (parcel.dataPosition() < zzaU) {
            int zzaT = zzb.zzaT(parcel);
            switch (zzb.zzcW(zzaT)) {
                case MessageApi.FILTER_PREFIX /*1*/:
                    metadataBundle = (MetadataBundle) zzb.zza(parcel, zzaT, MetadataBundle.CREATOR);
                    break;
                case CardNetwork.OTHER /*1000*/:
                    i = zzb.zzg(parcel, zzaT);
                    break;
                default:
                    zzb.zzb(parcel, zzaT);
                    break;
            }
        }
        if (parcel.dataPosition() == zzaU) {
            return new zzn(i, metadataBundle);
        }
        throw new zza("Overread allowed size end=" + zzaU, parcel);
    }

    public zzn[] zzfM(int i) {
        return new zzn[i];
    }
}
