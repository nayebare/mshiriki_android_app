package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.common.internal.safeparcel.zzb.zza;
import com.google.android.gms.common.internal.safeparcel.zzc;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.events.zze;
import com.google.android.gms.drive.events.zzp;
import com.google.android.gms.drive.events.zzu;
import com.google.android.gms.wallet.fragment.WalletFragmentStyle.BuyButtonText;
import com.google.android.gms.wallet.fragment.WalletFragmentStyle.Dimension;
import com.google.android.gms.wearable.ChannelApi.ChannelListener;
import com.google.android.gms.wearable.MessageApi;

public class zzagc implements Creator<zzagb> {
    static void zza(zzagb com_google_android_gms_internal_zzagb, Parcel parcel, int i) {
        int zzaV = zzc.zzaV(parcel);
        zzc.zzc(parcel, 1, com_google_android_gms_internal_zzagb.mVersionCode);
        zzc.zza(parcel, 2, com_google_android_gms_internal_zzagb.zzaJj, i, false);
        zzc.zzc(parcel, 3, com_google_android_gms_internal_zzagb.zzaGv);
        zzc.zza(parcel, 4, com_google_android_gms_internal_zzagb.zzaKh, i, false);
        zzc.zza(parcel, 5, com_google_android_gms_internal_zzagb.zzaKH, i, false);
        zzc.zza(parcel, 6, com_google_android_gms_internal_zzagb.zzaKI, i, false);
        zzc.zzJ(parcel, zzaV);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzbZ(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzeq(i);
    }

    public zzagb zzbZ(Parcel parcel) {
        int i = 0;
        zzp com_google_android_gms_drive_events_zzp = null;
        int zzaU = zzb.zzaU(parcel);
        zzu com_google_android_gms_drive_events_zzu = null;
        zze com_google_android_gms_drive_events_zze = null;
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
                    i = zzb.zzg(parcel, zzaT);
                    break;
                case Dimension.UNIT_IN /*4*/:
                    com_google_android_gms_drive_events_zze = (zze) zzb.zza(parcel, zzaT, zze.CREATOR);
                    break;
                case Dimension.UNIT_MM /*5*/:
                    com_google_android_gms_drive_events_zzu = (zzu) zzb.zza(parcel, zzaT, zzu.CREATOR);
                    break;
                case BuyButtonText.LOGO_ONLY /*6*/:
                    com_google_android_gms_drive_events_zzp = (zzp) zzb.zza(parcel, zzaT, zzp.CREATOR);
                    break;
                default:
                    zzb.zzb(parcel, zzaT);
                    break;
            }
        }
        if (parcel.dataPosition() == zzaU) {
            return new zzagb(i2, driveId, i, com_google_android_gms_drive_events_zze, com_google_android_gms_drive_events_zzu, com_google_android_gms_drive_events_zzp);
        }
        throw new zza("Overread allowed size end=" + zzaU, parcel);
    }

    public zzagb[] zzeq(int i) {
        return new zzagb[i];
    }
}
