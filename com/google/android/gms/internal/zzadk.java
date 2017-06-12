package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.common.internal.safeparcel.zzb.zza;
import com.google.android.gms.common.internal.safeparcel.zzc;
import com.google.android.gms.games.request.Requests;
import com.google.android.gms.wallet.fragment.WalletFragmentStyle.BuyButtonText;
import com.google.android.gms.wallet.fragment.WalletFragmentStyle.Dimension;
import com.google.android.gms.wearable.ChannelApi.ChannelListener;
import com.google.android.gms.wearable.MessageApi;
import java.util.List;
import org.apache.http.protocol.HTTP;

public class zzadk implements Creator<zzadj> {
    static void zza(zzadj com_google_android_gms_internal_zzadj, Parcel parcel, int i) {
        int zzaV = zzc.zzaV(parcel);
        zzc.zzc(parcel, 1, com_google_android_gms_internal_zzadj.mVersionCode);
        zzc.zza(parcel, 2, com_google_android_gms_internal_zzadj.getPackageName(), false);
        zzc.zza(parcel, 3, com_google_android_gms_internal_zzadj.zzyV());
        zzc.zza(parcel, 4, com_google_android_gms_internal_zzadj.zzyW(), i, false);
        zzc.zza(parcel, 5, com_google_android_gms_internal_zzadj.zzyX(), false);
        zzc.zza(parcel, 6, com_google_android_gms_internal_zzadj.getAppInstanceId(), false);
        zzc.zza(parcel, 7, com_google_android_gms_internal_zzadj.zzyY(), false);
        zzc.zzb(parcel, 8, com_google_android_gms_internal_zzadj.zzyZ(), false);
        zzc.zzc(parcel, 9, com_google_android_gms_internal_zzadj.zzyS());
        zzc.zzc(parcel, 10, com_google_android_gms_internal_zzadj.zzza(), false);
        zzc.zzJ(parcel, zzaV);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzbi(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzdq(i);
    }

    public zzadj zzbi(Parcel parcel) {
        int i = 0;
        List list = null;
        int zzaU = zzb.zzaU(parcel);
        long j = 0;
        List list2 = null;
        String str = null;
        String str2 = null;
        String str3 = null;
        DataHolder dataHolder = null;
        String str4 = null;
        int i2 = 0;
        while (parcel.dataPosition() < zzaU) {
            int zzaT = zzb.zzaT(parcel);
            switch (zzb.zzcW(zzaT)) {
                case MessageApi.FILTER_PREFIX /*1*/:
                    i2 = zzb.zzg(parcel, zzaT);
                    break;
                case ChannelListener.CLOSE_REASON_REMOTE_CLOSE /*2*/:
                    str4 = zzb.zzq(parcel, zzaT);
                    break;
                case ChannelListener.CLOSE_REASON_LOCAL_CLOSE /*3*/:
                    j = zzb.zzi(parcel, zzaT);
                    break;
                case Dimension.UNIT_IN /*4*/:
                    dataHolder = (DataHolder) zzb.zza(parcel, zzaT, DataHolder.CREATOR);
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
                    list2 = zzb.zzE(parcel, zzaT);
                    break;
                case HTTP.HT /*9*/:
                    i = zzb.zzg(parcel, zzaT);
                    break;
                case HTTP.LF /*10*/:
                    list = zzb.zzc(parcel, zzaT, zzadb.CREATOR);
                    break;
                default:
                    zzb.zzb(parcel, zzaT);
                    break;
            }
        }
        if (parcel.dataPosition() == zzaU) {
            return new zzadj(i2, str4, j, dataHolder, str3, str2, str, list2, i, list);
        }
        throw new zza("Overread allowed size end=" + zzaU, parcel);
    }

    public zzadj[] zzdq(int i) {
        return new zzadj[i];
    }
}
