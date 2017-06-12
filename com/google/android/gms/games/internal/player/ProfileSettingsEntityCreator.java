package com.google.android.gms.games.internal.player;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.common.internal.safeparcel.zzb.zza;
import com.google.android.gms.common.internal.safeparcel.zzc;
import com.google.android.gms.games.request.Requests;
import com.google.android.gms.wallet.WalletConstants.CardNetwork;
import com.google.android.gms.wallet.fragment.WalletFragmentStyle.BuyButtonText;
import com.google.android.gms.wallet.fragment.WalletFragmentStyle.Dimension;
import com.google.android.gms.wearable.ChannelApi.ChannelListener;
import com.google.android.gms.wearable.MessageApi;

public class ProfileSettingsEntityCreator implements Creator<ProfileSettingsEntity> {
    static void zza(ProfileSettingsEntity profileSettingsEntity, Parcel parcel, int i) {
        int zzaV = zzc.zzaV(parcel);
        zzc.zza(parcel, 1, profileSettingsEntity.getStatus(), i, false);
        zzc.zza(parcel, 2, profileSettingsEntity.zzDc(), false);
        zzc.zza(parcel, 3, profileSettingsEntity.zzDm());
        zzc.zza(parcel, 4, profileSettingsEntity.zzDf());
        zzc.zza(parcel, 5, profileSettingsEntity.zzDk());
        zzc.zza(parcel, 6, profileSettingsEntity.zzDl(), i, false);
        zzc.zza(parcel, 7, profileSettingsEntity.zzDn());
        zzc.zzc(parcel, CardNetwork.OTHER, profileSettingsEntity.getVersionCode());
        zzc.zza(parcel, 8, profileSettingsEntity.zzDo());
        zzc.zzJ(parcel, zzaV);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzfK(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zziN(i);
    }

    public ProfileSettingsEntity zzfK(Parcel parcel) {
        StockProfileImageEntity stockProfileImageEntity = null;
        boolean z = false;
        int zzaU = zzb.zzaU(parcel);
        boolean z2 = false;
        boolean z3 = false;
        boolean z4 = false;
        boolean z5 = false;
        String str = null;
        Status status = null;
        int i = 0;
        while (parcel.dataPosition() < zzaU) {
            int zzaT = zzb.zzaT(parcel);
            switch (zzb.zzcW(zzaT)) {
                case MessageApi.FILTER_PREFIX /*1*/:
                    status = (Status) zzb.zza(parcel, zzaT, Status.CREATOR);
                    break;
                case ChannelListener.CLOSE_REASON_REMOTE_CLOSE /*2*/:
                    str = zzb.zzq(parcel, zzaT);
                    break;
                case ChannelListener.CLOSE_REASON_LOCAL_CLOSE /*3*/:
                    z5 = zzb.zzc(parcel, zzaT);
                    break;
                case Dimension.UNIT_IN /*4*/:
                    z4 = zzb.zzc(parcel, zzaT);
                    break;
                case Dimension.UNIT_MM /*5*/:
                    z3 = zzb.zzc(parcel, zzaT);
                    break;
                case BuyButtonText.LOGO_ONLY /*6*/:
                    stockProfileImageEntity = (StockProfileImageEntity) zzb.zza(parcel, zzaT, StockProfileImageEntity.CREATOR);
                    break;
                case BuyButtonText.DONATE_WITH /*7*/:
                    z2 = zzb.zzc(parcel, zzaT);
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
            return new ProfileSettingsEntity(i, status, str, z5, z4, z3, stockProfileImageEntity, z2, z);
        }
        throw new zza("Overread allowed size end=" + zzaU, parcel);
    }

    public ProfileSettingsEntity[] zziN(int i) {
        return new ProfileSettingsEntity[i];
    }
}
