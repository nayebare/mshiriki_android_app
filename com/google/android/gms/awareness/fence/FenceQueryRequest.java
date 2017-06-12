package com.google.android.gms.awareness.fence;

import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.zzac;
import com.google.android.gms.internal.zzaeg;
import java.util.Collection;

public abstract class FenceQueryRequest extends zza {
    protected FenceQueryRequest() {
    }

    public static FenceQueryRequest all() {
        return new zzaeg();
    }

    public static FenceQueryRequest forFences(Collection<String> collection) {
        zzac.zzw(collection);
        for (String zzdv : collection) {
            zzac.zzdv(zzdv);
        }
        return new zzaeg((Collection) collection);
    }

    public static FenceQueryRequest forFences(String... strArr) {
        zzac.zzw(strArr);
        for (String zzdv : strArr) {
            zzac.zzdv(zzdv);
        }
        return new zzaeg(strArr);
    }
}
