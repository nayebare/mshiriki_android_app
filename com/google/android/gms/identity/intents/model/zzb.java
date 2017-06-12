package com.google.android.gms.identity.intents.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.C0473R;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.safeparcel.zzb.zza;
import com.google.android.gms.common.internal.safeparcel.zzc;
import com.google.android.gms.games.GamesStatusCodes;
import com.google.android.gms.games.Notifications;
import com.google.android.gms.games.request.Requests;
import com.google.android.gms.wallet.fragment.WalletFragmentStyle.BuyButtonText;
import com.google.android.gms.wallet.fragment.WalletFragmentStyle.Dimension;
import com.google.android.gms.wearable.ChannelApi.ChannelListener;
import com.google.android.gms.wearable.MessageApi;
import org.apache.http.protocol.HTTP;

public class zzb implements Creator<UserAddress> {
    static void zza(UserAddress userAddress, Parcel parcel, int i) {
        int zzaV = zzc.zzaV(parcel);
        zzc.zzc(parcel, 1, userAddress.getVersionCode());
        zzc.zza(parcel, 2, userAddress.name, false);
        zzc.zza(parcel, 3, userAddress.zzbgO, false);
        zzc.zza(parcel, 4, userAddress.zzbgP, false);
        zzc.zza(parcel, 5, userAddress.zzbgQ, false);
        zzc.zza(parcel, 6, userAddress.zzbgR, false);
        zzc.zza(parcel, 7, userAddress.zzbgS, false);
        zzc.zza(parcel, 8, userAddress.zzbgT, false);
        zzc.zza(parcel, 9, userAddress.zzbgU, false);
        zzc.zza(parcel, 10, userAddress.zzUe, false);
        zzc.zza(parcel, 11, userAddress.zzbgV, false);
        zzc.zza(parcel, 12, userAddress.zzbgW, false);
        zzc.zza(parcel, 13, userAddress.phoneNumber, false);
        zzc.zza(parcel, 14, userAddress.zzbgX);
        zzc.zza(parcel, 15, userAddress.zzbgY, false);
        zzc.zza(parcel, 16, userAddress.zzbgZ, false);
        zzc.zzJ(parcel, zzaV);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzgm(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzjz(i);
    }

    public UserAddress zzgm(Parcel parcel) {
        int zzaU = com.google.android.gms.common.internal.safeparcel.zzb.zzaU(parcel);
        int i = 0;
        String str = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        String str6 = null;
        String str7 = null;
        String str8 = null;
        String str9 = null;
        String str10 = null;
        String str11 = null;
        String str12 = null;
        boolean z = false;
        String str13 = null;
        String str14 = null;
        while (parcel.dataPosition() < zzaU) {
            int zzaT = com.google.android.gms.common.internal.safeparcel.zzb.zzaT(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.zzb.zzcW(zzaT)) {
                case MessageApi.FILTER_PREFIX /*1*/:
                    i = com.google.android.gms.common.internal.safeparcel.zzb.zzg(parcel, zzaT);
                    break;
                case ChannelListener.CLOSE_REASON_REMOTE_CLOSE /*2*/:
                    str = com.google.android.gms.common.internal.safeparcel.zzb.zzq(parcel, zzaT);
                    break;
                case ChannelListener.CLOSE_REASON_LOCAL_CLOSE /*3*/:
                    str2 = com.google.android.gms.common.internal.safeparcel.zzb.zzq(parcel, zzaT);
                    break;
                case Dimension.UNIT_IN /*4*/:
                    str3 = com.google.android.gms.common.internal.safeparcel.zzb.zzq(parcel, zzaT);
                    break;
                case Dimension.UNIT_MM /*5*/:
                    str4 = com.google.android.gms.common.internal.safeparcel.zzb.zzq(parcel, zzaT);
                    break;
                case BuyButtonText.LOGO_ONLY /*6*/:
                    str5 = com.google.android.gms.common.internal.safeparcel.zzb.zzq(parcel, zzaT);
                    break;
                case BuyButtonText.DONATE_WITH /*7*/:
                    str6 = com.google.android.gms.common.internal.safeparcel.zzb.zzq(parcel, zzaT);
                    break;
                case Requests.MAX_REQUEST_RECIPIENTS /*8*/:
                    str7 = com.google.android.gms.common.internal.safeparcel.zzb.zzq(parcel, zzaT);
                    break;
                case HTTP.HT /*9*/:
                    str8 = com.google.android.gms.common.internal.safeparcel.zzb.zzq(parcel, zzaT);
                    break;
                case HTTP.LF /*10*/:
                    str9 = com.google.android.gms.common.internal.safeparcel.zzb.zzq(parcel, zzaT);
                    break;
                case ConnectionResult.LICENSE_CHECK_FAILED /*11*/:
                    str10 = com.google.android.gms.common.internal.safeparcel.zzb.zzq(parcel, zzaT);
                    break;
                case C0473R.styleable.MapAttrs_uiZoomGestures /*12*/:
                    str11 = com.google.android.gms.common.internal.safeparcel.zzb.zzq(parcel, zzaT);
                    break;
                case HTTP.CR /*13*/:
                    str12 = com.google.android.gms.common.internal.safeparcel.zzb.zzq(parcel, zzaT);
                    break;
                case GamesStatusCodes.STATUS_INTERRUPTED /*14*/:
                    z = com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, zzaT);
                    break;
                case GamesStatusCodes.STATUS_TIMEOUT /*15*/:
                    str13 = com.google.android.gms.common.internal.safeparcel.zzb.zzq(parcel, zzaT);
                    break;
                case Notifications.NOTIFICATION_TYPE_LEVEL_UP /*16*/:
                    str14 = com.google.android.gms.common.internal.safeparcel.zzb.zzq(parcel, zzaT);
                    break;
                default:
                    com.google.android.gms.common.internal.safeparcel.zzb.zzb(parcel, zzaT);
                    break;
            }
        }
        if (parcel.dataPosition() == zzaU) {
            return new UserAddress(i, str, str2, str3, str4, str5, str6, str7, str8, str9, str10, str11, str12, z, str13, str14);
        }
        throw new zza("Overread allowed size end=" + zzaU, parcel);
    }

    public UserAddress[] zzjz(int i) {
        return new UserAddress[i];
    }
}
