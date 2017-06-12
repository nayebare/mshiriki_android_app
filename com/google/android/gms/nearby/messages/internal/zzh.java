package com.google.android.gms.nearby.messages.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;

@Deprecated
public class zzh extends zza {
    public static final Creator<zzh> CREATOR;
    final int mVersionCode;
    @Deprecated
    public final String zzbxx;
    @Deprecated
    public final ClientAppContext zzbyA;
    public final zzn zzbyz;

    static {
        CREATOR = new zzi();
    }

    zzh(int i, IBinder iBinder, String str, ClientAppContext clientAppContext) {
        this.mVersionCode = i;
        this.zzbyz = zzn.zza.zzeD(iBinder);
        this.zzbxx = str;
        this.zzbyA = ClientAppContext.zza(clientAppContext, null, str, false);
    }

    zzh(IBinder iBinder) {
        this(1, iBinder, null, null);
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzi.zza(this, parcel, i);
    }

    IBinder zzNi() {
        return this.zzbyz.asBinder();
    }
}
