package com.google.android.gms.cast.framework.media;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.dynamic.zze;
import com.google.android.gms.internal.zzyu;

public class CastMediaOptions extends zza {
    public static final Creator<CastMediaOptions> CREATOR;
    private static final zzyu zzaoQ;
    private final int mVersionCode;
    private final String zzaqH;
    private final String zzaqI;
    private final zzb zzaqJ;
    private final NotificationOptions zzaqK;

    public static final class Builder {
        private String zzaqH;
        private String zzaqI;
        private NotificationOptions zzaqK;
        private ImagePicker zzaqL;

        public Builder() {
            this.zzaqH = MediaIntentReceiver.class.getName();
            this.zzaqK = new com.google.android.gms.cast.framework.media.NotificationOptions.Builder().build();
        }

        public CastMediaOptions build() {
            return new CastMediaOptions(1, this.zzaqH, this.zzaqI, this.zzaqL == null ? null : this.zzaqL.zzsS().asBinder(), this.zzaqK);
        }

        public Builder setExpandedControllerActivityClassName(String str) {
            this.zzaqI = str;
            return this;
        }

        public Builder setImagePicker(ImagePicker imagePicker) {
            this.zzaqL = imagePicker;
            return this;
        }

        public Builder setMediaIntentReceiverClassName(String str) {
            this.zzaqH = str;
            return this;
        }

        public Builder setNotificationOptions(NotificationOptions notificationOptions) {
            this.zzaqK = notificationOptions;
            return this;
        }
    }

    static {
        zzaoQ = new zzyu("CastMediaOptions");
        CREATOR = new zza();
    }

    CastMediaOptions(int i, String str, String str2, IBinder iBinder, NotificationOptions notificationOptions) {
        this.mVersionCode = i;
        this.zzaqH = str;
        this.zzaqI = str2;
        this.zzaqJ = zzb.zza.zzbc(iBinder);
        this.zzaqK = notificationOptions;
    }

    public String getExpandedControllerActivityClassName() {
        return this.zzaqI;
    }

    public ImagePicker getImagePicker() {
        if (this.zzaqJ != null) {
            try {
                return (ImagePicker) zze.zzE(this.zzaqJ.zzsR());
            } catch (Throwable e) {
                zzaoQ.zzb(e, "Unable to call %s on %s.", "getWrappedClientObject", zzb.class.getSimpleName());
            }
        }
        return null;
    }

    public String getMediaIntentReceiverClassName() {
        return this.zzaqH;
    }

    public NotificationOptions getNotificationOptions() {
        return this.zzaqK;
    }

    int getVersionCode() {
        return this.mVersionCode;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zza.zza(this, parcel, i);
    }

    public IBinder zzsQ() {
        return this.zzaqJ == null ? null : this.zzaqJ.asBinder();
    }
}
