package com.google.android.gms.instantapps;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;

@Deprecated
public class LaunchSettings extends zza {
    public static final Creator<LaunchSettings> CREATOR;
    private final int versionCode;

    static {
        CREATOR = new zzb();
    }

    public LaunchSettings() {
        this.versionCode = 1;
    }

    LaunchSettings(int i) {
        this.versionCode = i;
    }

    public int getVersionCode() {
        return this.versionCode;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzb.zza(this, parcel, i);
    }
}
