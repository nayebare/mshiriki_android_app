package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;

public class zzard extends zza {
    public static final Creator<zzard> CREATOR;
    private final String packageName;
    public final int version;

    static {
        CREATOR = new zzare();
    }

    zzard(int i, String str) {
        this.version = i;
        this.packageName = str;
    }

    public String getPackageName() {
        return this.packageName;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzare.zza(this, parcel, i);
    }
}
