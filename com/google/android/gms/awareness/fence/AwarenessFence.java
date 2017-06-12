package com.google.android.gms.awareness.fence;

import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.zzac;
import com.google.android.gms.internal.zzaee;
import java.util.ArrayList;
import java.util.Collection;

public abstract class AwarenessFence extends zza {
    protected AwarenessFence() {
    }

    public static AwarenessFence and(Collection<AwarenessFence> collection) {
        boolean z = (collection == null || collection.isEmpty()) ? false : true;
        zzac.zzas(z);
        return zzaee.zzg(zzd(collection));
    }

    public static AwarenessFence and(AwarenessFence... awarenessFenceArr) {
        boolean z = awarenessFenceArr != null && awarenessFenceArr.length > 0;
        zzac.zzas(z);
        return zzaee.zzg(zza(awarenessFenceArr));
    }

    public static AwarenessFence not(AwarenessFence awarenessFence) {
        zzac.zzw(awarenessFence);
        return zzaee.zza((zzaee) awarenessFence);
    }

    public static AwarenessFence or(Collection<AwarenessFence> collection) {
        boolean z = (collection == null || collection.isEmpty()) ? false : true;
        zzac.zzas(z);
        return zzaee.zzh(zzd(collection));
    }

    public static AwarenessFence or(AwarenessFence... awarenessFenceArr) {
        boolean z = awarenessFenceArr != null && awarenessFenceArr.length > 0;
        zzac.zzas(z);
        return zzaee.zzh(zza(awarenessFenceArr));
    }

    private static ArrayList<zzaee> zza(AwarenessFence[] awarenessFenceArr) {
        ArrayList<zzaee> arrayList = new ArrayList(awarenessFenceArr.length);
        for (AwarenessFence awarenessFence : awarenessFenceArr) {
            arrayList.add((zzaee) awarenessFence);
        }
        return arrayList;
    }

    private static ArrayList<zzaee> zzd(Collection<AwarenessFence> collection) {
        ArrayList<zzaee> arrayList = new ArrayList(collection.size());
        for (AwarenessFence awarenessFence : collection) {
            arrayList.add((zzaee) awarenessFence);
        }
        return arrayList;
    }
}
