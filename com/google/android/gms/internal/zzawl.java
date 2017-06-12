package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.v7.mediarouter.C0308R;
import com.google.android.gms.C0473R;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.common.internal.safeparcel.zzc;
import com.google.android.gms.games.GamesStatusCodes;
import com.google.android.gms.games.Notifications;
import com.google.android.gms.games.request.Requests;
import com.google.android.gms.internal.zzawk.zza;
import com.google.android.gms.internal.zzawk.zzd;
import com.google.android.gms.internal.zzawk.zzf;
import com.google.android.gms.internal.zzawk.zzg;
import com.google.android.gms.internal.zzawk.zzh;
import com.google.android.gms.wallet.fragment.WalletFragmentStyle.BuyButtonText;
import com.google.android.gms.wallet.fragment.WalletFragmentStyle.Dimension;
import com.google.android.gms.wearable.ChannelApi.ChannelListener;
import com.google.android.gms.wearable.MessageApi;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.apache.http.protocol.HTTP;

public class zzawl implements Creator<zzawk> {
    static void zza(zzawk com_google_android_gms_internal_zzawk, Parcel parcel, int i) {
        int zzaV = zzc.zzaV(parcel);
        Set set = com_google_android_gms_internal_zzawk.zzbAl;
        if (set.contains(Integer.valueOf(1))) {
            zzc.zzc(parcel, 1, com_google_android_gms_internal_zzawk.mVersionCode);
        }
        if (set.contains(Integer.valueOf(2))) {
            zzc.zza(parcel, 2, com_google_android_gms_internal_zzawk.zzbAm, true);
        }
        if (set.contains(Integer.valueOf(3))) {
            zzc.zza(parcel, 3, com_google_android_gms_internal_zzawk.zzbAn, i, true);
        }
        if (set.contains(Integer.valueOf(4))) {
            zzc.zza(parcel, 4, com_google_android_gms_internal_zzawk.zzbAo, true);
        }
        if (set.contains(Integer.valueOf(5))) {
            zzc.zza(parcel, 5, com_google_android_gms_internal_zzawk.zzbAp, true);
        }
        if (set.contains(Integer.valueOf(6))) {
            zzc.zzc(parcel, 6, com_google_android_gms_internal_zzawk.zzbAq);
        }
        if (set.contains(Integer.valueOf(7))) {
            zzc.zza(parcel, 7, com_google_android_gms_internal_zzawk.zzbAr, i, true);
        }
        if (set.contains(Integer.valueOf(8))) {
            zzc.zza(parcel, 8, com_google_android_gms_internal_zzawk.zzbAs, true);
        }
        if (set.contains(Integer.valueOf(9))) {
            zzc.zza(parcel, 9, com_google_android_gms_internal_zzawk.zzaiX, true);
        }
        if (set.contains(Integer.valueOf(12))) {
            zzc.zzc(parcel, 12, com_google_android_gms_internal_zzawk.zzyW);
        }
        if (set.contains(Integer.valueOf(14))) {
            zzc.zza(parcel, 14, com_google_android_gms_internal_zzawk.zzGu, true);
        }
        if (set.contains(Integer.valueOf(15))) {
            zzc.zza(parcel, 15, com_google_android_gms_internal_zzawk.zzbAt, i, true);
        }
        if (set.contains(Integer.valueOf(16))) {
            zzc.zza(parcel, 16, com_google_android_gms_internal_zzawk.zzbAu);
        }
        if (set.contains(Integer.valueOf(18))) {
            zzc.zza(parcel, 18, com_google_android_gms_internal_zzawk.zzabW, true);
        }
        if (set.contains(Integer.valueOf(19))) {
            zzc.zza(parcel, 19, com_google_android_gms_internal_zzawk.zzbAv, i, true);
        }
        if (set.contains(Integer.valueOf(20))) {
            zzc.zza(parcel, 20, com_google_android_gms_internal_zzawk.zzbAw, true);
        }
        if (set.contains(Integer.valueOf(21))) {
            zzc.zzc(parcel, 21, com_google_android_gms_internal_zzawk.zzbAx);
        }
        if (set.contains(Integer.valueOf(22))) {
            zzc.zzc(parcel, 22, com_google_android_gms_internal_zzawk.zzbAy, true);
        }
        if (set.contains(Integer.valueOf(23))) {
            zzc.zzc(parcel, 23, com_google_android_gms_internal_zzawk.zzbAz, true);
        }
        if (set.contains(Integer.valueOf(24))) {
            zzc.zzc(parcel, 24, com_google_android_gms_internal_zzawk.zzbAA);
        }
        if (set.contains(Integer.valueOf(25))) {
            zzc.zzc(parcel, 25, com_google_android_gms_internal_zzawk.zzbAB);
        }
        if (set.contains(Integer.valueOf(26))) {
            zzc.zza(parcel, 26, com_google_android_gms_internal_zzawk.zzbAC, true);
        }
        if (set.contains(Integer.valueOf(27))) {
            zzc.zza(parcel, 27, com_google_android_gms_internal_zzawk.zzD, true);
        }
        if (set.contains(Integer.valueOf(28))) {
            zzc.zzc(parcel, 28, com_google_android_gms_internal_zzawk.zzbAD, true);
        }
        if (set.contains(Integer.valueOf(29))) {
            zzc.zza(parcel, 29, com_google_android_gms_internal_zzawk.zzbAE);
        }
        zzc.zzJ(parcel, zzaV);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zziy(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzmr(i);
    }

    public zzawk zziy(Parcel parcel) {
        int zzaU = zzb.zzaU(parcel);
        Set hashSet = new HashSet();
        int i = 0;
        String str = null;
        zza com_google_android_gms_internal_zzawk_zza = null;
        String str2 = null;
        String str3 = null;
        int i2 = 0;
        zzawk.zzb com_google_android_gms_internal_zzawk_zzb = null;
        String str4 = null;
        String str5 = null;
        int i3 = 0;
        String str6 = null;
        zzawk.zzc com_google_android_gms_internal_zzawk_zzc = null;
        boolean z = false;
        String str7 = null;
        zzd com_google_android_gms_internal_zzawk_zzd = null;
        String str8 = null;
        int i4 = 0;
        List list = null;
        List list2 = null;
        int i5 = 0;
        int i6 = 0;
        String str9 = null;
        String str10 = null;
        List list3 = null;
        boolean z2 = false;
        while (parcel.dataPosition() < zzaU) {
            int zzaT = zzb.zzaT(parcel);
            switch (zzb.zzcW(zzaT)) {
                case MessageApi.FILTER_PREFIX /*1*/:
                    i = zzb.zzg(parcel, zzaT);
                    hashSet.add(Integer.valueOf(1));
                    break;
                case ChannelListener.CLOSE_REASON_REMOTE_CLOSE /*2*/:
                    str = zzb.zzq(parcel, zzaT);
                    hashSet.add(Integer.valueOf(2));
                    break;
                case ChannelListener.CLOSE_REASON_LOCAL_CLOSE /*3*/:
                    zza com_google_android_gms_internal_zzawk_zza2 = (zza) zzb.zza(parcel, zzaT, zza.CREATOR);
                    hashSet.add(Integer.valueOf(3));
                    com_google_android_gms_internal_zzawk_zza = com_google_android_gms_internal_zzawk_zza2;
                    break;
                case Dimension.UNIT_IN /*4*/:
                    str2 = zzb.zzq(parcel, zzaT);
                    hashSet.add(Integer.valueOf(4));
                    break;
                case Dimension.UNIT_MM /*5*/:
                    str3 = zzb.zzq(parcel, zzaT);
                    hashSet.add(Integer.valueOf(5));
                    break;
                case BuyButtonText.LOGO_ONLY /*6*/:
                    i2 = zzb.zzg(parcel, zzaT);
                    hashSet.add(Integer.valueOf(6));
                    break;
                case BuyButtonText.DONATE_WITH /*7*/:
                    zzawk.zzb com_google_android_gms_internal_zzawk_zzb2 = (zzawk.zzb) zzb.zza(parcel, zzaT, zzawk.zzb.CREATOR);
                    hashSet.add(Integer.valueOf(7));
                    com_google_android_gms_internal_zzawk_zzb = com_google_android_gms_internal_zzawk_zzb2;
                    break;
                case Requests.MAX_REQUEST_RECIPIENTS /*8*/:
                    str4 = zzb.zzq(parcel, zzaT);
                    hashSet.add(Integer.valueOf(8));
                    break;
                case HTTP.HT /*9*/:
                    str5 = zzb.zzq(parcel, zzaT);
                    hashSet.add(Integer.valueOf(9));
                    break;
                case C0473R.styleable.MapAttrs_uiZoomGestures /*12*/:
                    i3 = zzb.zzg(parcel, zzaT);
                    hashSet.add(Integer.valueOf(12));
                    break;
                case GamesStatusCodes.STATUS_INTERRUPTED /*14*/:
                    str6 = zzb.zzq(parcel, zzaT);
                    hashSet.add(Integer.valueOf(14));
                    break;
                case GamesStatusCodes.STATUS_TIMEOUT /*15*/:
                    zzawk.zzc com_google_android_gms_internal_zzawk_zzc2 = (zzawk.zzc) zzb.zza(parcel, zzaT, zzawk.zzc.CREATOR);
                    hashSet.add(Integer.valueOf(15));
                    com_google_android_gms_internal_zzawk_zzc = com_google_android_gms_internal_zzawk_zzc2;
                    break;
                case Notifications.NOTIFICATION_TYPE_LEVEL_UP /*16*/:
                    z = zzb.zzc(parcel, zzaT);
                    hashSet.add(Integer.valueOf(16));
                    break;
                case ConnectionResult.SERVICE_UPDATING /*18*/:
                    str7 = zzb.zzq(parcel, zzaT);
                    hashSet.add(Integer.valueOf(18));
                    break;
                case ConnectionResult.SERVICE_MISSING_PERMISSION /*19*/:
                    zzd com_google_android_gms_internal_zzawk_zzd2 = (zzd) zzb.zza(parcel, zzaT, zzd.CREATOR);
                    hashSet.add(Integer.valueOf(19));
                    com_google_android_gms_internal_zzawk_zzd = com_google_android_gms_internal_zzawk_zzd2;
                    break;
                case ConnectionResult.RESTRICTED_PROFILE /*20*/:
                    str8 = zzb.zzq(parcel, zzaT);
                    hashSet.add(Integer.valueOf(20));
                    break;
                case C0473R.styleable.MapAttrs_latLngBoundsNorthEastLatitude /*21*/:
                    i4 = zzb.zzg(parcel, zzaT);
                    hashSet.add(Integer.valueOf(21));
                    break;
                case C0473R.styleable.MapAttrs_latLngBoundsNorthEastLongitude /*22*/:
                    list = zzb.zzc(parcel, zzaT, zzf.CREATOR);
                    hashSet.add(Integer.valueOf(22));
                    break;
                case C0308R.styleable.Toolbar_collapseContentDescription /*23*/:
                    list2 = zzb.zzc(parcel, zzaT, zzg.CREATOR);
                    hashSet.add(Integer.valueOf(23));
                    break;
                case C0308R.styleable.Toolbar_navigationIcon /*24*/:
                    i5 = zzb.zzg(parcel, zzaT);
                    hashSet.add(Integer.valueOf(24));
                    break;
                case C0308R.styleable.Toolbar_navigationContentDescription /*25*/:
                    i6 = zzb.zzg(parcel, zzaT);
                    hashSet.add(Integer.valueOf(25));
                    break;
                case C0308R.styleable.Toolbar_logoDescription /*26*/:
                    str9 = zzb.zzq(parcel, zzaT);
                    hashSet.add(Integer.valueOf(26));
                    break;
                case C0308R.styleable.Toolbar_titleTextColor /*27*/:
                    str10 = zzb.zzq(parcel, zzaT);
                    hashSet.add(Integer.valueOf(27));
                    break;
                case C0308R.styleable.Toolbar_subtitleTextColor /*28*/:
                    list3 = zzb.zzc(parcel, zzaT, zzh.CREATOR);
                    hashSet.add(Integer.valueOf(28));
                    break;
                case C0308R.styleable.AppCompatTheme_actionModeBackground /*29*/:
                    z2 = zzb.zzc(parcel, zzaT);
                    hashSet.add(Integer.valueOf(29));
                    break;
                default:
                    zzb.zzb(parcel, zzaT);
                    break;
            }
        }
        if (parcel.dataPosition() == zzaU) {
            return new zzawk(hashSet, i, str, com_google_android_gms_internal_zzawk_zza, str2, str3, i2, com_google_android_gms_internal_zzawk_zzb, str4, str5, i3, str6, com_google_android_gms_internal_zzawk_zzc, z, str7, com_google_android_gms_internal_zzawk_zzd, str8, i4, list, list2, i5, i6, str9, str10, list3, z2);
        }
        throw new zzb.zza("Overread allowed size end=" + zzaU, parcel);
    }

    public zzawk[] zzmr(int i) {
        return new zzawk[i];
    }
}
