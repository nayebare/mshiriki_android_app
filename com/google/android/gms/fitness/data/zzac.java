package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.zzaa;

public class zzac extends zza {
    public static final Creator<zzac> CREATOR;
    final int mVersionCode;
    private final Session zzaQL;
    private final DataSet zzaTM;

    static {
        CREATOR = new zzad();
    }

    zzac(int i, Session session, DataSet dataSet) {
        this.mVersionCode = i;
        this.zzaQL = session;
        this.zzaTM = dataSet;
    }

    private boolean zza(zzac com_google_android_gms_fitness_data_zzac) {
        return zzaa.equal(this.zzaQL, com_google_android_gms_fitness_data_zzac.zzaQL) && zzaa.equal(this.zzaTM, com_google_android_gms_fitness_data_zzac.zzaTM);
    }

    public boolean equals(Object obj) {
        return obj == this || ((obj instanceof zzac) && zza((zzac) obj));
    }

    public DataSet getDataSet() {
        return this.zzaTM;
    }

    public Session getSession() {
        return this.zzaQL;
    }

    public int hashCode() {
        return zzaa.hashCode(this.zzaQL, this.zzaTM);
    }

    public String toString() {
        return zzaa.zzv(this).zzg("session", this.zzaQL).zzg("dataSet", this.zzaTM).toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzad.zza(this, parcel, i);
    }
}
