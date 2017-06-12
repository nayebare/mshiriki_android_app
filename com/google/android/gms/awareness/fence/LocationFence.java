package com.google.android.gms.awareness.fence;

import android.support.annotation.RequiresPermission;
import com.google.android.gms.internal.zzaee;
import com.google.android.gms.internal.zzaer;

public final class LocationFence {
    private LocationFence() {
    }

    @RequiresPermission("android.permission.ACCESS_FINE_LOCATION")
    public static AwarenessFence entering(double d, double d2, double d3) {
        return zzaee.zza(zzaer.zza((int) (d * 1.0E7d), (int) (1.0E7d * d2), d3));
    }

    @RequiresPermission("android.permission.ACCESS_FINE_LOCATION")
    public static AwarenessFence exiting(double d, double d2, double d3) {
        return zzaee.zza(zzaer.zzb((int) (d * 1.0E7d), (int) (1.0E7d * d2), d3));
    }

    @RequiresPermission("android.permission.ACCESS_FINE_LOCATION")
    public static AwarenessFence in(double d, double d2, double d3, long j) {
        return zzaee.zza(zzaer.zza((int) (d * 1.0E7d), (int) (1.0E7d * d2), d3, j));
    }
}
