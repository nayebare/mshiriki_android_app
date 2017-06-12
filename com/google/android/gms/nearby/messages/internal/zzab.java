package com.google.android.gms.nearby.messages.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.nearby.messages.Strategy;

public final class zzab extends zza {
    public static final Creator<zzab> CREATOR;
    final int mVersionCode;
    @Deprecated
    public final String zzbxx;
    @Deprecated
    public final boolean zzbxy;
    @Deprecated
    public final ClientAppContext zzbyA;
    public final zzv zzbyX;
    public final Strategy zzbyY;
    @Deprecated
    public final boolean zzbyZ;
    @Deprecated
    public final String zzbyv;
    public final zzn zzbyz;
    public final zzp zzbza;

    static {
        CREATOR = new zzac();
    }

    zzab(int i, zzv com_google_android_gms_nearby_messages_internal_zzv, Strategy strategy, IBinder iBinder, String str, String str2, boolean z, IBinder iBinder2, boolean z2, ClientAppContext clientAppContext) {
        this.mVersionCode = i;
        this.zzbyX = com_google_android_gms_nearby_messages_internal_zzv;
        this.zzbyY = strategy;
        this.zzbyz = zzn.zza.zzeD(iBinder);
        this.zzbxx = str;
        this.zzbyv = str2;
        this.zzbyZ = z;
        this.zzbza = iBinder2 == null ? null : zzp.zza.zzeF(iBinder2);
        this.zzbxy = z2;
        this.zzbyA = ClientAppContext.zza(clientAppContext, str2, str, z2);
    }

    zzab(zzv com_google_android_gms_nearby_messages_internal_zzv, Strategy strategy, IBinder iBinder, IBinder iBinder2) {
        this(2, com_google_android_gms_nearby_messages_internal_zzv, strategy, iBinder, null, null, false, iBinder2, false, null);
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzac.zza(this, parcel, i);
    }

    IBinder zzNi() {
        return this.zzbyz.asBinder();
    }

    IBinder zzNm() {
        return this.zzbza == null ? null : this.zzbza.asBinder();
    }
}
