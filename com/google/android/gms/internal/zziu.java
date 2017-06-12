package com.google.android.gms.internal;

import android.support.annotation.Nullable;
import com.google.android.gms.common.internal.zzac;
import java.util.Iterator;
import java.util.LinkedList;

@zzmb
class zziu {
    private final LinkedList<zza> zzIC;
    private zzdy zzID;
    private final int zzIE;
    private boolean zzIF;
    private final String zztq;

    zziu(zzdy com_google_android_gms_internal_zzdy, String str, int i) {
        zzac.zzw(com_google_android_gms_internal_zzdy);
        zzac.zzw(str);
        this.zzIC = new LinkedList();
        this.zzID = com_google_android_gms_internal_zzdy;
        this.zztq = str;
        this.zzIE = i;
    }

    String getAdUnitId() {
        return this.zztq;
    }

    int getNetworkType() {
        return this.zzIE;
    }

    int size() {
        return this.zzIC.size();
    }

    void zza(zzip com_google_android_gms_internal_zzip, zzdy com_google_android_gms_internal_zzdy) {
        this.zzIC.add(new zza(this, com_google_android_gms_internal_zzip, com_google_android_gms_internal_zzdy));
    }

    void zzb(zzip com_google_android_gms_internal_zzip) {
        zza com_google_android_gms_internal_zziu_zza = new zza(this, com_google_android_gms_internal_zzip);
        this.zzIC.add(com_google_android_gms_internal_zziu_zza);
        com_google_android_gms_internal_zziu_zza.zzgq();
    }

    zzdy zzgl() {
        return this.zzID;
    }

    int zzgm() {
        Iterator it = this.zzIC.iterator();
        int i = 0;
        while (it.hasNext()) {
            i = ((zza) it.next()).zzIK ? i + 1 : i;
        }
        return i;
    }

    void zzgn() {
        Iterator it = this.zzIC.iterator();
        while (it.hasNext()) {
            ((zza) it.next()).zzgq();
        }
    }

    void zzgo() {
        this.zzIF = true;
    }

    boolean zzgp() {
        return this.zzIF;
    }

    zza zzp(@Nullable zzdy com_google_android_gms_internal_zzdy) {
        if (com_google_android_gms_internal_zzdy != null) {
            this.zzID = com_google_android_gms_internal_zzdy;
        }
        return (zza) this.zzIC.remove();
    }
}
