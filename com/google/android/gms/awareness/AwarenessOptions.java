package com.google.android.gms.awareness;

import com.google.android.gms.common.api.Api.ApiOptions.Optional;
import com.google.android.gms.common.internal.zzac;

public class AwarenessOptions implements Optional {
    public static final int NO_UID = -1;
    private final String zzakP;
    private final int zzakQ;
    private final String zzakR;
    private final String zzakS;
    private final int zzakT;

    protected AwarenessOptions(String str, int i, String str2, String str3, int i2) {
        this.zzakP = str;
        this.zzakQ = i;
        this.zzakR = str2;
        this.zzakS = str3;
        this.zzakT = i2;
    }

    public static AwarenessOptions create1p(String str) {
        zzac.zzdv(str);
        return new AwarenessOptions(str, 1, null, null, NO_UID);
    }

    public String zzrf() {
        return this.zzakP;
    }

    public int zzrg() {
        return this.zzakQ;
    }

    public String zzrh() {
        return this.zzakR;
    }

    public String zzri() {
        return this.zzakS;
    }

    public int zzrj() {
        return this.zzakT;
    }
}
