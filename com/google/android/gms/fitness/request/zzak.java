package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.internal.zzapg;

public class zzak extends zza {
    public static final Creator<zzak> CREATOR;
    private final int mVersionCode;
    private final zzapg zzaVB;

    static {
        CREATOR = new zzal();
    }

    zzak(int i, IBinder iBinder) {
        this.mVersionCode = i;
        this.zzaVB = zzapg.zza.zzcM(iBinder);
    }

    public zzak(zzapg com_google_android_gms_internal_zzapg) {
        this.mVersionCode = 2;
        this.zzaVB = com_google_android_gms_internal_zzapg;
    }

    public IBinder getCallbackBinder() {
        return this.zzaVB.asBinder();
    }

    int getVersionCode() {
        return this.mVersionCode;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzal.zza(this, parcel, i);
    }
}
