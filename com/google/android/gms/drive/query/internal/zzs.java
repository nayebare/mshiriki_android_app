package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.common.internal.safeparcel.zzb.zza;
import com.google.android.gms.common.internal.safeparcel.zzc;
import com.google.android.gms.wallet.WalletConstants.CardNetwork;
import com.google.android.gms.wearable.ChannelApi.ChannelListener;
import com.google.android.gms.wearable.MessageApi;
import java.util.ArrayList;
import java.util.List;

public class zzs implements Creator<zzr> {
    static void zza(zzr com_google_android_gms_drive_query_internal_zzr, Parcel parcel, int i) {
        int zzaV = zzc.zzaV(parcel);
        zzc.zza(parcel, 1, com_google_android_gms_drive_query_internal_zzr.zzaOM, i, false);
        zzc.zzc(parcel, 2, com_google_android_gms_drive_query_internal_zzr.zzaPb, false);
        zzc.zzc(parcel, CardNetwork.OTHER, com_google_android_gms_drive_query_internal_zzr.mVersionCode);
        zzc.zzJ(parcel, zzaV);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzds(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzfO(i);
    }

    public zzr zzds(Parcel parcel) {
        List list = null;
        int zzaU = zzb.zzaU(parcel);
        int i = 0;
        zzx com_google_android_gms_drive_query_internal_zzx = null;
        while (parcel.dataPosition() < zzaU) {
            int i2;
            zzx com_google_android_gms_drive_query_internal_zzx2;
            ArrayList zzc;
            int zzaT = zzb.zzaT(parcel);
            List list2;
            switch (zzb.zzcW(zzaT)) {
                case MessageApi.FILTER_PREFIX /*1*/:
                    i2 = i;
                    zzx com_google_android_gms_drive_query_internal_zzx3 = (zzx) zzb.zza(parcel, zzaT, zzx.CREATOR);
                    list2 = list;
                    com_google_android_gms_drive_query_internal_zzx2 = com_google_android_gms_drive_query_internal_zzx3;
                    break;
                case ChannelListener.CLOSE_REASON_REMOTE_CLOSE /*2*/:
                    zzc = zzb.zzc(parcel, zzaT, FilterHolder.CREATOR);
                    com_google_android_gms_drive_query_internal_zzx2 = com_google_android_gms_drive_query_internal_zzx;
                    i2 = i;
                    break;
                case CardNetwork.OTHER /*1000*/:
                    List list3 = list;
                    com_google_android_gms_drive_query_internal_zzx2 = com_google_android_gms_drive_query_internal_zzx;
                    i2 = zzb.zzg(parcel, zzaT);
                    list2 = list3;
                    break;
                default:
                    zzb.zzb(parcel, zzaT);
                    zzc = list;
                    com_google_android_gms_drive_query_internal_zzx2 = com_google_android_gms_drive_query_internal_zzx;
                    i2 = i;
                    break;
            }
            i = i2;
            com_google_android_gms_drive_query_internal_zzx = com_google_android_gms_drive_query_internal_zzx2;
            Object obj = zzc;
        }
        if (parcel.dataPosition() == zzaU) {
            return new zzr(i, com_google_android_gms_drive_query_internal_zzx, list);
        }
        throw new zza("Overread allowed size end=" + zzaU, parcel);
    }

    public zzr[] zzfO(int i) {
        return new zzr[i];
    }
}
