package com.google.android.gms.internal;

import android.app.PendingIntent;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.common.internal.safeparcel.zzb.zza;
import com.google.android.gms.common.internal.safeparcel.zzc;
import com.google.android.gms.games.request.Requests;
import com.google.android.gms.wallet.fragment.WalletFragmentStyle.BuyButtonText;
import com.google.android.gms.wallet.fragment.WalletFragmentStyle.Dimension;
import com.google.android.gms.wearable.ChannelApi.ChannelListener;
import com.google.android.gms.wearable.MessageApi;

public class zzaev implements Creator<zzaeu> {
    static void zza(zzaeu com_google_android_gms_internal_zzaeu, Parcel parcel, int i) {
        int zzaV = zzc.zzaV(parcel);
        zzc.zzc(parcel, 1, com_google_android_gms_internal_zzaeu.versionCode);
        zzc.zzc(parcel, 2, com_google_android_gms_internal_zzaeu.type);
        zzc.zza(parcel, 3, com_google_android_gms_internal_zzaeu.zzaIg, i, false);
        zzc.zza(parcel, 4, com_google_android_gms_internal_zzaeu.zzzs(), false);
        zzc.zza(parcel, 5, com_google_android_gms_internal_zzaeu.zzaIj, i, false);
        zzc.zza(parcel, 6, com_google_android_gms_internal_zzaeu.zzaHZ, false);
        zzc.zza(parcel, 7, com_google_android_gms_internal_zzaeu.zzaIk);
        zzc.zza(parcel, 8, com_google_android_gms_internal_zzaeu.zzaIl);
        zzc.zzJ(parcel, zzaV);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzbu(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzdF(i);
    }

    public zzaeu zzbu(Parcel parcel) {
        long j = 0;
        int i = 0;
        String str = null;
        int zzaU = zzb.zzaU(parcel);
        long j2 = 0;
        PendingIntent pendingIntent = null;
        IBinder iBinder = null;
        zzaec com_google_android_gms_internal_zzaec = null;
        int i2 = 0;
        while (parcel.dataPosition() < zzaU) {
            int zzaT = zzb.zzaT(parcel);
            switch (zzb.zzcW(zzaT)) {
                case MessageApi.FILTER_PREFIX /*1*/:
                    i2 = zzb.zzg(parcel, zzaT);
                    break;
                case ChannelListener.CLOSE_REASON_REMOTE_CLOSE /*2*/:
                    i = zzb.zzg(parcel, zzaT);
                    break;
                case ChannelListener.CLOSE_REASON_LOCAL_CLOSE /*3*/:
                    com_google_android_gms_internal_zzaec = (zzaec) zzb.zza(parcel, zzaT, zzaec.CREATOR);
                    break;
                case Dimension.UNIT_IN /*4*/:
                    iBinder = zzb.zzr(parcel, zzaT);
                    break;
                case Dimension.UNIT_MM /*5*/:
                    pendingIntent = (PendingIntent) zzb.zza(parcel, zzaT, PendingIntent.CREATOR);
                    break;
                case BuyButtonText.LOGO_ONLY /*6*/:
                    str = zzb.zzq(parcel, zzaT);
                    break;
                case BuyButtonText.DONATE_WITH /*7*/:
                    j2 = zzb.zzi(parcel, zzaT);
                    break;
                case Requests.MAX_REQUEST_RECIPIENTS /*8*/:
                    j = zzb.zzi(parcel, zzaT);
                    break;
                default:
                    zzb.zzb(parcel, zzaT);
                    break;
            }
        }
        if (parcel.dataPosition() == zzaU) {
            return new zzaeu(i2, i, com_google_android_gms_internal_zzaec, iBinder, pendingIntent, str, j2, j);
        }
        throw new zza("Overread allowed size end=" + zzaU, parcel);
    }

    public zzaeu[] zzdF(int i) {
        return new zzaeu[i];
    }
}
