package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.zzaa;
import com.google.android.gms.internal.zzaoo;
import java.util.List;

public class zzar extends zza {
    public static final Creator<zzar> CREATOR;
    private final int versionCode;
    private final zzaoo zzaVI;
    private final List<zzj> zzaVJ;
    private final boolean zzaVK;
    private final boolean zzaVL;

    static {
        CREATOR = new zzas();
    }

    zzar(int i, IBinder iBinder, List<zzj> list, boolean z, boolean z2) {
        this.versionCode = i;
        this.zzaVI = zzaoo.zza.zzcF(iBinder);
        this.zzaVJ = list;
        this.zzaVK = z;
        this.zzaVL = z2;
    }

    public IBinder getCallbackBinder() {
        return this.zzaVI != null ? this.zzaVI.asBinder() : null;
    }

    int getVersionCode() {
        return this.versionCode;
    }

    public String toString() {
        return zzaa.zzv(this).zzg("params", this.zzaVJ).zzg("server", Boolean.valueOf(this.zzaVL)).zzg("flush", Boolean.valueOf(this.zzaVK)).toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzas.zza(this, parcel, i);
    }

    public boolean zzCd() {
        return this.zzaVL;
    }

    public boolean zzCe() {
        return this.zzaVK;
    }

    public List<zzj> zzCo() {
        return this.zzaVJ;
    }
}
