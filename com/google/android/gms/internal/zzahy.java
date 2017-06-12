package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.drive.FileUploadPreferences;
import com.google.android.gms.wearable.ChannelApi.ChannelListener;
import com.google.android.gms.wearable.MessageApi;

public final class zzahy extends zza implements FileUploadPreferences {
    public static final Creator<zzahy> CREATOR;
    final int mVersionCode;
    int zzaMm;
    int zzaMn;
    boolean zzaMo;

    static {
        CREATOR = new zzahz();
    }

    zzahy(int i, int i2, int i3, boolean z) {
        this.mVersionCode = i;
        this.zzaMm = i2;
        this.zzaMn = i3;
        this.zzaMo = z;
    }

    public static boolean zzeK(int i) {
        switch (i) {
            case MessageApi.FILTER_PREFIX /*1*/:
            case ChannelListener.CLOSE_REASON_REMOTE_CLOSE /*2*/:
                return true;
            default:
                return false;
        }
    }

    public static boolean zzeL(int i) {
        switch (i) {
            case FileUploadPreferences.BATTERY_USAGE_UNRESTRICTED /*256*/:
            case FileUploadPreferences.BATTERY_USAGE_CHARGING_ONLY /*257*/:
                return true;
            default:
                return false;
        }
    }

    public int getBatteryUsagePreference() {
        return !zzeL(this.zzaMn) ? 0 : this.zzaMn;
    }

    public int getNetworkTypePreference() {
        return !zzeK(this.zzaMm) ? 0 : this.zzaMm;
    }

    public boolean isRoamingAllowed() {
        return this.zzaMo;
    }

    public void setBatteryUsagePreference(int i) {
        if (zzeL(i)) {
            this.zzaMn = i;
            return;
        }
        throw new IllegalArgumentException("Invalid battery usage preference value.");
    }

    public void setNetworkTypePreference(int i) {
        if (zzeK(i)) {
            this.zzaMm = i;
            return;
        }
        throw new IllegalArgumentException("Invalid data connection preference value.");
    }

    public void setRoamingAllowed(boolean z) {
        this.zzaMo = z;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzahz.zza(this, parcel, i);
    }
}
