package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.zzaa;
import com.google.android.gms.internal.zzaor;

public class zzbf extends zza {
    public static final Creator<zzbf> CREATOR;
    private final String mName;
    private final int mVersionCode;
    private final String zzaTJ;
    private final zzaor zzaWh;

    static {
        CREATOR = new zzbg();
    }

    zzbf(int i, String str, String str2, IBinder iBinder) {
        this.mVersionCode = i;
        this.mName = str;
        this.zzaTJ = str2;
        this.zzaWh = zzaor.zza.zzcI(iBinder);
    }

    public zzbf(String str, String str2, zzaor com_google_android_gms_internal_zzaor) {
        this.mVersionCode = 3;
        this.mName = str;
        this.zzaTJ = str2;
        this.zzaWh = com_google_android_gms_internal_zzaor;
    }

    private boolean zzb(zzbf com_google_android_gms_fitness_request_zzbf) {
        return zzaa.equal(this.mName, com_google_android_gms_fitness_request_zzbf.mName) && zzaa.equal(this.zzaTJ, com_google_android_gms_fitness_request_zzbf.zzaTJ);
    }

    public boolean equals(Object obj) {
        return obj == this || ((obj instanceof zzbf) && zzb((zzbf) obj));
    }

    public IBinder getCallbackBinder() {
        return this.zzaWh == null ? null : this.zzaWh.asBinder();
    }

    public String getIdentifier() {
        return this.zzaTJ;
    }

    public String getName() {
        return this.mName;
    }

    int getVersionCode() {
        return this.mVersionCode;
    }

    public int hashCode() {
        return zzaa.hashCode(this.mName, this.zzaTJ);
    }

    public String toString() {
        return zzaa.zzv(this).zzg("name", this.mName).zzg("identifier", this.zzaTJ).toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzbg.zza(this, parcel, i);
    }
}
