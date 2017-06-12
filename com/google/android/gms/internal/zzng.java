package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.internal.zznf.zza;
import java.util.WeakHashMap;

@zzmb
public final class zzng {
    private WeakHashMap<Context, zza> zzUx;

    public zzng() {
        this.zzUx = new WeakHashMap();
    }

    public zznf zzv(Context context) {
        zza com_google_android_gms_internal_zzng_zza = (zza) this.zzUx.get(context);
        zznf zzjn = (com_google_android_gms_internal_zzng_zza == null || com_google_android_gms_internal_zzng_zza.hasExpired() || !((Boolean) zzfx.zzCP.get()).booleanValue()) ? new zza(context).zzjn() : new zza(context, com_google_android_gms_internal_zzng_zza.zzUz).zzjn();
        this.zzUx.put(context, new zza(this, zzjn));
        return zzjn;
    }
}
