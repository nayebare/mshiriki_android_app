package com.google.android.gms.internal;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;

public class zzbpj {
    static final /* synthetic */ boolean $assertionsDisabled;
    private final zzbmj zzchA;
    private final zzbmj zzchB;
    private final zzbpe zzchC;

    static {
        $assertionsDisabled = !zzbpj.class.desiredAssertionStatus();
    }

    public zzbpj(zzblt com_google_android_gms_internal_zzblt) {
        zzbmj com_google_android_gms_internal_zzbmj = null;
        List zzWm = com_google_android_gms_internal_zzblt.zzWm();
        this.zzchA = zzWm != null ? new zzbmj(zzWm) : null;
        List zzWn = com_google_android_gms_internal_zzblt.zzWn();
        if (zzWn != null) {
            com_google_android_gms_internal_zzbmj = new zzbmj(zzWn);
        }
        this.zzchB = com_google_android_gms_internal_zzbmj;
        this.zzchC = zzbpf.zzar(com_google_android_gms_internal_zzblt.zzWo());
    }

    private zzbpe zzb(zzbmj com_google_android_gms_internal_zzbmj, zzbpe com_google_android_gms_internal_zzbpe, zzbpe com_google_android_gms_internal_zzbpe2) {
        Object obj = 1;
        int zzj = this.zzchA == null ? 1 : com_google_android_gms_internal_zzbmj.zzj(this.zzchA);
        int zzj2 = this.zzchB == null ? -1 : com_google_android_gms_internal_zzbmj.zzj(this.zzchB);
        Object obj2 = (this.zzchA == null || !com_google_android_gms_internal_zzbmj.zzi(this.zzchA)) ? null : 1;
        if (this.zzchB == null || !com_google_android_gms_internal_zzbmj.zzi(this.zzchB)) {
            obj = null;
        }
        if (zzj > 0 && zzj2 < 0 && r1 == null) {
            return com_google_android_gms_internal_zzbpe2;
        }
        if (zzj > 0 && r1 != null && com_google_android_gms_internal_zzbpe2.zzZd()) {
            return com_google_android_gms_internal_zzbpe2;
        }
        if (zzj <= 0 || zzj2 != 0) {
            if (obj2 != null || r1 != null) {
                Collection hashSet = new HashSet();
                for (zzbpd zzZz : com_google_android_gms_internal_zzbpe) {
                    hashSet.add(zzZz.zzZz());
                }
                for (zzbpd zzZz2 : com_google_android_gms_internal_zzbpe2) {
                    hashSet.add(zzZz2.zzZz());
                }
                List<zzbos> arrayList = new ArrayList(hashSet.size() + 1);
                arrayList.addAll(hashSet);
                if (!(com_google_android_gms_internal_zzbpe2.zzZe().isEmpty() && com_google_android_gms_internal_zzbpe.zzZe().isEmpty())) {
                    arrayList.add(zzbos.zzYY());
                }
                zzbpe com_google_android_gms_internal_zzbpe3 = com_google_android_gms_internal_zzbpe;
                for (zzbos com_google_android_gms_internal_zzbos : arrayList) {
                    zzbpe zzm = com_google_android_gms_internal_zzbpe.zzm(com_google_android_gms_internal_zzbos);
                    zzbpe zzb = zzb(com_google_android_gms_internal_zzbmj.zza(com_google_android_gms_internal_zzbos), com_google_android_gms_internal_zzbpe.zzm(com_google_android_gms_internal_zzbos), com_google_android_gms_internal_zzbpe2.zzm(com_google_android_gms_internal_zzbos));
                    com_google_android_gms_internal_zzbpe3 = zzb != zzm ? com_google_android_gms_internal_zzbpe3.zze(com_google_android_gms_internal_zzbos, zzb) : com_google_android_gms_internal_zzbpe3;
                }
                return com_google_android_gms_internal_zzbpe3;
            } else if ($assertionsDisabled || zzj2 > 0 || zzj <= 0) {
                return com_google_android_gms_internal_zzbpe;
            } else {
                throw new AssertionError();
            }
        } else if (!$assertionsDisabled && r1 == null) {
            throw new AssertionError();
        } else if ($assertionsDisabled || !com_google_android_gms_internal_zzbpe2.zzZd()) {
            return com_google_android_gms_internal_zzbpe.zzZd() ? zzbox.zzZp() : com_google_android_gms_internal_zzbpe;
        } else {
            throw new AssertionError();
        }
    }

    public String toString() {
        String valueOf = String.valueOf(this.zzchA);
        String valueOf2 = String.valueOf(this.zzchB);
        String valueOf3 = String.valueOf(this.zzchC);
        return new StringBuilder(((String.valueOf(valueOf).length() + 55) + String.valueOf(valueOf2).length()) + String.valueOf(valueOf3).length()).append("RangeMerge{optExclusiveStart=").append(valueOf).append(", optInclusiveEnd=").append(valueOf2).append(", snap=").append(valueOf3).append("}").toString();
    }

    public zzbpe zzr(zzbpe com_google_android_gms_internal_zzbpe) {
        return zzb(zzbmj.zzXf(), com_google_android_gms_internal_zzbpe, this.zzchC);
    }
}
