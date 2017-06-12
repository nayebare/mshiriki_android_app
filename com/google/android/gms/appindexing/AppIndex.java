package com.google.android.gms.appindexing;

import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.ApiOptions.NoOptions;
import com.google.android.gms.internal.zzti;
import com.google.android.gms.internal.zzuf;

public final class AppIndex {
    public static final Api<NoOptions> API;
    public static final Api<NoOptions> APP_INDEX_API;
    public static final AppIndexApi AppIndexApi;

    static {
        API = zzti.zzafY;
        APP_INDEX_API = zzti.zzafY;
        AppIndexApi = new zzuf();
    }

    private AppIndex() {
    }
}
