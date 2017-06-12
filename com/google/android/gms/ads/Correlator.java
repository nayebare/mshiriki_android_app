package com.google.android.gms.ads;

import com.google.android.gms.internal.zzei;
import com.google.android.gms.internal.zzmb;

@zzmb
public final class Correlator {
    private zzei zzrK;

    public Correlator() {
        this.zzrK = new zzei();
    }

    public void reset() {
        this.zzrK.zzeQ();
    }

    public zzei zzbr() {
        return this.zzrK;
    }
}
