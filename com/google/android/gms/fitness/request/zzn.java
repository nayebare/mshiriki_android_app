package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.zzaa;
import com.google.android.gms.internal.zzaob;

public class zzn extends zza {
    public static final Creator<zzn> CREATOR;
    private final String mName;
    private final int mVersionCode;
    private final zzaob zzaVs;

    static {
        CREATOR = new zzo();
    }

    zzn(int i, String str, IBinder iBinder) {
        this.mVersionCode = i;
        this.mName = str;
        this.zzaVs = zzaob.zza.zzcs(iBinder);
    }

    public zzn(String str, zzaob com_google_android_gms_internal_zzaob) {
        this.mVersionCode = 3;
        this.mName = str;
        this.zzaVs = com_google_android_gms_internal_zzaob;
    }

    private boolean zzb(zzn com_google_android_gms_fitness_request_zzn) {
        return zzaa.equal(this.mName, com_google_android_gms_fitness_request_zzn.mName);
    }

    public boolean equals(Object obj) {
        return obj == this || ((obj instanceof zzn) && zzb((zzn) obj));
    }

    public IBinder getCallbackBinder() {
        return this.zzaVs.asBinder();
    }

    public String getName() {
        return this.mName;
    }

    int getVersionCode() {
        return this.mVersionCode;
    }

    public int hashCode() {
        return zzaa.hashCode(this.mName);
    }

    public String toString() {
        return zzaa.zzv(this).zzg("name", this.mName).toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzo.zza(this, parcel, i);
    }
}
