package com.google.android.gms.nearby.messages.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;

public final class zzad extends zza {
    public static final Creator<zzad> CREATOR;
    final int versionCode;
    @Deprecated
    public String zzbxx;
    @Deprecated
    public final ClientAppContext zzbyA;
    public final zzn zzbyz;
    public final zzq zzbzb;
    public boolean zzbzc;

    static {
        CREATOR = new zzae();
    }

    zzad(int i, IBinder iBinder, IBinder iBinder2, boolean z, String str, ClientAppContext clientAppContext) {
        this.versionCode = i;
        this.zzbyz = zzn.zza.zzeD(iBinder);
        this.zzbzb = zzq.zza.zzeG(iBinder2);
        this.zzbzc = z;
        this.zzbxx = str;
        this.zzbyA = ClientAppContext.zza(clientAppContext, null, str, false);
    }

    zzad(IBinder iBinder, IBinder iBinder2) {
        this(1, iBinder, iBinder2, false, null, null);
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzae.zza(this, parcel, i);
    }

    IBinder zzNi() {
        return this.zzbyz.asBinder();
    }

    IBinder zzNn() {
        return this.zzbzb.asBinder();
    }
}
