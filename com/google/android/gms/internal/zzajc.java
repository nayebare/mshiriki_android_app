package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.drive.events.ChangeEvent;
import com.google.android.gms.drive.events.CompletionEvent;
import com.google.android.gms.drive.events.DriveEvent;
import com.google.android.gms.drive.events.zzb;
import com.google.android.gms.drive.events.zzk;
import com.google.android.gms.drive.events.zzn;
import com.google.android.gms.drive.events.zzr;
import com.google.android.gms.games.request.Requests;
import com.google.android.gms.wallet.fragment.WalletFragmentStyle.BuyButtonText;
import com.google.android.gms.wallet.fragment.WalletFragmentStyle.Dimension;
import com.google.android.gms.wearable.ChannelApi.ChannelListener;
import com.google.android.gms.wearable.MessageApi;

public class zzajc extends zza {
    public static final Creator<zzajc> CREATOR;
    final int mVersionCode;
    final int zzaGv;
    final ChangeEvent zzaML;
    final CompletionEvent zzaMM;
    final zzk zzaMN;
    final zzb zzaMO;
    final zzr zzaMP;
    final zzn zzaMQ;

    static {
        CREATOR = new zzajd();
    }

    zzajc(int i, int i2, ChangeEvent changeEvent, CompletionEvent completionEvent, zzk com_google_android_gms_drive_events_zzk, zzb com_google_android_gms_drive_events_zzb, zzr com_google_android_gms_drive_events_zzr, zzn com_google_android_gms_drive_events_zzn) {
        this.mVersionCode = i;
        this.zzaGv = i2;
        this.zzaML = changeEvent;
        this.zzaMM = completionEvent;
        this.zzaMN = com_google_android_gms_drive_events_zzk;
        this.zzaMO = com_google_android_gms_drive_events_zzb;
        this.zzaMP = com_google_android_gms_drive_events_zzr;
        this.zzaMQ = com_google_android_gms_drive_events_zzn;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzajd.zza(this, parcel, i);
    }

    public DriveEvent zzAt() {
        switch (this.zzaGv) {
            case MessageApi.FILTER_PREFIX /*1*/:
                return this.zzaML;
            case ChannelListener.CLOSE_REASON_REMOTE_CLOSE /*2*/:
                return this.zzaMM;
            case ChannelListener.CLOSE_REASON_LOCAL_CLOSE /*3*/:
                return this.zzaMN;
            case Dimension.UNIT_IN /*4*/:
                return this.zzaMO;
            case BuyButtonText.DONATE_WITH /*7*/:
                return this.zzaMP;
            case Requests.MAX_REQUEST_RECIPIENTS /*8*/:
                return this.zzaMQ;
            default:
                throw new IllegalStateException("Unexpected event type " + this.zzaGv);
        }
    }
}
