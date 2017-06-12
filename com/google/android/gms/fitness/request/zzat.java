package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.internal.zzaop;
import java.util.List;

public class zzat extends zza {
    public static final Creator<zzat> CREATOR;
    private final int mVersionCode;
    private final List<DataSource> zzaUV;
    private final zzaop zzaVM;

    static {
        CREATOR = new zzau();
    }

    zzat(int i, IBinder iBinder, List<DataSource> list) {
        this.mVersionCode = i;
        this.zzaVM = zzaop.zza.zzcG(iBinder);
        this.zzaUV = list;
    }

    public IBinder getCallbackBinder() {
        return this.zzaVM.asBinder();
    }

    public List<DataSource> getDataSources() {
        return this.zzaUV;
    }

    int getVersionCode() {
        return this.mVersionCode;
    }

    public String toString() {
        return String.format("ReadStatsRequest", new Object[0]);
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzau.zza(this, parcel, i);
    }
}
