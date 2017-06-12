package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.common.internal.safeparcel.zzb.zza;
import com.google.android.gms.common.internal.safeparcel.zzc;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.wallet.fragment.WalletFragmentStyle.BuyButtonText;
import com.google.android.gms.wallet.fragment.WalletFragmentStyle.Dimension;
import com.google.android.gms.wearable.ChannelApi.ChannelListener;
import com.google.android.gms.wearable.MessageApi;
import java.util.List;

public class zzair implements Creator<zzaiq> {
    static void zza(zzaiq com_google_android_gms_internal_zzaiq, Parcel parcel, int i) {
        int zzaV = zzc.zzaV(parcel);
        zzc.zzc(parcel, 1, com_google_android_gms_internal_zzaiq.mVersionCode);
        zzc.zza(parcel, 2, com_google_android_gms_internal_zzaiq.zzaJj, i, false);
        zzc.zza(parcel, 3, com_google_android_gms_internal_zzaiq.zzaMw);
        zzc.zzb(parcel, 4, com_google_android_gms_internal_zzaiq.zzaMx, false);
        zzc.zza(parcel, 5, com_google_android_gms_internal_zzaiq.zzaMy);
        zzc.zza(parcel, 6, com_google_android_gms_internal_zzaiq.zzaMz, i, false);
        zzc.zza(parcel, 7, com_google_android_gms_internal_zzaiq.zzaMA, false);
        zzc.zzJ(parcel, zzaV);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzcx(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzeT(i);
    }

    public zzaiq zzcx(Parcel parcel) {
        boolean z = false;
        String str = null;
        int zzaU = zzb.zzaU(parcel);
        DataHolder dataHolder = null;
        List list = null;
        boolean z2 = false;
        DriveId driveId = null;
        int i = 0;
        while (parcel.dataPosition() < zzaU) {
            int zzaT = zzb.zzaT(parcel);
            switch (zzb.zzcW(zzaT)) {
                case MessageApi.FILTER_PREFIX /*1*/:
                    i = zzb.zzg(parcel, zzaT);
                    break;
                case ChannelListener.CLOSE_REASON_REMOTE_CLOSE /*2*/:
                    driveId = (DriveId) zzb.zza(parcel, zzaT, DriveId.CREATOR);
                    break;
                case ChannelListener.CLOSE_REASON_LOCAL_CLOSE /*3*/:
                    z2 = zzb.zzc(parcel, zzaT);
                    break;
                case Dimension.UNIT_IN /*4*/:
                    list = zzb.zzE(parcel, zzaT);
                    break;
                case Dimension.UNIT_MM /*5*/:
                    z = zzb.zzc(parcel, zzaT);
                    break;
                case BuyButtonText.LOGO_ONLY /*6*/:
                    dataHolder = (DataHolder) zzb.zza(parcel, zzaT, DataHolder.CREATOR);
                    break;
                case BuyButtonText.DONATE_WITH /*7*/:
                    str = zzb.zzq(parcel, zzaT);
                    break;
                default:
                    zzb.zzb(parcel, zzaT);
                    break;
            }
        }
        if (parcel.dataPosition() == zzaU) {
            return new zzaiq(i, driveId, z2, list, z, dataHolder, str);
        }
        throw new zza("Overread allowed size end=" + zzaU, parcel);
    }

    public zzaiq[] zzeT(int i) {
        return new zzaiq[i];
    }
}
