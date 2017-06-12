package com.google.android.gms.internal;

import android.content.pm.PackageInfo;
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
import java.util.List;
import org.apache.http.protocol.HTTP;

public class zzaqf implements Creator<zzaqe> {
    static void zza(zzaqe com_google_android_gms_internal_zzaqe, Parcel parcel, int i) {
        int zzaV = zzc.zzaV(parcel);
        zzc.zzc(parcel, 1, com_google_android_gms_internal_zzaqe.version);
        zzc.zza(parcel, 2, com_google_android_gms_internal_zzaqe.getPackageName(), false);
        zzc.zza(parcel, 3, com_google_android_gms_internal_zzaqe.getTitle(), false);
        zzc.zza(parcel, 4, com_google_android_gms_internal_zzaqe.zzbhH, i, false);
        zzc.zzc(parcel, 5, com_google_android_gms_internal_zzaqe.getRoutes(), false);
        zzc.zzc(parcel, 6, com_google_android_gms_internal_zzaqe.zzGB(), false);
        zzc.zzc(parcel, 7, com_google_android_gms_internal_zzaqe.zzGD());
        zzc.zza(parcel, 8, com_google_android_gms_internal_zzaqe.zzGE(), false);
        zzc.zza(parcel, 9, com_google_android_gms_internal_zzaqe.zzGF(), i, false);
        zzc.zzc(parcel, 10, com_google_android_gms_internal_zzaqe.zzGC(), false);
        zzc.zzJ(parcel, zzaV);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzgq(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzjE(i);
    }

    public zzaqe zzgq(Parcel parcel) {
        int i = 0;
        List list = null;
        int zzaU = zzb.zzaU(parcel);
        PackageInfo packageInfo = null;
        byte[] bArr = null;
        List list2 = null;
        List list3 = null;
        BitmapTeleporter bitmapTeleporter = null;
        String str = null;
        String str2 = null;
        int i2 = 0;
        while (parcel.dataPosition() < zzaU) {
            int zzaT = zzb.zzaT(parcel);
            switch (zzb.zzcW(zzaT)) {
                case MessageApi.FILTER_PREFIX /*1*/:
                    i2 = zzb.zzg(parcel, zzaT);
                    break;
                case ChannelListener.CLOSE_REASON_REMOTE_CLOSE /*2*/:
                    str2 = zzb.zzq(parcel, zzaT);
                    break;
                case ChannelListener.CLOSE_REASON_LOCAL_CLOSE /*3*/:
                    str = zzb.zzq(parcel, zzaT);
                    break;
                case Dimension.UNIT_IN /*4*/:
                    bitmapTeleporter = (BitmapTeleporter) zzb.zza(parcel, zzaT, BitmapTeleporter.CREATOR);
                    break;
                case Dimension.UNIT_MM /*5*/:
                    list3 = zzb.zzc(parcel, zzaT, zzara.CREATOR);
                    break;
                case BuyButtonText.LOGO_ONLY /*6*/:
                    list2 = zzb.zzc(parcel, zzaT, zzaqg.CREATOR);
                    break;
                case BuyButtonText.DONATE_WITH /*7*/:
                    i = zzb.zzg(parcel, zzaT);
                    break;
                case Requests.MAX_REQUEST_RECIPIENTS /*8*/:
                    bArr = zzb.zzt(parcel, zzaT);
                    break;
                case HTTP.HT /*9*/:
                    packageInfo = (PackageInfo) zzb.zza(parcel, zzaT, PackageInfo.CREATOR);
                    break;
                case HTTP.LF /*10*/:
                    list = zzb.zzc(parcel, zzaT, zzard.CREATOR);
                    break;
                default:
                    zzb.zzb(parcel, zzaT);
                    break;
            }
        }
        if (parcel.dataPosition() == zzaU) {
            return new zzaqe(i2, str2, str, bitmapTeleporter, list3, list2, i, bArr, packageInfo, list);
        }
        throw new zza("Overread allowed size end=" + zzaU, parcel);
    }

    public zzaqe[] zzjE(int i) {
        return new zzaqe[i];
    }
}
