package com.google.android.gms.instantapps;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.data.BitmapTeleporter;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.common.internal.safeparcel.zzc;
import com.google.android.gms.wallet.fragment.WalletFragmentStyle.Dimension;
import com.google.android.gms.wearable.ChannelApi.ChannelListener;
import com.google.android.gms.wearable.MessageApi;

public class zza implements Creator<LaunchData> {
    static void zza(LaunchData launchData, Parcel parcel, int i) {
        int zzaV = zzc.zzaV(parcel);
        zzc.zzc(parcel, 1, launchData.getVersionCode());
        zzc.zza(parcel, 2, launchData.getIntent(), i, false);
        zzc.zza(parcel, 3, launchData.getPackageName(), false);
        zzc.zza(parcel, 4, launchData.getApplicationLabel(), false);
        zzc.zza(parcel, 5, launchData.zzbhF, i, false);
        zzc.zzJ(parcel, zzaV);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzgo(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzjC(i);
    }

    public LaunchData zzgo(Parcel parcel) {
        BitmapTeleporter bitmapTeleporter = null;
        int zzaU = zzb.zzaU(parcel);
        int i = 0;
        String str = null;
        String str2 = null;
        Intent intent = null;
        while (parcel.dataPosition() < zzaU) {
            int zzaT = zzb.zzaT(parcel);
            switch (zzb.zzcW(zzaT)) {
                case MessageApi.FILTER_PREFIX /*1*/:
                    i = zzb.zzg(parcel, zzaT);
                    break;
                case ChannelListener.CLOSE_REASON_REMOTE_CLOSE /*2*/:
                    intent = (Intent) zzb.zza(parcel, zzaT, Intent.CREATOR);
                    break;
                case ChannelListener.CLOSE_REASON_LOCAL_CLOSE /*3*/:
                    str2 = zzb.zzq(parcel, zzaT);
                    break;
                case Dimension.UNIT_IN /*4*/:
                    str = zzb.zzq(parcel, zzaT);
                    break;
                case Dimension.UNIT_MM /*5*/:
                    bitmapTeleporter = (BitmapTeleporter) zzb.zza(parcel, zzaT, BitmapTeleporter.CREATOR);
                    break;
                default:
                    zzb.zzb(parcel, zzaT);
                    break;
            }
        }
        if (parcel.dataPosition() == zzaU) {
            return new LaunchData(i, intent, str2, str, bitmapTeleporter);
        }
        throw new com.google.android.gms.common.internal.safeparcel.zzb.zza("Overread allowed size end=" + zzaU, parcel);
    }

    public LaunchData[] zzjC(int i) {
        return new LaunchData[i];
    }
}
