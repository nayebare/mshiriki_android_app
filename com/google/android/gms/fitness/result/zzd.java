package com.google.android.gms.fitness.result;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.fitness.data.DataSource;

public class zzd extends zza {
    public static final Creator<zzd> CREATOR;
    final int mVersionCode;
    public final DataSource zzaRJ;
    public final boolean zzaWs;
    public final long zzaWt;
    public final long zzaWu;
    public final long zzahs;

    static {
        CREATOR = new zze();
    }

    zzd(int i, DataSource dataSource, long j, boolean z, long j2, long j3) {
        this.mVersionCode = i;
        this.zzaRJ = dataSource;
        this.zzahs = j;
        this.zzaWs = z;
        this.zzaWt = j2;
        this.zzaWu = j3;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zze.zza(this, parcel, i);
    }
}
