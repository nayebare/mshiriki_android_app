package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import java.util.List;

public class zzaks extends zza {
    public static final Creator<zzaks> CREATOR;
    private final int mVersionCode;
    private final List<String> zzaNd;

    static {
        CREATOR = new zzakt();
    }

    zzaks(int i, List<String> list) {
        this.mVersionCode = i;
        this.zzaNd = list;
    }

    public int getVersionCode() {
        return this.mVersionCode;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzakt.zza(this, parcel, i);
    }

    public List<String> zzAy() {
        return this.zzaNd;
    }
}
