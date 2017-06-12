package com.google.android.gms.games.appcontent;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.common.internal.safeparcel.zzb.zza;
import com.google.android.gms.common.internal.safeparcel.zzc;
import com.google.android.gms.games.request.Requests;
import com.google.android.gms.wallet.WalletConstants.CardNetwork;
import com.google.android.gms.wallet.fragment.WalletFragmentStyle.BuyButtonText;
import com.google.android.gms.wearable.ChannelApi.ChannelListener;
import com.google.android.gms.wearable.MessageApi;
import java.util.ArrayList;
import org.apache.http.protocol.HTTP;

public class AppContentActionEntityCreator implements Creator<AppContentActionEntity> {
    static void zza(AppContentActionEntity appContentActionEntity, Parcel parcel, int i) {
        int zzaV = zzc.zzaV(parcel);
        zzc.zzc(parcel, 1, appContentActionEntity.zzDu(), false);
        zzc.zza(parcel, 2, appContentActionEntity.zzDv(), false);
        zzc.zza(parcel, 3, appContentActionEntity.getExtras(), false);
        zzc.zza(parcel, 6, appContentActionEntity.getType(), false);
        zzc.zza(parcel, 7, appContentActionEntity.getId(), false);
        zzc.zzc(parcel, CardNetwork.OTHER, appContentActionEntity.getVersionCode());
        zzc.zza(parcel, 8, appContentActionEntity.zzDt(), i, false);
        zzc.zza(parcel, 9, appContentActionEntity.zzDw(), false);
        zzc.zzJ(parcel, zzaV);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzfw(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzig(i);
    }

    public AppContentActionEntity zzfw(Parcel parcel) {
        String str = null;
        int zzaU = zzb.zzaU(parcel);
        int i = 0;
        AppContentAnnotationEntity appContentAnnotationEntity = null;
        String str2 = null;
        String str3 = null;
        Bundle bundle = null;
        String str4 = null;
        ArrayList arrayList = null;
        while (parcel.dataPosition() < zzaU) {
            int zzaT = zzb.zzaT(parcel);
            switch (zzb.zzcW(zzaT)) {
                case MessageApi.FILTER_PREFIX /*1*/:
                    arrayList = zzb.zzc(parcel, zzaT, AppContentConditionEntity.CREATOR);
                    break;
                case ChannelListener.CLOSE_REASON_REMOTE_CLOSE /*2*/:
                    str4 = zzb.zzq(parcel, zzaT);
                    break;
                case ChannelListener.CLOSE_REASON_LOCAL_CLOSE /*3*/:
                    bundle = zzb.zzs(parcel, zzaT);
                    break;
                case BuyButtonText.LOGO_ONLY /*6*/:
                    str3 = zzb.zzq(parcel, zzaT);
                    break;
                case BuyButtonText.DONATE_WITH /*7*/:
                    str2 = zzb.zzq(parcel, zzaT);
                    break;
                case Requests.MAX_REQUEST_RECIPIENTS /*8*/:
                    appContentAnnotationEntity = (AppContentAnnotationEntity) zzb.zza(parcel, zzaT, AppContentAnnotationEntity.CREATOR);
                    break;
                case HTTP.HT /*9*/:
                    str = zzb.zzq(parcel, zzaT);
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
            return new AppContentActionEntity(i, arrayList, str4, bundle, str3, str2, appContentAnnotationEntity, str);
        }
        throw new zza("Overread allowed size end=" + zzaU, parcel);
    }

    public AppContentActionEntity[] zzig(int i) {
        return new AppContentActionEntity[i];
    }
}
