package com.google.android.gms.fitness.result;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.common.internal.safeparcel.zzb.zza;
import com.google.android.gms.common.internal.safeparcel.zzc;
import com.google.android.gms.wallet.WalletConstants.CardNetwork;
import com.google.android.gms.wearable.ChannelApi.ChannelListener;
import com.google.android.gms.wearable.MessageApi;

public class zzm implements Creator<zzl> {
    static void zza(zzl com_google_android_gms_fitness_result_zzl, Parcel parcel, int i) {
        int zzaV = zzc.zzaV(parcel);
        zzc.zza(parcel, 1, com_google_android_gms_fitness_result_zzl.getUri(), i, false);
        zzc.zza(parcel, 2, com_google_android_gms_fitness_result_zzl.getStatus(), i, false);
        zzc.zzc(parcel, CardNetwork.OTHER, com_google_android_gms_fitness_result_zzl.getVersionCode());
        zzc.zzJ(parcel, zzaV);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzfi(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzhR(i);
    }

    public zzl zzfi(Parcel parcel) {
        Status status = null;
        int zzaU = zzb.zzaU(parcel);
        int i = 0;
        Uri uri = null;
        while (parcel.dataPosition() < zzaU) {
            int i2;
            Status status2;
            Uri uri2;
            int zzaT = zzb.zzaT(parcel);
            switch (zzb.zzcW(zzaT)) {
                case MessageApi.FILTER_PREFIX /*1*/:
                    i2 = i;
                    Uri uri3 = (Uri) zzb.zza(parcel, zzaT, Uri.CREATOR);
                    status2 = status;
                    uri2 = uri3;
                    break;
                case ChannelListener.CLOSE_REASON_REMOTE_CLOSE /*2*/:
                    status2 = (Status) zzb.zza(parcel, zzaT, Status.CREATOR);
                    uri2 = uri;
                    i2 = i;
                    break;
                case CardNetwork.OTHER /*1000*/:
                    Status status3 = status;
                    uri2 = uri;
                    i2 = zzb.zzg(parcel, zzaT);
                    status2 = status3;
                    break;
                default:
                    zzb.zzb(parcel, zzaT);
                    status2 = status;
                    uri2 = uri;
                    i2 = i;
                    break;
            }
            i = i2;
            uri = uri2;
            status = status2;
        }
        if (parcel.dataPosition() == zzaU) {
            return new zzl(i, uri, status);
        }
        throw new zza("Overread allowed size end=" + zzaU, parcel);
    }

    public zzl[] zzhR(int i) {
        return new zzl[i];
    }
}
