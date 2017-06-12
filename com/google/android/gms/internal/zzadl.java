package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.safeparcel.zza;

public class zzadl extends zza {
    public static final Creator<zzadl> CREATOR;
    private final int mVersionCode;
    private final DataHolder zzaHE;
    private final long zzaHx;
    private final int zzauz;

    static {
        CREATOR = new zzadm();
    }

    zzadl(int i, int i2, DataHolder dataHolder, long j) {
        this.mVersionCode = i;
        this.zzauz = i2;
        this.zzaHE = dataHolder;
        this.zzaHx = j;
    }

    public int getStatusCode() {
        return this.zzauz;
    }

    public long getThrottleEndTimeMillis() {
        return this.zzaHx;
    }

    public int getVersionCode() {
        return this.mVersionCode;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzadm.zza(this, parcel, i);
    }

    public DataHolder zzzb() {
        return this.zzaHE;
    }

    public void zzzc() {
        if (this.zzaHE != null && !this.zzaHE.isClosed()) {
            this.zzaHE.close();
        }
    }
}
