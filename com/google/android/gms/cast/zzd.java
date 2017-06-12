package com.google.android.gms.cast;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.images.WebImage;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.common.internal.safeparcel.zzb.zza;
import com.google.android.gms.common.internal.safeparcel.zzc;
import com.google.android.gms.wallet.fragment.WalletFragmentStyle.BuyButtonText;
import com.google.android.gms.wallet.fragment.WalletFragmentStyle.Dimension;
import com.google.android.gms.wearable.ChannelApi.ChannelListener;
import com.google.android.gms.wearable.MessageApi;
import java.util.List;

public class zzd implements Creator<ApplicationMetadata> {
    static void zza(ApplicationMetadata applicationMetadata, Parcel parcel, int i) {
        int zzaV = zzc.zzaV(parcel);
        zzc.zzc(parcel, 1, applicationMetadata.getVersionCode());
        zzc.zza(parcel, 2, applicationMetadata.getApplicationId(), false);
        zzc.zza(parcel, 3, applicationMetadata.getName(), false);
        zzc.zzc(parcel, 4, applicationMetadata.getImages(), false);
        zzc.zzb(parcel, 5, applicationMetadata.getSupportedNamespaces(), false);
        zzc.zza(parcel, 6, applicationMetadata.getSenderAppIdentifier(), false);
        zzc.zza(parcel, 7, applicationMetadata.zzrI(), i, false);
        zzc.zzJ(parcel, zzaV);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzao(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzbG(i);
    }

    public ApplicationMetadata zzao(Parcel parcel) {
        Uri uri = null;
        int zzaU = zzb.zzaU(parcel);
        int i = 0;
        String str = null;
        List list = null;
        List list2 = null;
        String str2 = null;
        String str3 = null;
        while (parcel.dataPosition() < zzaU) {
            int zzaT = zzb.zzaT(parcel);
            switch (zzb.zzcW(zzaT)) {
                case MessageApi.FILTER_PREFIX /*1*/:
                    i = zzb.zzg(parcel, zzaT);
                    break;
                case ChannelListener.CLOSE_REASON_REMOTE_CLOSE /*2*/:
                    str3 = zzb.zzq(parcel, zzaT);
                    break;
                case ChannelListener.CLOSE_REASON_LOCAL_CLOSE /*3*/:
                    str2 = zzb.zzq(parcel, zzaT);
                    break;
                case Dimension.UNIT_IN /*4*/:
                    list2 = zzb.zzc(parcel, zzaT, WebImage.CREATOR);
                    break;
                case Dimension.UNIT_MM /*5*/:
                    list = zzb.zzE(parcel, zzaT);
                    break;
                case BuyButtonText.LOGO_ONLY /*6*/:
                    str = zzb.zzq(parcel, zzaT);
                    break;
                case BuyButtonText.DONATE_WITH /*7*/:
                    uri = (Uri) zzb.zza(parcel, zzaT, Uri.CREATOR);
                    break;
                default:
                    zzb.zzb(parcel, zzaT);
                    break;
            }
        }
        if (parcel.dataPosition() == zzaU) {
            return new ApplicationMetadata(i, str3, str2, list2, list, str, uri);
        }
        throw new zza("Overread allowed size end=" + zzaU, parcel);
    }

    public ApplicationMetadata[] zzbG(int i) {
        return new ApplicationMetadata[i];
    }
}
