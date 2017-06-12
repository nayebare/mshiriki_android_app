package com.google.android.gms.awareness.fence;

import com.google.android.gms.internal.zzady;
import com.google.android.gms.internal.zzaee;

public final class HeadphoneFence {
    private HeadphoneFence() {
    }

    public static AwarenessFence during(int i) {
        return zzaee.zza(zzady.zzdv(i));
    }

    public static AwarenessFence pluggingIn() {
        return zzaee.zza(zzady.zzzj());
    }

    public static AwarenessFence unplugging() {
        return zzaee.zza(zzady.zzzk());
    }
}
