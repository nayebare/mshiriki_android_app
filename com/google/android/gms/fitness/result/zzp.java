package com.google.android.gms.fitness.result;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.safeparcel.zza;
import java.io.Closeable;
import java.util.Collections;
import java.util.List;

public class zzp extends zza implements Result, Closeable {
    public static final Creator<zzp> CREATOR;
    private final int mVersionCode;
    private final List<DataHolder> zzaWA;
    private final DataHolder zzazI;

    static {
        CREATOR = new zzq();
    }

    zzp(int i, DataHolder dataHolder, List<DataHolder> list) {
        List singletonList;
        this.mVersionCode = i;
        this.zzazI = dataHolder;
        if (list == null) {
            singletonList = Collections.singletonList(dataHolder);
        }
        this.zzaWA = singletonList;
    }

    public void close() {
        if (this.zzazI != null) {
            this.zzazI.close();
        }
        for (DataHolder close : this.zzaWA) {
            close.close();
        }
    }

    public Status getStatus() {
        return new Status(this.zzazI.getStatusCode());
    }

    int getVersionCode() {
        return this.mVersionCode;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzq.zza(this, parcel, i);
    }

    DataHolder zzAb() {
        return this.zzazI;
    }

    public List<DataHolder> zzCI() {
        return this.zzaWA;
    }
}
