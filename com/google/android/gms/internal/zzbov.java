package com.google.android.gms.internal;

import com.google.android.gms.internal.zzbpe.zza;
import java.util.Map;

public class zzbov extends zzbpb<zzbov> {
    static final /* synthetic */ boolean $assertionsDisabled;
    private Map<Object, Object> zzchf;

    static {
        $assertionsDisabled = !zzbov.class.desiredAssertionStatus();
    }

    public zzbov(Map<Object, Object> map, zzbpe com_google_android_gms_internal_zzbpe) {
        super(com_google_android_gms_internal_zzbpe);
        this.zzchf = map;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof zzbov)) {
            return false;
        }
        zzbov com_google_android_gms_internal_zzbov = (zzbov) obj;
        return this.zzchf.equals(com_google_android_gms_internal_zzbov.zzchf) && this.zzcgQ.equals(com_google_android_gms_internal_zzbov.zzcgQ);
    }

    public Object getValue() {
        return this.zzchf;
    }

    public int hashCode() {
        return this.zzchf.hashCode() + this.zzcgQ.hashCode();
    }

    protected zza zzYV() {
        return zza.DeferredValue;
    }

    public String zza(zza com_google_android_gms_internal_zzbpe_zza) {
        String valueOf = String.valueOf(zzb(com_google_android_gms_internal_zzbpe_zza));
        String valueOf2 = String.valueOf(this.zzchf);
        return new StringBuilder((String.valueOf(valueOf).length() + 14) + String.valueOf(valueOf2).length()).append(valueOf).append("deferredValue:").append(valueOf2).toString();
    }

    public /* synthetic */ zzbpe zzg(zzbpe com_google_android_gms_internal_zzbpe) {
        return zzj(com_google_android_gms_internal_zzbpe);
    }

    public zzbov zzj(zzbpe com_google_android_gms_internal_zzbpe) {
        if ($assertionsDisabled || zzbpi.zzq(com_google_android_gms_internal_zzbpe)) {
            return new zzbov(this.zzchf, com_google_android_gms_internal_zzbpe);
        }
        throw new AssertionError();
    }
}
