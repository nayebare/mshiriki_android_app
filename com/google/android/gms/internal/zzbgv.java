package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.C0473R;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.common.internal.safeparcel.zzb.zza;
import com.google.android.gms.common.internal.safeparcel.zzc;
import com.google.android.gms.games.request.Requests;
import com.google.android.gms.wallet.fragment.WalletFragmentStyle.BuyButtonText;
import com.google.android.gms.wallet.fragment.WalletFragmentStyle.Dimension;
import com.google.android.gms.wearable.ChannelApi.ChannelListener;
import com.google.android.gms.wearable.MessageApi;
import org.apache.http.protocol.HTTP;

public class zzbgv implements Creator<zzbgu> {
    static void zza(zzbgu com_google_android_gms_internal_zzbgu, Parcel parcel, int i) {
        int zzaV = zzc.zzaV(parcel);
        zzc.zzc(parcel, 1, com_google_android_gms_internal_zzbgu.versionCode);
        zzc.zzc(parcel, 2, com_google_android_gms_internal_zzbgu.id);
        zzc.zza(parcel, 3, com_google_android_gms_internal_zzbgu.centerX);
        zzc.zza(parcel, 4, com_google_android_gms_internal_zzbgu.centerY);
        zzc.zza(parcel, 5, com_google_android_gms_internal_zzbgu.width);
        zzc.zza(parcel, 6, com_google_android_gms_internal_zzbgu.height);
        zzc.zza(parcel, 7, com_google_android_gms_internal_zzbgu.zzbNd);
        zzc.zza(parcel, 8, com_google_android_gms_internal_zzbgu.zzbNe);
        zzc.zza(parcel, 9, com_google_android_gms_internal_zzbgu.zzbNf, i, false);
        zzc.zza(parcel, 10, com_google_android_gms_internal_zzbgu.zzbNg);
        zzc.zza(parcel, 11, com_google_android_gms_internal_zzbgu.zzbNh);
        zzc.zza(parcel, 12, com_google_android_gms_internal_zzbgu.zzbNi);
        zzc.zzJ(parcel, zzaV);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzjh(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zznx(i);
    }

    public zzbgu zzjh(Parcel parcel) {
        int zzaU = zzb.zzaU(parcel);
        int i = 0;
        int i2 = 0;
        float f = 0.0f;
        float f2 = 0.0f;
        float f3 = 0.0f;
        float f4 = 0.0f;
        float f5 = 0.0f;
        float f6 = 0.0f;
        zzbha[] com_google_android_gms_internal_zzbhaArr = null;
        float f7 = 0.0f;
        float f8 = 0.0f;
        float f9 = 0.0f;
        while (parcel.dataPosition() < zzaU) {
            int zzaT = zzb.zzaT(parcel);
            switch (zzb.zzcW(zzaT)) {
                case MessageApi.FILTER_PREFIX /*1*/:
                    i = zzb.zzg(parcel, zzaT);
                    break;
                case ChannelListener.CLOSE_REASON_REMOTE_CLOSE /*2*/:
                    i2 = zzb.zzg(parcel, zzaT);
                    break;
                case ChannelListener.CLOSE_REASON_LOCAL_CLOSE /*3*/:
                    f = zzb.zzl(parcel, zzaT);
                    break;
                case Dimension.UNIT_IN /*4*/:
                    f2 = zzb.zzl(parcel, zzaT);
                    break;
                case Dimension.UNIT_MM /*5*/:
                    f3 = zzb.zzl(parcel, zzaT);
                    break;
                case BuyButtonText.LOGO_ONLY /*6*/:
                    f4 = zzb.zzl(parcel, zzaT);
                    break;
                case BuyButtonText.DONATE_WITH /*7*/:
                    f5 = zzb.zzl(parcel, zzaT);
                    break;
                case Requests.MAX_REQUEST_RECIPIENTS /*8*/:
                    f6 = zzb.zzl(parcel, zzaT);
                    break;
                case HTTP.HT /*9*/:
                    com_google_android_gms_internal_zzbhaArr = (zzbha[]) zzb.zzb(parcel, zzaT, zzbha.CREATOR);
                    break;
                case HTTP.LF /*10*/:
                    f7 = zzb.zzl(parcel, zzaT);
                    break;
                case ConnectionResult.LICENSE_CHECK_FAILED /*11*/:
                    f8 = zzb.zzl(parcel, zzaT);
                    break;
                case C0473R.styleable.MapAttrs_uiZoomGestures /*12*/:
                    f9 = zzb.zzl(parcel, zzaT);
                    break;
                default:
                    zzb.zzb(parcel, zzaT);
                    break;
            }
        }
        if (parcel.dataPosition() == zzaU) {
            return new zzbgu(i, i2, f, f2, f3, f4, f5, f6, com_google_android_gms_internal_zzbhaArr, f7, f8, f9);
        }
        throw new zza("Overread allowed size end=" + zzaU, parcel);
    }

    public zzbgu[] zznx(int i) {
        return new zzbgu[i];
    }
}
