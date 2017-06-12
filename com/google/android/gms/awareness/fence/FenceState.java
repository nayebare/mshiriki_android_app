package com.google.android.gms.awareness.fence;

import android.content.Intent;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.internal.zzaei;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public abstract class FenceState extends zza {
    public static final int FALSE = 1;
    public static final int TRUE = 2;
    public static final int UNKNOWN = 0;

    @Retention(RetentionPolicy.SOURCE)
    public @interface State {
    }

    public static FenceState extract(Intent intent) {
        return zzaei.extract(intent);
    }

    public abstract int getCurrentState();

    public abstract String getFenceKey();

    public abstract long getLastFenceUpdateTimeMillis();

    public abstract int getPreviousState();
}
