package com.google.android.gms.fitness.result;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.zza;
import java.util.List;
import java.util.Locale;

public class zzg extends zza implements Result {
    public static final Creator<zzg> CREATOR;
    private final int versionCode;
    private final List<zzd> zzaWw;
    private final Status zzagv;

    static {
        CREATOR = new zzh();
    }

    zzg(int i, Status status, List<zzd> list) {
        this.versionCode = i;
        this.zzagv = status;
        this.zzaWw = list;
    }

    public Status getStatus() {
        return this.zzagv;
    }

    int getVersionCode() {
        return this.versionCode;
    }

    public String toString() {
        return String.format(Locale.getDefault(), "DataStatsResult{%s %d sources}", new Object[]{this.zzagv, Integer.valueOf(this.zzaWw.size())});
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzh.zza(this, parcel, i);
    }

    List<zzd> zzCG() {
        return this.zzaWw;
    }
}
