package com.google.android.gms.identity.intents;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.common.internal.safeparcel.zzc;
import com.google.android.gms.identity.intents.model.CountrySpecification;
import com.google.android.gms.wearable.ChannelApi.ChannelListener;
import com.google.android.gms.wearable.MessageApi;
import java.util.List;

public class zza implements Creator<UserAddressRequest> {
    static void zza(UserAddressRequest userAddressRequest, Parcel parcel, int i) {
        int zzaV = zzc.zzaV(parcel);
        zzc.zzc(parcel, 1, userAddressRequest.getVersionCode());
        zzc.zzc(parcel, 2, userAddressRequest.zzbgL, false);
        zzc.zzJ(parcel, zzaV);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzgk(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzjx(i);
    }

    public UserAddressRequest zzgk(Parcel parcel) {
        int zzaU = zzb.zzaU(parcel);
        int i = 0;
        List list = null;
        while (parcel.dataPosition() < zzaU) {
            int zzaT = zzb.zzaT(parcel);
            switch (zzb.zzcW(zzaT)) {
                case MessageApi.FILTER_PREFIX /*1*/:
                    i = zzb.zzg(parcel, zzaT);
                    break;
                case ChannelListener.CLOSE_REASON_REMOTE_CLOSE /*2*/:
                    list = zzb.zzc(parcel, zzaT, CountrySpecification.CREATOR);
                    break;
                default:
                    zzb.zzb(parcel, zzaT);
                    break;
            }
        }
        if (parcel.dataPosition() == zzaU) {
            return new UserAddressRequest(i, list);
        }
        throw new com.google.android.gms.common.internal.safeparcel.zzb.zza("Overread allowed size end=" + zzaU, parcel);
    }

    public UserAddressRequest[] zzjx(int i) {
        return new UserAddressRequest[i];
    }
}
