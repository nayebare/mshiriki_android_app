package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;

public class zzadb extends zza {
    public static final Creator<zzadb> CREATOR;
    private final String mName;
    private final String mValue;
    private final int mVersionCode;

    static {
        CREATOR = new zzadc();
    }

    zzadb(int i, String str, String str2) {
        this.mVersionCode = i;
        this.mName = str;
        this.mValue = str2;
    }

    public zzadb(String str, String str2) {
        this(1, str, str2);
    }

    public String getName() {
        return this.mName;
    }

    public String getValue() {
        return this.mValue;
    }

    public int getVersionCode() {
        return this.mVersionCode;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzadc.zza(this, parcel, i);
    }
}
