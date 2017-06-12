package com.google.android.gms.internal;

import android.content.Context;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import java.util.concurrent.TimeUnit;

public final class zzbku {
    public static final zzapn<Boolean> zzbXh;
    public static final zzapn<String> zzbXi;
    public static final zzapn<Integer> zzbXj;
    public static final zzapn<Integer> zzbXk;
    public static final zzapn<Integer> zzbXl;
    public static final zzapn<Long> zzbXm;
    public static final zzapn<Long> zzbXn;
    public static final zzapn<Long> zzbXo;
    public static final zzapn<Integer> zzbXp;
    public static final zzapn<Integer> zzbXq;
    public static final zzapn<Long> zzbXr;
    public static final zzapn<Integer> zzbXs;
    public static final zzapn<Integer> zzbXt;
    public static final zzapn<Integer> zzbXu;

    static {
        zzbXh = zzapn.zzb(0, "crash:enabled", Boolean.valueOf(true));
        zzbXi = zzapn.zzc(0, "crash:gateway_url", "https://mobilecrashreporting.googleapis.com/v1/crashes:batchCreate?key=");
        zzbXj = zzapn.zzb(0, "crash:log_buffer_capacity", 100);
        zzbXk = zzapn.zzb(0, "crash:log_buffer_max_total_size", (int) AccessibilityNodeInfoCompat.ACTION_PASTE);
        zzbXl = zzapn.zzb(0, "crash:crash_backlog_capacity", 5);
        zzbXm = zzapn.zzb(0, "crash:crash_backlog_max_age", 604800000);
        zzbXn = zzapn.zzb(0, "crash:starting_backoff", TimeUnit.SECONDS.toMillis(1));
        zzbXo = zzapn.zzb(0, "crash:backoff_limit", TimeUnit.MINUTES.toMillis(60));
        zzbXp = zzapn.zzb(0, "crash:retry_num_attempts", 12);
        zzbXq = zzapn.zzb(0, "crash:batch_size", 5);
        zzbXr = zzapn.zzb(0, "crash:batch_throttle", TimeUnit.MINUTES.toMillis(5));
        zzbXs = zzapn.zzb(0, "crash:frame_depth", 60);
        zzbXt = zzapn.zzb(0, "crash:receiver_delay", 100);
        zzbXu = zzapn.zzb(0, "crash:thread_idle_timeout", 10);
    }

    public static final void initialize(Context context) {
        zzapr.zzCQ();
        zzapo.initialize(context);
    }
}
