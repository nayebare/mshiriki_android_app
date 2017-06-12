package com.google.android.gms.games.appcontent;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.common.internal.safeparcel.zzb.zza;
import com.google.android.gms.common.internal.safeparcel.zzc;
import com.google.android.gms.games.GamesStatusCodes;
import com.google.android.gms.games.request.Requests;
import com.google.android.gms.wallet.WalletConstants.CardNetwork;
import com.google.android.gms.wallet.fragment.WalletFragmentStyle.BuyButtonText;
import com.google.android.gms.wallet.fragment.WalletFragmentStyle.Dimension;
import com.google.android.gms.wearable.ChannelApi.ChannelListener;
import com.google.android.gms.wearable.MessageApi;
import java.util.ArrayList;
import org.apache.http.protocol.HTTP;

public class AppContentSectionEntityCreator implements Creator<AppContentSectionEntity> {
    static void zza(AppContentSectionEntity appContentSectionEntity, Parcel parcel, int i) {
        int zzaV = zzc.zzaV(parcel);
        zzc.zzc(parcel, 1, appContentSectionEntity.getActions(), false);
        zzc.zzc(parcel, 3, appContentSectionEntity.zzDP(), false);
        zzc.zza(parcel, 4, appContentSectionEntity.zzDv(), false);
        zzc.zza(parcel, 5, appContentSectionEntity.getExtras(), false);
        zzc.zza(parcel, 6, appContentSectionEntity.zzDH(), false);
        zzc.zza(parcel, 7, appContentSectionEntity.getTitle(), false);
        zzc.zzc(parcel, CardNetwork.OTHER, appContentSectionEntity.getVersionCode());
        zzc.zza(parcel, 8, appContentSectionEntity.getType(), false);
        zzc.zza(parcel, 9, appContentSectionEntity.getId(), false);
        zzc.zza(parcel, 10, appContentSectionEntity.zzDQ(), false);
        zzc.zzc(parcel, 14, appContentSectionEntity.zzDF(), false);
        zzc.zzJ(parcel, zzaV);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzfA(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzik(i);
    }

    public AppContentSectionEntity zzfA(Parcel parcel) {
        ArrayList arrayList = null;
        int zzaU = zzb.zzaU(parcel);
        int i = 0;
        String str = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        Bundle bundle = null;
        String str6 = null;
        ArrayList arrayList2 = null;
        ArrayList arrayList3 = null;
        while (parcel.dataPosition() < zzaU) {
            int zzaT = zzb.zzaT(parcel);
            switch (zzb.zzcW(zzaT)) {
                case MessageApi.FILTER_PREFIX /*1*/:
                    arrayList3 = zzb.zzc(parcel, zzaT, AppContentActionEntity.CREATOR);
                    break;
                case ChannelListener.CLOSE_REASON_LOCAL_CLOSE /*3*/:
                    arrayList2 = zzb.zzc(parcel, zzaT, AppContentCardEntity.CREATOR);
                    break;
                case Dimension.UNIT_IN /*4*/:
                    str6 = zzb.zzq(parcel, zzaT);
                    break;
                case Dimension.UNIT_MM /*5*/:
                    bundle = zzb.zzs(parcel, zzaT);
                    break;
                case BuyButtonText.LOGO_ONLY /*6*/:
                    str5 = zzb.zzq(parcel, zzaT);
                    break;
                case BuyButtonText.DONATE_WITH /*7*/:
                    str4 = zzb.zzq(parcel, zzaT);
                    break;
                case Requests.MAX_REQUEST_RECIPIENTS /*8*/:
                    str3 = zzb.zzq(parcel, zzaT);
                    break;
                case HTTP.HT /*9*/:
                    str2 = zzb.zzq(parcel, zzaT);
                    break;
                case HTTP.LF /*10*/:
                    str = zzb.zzq(parcel, zzaT);
                    break;
                case GamesStatusCodes.STATUS_INTERRUPTED /*14*/:
                    arrayList = zzb.zzc(parcel, zzaT, AppContentAnnotationEntity.CREATOR);
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
            return new AppContentSectionEntity(i, arrayList3, arrayList2, str6, bundle, str5, str4, str3, str2, str, arrayList);
        }
        throw new zza("Overread allowed size end=" + zzaU, parcel);
    }

    public AppContentSectionEntity[] zzik(int i) {
        return new AppContentSectionEntity[i];
    }
}
