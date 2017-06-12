package com.google.android.gms.awareness.fence;

import android.support.annotation.RequiresPermission;
import com.google.android.gms.awareness.state.BeaconState.TypeFilter;
import com.google.android.gms.internal.zzaea;
import com.google.android.gms.internal.zzaee;
import java.util.Collection;

public final class BeaconFence {
    private BeaconFence() {
    }

    @RequiresPermission("android.permission.ACCESS_FINE_LOCATION")
    public static AwarenessFence found(Collection<TypeFilter> collection) {
        return (collection == null || collection.isEmpty()) ? found(new TypeFilter[0]) : found((TypeFilter[]) collection.toArray(new TypeFilter[collection.size()]));
    }

    @RequiresPermission("android.permission.ACCESS_FINE_LOCATION")
    public static AwarenessFence found(TypeFilter... typeFilterArr) {
        return zzaee.zza(zzaea.zzb(typeFilterArr));
    }

    @RequiresPermission("android.permission.ACCESS_FINE_LOCATION")
    public static AwarenessFence lost(Collection<TypeFilter> collection) {
        return (collection == null || collection.isEmpty()) ? lost(new TypeFilter[0]) : lost((TypeFilter[]) collection.toArray(new TypeFilter[collection.size()]));
    }

    @RequiresPermission("android.permission.ACCESS_FINE_LOCATION")
    public static AwarenessFence lost(TypeFilter... typeFilterArr) {
        return zzaee.zza(zzaea.zzc(typeFilterArr));
    }

    @RequiresPermission("android.permission.ACCESS_FINE_LOCATION")
    public static AwarenessFence near(Collection<TypeFilter> collection) {
        return (collection == null || collection.isEmpty()) ? near(new TypeFilter[0]) : near((TypeFilter[]) collection.toArray(new TypeFilter[collection.size()]));
    }

    @RequiresPermission("android.permission.ACCESS_FINE_LOCATION")
    public static AwarenessFence near(TypeFilter... typeFilterArr) {
        return zzaee.zza(zzaea.zzd(typeFilterArr));
    }
}
