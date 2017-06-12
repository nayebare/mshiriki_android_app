package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.common.internal.safeparcel.zzb.zza;
import com.google.android.gms.common.internal.safeparcel.zzc;
import com.google.android.gms.games.request.Requests;
import com.google.android.gms.wallet.WalletConstants.CardNetwork;
import com.google.android.gms.wallet.fragment.WalletFragmentStyle.BuyButtonText;
import com.google.android.gms.wallet.fragment.WalletFragmentStyle.Dimension;
import com.google.android.gms.wearable.ChannelApi.ChannelListener;
import com.google.android.gms.wearable.MessageApi;
import org.apache.http.protocol.HTTP;

public class zzh implements Creator<FilterHolder> {
    static void zza(FilterHolder filterHolder, Parcel parcel, int i) {
        int zzaV = zzc.zzaV(parcel);
        zzc.zza(parcel, 1, filterHolder.zzaOQ, i, false);
        zzc.zza(parcel, 2, filterHolder.zzaOR, i, false);
        zzc.zza(parcel, 3, filterHolder.zzaOS, i, false);
        zzc.zza(parcel, 4, filterHolder.zzaOT, i, false);
        zzc.zza(parcel, 5, filterHolder.zzaOU, i, false);
        zzc.zza(parcel, 6, filterHolder.zzaOV, i, false);
        zzc.zza(parcel, 7, filterHolder.zzaOW, i, false);
        zzc.zzc(parcel, CardNetwork.OTHER, filterHolder.mVersionCode);
        zzc.zza(parcel, 8, filterHolder.zzaOX, i, false);
        zzc.zza(parcel, 9, filterHolder.zzaOY, i, false);
        zzc.zzJ(parcel, zzaV);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzdo(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzfK(i);
    }

    public FilterHolder zzdo(Parcel parcel) {
        zzz com_google_android_gms_drive_query_internal_zzz = null;
        int zzaU = zzb.zzaU(parcel);
        int i = 0;
        zzl com_google_android_gms_drive_query_internal_zzl = null;
        zzn com_google_android_gms_drive_query_internal_zzn = null;
        zzt com_google_android_gms_drive_query_internal_zzt = null;
        zzp com_google_android_gms_drive_query_internal_zzp = null;
        zzv com_google_android_gms_drive_query_internal_zzv = null;
        zzr com_google_android_gms_drive_query_internal_zzr = null;
        zzd com_google_android_gms_drive_query_internal_zzd = null;
        zzb com_google_android_gms_drive_query_internal_zzb = null;
        while (parcel.dataPosition() < zzaU) {
            int zzaT = zzb.zzaT(parcel);
            switch (zzb.zzcW(zzaT)) {
                case MessageApi.FILTER_PREFIX /*1*/:
                    com_google_android_gms_drive_query_internal_zzb = (zzb) zzb.zza(parcel, zzaT, zzb.CREATOR);
                    break;
                case ChannelListener.CLOSE_REASON_REMOTE_CLOSE /*2*/:
                    com_google_android_gms_drive_query_internal_zzd = (zzd) zzb.zza(parcel, zzaT, zzd.CREATOR);
                    break;
                case ChannelListener.CLOSE_REASON_LOCAL_CLOSE /*3*/:
                    com_google_android_gms_drive_query_internal_zzr = (zzr) zzb.zza(parcel, zzaT, zzr.CREATOR);
                    break;
                case Dimension.UNIT_IN /*4*/:
                    com_google_android_gms_drive_query_internal_zzv = (zzv) zzb.zza(parcel, zzaT, zzv.CREATOR);
                    break;
                case Dimension.UNIT_MM /*5*/:
                    com_google_android_gms_drive_query_internal_zzp = (zzp) zzb.zza(parcel, zzaT, zzp.CREATOR);
                    break;
                case BuyButtonText.LOGO_ONLY /*6*/:
                    com_google_android_gms_drive_query_internal_zzt = (zzt) zzb.zza(parcel, zzaT, zzt.CREATOR);
                    break;
                case BuyButtonText.DONATE_WITH /*7*/:
                    com_google_android_gms_drive_query_internal_zzn = (zzn) zzb.zza(parcel, zzaT, zzn.CREATOR);
                    break;
                case Requests.MAX_REQUEST_RECIPIENTS /*8*/:
                    com_google_android_gms_drive_query_internal_zzl = (zzl) zzb.zza(parcel, zzaT, zzl.CREATOR);
                    break;
                case HTTP.HT /*9*/:
                    com_google_android_gms_drive_query_internal_zzz = (zzz) zzb.zza(parcel, zzaT, zzz.CREATOR);
                    break;
                case CardNetwork.OTHER /*1000*/:
                    i = zzb.zzg(parcel, zzaT);
                    break;
                default:
                    zzb.zzb(parcel, zzaT);
                    break;
            }
        }
        if (parcel.dataPosition() == zzaU) {
            return new FilterHolder(i, com_google_android_gms_drive_query_internal_zzb, com_google_android_gms_drive_query_internal_zzd, com_google_android_gms_drive_query_internal_zzr, com_google_android_gms_drive_query_internal_zzv, com_google_android_gms_drive_query_internal_zzp, com_google_android_gms_drive_query_internal_zzt, com_google_android_gms_drive_query_internal_zzn, com_google_android_gms_drive_query_internal_zzl, com_google_android_gms_drive_query_internal_zzz);
        }
        throw new zza("Overread allowed size end=" + zzaU, parcel);
    }

    public FilterHolder[] zzfK(int i) {
        return new FilterHolder[i];
    }
}
