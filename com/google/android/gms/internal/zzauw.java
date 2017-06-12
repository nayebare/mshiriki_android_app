package com.google.android.gms.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.zzac;

public class zzauw extends zza {
    public static final Creator<zzauw> CREATOR;
    final int versionCode;
    private final zzaup zzbwO;

    static {
        CREATOR = new zzaux();
    }

    zzauw(int i, IBinder iBinder) {
        this.versionCode = i;
        zzac.zzw(iBinder);
        this.zzbwO = zzaup.zza.zzew(iBinder);
    }

    public IBinder getCallbackBinder() {
        return this.zzbwO == null ? null : this.zzbwO.asBinder();
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzaux.zza(this, parcel, i);
    }
}
