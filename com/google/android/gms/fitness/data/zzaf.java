package com.google.android.gms.fitness.data;

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

public class zzaf implements Creator<Value> {
    static void zza(Value value, Parcel parcel, int i) {
        int zzaV = zzc.zzaV(parcel);
        zzc.zzc(parcel, 1, value.getFormat());
        zzc.zza(parcel, 2, value.isSet());
        zzc.zza(parcel, 3, value.zzBI());
        zzc.zza(parcel, 4, value.zzBN(), false);
        zzc.zza(parcel, 5, value.zzBO(), false);
        zzc.zza(parcel, 6, value.zzBP(), false);
        zzc.zza(parcel, 7, value.zzBQ(), false);
        zzc.zzc(parcel, CardNetwork.OTHER, value.getVersionCode());
        zzc.zza(parcel, 8, value.zzBR(), false);
        zzc.zzJ(parcel, zzaV);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzej(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzgQ(i);
    }

    public Value zzej(Parcel parcel) {
        boolean z = false;
        byte[] bArr = null;
        int zzaU = zzb.zzaU(parcel);
        float f = 0.0f;
        float[] fArr = null;
        int[] iArr = null;
        Bundle bundle = null;
        String str = null;
        int i = 0;
        int i2 = 0;
        while (parcel.dataPosition() < zzaU) {
            int zzaT = zzb.zzaT(parcel);
            switch (zzb.zzcW(zzaT)) {
                case MessageApi.FILTER_PREFIX /*1*/:
                    i = zzb.zzg(parcel, zzaT);
                    break;
                case ChannelListener.CLOSE_REASON_REMOTE_CLOSE /*2*/:
                    z = zzb.zzc(parcel, zzaT);
                    break;
                case ChannelListener.CLOSE_REASON_LOCAL_CLOSE /*3*/:
                    f = zzb.zzl(parcel, zzaT);
                    break;
                case Dimension.UNIT_IN /*4*/:
                    str = zzb.zzq(parcel, zzaT);
                    break;
                case Dimension.UNIT_MM /*5*/:
                    bundle = zzb.zzs(parcel, zzaT);
                    break;
                case BuyButtonText.LOGO_ONLY /*6*/:
                    iArr = zzb.zzw(parcel, zzaT);
                    break;
                case BuyButtonText.DONATE_WITH /*7*/:
                    fArr = zzb.zzz(parcel, zzaT);
                    break;
                case Requests.MAX_REQUEST_RECIPIENTS /*8*/:
                    bArr = zzb.zzt(parcel, zzaT);
                    break;
                case CardNetwork.OTHER /*1000*/:
                    i2 = zzb.zzg(parcel, zzaT);
                    break;
                default:
                    zzb.zzb(parcel, zzaT);
                    break;
            }
        }
        if (parcel.dataPosition() == zzaU) {
            return new Value(i2, i, z, f, str, bundle, iArr, fArr, bArr);
        }
        throw new zza("Overread allowed size end=" + zzaU, parcel);
    }

    public Value[] zzgQ(int i) {
        return new Value[i];
    }
}
