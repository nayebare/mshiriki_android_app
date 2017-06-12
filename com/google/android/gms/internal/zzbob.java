package com.google.android.gms.internal;

import com.google.android.gms.internal.zzboa.zza;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class zzbob {
    private final zzboe zzcfS;
    private final zzboy zzcfT;

    /* renamed from: com.google.android.gms.internal.zzbob.1 */
    class C12641 implements Comparator<zzbny> {
        static final /* synthetic */ boolean $assertionsDisabled;
        final /* synthetic */ zzbob zzcfU;

        static {
            $assertionsDisabled = !zzbob.class.desiredAssertionStatus();
        }

        C12641(zzbob com_google_android_gms_internal_zzbob) {
            this.zzcfU = com_google_android_gms_internal_zzbob;
        }

        public /* synthetic */ int compare(Object obj, Object obj2) {
            return zza((zzbny) obj, (zzbny) obj2);
        }

        public int zza(zzbny com_google_android_gms_internal_zzbny, zzbny com_google_android_gms_internal_zzbny2) {
            if ($assertionsDisabled || !(com_google_android_gms_internal_zzbny.zzYk() == null || com_google_android_gms_internal_zzbny2.zzYk() == null)) {
                return this.zzcfU.zzcfT.compare(new zzbpd(com_google_android_gms_internal_zzbny.zzYk(), com_google_android_gms_internal_zzbny.zzYi().zzUY()), new zzbpd(com_google_android_gms_internal_zzbny2.zzYk(), com_google_android_gms_internal_zzbny2.zzYi().zzUY()));
            }
            throw new AssertionError();
        }
    }

    public zzbob(zzboe com_google_android_gms_internal_zzboe) {
        this.zzcfS = com_google_android_gms_internal_zzboe;
        this.zzcfT = com_google_android_gms_internal_zzboe.zzYz();
    }

    private Comparator<zzbny> zzYq() {
        return new C12641(this);
    }

    private zzbnz zza(zzbny com_google_android_gms_internal_zzbny, zzbme com_google_android_gms_internal_zzbme, zzboz com_google_android_gms_internal_zzboz) {
        if (!(com_google_android_gms_internal_zzbny.zzYl().equals(zza.VALUE) || com_google_android_gms_internal_zzbny.zzYl().equals(zza.CHILD_REMOVED))) {
            com_google_android_gms_internal_zzbny = com_google_android_gms_internal_zzbny.zzg(com_google_android_gms_internal_zzboz.zza(com_google_android_gms_internal_zzbny.zzYk(), com_google_android_gms_internal_zzbny.zzYi().zzUY(), this.zzcfT));
        }
        return com_google_android_gms_internal_zzbme.zza(com_google_android_gms_internal_zzbny, this.zzcfS);
    }

    private void zza(List<zzbnz> list, zza com_google_android_gms_internal_zzboa_zza, List<zzbny> list2, List<zzbme> list3, zzboz com_google_android_gms_internal_zzboz) {
        List<zzbny> arrayList = new ArrayList();
        for (zzbny com_google_android_gms_internal_zzbny : list2) {
            if (com_google_android_gms_internal_zzbny.zzYl().equals(com_google_android_gms_internal_zzboa_zza)) {
                arrayList.add(com_google_android_gms_internal_zzbny);
            }
        }
        Collections.sort(arrayList, zzYq());
        for (zzbny com_google_android_gms_internal_zzbny2 : arrayList) {
            for (zzbme com_google_android_gms_internal_zzbme : list3) {
                if (com_google_android_gms_internal_zzbme.zza(com_google_android_gms_internal_zzboa_zza)) {
                    list.add(zza(com_google_android_gms_internal_zzbny2, com_google_android_gms_internal_zzbme, com_google_android_gms_internal_zzboz));
                }
            }
        }
    }

    public List<zzbnz> zza(List<zzbny> list, zzboz com_google_android_gms_internal_zzboz, List<zzbme> list2) {
        List<zzbnz> arrayList = new ArrayList();
        List arrayList2 = new ArrayList();
        for (zzbny com_google_android_gms_internal_zzbny : list) {
            if (com_google_android_gms_internal_zzbny.zzYl().equals(zza.CHILD_CHANGED) && this.zzcfT.zza(com_google_android_gms_internal_zzbny.zzYn().zzUY(), com_google_android_gms_internal_zzbny.zzYi().zzUY())) {
                arrayList2.add(zzbny.zzc(com_google_android_gms_internal_zzbny.zzYk(), com_google_android_gms_internal_zzbny.zzYi()));
            }
        }
        zza(arrayList, zza.CHILD_REMOVED, list, list2, com_google_android_gms_internal_zzboz);
        zza(arrayList, zza.CHILD_ADDED, list, list2, com_google_android_gms_internal_zzboz);
        zza(arrayList, zza.CHILD_MOVED, arrayList2, list2, com_google_android_gms_internal_zzboz);
        zza(arrayList, zza.CHILD_CHANGED, list, list2, com_google_android_gms_internal_zzboz);
        zza(arrayList, zza.VALUE, list, list2, com_google_android_gms_internal_zzboz);
        return arrayList;
    }
}
