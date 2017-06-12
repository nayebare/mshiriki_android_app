package com.google.android.gms.awareness;

import com.google.android.gms.common.api.Api;
import com.google.android.gms.internal.zzadu;

public final class Awareness {
    public static final Api<AwarenessOptions> API;
    public static final FenceApi FenceApi;
    public static final SnapshotApi SnapshotApi;

    static {
        FenceApi = zzadu.FenceApi;
        SnapshotApi = zzadu.SnapshotApi;
        API = zzadu.API;
    }

    private Awareness() {
    }
}
