package com.google.android.gms.fitness;

import android.content.Intent;
import android.os.Build.VERSION;
import com.google.android.gms.common.Scopes;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.ApiOptions.NoOptions;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.internal.zzanq;
import com.google.android.gms.internal.zzanr;
import com.google.android.gms.internal.zzans;
import com.google.android.gms.internal.zzant;
import com.google.android.gms.internal.zzanu;
import com.google.android.gms.internal.zzanv;
import com.google.android.gms.internal.zzanw;
import com.google.android.gms.internal.zzanx;
import com.google.android.gms.internal.zzaov;
import com.google.android.gms.internal.zzaow;
import com.google.android.gms.internal.zzaox;
import com.google.android.gms.internal.zzaoy;
import com.google.android.gms.internal.zzaoz;
import com.google.android.gms.internal.zzapa;
import com.google.android.gms.internal.zzapb;
import com.google.android.gms.internal.zzapc;
import com.google.android.gms.internal.zzapd;
import com.google.android.gms.internal.zzapf;
import java.util.concurrent.TimeUnit;

public class Fitness {
    public static final String ACTION_TRACK = "vnd.google.fitness.TRACK";
    public static final String ACTION_VIEW = "vnd.google.fitness.VIEW";
    public static final String ACTION_VIEW_GOAL = "vnd.google.fitness.VIEW_GOAL";
    @Deprecated
    public static final Void API;
    public static final Api<NoOptions> BLE_API;
    public static final BleApi BleApi;
    public static final Api<NoOptions> CONFIG_API;
    public static final ConfigApi ConfigApi;
    public static final String EXTRA_END_TIME = "vnd.google.fitness.end_time";
    public static final String EXTRA_START_TIME = "vnd.google.fitness.start_time";
    public static final Api<NoOptions> GOALS_API;
    public static final GoalsApi GoalsApi;
    public static final Api<NoOptions> HISTORY_API;
    public static final HistoryApi HistoryApi;
    public static final Api<NoOptions> RECORDING_API;
    public static final RecordingApi RecordingApi;
    public static final Scope SCOPE_ACTIVITY_READ;
    public static final Scope SCOPE_ACTIVITY_READ_WRITE;
    public static final Scope SCOPE_BODY_READ;
    public static final Scope SCOPE_BODY_READ_WRITE;
    public static final Scope SCOPE_LOCATION_READ;
    public static final Scope SCOPE_LOCATION_READ_WRITE;
    public static final Scope SCOPE_NUTRITION_READ;
    public static final Scope SCOPE_NUTRITION_READ_WRITE;
    public static final Api<NoOptions> SENSORS_API;
    public static final Api<NoOptions> SESSIONS_API;
    public static final SensorsApi SensorsApi;
    public static final SessionsApi SessionsApi;
    public static final Api<NoOptions> zzaJq;
    public static final zzaov zzaQG;

    static {
        API = null;
        SENSORS_API = zzanw.API;
        SensorsApi = new zzapc();
        RECORDING_API = zzanv.API;
        RecordingApi = new zzapb();
        SESSIONS_API = zzanx.API;
        SessionsApi = new zzapd();
        HISTORY_API = zzant.API;
        HistoryApi = new zzaoz();
        GOALS_API = zzans.API;
        GoalsApi = new zzaoy();
        CONFIG_API = zzanr.API;
        ConfigApi = new zzaox();
        BLE_API = zzanq.API;
        BleApi = zzBe();
        zzaJq = zzanu.API;
        zzaQG = new zzapa();
        SCOPE_ACTIVITY_READ = new Scope(Scopes.FITNESS_ACTIVITY_READ);
        SCOPE_ACTIVITY_READ_WRITE = new Scope(Scopes.FITNESS_ACTIVITY_READ_WRITE);
        SCOPE_LOCATION_READ = new Scope(Scopes.FITNESS_LOCATION_READ);
        SCOPE_LOCATION_READ_WRITE = new Scope(Scopes.FITNESS_LOCATION_READ_WRITE);
        SCOPE_BODY_READ = new Scope(Scopes.FITNESS_BODY_READ);
        SCOPE_BODY_READ_WRITE = new Scope(Scopes.FITNESS_BODY_READ_WRITE);
        SCOPE_NUTRITION_READ = new Scope(Scopes.FITNESS_NUTRITION_READ);
        SCOPE_NUTRITION_READ_WRITE = new Scope(Scopes.FITNESS_NUTRITION_READ_WRITE);
    }

    private Fitness() {
    }

    public static long getEndTime(Intent intent, TimeUnit timeUnit) {
        long longExtra = intent.getLongExtra(EXTRA_END_TIME, -1);
        return longExtra == -1 ? -1 : timeUnit.convert(longExtra, TimeUnit.MILLISECONDS);
    }

    public static long getStartTime(Intent intent, TimeUnit timeUnit) {
        long longExtra = intent.getLongExtra(EXTRA_START_TIME, -1);
        return longExtra == -1 ? -1 : timeUnit.convert(longExtra, TimeUnit.MILLISECONDS);
    }

    private static BleApi zzBe() {
        return VERSION.SDK_INT >= 18 ? new zzaow() : new zzapf();
    }
}
