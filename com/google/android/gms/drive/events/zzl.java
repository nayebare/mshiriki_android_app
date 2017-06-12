package com.google.android.gms.drive.events;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.common.internal.safeparcel.zzb.zza;
import com.google.android.gms.common.internal.safeparcel.zzc;
import com.google.android.gms.wallet.fragment.WalletFragmentStyle.Dimension;
import com.google.android.gms.wearable.ChannelApi.ChannelListener;
import com.google.android.gms.wearable.MessageApi;

public class zzl implements Creator<zzk> {
    static void zza(zzk com_google_android_gms_drive_events_zzk, Parcel parcel, int i) {
        int zzaV = zzc.zzaV(parcel);
        zzc.zzc(parcel, 1, com_google_android_gms_drive_events_zzk.mVersionCode);
        zzc.zza(parcel, 2, com_google_android_gms_drive_events_zzk.zzazI, i, false);
        zzc.zza(parcel, 3, com_google_android_gms_drive_events_zzk.zzaKz);
        zzc.zzc(parcel, 4, com_google_android_gms_drive_events_zzk.zzaKA);
        zzc.zzJ(parcel, zzaV);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzbT(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzek(i);
    }

    public zzk zzbT(Parcel parcel) {
        int i = 0;
        int zzaU = zzb.zzaU(parcel);
        DataHolder dataHolder = null;
        boolean z = false;
        int i2 = 0;
        while (parcel.dataPosition() < zzaU) {
            boolean z2;
            DataHolder dataHolder2;
            int zzg;
            int zzaT = zzb.zzaT(parcel);
            int i3;
            switch (zzb.zzcW(zzaT)) {
                case MessageApi.FILTER_PREFIX /*1*/:
                    i3 = i;
                    z2 = z;
                    dataHolder2 = dataHolder;
                    zzg = zzb.zzg(parcel, zzaT);
                    zzaT = i3;
                    break;
                case ChannelListener.CLOSE_REASON_REMOTE_CLOSE /*2*/:
                    zzg = i2;
                    boolean z3 = z;
                    dataHolder2 = (DataHolder) zzb.zza(parcel, zzaT, DataHolder.CREATOR);
                    zzaT = i;
                    z2 = z3;
                    break;
                case ChannelListener.CLOSE_REASON_LOCAL_CLOSE /*3*/:
                    dataHolder2 = dataHolder;
                    zzg = i2;
                    i3 = i;
                    z2 = zzb.zzc(parcel, zzaT);
                    zzaT = i3;
                    break;
                case Dimension.UNIT_IN /*4*/:
                    zzaT = zzb.zzg(parcel, zzaT);
                    z2 = z;
                    dataHolder2 = dataHolder;
                    zzg = i2;
                    break;
                default:
                    zzb.zzb(parcel, zzaT);
                    zzaT = i;
                    z2 = z;
                    dataHolder2 = dataHolder;
                    zzg = i2;
                    break;
            }
            i2 = zzg;
            dataHolder = dataHolder2;
            z = z2;
            i = zzaT;
        }
        if (parcel.dataPosition() == zzaU) {
            return new zzk(i2, dataHolder, z, i);
        }
        throw new zza("Overread allowed size end=" + zzaU, parcel);
    }

    public zzk[] zzek(int i) {
        return new zzk[i];
    }
}
