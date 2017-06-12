package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.ParcelUuid;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.common.internal.safeparcel.zzb.zza;
import com.google.android.gms.common.internal.safeparcel.zzc;
import com.google.android.gms.games.request.Requests;
import com.google.android.gms.wallet.fragment.WalletFragmentStyle.BuyButtonText;
import com.google.android.gms.wallet.fragment.WalletFragmentStyle.Dimension;
import com.google.android.gms.wearable.MessageApi;
import org.apache.http.protocol.HTTP;

public class zzavo implements Creator<zzavn> {
    static void zza(zzavn com_google_android_gms_internal_zzavn, Parcel parcel, int i) {
        int zzaV = zzc.zzaV(parcel);
        zzc.zzc(parcel, 1, com_google_android_gms_internal_zzavn.getVersionCode());
        zzc.zza(parcel, 4, com_google_android_gms_internal_zzavn.getServiceUuid(), i, false);
        zzc.zza(parcel, 5, com_google_android_gms_internal_zzavn.getServiceUuidMask(), i, false);
        zzc.zza(parcel, 6, com_google_android_gms_internal_zzavn.getServiceDataUuid(), i, false);
        zzc.zza(parcel, 7, com_google_android_gms_internal_zzavn.getServiceData(), false);
        zzc.zza(parcel, 8, com_google_android_gms_internal_zzavn.getServiceDataMask(), false);
        zzc.zzc(parcel, 9, com_google_android_gms_internal_zzavn.getManufacturerId());
        zzc.zza(parcel, 10, com_google_android_gms_internal_zzavn.getManufacturerData(), false);
        zzc.zza(parcel, 11, com_google_android_gms_internal_zzavn.getManufacturerDataMask(), false);
        zzc.zzJ(parcel, zzaV);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzic(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzlR(i);
    }

    public zzavn zzic(Parcel parcel) {
        int i = 0;
        byte[] bArr = null;
        int zzaU = zzb.zzaU(parcel);
        byte[] bArr2 = null;
        byte[] bArr3 = null;
        byte[] bArr4 = null;
        ParcelUuid parcelUuid = null;
        ParcelUuid parcelUuid2 = null;
        ParcelUuid parcelUuid3 = null;
        int i2 = 0;
        while (parcel.dataPosition() < zzaU) {
            int zzaT = zzb.zzaT(parcel);
            switch (zzb.zzcW(zzaT)) {
                case MessageApi.FILTER_PREFIX /*1*/:
                    i2 = zzb.zzg(parcel, zzaT);
                    break;
                case Dimension.UNIT_IN /*4*/:
                    parcelUuid3 = (ParcelUuid) zzb.zza(parcel, zzaT, ParcelUuid.CREATOR);
                    break;
                case Dimension.UNIT_MM /*5*/:
                    parcelUuid2 = (ParcelUuid) zzb.zza(parcel, zzaT, ParcelUuid.CREATOR);
                    break;
                case BuyButtonText.LOGO_ONLY /*6*/:
                    parcelUuid = (ParcelUuid) zzb.zza(parcel, zzaT, ParcelUuid.CREATOR);
                    break;
                case BuyButtonText.DONATE_WITH /*7*/:
                    bArr4 = zzb.zzt(parcel, zzaT);
                    break;
                case Requests.MAX_REQUEST_RECIPIENTS /*8*/:
                    bArr3 = zzb.zzt(parcel, zzaT);
                    break;
                case HTTP.HT /*9*/:
                    i = zzb.zzg(parcel, zzaT);
                    break;
                case HTTP.LF /*10*/:
                    bArr2 = zzb.zzt(parcel, zzaT);
                    break;
                case ConnectionResult.LICENSE_CHECK_FAILED /*11*/:
                    bArr = zzb.zzt(parcel, zzaT);
                    break;
                default:
                    zzb.zzb(parcel, zzaT);
                    break;
            }
        }
        if (parcel.dataPosition() == zzaU) {
            return new zzavn(i2, parcelUuid3, parcelUuid2, parcelUuid, bArr4, bArr3, i, bArr2, bArr);
        }
        throw new zza("Overread allowed size end=" + zzaU, parcel);
    }

    public zzavn[] zzlR(int i) {
        return new zzavn[i];
    }
}
