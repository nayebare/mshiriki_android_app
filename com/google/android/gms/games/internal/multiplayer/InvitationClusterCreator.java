package com.google.android.gms.games.internal.multiplayer;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.common.internal.safeparcel.zzb.zza;
import com.google.android.gms.common.internal.safeparcel.zzc;
import com.google.android.gms.games.multiplayer.InvitationEntity;
import com.google.android.gms.wallet.WalletConstants.CardNetwork;
import com.google.android.gms.wearable.MessageApi;
import java.util.ArrayList;

public class InvitationClusterCreator implements Creator<ZInvitationCluster> {
    static void zza(ZInvitationCluster zInvitationCluster, Parcel parcel, int i) {
        int zzaV = zzc.zzaV(parcel);
        zzc.zzc(parcel, 1, zInvitationCluster.zzFh(), false);
        zzc.zzc(parcel, CardNetwork.OTHER, zInvitationCluster.getVersionCode());
        zzc.zzJ(parcel, zzaV);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzfI(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zziK(i);
    }

    public ZInvitationCluster zzfI(Parcel parcel) {
        int zzaU = zzb.zzaU(parcel);
        int i = 0;
        ArrayList arrayList = null;
        while (parcel.dataPosition() < zzaU) {
            int zzaT = zzb.zzaT(parcel);
            switch (zzb.zzcW(zzaT)) {
                case MessageApi.FILTER_PREFIX /*1*/:
                    arrayList = zzb.zzc(parcel, zzaT, InvitationEntity.CREATOR);
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
            return new ZInvitationCluster(i, arrayList);
        }
        throw new zza("Overread allowed size end=" + zzaU, parcel);
    }

    public ZInvitationCluster[] zziK(int i) {
        return new ZInvitationCluster[i];
    }
}
