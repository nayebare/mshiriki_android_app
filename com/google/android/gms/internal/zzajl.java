package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;

public class zzajl extends zza {
    public static final Creator<zzajl> CREATOR;
    final int mVersionCode;
    final MetadataBundle zzaLf;

    static {
        CREATOR = new zzajm();
    }

    zzajl(int i, MetadataBundle metadataBundle) {
        this.mVersionCode = i;
        this.zzaLf = metadataBundle;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzajm.zza(this, parcel, i);
    }

    public MetadataBundle zzAx() {
        return this.zzaLf;
    }
}
