package com.google.android.gms.awareness.fence;

import android.support.annotation.RequiresPermission;
import com.google.android.gms.internal.zzadx;
import com.google.android.gms.internal.zzaee;

public final class DetectedActivityFence {
    public static final int IN_VEHICLE = 0;
    public static final int ON_BICYCLE = 1;
    public static final int ON_FOOT = 2;
    public static final int RUNNING = 8;
    public static final int STILL = 3;
    public static final int TILTING = 5;
    public static final int UNKNOWN = 4;
    public static final int WALKING = 7;

    private DetectedActivityFence() {
    }

    @RequiresPermission("com.google.android.gms.permission.ACTIVITY_RECOGNITION")
    public static AwarenessFence during(int... iArr) {
        return zzaee.zza(zzadx.zzb(iArr));
    }

    @RequiresPermission("com.google.android.gms.permission.ACTIVITY_RECOGNITION")
    public static AwarenessFence starting(int... iArr) {
        return zzaee.zza(zzadx.zza(ON_FOOT, iArr));
    }

    @RequiresPermission("com.google.android.gms.permission.ACTIVITY_RECOGNITION")
    public static AwarenessFence stopping(int... iArr) {
        return zzaee.zza(zzadx.zza(STILL, iArr));
    }
}
