package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.common.internal.safeparcel.zzb.zza;
import com.google.android.gms.common.internal.safeparcel.zzc;
import com.google.android.gms.wallet.WalletConstants.CardNetwork;
import com.google.android.gms.wallet.fragment.WalletFragmentStyle.BuyButtonText;
import com.google.android.gms.wallet.fragment.WalletFragmentStyle.Dimension;
import com.google.android.gms.wearable.ChannelApi.ChannelListener;
import com.google.android.gms.wearable.MessageApi;

public class zzy implements Creator<RawDataPoint> {
    static void zza(RawDataPoint rawDataPoint, Parcel parcel, int i) {
        int zzaV = zzc.zzaV(parcel);
        zzc.zza(parcel, 1, rawDataPoint.zzaTA);
        zzc.zza(parcel, 2, rawDataPoint.zzaTB);
        zzc.zza(parcel, 3, rawDataPoint.zzaTC, i, false);
        zzc.zzc(parcel, 4, rawDataPoint.zzaTD);
        zzc.zzc(parcel, 5, rawDataPoint.zzaTE);
        zzc.zza(parcel, 6, rawDataPoint.zzaTF);
        zzc.zza(parcel, 7, rawDataPoint.zzaTG);
        zzc.zzc(parcel, CardNetwork.OTHER, rawDataPoint.versionCode);
        zzc.zzJ(parcel, zzaV);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzed(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzgJ(i);
    }

    public RawDataPoint zzed(Parcel parcel) {
        int zzaU = zzb.zzaU(parcel);
        int i = 0;
        long j = 0;
        long j2 = 0;
        Value[] valueArr = null;
        int i2 = 0;
        int i3 = 0;
        long j3 = 0;
        long j4 = 0;
        while (parcel.dataPosition() < zzaU) {
            int zzaT = zzb.zzaT(parcel);
            switch (zzb.zzcW(zzaT)) {
                case MessageApi.FILTER_PREFIX /*1*/:
                    j = zzb.zzi(parcel, zzaT);
                    break;
                case ChannelListener.CLOSE_REASON_REMOTE_CLOSE /*2*/:
                    j2 = zzb.zzi(parcel, zzaT);
                    break;
                case ChannelListener.CLOSE_REASON_LOCAL_CLOSE /*3*/:
                    valueArr = (Value[]) zzb.zzb(parcel, zzaT, Value.CREATOR);
                    break;
                case Dimension.UNIT_IN /*4*/:
                    i2 = zzb.zzg(parcel, zzaT);
                    break;
                case Dimension.UNIT_MM /*5*/:
                    i3 = zzb.zzg(parcel, zzaT);
                    break;
                case BuyButtonText.LOGO_ONLY /*6*/:
                    j3 = zzb.zzi(parcel, zzaT);
                    break;
                case BuyButtonText.DONATE_WITH /*7*/:
                    j4 = zzb.zzi(parcel, zzaT);
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
            return new RawDataPoint(i, j, j2, valueArr, i2, i3, j3, j4);
        }
        throw new zza("Overread allowed size end=" + zzaU, parcel);
    }

    public RawDataPoint[] zzgJ(int i) {
        return new RawDataPoint[i];
    }
}
