package com.google.android.gms.drive;

import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.common.internal.safeparcel.zzb.zza;
import com.google.android.gms.common.internal.safeparcel.zzc;
import com.google.android.gms.games.request.Requests;
import com.google.android.gms.wallet.fragment.WalletFragmentStyle.BuyButtonText;
import com.google.android.gms.wallet.fragment.WalletFragmentStyle.Dimension;
import com.google.android.gms.wearable.ChannelApi.ChannelListener;
import com.google.android.gms.wearable.MessageApi;

public class zzd implements Creator<zzc> {
    static void zza(zzc com_google_android_gms_drive_zzc, Parcel parcel, int i) {
        int zzaV = zzc.zzaV(parcel);
        zzc.zzc(parcel, 1, com_google_android_gms_drive_zzc.mVersionCode);
        zzc.zza(parcel, 2, com_google_android_gms_drive_zzc.zzaCS, i, false);
        zzc.zzc(parcel, 3, com_google_android_gms_drive_zzc.zzaJh);
        zzc.zzc(parcel, 4, com_google_android_gms_drive_zzc.zzaJi);
        zzc.zza(parcel, 5, com_google_android_gms_drive_zzc.zzaJj, i, false);
        zzc.zza(parcel, 7, com_google_android_gms_drive_zzc.zzaJk);
        zzc.zza(parcel, 8, com_google_android_gms_drive_zzc.zzxq, false);
        zzc.zzJ(parcel, zzaV);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzbI(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzdT(i);
    }

    public zzc zzbI(Parcel parcel) {
        String str = null;
        boolean z = false;
        int zzaU = zzb.zzaU(parcel);
        DriveId driveId = null;
        int i = 0;
        int i2 = 0;
        ParcelFileDescriptor parcelFileDescriptor = null;
        int i3 = 0;
        while (parcel.dataPosition() < zzaU) {
            int zzaT = zzb.zzaT(parcel);
            switch (zzb.zzcW(zzaT)) {
                case MessageApi.FILTER_PREFIX /*1*/:
                    i3 = zzb.zzg(parcel, zzaT);
                    break;
                case ChannelListener.CLOSE_REASON_REMOTE_CLOSE /*2*/:
                    parcelFileDescriptor = (ParcelFileDescriptor) zzb.zza(parcel, zzaT, ParcelFileDescriptor.CREATOR);
                    break;
                case ChannelListener.CLOSE_REASON_LOCAL_CLOSE /*3*/:
                    i2 = zzb.zzg(parcel, zzaT);
                    break;
                case Dimension.UNIT_IN /*4*/:
                    i = zzb.zzg(parcel, zzaT);
                    break;
                case Dimension.UNIT_MM /*5*/:
                    driveId = (DriveId) zzb.zza(parcel, zzaT, DriveId.CREATOR);
                    break;
                case BuyButtonText.DONATE_WITH /*7*/:
                    z = zzb.zzc(parcel, zzaT);
                    break;
                case Requests.MAX_REQUEST_RECIPIENTS /*8*/:
                    str = zzb.zzq(parcel, zzaT);
                    break;
                default:
                    zzb.zzb(parcel, zzaT);
                    break;
            }
        }
        if (parcel.dataPosition() == zzaU) {
            return new zzc(i3, parcelFileDescriptor, i2, i, driveId, z, str);
        }
        throw new zza("Overread allowed size end=" + zzaU, parcel);
    }

    public zzc[] zzdT(int i) {
        return new zzc[i];
    }
}
