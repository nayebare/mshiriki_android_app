package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.C0473R;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.common.internal.safeparcel.zzb.zza;
import com.google.android.gms.common.internal.safeparcel.zzc;
import com.google.android.gms.games.GamesStatusCodes;
import com.google.android.gms.games.Notifications;
import com.google.android.gms.games.request.Requests;
import com.google.android.gms.wallet.fragment.WalletFragmentStyle.BuyButtonText;
import com.google.android.gms.wallet.fragment.WalletFragmentStyle.Dimension;
import com.google.android.gms.wearable.ChannelApi.ChannelListener;
import com.google.android.gms.wearable.MessageApi;
import java.util.List;
import org.apache.http.protocol.HTTP;

public class zzamo implements Creator<zzamn> {
    static void zza(zzamn com_google_android_gms_internal_zzamn, Parcel parcel, int i) {
        int zzaV = zzc.zzaV(parcel);
        zzc.zzc(parcel, 1, com_google_android_gms_internal_zzamn.mVersionCode);
        zzc.zza(parcel, 2, com_google_android_gms_internal_zzamn.zzVW, false);
        zzc.zza(parcel, 3, com_google_android_gms_internal_zzamn.zzach, false);
        zzc.zzb(parcel, 4, com_google_android_gms_internal_zzamn.zzaPx, false);
        zzc.zza(parcel, 5, com_google_android_gms_internal_zzamn.zzaPy);
        zzc.zza(parcel, 6, com_google_android_gms_internal_zzamn.zzaPr, false);
        zzc.zza(parcel, 7, com_google_android_gms_internal_zzamn.zzaPB, false);
        zzc.zza(parcel, 8, com_google_android_gms_internal_zzamn.zzaPC, i, false);
        zzc.zza(parcel, 9, com_google_android_gms_internal_zzamn.zzaPD, i, false);
        zzc.zza(parcel, 10, com_google_android_gms_internal_zzamn.zzaPE, i, false);
        zzc.zza(parcel, 11, com_google_android_gms_internal_zzamn.zzaPF, i, false);
        zzc.zza(parcel, 12, com_google_android_gms_internal_zzamn.zzaPG, i, false);
        zzc.zza(parcel, 13, com_google_android_gms_internal_zzamn.zzaPH, i, false);
        zzc.zza(parcel, 14, com_google_android_gms_internal_zzamn.zzaPI, i, false);
        zzc.zza(parcel, 15, com_google_android_gms_internal_zzamn.zzaPJ, i, false);
        zzc.zza(parcel, 16, com_google_android_gms_internal_zzamn.zzaPz);
        zzc.zza(parcel, 17, com_google_android_gms_internal_zzamn.zzaPA);
        zzc.zza(parcel, 18, com_google_android_gms_internal_zzamn.zzaPK, i, false);
        zzc.zzJ(parcel, zzaV);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzdE(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzgb(i);
    }

    public zzamn zzdE(Parcel parcel) {
        int zzaU = zzb.zzaU(parcel);
        int i = 0;
        String str = null;
        String str2 = null;
        List list = null;
        boolean z = false;
        boolean z2 = false;
        boolean z3 = false;
        String str3 = null;
        String str4 = null;
        zzamv com_google_android_gms_internal_zzamv = null;
        zzamt com_google_android_gms_internal_zzamt = null;
        zzamz com_google_android_gms_internal_zzamz = null;
        zzanb com_google_android_gms_internal_zzanb = null;
        zzand com_google_android_gms_internal_zzand = null;
        zzamx com_google_android_gms_internal_zzamx = null;
        zzamr com_google_android_gms_internal_zzamr = null;
        zzaml com_google_android_gms_internal_zzaml = null;
        zzamj com_google_android_gms_internal_zzamj = null;
        while (parcel.dataPosition() < zzaU) {
            int zzaT = zzb.zzaT(parcel);
            switch (zzb.zzcW(zzaT)) {
                case MessageApi.FILTER_PREFIX /*1*/:
                    i = zzb.zzg(parcel, zzaT);
                    break;
                case ChannelListener.CLOSE_REASON_REMOTE_CLOSE /*2*/:
                    str = zzb.zzq(parcel, zzaT);
                    break;
                case ChannelListener.CLOSE_REASON_LOCAL_CLOSE /*3*/:
                    str2 = zzb.zzq(parcel, zzaT);
                    break;
                case Dimension.UNIT_IN /*4*/:
                    list = zzb.zzE(parcel, zzaT);
                    break;
                case Dimension.UNIT_MM /*5*/:
                    z = zzb.zzc(parcel, zzaT);
                    break;
                case BuyButtonText.LOGO_ONLY /*6*/:
                    str3 = zzb.zzq(parcel, zzaT);
                    break;
                case BuyButtonText.DONATE_WITH /*7*/:
                    str4 = zzb.zzq(parcel, zzaT);
                    break;
                case Requests.MAX_REQUEST_RECIPIENTS /*8*/:
                    com_google_android_gms_internal_zzamv = (zzamv) zzb.zza(parcel, zzaT, zzamv.CREATOR);
                    break;
                case HTTP.HT /*9*/:
                    com_google_android_gms_internal_zzamt = (zzamt) zzb.zza(parcel, zzaT, zzamt.CREATOR);
                    break;
                case HTTP.LF /*10*/:
                    com_google_android_gms_internal_zzamz = (zzamz) zzb.zza(parcel, zzaT, zzamz.CREATOR);
                    break;
                case ConnectionResult.LICENSE_CHECK_FAILED /*11*/:
                    com_google_android_gms_internal_zzanb = (zzanb) zzb.zza(parcel, zzaT, zzanb.CREATOR);
                    break;
                case C0473R.styleable.MapAttrs_uiZoomGestures /*12*/:
                    com_google_android_gms_internal_zzand = (zzand) zzb.zza(parcel, zzaT, zzand.CREATOR);
                    break;
                case HTTP.CR /*13*/:
                    com_google_android_gms_internal_zzamx = (zzamx) zzb.zza(parcel, zzaT, zzamx.CREATOR);
                    break;
                case GamesStatusCodes.STATUS_INTERRUPTED /*14*/:
                    com_google_android_gms_internal_zzamr = (zzamr) zzb.zza(parcel, zzaT, zzamr.CREATOR);
                    break;
                case GamesStatusCodes.STATUS_TIMEOUT /*15*/:
                    com_google_android_gms_internal_zzaml = (zzaml) zzb.zza(parcel, zzaT, zzaml.CREATOR);
                    break;
                case Notifications.NOTIFICATION_TYPE_LEVEL_UP /*16*/:
                    z2 = zzb.zzc(parcel, zzaT);
                    break;
                case ConnectionResult.SIGN_IN_FAILED /*17*/:
                    z3 = zzb.zzc(parcel, zzaT);
                    break;
                case ConnectionResult.SERVICE_UPDATING /*18*/:
                    com_google_android_gms_internal_zzamj = (zzamj) zzb.zza(parcel, zzaT, zzamj.CREATOR);
                    break;
                default:
                    zzb.zzb(parcel, zzaT);
                    break;
            }
        }
        if (parcel.dataPosition() == zzaU) {
            return new zzamn(i, str, str2, list, z, z2, z3, str3, str4, com_google_android_gms_internal_zzamv, com_google_android_gms_internal_zzamt, com_google_android_gms_internal_zzamz, com_google_android_gms_internal_zzanb, com_google_android_gms_internal_zzand, com_google_android_gms_internal_zzamx, com_google_android_gms_internal_zzamr, com_google_android_gms_internal_zzaml, com_google_android_gms_internal_zzamj);
        }
        throw new zza("Overread allowed size end=" + zzaU, parcel);
    }

    public zzamn[] zzgb(int i) {
        return new zzamn[i];
    }
}
