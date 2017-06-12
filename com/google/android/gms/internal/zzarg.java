package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.data.BitmapTeleporter;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.common.internal.safeparcel.zzb.zza;
import com.google.android.gms.common.internal.safeparcel.zzc;
import com.google.android.gms.games.request.Requests;
import com.google.android.gms.wallet.fragment.WalletFragmentStyle.BuyButtonText;
import com.google.android.gms.wallet.fragment.WalletFragmentStyle.Dimension;
import com.google.android.gms.wearable.ChannelApi.ChannelListener;
import com.google.android.gms.wearable.MessageApi;
import java.util.Collection;

public class zzarg implements Creator<zzarf> {
    static void zza(zzarf com_google_android_gms_internal_zzarf, Parcel parcel, int i) {
        int zzaV = zzc.zzaV(parcel);
        zzc.zzc(parcel, 1, com_google_android_gms_internal_zzarf.version);
        zzc.zza(parcel, 2, com_google_android_gms_internal_zzarf.zzHe(), i, false);
        zzc.zza(parcel, 3, com_google_android_gms_internal_zzarf.zzmx(), false);
        zzc.zza(parcel, 4, com_google_android_gms_internal_zzarf.getDeveloperName(), false);
        zzc.zza(parcel, 5, com_google_android_gms_internal_zzarf.zzHf(), false);
        zzc.zza(parcel, 6, com_google_android_gms_internal_zzarf.getPackageName(), false);
        zzc.zzb(parcel, 7, com_google_android_gms_internal_zzarf.zzHg(), false);
        zzc.zza(parcel, 8, com_google_android_gms_internal_zzarf.zzHh(), i, false);
        zzc.zzJ(parcel, zzaV);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzgz(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzjQ(i);
    }

    public zzarf zzgz(Parcel parcel) {
        zzaqj com_google_android_gms_internal_zzaqj = null;
        int zzaU = zzb.zzaU(parcel);
        int i = 0;
        Collection collection = null;
        String str = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        BitmapTeleporter bitmapTeleporter = null;
        while (parcel.dataPosition() < zzaU) {
            int zzaT = zzb.zzaT(parcel);
            switch (zzb.zzcW(zzaT)) {
                case MessageApi.FILTER_PREFIX /*1*/:
                    i = zzb.zzg(parcel, zzaT);
                    break;
                case ChannelListener.CLOSE_REASON_REMOTE_CLOSE /*2*/:
                    bitmapTeleporter = (BitmapTeleporter) zzb.zza(parcel, zzaT, BitmapTeleporter.CREATOR);
                    break;
                case ChannelListener.CLOSE_REASON_LOCAL_CLOSE /*3*/:
                    str4 = zzb.zzq(parcel, zzaT);
                    break;
                case Dimension.UNIT_IN /*4*/:
                    str3 = zzb.zzq(parcel, zzaT);
                    break;
                case Dimension.UNIT_MM /*5*/:
                    str2 = zzb.zzq(parcel, zzaT);
                    break;
                case BuyButtonText.LOGO_ONLY /*6*/:
                    str = zzb.zzq(parcel, zzaT);
                    break;
                case BuyButtonText.DONATE_WITH /*7*/:
                    collection = zzb.zzE(parcel, zzaT);
                    break;
                case Requests.MAX_REQUEST_RECIPIENTS /*8*/:
                    com_google_android_gms_internal_zzaqj = (zzaqj) zzb.zza(parcel, zzaT, zzaqj.CREATOR);
                    break;
                default:
                    zzb.zzb(parcel, zzaT);
                    break;
            }
        }
        if (parcel.dataPosition() == zzaU) {
            return new zzarf(i, bitmapTeleporter, str4, str3, str2, str, collection, com_google_android_gms_internal_zzaqj);
        }
        throw new zza("Overread allowed size end=" + zzaU, parcel);
    }

    public zzarf[] zzjQ(int i) {
        return new zzarf[i];
    }
}
