package com.google.android.gms.drive.events;

import android.os.IBinder;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
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
import java.util.List;
import org.apache.http.protocol.HTTP;

public class zzg implements Creator<CompletionEvent> {
    static void zza(CompletionEvent completionEvent, Parcel parcel, int i) {
        int zzaV = zzc.zzaV(parcel);
        zzc.zzc(parcel, 1, completionEvent.mVersionCode);
        zzc.zza(parcel, 2, completionEvent.zzaJj, i, false);
        zzc.zza(parcel, 3, completionEvent.zzaht, false);
        zzc.zza(parcel, 4, completionEvent.zzaKm, i, false);
        zzc.zza(parcel, 5, completionEvent.zzaKn, i, false);
        zzc.zza(parcel, 6, completionEvent.zzaKo, i, false);
        zzc.zzb(parcel, 7, completionEvent.zzaKp, false);
        zzc.zzc(parcel, 8, completionEvent.zzJh);
        zzc.zza(parcel, 9, completionEvent.zzaKq, false);
        zzc.zzJ(parcel, zzaV);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzbS(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzej(i);
    }

    public CompletionEvent zzbS(Parcel parcel) {
        int i = 0;
        IBinder iBinder = null;
        int zzaU = zzb.zzaU(parcel);
        List list = null;
        MetadataBundle metadataBundle = null;
        ParcelFileDescriptor parcelFileDescriptor = null;
        ParcelFileDescriptor parcelFileDescriptor2 = null;
        String str = null;
        DriveId driveId = null;
        int i2 = 0;
        while (parcel.dataPosition() < zzaU) {
            int zzaT = zzb.zzaT(parcel);
            switch (zzb.zzcW(zzaT)) {
                case MessageApi.FILTER_PREFIX /*1*/:
                    i2 = zzb.zzg(parcel, zzaT);
                    break;
                case ChannelListener.CLOSE_REASON_REMOTE_CLOSE /*2*/:
                    driveId = (DriveId) zzb.zza(parcel, zzaT, DriveId.CREATOR);
                    break;
                case ChannelListener.CLOSE_REASON_LOCAL_CLOSE /*3*/:
                    str = zzb.zzq(parcel, zzaT);
                    break;
                case Dimension.UNIT_IN /*4*/:
                    parcelFileDescriptor2 = (ParcelFileDescriptor) zzb.zza(parcel, zzaT, ParcelFileDescriptor.CREATOR);
                    break;
                case Dimension.UNIT_MM /*5*/:
                    parcelFileDescriptor = (ParcelFileDescriptor) zzb.zza(parcel, zzaT, ParcelFileDescriptor.CREATOR);
                    break;
                case BuyButtonText.LOGO_ONLY /*6*/:
                    metadataBundle = (MetadataBundle) zzb.zza(parcel, zzaT, MetadataBundle.CREATOR);
                    break;
                case BuyButtonText.DONATE_WITH /*7*/:
                    list = zzb.zzE(parcel, zzaT);
                    break;
                case Requests.MAX_REQUEST_RECIPIENTS /*8*/:
                    i = zzb.zzg(parcel, zzaT);
                    break;
                case HTTP.HT /*9*/:
                    iBinder = zzb.zzr(parcel, zzaT);
                    break;
                default:
                    zzb.zzb(parcel, zzaT);
                    break;
            }
        }
        if (parcel.dataPosition() == zzaU) {
            return new CompletionEvent(i2, driveId, str, parcelFileDescriptor2, parcelFileDescriptor, metadataBundle, list, i, iBinder);
        }
        throw new zza("Overread allowed size end=" + zzaU, parcel);
    }

    public CompletionEvent[] zzej(int i) {
        return new CompletionEvent[i];
    }
}
