package com.google.android.gms.auth.api.credentials;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.common.internal.safeparcel.zzb.zza;
import com.google.android.gms.wallet.WalletConstants.CardNetwork;
import com.google.android.gms.wallet.fragment.WalletFragmentStyle.Dimension;
import com.google.android.gms.wearable.ChannelApi.ChannelListener;
import com.google.android.gms.wearable.MessageApi;

public class zzc implements Creator<CredentialRequest> {
    static void zza(CredentialRequest credentialRequest, Parcel parcel, int i) {
        int zzaV = com.google.android.gms.common.internal.safeparcel.zzc.zzaV(parcel);
        com.google.android.gms.common.internal.safeparcel.zzc.zza(parcel, 1, credentialRequest.isPasswordLoginSupported());
        com.google.android.gms.common.internal.safeparcel.zzc.zza(parcel, 2, credentialRequest.getAccountTypes(), false);
        com.google.android.gms.common.internal.safeparcel.zzc.zza(parcel, 3, credentialRequest.getCredentialPickerConfig(), i, false);
        com.google.android.gms.common.internal.safeparcel.zzc.zza(parcel, 4, credentialRequest.getCredentialHintPickerConfig(), i, false);
        com.google.android.gms.common.internal.safeparcel.zzc.zzc(parcel, CardNetwork.OTHER, credentialRequest.mVersionCode);
        com.google.android.gms.common.internal.safeparcel.zzc.zzJ(parcel, zzaV);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzL(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzaZ(i);
    }

    public CredentialRequest zzL(Parcel parcel) {
        boolean z = false;
        CredentialPickerConfig credentialPickerConfig = null;
        int zzaU = zzb.zzaU(parcel);
        CredentialPickerConfig credentialPickerConfig2 = null;
        String[] strArr = null;
        int i = 0;
        while (parcel.dataPosition() < zzaU) {
            int zzaT = zzb.zzaT(parcel);
            switch (zzb.zzcW(zzaT)) {
                case MessageApi.FILTER_PREFIX /*1*/:
                    z = zzb.zzc(parcel, zzaT);
                    break;
                case ChannelListener.CLOSE_REASON_REMOTE_CLOSE /*2*/:
                    strArr = zzb.zzC(parcel, zzaT);
                    break;
                case ChannelListener.CLOSE_REASON_LOCAL_CLOSE /*3*/:
                    credentialPickerConfig2 = (CredentialPickerConfig) zzb.zza(parcel, zzaT, CredentialPickerConfig.CREATOR);
                    break;
                case Dimension.UNIT_IN /*4*/:
                    credentialPickerConfig = (CredentialPickerConfig) zzb.zza(parcel, zzaT, CredentialPickerConfig.CREATOR);
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
            return new CredentialRequest(i, z, strArr, credentialPickerConfig2, credentialPickerConfig);
        }
        throw new zza("Overread allowed size end=" + zzaU, parcel);
    }

    public CredentialRequest[] zzaZ(int i) {
        return new CredentialRequest[i];
    }
}
