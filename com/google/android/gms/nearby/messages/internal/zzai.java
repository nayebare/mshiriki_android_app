package com.google.android.gms.nearby.messages.internal;

import android.app.PendingIntent;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.annotation.VisibleForTesting;
import com.google.android.gms.common.internal.safeparcel.zza;

public final class zzai extends zza {
    public static final Creator<zzai> CREATOR;
    final int mVersionCode;
    public final PendingIntent zzaIj;
    @Deprecated
    public final String zzbxx;
    @Deprecated
    public final boolean zzbxy;
    @Deprecated
    public final ClientAppContext zzbyA;
    @Deprecated
    public final String zzbyv;
    public final zzn zzbyz;
    public final zzm zzbzd;
    public final int zzbzf;

    static {
        CREATOR = new zzaj();
    }

    zzai(int i, IBinder iBinder, IBinder iBinder2, PendingIntent pendingIntent, int i2, String str, String str2, boolean z, ClientAppContext clientAppContext) {
        this.mVersionCode = i;
        this.zzbzd = zzm.zza.zzeC(iBinder);
        this.zzbyz = zzn.zza.zzeD(iBinder2);
        this.zzaIj = pendingIntent;
        this.zzbzf = i2;
        this.zzbxx = str;
        this.zzbyv = str2;
        this.zzbxy = z;
        this.zzbyA = ClientAppContext.zza(clientAppContext, str2, str, z);
    }

    @VisibleForTesting
    public zzai(IBinder iBinder, IBinder iBinder2, PendingIntent pendingIntent, int i) {
        this(1, iBinder, iBinder2, pendingIntent, i, null, null, false, null);
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzaj.zza(this, parcel, i);
    }

    IBinder zzNi() {
        return this.zzbyz.asBinder();
    }

    IBinder zzNo() {
        return this.zzbzd == null ? null : this.zzbzd.asBinder();
    }
}
