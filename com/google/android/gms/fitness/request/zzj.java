package com.google.android.gms.fitness.request;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.fitness.data.DataSource;

public class zzj extends zza {
    public static final Creator<zzj> CREATOR;
    final int versionCode;
    public final DataSource zzaRJ;
    public final long zzaTB;
    public final int zzaVe;
    public final long zzaVk;
    public final int zzaVl;
    public final long zzahs;

    static {
        CREATOR = new zzk();
    }

    zzj(int i, DataSource dataSource, long j, long j2, long j3, int i2, int i3) {
        this.versionCode = i;
        this.zzaRJ = dataSource;
        this.zzahs = j;
        this.zzaTB = j2;
        this.zzaVk = j3;
        this.zzaVe = i2;
        this.zzaVl = i3;
    }

    public String toString() {
        return String.format("{%1$s, %2$tF %2$tT - %3$tF %3$tT (%4$s %5$s)}", new Object[]{this.zzaRJ.toDebugString(), Long.valueOf(this.zzaTB / 1000000), Long.valueOf(this.zzaVk / 1000000), Integer.valueOf(this.zzaVe), Integer.valueOf(this.zzaVl)});
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzk.zza(this, parcel, i);
    }
}
