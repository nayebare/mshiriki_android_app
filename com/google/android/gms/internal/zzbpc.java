package com.google.android.gms.internal;

import com.google.android.gms.internal.zzbpe.zza;

public class zzbpc extends zzbpb<zzbpc> {
    private final long value;

    public zzbpc(Long l, zzbpe com_google_android_gms_internal_zzbpe) {
        super(com_google_android_gms_internal_zzbpe);
        this.value = l.longValue();
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof zzbpc)) {
            return false;
        }
        zzbpc com_google_android_gms_internal_zzbpc = (zzbpc) obj;
        return this.value == com_google_android_gms_internal_zzbpc.value && this.zzcgQ.equals(com_google_android_gms_internal_zzbpc.zzcgQ);
    }

    public Object getValue() {
        return Long.valueOf(this.value);
    }

    public int hashCode() {
        return ((int) (this.value ^ (this.value >>> 32))) + this.zzcgQ.hashCode();
    }

    protected zza zzYV() {
        return zza.Number;
    }

    protected int zza(zzbpc com_google_android_gms_internal_zzbpc) {
        return zzbqg.zzj(this.value, com_google_android_gms_internal_zzbpc.value);
    }

    public String zza(zza com_google_android_gms_internal_zzbpe_zza) {
        String valueOf = String.valueOf(String.valueOf(zzb(com_google_android_gms_internal_zzbpe_zza)).concat("number:"));
        String valueOf2 = String.valueOf(zzbqg.zzl((double) this.value));
        return valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf);
    }

    public /* synthetic */ zzbpe zzg(zzbpe com_google_android_gms_internal_zzbpe) {
        return zzp(com_google_android_gms_internal_zzbpe);
    }

    public zzbpc zzp(zzbpe com_google_android_gms_internal_zzbpe) {
        return new zzbpc(Long.valueOf(this.value), com_google_android_gms_internal_zzbpe);
    }
}
