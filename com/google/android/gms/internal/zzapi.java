package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.zzaa;
import com.google.android.gms.fitness.data.DataType;
import java.util.Collections;
import java.util.List;

public class zzapi extends zza {
    public static final Creator<zzapi> CREATOR;
    private final int mVersionCode;
    private final List<DataType> zzaQU;

    static {
        CREATOR = new zzapj();
    }

    zzapi(int i, List<DataType> list) {
        this.mVersionCode = i;
        this.zzaQU = list;
    }

    public List<DataType> getDataTypes() {
        return Collections.unmodifiableList(this.zzaQU);
    }

    int getVersionCode() {
        return this.mVersionCode;
    }

    public String toString() {
        return zzaa.zzv(this).zzg("dataTypes", this.zzaQU).toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzapj.zza(this, parcel, i);
    }
}
