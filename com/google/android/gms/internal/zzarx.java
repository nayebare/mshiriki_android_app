package com.google.android.gms.internal;

import android.app.PendingIntent;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.annotation.Nullable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.location.zzl;
import com.google.android.gms.location.zzm;

public class zzarx extends zza {
    public static final Creator<zzarx> CREATOR;
    PendingIntent mPendingIntent;
    private final int mVersionCode;
    int zzbkr;
    zzarv zzbks;
    zzm zzbkt;
    zzl zzbku;
    zzarp zzbkv;

    static {
        CREATOR = new zzary();
    }

    zzarx(int i, int i2, zzarv com_google_android_gms_internal_zzarv, IBinder iBinder, PendingIntent pendingIntent, IBinder iBinder2, IBinder iBinder3) {
        zzarp com_google_android_gms_internal_zzarp = null;
        this.mVersionCode = i;
        this.zzbkr = i2;
        this.zzbks = com_google_android_gms_internal_zzarv;
        this.zzbkt = iBinder == null ? null : zzm.zza.zzde(iBinder);
        this.mPendingIntent = pendingIntent;
        this.zzbku = iBinder2 == null ? null : zzl.zza.zzdd(iBinder2);
        if (iBinder3 != null) {
            com_google_android_gms_internal_zzarp = zzarp.zza.zzdg(iBinder3);
        }
        this.zzbkv = com_google_android_gms_internal_zzarp;
    }

    public static zzarx zza(zzarv com_google_android_gms_internal_zzarv, PendingIntent pendingIntent, @Nullable zzarp com_google_android_gms_internal_zzarp) {
        return new zzarx(1, 1, com_google_android_gms_internal_zzarv, null, pendingIntent, null, com_google_android_gms_internal_zzarp != null ? com_google_android_gms_internal_zzarp.asBinder() : null);
    }

    public static zzarx zza(zzarv com_google_android_gms_internal_zzarv, zzl com_google_android_gms_location_zzl, @Nullable zzarp com_google_android_gms_internal_zzarp) {
        return new zzarx(1, 1, com_google_android_gms_internal_zzarv, null, null, com_google_android_gms_location_zzl.asBinder(), com_google_android_gms_internal_zzarp != null ? com_google_android_gms_internal_zzarp.asBinder() : null);
    }

    public static zzarx zza(zzarv com_google_android_gms_internal_zzarv, zzm com_google_android_gms_location_zzm, @Nullable zzarp com_google_android_gms_internal_zzarp) {
        return new zzarx(1, 1, com_google_android_gms_internal_zzarv, com_google_android_gms_location_zzm.asBinder(), null, null, com_google_android_gms_internal_zzarp != null ? com_google_android_gms_internal_zzarp.asBinder() : null);
    }

    public static zzarx zza(zzl com_google_android_gms_location_zzl, @Nullable zzarp com_google_android_gms_internal_zzarp) {
        return new zzarx(1, 2, null, null, null, com_google_android_gms_location_zzl.asBinder(), com_google_android_gms_internal_zzarp != null ? com_google_android_gms_internal_zzarp.asBinder() : null);
    }

    public static zzarx zza(zzm com_google_android_gms_location_zzm, @Nullable zzarp com_google_android_gms_internal_zzarp) {
        return new zzarx(1, 2, null, com_google_android_gms_location_zzm.asBinder(), null, null, com_google_android_gms_internal_zzarp != null ? com_google_android_gms_internal_zzarp.asBinder() : null);
    }

    public static zzarx zzb(PendingIntent pendingIntent, @Nullable zzarp com_google_android_gms_internal_zzarp) {
        return new zzarx(1, 2, null, null, pendingIntent, null, com_google_android_gms_internal_zzarp != null ? com_google_android_gms_internal_zzarp.asBinder() : null);
    }

    int getVersionCode() {
        return this.mVersionCode;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzary.zza(this, parcel, i);
    }

    IBinder zzHD() {
        return this.zzbkt == null ? null : this.zzbkt.asBinder();
    }

    IBinder zzHE() {
        return this.zzbku == null ? null : this.zzbku.asBinder();
    }

    IBinder zzHF() {
        return this.zzbkv == null ? null : this.zzbkv.asBinder();
    }
}
