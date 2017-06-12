package com.google.android.gms.ads.internal.overlay;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.C0473R;
import com.google.android.gms.ads.internal.zzm;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.common.internal.safeparcel.zzb.zza;
import com.google.android.gms.common.internal.safeparcel.zzc;
import com.google.android.gms.games.GamesStatusCodes;
import com.google.android.gms.games.Notifications;
import com.google.android.gms.games.request.Requests;
import com.google.android.gms.internal.zzqa;
import com.google.android.gms.wallet.fragment.WalletFragmentStyle.BuyButtonText;
import com.google.android.gms.wallet.fragment.WalletFragmentStyle.Dimension;
import com.google.android.gms.wearable.ChannelApi.ChannelListener;
import com.google.android.gms.wearable.MessageApi;
import org.apache.http.protocol.HTTP;

public class zzg implements Creator<AdOverlayInfoParcel> {
    static void zza(AdOverlayInfoParcel adOverlayInfoParcel, Parcel parcel, int i) {
        int zzaV = zzc.zzaV(parcel);
        zzc.zzc(parcel, 1, adOverlayInfoParcel.versionCode);
        zzc.zza(parcel, 2, adOverlayInfoParcel.zzMW, i, false);
        zzc.zza(parcel, 3, adOverlayInfoParcel.zzhs(), false);
        zzc.zza(parcel, 4, adOverlayInfoParcel.zzht(), false);
        zzc.zza(parcel, 5, adOverlayInfoParcel.zzhu(), false);
        zzc.zza(parcel, 6, adOverlayInfoParcel.zzhv(), false);
        zzc.zza(parcel, 7, adOverlayInfoParcel.zzNb, false);
        zzc.zza(parcel, 8, adOverlayInfoParcel.zzNc);
        zzc.zza(parcel, 9, adOverlayInfoParcel.zzNd, false);
        zzc.zza(parcel, 10, adOverlayInfoParcel.zzhx(), false);
        zzc.zzc(parcel, 11, adOverlayInfoParcel.orientation);
        zzc.zzc(parcel, 12, adOverlayInfoParcel.zzNf);
        zzc.zza(parcel, 13, adOverlayInfoParcel.url, false);
        zzc.zza(parcel, 14, adOverlayInfoParcel.zzvf, i, false);
        zzc.zza(parcel, 15, adOverlayInfoParcel.zzhw(), false);
        zzc.zza(parcel, 16, adOverlayInfoParcel.zzNh, false);
        zzc.zza(parcel, 17, adOverlayInfoParcel.zzNi, i, false);
        zzc.zzJ(parcel, zzaV);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzk(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzL(i);
    }

    public AdOverlayInfoParcel[] zzL(int i) {
        return new AdOverlayInfoParcel[i];
    }

    public AdOverlayInfoParcel zzk(Parcel parcel) {
        int zzaU = zzb.zzaU(parcel);
        int i = 0;
        zzc com_google_android_gms_ads_internal_overlay_zzc = null;
        IBinder iBinder = null;
        IBinder iBinder2 = null;
        IBinder iBinder3 = null;
        IBinder iBinder4 = null;
        String str = null;
        boolean z = false;
        String str2 = null;
        IBinder iBinder5 = null;
        int i2 = 0;
        int i3 = 0;
        String str3 = null;
        zzqa com_google_android_gms_internal_zzqa = null;
        IBinder iBinder6 = null;
        String str4 = null;
        zzm com_google_android_gms_ads_internal_zzm = null;
        while (parcel.dataPosition() < zzaU) {
            int zzaT = zzb.zzaT(parcel);
            switch (zzb.zzcW(zzaT)) {
                case MessageApi.FILTER_PREFIX /*1*/:
                    i = zzb.zzg(parcel, zzaT);
                    break;
                case ChannelListener.CLOSE_REASON_REMOTE_CLOSE /*2*/:
                    com_google_android_gms_ads_internal_overlay_zzc = (zzc) zzb.zza(parcel, zzaT, zzc.CREATOR);
                    break;
                case ChannelListener.CLOSE_REASON_LOCAL_CLOSE /*3*/:
                    iBinder = zzb.zzr(parcel, zzaT);
                    break;
                case Dimension.UNIT_IN /*4*/:
                    iBinder2 = zzb.zzr(parcel, zzaT);
                    break;
                case Dimension.UNIT_MM /*5*/:
                    iBinder3 = zzb.zzr(parcel, zzaT);
                    break;
                case BuyButtonText.LOGO_ONLY /*6*/:
                    iBinder4 = zzb.zzr(parcel, zzaT);
                    break;
                case BuyButtonText.DONATE_WITH /*7*/:
                    str = zzb.zzq(parcel, zzaT);
                    break;
                case Requests.MAX_REQUEST_RECIPIENTS /*8*/:
                    z = zzb.zzc(parcel, zzaT);
                    break;
                case HTTP.HT /*9*/:
                    str2 = zzb.zzq(parcel, zzaT);
                    break;
                case HTTP.LF /*10*/:
                    iBinder5 = zzb.zzr(parcel, zzaT);
                    break;
                case ConnectionResult.LICENSE_CHECK_FAILED /*11*/:
                    i2 = zzb.zzg(parcel, zzaT);
                    break;
                case C0473R.styleable.MapAttrs_uiZoomGestures /*12*/:
                    i3 = zzb.zzg(parcel, zzaT);
                    break;
                case HTTP.CR /*13*/:
                    str3 = zzb.zzq(parcel, zzaT);
                    break;
                case GamesStatusCodes.STATUS_INTERRUPTED /*14*/:
                    com_google_android_gms_internal_zzqa = (zzqa) zzb.zza(parcel, zzaT, zzqa.CREATOR);
                    break;
                case GamesStatusCodes.STATUS_TIMEOUT /*15*/:
                    iBinder6 = zzb.zzr(parcel, zzaT);
                    break;
                case Notifications.NOTIFICATION_TYPE_LEVEL_UP /*16*/:
                    str4 = zzb.zzq(parcel, zzaT);
                    break;
                case ConnectionResult.SIGN_IN_FAILED /*17*/:
                    com_google_android_gms_ads_internal_zzm = (zzm) zzb.zza(parcel, zzaT, zzm.CREATOR);
                    break;
                default:
                    zzb.zzb(parcel, zzaT);
                    break;
            }
        }
        if (parcel.dataPosition() == zzaU) {
            return new AdOverlayInfoParcel(i, com_google_android_gms_ads_internal_overlay_zzc, iBinder, iBinder2, iBinder3, iBinder4, str, z, str2, iBinder5, i2, i3, str3, com_google_android_gms_internal_zzqa, iBinder6, str4, com_google_android_gms_ads_internal_zzm);
        }
        throw new zza("Overread allowed size end=" + zzaU, parcel);
    }
}
