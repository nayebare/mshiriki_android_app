package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;

public class zzaqj extends zza {
    public static final Creator<zzaqj> CREATOR;
    private final String title;
    public final int version;
    private final String zzbhT;

    static {
        CREATOR = new zzaqk();
    }

    zzaqj(int i, String str, String str2) {
        this.version = i;
        this.title = str;
        this.zzbhT = str2;
    }

    public String getImageUrl() {
        return this.zzbhT;
    }

    public String getTitle() {
        return this.title;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzaqk.zza(this, parcel, i);
    }
}
