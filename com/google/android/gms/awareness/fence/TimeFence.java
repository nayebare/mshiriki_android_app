package com.google.android.gms.awareness.fence;

import com.google.android.gms.internal.zzaee;
import com.google.android.gms.internal.zzaet;
import java.util.TimeZone;

public final class TimeFence {
    private TimeFence() {
    }

    public static AwarenessFence inDailyInterval(TimeZone timeZone, long j, long j2) {
        return zzaee.zza(zzaet.zza(2, timeZone, j, j2));
    }

    public static AwarenessFence inFridayInterval(TimeZone timeZone, long j, long j2) {
        return zzaee.zza(zzaet.zza(10, timeZone, j, j2));
    }

    public static AwarenessFence inInterval(long j, long j2) {
        return zzaee.zza(zzaet.zze(j, j2));
    }

    public static AwarenessFence inMondayInterval(TimeZone timeZone, long j, long j2) {
        return zzaee.zza(zzaet.zza(6, timeZone, j, j2));
    }

    public static AwarenessFence inSaturdayInterval(TimeZone timeZone, long j, long j2) {
        return zzaee.zza(zzaet.zza(11, timeZone, j, j2));
    }

    public static AwarenessFence inSundayInterval(TimeZone timeZone, long j, long j2) {
        return zzaee.zza(zzaet.zza(5, timeZone, j, j2));
    }

    public static AwarenessFence inThursdayInterval(TimeZone timeZone, long j, long j2) {
        return zzaee.zza(zzaet.zza(9, timeZone, j, j2));
    }

    public static AwarenessFence inTuesdayInterval(TimeZone timeZone, long j, long j2) {
        return zzaee.zza(zzaet.zza(7, timeZone, j, j2));
    }

    public static AwarenessFence inWednesdayInterval(TimeZone timeZone, long j, long j2) {
        return zzaee.zza(zzaet.zza(8, timeZone, j, j2));
    }
}
