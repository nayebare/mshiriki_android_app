package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.common.internal.safeparcel.zzb.zza;
import com.google.android.gms.common.internal.safeparcel.zzc;
import com.google.android.gms.drive.events.ChangeEvent;
import com.google.android.gms.drive.events.CompletionEvent;
import com.google.android.gms.drive.events.zzk;
import com.google.android.gms.drive.events.zzn;
import com.google.android.gms.drive.events.zzr;
import com.google.android.gms.wallet.fragment.WalletFragmentStyle.BuyButtonText;
import com.google.android.gms.wallet.fragment.WalletFragmentStyle.Dimension;
import com.google.android.gms.wearable.ChannelApi.ChannelListener;
import com.google.android.gms.wearable.MessageApi;
import org.apache.http.protocol.HTTP;

public class zzajd implements Creator<zzajc> {
    static void zza(zzajc com_google_android_gms_internal_zzajc, Parcel parcel, int i) {
        int zzaV = zzc.zzaV(parcel);
        zzc.zzc(parcel, 1, com_google_android_gms_internal_zzajc.mVersionCode);
        zzc.zzc(parcel, 2, com_google_android_gms_internal_zzajc.zzaGv);
        zzc.zza(parcel, 3, com_google_android_gms_internal_zzajc.zzaML, i, false);
        zzc.zza(parcel, 5, com_google_android_gms_internal_zzajc.zzaMM, i, false);
        zzc.zza(parcel, 6, com_google_android_gms_internal_zzajc.zzaMN, i, false);
        zzc.zza(parcel, 7, com_google_android_gms_internal_zzajc.zzaMO, i, false);
        zzc.zza(parcel, 9, com_google_android_gms_internal_zzajc.zzaMP, i, false);
        zzc.zza(parcel, 10, com_google_android_gms_internal_zzajc.zzaMQ, i, false);
        zzc.zzJ(parcel, zzaV);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzcD(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzeZ(i);
    }

    public zzajc zzcD(Parcel parcel) {
        int i = 0;
        zzn com_google_android_gms_drive_events_zzn = null;
        int zzaU = zzb.zzaU(parcel);
        zzr com_google_android_gms_drive_events_zzr = null;
        com.google.android.gms.drive.events.zzb com_google_android_gms_drive_events_zzb = null;
        zzk com_google_android_gms_drive_events_zzk = null;
        CompletionEvent completionEvent = null;
        ChangeEvent changeEvent = null;
        int i2 = 0;
        while (parcel.dataPosition() < zzaU) {
            int zzaT = zzb.zzaT(parcel);
            switch (zzb.zzcW(zzaT)) {
                case MessageApi.FILTER_PREFIX /*1*/:
                    i2 = zzb.zzg(parcel, zzaT);
                    break;
                case ChannelListener.CLOSE_REASON_REMOTE_CLOSE /*2*/:
                    i = zzb.zzg(parcel, zzaT);
                    break;
                case ChannelListener.CLOSE_REASON_LOCAL_CLOSE /*3*/:
                    changeEvent = (ChangeEvent) zzb.zza(parcel, zzaT, ChangeEvent.CREATOR);
                    break;
                case Dimension.UNIT_MM /*5*/:
                    completionEvent = (CompletionEvent) zzb.zza(parcel, zzaT, CompletionEvent.CREATOR);
                    break;
                case BuyButtonText.LOGO_ONLY /*6*/:
                    com_google_android_gms_drive_events_zzk = (zzk) zzb.zza(parcel, zzaT, zzk.CREATOR);
                    break;
                case BuyButtonText.DONATE_WITH /*7*/:
                    com_google_android_gms_drive_events_zzb = (com.google.android.gms.drive.events.zzb) zzb.zza(parcel, zzaT, com.google.android.gms.drive.events.zzb.CREATOR);
                    break;
                case HTTP.HT /*9*/:
                    com_google_android_gms_drive_events_zzr = (zzr) zzb.zza(parcel, zzaT, zzr.CREATOR);
                    break;
                case HTTP.LF /*10*/:
                    com_google_android_gms_drive_events_zzn = (zzn) zzb.zza(parcel, zzaT, zzn.CREATOR);
                    break;
                default:
                    zzb.zzb(parcel, zzaT);
                    break;
            }
        }
        if (parcel.dataPosition() == zzaU) {
            return new zzajc(i2, i, changeEvent, completionEvent, com_google_android_gms_drive_events_zzk, com_google_android_gms_drive_events_zzb, com_google_android_gms_drive_events_zzr, com_google_android_gms_drive_events_zzn);
        }
        throw new zza("Overread allowed size end=" + zzaU, parcel);
    }

    public zzajc[] zzeZ(int i) {
        return new zzajc[i];
    }
}
