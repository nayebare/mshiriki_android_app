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

public class zzagp implements Creator<zzago> {
    static void zza(zzago com_google_android_gms_internal_zzago, Parcel parcel, int i) {
        int zzaV = zzc.zzaV(parcel);
        zzc.zzc(parcel, 1, com_google_android_gms_internal_zzago.mVersionCode);
        zzc.zza(parcel, 2, com_google_android_gms_internal_zzago.zzaKS, i, false);
        zzc.zza(parcel, 3, com_google_android_gms_internal_zzago.zzaKT, i, false);
        zzc.zza(parcel, 4, com_google_android_gms_internal_zzago.zzaKU, i, false);
        zzc.zza(parcel, 5, com_google_android_gms_internal_zzago.zzaJG);
        zzc.zza(parcel, 6, com_google_android_gms_internal_zzago.zzaJF, false);
        zzc.zzc(parcel, 7, com_google_android_gms_internal_zzago.zzaKV);
        zzc.zzc(parcel, 8, com_google_android_gms_internal_zzago.zzaKW);
        zzc.zza(parcel, 9, com_google_android_gms_internal_zzago.zzaKX);
        zzc.zza(parcel, 10, com_google_android_gms_internal_zzago.zzaJK);
        zzc.zzJ(parcel, zzaV);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzcf(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzew(i);
    }

    public zzago zzcf(Parcel parcel) {
        String str = null;
        boolean z = false;
        int zzaU = zzb.zzaU(parcel);
        boolean z2 = true;
        int i = 0;
        int i2 = 0;
        boolean z3 = false;
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
                    z3 = zzb.zzc(parcel, zzaT);
                    break;
                case BuyButtonText.LOGO_ONLY /*6*/:
                    str = zzb.zzq(parcel, zzaT);
                    break;
                case BuyButtonText.DONATE_WITH /*7*/:
                    i2 = zzb.zzg(parcel, zzaT);
                    break;
                case Requests.MAX_REQUEST_RECIPIENTS /*8*/:
                    i = zzb.zzg(parcel, zzaT);
                    break;
                case HTTP.HT /*9*/:
                    z = zzb.zzc(parcel, zzaT);
                    break;
                case HTTP.LF /*10*/:
                    z2 = zzb.zzc(parcel, zzaT);
                    break;
                default:
                    zzb.zzb(parcel, zzaT);
                    break;
            }
        }
        if (parcel.dataPosition() == zzaU) {
            return new zzago(i3, driveId, metadataBundle, com_google_android_gms_drive_zzc, z3, str, i2, i, z, z2);
        }
        throw new zza("Overread allowed size end=" + zzaU, parcel);
    }

    public zzago[] zzew(int i) {
        return new zzago[i];
    }
}
