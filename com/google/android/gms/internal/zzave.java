package com.google.android.gms.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.zzac;

public class zzave extends zza {
    public static final Creator<zzave> CREATOR;
    final int versionCode;
    private final zzaup zzbwO;
    private final byte zzbwR;
    private final zzaur zzbwS;

    static {
        CREATOR = new zzavf();
    }

    zzave(int i, byte b, IBinder iBinder, IBinder iBinder2) {
        this.versionCode = i;
        this.zzbwR = b;
        zzac.zzw(iBinder);
        this.zzbwS = zzaur.zza.zzey(iBinder);
        zzac.zzw(iBinder2);
        this.zzbwO = zzaup.zza.zzew(iBinder2);
    }

    public IBinder getCallbackBinder() {
        return this.zzbwO == null ? null : this.zzbwO.asBinder();
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzavf.zza(this, parcel, i);
    }

    public byte zzMP() {
        return this.zzbwR;
    }

    public IBinder zzMS() {
        return this.zzbwS == null ? null : this.zzbwS.asBinder();
    }
}
