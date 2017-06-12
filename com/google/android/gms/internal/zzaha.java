package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.common.internal.safeparcel.zzb.zza;
import com.google.android.gms.common.internal.safeparcel.zzc;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;
import com.google.android.gms.games.request.Requests;
import com.google.android.gms.wallet.fragment.WalletFragmentStyle.BuyButtonText;
import com.google.android.gms.wallet.fragment.WalletFragmentStyle.Dimension;
import com.google.android.gms.wearable.ChannelApi.ChannelListener;
import com.google.android.gms.wearable.MessageApi;
import org.apache.http.protocol.HTTP;

public class zzaha implements Creator<zzagz> {
    static void zza(zzagz com_google_android_gms_internal_zzagz, Parcel parcel, int i) {
        int zzaV = zzc.zzaV(parcel);
        zzc.zzc(parcel, 1, com_google_android_gms_internal_zzagz.mVersionCode);
        zzc.zza(parcel, 2, com_google_android_gms_internal_zzagz.zzaLh, i, false);
        zzc.zza(parcel, 3, com_google_android_gms_internal_zzagz.zzaLf, i, false);
        zzc.zza(parcel, 4, com_google_android_gms_internal_zzagz.zzaKU, i, false);
        zzc.zza(parcel, 5, com_google_android_gms_internal_zzagz.zzaLg, false);
        zzc.zza(parcel, 6, com_google_android_gms_internal_zzagz.zzaKM);
        zzc.zza(parcel, 7, com_google_android_gms_internal_zzagz.zzaJF, false);
        zzc.zzc(parcel, 8, com_google_android_gms_internal_zzagz.zzaLi);
        zzc.zzc(parcel, 9, com_google_android_gms_internal_zzagz.zzaLj);
        zzc.zza(parcel, 10, com_google_android_gms_internal_zzagz.zzaJI, false);
        zzc.zzJ(parcel, zzaV);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzck(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzeC(i);
    }

    public zzagz zzck(Parcel parcel) {
        int i = 0;
        String str = null;
        int zzaU = zzb.zzaU(parcel);
        int i2 = 0;
        String str2 = null;
        boolean z = false;
        Integer num = null;
        com.google.android.gms.drive.zzc com_google_android_gms_drive_zzc = null;
        MetadataBundle metadataBundle = null;
        DriveId driveId = null;
        int i3 = 0;
        while (parcel.dataPosition() < zzaU) {
            int zzaT = zzb.zzaT(parcel);
            switch (zzb.zzcW(zzaT)) {
                case MessageApi.FILTER_PREFIX /*1*/:
                    i3 = zzb.zzg(parcel, zzaT);
                    break;
                case ChannelListener.CLOSE_REASON_REMOTE_CLOSE /*2*/:
                    driveId = (DriveId) zzb.zza(parcel, zzaT, DriveId.CREATOR);
                    break;
                case ChannelListener.CLOSE_REASON_LOCAL_CLOSE /*3*/:
                    metadataBundle = (MetadataBundle) zzb.zza(parcel, zzaT, MetadataBundle.CREATOR);
                    break;
                case Dimension.UNIT_IN /*4*/:
                    com_google_android_gms_drive_zzc = (com.google.android.gms.drive.zzc) zzb.zza(parcel, zzaT, com.google.android.gms.drive.zzc.CREATOR);
                    break;
                case Dimension.UNIT_MM /*5*/:
                    num = zzb.zzh(parcel, zzaT);
                    break;
                case BuyButtonText.LOGO_ONLY /*6*/:
                    z = zzb.zzc(parcel, zzaT);
                    break;
                case BuyButtonText.DONATE_WITH /*7*/:
                    str2 = zzb.zzq(parcel, zzaT);
                    break;
                case Requests.MAX_REQUEST_RECIPIENTS /*8*/:
                    i2 = zzb.zzg(parcel, zzaT);
                    break;
                case HTTP.HT /*9*/:
                    i = zzb.zzg(parcel, zzaT);
                    break;
                case HTTP.LF /*10*/:
                    str = zzb.zzq(parcel, zzaT);
                    break;
                default:
                    zzb.zzb(parcel, zzaT);
                    break;
            }
        }
        if (parcel.dataPosition() == zzaU) {
            return new zzagz(i3, driveId, metadataBundle, com_google_android_gms_drive_zzc, num, z, str2, i2, i, str);
        }
        throw new zza("Overread allowed size end=" + zzaU, parcel);
    }

    public zzagz[] zzeC(int i) {
        return new zzagz[i];
    }
}
