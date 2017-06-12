package com.google.android.gms.internal;

import com.google.android.gms.internal.zzja.zzc;
import java.util.concurrent.Future;

@zzmb
public final class zznb {
    private String zzOn;
    private String zzTh;
    private zzqc<zzne> zzTi;
    zzc zzTj;
    public final zzhx zzTk;
    public final zzhx zzTl;
    public final zzhx zzTm;
    private final Object zzrN;

    public zznb(String str, String str2) {
        this.zzrN = new Object();
        this.zzTi = new zzqc();
        this.zzTk = new 1(this);
        this.zzTl = new 2(this);
        this.zzTm = new 3(this);
        this.zzTh = str2;
        this.zzOn = str;
    }

    public void zzb(zzc com_google_android_gms_internal_zzja_zzc) {
        this.zzTj = com_google_android_gms_internal_zzja_zzc;
    }

    public zzc zzjg() {
        return this.zzTj;
    }

    public Future<zzne> zzjh() {
        return this.zzTi;
    }
}
