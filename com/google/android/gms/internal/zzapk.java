package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.fitness.data.DataSource;

public class zzapk extends zza {
    public static final Creator<zzapk> CREATOR;
    private final int mVersionCode;
    private final DataSource zzaRJ;

    static {
        CREATOR = new zzapl();
    }

    zzapk(int i, DataSource dataSource) {
        this.mVersionCode = i;
        this.zzaRJ = dataSource;
    }

    public DataSource getDataSource() {
        return this.zzaRJ;
    }

    int getVersionCode() {
        return this.mVersionCode;
    }

    public String toString() {
        return String.format("ApplicationUnregistrationRequest{%s}", new Object[]{this.zzaRJ});
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzapl.zza(this, parcel, i);
    }
}
