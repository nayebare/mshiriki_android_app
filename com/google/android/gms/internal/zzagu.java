package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.zzac;
import com.google.android.gms.drive.DriveFile;

public class zzagu extends zza {
    public static final Creator<zzagu> CREATOR;
    final int mVersionCode;
    final int zzaJi;

    static {
        CREATOR = new zzagv();
    }

    public zzagu(int i) {
        this(1, i);
    }

    zzagu(int i, int i2) {
        this.mVersionCode = i;
        boolean z = i2 == DriveFile.MODE_WRITE_ONLY || i2 == DriveFile.MODE_READ_WRITE;
        zzac.zzb(z, (Object) "Cannot create a new read-only contents!");
        this.zzaJi = i2;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzagv.zza(this, parcel, i);
    }
}
