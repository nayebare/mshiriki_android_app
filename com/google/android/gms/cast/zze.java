package com.google.android.gms.cast;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.images.WebImage;
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

public class zze implements Creator<CastDevice> {
    static void zza(CastDevice castDevice, Parcel parcel, int i) {
        int zzaV = zzc.zzaV(parcel);
        zzc.zzc(parcel, 1, castDevice.getVersionCode());
        zzc.zza(parcel, 2, castDevice.zzrJ(), false);
        zzc.zza(parcel, 3, castDevice.zzamh, false);
        zzc.zza(parcel, 4, castDevice.getFriendlyName(), false);
        zzc.zza(parcel, 5, castDevice.getModelName(), false);
        zzc.zza(parcel, 6, castDevice.getDeviceVersion(), false);
        zzc.zzc(parcel, 7, castDevice.getServicePort());
        zzc.zzc(parcel, 8, castDevice.getIcons(), false);
        zzc.zzc(parcel, 9, castDevice.getCapabilities());
        zzc.zzc(parcel, 10, castDevice.getStatus());
        zzc.zza(parcel, 11, castDevice.zzrK(), false);
        zzc.zzJ(parcel, zzaV);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzap(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzbH(i);
    }

    public CastDevice zzap(Parcel parcel) {
        int i = 0;
        String str = null;
        int zzaU = zzb.zzaU(parcel);
        int i2 = -1;
        List list = null;
        int i3 = 0;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        String str6 = null;
        int i4 = 0;
        while (parcel.dataPosition() < zzaU) {
            int zzaT = zzb.zzaT(parcel);
            switch (zzb.zzcW(zzaT)) {
                case MessageApi.FILTER_PREFIX /*1*/:
                    i4 = zzb.zzg(parcel, zzaT);
                    break;
                case ChannelListener.CLOSE_REASON_REMOTE_CLOSE /*2*/:
                    str6 = zzb.zzq(parcel, zzaT);
                    break;
                case ChannelListener.CLOSE_REASON_LOCAL_CLOSE /*3*/:
                    str5 = zzb.zzq(parcel, zzaT);
                    break;
                case Dimension.UNIT_IN /*4*/:
                    str4 = zzb.zzq(parcel, zzaT);
                    break;
                case Dimension.UNIT_MM /*5*/:
                    str3 = zzb.zzq(parcel, zzaT);
                    break;
                case BuyButtonText.LOGO_ONLY /*6*/:
                    str2 = zzb.zzq(parcel, zzaT);
                    break;
                case BuyButtonText.DONATE_WITH /*7*/:
                    i3 = zzb.zzg(parcel, zzaT);
                    break;
                case Requests.MAX_REQUEST_RECIPIENTS /*8*/:
                    list = zzb.zzc(parcel, zzaT, WebImage.CREATOR);
                    break;
                case HTTP.HT /*9*/:
                    i = zzb.zzg(parcel, zzaT);
                    break;
                case HTTP.LF /*10*/:
                    i2 = zzb.zzg(parcel, zzaT);
                    break;
                case ConnectionResult.LICENSE_CHECK_FAILED /*11*/:
                    str = zzb.zzq(parcel, zzaT);
                    break;
                default:
                    zzb.zzb(parcel, zzaT);
                    break;
            }
        }
        if (parcel.dataPosition() == zzaU) {
            return new CastDevice(i4, str6, str5, str4, str3, str2, i3, list, i, i2, str);
        }
        throw new zza("Overread allowed size end=" + zzaU, parcel);
    }

    public CastDevice[] zzbH(int i) {
        return new CastDevice[i];
    }
}
