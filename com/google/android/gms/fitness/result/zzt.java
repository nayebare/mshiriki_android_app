package com.google.android.gms.fitness.result;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.zzaa;
import com.google.android.gms.games.Games;

public class zzt extends zza implements Result {
    public static final Creator<zzt> CREATOR;
    private final long timestamp;
    private final int versionCode;
    private final Boolean zzaWC;
    private final Status zzagv;

    static {
        CREATOR = new zzu();
    }

    zzt(int i, Status status, long j, Boolean bool) {
        this.versionCode = i;
        this.zzagv = status;
        this.timestamp = j;
        this.zzaWC = bool;
    }

    private boolean zzb(zzt com_google_android_gms_fitness_result_zzt) {
        return this.zzagv.equals(com_google_android_gms_fitness_result_zzt.zzagv) && zzaa.equal(Long.valueOf(this.timestamp), Long.valueOf(com_google_android_gms_fitness_result_zzt.timestamp));
    }

    public boolean equals(Object obj) {
        return this == obj || ((obj instanceof zzt) && zzb((zzt) obj));
    }

    public Status getStatus() {
        return this.zzagv;
    }

    int getVersionCode() {
        return this.versionCode;
    }

    public int hashCode() {
        return zzaa.hashCode(this.zzagv, Long.valueOf(this.timestamp));
    }

    public String toString() {
        return zzaa.zzv(this).zzg(Games.EXTRA_STATUS, this.zzagv).zzg("timestamp", Long.valueOf(this.timestamp)).zzg("syncEnabled", this.zzaWC).toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzu.zza(this, parcel, i);
    }

    public long zzCK() {
        return this.timestamp;
    }

    public Boolean zzCL() {
        return this.zzaWC;
    }
}
