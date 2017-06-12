package com.google.android.gms.games.internal.game;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.common.internal.safeparcel.zzb.zza;
import com.google.android.gms.common.internal.safeparcel.zzc;
import com.google.android.gms.wallet.WalletConstants.CardNetwork;
import com.google.android.gms.wearable.ChannelApi.ChannelListener;
import com.google.android.gms.wearable.MessageApi;

public class ScreenshotEntityCreator implements Creator<ScreenshotEntity> {
    static void zza(ScreenshotEntity screenshotEntity, Parcel parcel, int i) {
        int zzaV = zzc.zzaV(parcel);
        zzc.zza(parcel, 1, screenshotEntity.getUri(), i, false);
        zzc.zzc(parcel, 2, screenshotEntity.getWidth());
        zzc.zzc(parcel, 3, screenshotEntity.getHeight());
        zzc.zzc(parcel, CardNetwork.OTHER, screenshotEntity.getVersionCode());
        zzc.zzJ(parcel, zzaV);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzfH(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zziJ(i);
    }

    public ScreenshotEntity zzfH(Parcel parcel) {
        int i = 0;
        int zzaU = zzb.zzaU(parcel);
        Uri uri = null;
        int i2 = 0;
        int i3 = 0;
        while (parcel.dataPosition() < zzaU) {
            int i4;
            Uri uri2;
            int zzaT = zzb.zzaT(parcel);
            int i5;
            switch (zzb.zzcW(zzaT)) {
                case MessageApi.FILTER_PREFIX /*1*/:
                    i4 = i3;
                    i5 = i2;
                    uri2 = (Uri) zzb.zza(parcel, zzaT, Uri.CREATOR);
                    zzaT = i;
                    i = i5;
                    break;
                case ChannelListener.CLOSE_REASON_REMOTE_CLOSE /*2*/:
                    uri2 = uri;
                    i4 = i3;
                    i5 = i;
                    i = zzb.zzg(parcel, zzaT);
                    zzaT = i5;
                    break;
                case ChannelListener.CLOSE_REASON_LOCAL_CLOSE /*3*/:
                    zzaT = zzb.zzg(parcel, zzaT);
                    i = i2;
                    uri2 = uri;
                    i4 = i3;
                    break;
                case CardNetwork.OTHER /*1000*/:
                    i5 = i;
                    i = i2;
                    uri2 = uri;
                    i4 = zzb.zzg(parcel, zzaT);
                    zzaT = i5;
                    break;
                default:
                    zzb.zzb(parcel, zzaT);
                    zzaT = i;
                    i = i2;
                    uri2 = uri;
                    i4 = i3;
                    break;
            }
            i3 = i4;
            uri = uri2;
            i2 = i;
            i = zzaT;
        }
        if (parcel.dataPosition() == zzaU) {
            return new ScreenshotEntity(i3, uri, i2, i);
        }
        throw new zza("Overread allowed size end=" + zzaU, parcel);
    }

    public ScreenshotEntity[] zziJ(int i) {
        return new ScreenshotEntity[i];
    }
}
