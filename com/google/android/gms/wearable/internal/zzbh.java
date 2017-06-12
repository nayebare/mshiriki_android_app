package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.wearable.ConnectionConfiguration;

@Deprecated
public class zzbh extends zza {
    public static final Creator<zzbh> CREATOR;
    public final int statusCode;
    public final int versionCode;
    public final ConnectionConfiguration zzbSA;

    static {
        CREATOR = new zzbi();
    }

    zzbh(int i, int i2, ConnectionConfiguration connectionConfiguration) {
        this.versionCode = i;
        this.statusCode = i2;
        this.zzbSA = connectionConfiguration;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzbi.zza(this, parcel, i);
    }
}
