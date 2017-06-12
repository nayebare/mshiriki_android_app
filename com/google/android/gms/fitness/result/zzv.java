package com.google.android.gms.fitness.result;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.zzaa;
import com.google.android.gms.games.Games;

public class zzv extends zza implements Result {
    public static final Creator<zzv> CREATOR;
    private final int versionCode;
    private final long zzaWD;
    private final Status zzagv;

    static {
        CREATOR = new zzw();
    }

    zzv(int i, Status status, long j) {
        this.versionCode = i;
        this.zzagv = status;
        this.zzaWD = j;
    }

    private boolean zzb(zzv com_google_android_gms_fitness_result_zzv) {
        return this.zzagv.equals(com_google_android_gms_fitness_result_zzv.zzagv) && this.zzaWD == com_google_android_gms_fitness_result_zzv.zzaWD;
    }

    public boolean equals(Object obj) {
        return this == obj || ((obj instanceof zzv) && zzb((zzv) obj));
    }

    public Status getStatus() {
        return this.zzagv;
    }

    int getVersionCode() {
        return this.versionCode;
    }

    public int hashCode() {
        return zzaa.hashCode(this.zzagv, Long.valueOf(this.zzaWD));
    }

    public String toString() {
        return zzaa.zzv(this).zzg(Games.EXTRA_STATUS, this.zzagv).zzg("lastSuccessfulSyncTimeMillis", Long.valueOf(this.zzaWD)).toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzw.zza(this, parcel, i);
    }

    public long zzCM() {
        return this.zzaWD;
    }
}
