package com.google.android.gms.games.appcontent;

import android.net.Uri;
import android.os.Bundle;
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

public class AppContentAnnotationEntityCreator implements Creator<AppContentAnnotationEntity> {
    static void zza(AppContentAnnotationEntity appContentAnnotationEntity, Parcel parcel, int i) {
        int zzaV = zzc.zzaV(parcel);
        zzc.zza(parcel, 1, appContentAnnotationEntity.getDescription(), false);
        zzc.zza(parcel, 2, appContentAnnotationEntity.zzDA(), i, false);
        zzc.zza(parcel, 3, appContentAnnotationEntity.getTitle(), false);
        zzc.zza(parcel, 5, appContentAnnotationEntity.getId(), false);
        zzc.zza(parcel, 6, appContentAnnotationEntity.zzDD(), false);
        zzc.zza(parcel, 7, appContentAnnotationEntity.zzDy(), false);
        zzc.zzc(parcel, CardNetwork.OTHER, appContentAnnotationEntity.getVersionCode());
        zzc.zzc(parcel, 8, appContentAnnotationEntity.zzDz());
        zzc.zzc(parcel, 9, appContentAnnotationEntity.zzDC());
        zzc.zza(parcel, 10, appContentAnnotationEntity.zzDB(), false);
        zzc.zzJ(parcel, zzaV);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzfx(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzih(i);
    }

    public AppContentAnnotationEntity zzfx(Parcel parcel) {
        int i = 0;
        Bundle bundle = null;
        int zzaU = zzb.zzaU(parcel);
        int i2 = 0;
        String str = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        Uri uri = null;
        String str5 = null;
        int i3 = 0;
        while (parcel.dataPosition() < zzaU) {
            int zzaT = zzb.zzaT(parcel);
            switch (zzb.zzcW(zzaT)) {
                case MessageApi.FILTER_PREFIX /*1*/:
                    str5 = zzb.zzq(parcel, zzaT);
                    break;
                case ChannelListener.CLOSE_REASON_REMOTE_CLOSE /*2*/:
                    uri = (Uri) zzb.zza(parcel, zzaT, Uri.CREATOR);
                    break;
                case ChannelListener.CLOSE_REASON_LOCAL_CLOSE /*3*/:
                    str4 = zzb.zzq(parcel, zzaT);
                    break;
                case Dimension.UNIT_MM /*5*/:
                    str3 = zzb.zzq(parcel, zzaT);
                    break;
                case BuyButtonText.LOGO_ONLY /*6*/:
                    str2 = zzb.zzq(parcel, zzaT);
                    break;
                case BuyButtonText.DONATE_WITH /*7*/:
                    str = zzb.zzq(parcel, zzaT);
                    break;
                case Requests.MAX_REQUEST_RECIPIENTS /*8*/:
                    i2 = zzb.zzg(parcel, zzaT);
                    break;
                case HTTP.HT /*9*/:
                    i = zzb.zzg(parcel, zzaT);
                    break;
                case HTTP.LF /*10*/:
                    bundle = zzb.zzs(parcel, zzaT);
                    break;
                case CardNetwork.OTHER /*1000*/:
                    i3 = zzb.zzg(parcel, zzaT);
                    break;
                default:
                    zzb.zzb(parcel, zzaT);
                    break;
            }
        }
        if (parcel.dataPosition() == zzaU) {
            return new AppContentAnnotationEntity(i3, str5, uri, str4, str3, str2, str, i2, i, bundle);
        }
        throw new zza("Overread allowed size end=" + zzaU, parcel);
    }

    public AppContentAnnotationEntity[] zzih(int i) {
        return new AppContentAnnotationEntity[i];
    }
}
