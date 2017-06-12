package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.internal.zzaot;

public class zzad extends zza {
    public static final Creator<zzad> CREATOR;
    private final int mVersionCode;
    private final zzaot zzaVw;

    static {
        CREATOR = new zzae();
    }

    zzad(int i, IBinder iBinder) {
        this.mVersionCode = i;
        this.zzaVw = zzaot.zza.zzcK(iBinder);
    }

    public IBinder getCallbackBinder() {
        return this.zzaVw.asBinder();
    }

    int getVersionCode() {
        return this.mVersionCode;
    }

    public String toString() {
        return String.format("GetSyncInfoRequest {%d, %s}", new Object[]{Integer.valueOf(this.mVersionCode), this.zzaVw});
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzae.zza(this, parcel, i);
    }
}
