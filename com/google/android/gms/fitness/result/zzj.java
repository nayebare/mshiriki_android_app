package com.google.android.gms.fitness.result;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.zza;

public class zzj extends zza implements Result {
    public static final Creator<zzj> CREATOR;
    private final int versionCode;
    private final Bundle zzaWx;
    private final Status zzagv;

    static {
        CREATOR = new zzk();
    }

    zzj(int i, Status status, Bundle bundle) {
        this.versionCode = i;
        this.zzagv = status;
        this.zzaWx = bundle;
    }

    public Status getStatus() {
        return this.zzagv;
    }

    int getVersionCode() {
        return this.versionCode;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzk.zza(this, parcel, i);
    }

    Bundle zzCH() {
        return this.zzaWx;
    }
}
