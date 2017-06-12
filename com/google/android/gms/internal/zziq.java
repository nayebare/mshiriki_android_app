package com.google.android.gms.internal;

import android.os.Handler;
import com.google.android.gms.ads.internal.zzl;
import java.util.LinkedList;
import java.util.List;

@zzmb
class zziq {
    private final List<zza> zztf;

    zziq() {
        this.zztf = new LinkedList();
    }

    void zza(zzir com_google_android_gms_internal_zzir) {
        Handler handler = zzpi.zzWR;
        for (zza 7 : this.zztf) {
            handler.post(new 7(this, 7, com_google_android_gms_internal_zzir));
        }
        this.zztf.clear();
    }

    void zzc(zzl com_google_android_gms_ads_internal_zzl) {
        com_google_android_gms_ads_internal_zzl.zza((zzel) new 1(this));
        com_google_android_gms_ads_internal_zzl.zza((zzer) new 2(this));
        com_google_android_gms_ads_internal_zzl.zza((zzkz) new 3(this));
        com_google_android_gms_ads_internal_zzl.zza((zzgj) new 4(this));
        com_google_android_gms_ads_internal_zzl.zza((zzek) new 5(this));
        com_google_android_gms_ads_internal_zzl.zza((zznt) new 6(this));
    }
}
