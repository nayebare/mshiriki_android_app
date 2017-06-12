package com.google.android.gms.games.appcontent;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.C0473R;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.common.internal.safeparcel.zzb.zza;
import com.google.android.gms.common.internal.safeparcel.zzc;
import com.google.android.gms.games.GamesStatusCodes;
import com.google.android.gms.wallet.WalletConstants.CardNetwork;
import com.google.android.gms.wallet.fragment.WalletFragmentStyle.BuyButtonText;
import com.google.android.gms.wallet.fragment.WalletFragmentStyle.Dimension;
import com.google.android.gms.wearable.ChannelApi.ChannelListener;
import com.google.android.gms.wearable.MessageApi;
import java.util.ArrayList;
import org.apache.http.protocol.HTTP;

public class AppContentCardEntityCreator implements Creator<AppContentCardEntity> {
    static void zza(AppContentCardEntity appContentCardEntity, Parcel parcel, int i) {
        int zzaV = zzc.zzaV(parcel);
        zzc.zzc(parcel, 1, appContentCardEntity.getActions(), false);
        zzc.zzc(parcel, 2, appContentCardEntity.zzDF(), false);
        zzc.zzc(parcel, 3, appContentCardEntity.zzDu(), false);
        zzc.zza(parcel, 4, appContentCardEntity.zzDv(), false);
        zzc.zzc(parcel, 5, appContentCardEntity.zzDG());
        zzc.zza(parcel, 6, appContentCardEntity.getDescription(), false);
        zzc.zza(parcel, 7, appContentCardEntity.getExtras(), false);
        zzc.zzc(parcel, CardNetwork.OTHER, appContentCardEntity.getVersionCode());
        zzc.zza(parcel, 10, appContentCardEntity.zzDH(), false);
        zzc.zza(parcel, 11, appContentCardEntity.getTitle(), false);
        zzc.zzc(parcel, 12, appContentCardEntity.zzDI());
        zzc.zza(parcel, 13, appContentCardEntity.getType(), false);
        zzc.zza(parcel, 14, appContentCardEntity.getId(), false);
        zzc.zzJ(parcel, zzaV);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzfy(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzii(i);
    }

    public AppContentCardEntity zzfy(Parcel parcel) {
        int zzaU = zzb.zzaU(parcel);
        int i = 0;
        ArrayList arrayList = null;
        ArrayList arrayList2 = null;
        ArrayList arrayList3 = null;
        String str = null;
        int i2 = 0;
        String str2 = null;
        Bundle bundle = null;
        String str3 = null;
        String str4 = null;
        int i3 = 0;
        String str5 = null;
        String str6 = null;
        while (parcel.dataPosition() < zzaU) {
            int zzaT = zzb.zzaT(parcel);
            switch (zzb.zzcW(zzaT)) {
                case MessageApi.FILTER_PREFIX /*1*/:
                    arrayList = zzb.zzc(parcel, zzaT, AppContentActionEntity.CREATOR);
                    break;
                case ChannelListener.CLOSE_REASON_REMOTE_CLOSE /*2*/:
                    arrayList2 = zzb.zzc(parcel, zzaT, AppContentAnnotationEntity.CREATOR);
                    break;
                case ChannelListener.CLOSE_REASON_LOCAL_CLOSE /*3*/:
                    arrayList3 = zzb.zzc(parcel, zzaT, AppContentConditionEntity.CREATOR);
                    break;
                case Dimension.UNIT_IN /*4*/:
                    str = zzb.zzq(parcel, zzaT);
                    break;
                case Dimension.UNIT_MM /*5*/:
                    i2 = zzb.zzg(parcel, zzaT);
                    break;
                case BuyButtonText.LOGO_ONLY /*6*/:
                    str2 = zzb.zzq(parcel, zzaT);
                    break;
                case BuyButtonText.DONATE_WITH /*7*/:
                    bundle = zzb.zzs(parcel, zzaT);
                    break;
                case HTTP.LF /*10*/:
                    str3 = zzb.zzq(parcel, zzaT);
                    break;
                case ConnectionResult.LICENSE_CHECK_FAILED /*11*/:
                    str4 = zzb.zzq(parcel, zzaT);
                    break;
                case C0473R.styleable.MapAttrs_uiZoomGestures /*12*/:
                    i3 = zzb.zzg(parcel, zzaT);
                    break;
                case HTTP.CR /*13*/:
                    str5 = zzb.zzq(parcel, zzaT);
                    break;
                case GamesStatusCodes.STATUS_INTERRUPTED /*14*/:
                    str6 = zzb.zzq(parcel, zzaT);
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
            return new AppContentCardEntity(i, arrayList, arrayList2, arrayList3, str, i2, str2, bundle, str3, str4, i3, str5, str6);
        }
        throw new zza("Overread allowed size end=" + zzaU, parcel);
    }

    public AppContentCardEntity[] zzii(int i) {
        return new AppContentCardEntity[i];
    }
}
