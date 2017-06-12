package com.google.android.gms.drive;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.zzac;

public abstract class zzr extends zza {
    private volatile transient boolean zzaKf;

    public zzr() {
        this.zzaKf = false;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzac.zzar(!zzzX());
        this.zzaKf = true;
        zzK(parcel, i);
    }

    protected abstract void zzK(Parcel parcel, int i);

    public final boolean zzzX() {
        return this.zzaKf;
    }
}
