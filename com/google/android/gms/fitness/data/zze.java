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
import java.util.List;

public class zze implements Creator<Bucket> {
    static void zza(Bucket bucket, Parcel parcel, int i) {
        int zzaV = zzc.zzaV(parcel);
        zzc.zza(parcel, 1, bucket.zzpN());
        zzc.zza(parcel, 2, bucket.zzzx());
        zzc.zza(parcel, 3, bucket.getSession(), i, false);
        zzc.zzc(parcel, 4, bucket.zzBg());
        zzc.zzc(parcel, 5, bucket.getDataSets(), false);
        zzc.zzc(parcel, 6, bucket.getBucketType());
        zzc.zza(parcel, 7, bucket.zzBh());
        zzc.zzc(parcel, CardNetwork.OTHER, bucket.getVersionCode());
        zzc.zzJ(parcel, zzaV);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzdP(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzgo(i);
    }

    public Bucket zzdP(Parcel parcel) {
        long j = 0;
        List list = null;
        boolean z = false;
        int zzaU = zzb.zzaU(parcel);
        int i = 0;
        int i2 = 0;
        Session session = null;
        long j2 = 0;
        int i3 = 0;
        while (parcel.dataPosition() < zzaU) {
            int zzaT = zzb.zzaT(parcel);
            switch (zzb.zzcW(zzaT)) {
                case MessageApi.FILTER_PREFIX /*1*/:
                    j2 = zzb.zzi(parcel, zzaT);
                    break;
                case ChannelListener.CLOSE_REASON_REMOTE_CLOSE /*2*/:
                    j = zzb.zzi(parcel, zzaT);
                    break;
                case ChannelListener.CLOSE_REASON_LOCAL_CLOSE /*3*/:
                    session = (Session) zzb.zza(parcel, zzaT, Session.CREATOR);
                    break;
                case Dimension.UNIT_IN /*4*/:
                    i2 = zzb.zzg(parcel, zzaT);
                    break;
                case Dimension.UNIT_MM /*5*/:
                    list = zzb.zzc(parcel, zzaT, DataSet.CREATOR);
                    break;
                case BuyButtonText.LOGO_ONLY /*6*/:
                    i = zzb.zzg(parcel, zzaT);
                    break;
                case BuyButtonText.DONATE_WITH /*7*/:
                    z = zzb.zzc(parcel, zzaT);
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
            return new Bucket(i3, j2, j, session, i2, list, i, z);
        }
        throw new zza("Overread allowed size end=" + zzaU, parcel);
    }

    public Bucket[] zzgo(int i) {
        return new Bucket[i];
    }
}
