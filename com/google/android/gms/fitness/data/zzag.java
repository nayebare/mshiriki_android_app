package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.wearable.ChannelApi.ChannelListener;
import com.google.android.gms.wearable.MessageApi;

public class zzag extends zza {
    public static final Creator<zzag> CREATOR;
    private final int status;
    private final int versionCode;

    static {
        CREATOR = new zzah();
    }

    zzag(int i, int i2) {
        this.versionCode = i;
        this.status = i2;
    }

    private boolean zza(zzag com_google_android_gms_fitness_data_zzag) {
        return this.status == com_google_android_gms_fitness_data_zzag.status;
    }

    private static String zzgR(int i) {
        switch (i) {
            case MessageApi.FILTER_LITERAL /*0*/:
                return "skipped";
            case MessageApi.FILTER_PREFIX /*1*/:
                return "started";
            case ChannelListener.CLOSE_REASON_REMOTE_CLOSE /*2*/:
                return "completed";
            case ChannelListener.CLOSE_REASON_LOCAL_CLOSE /*3*/:
                return "failed";
            default:
                return "invalid";
        }
    }

    public boolean equals(Object obj) {
        return obj == this || ((obj instanceof zzag) && zza((zzag) obj));
    }

    public int getStatus() {
        return this.status;
    }

    int getVersionCode() {
        return this.versionCode;
    }

    public int hashCode() {
        return this.status;
    }

    public String toString() {
        return zzgR(this.status);
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzah.zza(this, parcel, i);
    }
}
