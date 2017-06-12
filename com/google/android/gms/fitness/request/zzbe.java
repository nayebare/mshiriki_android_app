package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.common.internal.safeparcel.zzb.zza;
import com.google.android.gms.common.internal.safeparcel.zzc;
import com.google.android.gms.fitness.data.Session;
import com.google.android.gms.wallet.WalletConstants.CardNetwork;
import com.google.android.gms.wearable.ChannelApi.ChannelListener;
import com.google.android.gms.wearable.MessageApi;

public class zzbe implements Creator<zzbd> {
    static void zza(zzbd com_google_android_gms_fitness_request_zzbd, Parcel parcel, int i) {
        int zzaV = zzc.zzaV(parcel);
        zzc.zza(parcel, 1, com_google_android_gms_fitness_request_zzbd.getSession(), i, false);
        zzc.zza(parcel, 2, com_google_android_gms_fitness_request_zzbd.getCallbackBinder(), false);
        zzc.zzc(parcel, CardNetwork.OTHER, com_google_android_gms_fitness_request_zzbd.getVersionCode());
        zzc.zzJ(parcel, zzaV);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzeR(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzhA(i);
    }

    public zzbd zzeR(Parcel parcel) {
        IBinder iBinder = null;
        int zzaU = zzb.zzaU(parcel);
        int i = 0;
        Session session = null;
        while (parcel.dataPosition() < zzaU) {
            int i2;
            IBinder iBinder2;
            Session session2;
            int zzaT = zzb.zzaT(parcel);
            switch (zzb.zzcW(zzaT)) {
                case MessageApi.FILTER_PREFIX /*1*/:
                    i2 = i;
                    Session session3 = (Session) zzb.zza(parcel, zzaT, Session.CREATOR);
                    iBinder2 = iBinder;
                    session2 = session3;
                    break;
                case ChannelListener.CLOSE_REASON_REMOTE_CLOSE /*2*/:
                    iBinder2 = zzb.zzr(parcel, zzaT);
                    session2 = session;
                    i2 = i;
                    break;
                case CardNetwork.OTHER /*1000*/:
                    IBinder iBinder3 = iBinder;
                    session2 = session;
                    i2 = zzb.zzg(parcel, zzaT);
                    iBinder2 = iBinder3;
                    break;
                default:
                    zzb.zzb(parcel, zzaT);
                    iBinder2 = iBinder;
                    session2 = session;
                    i2 = i;
                    break;
            }
            i = i2;
            session = session2;
            iBinder = iBinder2;
        }
        if (parcel.dataPosition() == zzaU) {
            return new zzbd(i, session, iBinder);
        }
        throw new zza("Overread allowed size end=" + zzaU, parcel);
    }

    public zzbd[] zzhA(int i) {
        return new zzbd[i];
    }
}
