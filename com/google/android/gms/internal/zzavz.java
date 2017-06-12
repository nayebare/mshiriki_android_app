package com.google.android.gms.internal;

import android.content.Intent;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.zzac;
import com.google.android.gms.panorama.PanoramaApi.PanoramaResult;

class zzavz implements PanoramaResult {
    private final Status zzahq;
    private final Intent zzbzo;

    public zzavz(Status status, Intent intent) {
        this.zzahq = (Status) zzac.zzw(status);
        this.zzbzo = intent;
    }

    public Status getStatus() {
        return this.zzahq;
    }

    public Intent getViewerIntent() {
        return this.zzbzo;
    }
}
