package com.google.android.gms.internal;

import com.google.firebase.database.DatabaseError;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class zzbof {
    static final /* synthetic */ boolean $assertionsDisabled;
    private final zzboe zzcfS;
    private final zzboh zzcgj;
    private zzbog zzcgk;
    private final List<zzbme> zzcgl;
    private final zzbob zzcgm;

    public static class zza {
        public final List<zzbnz> zzcgn;
        public final List<zzbny> zzcgo;

        public zza(List<zzbnz> list, List<zzbny> list2) {
            this.zzcgn = list;
            this.zzcgo = list2;
        }
    }

    static {
        $assertionsDisabled = !zzbof.class.desiredAssertionStatus();
    }

    public zzbof(zzboe com_google_android_gms_internal_zzboe, zzbog com_google_android_gms_internal_zzbog) {
        this.zzcfS = com_google_android_gms_internal_zzboe;
        zzboj com_google_android_gms_internal_zzboj = new zzboj(com_google_android_gms_internal_zzboe.zzYz());
        zzbol zzYF = com_google_android_gms_internal_zzboe.zzYG().zzYF();
        this.zzcgj = new zzboh(zzYF);
        zzbnw zzYM = com_google_android_gms_internal_zzbog.zzYM();
        zzbnw zzYK = com_google_android_gms_internal_zzbog.zzYK();
        zzboz zza = zzboz.zza(zzbox.zzZp(), com_google_android_gms_internal_zzboe.zzYz());
        zzboz zza2 = com_google_android_gms_internal_zzboj.zza(zza, zzYM.zzYi(), null);
        zza = zzYF.zza(zza, zzYK.zzYi(), null);
        this.zzcgk = new zzbog(new zzbnw(zza, zzYK.zzYg(), zzYF.zzYQ()), new zzbnw(zza2, zzYM.zzYg(), com_google_android_gms_internal_zzboj.zzYQ()));
        this.zzcgl = new ArrayList();
        this.zzcgm = new zzbob(com_google_android_gms_internal_zzboe);
    }

    private List<zzbnz> zza(List<zzbny> list, zzboz com_google_android_gms_internal_zzboz, zzbme com_google_android_gms_internal_zzbme) {
        List list2;
        if (com_google_android_gms_internal_zzbme == null) {
            list2 = this.zzcgl;
        } else {
            list2 = Arrays.asList(new zzbme[]{com_google_android_gms_internal_zzbme});
        }
        return this.zzcgm.zza((List) list, com_google_android_gms_internal_zzboz, list2);
    }

    public boolean isEmpty() {
        return this.zzcgl.isEmpty();
    }

    public zzboe zzYH() {
        return this.zzcfS;
    }

    public zzbpe zzYI() {
        return this.zzcgk.zzYM().zzUY();
    }

    public zzbpe zzYJ() {
        return this.zzcgk.zzYK().zzUY();
    }

    public List<zzboa> zza(zzbme com_google_android_gms_internal_zzbme, DatabaseError databaseError) {
        List<zzboa> list;
        if (databaseError != null) {
            List<zzboa> arrayList = new ArrayList();
            if ($assertionsDisabled || com_google_android_gms_internal_zzbme == null) {
                zzbmj zzVc = this.zzcfS.zzVc();
                for (zzbme com_google_android_gms_internal_zzbnx : this.zzcgl) {
                    zzbme com_google_android_gms_internal_zzbnx2;
                    arrayList.add(new zzbnx(com_google_android_gms_internal_zzbnx2, databaseError, zzVc));
                }
                list = arrayList;
            } else {
                throw new AssertionError("A cancel should cancel all event registrations");
            }
        }
        list = Collections.emptyList();
        if (com_google_android_gms_internal_zzbme != null) {
            int i = 0;
            int i2 = -1;
            while (i < this.zzcgl.size()) {
                com_google_android_gms_internal_zzbnx2 = (zzbme) this.zzcgl.get(i);
                if (com_google_android_gms_internal_zzbnx2.zzc(com_google_android_gms_internal_zzbme)) {
                    if (com_google_android_gms_internal_zzbnx2.zzXb()) {
                        break;
                    }
                    i2 = i;
                }
                i++;
            }
            i = i2;
            if (i != -1) {
                com_google_android_gms_internal_zzbnx2 = (zzbme) this.zzcgl.get(i);
                this.zzcgl.remove(i);
                com_google_android_gms_internal_zzbnx2.zzXa();
            }
        } else {
            for (zzbme com_google_android_gms_internal_zzbnx22 : this.zzcgl) {
                com_google_android_gms_internal_zzbnx22.zzXa();
            }
            this.zzcgl.clear();
        }
        return list;
    }

    public zza zzb(zzbng com_google_android_gms_internal_zzbng, zzbnb com_google_android_gms_internal_zzbnb, zzbpe com_google_android_gms_internal_zzbpe) {
        if (com_google_android_gms_internal_zzbng.zzXP() == com.google.android.gms.internal.zzbng.zza.Merge && com_google_android_gms_internal_zzbng.zzXO().zzXT() != null) {
            if (!$assertionsDisabled && this.zzcgk.zzYN() == null) {
                throw new AssertionError("We should always have a full cache before handling merges");
            } else if (!$assertionsDisabled && this.zzcgk.zzYL() == null) {
                throw new AssertionError("Missing event cache, even though we have a server cache");
            }
        }
        zzbog com_google_android_gms_internal_zzbog = this.zzcgk;
        com.google.android.gms.internal.zzboh.zza zza = this.zzcgj.zza(com_google_android_gms_internal_zzbog, com_google_android_gms_internal_zzbng, com_google_android_gms_internal_zzbnb, com_google_android_gms_internal_zzbpe);
        if ($assertionsDisabled || zza.zzcgk.zzYM().zzYg() || !com_google_android_gms_internal_zzbog.zzYM().zzYg()) {
            this.zzcgk = zza.zzcgk;
            return new zza(zza(zza.zzcgo, zza.zzcgk.zzYK().zzYi(), null), zza.zzcgo);
        }
        throw new AssertionError("Once a server snap is complete, it should never go back");
    }

    public void zzb(zzbme com_google_android_gms_internal_zzbme) {
        this.zzcgl.add(com_google_android_gms_internal_zzbme);
    }

    public List<zzbnz> zzl(zzbme com_google_android_gms_internal_zzbme) {
        zzbnw zzYK = this.zzcgk.zzYK();
        List arrayList = new ArrayList();
        for (zzbpd com_google_android_gms_internal_zzbpd : zzYK.zzUY()) {
            arrayList.add(zzbny.zzc(com_google_android_gms_internal_zzbpd.zzZz(), com_google_android_gms_internal_zzbpd.zzUY()));
        }
        if (zzYK.zzYg()) {
            arrayList.add(zzbny.zza(zzYK.zzYi()));
        }
        return zza(arrayList, zzYK.zzYi(), com_google_android_gms_internal_zzbme);
    }

    public zzbpe zzs(zzbmj com_google_android_gms_internal_zzbmj) {
        zzbpe zzYN = this.zzcgk.zzYN();
        return (zzYN == null || (!this.zzcfS.zzYD() && (com_google_android_gms_internal_zzbmj.isEmpty() || zzYN.zzm(com_google_android_gms_internal_zzbmj.zzXi()).isEmpty()))) ? null : zzYN.zzO(com_google_android_gms_internal_zzbmj);
    }
}
