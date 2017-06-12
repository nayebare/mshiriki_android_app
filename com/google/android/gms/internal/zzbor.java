package com.google.android.gms.internal;

import com.google.android.gms.internal.zzbpe.zza;

public class zzbor extends zzbpb<zzbor> {
    private final boolean value;

    public zzbor(Boolean bool, zzbpe com_google_android_gms_internal_zzbpe) {
        super(com_google_android_gms_internal_zzbpe);
        this.value = bool.booleanValue();
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof zzbor)) {
            return false;
        }
        zzbor com_google_android_gms_internal_zzbor = (zzbor) obj;
        return this.value == com_google_android_gms_internal_zzbor.value && this.zzcgQ.equals(com_google_android_gms_internal_zzbor.zzcgQ);
    }

    public Object getValue() {
        return Boolean.valueOf(this.value);
    }

    public int hashCode() {
        return (this.value ? 1 : 0) + this.zzcgQ.hashCode();
    }

    protected zza zzYV() {
        return zza.Boolean;
    }

    protected int zza(zzbor com_google_android_gms_internal_zzbor) {
        return this.value == com_google_android_gms_internal_zzbor.value ? 0 : this.value ? 1 : -1;
    }

    public String zza(zza com_google_android_gms_internal_zzbpe_zza) {
        String valueOf = String.valueOf(zzb(com_google_android_gms_internal_zzbpe_zza));
        return new StringBuilder(String.valueOf(valueOf).length() + 13).append(valueOf).append("boolean:").append(this.value).toString();
    }

    public zzbor zzf(zzbpe com_google_android_gms_internal_zzbpe) {
        return new zzbor(Boolean.valueOf(this.value), com_google_android_gms_internal_zzbpe);
    }

    public /* synthetic */ zzbpe zzg(zzbpe com_google_android_gms_internal_zzbpe) {
        return zzf(com_google_android_gms_internal_zzbpe);
    }
}
