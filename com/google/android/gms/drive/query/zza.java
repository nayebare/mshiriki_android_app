package com.google.android.gms.drive.query;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.common.internal.safeparcel.zzc;
import com.google.android.gms.drive.DriveSpace;
import com.google.android.gms.drive.query.internal.zzr;
import com.google.android.gms.games.request.Requests;
import com.google.android.gms.wallet.WalletConstants.CardNetwork;
import com.google.android.gms.wallet.fragment.WalletFragmentStyle.BuyButtonText;
import com.google.android.gms.wallet.fragment.WalletFragmentStyle.Dimension;
import com.google.android.gms.wearable.ChannelApi.ChannelListener;
import com.google.android.gms.wearable.MessageApi;
import java.util.List;

public class zza implements Creator<Query> {
    static void zza(Query query, Parcel parcel, int i) {
        int zzaV = zzc.zzaV(parcel);
        zzc.zza(parcel, 1, query.zzaOB, i, false);
        zzc.zza(parcel, 3, query.zzaOC, false);
        zzc.zza(parcel, 4, query.zzaOD, i, false);
        zzc.zzb(parcel, 5, query.zzaOE, false);
        zzc.zza(parcel, 6, query.zzaOF);
        zzc.zzc(parcel, 7, query.zzaKk, false);
        zzc.zza(parcel, 8, query.zzaMr);
        zzc.zzc(parcel, CardNetwork.OTHER, query.mVersionCode);
        zzc.zzJ(parcel, zzaV);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzdj(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzfF(i);
    }

    public Query zzdj(Parcel parcel) {
        boolean z = false;
        List list = null;
        int zzaU = zzb.zzaU(parcel);
        boolean z2 = false;
        List list2 = null;
        SortOrder sortOrder = null;
        String str = null;
        zzr com_google_android_gms_drive_query_internal_zzr = null;
        int i = 0;
        while (parcel.dataPosition() < zzaU) {
            int zzaT = zzb.zzaT(parcel);
            switch (zzb.zzcW(zzaT)) {
                case MessageApi.FILTER_PREFIX /*1*/:
                    com_google_android_gms_drive_query_internal_zzr = (zzr) zzb.zza(parcel, zzaT, zzr.CREATOR);
                    break;
                case ChannelListener.CLOSE_REASON_LOCAL_CLOSE /*3*/:
                    str = zzb.zzq(parcel, zzaT);
                    break;
                case Dimension.UNIT_IN /*4*/:
                    sortOrder = (SortOrder) zzb.zza(parcel, zzaT, SortOrder.CREATOR);
                    break;
                case Dimension.UNIT_MM /*5*/:
                    list2 = zzb.zzE(parcel, zzaT);
                    break;
                case BuyButtonText.LOGO_ONLY /*6*/:
                    z2 = zzb.zzc(parcel, zzaT);
                    break;
                case BuyButtonText.DONATE_WITH /*7*/:
                    list = zzb.zzc(parcel, zzaT, DriveSpace.CREATOR);
                    break;
                case Requests.MAX_REQUEST_RECIPIENTS /*8*/:
                    z = zzb.zzc(parcel, zzaT);
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
            return new Query(i, com_google_android_gms_drive_query_internal_zzr, str, sortOrder, list2, z2, list, z);
        }
        throw new com.google.android.gms.common.internal.safeparcel.zzb.zza("Overread allowed size end=" + zzaU, parcel);
    }

    public Query[] zzfF(int i) {
        return new Query[i];
    }
}
