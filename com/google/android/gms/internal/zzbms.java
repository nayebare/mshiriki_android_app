package com.google.android.gms.internal;

import com.google.android.gms.internal.zzbof.zza;
import com.google.firebase.database.DatabaseError;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class zzbms {
    static final /* synthetic */ boolean $assertionsDisabled;
    private final Map<zzbod, zzbof> zzcdA;
    private final zzbnn zzcdB;

    static {
        $assertionsDisabled = !zzbms.class.desiredAssertionStatus();
    }

    public zzbms(zzbnn com_google_android_gms_internal_zzbnn) {
        this.zzcdA = new HashMap();
        this.zzcdB = com_google_android_gms_internal_zzbnn;
    }

    private List<zzbnz> zza(zzbof com_google_android_gms_internal_zzbof, zzbng com_google_android_gms_internal_zzbng, zzbnb com_google_android_gms_internal_zzbnb, zzbpe com_google_android_gms_internal_zzbpe) {
        zza zzb = com_google_android_gms_internal_zzbof.zzb(com_google_android_gms_internal_zzbng, com_google_android_gms_internal_zzbnb, com_google_android_gms_internal_zzbpe);
        if (!com_google_android_gms_internal_zzbof.zzYH().zzYD()) {
            Set hashSet = new HashSet();
            Set hashSet2 = new HashSet();
            for (zzbny com_google_android_gms_internal_zzbny : zzb.zzcgo) {
                zzboa.zza zzYl = com_google_android_gms_internal_zzbny.zzYl();
                if (zzYl == zzboa.zza.CHILD_ADDED) {
                    hashSet2.add(com_google_android_gms_internal_zzbny.zzYk());
                } else if (zzYl == zzboa.zza.CHILD_REMOVED) {
                    hashSet.add(com_google_android_gms_internal_zzbny.zzYk());
                }
            }
            if (!(hashSet2.isEmpty() && hashSet.isEmpty())) {
                this.zzcdB.zza(com_google_android_gms_internal_zzbof.zzYH(), hashSet2, hashSet);
            }
        }
        return zzb.zzcgn;
    }

    public boolean isEmpty() {
        return this.zzcdA.isEmpty();
    }

    public List<zzbof> zzXw() {
        List<zzbof> arrayList = new ArrayList();
        for (Entry value : this.zzcdA.entrySet()) {
            zzbof com_google_android_gms_internal_zzbof = (zzbof) value.getValue();
            if (!com_google_android_gms_internal_zzbof.zzYH().zzYD()) {
                arrayList.add(com_google_android_gms_internal_zzbof);
            }
        }
        return arrayList;
    }

    public boolean zzXx() {
        return zzXy() != null;
    }

    public zzbof zzXy() {
        for (Entry value : this.zzcdA.entrySet()) {
            zzbof com_google_android_gms_internal_zzbof = (zzbof) value.getValue();
            if (com_google_android_gms_internal_zzbof.zzYH().zzYD()) {
                return com_google_android_gms_internal_zzbof;
            }
        }
        return null;
    }

    public zzbqd<List<zzboe>, List<zzboa>> zza(zzboe com_google_android_gms_internal_zzboe, zzbme com_google_android_gms_internal_zzbme, DatabaseError databaseError) {
        List arrayList = new ArrayList();
        List arrayList2 = new ArrayList();
        boolean zzXx = zzXx();
        zzbof com_google_android_gms_internal_zzbof;
        if (com_google_android_gms_internal_zzboe.isDefault()) {
            Iterator it = this.zzcdA.entrySet().iterator();
            while (it.hasNext()) {
                com_google_android_gms_internal_zzbof = (zzbof) ((Entry) it.next()).getValue();
                arrayList2.addAll(com_google_android_gms_internal_zzbof.zza(com_google_android_gms_internal_zzbme, databaseError));
                if (com_google_android_gms_internal_zzbof.isEmpty()) {
                    it.remove();
                    if (!com_google_android_gms_internal_zzbof.zzYH().zzYD()) {
                        arrayList.add(com_google_android_gms_internal_zzbof.zzYH());
                    }
                }
            }
        } else {
            com_google_android_gms_internal_zzbof = (zzbof) this.zzcdA.get(com_google_android_gms_internal_zzboe.zzYG());
            if (com_google_android_gms_internal_zzbof != null) {
                arrayList2.addAll(com_google_android_gms_internal_zzbof.zza(com_google_android_gms_internal_zzbme, databaseError));
                if (com_google_android_gms_internal_zzbof.isEmpty()) {
                    this.zzcdA.remove(com_google_android_gms_internal_zzboe.zzYG());
                    if (!com_google_android_gms_internal_zzbof.zzYH().zzYD()) {
                        arrayList.add(com_google_android_gms_internal_zzbof.zzYH());
                    }
                }
            }
        }
        if (zzXx && !zzXx()) {
            arrayList.add(zzboe.zzN(com_google_android_gms_internal_zzboe.zzVc()));
        }
        return new zzbqd(arrayList, arrayList2);
    }

    public List<zzbnz> zza(zzbme com_google_android_gms_internal_zzbme, zzbnb com_google_android_gms_internal_zzbnb, zzbnw com_google_android_gms_internal_zzbnw) {
        zzboe zzWD = com_google_android_gms_internal_zzbme.zzWD();
        zzbof com_google_android_gms_internal_zzbof = (zzbof) this.zzcdA.get(zzWD.zzYG());
        if (com_google_android_gms_internal_zzbof == null) {
            boolean z;
            zzbpe zzc = com_google_android_gms_internal_zzbnb.zzc(com_google_android_gms_internal_zzbnw.zzYg() ? com_google_android_gms_internal_zzbnw.zzUY() : null);
            if (zzc != null) {
                z = true;
            } else {
                zzc = com_google_android_gms_internal_zzbnb.zzd(com_google_android_gms_internal_zzbnw.zzUY());
                z = false;
            }
            zzbof com_google_android_gms_internal_zzbof2 = new zzbof(zzWD, new zzbog(new zzbnw(zzboz.zza(zzc, zzWD.zzYz()), z, false), com_google_android_gms_internal_zzbnw));
            if (!zzWD.zzYD()) {
                Set hashSet = new HashSet();
                for (zzbpd zzZz : com_google_android_gms_internal_zzbof2.zzYJ()) {
                    hashSet.add(zzZz.zzZz());
                }
                this.zzcdB.zza(zzWD, hashSet);
            }
            this.zzcdA.put(zzWD.zzYG(), com_google_android_gms_internal_zzbof2);
            com_google_android_gms_internal_zzbof = com_google_android_gms_internal_zzbof2;
        }
        com_google_android_gms_internal_zzbof.zzb(com_google_android_gms_internal_zzbme);
        return com_google_android_gms_internal_zzbof.zzl(com_google_android_gms_internal_zzbme);
    }

    public List<zzbnz> zza(zzbng com_google_android_gms_internal_zzbng, zzbnb com_google_android_gms_internal_zzbnb, zzbpe com_google_android_gms_internal_zzbpe) {
        zzbod zzXT = com_google_android_gms_internal_zzbng.zzXO().zzXT();
        if (zzXT != null) {
            zzbof com_google_android_gms_internal_zzbof = (zzbof) this.zzcdA.get(zzXT);
            if ($assertionsDisabled || com_google_android_gms_internal_zzbof != null) {
                return zza(com_google_android_gms_internal_zzbof, com_google_android_gms_internal_zzbng, com_google_android_gms_internal_zzbnb, com_google_android_gms_internal_zzbpe);
            }
            throw new AssertionError();
        }
        List<zzbnz> arrayList = new ArrayList();
        for (Entry value : this.zzcdA.entrySet()) {
            arrayList.addAll(zza((zzbof) value.getValue(), com_google_android_gms_internal_zzbng, com_google_android_gms_internal_zzbnb, com_google_android_gms_internal_zzbpe));
        }
        return arrayList;
    }

    public zzbof zzb(zzboe com_google_android_gms_internal_zzboe) {
        return com_google_android_gms_internal_zzboe.zzYD() ? zzXy() : (zzbof) this.zzcdA.get(com_google_android_gms_internal_zzboe.zzYG());
    }

    public boolean zzc(zzboe com_google_android_gms_internal_zzboe) {
        return zzb(com_google_android_gms_internal_zzboe) != null;
    }

    public zzbpe zzs(zzbmj com_google_android_gms_internal_zzbmj) {
        for (zzbof com_google_android_gms_internal_zzbof : this.zzcdA.values()) {
            if (com_google_android_gms_internal_zzbof.zzs(com_google_android_gms_internal_zzbmj) != null) {
                return com_google_android_gms_internal_zzbof.zzs(com_google_android_gms_internal_zzbmj);
            }
        }
        return null;
    }
}
