package com.google.android.gms.internal;

import com.google.android.gms.internal.zzbpe.zza;

public class zzbow extends zzbpb<zzbow> {
    static final /* synthetic */ boolean $assertionsDisabled;
    private final Double zzchg;

    static {
        $assertionsDisabled = !zzbow.class.desiredAssertionStatus();
    }

    public zzbow(Double d, zzbpe com_google_android_gms_internal_zzbpe) {
        super(com_google_android_gms_internal_zzbpe);
        this.zzchg = d;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof zzbow)) {
            return false;
        }
        zzbow com_google_android_gms_internal_zzbow = (zzbow) obj;
        return this.zzchg.equals(com_google_android_gms_internal_zzbow.zzchg) && this.zzcgQ.equals(com_google_android_gms_internal_zzbow.zzcgQ);
    }

    public Object getValue() {
        return this.zzchg;
    }

    public int hashCode() {
        return this.zzchg.hashCode() + this.zzcgQ.hashCode();
    }

    protected zza zzYV() {
        return zza.Number;
    }

    protected int zza(zzbow com_google_android_gms_internal_zzbow) {
        return this.zzchg.compareTo(com_google_android_gms_internal_zzbow.zzchg);
    }

    public String zza(zza com_google_android_gms_internal_zzbpe_zza) {
        String valueOf = String.valueOf(String.valueOf(zzb(com_google_android_gms_internal_zzbpe_zza)).concat("number:"));
        String valueOf2 = String.valueOf(zzbqg.zzl(this.zzchg.doubleValue()));
        return valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf);
    }

    public /* synthetic */ zzbpe zzg(zzbpe com_google_android_gms_internal_zzbpe) {
        return zzk(com_google_android_gms_internal_zzbpe);
    }

    public zzbow zzk(zzbpe com_google_android_gms_internal_zzbpe) {
        if ($assertionsDisabled || zzbpi.zzq(com_google_android_gms_internal_zzbpe)) {
            return new zzbow(this.zzchg, com_google_android_gms_internal_zzbpe);
        }
        throw new AssertionError();
    }
}
