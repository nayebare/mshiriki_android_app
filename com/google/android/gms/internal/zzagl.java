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
import java.util.ArrayList;
import java.util.List;

public class zzagl implements Creator<zzagk> {
    static void zza(zzagk com_google_android_gms_internal_zzagk, Parcel parcel, int i) {
        int zzaV = zzc.zzaV(parcel);
        zzc.zzc(parcel, 1, com_google_android_gms_internal_zzagk.mVersionCode);
        zzc.zza(parcel, 2, com_google_android_gms_internal_zzagk.zzaKO, i, false);
        zzc.zzc(parcel, 3, com_google_android_gms_internal_zzagk.zzaKP, false);
        zzc.zzc(parcel, 4, com_google_android_gms_internal_zzagk.zzaKQ, false);
        zzc.zzJ(parcel, zzaV);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzcd(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzeu(i);
    }

    public zzagk zzcd(Parcel parcel) {
        List list = null;
        int zzaU = zzb.zzaU(parcel);
        int i = 0;
        List list2 = null;
        DriveId driveId = null;
        while (parcel.dataPosition() < zzaU) {
            DriveId driveId2;
            int zzg;
            Object zzc;
            ArrayList zzc2;
            int zzaT = zzb.zzaT(parcel);
            List list3;
            List list4;
            switch (zzb.zzcW(zzaT)) {
                case MessageApi.FILTER_PREFIX /*1*/:
                    list3 = list;
                    list = list2;
                    driveId2 = driveId;
                    zzg = zzb.zzg(parcel, zzaT);
                    list4 = list3;
                    break;
                case ChannelListener.CLOSE_REASON_REMOTE_CLOSE /*2*/:
                    zzg = i;
                    list3 = list2;
                    driveId2 = (DriveId) zzb.zza(parcel, zzaT, DriveId.CREATOR);
                    list4 = list;
                    list = list3;
                    break;
                case ChannelListener.CLOSE_REASON_LOCAL_CLOSE /*3*/:
                    driveId2 = driveId;
                    zzg = i;
                    list3 = list;
                    zzc = zzb.zzc(parcel, zzaT, DriveId.CREATOR);
                    list4 = list3;
                    break;
                case Dimension.UNIT_IN /*4*/:
                    zzc2 = zzb.zzc(parcel, zzaT, DriveId.CREATOR);
                    list = list2;
                    driveId2 = driveId;
                    zzg = i;
                    break;
                default:
                    zzb.zzb(parcel, zzaT);
                    zzc2 = list;
                    list = list2;
                    driveId2 = driveId;
                    zzg = i;
                    break;
            }
            i = zzg;
            driveId = driveId2;
            list2 = list;
            zzc = zzc2;
        }
        if (parcel.dataPosition() == zzaU) {
            return new zzagk(i, driveId, list2, list);
        }
        throw new zza("Overread allowed size end=" + zzaU, parcel);
    }

    public zzagk[] zzeu(int i) {
        return new zzagk[i];
    }
}
