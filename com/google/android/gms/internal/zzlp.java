package com.google.android.gms.internal;

import com.google.android.gms.internal.zzln.zza;

@zzmb
public class zzlp extends zzpd {
    private final zza zzPn;
    private final zzov.zza zzPo;
    private final zzmk zzPp;

    public zzlp(zzov.zza com_google_android_gms_internal_zzov_zza, zza com_google_android_gms_internal_zzln_zza) {
        this.zzPo = com_google_android_gms_internal_zzov_zza;
        this.zzPp = this.zzPo.zzVB;
        this.zzPn = com_google_android_gms_internal_zzln_zza;
    }

    private zzov zzQ(int i) {
        return new zzov(this.zzPo.zzSF.zzRd, null, null, i, null, null, this.zzPp.orientation, this.zzPp.zzKe, this.zzPo.zzSF.zzRg, false, null, null, null, null, null, this.zzPp.zzRL, this.zzPo.zzvj, this.zzPp.zzRJ, this.zzPo.zzVv, this.zzPp.zzRO, this.zzPp.zzRP, this.zzPo.zzVp, null, null, null, null, this.zzPo.zzVB.zzSc, this.zzPo.zzVB.zzSd, null, null, null);
    }

    public void onStop() {
    }

    public void zzcm() {
        zzpi.zzWR.post(new 1(this, zzQ(0)));
    }
}
