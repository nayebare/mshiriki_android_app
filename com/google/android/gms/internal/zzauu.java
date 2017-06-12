package com.google.android.gms.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.zzac;

public class zzauu extends zza {
    public static final Creator<zzauu> CREATOR;
    final int versionCode;
    private final zzaup zzbwO;
    private final String zzbwP;

    static {
        CREATOR = new zzauv();
    }

    zzauu(int i, String str, IBinder iBinder) {
        this.versionCode = i;
        this.zzbwP = (String) zzac.zzw(str);
        this.zzbwO = zzaup.zza.zzew(iBinder);
    }

    public IBinder getCallbackBinder() {
        return this.zzbwO == null ? null : this.zzbwO.asBinder();
    }

    public String getToken() {
        return this.zzbwP;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzauv.zza(this, parcel, i);
    }
}
