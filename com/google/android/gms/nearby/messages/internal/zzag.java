package com.google.android.gms.nearby.messages.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;

public final class zzag extends zza {
    public static final Creator<zzag> CREATOR;
    final int mVersionCode;
    @Deprecated
    public final String zzbxx;
    @Deprecated
    public final boolean zzbxy;
    @Deprecated
    public final ClientAppContext zzbyA;
    public final zzv zzbyX;
    @Deprecated
    public final String zzbyv;
    public final zzn zzbyz;

    static {
        CREATOR = new zzah();
    }

    zzag(int i, zzv com_google_android_gms_nearby_messages_internal_zzv, IBinder iBinder, String str, String str2, boolean z, ClientAppContext clientAppContext) {
        this.mVersionCode = i;
        this.zzbyX = com_google_android_gms_nearby_messages_internal_zzv;
        this.zzbyz = zzn.zza.zzeD(iBinder);
        this.zzbxx = str;
        this.zzbyv = str2;
        this.zzbxy = z;
        this.zzbyA = ClientAppContext.zza(clientAppContext, str2, str, z);
    }

    zzag(zzv com_google_android_gms_nearby_messages_internal_zzv, IBinder iBinder, ClientAppContext clientAppContext) {
        this(1, com_google_android_gms_nearby_messages_internal_zzv, iBinder, null, null, false, clientAppContext);
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzah.zza(this, parcel, i);
    }

    IBinder zzNi() {
        return this.zzbyz.asBinder();
    }
}
